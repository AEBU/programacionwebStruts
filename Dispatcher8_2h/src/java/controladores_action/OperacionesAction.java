/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores_action;

import excepciones.DivisionCeroExcepcion;
import javax.servlet.http.*;
import modelo.OperacionesBasicas2;
import org.apache.struts.action.*;
import org.apache.struts.actions.*;
import servlets_form.*;

/**
 *
 * @author Alexis
 */
public class OperacionesAction extends DispatchAction {

    public ActionForward sumar_numeros(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        Numeros n = (Numeros) form;
        OperacionesBasicas2 op = new OperacionesBasicas2();
        request.setAttribute("resultado", op.suma(n));
        return mapping.findForward("Basica");
    }

    public ActionForward restar_numeros(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        Numeros n = (Numeros) form;
        OperacionesBasicas2 op = new OperacionesBasicas2();
        request.setAttribute("resultado", op.resta(n));
        return mapping.findForward("Basica");
    }

    public ActionForward multiplicar_numeros(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        Numeros n = (Numeros) form;
        OperacionesBasicas2 op = new OperacionesBasicas2();
        request.setAttribute("resultado", op.multiplicacion(n));
        return mapping.findForward("Basica");
    }

    public ActionForward dividir_numeros(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws DivisionCeroExcepcion {

        Numeros n = (Numeros) form;
        OperacionesBasicas2 op = new OperacionesBasicas2();

        try {
            int valor = op.division(n);
            request.setAttribute("resultado", valor);

        } catch (Exception e) {
            throw new DivisionCeroExcepcion();
        }

        return mapping.findForward("Basica");
    }
}
