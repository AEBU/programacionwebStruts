/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores_action;

import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 *
 * @author Alexis
 */
public class ValidacionAction extends Action{
    
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
        
        return mapping.findForward("autenticacion");
    }
    
}
