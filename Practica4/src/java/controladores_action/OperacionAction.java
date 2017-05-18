/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores_action;


import controladores_form.ValidacionForm;
import modelo.OperacionesBasicas;
import org.apache.struts.action.Action;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 *
 * @author Alexis
 */
public class OperacionAction extends Action{
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
       OperacionesBasicas op = new OperacionesBasicas();
       ValidacionForm vf = (ValidacionForm)form;
       request.setAttribute("respuesta", op.suma(vf));  //op.suma(vf) encapsula los datos de vf y envía al modelo op
       return mapping.findForward("resultado");
    }
    
}
