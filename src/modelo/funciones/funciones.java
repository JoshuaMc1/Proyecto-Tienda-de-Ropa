package modelo.funciones;

import controlador.clases.Usuario;
import java.sql.SQLException;
import java.util.function.UnaryOperator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import modelo.ConexionMySQL;

/**
 *
 * @author Joshua Mc
 */
public class funciones {

    //Objetos
    ConexionMySQL con = new ConexionMySQL();

    public void msg(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    //metodo para verificar que todas las cajas de texto en un panel esten vaciasm
    public boolean Vacio(Pane panel, String tfName) {// panel en que se encuentran las cajas de texto y opcional una caja de texto que no se quiera
        boolean vacio = false;                         // verificar si esta vacia o no, solo se pone el id de la caja de texto
        for (Node jt : panel.getChildren()) { //foreach, recorre todos los componentes en el panel
            if (jt instanceof TextField) { //if un componente es un textfield
                if (((TextField) jt).getText().isEmpty() && !jt.getId().equals(tfName)) { //if la caja de texto esta vacia o su nombre es similar al nombre de la caja de texto que no se quiere verificar
                    vacio = true;
                    break;
                }
            }
        }
        return vacio;
    }

    //metodo para cambiar de estado los datos en la base de datos
    /* public void eliminar(String sentencia){
        try {
            con.ConectarBasedeDatos();
            con.sentencia.execute(sentencia);
            JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO CORRECTAMENTE", "ATENCION!", 1);
            con.DesconectarBasedeDatos();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR EL REGISTRO\nERROR: "+e.getMessage(), "ATENCION!", 0);
        }
    }
    
    //metodo para modificar los datos en la base de datos
    public void modificar(String sentencia){
        try{
            con.ConectarBasedeDatos();
            con.sentencia.execute(sentencia);
            //JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO CORRECTAMENTE", "ATENCION!", 1);
            con.DesconectarBasedeDatos();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "NO SE PUDO MODIFICAR EL REGISTRO\nERROR: "+ex.getMessage(), "ATENCION!", 0);
        }
    }
    
    //metodo para buscar en la base de datos
    public ResultSet buscar(String sql, Conexion.ConexionMySQL con){
        try{
            con = new Conexion.ConexionMySQL();
            con.ConectarBasedeDatos("supermercado");
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch(Exception e){
            return null;
        }
    }
    
    //metodo para guardar el la base de datos
    public void guardar(String sentencia){
        try{
            con.ConectarBasedeDatos();
            System.out.println("coencta");
            PreparedStatement ps = con.getConnection().prepareStatement(sentencia);
            ps.execute();
            con.DesconectarBasedeDatos();
            //JOptionPane.showMessageDialog(null, "REGISTRO GUARDADO CORRECTAMENTE", "ATENCION!", 1);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR EL REGISTRO\nError: "+ex.getMessage(), "ATENCION!", 0);
            ex.printStackTrace();
        }
    }*/
    public String totalInventario() {
        String res = "";
        try {
            con.ConectarBasedeDatos();
            con.resultado = con.sentencia.executeQuery("SELECT SUM(precio*existencias) total FROM producto, inventario WHERE inventario.status='1' AND producto.status='1'");
            if (con.resultado.next()) {
                res = "L. " + con.resultado.getDouble("total");
            }
            con.DesconectarBasedeDatos();
        } catch (SQLException e) {
            msg(e.getMessage());
        }
        return res;
    }

    public String catidadInventario() {
        String res = "";
        try {
            con.ConectarBasedeDatos();
            con.resultado = con.sentencia.executeQuery("SELECT SUM(existencias) AS total FROM inventario WHERE status='1'");
            if (con.resultado.next()) {
                res = String.valueOf(con.resultado.getInt("total"));
            }
            con.DesconectarBasedeDatos();
        } catch (SQLException e) {
            msg(e.getMessage());
        }
        return res;
    }
    
    public String catidadInventarioBajo() {
        String res = "";
        try {
            con.ConectarBasedeDatos();
            con.resultado = con.sentencia.executeQuery("SELECT COUNT(id_inv) AS total FROM inventario WHERE status='1' AND existencias < 15");
            if (con.resultado.next()) {
                res = String.valueOf(con.resultado.getInt("total"));
            }
            con.DesconectarBasedeDatos();
        } catch (SQLException e) {
            msg(e.getMessage());
        }
        return res;
    }
    
    public ObservableList<XYChart.Data<String, Number>> datosGrafico1(){
        ObservableList<XYChart.Data<String, Number>> data = FXCollections.observableArrayList();
        try {
            con.ConectarBasedeDatos();
            con.resultado = con.sentencia.executeQuery("SELECT p.descripcion, inv.existencias FROM producto p INNER JOIN inventario inv ON inv.id_pdt = p.id_pdt WHERE inv.existencias < 15 AND inv.status='1'");
            while(con.resultado.next()) {
                data.add(new XYChart.Data<>(con.resultado.getString("descripcion"),con.resultado.getInt("existencias")));
            }
            con.DesconectarBasedeDatos();
        } catch (SQLException e) {
            msg(e.getMessage());
        }
        return data;
    }
    
    public ObservableList<PieChart.Data> datosGrafico2(){
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        try {
            con.ConectarBasedeDatos();
            con.resultado = con.sentencia.executeQuery("select sum(inv.existencias) as existencias, m.nombre from inventario inv INNER JOIN producto p on inv.id_pdt=p.id_pdt INNER JOIN marca m on p.id_marca=m.id_marca WHERE inv.status='1' GROUP by p.id_marca, m.nombre");
            while(con.resultado.next()) {
                data.add(new PieChart.Data(con.resultado.getString("nombre")+" - "+con.resultado.getInt("existencias"), con.resultado.getInt("existencias")));
            }
            con.DesconectarBasedeDatos();
        } catch (SQLException e) {
            msg(e.getMessage());
        }
        return data;
    }
    
    public int validarInicio(String usuario, String clave) {
        int dato = 0;
        try {
            con.ConectarBasedeDatos();
            con.resultado = con.sentencia.executeQuery("SELECT * FROM usuarios WHERE usuario='" + usuario + "' AND clave=SHA('" + clave + "') AND status='1'");
            if (con.resultado.next()) {
                dato = con.resultado.getInt("id_user");
            }
            con.DesconectarBasedeDatos();
        } catch (SQLException e) {
            msg(e.getMessage());
        }
        return dato;
    }

    public Usuario llenarObejto(int idUser) {
        Usuario objeto = new Usuario();
        try {
            con.ConectarBasedeDatos();
            con.resultado = con.sentencia.executeQuery("SELECT us.usuario, us.rol, emp.*, genre.Genero FROM usuarios us INNER JOIN empleado emp ON us.id_user=emp.id_user INNER JOIN genero_user genre ON emp.id_genero=genre.id_genero WHERE emp.id_user='" + idUser + "' AND emp.status='1'");
            if (con.resultado.next()) {
                objeto.setIdUsuario(String.valueOf(idUser));
                objeto.setDNI(con.resultado.getString("DNI"));
                objeto.setNombres(con.resultado.getString("nombre"));
                objeto.setApellidos(con.resultado.getString("apellido"));
                objeto.setTelefono(con.resultado.getString("telefono"));
                objeto.setEdad(con.resultado.getString("edad"));
                objeto.setDireccion(con.resultado.getString("direccion"));
                objeto.setGenero(con.resultado.getString("Genero"));
                objeto.setEntradaFoto(con.resultado.getBlob("foto"));
                objeto.setCargo(con.resultado.getString("rol"));
                objeto.setUsuario(con.resultado.getString("usuario"));
            }

            con.DesconectarBasedeDatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return objeto;
    }

    public int[] permisos(int id) {
        int permisos[] = {0, 0, 0, 0};
        try {
            con.ConectarBasedeDatos();
            con.resultado = con.sentencia.executeQuery("SELECT * FROM permisos WHERE id_user='" + id + "' AND status='1'");
            if (con.resultado.next()) {
                permisos[0] = con.resultado.getInt("p_venta");
                permisos[1] = con.resultado.getInt("p_compra");
                permisos[2] = con.resultado.getInt("p_inventario");
                permisos[3] = con.resultado.getInt("p_usuarios");
            }
            con.DesconectarBasedeDatos();
        } catch (SQLException e) {
            msg(e.getMessage());
        }
        return permisos;
    }

    public void formatTD(TextField tf, int bt) { //metodo para validar la caja de texto telefono y DNI
        UnaryOperator<TextFormatter.Change> filter = change -> {
            if (change.isContentChange()) { //si hay cambios en la caja de texto
                handleBackspaceOverSpecialCharacter(change);
                if (change.getText().matches("[0-9]*")) { //si el texto capturado por el textformatter es igual a un valor numerico
                    int originalNewTextLength = change.getControlNewText().length();
                    change.setText(formatNumber(change.getControlNewText(), bt));
                    /*se le aplica el formato al texto y se guarda en la variable
                change el nuevo texto en la caja*/
                    change.setRange(0, change.getControlText().length());
                    int caretOffset = change.getControlNewText().length() - originalNewTextLength;
                    change.setCaretPosition(change.getCaretPosition() + caretOffset);
                    change.setAnchor(change.getAnchor() + caretOffset);
                    /*esto sirve para colocar el puntero en el ultimo digito y no permitir que se vayan arrastrando datos en la caja de
                texto*/
                    return change;
                } else {
                    return null;
                }
            }
            return change;
        };
        TextFormatter<String> formatter = new TextFormatter<>(filter);
        tf.setTextFormatter(formatter);
    }

    public void validaTexto(TextField tf, int longitud) { //Metodo para validar que solo se ingresen letras y espacios
        UnaryOperator<TextFormatter.Change> filter = change -> {
            if (change.getControlNewText().matches("[a-zA-Z ]*") && change.getControlNewText().length() <= longitud) {
                /*si el texto que se encuentra en la caja de texto es una letra o 
                un espacio devuelve ese texto*/
                return change;
            }
            return null; //si no no devuelve nada o sea no permite que se ingrese el valor tecleado
        };
        TextFormatter<String> formatter = new TextFormatter<>(filter);
        tf.setTextFormatter(formatter);
    }

    public void validaNumeros(TextField tf, int longitud) {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            if (change.getControlNewText().matches("[0-9]*") && change.getControlNewText().length() <= longitud) {
                /*si el texto que se encuentra en la caja de texto es un numero*/
                return change;
            }
            return null; //si no no devuelve nada o sea no permite que se ingrese el valor tecleado
        };
        TextFormatter<String> formatter = new TextFormatter<>(filter);
        tf.setTextFormatter(formatter);
    }

    //Metodo para validar la longitud en una caja de texto, asi se evita que el usuario ingrese un valor mayor al permitido en la bd
    public void manejaLongitudTxt(TextField tf, int longitud) {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            if (change.getControlNewText().length() <= longitud) {
                /*si la longitud del texto es menor a la longitud deseada por el usuario*/
                return change; //Permite escribir
            }
            return null; //si no no devuelve nada o sea no permite que se ingrese el valor tecleado
        };
        TextFormatter<String> formatter = new TextFormatter<>(filter);
        tf.setTextFormatter(formatter);
    }

    private void handleBackspaceOverSpecialCharacter(TextFormatter.Change change) {
        /*Este metodo permite borrar todos los valores de
        una caja de texto que use el metodo formatTD(), sin este metodo quedaria un numero y un guion que no se iban a poder eliminar*/
        if (change.isDeleted() && (change.getSelection().getLength() == 0)) {
            if (!Character.isDigit(change.getControlText().charAt(change.getRangeStart()))) {
                if (change.getRangeStart() > 0) {
                    change.setRange(change.getRangeStart() - 1, change.getRangeEnd() - 1);
                }
            }
        }
    }

    private String formatNumber(String numbers, int tb) { //metodo para darle formato a la caja de texto de telefono y DNI
        String nFmt = "", fNum = "";
        numbers = numbers.replaceAll("[^\\d]", ""); //Reemplaza cualquier valor que no sea un numero por un espacio en blanco

        if (tb == 1) {
            fNum = numbers.substring(0, Math.min(8, numbers.length()));
        } else {
            fNum = numbers.substring(0, Math.min(13, numbers.length()));
        };
        //Esto controla la cantidad de numeros que se pueden ingresar
        nFmt = fNum;
        if (nFmt.length() == 0) {
            return "";
        }
        if (tb == 1) {
            if (nFmt.length() < 5) {
                return nFmt + "-";
            }
            nFmt = nFmt.replaceFirst("(\\d{4})(\\d+)", "$1-$2");
            //si no hay coincidencias con los if statement
            //(\\d{4}) = valores que sean digitos y esten agrupados en un grupo de 4
            //(\\d+) = valores que sean digitos y se signa tecleando
            //$1 = el primer grupo definido dentro de los parentesis
            //- = el separador
            //$2 = el segundo grupo definido dentro de parentesis
        } else {
            if (nFmt.length() < 5) {
                return nFmt + "-";
            }
            if (nFmt.length() < 9) {
                return nFmt.replaceFirst("(\\d{4})(\\d+)", "$1-$2");
            }
            nFmt = nFmt.replaceFirst("(\\d{4})(\\d{4})(\\d+)", "$1-$2-$3");
        }
        return nFmt;
    }
}
