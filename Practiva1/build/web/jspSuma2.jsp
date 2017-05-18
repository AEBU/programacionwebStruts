<%-- 
    Document   : jspSuma2
    Created on : 06-abr-2017, 11:23:46
    Author     : Alexis

Pagina HTML con propiedades JSP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="idBean" class="practica1.beanOperacion"/>
<jsp:setProperty name="idBean" property="*"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Utilizando una clase Java</title>
    </head>
    <body>
        <form method="get">
            <p>Numero 1: <input type="text" name="numero1" size="20"> </p>
            <p>Numero 1: <input type="text" name="numero2" size="20"> </p>
            <input type="submit" value="Sumar" name="btnSumar"/>
        </form>
        
        <p> La suma de <%=idBean.getNumero1()%>+<%=idBean.getNumero2()%> es:<%=idBean.suma()%></p>
            
        
    </body>
</html>
