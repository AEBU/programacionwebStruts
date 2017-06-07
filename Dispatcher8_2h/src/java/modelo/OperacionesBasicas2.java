package modelo;

import servlets_form.Numeros;

/**
 *
 * @author Alexis
 */
public class OperacionesBasicas2 {
    
    public int suma(Numeros n){
        return (n.getNumero1()+n.getNumero2());
    }
    public int resta(Numeros n){
        return (n.getNumero1()-n.getNumero2());
    }
    public int multiplicacion(Numeros n){
        return (n.getNumero1()*n.getNumero2());
    }
    public int division(Numeros n){
        return (n.getNumero1()/n.getNumero2());
    }
    
}
