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
public class marca {
    private IntegerProperty id;
    private StringProperty nombre;
    ConexionMySQL con = new ConexionMySQL();
    
    public marca(Integer id, String nombre) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
    }

    public marca(){
    }
    
    public Integer getId() {
        return id.get();
    }

    public void setId(Integer id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }
    
    public String toString(){
        return nombre.get();
    }
    
    public void cargarDatos(ObservableList<marca> datos){
        try{
            con.ConectarBasedeDatos();
            con.resultado = con.sentencia.executeQuery("SELECT * FROM marca WHERE status='1'");
            while(con.resultado.next()){
                int id = con.resultado.getInt("id_marca");
                String nombre_marca = con.resultado.getString("nombre");
                datos.add(new marca(id,nombre_marca));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, Arrays.toString(ex.getStackTrace()));
        }
    }
    
    public int guardar() {
        try{
            con.ConectarBasedeDatos();
            PreparedStatement ps = con.getConnection().prepareStatement("INSERT INTO marca(nombre, status) VALUES (?, ?)");
            ps.setString(1, nombre.get());
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
            PreparedStatement ps = con.getConnection().prepareStatement("UPDATE marca SET nombre=? WHERE id_marca=?");
            ps.setString(1, nombre.get());
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
            PreparedStatement ps = con.getConnection().prepareStatement("UPDATE marca SET status=? WHERE id_marca=?");
            ps.setString(1, "0");
            ps.setInt(2, id.get());
            return ps.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
    }
}
