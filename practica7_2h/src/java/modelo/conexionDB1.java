/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
create table Registro( 

nombre varchar(30),
apellido varchar(30),
usuario varchar(30),
password varchar(30),
email varchar(30),
constraint pfa primary key (usuario));
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author edalx
 */
public class conexionDB1 {
    private String driver;
    private String cadenacon;
    
    public conexionDB1(){
    
}
    public conexionDB1(String driver, String cadena_conexion){
        this.driver=driver;
        this.cadenacon=cadena_conexion;
    }
    
    public Connection getConexion(){
        Connection cn=null;
        try{
            Class.forName(driver).newInstance();
            cn=DriverManager.getConnection(cadenacon,"postgres","junior200");
        }catch(Exception er){
            er.printStackTrace();
        }
        return cn;
    }
    
    public void cierraConexion(Connection cn){
        try{
            if (cn!=null && !cn.isClosed()){
                cn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
