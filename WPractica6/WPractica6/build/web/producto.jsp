<%-- 
    Document   : producto
    Created on : 03/05/2017, 20:27:09
    Author     : GABRIELA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ page import="java.util.*, controladores_form.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta Solicitada...</title>
    </head>
    <body>
        <% ArrayList<productosBean> productos = (ArrayList)request.getAttribute("productos"); %>

        <h1> Listado de productos </h1>
        
        <table border="1" width="60%">
            <th> Categoria_Id </th>
            <th> Categoria    </th>
            <th> Producto_Id  </th>
            <th> Producto     </th>
            <th> Stock        </th>
            <th> Precio       </th>
            
            <% for (int i = 0; i<productos.size(); i++ ){
                productosBean prod = productos.get(i); %>
                
                <tr>
                    <td><%=prod.getId_categoria()%></td>
                    <td><%=prod.getNombre_categoria()%></td>
                    <td><%=prod.getId_producto()%></td>
                    <td><%=prod.getNombre_producto()%></td>
                    <td><%=prod.getStock_producto()%></td>
                    <td><%=prod.getPrecio_producto()%></td>
                    
                </tr>
          <%  } %>
            
        </table>
       </body>
</html>
