/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.inventoryModel;

import java.sql.SQLException;
import java.util.Arrays;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import modelo.ConexionMySQL;

/**
 *
 * @author JoshuaMc
 */
public class descuentos {
    private IntegerProperty id;
    private DoubleProperty desc;
    ConexionMySQL con = new ConexionMySQL();
    
    public descuentos(Integer id, Double desc) {
        this.id = new SimpleIntegerProperty(id);
        this.desc = new SimpleDoubleProperty(desc);
    }

    public descuentos() {
    }

    public IntegerProperty getId() {
        return id;
    }

    public void setId(IntegerProperty id) {
        this.id = id;
    }

    public DoubleProperty getDesc() {
        return desc;
    }

    public void setDesc(DoubleProperty desc) {
        this.desc = desc;
    }
    
    public String toString(){
        return desc.toString();
    }
    
    public void cargarDatos(ObservableList<descuentos> datos){
        try{
            con.ConectarBasedeDatos();
            con.resultado = con.sentencia.executeQuery("SELECT * FROM descuentos WHERE status='1'");
            while(con.resultado.next()){
                int id = con.resultado.getInt("id_desc");
                double porciento = con.resultado.getDouble("porcentaje");
                datos.add(new descuentos(id,porciento));
            }
            con.DesconectarBasedeDatos();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, Arrays.toString(ex.getStackTrace()));
        }
    }
}
