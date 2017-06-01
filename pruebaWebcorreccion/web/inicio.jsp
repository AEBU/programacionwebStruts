<%-- 
    Document   : inicio
    Created on : 17-may-2017, 9:39:23
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
        <title>Inicio</title>
    </head>
    <body>
        <p> Ingreso de la cedula para acceder a los datos de esta persona</p>       
        

        <html:form action="/inicio" method="post">
            <p>Cedula:</p>

            <html:text name="seleccionEstForm" property="numCedula" size="20"></html:text>
                <!--Debemos tener en cuenta que esta propiedad de numCedula es el getY set que tenemos-->

            <html:submit value="Mostrar Listado de Estudiantes" />
        </html:form>
    </body>
</html>
