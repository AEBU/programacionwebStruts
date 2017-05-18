# WebCorreccionStruts

### Estructura del Proyecto 
* WebInf
  - Struts config.xml
  - web.xml
  - inicio.jsp
  - consulta.jsp
* controladoresform
  - EstudiantesBean.java
  - SeleccionEstForm.java
* controladoresAction
  - EstudianteAction.java
* modelo
  - ConexionDB.java
  - GestionEstudiante.java

### Explicacion de cada uno de los componentes
* web.xml
- para este archivo comenzaremos por colocar el driver la cadena de conexión, el driver y la pagina de inicio 
    
```[xml]
   
   <welcome-file-list>
        <welcome-file>inicio.jsp</welcome-file>
   </welcome-file-list>
   
   <context-param>
        <param-name>driver</param-name>
        <param-value>org.postgresql.Driver</param-value>
    </context-param>
    
    <context-param>
        <param-name>cadena_conexion</param-name>
        <param-value>jdbc:postgresql://localhost:5432/pruebaweb1</param-value>
    </context-param>
```

**struts.config**
Definimos los beans  como alias hacia un archivo como seleccionEstudianteForm  de la clase Seleccion Estudiante Form
```[html]
 <form-beans>
    <form-bean name="seleccionEstForm" type="controladores_form.SeleccionEstForm"/>   
  </form-beans>
```
Tambien en action mappings que usaremos para redireccionar el path de /inicio  y colocaremos la clase que se ursara para redireccionar es decir en pocas palabras le damos un **alias** categoriaForm va a capturar todo lo que esta en _inicio t va a ser procesado por  EstudianteAction y la respuesta va a ir a consulta.jsp
```[html]
    <action-mappings>
        <action name="seleccionEstForm" path="/inicio" scope="request" type="controladores_action.EstudianteAction">
           <forward name="consultajsp" path="/consulta.jsp"/> 
        </action>
    </action-mappings>
```
**inicio.jsp**
Este es el archivo de bienvenida que usaremos para que se ingrese el valor para acceder a los datos del estudiante. Debemos tener en cuenta que estamos usando /inicio que estará siendo usado por la configuracion de struts y usaremos las propiedades que hemos definido dentro de seleccion form y numCedula definidas en controladores Action

```[html]
        <html:form action="/inicio" method="post">
            <p>Cedula:</p>

            <html:text name="seleccionEstForm" property="numCedula" size="20"></html:text>
                <!--Debemos tener en cuenta que esta propiedad de numCedula es el getY set que tenemos-->

            <html:submit value="Mostrar Listado de Estudiantes" />
        </html:form>
```

**consulta.jsp** 
En esta vista visualizaremos el resultado emitido por la base de datos de acuerdo a lo que le mandamos a consultar haciendo referencia a el valor que nos mando el controlador como estudiantes
```[html]
<% ArrayList<EstudiantesBean> estudiantes = (ArrayList)request.getAttribute("estudiantes"); %>
       <h1> Listado de Estudiantes </h1>

         <table border="1" width="60%">
            <th> est_cedula </th>
            <th> est_apellido    </th>
            <th> est_nombre  </th>
            <th> mat_codigo     </th>
            <th> mat_nombre        </th>
            <th> mat_creditos    </th>
            
            <% for (int i = 0; i<estudiantes.size(); i++ ){
                EstudiantesBean est = estudiantes.get(i); %>
                
                <tr>
                    <td><%=est.getEst_cedula()%></td>
                    <td><%=est.getEst_apellido()%></td>
                    <td><%=est.getEst_nombre()%></td>
                    <td><%=est.getMat_codigo()%></td>
                    <td><%=est.getMat_nombre()%></td>
                    <td><%=est.getMat_creditos()%></td>
                    
                </tr>
          <%  } %>
            
        </table>
```
En el paquete modelose colocan las clases que pertenecen a la lógica del negocio
* Gestion Estudiate
Es el que hace la consulta con la base de datos, haremos un constructor que reciba el enlace de conexion y la cadena para luego realizar consulta_estudiante
```[java]
ArrayList<EstudiantesBean> conjuntoRegistro = new ArrayList<EstudiantesBean>();
        try {
            Connection cn = con.getConexion();
            Statement st = cn.createStatement();
            String cadenaSQL = "select es.*,ma.* from estudiante_materia esma, materia ma, estudiante es where es.est_cedula=esma.est_cedula and ma.mat_codigo=esma.mat_codigo and es.est_cedula like '" + numCedula + "%'";
            System.out.println(cadenaSQL+" Este es la cadena de creacion");
            ResultSet rs = st.executeQuery(cadenaSQL);
            while (rs.next()) {
                EstudiantesBean estu = new EstudiantesBean();

                estu.setEst_cedula(rs.getString("est_cedula"));
                estu.setEst_apellido(rs.getString("est_apellido"));
                estu.setEst_nombre(rs.getString("est_nombre"));

                estu.setMat_codigo(rs.getString("mat_codigo"));
                estu.setMat_nombre(rs.getString("mat_nombre"));
                estu.setMat_creditos(rs.getString("mat_creditos"));

                conjuntoRegistro.add(estu);
            }
            con.cierraConexion(cn);
```

En el paquete controladores_action se colocan las clases que procesan las peticiones del controlador
* EstudianteAction.java
La clase EstudianteAction mediante el método execute procesa la ejecucion hacia el archivo "GestionProductos.java" (paquete modelo) y luego redirecciona su respuesta al archivo "cosulta.jsp" (archivo de vista)
```[java]
        //obtiene el codigo (texto) seleccionado en seleccionEstForm 
        SeleccionEstForm pb = (SeleccionEstForm) form;
        GestionEstudiante gp = new GestionEstudiante(driver, cadena_conexion);//
        //Consulta todos los estudiantes que pertenecen a el input seleccionado en la claseGestionEstudiantes 
        //y luego copia todos los resultados a el atributo estudiantes
        request.setAttribute("estudiantes", gp.consulta_categoria(pb.getNumCedula()));
        return mapping.findForward("consultajsp");
```
En el paquete controladores_form se colocan las clases que capturan los datos de usuario
**seleccionForm** La clase seleccionEstForm caputra el numCedula
```[java]
 private String  numCedula;

    public String getNumCedula() {
        return numCedula;
    }

    public void setNumCedula(String numCedula) {
        this.numCedula = numCedula;
    }
```
>Nota: tener en cuenta que este el property que le debemos dar en el input para que funcione, si no no se direcciona


