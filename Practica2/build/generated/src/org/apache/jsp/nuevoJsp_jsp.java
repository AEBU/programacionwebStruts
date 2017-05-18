package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class nuevoJsp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Beans</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form method=\"GET\">\n");
      out.write("            <p>Cedula:<input type=\"text\" name=\"txt_cedula\" size=\"20\"/>\n");
      out.write("            <p>Nombre:<input type=\"text\" name=\"txt_nombre\" size=\"20\"/>\n");
      out.write("            <p>Apellido:<input type=\"text\" name=\"txt_apellido\" size=\"20\"/>\n");
      out.write("            <p>Sexo:<select name=\"sl_sexo\">\n");
      out.write("                    <option value=\"M\">M</option>\n");
      out.write("                    <option value=\"F\">F</option>\n");
      out.write("                </select>\n");
      out.write("            </p>\n");
      out.write("            <input type=\"submit\" value=\"Ingresar Datos\" name=\"btn_ingresar\">\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("        ");

            if (request.getParameter("txt_cedula") != null && request.getParameter("txt_cedula") != ""
                    && request.getParameter("txt_nombre") != null && request.getParameter("txt_nombre") != ""
                    && request.getParameter("txt_apellido") != null && request.getParameter("txt_apellido") != ""
                    && request.getParameter("sl_sexo") != null && request.getParameter("sl_sexo") != "") {
                String[] datos = new String[4];
                datos[0] = request.getParameter("txt_cedula");
                datos[1] = request.getParameter("txt_nombre");
                datos[2] = request.getParameter("txt_apellido");
                datos[3] = request.getParameter("sl_sexo");
        
      out.write("\n");
      out.write("\n");
      out.write("        ");
      segundaPractica.Clase_Persona1 id_objeto = null;
      synchronized (_jspx_page_context) {
        id_objeto = (segundaPractica.Clase_Persona1) _jspx_page_context.getAttribute("id_objeto", PageContext.PAGE_SCOPE);
        if (id_objeto == null){
          id_objeto = new segundaPractica.Clase_Persona1();
          _jspx_page_context.setAttribute("id_objeto", id_objeto, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("id_objeto"), "arreglo",
datos);
      out.write("\n");
      out.write("\n");
      out.write("        ");

                id_objeto.procedimiento_conexion();
                id_objeto.procedimiento_ingreso();

            }
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
