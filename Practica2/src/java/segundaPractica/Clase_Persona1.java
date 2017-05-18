/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundaPractica;

import java.sql.*;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class Clase_Persona1 {
            public final static Logger LOGGER=Logger.getLogger(Clase_Persona1.class.getName());

    private String[] arreglo;
    private Connection var_conexion;
    private Statement var_stmt;

    public Clase_Persona1() {
    }

    public synchronized void setarreglo(String[] nuevo_arreglo) {
        arreglo = new String[nuevo_arreglo.length];
        System.arraycopy(nuevo_arreglo, 0, arreglo, 0, nuevo_arreglo.length);
    }

    public void procedimiento_conexion() {
        try {
            Class.forName("org.postgresql.Driver");
            DriverManager.registerDriver(new org.postgresql.Driver());
            var_conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practica2", "postgres", "junior200");

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public void procedimiento_ingreso() {

        try {
            var_stmt = var_conexion.createStatement();
            String query = "insert into persona values ('" + arreglo[0] + "','" + arreglo[1] + "','" + arreglo[2] + "','" + arreglo[3] + "')";
            System.out.println(query);
            LOGGER.info(query);
            var_stmt.executeUpdate(query);

            var_stmt.executeUpdate(query);
            var_stmt.close();
            var_conexion.close();

        } catch (Exception e) {

        }

    }

}
