
package modelo.inventoryModel;

import java.sql.SQLException;
import java.util.Arrays;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
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
public class product {
    private IntegerProperty idP;
    private IntegerProperty idLote;
    private StringProperty nombreP;
    private StringProperty marca;
    private StringProperty color;
    private StringProperty talla;
    private StringProperty tipoP;
    private StringProperty generoP;
    private StringProperty proveedor;
    private DoubleProperty precio;
    private IntegerProperty cantidad;
    private DoubleProperty descuento;
    ConexionMySQL con = new ConexionMySQL();
    
    public product(Integer idP, Integer idLote, String nombreP, String marca, String color, String talla, String tipoP, String generoP, String proveedor, Double precio, Integer cantidad, Double descuento) {
        this.idP = new SimpleIntegerProperty(idP);
        this.idLote = new SimpleIntegerProperty(idLote);
        this.nombreP = new SimpleStringProperty(nombreP);
        this.marca = new SimpleStringProperty(marca);
        this.color = new SimpleStringProperty(color);
        this.talla = new SimpleStringProperty(talla);
        this.tipoP = new SimpleStringProperty(tipoP);
        this.generoP = new SimpleStringProperty(generoP);
        this.proveedor = new SimpleStringProperty(proveedor);
        this.precio = new SimpleDoubleProperty(precio);
        this.cantidad = new SimpleIntegerProperty(cantidad);
        this.descuento = new SimpleDoubleProperty(descuento);
    }

    public product(){
    }
    
    public Integer getIdP() {
        return idP.get();
    }

    public void setIdP(Integer idP) {
        this.idP = new SimpleIntegerProperty(idP);
    }

    public Integer getIdLote() {
        return idLote.get();
    }

    public void setIdLote(Integer idLote) {
        this.idLote = new SimpleIntegerProperty(idLote);
    }

    public String getNombreP() {
        return nombreP.get();
    }

    public void setNombreP(String nombreP) {
        this.nombreP = new SimpleStringProperty(nombreP);
    }

    public String getMarca() {
        return marca.get();
    }

    public void setMarca(String marca) {
        this.marca = new SimpleStringProperty(marca);
    }

    public String getColor() {
        return color.get();
    }

    public void setColor(String color) {
        this.color = new SimpleStringProperty(color);
    }

    public String getTalla() {
        return talla.get();
    }

    public void setTalla(String talla) {
        this.talla = new SimpleStringProperty(talla);
    }

    public String getTipoP() {
        return tipoP.get();
    }

    public void setTipoP(String tipoP) {
        this.tipoP = new SimpleStringProperty(tipoP);
    }

    public String getGeneroP() {
        return generoP.get();
    }

    public void setGeneroP(String generoP) {
        this.generoP = new SimpleStringProperty(generoP);
    }

    public String getProveedor() {
        return proveedor.get();
    }

    public void setProveedor(String proveedor) {
        this.proveedor = new SimpleStringProperty(proveedor);
    }

    public Double getPrecio() {
        return precio.get();
    }

    public void setPrecio(Double precio) {
        this.precio = new SimpleDoubleProperty(precio);
    }

    public Integer getCantidad() {
        return cantidad.get();
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = new SimpleIntegerProperty(cantidad);
    }

    public Double getDescuento() {
        return descuento.get();
    }

    public void setDescuento(Double descuento) {
        this.descuento = new SimpleDoubleProperty(descuento);
    }
    
    public ObservableList<product> llenarTablaProductos(){
        ObservableList<product> datos = FXCollections.observableArrayList();
        try{
            con.ConectarBasedeDatos();
            con.resultado = con.sentencia.executeQuery("SELECT inv.*,gp.genero, prv.nombre_prov, prv.nombre_prov, p.*, des.porcentaje, tp.nombre, m.nombre FROM producto p INNER JOIN tipo_producto tp ON p.id_tipo=tp.id_tipo INNER JOIN marca m ON p.id_marca=m.id_marca INNER JOIN proveedores prv ON p.id_prov=prv.id_prov INNER JOIN genero_producto gp ON p.id_gen=gp.id_gen INNER JOIN descuentos des ON p.id_desc= des.id_desc INNER JOIN inventario inv ON inv.id_pdt=p.id_pdt WHERE inv.status='1' AND p.status='1'");
            while(con.resultado.next()){
                datos.add(
                    new product(
                            con.resultado.getInt("id_pdt"),
                            con.resultado.getInt("n_lote"),
                            con.resultado.getString("descripcion"),
                            con.resultado.getString("m.nombre"),
                            con.resultado.getString("color"),
                            con.resultado.getString("talla"),
                            con.resultado.getString("tp.nombre"),
                            con.resultado.getString("genero"),
                            con.resultado.getString("nombre_prov"),
                            con.resultado.getDouble("precio"),
                            con.resultado.getInt("existencias"),
                            con.resultado.getDouble("porcentaje")
                ));
            }
            con.DesconectarBasedeDatos();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, Arrays.toString(ex.getStackTrace()));
        }
        return datos;
    }
}
