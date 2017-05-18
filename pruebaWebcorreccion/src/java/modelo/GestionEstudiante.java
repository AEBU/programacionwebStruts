/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controladores_form.EstudiantesBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class GestionEstudiante {

    ConexionDB con;

    public GestionEstudiante(String driver, String cadena_conexion) {
        con = new ConexionDB(driver, cadena_conexion);
    }

    public ArrayList<EstudiantesBean> consulta_categoria(String numCedula) {

        ArrayList<EstudiantesBean> conjuntoRegistro = new ArrayList<EstudiantesBean>();
        try {
            Connection cn = con.getConexion();
            Statement st = cn.createStatement();
            String cadenaSQL = "select es.*,ma.* from estudiante_materia esma, materia ma, estudiante es where es.est_cedula=esma.est_cedula and ma.mat_codigo=esma.mat_codigo and es.est_cedula like '" + numCedula + "%'";
            System.out.println(cadenaSQL+" Este es la cadena de creacion");
            ResultSet rs = st.executeQuery(cadenaSQL);
            while (rs.next()) {
                EstudiantesBean estu = new EstudiantesBean();

                estu.setEst_cedula(rs.getString("est_cedula"));
                estu.setEst_apellido(rs.getString("est_apellido"));
                estu.setEst_nombre(rs.getString("est_nombre"));

                estu.setMat_codigo(rs.getString("mat_codigo"));
                estu.setMat_nombre(rs.getString("mat_nombre"));
                estu.setMat_creditos(rs.getString("mat_creditos"));

                conjuntoRegistro.add(estu);
            }
            con.cierraConexion(cn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conjuntoRegistro;
    }
}
