# Clase que Registra y Autentica en la base de datos a un cliente 
*Práctica7_2h*

### Estructura del Proyecto
```
WebInf
  |-- Struts config.xml
  |-- web.xml
  |-- bienvenida.jsp
  |-- error.jsp
  |-- login.jsp
  |-- registro.jsp
controladoresform
  |-- RegistroForm.java
  |-- ValidacionForm.java
controladoresAction
  |-- RegistrarAction.java
  |-- ValidarAction.java
modelo
  |-- ConexionDB.java
  |-- GestionClientes.java
```


> Explicacion de cada uno de los componentes (PASOS)

1. *struts.config*.- 
  Tenemos que colocar nuestros beans y urls a definir para conseguir el trabajo que necesito 
  En este caso estamos asignando un valor logico a la cada clase (Bean) de controladores_form, es decir a la clase  **RegistroForm** le asiganmos el nombre mbre llogico  *RegistroForm*
```[xml]
 <form-beans>
    <form-beans>
        <form-bean name="RegistroForm" type="controladores_form.RegistroForm" />
        <form-bean name="ValidacionForm" type="controladores_form.ValidacionForm" />
    </form-beans>
  </form-beans>
```
  Tenemos otra asignacion que es llamada como los **global forwards** que son las que van a ser accedidads desde cualquier path y para cualquier peticion
  La lógica de esta parte es que podemos asignar un nombre a la vista tal .
```[xml]
    <global-forwards>
        <forward name="welcome"  path="/Welcome.do"/>
        <forward name="login" path="/login.jsp" />
        <forward name="pararegistro" path="/registro.jsp" />
    </global-forwards>
```
  Por ultimo tenemos los **action-mappings** los cuales me diran cual es que captura y cual procesa los datos de un determinado path*(formulario)*
'Ejemplo'
  Como ejemplo podemos tomar a **path /validar** el cual dice:  que **ValidacionForm** va a capturar todo lo que esta en **/validar** y esto sera procesado por **ValidarAction** y su respuesta sera mandada a **bienvenida** *login Correcto* o a **error** *LoginIncorrecto* segun sea el caso 
```[xml]
    <action-mappings>
        <action path="/Welcome" forward="/welcomeStruts.jsp"/>
        
        <action name="ValidacionForm" path="/validar" scope="request" type="controladores_action.ValidarAction">
            <forward name="bienvenida" path="/bienvenida.jsp" />
            <forward name="error" path="/error.jsp" />
        </action>
        
        <action name="RegistroForm" path="/registrar" scope="request" type="controladores_action.RegistrarAction">
            <forward name="login" path="/login.jsp" />
        </action>
        
            
    </action-mappings>
```
**NOTA** Tenemos que tener en cuenta que este tambien tiene un forward, pero este solo funciona si se cumple dicha accion es decir esta directamente relacionado al path /


2. *controladores_form*
  En este paquete se colocan las clases qeu capturan los datos del usuario 
    > Ejemplo1: la clase *ValidacionForm* captura y encapsula los datos provenientes del formulario de ingreso *loging.jsp*
  ```[java]
    public class ValidacionForm  extends ActionForm{
    //datos del miembro
    
    private String usuario;
    private String password;
```
  > Ejemplo2: la clase *RegistroForm* captura y encapsula los datos provenientes del formulario de ingreso *registro.jsp*
```[java]
    public class RegistroForm  extends ActionForm{
    //datos del miembro
    private String nombre;
    private String apellidos;
    private String usuario;
    private String password;
    private String email;
```
2. *controladores_action*
  En este paquete se colocan las clases que procesa las peticion que llegan al controlador
  > Ejemplo1: la clase *ValiarAction* mediante el metodo execute() procesa la ejecucion hacia el archivo *GestionClientes.java* (paquete modelo) y luego redirecciona al archivo *bienvenida.jsp* o al archivo *error.jsp*
```[java]
    public class ValidarAction extends Action {

    @Override
    //obtenemos los datos de la conexion definida en web.xml
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String driver = this.getServlet().getServletContext().getInitParameter("driver");
        String cadenacon = this.getServlet().getServletContext().getInitParameter("cadenacon");//este es el nombre de web.xml
        GestionClientes gc = new GestionClientes(driver, cadenacon);
    //con el Objeto Gestion Cliente Mediante la función validar del obj GestCliente, estoy encapsulando un objeto del tipo validacion Form
    //Invocamos al metodo validar() del modelo para saber si el usuario esta o no esta registrado
        ValidacionForm vf = (ValidacionForm) form;
        if (gc.validar(vf)) {
            return mapping.findForward("bienvenida");
        } else {
            return mapping.findForward("error");
        }
    }

}
```
  > Ejemplo2: la clase *RegistrarAction* mediante el metodo execute procesa la ejecucion hacia el archivo **GestionClientes.java**(paquete modelo) y luego redirecciona la resupuesta al archivo *login.jsp* (archivo de vista) 
```[java]
   public class RegistrarAction extends Action{

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String driver=this.getServlet().getServletContext().getInitParameter("driver");
        String cadenacon=this.getServlet().getServletContext().getInitParameter("cadenacon");
        
        GestionClientes gc=new GestionClientes(driver, cadenacon);
        RegistroForm rf=(RegistroForm) form;
        //con el objeto GC(GestionCliente) en su función Registrar
        //encapsula registroForm
        gc.registrar(rf);
        return mapping.findForward("login");
    }

```

3. *modelo*
  En este paquete modelo se colocan todas las clases que encapsula la logica del negocio de la aplicacion, incluyendo el acceso a los datos y su manipulacion 
  > Ejemplo1: la clase *GestionCliente* tiene dos procedimientos **validar()** y **registar()**
  > validar() valida si el usaurio esta en nuestra base de datos
```[java]
 public boolean validar (ValidacionForm vf){
        boolean estado=false;
        try{
            Connection cn=con.getConexion();
            String query="Select * from Registro ";
            query+="where password= '"+vf.getPassword();
            query+="' and usuario = '"+vf.getUsuario()+"'";
            System.out.println(query+"      Este es nuevo query");
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(query);
            estado=rs.next();
            con.cierraConexion(cn);
        }catch(Exception e){
            e.printStackTrace();
            
        }finally{
            return estado;
        }
    }
```
> registrar() registra al nuevo cliente
```[java]
 public void registrar(RegistroForm rf){
        String query="insert into Registro ";
        query+="values ( '" +rf.getNombre()+"','"+rf.getApellidos()+"','"+rf.getUsuario()+"','"+rf.getPassword()+"','"+rf.getEmail()+"')";
        System.out.println(query);
        try{
            int i;
            Connection cn=con.getConexion();
            Statement st=cn.createStatement();
            i=st.executeUpdate(query);
            st.close();
            con.cierraConexion(cn);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
```
> Datos o ConexionDB1: permite realizar la apertura y cierre de una conexion a una base de datos
  > Obtiene conexion
```[java]
 public Connection getConexion(){
        Connection cn=null;
        try{
            Class.forName(driver).newInstance();
            cn=DriverManager.getConnection(cadenacon,"postgres","junior200");
        }catch(Exception er){
            er.printStackTrace();
        }
        return cn;
    }
```
  > Cierra conexion conexion
```[java]
public void cierraConexion(Connection cn){
        try{
            if (cn!=null && !cn.isClosed()){
                cn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
```    
4. *Adicionales*
  Cuando una clase extiende de Action se puede atender solo una petición , es decir /registrar es capturado solo por una clase que extienda de Action, en cambio con Dispatcher podemos atender varias peticiones en una sola Clase
