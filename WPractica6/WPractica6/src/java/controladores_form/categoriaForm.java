/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores_form;
import java.util.*;
import org.apache.struts.action.*;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author GABRIELA
 */
public class categoriaForm extends ActionForm {
   private String Bandera;
    private ArrayList<String> codigocategoria;

    public ArrayList<String> getCodigocategoria() {
        return codigocategoria;
    }

    public void setCodigocategoria(ArrayList<String> codigocategoria) {
        this.codigocategoria = codigocategoria;
    }

    public String getBandera() {
        return Bandera;
    }

    public void setBandera(String Bandera) {
        this.Bandera = Bandera;
    }
 
}
