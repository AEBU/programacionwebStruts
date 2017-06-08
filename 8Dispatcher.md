# Clase que usa DispatchAction para varias peticiones
*Práctica8_2h*
### Estructura del Proyecto
```
WebInf
  |-- Struts config.xml
  |-- web.xml
  |-- basica.jsp
  |-- error.jsp
  |-- login.jsp
  |-- registro.jsp
servlets_form
  |-- Numeros.java
controladoresAction
  |-- OperacionesAction.java
modelo
  |-- OperacionesBasicas2.java
excepciones
  |-- DivisionCeroExcepcion.java
strutspackage
  |-- ApplicationResource.properties
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
  TEnemos que Numeros va a cpaturar todo lo que esta en /seleccionar y sera procesado por OperacionesAction mandando un parametro
  llamado operación, luego veresmo qi tiene un error será capturado por ** DivisionCeroExcepcion ** y por el error se quedara en Basica.jsp 
  
```[xml]
    <action name="Numeros" path="/seleccionar" scope="request" type="controladores_action.OperacionesAction" parameter="operacion">
            <forward name="Basica" path="/Basica.jsp"/>
            <exception type="excepciones.DivisionCeroExcepcion" key="error.division" path="/Basica.jsp"/>
     </action>
```

1. *servlets_form*
  > Numeros
    Esta clase es un servlet que patura los datos de entrada del usuario 
```[java]
   public class Numeros extends ActionForm{
    private int numero1;
    private int numero2;
    private String operacion;

    public int getNumero1() {
        return numero1;
    }
```
2. *controladores_action*
  La clase DispatchAction es una subcalse de Action que permite definir en la misma clase diferentes métodos para tratar
  un grupo de peticiones similares, evitando tener que crear una clase para la gestión de cada acción. En el presente ejemplo, en vez 
  de implementar **cuatro sublcases de Action para su tratamiento**, crearemos una única subclase de *DispatchAction* con cuatro métodos que asociaremos
  a cada una de estas peticiones.
  Será a través de un parámetro enviado a la petición como el método execute() podrá determinar cuál de los métodos 
  definidos en la clase para la gestión de las acciones ha de ser ejectuado. El nombre de este parámetro será elegio por el programador 
  y su valor en cada petición tendrá que coincidir exactamente con el nombre del método que se quiera ejecutar
  > OperacionesAction
```[java]
    public class OperacionesAction extends DispatchAction {

    public ActionForward sumar_numeros(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        Numeros n = (Numeros) form;
        OperacionesBasicas2 op = new OperacionesBasicas2();
        request.setAttribute("resultado", op.suma(n));
        return mapping.findForward("Basica");
    }

    public ActionForward restar_numeros(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        Numeros n = (Numeros) form;
        OperacionesBasicas2 op = new OperacionesBasicas2();
        request.setAttribute("resultado", op.resta(n));
        return mapping.findForward("Basica");
    }

```
  
3. *modelo*
  > OperacionesBasicas2
    En esta clase se encapsula la lógica del negocio representada por las cuatro operaciones básicas
```[java]
   public class OperacionesBasicas2 {
    
    public int suma(Numeros n){
        return (n.getNumero1()+n.getNumero2());
    }
    public int resta(Numeros n){
        return (n.getNumero1()-n.getNumero2());
    }
    public int multiplicacion(Numeros n){
        return (n.getNumero1()*n.getNumero2());
    }
    public int division(Numeros n){
        return (n.getNumero1()/n.getNumero2());
    }
```
4. * Vistas Jsp*
  > Basica.jsp
  vamos a obtener el atributo resultado pasado a esta vista y si lo obtenemos puest lo mostramos como resultado
```[java]
    <% if (request.getAttribute("resultado")!=null) {
                        int i=(Integer)request.getAttribute("resultado");
                    %>    
                    <p></p>
```

5. * Excepciones *
  > DivisionCeroException 
    es una execpcion que extiende de la calse Exception y es para validar Division Para Cero
```[java]
public class DivisionCeroExcepcion extends Exception{
    
}

```

6. *Resources*
  > ApplicationResource.properties
```[xml]
# -- division por cero --
error.division= Error division para cero
```
  
  
