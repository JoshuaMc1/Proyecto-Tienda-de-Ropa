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
public class proveedor {

    private IntegerProperty idProveedor;
    private StringProperty nombreProveedor;
    private StringProperty telefono;
    private StringProperty direccion;
    private StringProperty correo;
    ConexionMySQL con = new ConexionMySQL();

    public proveedor(Integer idProveedor, String nombreProveedor, String telefono, String direccion, String correo) {
        this.idProveedor = new SimpleIntegerProperty(idProveedor);
        this.nombreProveedor = new SimpleStringProperty(nombreProveedor);
        this.telefono = new SimpleStringProperty(telefono);
        this.direccion = new SimpleStringProperty(direccion);
        this.correo = new SimpleStringProperty(correo);
    }

    public Integer getIdProveedor() {
        return idProveedor.get();
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = new SimpleIntegerProperty(idProveedor);
    }

    public String getNombreProveedor() {
        return nombreProveedor.get();
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = new SimpleStringProperty(nombreProveedor);
    }

    public String getTelefono() {
        return telefono.get();
    }

    public void setTelefono(String telefono) {
        this.telefono = new SimpleStringProperty(telefono);
    }

    public String getDireccion() {
        return direccion.get();
    }

    public void setDireccion(String direccion) {
        this.direccion = new SimpleStringProperty(direccion);
    }

    public String getCorreo() {
        return correo.get();
    }

    public void setCorreo(String correo) {
        this.correo = new SimpleStringProperty(correo);
    }

    public proveedor() {
    }

    public String toString() {
        return nombreProveedor.get();
    }

    public int guardar() {
        try{
            con.ConectarBasedeDatos();
            PreparedStatement ps = con.getConnection().prepareStatement("INSERT INTO proveedores(nombre_prov, telefono, direccion, correo, status) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, nombreProveedor.get());
            ps.setString(2, telefono.get());
            ps.setString(3, direccion.get());
            ps.setString(4, correo.get());
            ps.setString(5, "1");
            return ps.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
    }
    
    public int actualizar(){
        try{
            con.ConectarBasedeDatos();
            PreparedStatement ps = con.getConnection().prepareStatement("UPDATE proveedores SET nombre_prov=?, telefono=?, direccion=?, correo=? WHERE id_prov=?");
            ps.setString(1, nombreProveedor.get());
            ps.setString(2, telefono.get());
            ps.setString(3, direccion.get());
            ps.setString(4, correo.get());
            ps.setInt(5, idProveedor.get());
            return ps.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
    }
    
    public int eliminar(){
        try{
            con.ConectarBasedeDatos();
            PreparedStatement ps = con.getConnection().prepareStatement("UPDATE proveedores SET status=? WHERE id_prov=?");
            ps.setString(1, "0");
            ps.setInt(2, idProveedor.get());
            return ps.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
    }
    
    public void cargarDatos(ObservableList<proveedor> datos) {
        try {
            con.ConectarBasedeDatos();
            con.resultado = con.sentencia.executeQuery("SELECT * FROM proveedores WHERE status='1'");
            while (con.resultado.next()) {
                int id = con.resultado.getInt("id_prov");
                String prov = con.resultado.getString("nombre_prov");
                String telefono = con.resultado.getString("telefono");
                String direccion = con.resultado.getString("direccion");
                String correo = con.resultado.getString("correo");
                datos.add(new proveedor(id, prov, telefono, direccion, correo));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, Arrays.toString(ex.getStackTrace()));
        }
    }
}
