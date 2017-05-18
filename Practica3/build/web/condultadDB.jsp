<%-- 
    Document   : condultadDB
    Created on : 19-abr-2017, 9:52:07
    Author     : Alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Servlets y OperacionSql</title>
    </head>
    <body>

        <form method="GET">
            <p>Cedula:<input type="text" name="numCedula" size="20"/></p>
            <input type="submit" value="Consultar" name="btnIngresar">
        </form>

        <%
            if (request.getParameter("numCedula") != null && request.getParameter("numCedula") != "") {
        %>    
        <jsp:useBean id="obj" class="practica3.Clase_Persona2" />
        <jsp:setProperty name="obj" property="*" />
        <%
            obj.procedimiento_conexion();
            obj.procedimiento_consultar();

        %>

        <%=obj.procedimiento_mostrar_consulta()%>
        <%}%>
    </body>
</html>
