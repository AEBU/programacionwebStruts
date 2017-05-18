<%-- 
    Document   : webIngreso
    Created on : 02-may-2017, 23:20:40
    Author     : Alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "modelo.*" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C/DTD HTML 4.01 Transactional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Formulario de ingreso de datos</title>
    </head>
    <body>
        <h1>Formulario ingreso de datos</h1>
        <html:form action="/validar" method="POST"> <!--validar es el aliaas y el nombre de la peticion-->
            <p>Número 1: <html:text property="numero1" value=""></html:text></p>
            <p>Número 2: <html:text property="numero2" value=""></html:text></p>
            <html:submit property="submit" value="Sumar"></html:submit>
        </html:form>
    </body>
</html>
