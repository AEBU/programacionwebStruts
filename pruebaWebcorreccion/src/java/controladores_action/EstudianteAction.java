/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores_action;

import controladores_form.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import modelo.*;

/**
 *
 * @author Alexis
 */
public class EstudianteAction extends Action {
    
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String driver = this.getServlet().getServletContext().getInitParameter("driver");
        String cadena_conexion = this.getServlet().getServletContext().getInitParameter("cadena_conexion");

        SeleccionEstForm pb = (SeleccionEstForm) form;
        GestionEstudiante gp = new GestionEstudiante(driver, cadena_conexion);
         System.out.println(pb.getNumCedula());
        request.setAttribute("estudiantes", gp.consulta_categoria(pb.getNumCedula()));

        return mapping.findForward("consultajsp");
    }
}
