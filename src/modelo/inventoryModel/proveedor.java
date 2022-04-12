package modelo.inventoryModel;

import java.sql.SQLException;
import java.util.Arrays;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
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

    public proveedor() {
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

    public void cargarDatos() {
        ObservableList<proveedor> datos = FXCollections.observableArrayList();
        try {
            con.ConectarBasedeDatos();
            con.resultado = con.sentencia.executeQuery("SELECT * FROM proveedores WHERE status='1'");
            while (con.resultado.next()) {
                int id = con.resultado.getInt("id_prov");
                String prov = con.resultado.getString("nombre_prov");
                String telefono = con.resultado.getString("telefono");
                String direccion = con.resultado.getString("direccion");
                String correo = con.resultado.getString("correo");

                proveedor p = new proveedor(id, prov, telefono, direccion, correo);
                datos.add(p);
            }
            con.DesconectarBasedeDatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, Arrays.toString(ex.getStackTrace()));
        }
    }
}
