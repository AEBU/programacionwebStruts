<%-- 
    Document   : categoria
    Created on : 03-may-2017, 9:36:46
    Author     : Alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ page import="java.util.*, controladores_form.* " %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de codigo de las categorias</title>
    </head>
    <body>
        <html:form action="/listado" method="post">
            <html:select property="codigo_cat">
                <html:options name="categoriaForm" property="codigocategoria"/>
            </html:select>
            
            <html:submit value="Mostra Listado de productos"/>
        </html:form>
    </body>
</html>
