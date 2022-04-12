/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.clases.Fact_Model;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.table.DefaultTableModel;
import modelo.ConexionMySQL;

/**
 * FXML Controller class
 *
 * @author Joshua Mc
 */
public class UsersController implements Initializable {
      
 
    
    
    String cliente, vendedor, idPropiedad;
    @FXML
    private TextField txtDNI;
    @FXML
    private TextField txtnombre;
    @FXML
    private TextField txtapellido;
    @FXML
    private TextField txttelefono;
    @FXML
    private TextArea txtdireccion;
    @FXML
    private TextField txtedad;
    @FXML
    private ComboBox<?> cmbgenero;
    @FXML
    private Button btnguardar;
    @FXML
    private Button btneditar;
    @FXML
    private TextField txtusuario;
    @FXML
    private PasswordField txtcontra;
    @FXML
    private CheckBox chec1;
    @FXML
    private CheckBox chec2;
    @FXML
    private CheckBox chec4;
    @FXML
    private CheckBox chec3;
    @FXML
    private TableView<?> tbusuario;

    
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void clickGuardar(MouseEvent event) {
        System.out.print("Guardado");
    }
}
