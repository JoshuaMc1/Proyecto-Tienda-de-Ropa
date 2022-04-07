package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    private TextField txtIDProd;
    @FXML
    private AnchorPane pnlPrinc;
    
    //metodo para limpiar las cajas de texto en un panel
    private void cleanTxt(AnchorPane ap, String txtName){ // El Pane es el panel en que se encuentran las cajas de texto
        try{
            for(Node n1 : ap.getChildren()){ //se usa un ciclo foreach y se recorren todos los objetos hijos del panel
                //Node de javafx = Component de java.awt
                if (n1 instanceof TextField) { //si el nodo es un textfield se limpia
                    //if(!n1.getId().equals(txtName)) //El unico txtfld que no se limpiara es el que muestra el id del usuario
                        ((TextField) n1).setText("");
                        System.out.println(n1.getId().toString());
               }
            }
        }catch(Exception e){
            e.printStackTrace();
            /*fun.msg("Ha ocurrido un error: " + e + 
                "\n Por Favor contacte a soporte");*/
        }
    }    
    
    @FXML
    private void agrProd(ActionEvent evt){
        System.out.println(txtIDProd.getParent().getId());
    }
    
    @FXML
    private void saveFact(ActionEvent evt){
        
    }
    
    @FXML
    private void removeProd(ActionEvent evt){
        
    }
    
    @FXML
    private void cleanTxt(ActionEvent evt){
        cleanTxt(pnlPrinc, "txtIDUsr");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
