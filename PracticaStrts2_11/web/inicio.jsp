<%-- 
    Document   : inicio.jsp
    Created on : 28-jun-2017, 9:58:36
    Author     : Alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <form action="paquete1/saludo.action" method="post">
            
            <input type="submit" value="Para entrar a struts 2 Pulsa aqui"/>
            
        </form>
    </body>
</html>
