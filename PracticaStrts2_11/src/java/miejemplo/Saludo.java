/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miejemplo;

import java.util.Date;

/**
 *
 * @author Alexis
 */
public class Saludo {
    public static final String texto="Bienvenido a Struts 2";
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String getFechaHora(){
        return  new Date().toString();
    }
    
    public String execute() throws Exception{
        setMensaje(texto);
        return "ok";
    }
    
}
