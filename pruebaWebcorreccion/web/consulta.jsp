<%-- 
    Document   : consulta
    Created on : 17-may-2017, 9:41:08
    Author     : Alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ page import="java.util.*, controladores_form.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta Solicitada...</title>
    </head>
    <body>
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

    </body>
</html>
