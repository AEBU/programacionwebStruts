/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author Alexis
 */
public class beanOperacion extends Object {
    
    private int numero1;
    private int numero2;

    public int getNumero1() {
        return numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public synchronized void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public synchronized void setNumero2(int numero2) {
        this.numero2 = numero2;
    }
    
    public int suma(){
        return numero1+numero2;
    }

    public beanOperacion() {
    }
    
    
    
    
}
