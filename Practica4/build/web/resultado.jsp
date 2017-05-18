<%-- 
    Document   : resultado
    Created on : 02-may-2017, 23:18:52
    Author     : Alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "modelo.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Página de resultados</title>
    </head>
    <body>
        <% int i = (Integer)request.getAttribute("respuesta"); %>
        La suma es : <%= i%>
    </body>
</html>