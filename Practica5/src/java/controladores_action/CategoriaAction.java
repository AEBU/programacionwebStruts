/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores_action;

import controladores_form.CategoriaForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionProducto;
import org.apache.struts.action.*;

/**
 *
 * @author Alexis
 */
public class CategoriaAction extends Action{
    public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)throws Exception{
        String driver=this.getServlet().getServletContext().getInitParameter("driver");
        String cadena_conexion=this.getServlet().getServletContext().getInitParameter("cadena_conexion");
        CategoriaForm cb=(CategoriaForm)form;
        GestionProducto gp=new GestionProducto(driver, cadena_conexion);
        cb.setCodigoCategoria(gp.consulta_categorias());
        return mapping.findForward("categoriajsp");
        
    }
            
}
