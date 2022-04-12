/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.clases.User_Model;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import modelo.ConexionMySQL;
import modelo.funciones.funciones;

public class UsersController implements Initializable {

    private ResultSet rs=null;
    private ConexionMySQL con=new ConexionMySQL();
    private funciones fun =  new funciones();
    private ArrayList<Integer> permisos = new ArrayList<Integer>();
    private ArrayList<String> gen = new ArrayList<String>();
    private ObservableList<User_Model> ol = FXCollections.observableArrayList();
    private String path="", perm="";
    private int idUsr=0, prms=0, ad=0, de=0;
    private boolean selec=false;
    
    @FXML
    private ComboBox cmbGen;
    @FXML
    private TextField txtDNI, txtNombre, txtApellido, txtTelefono, txtEdad,txtUser;
    @FXML
    private TextArea txtDir;
    @FXML
    private ImageView lblFotoU;
    @FXML
    private PasswordField txtPass;
    @FXML
    private AnchorPane apu, apdu;
    @FXML
    private TableView<User_Model> tblDat;
    @FXML
    private TableColumn<User_Model, String> col_ID;
    @FXML
    private TableColumn<User_Model, String> col_NU;
    @FXML
    private TableColumn<User_Model, String> col_Rol;
    @FXML
    private CheckBox chkV, chkC, chkI, chkU;
    
    
    //metodo para verificar que todas las cajas de texto en un panel esten vacias
    private boolean Vacio(AnchorPane panel){// panel en que se encuentran las cajas de texto y opcional una caja de texto que no se quiera
        boolean vacio = false;                         // verificar si esta vacia o no, solo se pone el id de la caja de texto
        for(Node jt : panel.getChildren()){ //foreach, recorre todos los componentes en el panel
            if(jt instanceof TextField){ //if un componente es un textfield
                if(((TextField) jt).getText().isEmpty()){ //if la caja de texto esta vacia o su nombre es similar al nombre de la caja de texto que no se quiere verificar
                    vacio=true;
                    break; 
                }
            }
        }
        return vacio;
    }
    
    //Los valores que recibira cada columna
    private void setCellValue(){
        col_ID.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        col_NU.setCellValueFactory(new PropertyValueFactory<>("u_Name"));
        col_Rol.setCellValueFactory(new PropertyValueFactory<>("rol"));
    }
    
    private void access(){
        if(chkV.isSelected()){
            perm="Ventas";
            prms=1;
        }
        if(chkC.isSelected() && chkI.isSelected()){
            perm="Inventario";
            prms=2;
        }
        if(chkC.isSelected() && chkI.isSelected() && chkU.isSelected() && chkV.isSelected()){
            perm="Administrador";
            prms=4;
        }
    }
    
    private void cargarGen(){
        try{
            String sql = "select g.id_genero, g.Genero from genero_user g where status = '1'";
            rs = buscar(sql, con);
            while(rs.next()){
                gen.add(rs.getString("Genero"));
            }
            //se limpian todos los valores del combobox, se hace por precaucion
            cmbGen.getItems().removeAll(cmbGen.getItems());
            cmbGen.getItems().addAll(gen);
            //se le agregan los valores que se quieren mostrar en el combobox
            //se elije que valor aparecera seleccionado
            cmbGen.getSelectionModel().select(gen.get(0));
            con.DesconectarBasedeDatos();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void cargarTablaUsu(){
        String sql = "select id_user, usuario, rol from usuarios where status = '1'";
        try{
            rs = buscar(sql, con);
            while(rs.next()){
                ol.add(new User_Model(Integer.toString(rs.getInt("id_user")), rs.getString("usuario"), rs.getString("rol")));
                setCellValue();
                tblDat.setItems(ol);
            }
        }catch(Exception e){
            fun.msg("Hubo un error + " + e + " profavor contactar al administrador");
        }
    }
    
    private int cargarIDU(){
        int id=0;
        String sql  = "select id_user from usuarios where status='1'";
        try{
            rs = buscar(sql, con);
            if(rs.next()){
                while(rs.next()){
                    if(rs.isLast()){
                        id = rs.getInt("id_user") + 1;
                    }
                }
            } else id = 1;
        }catch(Exception e){fun.msg("Hubo un error + " + e + " profavor contactar al administrador");}
        return id;
    }
    
    private int gen(){
        int gnr = 0;
        if(cmbGen.getSelectionModel().getSelectedItem().equals("Masculino")) gnr=1;
        if(cmbGen.getSelectionModel().getSelectedItem().equals("Femenino")) gnr=2;
        if(cmbGen.getSelectionModel().getSelectedItem().equals("Indefinido")) gnr=3;
        return gnr;
    }
    
    private void saveU(){
        int gnr=0;
        if(!Vacio(apu) && !Vacio(apdu) && !path.isEmpty()){
            try{
                gnr = gen();
                File file = new File(path);
                FileInputStream is = new FileInputStream(file);
                String sent1 = "insert into usuarios (id_user,usuario,clave,rol,status) values('0','"+txtUser.getText()+"',SHA('"+txtPass.getText()+"'),'Administrador','1')";
                String sent2 = "insert into empleado (id_info,id_user,nombre,apellido,DNI,telefono,edad,foto,direccion,id_genero,status) values" +
                           "('0','" + idUsr +"','"+txtNombre.getText()+"','"+txtApellido.getText()+"','"+txtDNI.getText()+"','"+txtTelefono.getText()+"','"+txtEdad.getText()+"','"+
                           is+"','"+ txtDir.getText()+"','" +gnr+"','1')";
                System.out.println(sent1);
                System.out.println(sent2);
                System.out.println(perm);
                System.out.println(prms);
               /* fun.guardar(sent1);
                fun.guardar(sent2);*/
            }catch(Exception e){
                fun.msg("Hubo un error, " +e+" por favor contactar al administrador");
            }
        }else fun.msg("no pueden haber campos vacios y debe seleccionar una foto");
    }
    
    private ResultSet buscar(String sql, ConexionMySQL con){ //Metodo para realizar una consulta devuelve un ResultSet
        try{
            con.ConectarBasedeDatos();
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    private void cleanTxt(AnchorPane ap, String txtName, String txtName2){ // El Pane es el panel en que se encuentran las cajas de texto
        //System.out.println(txtIDProd.getParent().toString());
        try{
            for(Node n1 : ap.getChildren()){ //se usa un ciclo foreach y se recorren todos los objetos hijos del panel
                //Node de javafx = Component de java.awt
                if (n1 instanceof TextField) { //si el nodo es un textfield se limpia
                    if(!n1.getId().equals(txtName) && !n1.getId().equals(txtName2)) //El unico txtfld que no se limpiara es el que muestra el id del usuario
                        ((TextField) n1).setText("");
               }
                if(n1 instanceof TextArea)
                    ((TextArea)n1).setText("");
            }
        }catch(Exception e){   fun.msg("Ha ocurrido un error: \n Por Favor contacte a soporte");}
    }
    
    private void selRow(){
        /*if(tblDet.getItems().size() > 0)
            if(tblDet.getSelectionModel().getSelectedItem() != null){
                fm = tblDet.getSelectionModel().getSelectedItem();
                fmIndex = tblDet.getSelectionModel().getSelectedIndex();
            }*/
    }
    
    @FXML
    private void dniKP(KeyEvent evt){
        fun.formatTD(txtDNI, 2);
    }
    
    @FXML
    private void nameKP(KeyEvent evt){
        fun.validaTexto(txtNombre, 30);
    }
    
    @FXML
    private void apelKP(KeyEvent evt){
        fun.validaTexto(txtApellido, 30);
    }
    
    @FXML
    private void telKP(KeyEvent evt){
        fun.formatTD(txtTelefono, 1);
    }
    
    @FXML
    private void dirKP(KeyEvent evt){
        fun.manejaLongitudTxt(null, 30, txtDir);
    }
    
    @FXML
    private void ageKP(KeyEvent evt){
        fun.validaNumeros(txtEdad, 3);
    }
    
    @FXML
    private void usuKP(KeyEvent evt){
        fun.validaTexto(txtUser, 30);
    }
    
    @FXML
    private void passKP(KeyEvent evt){
        fun.manejaLongitudTxt(txtPass, 20, null);
    }
    
    @FXML
    private void tblMC(MouseEvent evt){
        selRow();
    } 
    
    @FXML
    private void opFoto(ActionEvent evt){
        path=fun.EscogerArchivo(lblFotoU);
        System.out.println(path);
    }
    
    @FXML
    private void save(ActionEvent evt){
        saveU();
    }
    
    @FXML
    private void edit(ActionEvent evt){
        
    }
    
    @FXML
    private void del(ActionEvent evt){
        
    }
    
    @FXML
    private void clean(ActionEvent evt){
        cleanTxt(apu, "", "");
        cleanTxt(apdu, "", "");
    }
    
    @FXML
    private void selU(ActionEvent evt){
        if(selec) chkU.setSelected(true);
        if(chkC.isSelected() || chkI.isSelected() || chkV.isSelected()){
            if(!selec){
                fun.msg("Debe deseleccionar las otras opciones, (Compra, Venta, Inventario)"+1);
                chkU.setSelected(false);
                return;
            }else if(selec){
                fun.msg("Debe deseleccionar las otras opciones, (Compra, Venta, Inventario) antes de deseleccionar esta"+2);
                return;
            }
        }
        if(chkU.isSelected()){
            if(!selec){
                ad=1;
                selec=true;
            } else{
                if(!chkC.isSelected() && !chkI.isSelected() && !chkV.isSelected()){
                    if(selec){
                        ad=0;
                        selec=false;
                        chkU.setSelected(false);
                    }
                }
            }
        }
    }
    
    @FXML
    private void selV(ActionEvent evt){
        if(ad==0)
        if(chkI.isSelected() || chkC.isSelected()){
            chkV.setSelected(false);
            fun.msg("Debe deseleccionar las otras opciones, (Compra, Inventario)");
        }
    }
    
    @FXML
    private void selC(ActionEvent evt){
        if(ad==0)
        if(chkV.isSelected()){
            chkC.setSelected(false);
            fun.msg("Debe deseleccionar las otras opciones, (Ventas)");
        }
    }
    
    @FXML
    private void selInv(ActionEvent evt){
        if(ad==0)
        if(chkV.isSelected()){
            chkI.setSelected(false);
            fun.msg("Debe deseleccionar las otras opciones, (Ventas)");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarGen();
        cargarTablaUsu();
        idUsr = cargarIDU();
    }    
}
