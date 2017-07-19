/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misclases;

/**
 *
 * @author Alexis
 */
public class Mensaje {
    
    private String remite;
    private String destino;
    private String texto;

    public Mensaje() {
    
    
    }

    public Mensaje(String remite, String destino, String texto) {
        this.remite = remite;
        this.destino = destino;
        this.texto = texto;
    }

    public String getRemite() {
        return remite;
    }

    public void setRemite(String remite) {
        this.remite = remite;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
    
    
    
}
