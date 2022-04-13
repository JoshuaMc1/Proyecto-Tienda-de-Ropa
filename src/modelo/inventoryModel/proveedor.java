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

    public IntegerProperty getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(IntegerProperty idProveedor) {
        this.idProveedor = idProveedor;
    }

    public StringProperty getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(StringProperty nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public StringProperty getTelefono() {
        return telefono;
    }

    public void setTelefono(StringProperty telefono) {
        this.telefono = telefono;
    }

    public StringProperty getDireccion() {
        return direccion;
    }

    public void setDireccion(StringProperty direccion) {
        this.direccion = direccion;
    }

    public StringProperty getCorreo() {
        return correo;
    }

    public void setCorreo(StringProperty correo) {
        this.correo = correo;
    }
    
    
    public proveedor() {
    }

    public String toString(){
        return nombreProveedor.get();
    }
    
    public void cargarDatos(ObservableList<proveedor> datos) {
        try{
            con.ConectarBasedeDatos();
            con.resultado = con.sentencia.executeQuery("SELECT * FROM proveedores WHERE status='1'");
            while(con.resultado.next()){
                int id = con.resultado.getInt("id_prov");
                String prov = con.resultado.getString("nombre_prov");
                String telefono = con.resultado.getString("telefono");
                String direccion = con.resultado.getString("direccion");
                String correo = con.resultado.getString("correo");
                datos.add(new proveedor(id, prov, telefono, direccion, correo));
            }
            con.DesconectarBasedeDatos();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, Arrays.toString(ex.getStackTrace()));
        }
    }
}
