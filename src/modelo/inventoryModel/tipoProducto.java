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
public class tipoProducto {
    private IntegerProperty id;
    private StringProperty tipo;
    ConexionMySQL con = new ConexionMySQL();
    
    public tipoProducto(Integer id, String tipo) {
        this.id = new SimpleIntegerProperty(id);
        this.tipo = new SimpleStringProperty(tipo);
    }
    
    public tipoProducto(){
    }
    
    public Integer getId() {
        return id.get();
    }

    public void setId(Integer id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public String getTipo() {
        return tipo.get();
    }

    public void setTipo(String tipo) {
        this.tipo = new SimpleStringProperty(tipo);
    }
    
    public String toString(){
        return tipo.get();
    }
    
    public void cargarDatos(ObservableList<tipoProducto> datos){
        try{
            con.ConectarBasedeDatos();
            con.resultado = con.sentencia.executeQuery("SELECT * FROM tipo_producto WHERE status='1'");
            while(con.resultado.next()){
                int id = con.resultado.getInt("id_tipo");
                String genero_p = con.resultado.getString("nombre");
                datos.add(new tipoProducto(id, genero_p));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, Arrays.toString(ex.getStackTrace()));
        }
    }
    
    public int guardar() {
        try{
            con.ConectarBasedeDatos();
            PreparedStatement ps = con.getConnection().prepareStatement("INSERT INTO tipo_producto(nombre, status) VALUES (?, ?)");
            ps.setString(1, tipo.get());
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
            PreparedStatement ps = con.getConnection().prepareStatement("UPDATE tipo_producto SET nombre=? WHERE id_tipo=?");
            ps.setString(1, tipo.get());
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
            PreparedStatement ps = con.getConnection().prepareStatement("UPDATE tipo_producto SET status=? WHERE id_tipo=?");
            ps.setString(1, "0");
            ps.setInt(2, id.get());
            return ps.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
    }
}
