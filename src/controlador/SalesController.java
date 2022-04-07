package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import modelo.ConexionMySQL;
import modelo.funciones.funciones;

public class SalesController implements Initializable {

    private funciones fun = new funciones();
    ConexionMySQL con = new ConexionMySQL(); //Variable que referencia a la clase que realiza la conexion a la bd
    private String bd = "tienda_de_ropa_2"; //nombre de la bd
    
    @FXML
    private Button btnAgProd;
    @FXML 
    private TextField txtIDProd, txtUser, txtDniCli, txtProdName, txtPrice, txtCant;
    @FXML
    private AnchorPane pnlPrinc;
    @FXML
    private ComboBox cmbCli; 
    
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
    
    @FXML
    private void AgrProd(ActionEvent evt){
        System.out.println(txtIDProd.getParent().getId());
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
