/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.clases.User_Model;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import modelo.ConexionMySQL;
import modelo.funciones.funciones;

public class UsersController implements Initializable {

    private ResultSet rs = null;
    private ConexionMySQL con = new ConexionMySQL();
    private funciones fun = new funciones();
    private ArrayList<Integer> permisos = new ArrayList<Integer>();
    private ArrayList<String> gen = new ArrayList<String>();
    private ObservableList<User_Model> ol = FXCollections.observableArrayList();
    private ObservableList<User_Model> ola = FXCollections.observableArrayList();
    private ObservableList<User_Model> olp = FXCollections.observableArrayList();
    private String path = "", perm = "", perm2 = "";
    private int idUsr = 0, prms = 0, prms2 = 0, ad = 0, de = 0, index, ad2 = 0;
    private boolean selec = false, selec2 = false;
    private String sent1 = "", sent2 = "", sent3 = "";
    private Connection cone = null;

    @FXML
    private ComboBox cmbGen;
    @FXML
    private TextField txtDNI, txtNombre, txtApellido, txtTelefono, txtEdad, txtUser;
    @FXML
    private TextField txtIDA, txtDNIA, txtNameA, txtApelA, txtUserA;
    @FXML
    private TextField txtIDP, txtUsuP;
    @FXML
    private TextArea txtDir;
    @FXML
    private ImageView lblFotoU;
    @FXML
    private PasswordField txtPass;
    @FXML
    private AnchorPane apu, apdu, apA;
    @FXML
    private TableView<User_Model> tblDat;
    @FXML
    private TableView<User_Model> tblUsuD;
    @FXML
    private TableView<User_Model> tblDatP;
    @FXML
    private TableColumn<User_Model, String> col_ID;
    @FXML
    private TableColumn<User_Model, String> col_NU;
    @FXML
    private TableColumn<User_Model, String> col_Rol;
    @FXML
    private TableColumn<User_Model, String> col_IDA;
    @FXML
    private TableColumn<User_Model, String> col_UNA;
    @FXML
    private TableColumn<User_Model, String> col_RolA;
    @FXML
    private TableColumn<User_Model, String> col_IDP;
    @FXML
    private TableColumn<User_Model, String> col_UsuP;
    @FXML
    private TableColumn<User_Model, String> col_RolP;
    @FXML
    private CheckBox chkV, chkC, chkI, chkU;
    @FXML
    private CheckBox chkVP, chkInvP, chkBP, chkUP;

    //metodo para verificar que todas las cajas de texto en un panel esten vacias
    private boolean Vacio(AnchorPane panel) {// panel en que se encuentran las cajas de texto y opcional una caja de texto que no se quiera
        boolean vacio = false;                         // verificar si esta vacia o no, solo se pone el id de la caja de texto
        for (Node jt : panel.getChildren()) { //foreach, recorre todos los componentes en el panel
            if (jt instanceof TextField) { //if un componente es un textfield
                if (((TextField) jt).getText().isEmpty()) { //if la caja de texto esta vacia o su nombre es similar al nombre de la caja de texto que no se quiere verificar
                    vacio = true;
                    break;
                }
            }
        }
        return vacio;
    }

    //Los valores que recibira cada columna
    private void setCellValue() {
        col_ID.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        col_NU.setCellValueFactory(new PropertyValueFactory<>("u_Name"));
        col_Rol.setCellValueFactory(new PropertyValueFactory<>("rol"));
    }

    private void setCellValueA() {
        col_IDA.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        col_UNA.setCellValueFactory(new PropertyValueFactory<>("u_Name"));
        col_RolA.setCellValueFactory(new PropertyValueFactory<>("rol"));
    }

    private void setCellValueP() {
        col_IDP.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        col_UsuP.setCellValueFactory(new PropertyValueFactory<>("u_Name"));
        col_RolP.setCellValueFactory(new PropertyValueFactory<>("rol"));
    }

    private void access() {
        if (chkV.isSelected() && !chkC.isSelected() && !chkI.isSelected() && !chkU.isSelected()) {
            perm = "Ventas";
            prms = 1;
        } else if (chkC.isSelected() && chkI.isSelected() && !chkU.isSelected() && !chkV.isSelected()) {
            perm = "Inventario";
            prms = 2;
        } else if (chkC.isSelected() && chkI.isSelected() && chkU.isSelected() && chkV.isSelected()) {
            perm = "Administrador";
            prms = 4;
        } else {
            perm = "";
            prms = 0;
        }
    }

    private void access2() {
        if (chkVP.isSelected() && !chkBP.isSelected() && !chkInvP.isSelected() && !chkUP.isSelected()) {
            perm2 = "Ventas";
            prms2 = 1;
        } else if (chkBP.isSelected() && chkInvP.isSelected() && !chkUP.isSelected() && !chkVP.isSelected()) {
            perm2 = "Inventario";
            prms2 = 2;
        } else if (chkBP.isSelected() && chkInvP.isSelected() && chkUP.isSelected() && chkVP.isSelected()) {
            perm2 = "Administrador";
            prms2 = 4;
        } else {
            perm2 = "";
            prms2 = 0;
        }
    }

    private void cargarGen() {
        try {
            String sql = "select g.id_genero, g.Genero from genero_user g where status = '1'";
            rs = buscar(sql, con);
            while (rs.next()) {
                gen.add(rs.getString("Genero"));
            }
            //se limpian todos los valores del combobox, se hace por precaucion
            cmbGen.getItems().removeAll(cmbGen.getItems());
            cmbGen.getItems().addAll(gen);
            //se le agregan los valores que se quieren mostrar en el combobox
            //se elije que valor aparecera seleccionado
            cmbGen.getSelectionModel().select(gen.get(0));
            con.DesconectarBasedeDatos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarTablaUsu() {
        String sql = "select id_user, usuario, rol from usuarios where status = '1'";
        try {
            rs = buscar(sql, con);
            while (rs.next()) {
                ol.add(new User_Model(Integer.toString(rs.getInt("id_user")), rs.getString("usuario"), rs.getString("rol")));
                setCellValue();
                tblDat.setItems(ol);
            }
        } catch (Exception e) {
            fun.msg("Hubo un error + " + e + " profavor contactar al administrador");
        }
        con.DesconectarBasedeDatos();
    }

    private void cargarTblUsuP() {
        String sql = "select id_user, usuario, rol from usuarios where status = '1'";
        try {
            rs = buscar(sql, con);
            while (rs.next()) {
                olp.add(new User_Model(Integer.toString(rs.getInt("id_user")), rs.getString("usuario"), rs.getString("rol")));
                setCellValueP();
                tblDatP.setItems(olp);
            }
        } catch (Exception e) {
            fun.msg("Hubo un error + " + e + " profavor contactar al administrador");
        }
        con.DesconectarBasedeDatos();
    }

    private void cargarTablaUsuA() {
        String sql = "select id_user, usuario, rol from usuarios where status = '2'";
        try {
            rs = buscar(sql, con);
            while (rs.next()) {
                ola.add(new User_Model(Integer.toString(rs.getInt("id_user")), rs.getString("usuario"), rs.getString("rol")));
                setCellValueA();
                tblUsuD.setItems(ola);
                System.out.println("foud");
            }
        } catch (Exception e) {
            fun.msg("Hubo un error + " + e + " profavor contactar al administrador");
        }
        con.DesconectarBasedeDatos();
    }

    private int cargarIDU() {
        int id = 0;
        String sql = "select id_user from usuarios where status='1'";
        try {
            rs = buscar(sql, con);
            if (rs.next()) {
                while (rs.next()) {
                    if (rs.isLast()) {
                        id = rs.getInt("id_user");
                    }
                }
            } else {
                id = 1;
            }
        } catch (Exception e) {
            fun.msg("Hubo un error + " + e + " profavor contactar al administrador");
        }
        con.DesconectarBasedeDatos();
        return id;
    }

    private int gen() {
        int gnr = 0;
        if (cmbGen.getSelectionModel().getSelectedItem().equals("Masculino")) {
            gnr = 1;
        }
        if (cmbGen.getSelectionModel().getSelectedItem().equals("Femenino")) {
            gnr = 2;
        }
        if (cmbGen.getSelectionModel().getSelectedItem().equals("Indefinido")) {
            gnr = 3;
        }
        return gnr;
    }

    private void verifPrms(int id, FileInputStream is, int gnr) {
        if (prms == 1) {
            sent3 = "insert into permisos (id_permiso,id_user,p_venta,p_compra,p_inventario,p_usuarios,status) values('0','" + id + "','1','0','0','0','1')";
            sent2 = "insert into empleado (id_info,id_user,nombre,apellido,DNI,telefono,edad,foto,direccion,id_genero,status) values"
                    + "('0','" + id + "','" + txtNombre.getText() + "','" + txtApellido.getText() + "','" + txtDNI.getText() + "','" + txtTelefono.getText() + "','" + txtEdad.getText() + "','"
                    + is + "','" + txtDir.getText() + "','" + gnr + "','1')";
        }
        if (prms == 2) {
            sent3 = "insert into permisos (id_permiso,id_user,p_venta,p_compra,p_inventario,p_usuarios,status) values('0','" + id + "','0','1','1','0','1')";
            sent2 = "insert into empleado (id_info,id_user,nombre,apellido,DNI,telefono,edad,foto,direccion,id_genero,status) values"
                    + "('0','" + id + "','" + txtNombre.getText() + "','" + txtApellido.getText() + "','" + txtDNI.getText() + "','" + txtTelefono.getText() + "','" + txtEdad.getText() + "','"
                    + is + "','" + txtDir.getText() + "','" + gnr + "','1')";
        }
        if (prms == 4) {
            sent3 = "insert into permisos (id_permiso,id_user,p_venta,p_compra,p_inventario,p_usuarios,status) values('0','" + id + "','1','1','1','1','1')";
            sent2 = "insert into empleado (id_info,id_user,nombre,apellido,DNI,telefono,edad,foto,direccion,id_genero,status) values"
                    + "('0','" + id + "','" + txtNombre.getText() + "','" + txtApellido.getText() + "','" + txtDNI.getText() + "','" + txtTelefono.getText() + "','" + txtEdad.getText() + "','"
                    + is + "','" + txtDir.getText() + "','" + gnr + "','1')";
        }
    }

    private void verifPrms2(int id) {
        if (prms == 1) {
            sent3 = "update permisos set p_venta = '1', p_compra='0', p_inventario='0', p_usuarios='0' where id_user = '" + id + "'";
            sent2 = "update usuarios set rol = 'Ventas' where id_user='" + id + "'";
        }
        if (prms == 2) {
            sent3 = "update permisos set p_venta = '0', p_compra='1', p_inventario='1', p_usuarios='0' where id_user = '" + id + "'";
            sent2 = "update usuarios set rol = 'Inventario' where id_user='" + id + "'";
        }
        if (prms == 4) {
            sent3 = "update permisos set p_venta = '1', p_compra='1', p_inventario='1', p_usuarios='1' where id_user = '" + id + "'";
            sent2 = "update usuarios set rol = 'Administrador' where id_user='" + id + "'";
        }
    }

    private void fillTxt() {
        if (tblDat.getItems().size() >= 0) {
            if (index >= 0) {
                int id = Integer.parseInt(tblDat.getItems().get(index).getId_user());
                String sql = "select e.nombre,e.apellido,e.DNI,e.telefono,e.edad,e.foto,e.direccion,e.id_genero, u.usuario,u.clave,u.rol "
                        + "from empleado e inner join usuarios u on e.id_user=u.id_user where u.id_user = '" + id + "'";
                try {
                    rs = buscar(sql, con);
                    if (rs.next()) {
                        txtDNI.setText(rs.getString("DNI"));
                        txtNombre.setText(rs.getString("nombre"));
                        txtApellido.setText(rs.getString("apellido"));
                        txtTelefono.setText(rs.getString("telefono"));
                        txtEdad.setText(Integer.toString(rs.getInt("edad")));
                        if (rs.getInt("id_genero") == 1) {
                            cmbGen.getSelectionModel().select(gen.get(0));
                        }
                        if (rs.getInt("id_genero") == 2) {
                            cmbGen.getSelectionModel().select(gen.get(1));
                        }
                        if (rs.getInt("id_genero") == 3) {
                            cmbGen.getSelectionModel().select(gen.get(2));
                        }
                        txtDir.setText(rs.getString("direccion"));
                        txtUser.setText(rs.getString("usuario"));
                        txtPass.setText(rs.getString("clave"));
                        if (rs.getString("rol").equals("Administrador")) {
                            chkC.setSelected(true);
                            chkI.setSelected(true);
                            chkU.setSelected(true);
                            chkV.setSelected(true);
                        }
                        if (rs.getString("rol").equals("Ventas")) {
                            chkV.setSelected(true);
                            chkC.setSelected(false);
                            chkI.setSelected(false);
                            chkU.setSelected(false);
                        }
                        if (rs.getString("rol").equals("Inventario")) {
                            chkI.setSelected(true);
                            chkC.setSelected(true);
                            chkU.setSelected(false);
                            chkV.setSelected(false);
                        }
                        InputStream is = rs.getBinaryStream("foto");
                        Image img = new Image(is);
                        lblFotoU.setImage(img);
                        con.DesconectarBasedeDatos();
                    }
                } catch (Exception e) {
                    fun.msg("Error");
                }
            }
        }
    }

    private void filltxtP() {
        if (tblDatP.getItems().size() >= 0) {
            if (index >= 0) {
                int id = Integer.parseInt(tblDatP.getItems().get(index).getId_user());
                String sql = "select usuario from usuarios  where id_user = '" + id + "'";
                try {
                    rs = buscar(sql, con);
                    if (rs.next()) {
                        txtIDP.setText(Integer.toString(id));
                        txtUsuP.setText(rs.getString("usuario"));
                    }
                } catch (Exception e) {
                    fun.msg("Error  " + e);
                    e.printStackTrace();
                }
            }
        }
    }

    private void filltxtA() {
        if (tblUsuD.getItems().size() >= 0) {
            if (index >= 0) {
                int id = Integer.parseInt(tblUsuD.getItems().get(index).getId_user());
                String sql = "select e.nombre,e.apellido,e.DNI, u.usuario,u.clave,u.rol "
                        + "from empleado e inner join usuarios u on e.id_user=u.id_user where u.id_user = '" + id + "'";
                try {
                    rs = buscar(sql, con);
                    if (rs.next()) {
                        txtIDA.setText(Integer.toString(id));
                        txtDNIA.setText(rs.getString("DNI"));
                        txtNameA.setText(rs.getString("nombre"));
                        txtApelA.setText(rs.getString("apellido"));
                        txtUserA.setText(rs.getString("usuario"));
                    }
                } catch (Exception e) {
                    fun.msg("Error");
                }
            }
        }
        con.DesconectarBasedeDatos();
    }

    private void modU() {
        int gnr = 0, id = 0;
        if (!Vacio(apu) && !Vacio(apdu)) {
            try {
                gnr = gen();
                if (index >= 0) {
                    id = Integer.parseInt(tblDat.getItems().get(index).getId_user());
                    sent1 = "update usuarios set usuario='" + txtUser.getText() + "', clave = SHA('" + txtPass.getText() + "') where id_user = '" + id + "'";
                    sent2 = "update empleado set nombre='" + txtNombre.getText() + "', apellido='" + txtApellido.getText()
                            + "', telefono='" + txtTelefono.getText() + "', edad='" + txtEdad.getText() + "', id_genero='" + gnr + "', direccion='" + txtDir.getText()
                            + "' where id_user='" + id + "'";
                    String ftu="";
                    if(!path.isEmpty()){
                        File file = new File(path);
                        FileInputStream is = new FileInputStream(file);
                        ftu = "update empleado set foto=? where id_user='" + id + "'";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        cone = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda_de_ropa", "root", "");
                        PreparedStatement pst = cone.prepareStatement(ftu);
                        pst.setBinaryStream(1, is, (int) file.length());
                        pst.executeUpdate();
                        cone.close();
                    }
                    fun.modificar(sent1);
                    fun.modificar(sent2);
                    fun.msg("Usuario modificado");
                    tblDat.getItems().clear();
                    cargarTablaUsu();
                    cleanTxt(apu, "", "");
                    cleanTxt(apdu, "", "");
                    lblFotoU.setImage(null);
                } else if (prms == 0) {
                    fun.msg("No ha seleccionado los permisos");
                }

            } catch (Exception e) {
                fun.msg("Hubo un error, " + e + " por favor contactar al administrador");
                e.printStackTrace();
            }
        } else {
            fun.msg("no pueden haber campos vacios y debe seleccionar una foto");
        }
    }

    private void delU() {
        if (tblDat.getItems().size() >= 0) {
            if (index >= 0) {
                String sql = "update usuarios set status = 2 where id_user = '" + tblDat.getItems().get(index).getId_user() + "' and status='1'";
                fun.eliminar(sql);
                fun.msg("Registro eliminado correctamente");
                tblDat.getItems().clear();
                cargarTablaUsu();
            } else {
                fun.msg("No hay un empleado seleccionado");
            }
        } else {
            fun.msg("No hay usuarios seleccionables");
        }

    }

    private void saveU() {
        int gnr = 0;
        if (!Vacio(apu) && !Vacio(apdu) && !path.isEmpty()) {
            try {
                gnr = gen();
                access();
                File file = new File(path);
                FileInputStream is = new FileInputStream(file);
                if (HasRTN(txtDNI.getText())) {
                    fun.msg("Ya hay un empleado con un DNI similar");
                } else {
                    if (prms != 0) {
                        if (prms == 1) {
                            sent1 = "insert into usuarios (id_user,usuario,clave,rol,status) values('0','" + txtUser.getText() + "',SHA('" + txtPass.getText() + "'),'Ventas','1')";
                        }

                        if (prms == 2) {
                            sent1 = "insert into usuarios (id_user,usuario,clave,rol,status) values('0','" + txtUser.getText() + "',SHA('" + txtPass.getText() + "'),'Inventario','1')";
                        }

                        if (prms == 4) {
                            sent1 = "insert into usuarios (id_user,usuario,clave,rol,status) values('0','" + txtUser.getText() + "',SHA('" + txtPass.getText() + "'),'Administrador','1')";
                        }

                        fun.guardar(sent1);
                        idUsr = cargarIDU();
                        verifPrms(idUsr, is, gnr);
                        fun.guardar(sent2);
                        fun.guardar(sent3);
                        fun.msg("Usuario creado");
                        tblDat.getItems().clear();
                        cargarTablaUsu();
                        cleanTxt(apu, "", "");
                        cleanTxt(apdu, "", "");
                    } else if (prms == 0) {
                        fun.msg("No ha seleccionado los permisos");
                    }
                }
            } catch (Exception e) {
                fun.msg("Hubo un error, " + e + " por favor contactar al administrador");
            }
        } else {
            fun.msg("no pueden haber campos vacios y debe seleccionar una foto");
        }
        path="";
    }

    private void actU() {
        int id = Integer.parseInt(txtIDA.getText());
        String sql = "update usuarios set status = '1' where id_user = '" + id + "' and status = '2'";
        try {
            fun.modificar(sql);
            fun.msg("Usuario activado");
            cleanTxt(apA, "", "");
            tblUsuD.getItems().clear();
            cargarTablaUsuA();
            cargarTablaUsu();
        } catch (Exception e) {
            fun.msg("ERROR");
        }
    }

    private ResultSet buscar(String sql, ConexionMySQL con) { //Metodo para realizar una consulta devuelve un ResultSet
        try {
            con.ConectarBasedeDatos();
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void cleanTxt(AnchorPane ap, String txtName, String txtName2) { // El Pane es el panel en que se encuentran las cajas de texto
        //System.out.println(txtIDProd.getParent().toString());
        try {
            for (Node n1 : ap.getChildren()) { //se usa un ciclo foreach y se recorren todos los objetos hijos del panel
                //Node de javafx = Component de java.awt
                if (n1 instanceof TextField) { //si el nodo es un textfield se limpia
                    if (!n1.getId().equals(txtName) && !n1.getId().equals(txtName2)) //El unico txtfld que no se limpiara es el que muestra el id del usuario
                    {
                        ((TextField) n1).setText("");
                    }
                }
                if (n1 instanceof TextArea) {
                    ((TextArea) n1).setText("");
                }
            }
        } catch (Exception e) {
            fun.msg("Ha ocurrido un error: \n Por Favor contacte a soporte");
        }
    }

    private boolean HasRTN(String cad) { //funcion para verificar si el RTN ingresado ya existe
        boolean has = false; // valor a devolver
        String last5 = ""; // String para capturar los ultimos 5 digitos de un RTN
        try {
            int l = cad.length(); //Se obtiene el tamaño del RTN
            for (int i = 0; i < l; i++) { // se recorre el RTN
                if (i > l - 6)// verificar que se esten recorriendo los ultimos 5 digitos del RTN
                {
                    last5 = last5 + cad.charAt(i); //Se carga el String con los ultimos 5 digitos del RTN
                }
            }

            String sql = "select * from empleado where DNI like '%" + last5 + "' and status = 1";//Se busca en la base de datos, con una sentencia like '%'
            rs = buscar(sql, con); //Para buscar los ultimos 5 digitos

            if (rs.next()) {
                has = true; //Si la consulta devuelve un valor has es true (si hay clientes con ese RTN)
            }
            return has;// si no devuelve false (no hay clientes con ese RTN)

        } catch (Exception e) {
            fun.msg("ERROR" + e);
        }
        con.DesconectarBasedeDatos();
        return has;
    }

    private void selRow(TableView tbl, int n) {
        if (tbl.getItems().size() >= 0) {
            if (tbl.getSelectionModel().getSelectedItem() != null) {
                index = tbl.getSelectionModel().getSelectedIndex();
                if (n == 1) {
                    fillTxt();
                }
                if (n == 2) {
                    filltxtA();
                }
                if (n == 3) {
                    filltxtP();
                }
            }
        }
    }

    @FXML
    private void dniKP(KeyEvent evt) {
        fun.formatTD(txtDNI, 2);
    }

    @FXML
    private void nameKP(KeyEvent evt) {
        fun.validaTexto(txtNombre, 30);
    }

    @FXML
    private void apelKP(KeyEvent evt) {
        fun.validaTexto(txtApellido, 30);
    }

    @FXML
    private void telKP(KeyEvent evt) {
        fun.formatTD(txtTelefono, 1);
    }

    @FXML
    private void dirKP(KeyEvent evt) {
        fun.manejaLongitudTxt(null, 30, txtDir);
    }

    @FXML
    private void ageKP(KeyEvent evt) {
        fun.validaNumeros(txtEdad, 3);
    }

    @FXML
    private void usuKP(KeyEvent evt) {
        fun.validaTexto(txtUser, 30);
    }

    @FXML
    private void passKP(KeyEvent evt) {
        fun.manejaLongitudTxt(txtPass, 20, null);
    }

    @FXML
    private void kprIDA(KeyEvent evt) {

    }

    @FXML
    private void kprDNIA(KeyEvent evt) {
        fun.formatTD(txtDNI, 2);
    }

    @FXML
    private void kprNameA(KeyEvent evt) {
        fun.validaTexto(txtNameA, 30);
    }

    @FXML
    private void kprApelA(KeyEvent evt) {
        fun.validaTexto(txtApelA, 30);
    }

    @FXML
    private void kprUsuA(KeyEvent evt) {
        fun.validaTexto(txtUserA, 30);
    }

    @FXML
    private void kprUP(KeyEvent evt) {
        fun.validaTexto(txtUsuP, 30);
    }

    @FXML
    private void kpIDP(KeyEvent evt) {
        fun.validaNumeros(txtIDP, 30);
    }

    @FXML
    private void tblMC(MouseEvent evt) {
        selRow(tblDat, 1);
    }

    @FXML
    private void mcP(MouseEvent evt) {
        selRow(tblDatP, 3);
    }

    @FXML
    private void vpA(ActionEvent evt) {
        if (ad == 0) {
            if (chkInvP.isSelected() || chkBP.isSelected()) {
                chkVP.setSelected(false);
                fun.msg("Debe deseleccionar las otras opciones, (Compra, Inventario)");
            }
        }
    }

    @FXML
    private void invA(ActionEvent evt) {
        if (ad2 == 0) {
            if (chkVP.isSelected()) {
                chkInvP.setSelected(false);
                fun.msg("Debe deseleccionar las otras opciones, (Ventas)");
            }
        }
    }

    @FXML
    private void bpA(ActionEvent evt) {
        if (ad2 == 0) {
            if (chkVP.isSelected()) {
                chkC.setSelected(false);
                fun.msg("Debe deseleccionar las otras opciones, (Ventas)");
            }
        }
    }

    @FXML
    private void upA(ActionEvent evt) {
        if (selec2) {
            chkUP.setSelected(true);
        }
        if (chkBP.isSelected() || chkInvP.isSelected() || chkVP.isSelected()) {
            if (!selec2) {
                fun.msg("Debe deseleccionar las otras opciones, (Compra, Venta, Inventario)" + 1);
                chkUP.setSelected(false);
                return;
            } else if (selec2) {
                fun.msg("Debe deseleccionar las otras opciones, (Compra, Venta, Inventario) antes de deseleccionar esta" + 2);
                return;
            }
        }
        if (chkUP.isSelected()) {
            if (!selec2) {
                ad2 = 1;
                selec2 = true;
            } else {
                if (!chkBP.isSelected() && !chkInvP.isSelected() && !chkVP.isSelected()) {
                    if (selec2) {
                        ad2 = 0;
                        selec2 = false;
                        chkUP.setSelected(false);
                    }
                }
            }
        }
    }

    @FXML
    private void actP(ActionEvent evt) {
        int id = Integer.parseInt(tblDatP.getItems().get(index).getId_user());
        if (!txtIDP.getText().isEmpty() && !txtUsuP.getText().isEmpty()) {
            access2();
            //verifPrms2(Integer.parseInt(tblDatP.getItems().get(index).getId_user()));
            if (prms2 == 1) {
                sent3 = "update permisos set p_venta = '1', p_compra='0', p_inventario='0', p_usuarios='0' where id_user = '" + id + "'";
                sent2 = "update usuarios set rol = 'Ventas' where id_user='" + id + "'";
            }
            if (prms2 == 2) {
                sent3 = "update permisos set p_venta = '0', p_compra='1', p_inventario='1', p_usuarios='0' where id_user = '" + id + "'";
                sent2 = "update usuarios set rol = 'Inventario' where id_user='" + id + "'";
            }
            if (prms2 == 4) {
                sent3 = "update permisos set p_venta = '1', p_compra='1', p_inventario='1', p_usuarios='1' where id_user = '" + id + "'";
                sent2 = "update usuarios set rol = 'Administrador' where id_user='" + id + "'";
            }
            fun.modificar(sent2);
            fun.modificar(sent3);
            fun.msg("Permisos Modificados");
            tblDatP.getItems().clear();
            tblDat.getItems().clear();
            cargarTblUsuP();
            cargarTablaUsu();
            txtIDP.setText("");
            txtUsuP.setText("");
        }
    }

    @FXML
    private void opFoto(ActionEvent evt) {
        path = fun.EscogerArchivo(lblFotoU);
    }

    @FXML
    private void save(ActionEvent evt) {
        saveU();
    }

    @FXML
    private void edit(ActionEvent evt) {
        modU();
    }

    @FXML
    private void del(ActionEvent evt) {
        delU();
    }

    @FXML
    private void clean(ActionEvent evt) {
        cleanTxt(apu, "", "");
        cleanTxt(apdu, "", "");
    }

    @FXML
    private void act(ActionEvent evt) {
        actU();
    }

    @FXML
    private void selU(ActionEvent evt) {
        if (selec) {
            chkU.setSelected(true);
        }
        if (chkC.isSelected() || chkI.isSelected() || chkV.isSelected()) {
            if (!selec) {
                fun.msg("Debe deseleccionar las otras opciones, (Compra, Venta, Inventario)" + 1);
                chkU.setSelected(false);
                return;
            } else if (selec) {
                fun.msg("Debe deseleccionar las otras opciones, (Compra, Venta, Inventario) antes de deseleccionar esta" + 2);
                return;
            }
        }
        if (chkU.isSelected()) {
            if (!selec) {
                ad = 1;
                selec = true;
            } else {
                if (!chkC.isSelected() && !chkI.isSelected() && !chkV.isSelected()) {
                    if (selec) {
                        ad = 0;
                        selec = false;
                        chkU.setSelected(false);
                    }
                }
            }
        }
    }

    @FXML
    private void selV(ActionEvent evt) {
        if (ad == 0) {
            if (chkI.isSelected() || chkC.isSelected()) {
                chkV.setSelected(false);
                fun.msg("Debe deseleccionar las otras opciones, (Compra, Inventario)");
            }
        }
    }

    @FXML
    private void selC(ActionEvent evt) {
        if (ad == 0) {
            if (chkV.isSelected()) {
                chkC.setSelected(false);
                fun.msg("Debe deseleccionar las otras opciones, (Ventas)");
            }
        }
    }

    @FXML
    private void tblASel(MouseEvent evt) {
        selRow(tblUsuD, 2);
    }

    @FXML
    private void selInv(ActionEvent evt) {
        if (ad == 0) {
            if (chkV.isSelected()) {
                chkI.setSelected(false);
                fun.msg("Debe deseleccionar las otras opciones, (Ventas)");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarGen();
        cargarTablaUsu();
        cargarTablaUsuA();
        cargarTblUsuP();
    }
}
