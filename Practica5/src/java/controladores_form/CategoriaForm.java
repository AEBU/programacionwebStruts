/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores_form;

import java.util.ArrayList;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author Alexis
 */
public class CategoriaForm extends ActionForm{
    private String bandera;
    private ArrayList<String> codigoCategoria;

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    public ArrayList<String> getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(ArrayList<String> codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }
    
    
    
}
