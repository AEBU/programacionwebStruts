/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

import java.sql.*;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 *
 * @author Alexis
 */
public class Clase_Persona2 implements HttpSessionBindingListener{
    
    private String numCedula;
    private Connection var_conexion=null;
    private Statement stmt= null;
    private ResultSet rset= null;
    private StringBuffer tabla_resultados;

    public Clase_Persona2() {
    }

    public String getNumCedula() {
        return numCedula;
    }

    public synchronized void setNumCedula(String numCedula) {
        this.numCedula = numCedula;
    }

    
   
    @Override
    public synchronized void valueBound(HttpSessionBindingEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized void valueUnbound(HttpSessionBindingEvent event) {
       try{
           if (var_conexion!=null) {
               var_conexion=null;
           }
       }catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void procedimiento_conexion() {
        try {
            Class.forName("org.postgresql.Driver");
            DriverManager.registerDriver(new org.postgresql.Driver());
            var_conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practica3", "postgres", "junior200");

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public void procedimiento_consultar() {

        try {
            stmt = var_conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            //String query = "select * from persona where cedula like '"+numCedula+"%'";
            String query = "select * from consulta_cedula ('"+numCedula+"')";
            
            
            System.out.println(query);
            
            rset=stmt.executeQuery(query);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public String procedimiento_mostrar_consulta(){
        StringBuffer tabla_resultados=new StringBuffer();
        try {
            tabla_resultados.append("<table border=1 cellPading=1 cellSpacing=1 width=75>");
            tabla_resultados.append("<tr> <td> Cedula </td>");
            tabla_resultados.append("   <td> Cedula </td>");
            tabla_resultados.append("   <td> Nombre </td>");
            tabla_resultados.append("   <td> apellido </td>");
            tabla_resultados.append("   <td> Sexo </td>");
            tabla_resultados.append("   </tr>");
            
            
            while (rset.next()) {
                tabla_resultados.append("<table border=1 cellPading=1 cellSpacing=1 width=75>");
            tabla_resultados.append("<tr>");
            tabla_resultados.append("<td>"+rset.getString(1) + " </td>");
            tabla_resultados.append("<td>"+rset.getString(2) + " </td>");
            tabla_resultados.append("<td>"+rset.getString(3) + " </td>");
            tabla_resultados.append("<td>"+rset.getString(4) + " </td>");
            tabla_resultados.append("</tr>");
            }
            
            tabla_resultados.append("</table>");
        } catch (Exception e) {
            System.out.println(e);
        }
        return tabla_resultados.toString();
    }
    
}
