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
public class tipoProducto {
    private IntegerProperty id;
    private StringProperty tipo;
    ConexionMySQL con = new ConexionMySQL();
    
    public tipoProducto(Integer id, String genero) {
        this.id = new SimpleIntegerProperty(id);
        this.tipo = new SimpleStringProperty(genero);
    }
    
    public tipoProducto(){
    }
    
    public IntegerProperty getId() {
        return id;
    }

    public void setId(IntegerProperty id) {
        this.id = id;
    }

    public StringProperty getGenero() {
        return tipo;
    }

    public void setGenero(StringProperty genero) {
        this.tipo = genero;
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
            con.DesconectarBasedeDatos();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, Arrays.toString(ex.getStackTrace()));
        }
    }
}
