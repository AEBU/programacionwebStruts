<%-- 
    Document   : ingresoDB
    Created on : 13-abr-2017, 11:26:44
    Author     : Alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Beans</title>
    </head>
    <body>
        <form method="GET">
            <p>
                Cedula:<input type="text" name="txt_cedula" size="20"/>
            </p>
            <p>
                Nombre:<input type="text" name="txt_cedula" size="20"/>
            </p>
            <p>
                Apellido:<input type="text" name="txt_cedula" size="20"/>
            </p>
            <p>
                Sexo:<select name="sl_sexo">
                    <option value="M">M</option>
                    <option value="F">F</option>
                        
                    <input type="submit" value="Ingresar Datos" name="btn_ingresar">
                    
                        
                </select>
                    
                <input type="text" name="txt_cedula" size="20"/>
            </p>
                
        </form>
        <%
        if(request.getParameter("txt_cedula")!=null&&request.getParameter("txt_cedula")!=""&&
        request.getParameter("txt_nombre")!=null&&request.getParameter("txt_nombre")!=""&&
        request.getParameter("txt_apellido")!=null&&request.getParameter("txt_apellido")!="" &&
        request.getParameter("sl_sexo")!=null&&request.getParameter("sl_sexo")!="")
        {
            String[] datos=new String[4];
            datos[0]=request.getParameter("txt_cedula");
            datos[1]=request.getParameter("txt_nombre");
            datos[2]=request.getParameter("txt_apellido");
            datos[3]=request.getParameter("sl_sexo");
            %>
           
            <jsp:useBean id="id_objeto" class="segundaPractica.Clase_Persona1" />
            <jsp:setProperty name="id_objeto" property="arreglo" value="<%=datos %>"/>
            
           <%
               id_objeto.procedimiento_conexion();
               id_objeto.procedimiento_conexion();
               
        }
%>
    </body>
</html>
