/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.inventoryModel;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import modelo.ConexionMySQL;

/**
 *
 * @author JoshuaMc
 */
public class generoProducto {
    private IntegerProperty id;
    private StringProperty genero;
    ConexionMySQL con = new ConexionMySQL();

    public generoProducto(Integer id, String genero) {
        this.id = new SimpleIntegerProperty(id);
        this.genero = new SimpleStringProperty(genero);
    }

    public generoProducto() {
    }

    public Integer getId() {
        return id.get();
    }

    public void setId(Integer id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public String getGenero() {
        return genero.get();
    }

    public void setGenero(String genero) {
        this.genero = new SimpleStringProperty(genero);
    }
    
    public String toString(){
        return genero.get();
    }
    
    public void cargarDatos(ObservableList<generoProducto> datos){
        try{
            con.ConectarBasedeDatos();
            con.resultado = con.sentencia.executeQuery("SELECT * FROM genero_producto WHERE status='1'");
            while(con.resultado.next()){
                int id = con.resultado.getInt("id_gen");
                String genero_p = con.resultado.getString("genero");
                datos.add(new generoProducto(id, genero_p));
            }
            con.DesconectarBasedeDatos();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, Arrays.toString(ex.getStackTrace()));
        }
    }
    
    public int guardar() {
        try{
            con.ConectarBasedeDatos();
            PreparedStatement ps = con.getConnection().prepareStatement("INSERT INTO genero_producto(genero, status) VALUES (?, ?)");
            ps.setString(1, genero.get());
            ps.setString(2, "1");
            return ps.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
    }
    
    public int actualizar(){
        try{
            con.ConectarBasedeDatos();
            PreparedStatement ps = con.getConnection().prepareStatement("UPDATE genero_producto SET genero=? WHERE id_gen=?");
            ps.setString(1, genero.get());
            ps.setInt(2, id.get());
            return ps.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
    }
    
    public int eliminar(){
        try{
            con.ConectarBasedeDatos();
            PreparedStatement ps = con.getConnection().prepareStatement("UPDATE genero_producto SET status=? WHERE id_gen=?");
            ps.setString(1, "0");
            ps.setInt(2, id.get());
            return ps.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
    }
}
