/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores_form;

import org.apache.struts.action.ActionForm;

/**
 *
 * @author Alexis
 */
public class SeleccionEstForm extends ActionForm{
    
    private String  numCedula;

    public String getNumCedula() {
        return numCedula;
    }

    public void setNumCedula(String numCedula) {
        this.numCedula = numCedula;
    }
            
    
    
}
