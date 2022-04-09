    package controlador;

import controlador.clases.Fact_Model;
import controlador.clases.Usuario;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import modelo.ConexionMySQL;
import modelo.funciones.funciones;

public class SalesController implements Initializable {

    private static String uID="";  
    private boolean suma = false;
    
    private funciones fun = new funciones();
    private Usuario usuario = new Usuario();
    ConexionMySQL con = new ConexionMySQL(); //Variable que referencia a la clase que realiza la conexion a la bd
    private String bd = "tienda_de_ropa_2"; //nombre de la bd
    private ResultSet rs = null;
    ObservableList<Fact_Model> ol = FXCollections.observableArrayList();
    private double precio= 0.0, subt=0.0,imp=0.0,tot=0.0,s_TotG=0.0, totG =0.0, impG=0.0, vImp=0.0, txt_price=0.0, st=0.0,
                   vDesc=0.0, desc = 0.0, descg=0.0;
    private int id;
    
    @FXML
    private Button btnAgProd;
    @FXML 
    private TextField txtIDProd, txtUser, txtDniCli, txtProdName, txtPrice, txtCant;
    @FXML
    private Label lblSTot, lblDesc, lblTotal;
    @FXML
    private AnchorPane pnlPrinc;
    @FXML
    private ComboBox cmbCli; 
    @FXML
    private TableView<Fact_Model> tblDet;
    @FXML
    private TableColumn<Fact_Model, String> col_IDProd;
    @FXML
    private TableColumn<Fact_Model, String> colDescr;
    @FXML
    private TableColumn<Fact_Model, String> colCant;
    @FXML
    private TableColumn<Fact_Model, String> colPrice;
    @FXML
    private TableColumn<Fact_Model, String> colImp;
    @FXML
    private TableColumn<Fact_Model, String> colDesc;
    @FXML
    private TableColumn<Fact_Model, String> colLote;
    
    private void fillCBox(){
        try{
            //String arr[] = {"1","2","3","4","5"};
            cmbCli.getItems().removeAll(cmbCli.getItems());
            //cmbCli.getItems().addAll(arr);
            cmbCli.getItems().addAll("Cliente Normal","Cliente Temporal");
            //cmbCli.getSelectionModel().select("1");
            cmbCli.getSelectionModel().select("Cliente Normal");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public double giveFormat(double val){
        String formt = String.format("%.2f", val);
        double finalD = Double.parseDouble(formt);
        return finalD;
    }
    
    private void verifyEnter(KeyEvent evt){
        if(evt.getCode() == KeyCode.ENTER){
            int n = 0;
            buscartxt(n);
        } 
    }
    
    private void calCant(KeyEvent evt){
        double _price=Double.parseDouble(txtPrice.getText());
       if(evt.getCode() == KeyCode.ENTER){
           if(suma)  _price += txt_price * Double.parseDouble(txtCant.getText());
           if(!suma){
               _price += txt_price * Double.parseDouble(txtCant.getText()) - _price;
               suma = true;
           }
            txtPrice.setText(Double.toString(_price));
        } 
    }
    
    private void request(KeyEvent evt, Node n1){
       if(evt.getCode() == KeyCode.ENTER){
            if(n1 instanceof TextField) n1.requestFocus();
            if(n1 instanceof Button) n1.requestFocus();
        } 
    }
    
    //metodo para limpiar las cajas de texto en un panel
    private void cleanTxt(AnchorPane ap, String txtName){ // El Pane es el panel en que se encuentran las cajas de texto
        //System.out.println(txtIDProd.getParent().toString());
        try{
            for(Node n1 : ap.getChildren()){ //se usa un ciclo foreach y se recorren todos los objetos hijos del panel
                //Node de javafx = Component de java.awt
                if (n1 instanceof TextField) { //si el nodo es un textfield se limpia
                    if(!n1.getId().equals(txtName)) //El unico txtfld que no se limpiara es el que muestra el id del usuario
                        ((TextField) n1).setText("");
               }
            }
        }catch(Exception e){
            
            fun.msg("Ha ocurrido un error: \n Por Favor contacte a soporte");
        }
    }    
    
    private void setCellValue(){
        col_IDProd.setCellValueFactory(new PropertyValueFactory<>("_id"));
        colDescr.setCellValueFactory(new PropertyValueFactory<>("descr"));
        colCant.setCellValueFactory(new PropertyValueFactory<>("cant"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colImp.setCellValueFactory(new PropertyValueFactory<>("isv"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("desc"));
        colLote.setCellValueFactory(new PropertyValueFactory<>("lote"));
    }
    
    private void agrProd(String sql){
        int cant = Integer.parseInt(txtCant.getText());
        int rc = tblDet.getItems().size();
        int exists = 0;
        try{
            if(!txtIDProd.getText().isEmpty() && !txtCant.getText().isEmpty() && !txtProdName.getText().isEmpty()){
                rs = buscar(sql, con);
                if(rs.next()){
                    if(rs.getInt("Existencias") > cant && cant > 0){
                        sum(rs.getDouble("porcentaje"));
                        if(rc > 0){
                            System.out.println("mayor");
                            for(int i=0;i<rc;i++){
                                if(txtIDProd.getText().equals(tblDet.getItems().get(i).get_id())){
                                    System.out.println("igual");
                                    exists = 1;
                                    System.out.println(tblDet.getItems().get(i).getCant().toString());
                                    int ct = Integer.parseInt(tblDet.getItems().get(i).getCant()) + cant;
                                    tblDet.getItems().get(i).setCant(Integer.toString(ct));
                                    System.out.println(tblDet.getItems().get(i).getCant().toString());
                                    exists=1;
                                }
                            }
                        }else if(exists == 0){
                            ol.add(new Fact_Model(usuario.getIdUsuario(), rs.getString("descripcion"), txtCant.getText(),
                            Double.toString(rs.getDouble("Precio")), "0.15", Double.toString(rs.getDouble("porcentaje")),
                            Integer.toString(rs.getInt("n_lote"))));
                            setCellValue();
                            tblDet.setItems(ol);
                        }
                    } else{
                        fun.msg("La cantidad de producto a facturar supera le existencia actual o su valor es 0");
                    }
                }
                rs = null;
                con.DesconectarBasedeDatos();
            }
        }catch(Exception e){fun.msg("Hubo un error¡¡¡ " + e + "\n favor contactar al administrador ");}
    }
    
    private void sum(double _desc){
        try{
            double stt = Double.parseDouble(txtPrice.getText());
            st = giveFormat(stt);
            vDesc = _desc;
            double desct = st * vDesc;
            desc = giveFormat(desct);
            vImp = 0.15;
            double impte = st * vImp;
            imp = giveFormat(impte);
            double tott = st + imp - desc;
            tot = giveFormat(tott);
            s_TotG += st;
            totG+=tot;
            impG+=imp;
            descg+=desc;
            lblDesc.setText("L. " + String.format("%.2f",descg));
            lblSTot.setText("L. " + String.format("%.2f",s_TotG));
            lblTotal.setText("L. " + String.format("%.2f",totG));
        }catch(Exception e){fun.msg("ERROR"+e);}
    }
    
    public void recibirId(int id) {
        cargarObjeto(id);
    }

    private void cargarObjeto(int id) {
        try {
            usuario = fun.llenarObejto(id);
            txtUser.setText(usuario.getIdUsuario());
        }catch(Exception ex) {
            fun.msg(ex.getMessage());
        }
    }
    
    public void buscartxt(int _id){
        _id = Integer.parseInt(txtIDProd.getText()); 
        String sql = "select p.descripcion, p.precio from producto p where p.id_pdt = '" + _id + "' && status = 1";
        try{
            rs = buscar(sql, con);
            if(rs.next()){
                txtProdName.setText(rs.getString("descripcion"));
                txtPrice.setText(Double.toString(rs.getDouble("precio")));
                txt_price = Double.parseDouble(txtPrice.getText());
            }
        }catch(Exception e){fun.msg("Hubo un error¡¡¡ " + e + "\n favor contactar al administrador ");}
    }
    
    public ResultSet buscar(String sql, ConexionMySQL con){
        try{
            con = new ConexionMySQL();
            con.ConectarBasedeDatos();
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    @FXML
    private void AgrProd(ActionEvent evt){
        String sql = "SELECT pr.descripcion, pr.precio, de.porcentaje, iv.n_lote, iv.existencias from producto pr " +
                         " INNER JOIN inventario iv on pr.id_pdt = iv.id_pdt " +
                         " INNER JOIN descuentos de on pr.id_desc = de.id_desc "
                        +" where pr.id_pdt = 1";
        agrProd(sql);
    }
    
    @FXML
    private void SaveBill(ActionEvent evt){
        
    }
    
    @FXML
    private void RemProd(ActionEvent evt){
        
    }
    
    @FXML
    private void clean(ActionEvent evt){
        cleanTxt(pnlPrinc, "txtUser");
    }
    
    @FXML
    private void busc(ActionEvent evt){
        int id=0;
        if(!txtIDProd.getText().isEmpty()){
            buscartxt(id);
        }
    }
    
    @FXML
    private void IDProdkpr(KeyEvent evt){
        fun.validaNumeros(txtIDProd, 100);
        verifyEnter(evt);
        request(evt, txtDniCli);
    }
    
    @FXML
    private void Cantkpr(KeyEvent evt){
        fun.validaNumeros(txtCant, 20);
        calCant(evt);
        request(evt, txtPrice);
    }
    
    @FXML
    private void dniCkpr(KeyEvent evt){
        fun.formatTD(txtDniCli, 2);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillCBox();
    }    
}
