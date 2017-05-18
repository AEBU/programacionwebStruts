<%-- 
    Document   : categoria
    Created on : 03/05/2017, 20:27:22
    Author     : GABRIELA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ page import="java.util.*, controladores_form.*" %>
<!DOCTYPE html>
<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de codigos categoria</h1>
        <html:form action="/listado" method="post">
            <html:select property="codigo_cat">
                <html:options name="categoriaForm" property="codigocategoria"/>
            </html:select>
            <html:submit value="Mostrar Listado de prodcutos" />
        </html:form>
    </body>
</html:html>
