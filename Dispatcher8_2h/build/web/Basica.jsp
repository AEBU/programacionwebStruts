<%-- 
    Document   : Basica
    Created on : 01-jun-2017, 11:48:37
    Author     : Alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.*" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <html:form action="/seleccionar" method="get">
            <p>Numero 1: <html:text property="numero1"></html:text></p>
            <p>Numero 2: <html:text property="numero2"></html:text></p>
            
                
                <p>Operacion : </p>
                <html:select property="operacion">
                    <html:option value="sumar_numeros">+</html:option>    
                    <html:option value="restar_numeros">-</html:option>    
                    <html:option value="multiplicar_numeros">*</html:option>    
                    <html:option value="dividir_numeros">/</html:option>    
                </html:select>
                 
            <html:submit property="submit" value="Calcular" />
                 
        </html:form>
                    
                    <% if (request.getAttribute("resultado")!=null) {
                        int i=(Integer)request.getAttribute("resultado");
                    %>    
                    <p></p>
                    
                    Respuesta: <%= i%>
                    <%}%>
                    
                    <html:errors/>
    
    </body>
</html>
