package modelo;

import controladores_form.ProductosBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class GestionProducto {

    ConexionDB con;

    public GestionProducto(String driver, String cadena_conexion) {
        con = new ConexionDB(driver, cadena_conexion);
    }

    public ArrayList<String> consulta_categorias() {

        ArrayList<String> conjunto_categoria = new ArrayList<String>();
        try {
            Connection cn = con.getConexion();
            Statement st = cn.createStatement();
            String cadenaSQL = "select categoria_id from categoria";
            ResultSet rs = st.executeQuery(cadenaSQL);

            while (rs.next()) {
                conjunto_categoria.add(rs.getString("categoria_id"));
            }
            con.cierraConexion(cn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conjunto_categoria;
    }

    public ArrayList<ProductosBean> consulta_producto(String categoria_codigo){
        ArrayList<ProductosBean> conjunto_productos= new ArrayList<ProductosBean>();
        try {
            Connection cn=con.getConexion();
             Statement st = cn.createStatement();
            String cadenaSQL = "select a.categoria_id,b.categoria_nombre,a.producto_id,a.producto_nombre,"
                                + "a.producto_precio,a.producto_stock from producto a, categoria b"
                                + "where a.categoria_id= '"+categoria_codigo+"' and a.categoria_id=b.categoria_id";
            ResultSet rs = st.executeQuery(cadenaSQL);
            while (rs.next()) {
                ProductosBean prod=new ProductosBean();
                prod.setId_categoria(rs.getString("categoria_id"));
                prod.setNombre_categoria(rs.getString("categoria_nombre"));
                prod.setId_producto(rs.getString("producto_id"));
                prod.setNombre_producto(rs.getString("producto_nombre"));
                prod.setPrecio_producto(rs.getInt("producto_precio"));
                prod.setStock_producto(rs.getInt("producto_stock"));
                conjunto_productos.add(prod);
            }

            con.cierraConexion(cn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conjunto_productos;
    }
}
