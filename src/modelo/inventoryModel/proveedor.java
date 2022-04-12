
package modelo.inventoryModel;

import java.sql.SQLException;
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import modelo.ConexionMySQL;

/**
 *
 * @author JoshuaMc
 */
public class proveedor {
    private int idProveedor;
    private String nombreProveedor;
    private String telefono;
    private String direccion;
    private String correo;
    ConexionMySQL con = new ConexionMySQL();
    
    public proveedor(int idProveedor, String nombreProveedor, String telefono, String direccion, String correo) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }
    
    public proveedor() {
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ObservableList<proveedor> cargarDatos(){
        ObservableList<proveedor> datos = FXCollections.observableArrayList();
        try{
            con.ConectarBasedeDatos();
            con.resultado = con.sentencia.executeQuery("SELECT * FROM proveedores WHERE status='1'");
            while(con.resultado.next()){
                int id = con.resultado.getInt("id_prov");
                String prov = con.resultado.getString("nombre_prov");
                String telefono = con.resultado.getString("telefono");
                String direccion = con.resultado.getString("direccion");
                String correo = con.resultado.getString("correo");
                
                proveedor p = new proveedor(id, prov, telefono, direccion, correo);
                datos.add(p);
            }
            con.DesconectarBasedeDatos();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, Arrays.toString(ex.getStackTrace()));
        }
        return datos;
    }
}
