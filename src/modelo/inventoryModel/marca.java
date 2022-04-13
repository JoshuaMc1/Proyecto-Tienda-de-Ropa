/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.inventoryModel;

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
    
    public IntegerProperty getId() {
        return id;
    }

    public void setId(IntegerProperty id) {
        this.id = id;
    }

    public StringProperty getNombre() {
        return nombre;
    }

    public void setNombre(StringProperty nombre) {
        this.nombre = nombre;
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
            con.DesconectarBasedeDatos();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, Arrays.toString(ex.getStackTrace()));
        }
    }
}
