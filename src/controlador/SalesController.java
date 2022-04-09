    package controlador;

import controlador.clases.Fact_Model;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import modelo.ConexionMySQL;
import modelo.funciones.funciones;

public class SalesController implements Initializable {

    private funciones fun = new funciones();
    ConexionMySQL con = new ConexionMySQL(); //Variable que referencia a la clase que realiza la conexion a la bd
<<<<<<< HEAD
    private String bd = "tienda_de_ropa_2"; //nombre de la bd
    private ResultSet rs = null;
    ObservableList<Fact_Model> ol = FXCollections.observableArrayList();
=======
>>>>>>> 69710d595baaa8b97ccfe2e32717fb3e679834a7
    
    @FXML
    private Button btnAgProd;
    @FXML 
    private TextField txtIDProd, txtUser, txtDniCli, txtProdName, txtPrice, txtCant;
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
        try{
            String sql = "SELECT pr.descripcion, pr.precio, de.porcentaje, iv.n_lote from producto pr " +
                         " INNER JOIN inventario iv on 1 = iv.id_pdt " +
                         " INNER JOIN descuentos de on 1 = de.id_desc";
            rs = buscar(sql, con);
            while(rs.next()){
                System.out.println(rs.getString("descripcion") + " " + rs.getDouble("precio") + " " + rs.getDouble("porcentaje") + " " + rs.getInt("n_lote"));
                //ol.add(new Fact_Model("1", rs.getString("descripcion"), "1", "10", "0.0", "0.0", "1111"));
            }
            ol.add(new Fact_Model("1", "test", "1", "10", "0.0", "0.0", "1111"));
            
            col_IDProd.setCellValueFactory(new PropertyValueFactory<>("_id"));
            colDescr.setCellValueFactory(new PropertyValueFactory<>("descr"));
            colCant.setCellValueFactory(new PropertyValueFactory<>("cant"));
            colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
            colImp.setCellValueFactory(new PropertyValueFactory<>("isv"));
            colDesc.setCellValueFactory(new PropertyValueFactory<>("desc"));
            colLote.setCellValueFactory(new PropertyValueFactory<>("lote"));
            tblDet.setItems(ol);
            System.out.println(colCant.getCellData(0));
        }catch(Exception e){
            e.printStackTrace();
        }
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
    private void IDProdkpr(KeyEvent evt){
        fun.validaNumeros(txtIDProd, 100);
        request(evt, txtDniCli);
    }
    
    @FXML
    private void Cantkpr(KeyEvent evt){
        fun.validaNumeros(txtCant, 20);
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
