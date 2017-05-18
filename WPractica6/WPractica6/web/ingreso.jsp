<%-- 
    Document   : ingreso
    Created on : 03/05/2017, 20:26:54
    Author     : GABRIELA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Bienvenida</title>
    </head>
    <body>
        <center>
        <html:form action="/ingresar" method="POST">
            <html:text property="bandera" value="Bienvenido al Sistema de Consultas" size="35"></html:text>
        
            <html:submit property="submit" value="Ingresar al sistema"></html:submit>            
        </html:form>
    </center>
    </body>
</html:html>
