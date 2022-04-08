/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.ConexionMySQL;
import modelo.funciones.funciones;

/**
 * FXML Controller class
 *
 * @author Joshua Mc
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtClave;
    @FXML
    private Button btnIniciar;

    private Stage stage;
    @FXML
    private AnchorPane loginWindow;
    //Objetos
    funciones fun = new funciones();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ConexionMySQL con = new ConexionMySQL();
        con.ConectarBasedeDatos();
    }

    @FXML
    private void click() {
        int param = fun.validarInicio(txtUsuario.getText(), txtClave.getText());
        if(param != 0){
            JOptionPane.showMessageDialog(null, "A iniciado sesión exitosamente");
            closeWindow();
            openWindow(param);
        }else{
            JOptionPane.showMessageDialog(null, "Datos incorrectos","Error al iniciar sesión",2);
        }
    }

    private void openWindow(int id) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/mainMenu.fxml"));
            Parent root = loader.load();
            MainMenuController controlador = loader.<MainMenuController>getController();
            controlador.recibirId(id);
            Scene scene = new Scene(root);
            stage.setFullScreen(true);
            stage.setResizable(true);
            stage.setMaximized(true);
            stage.setTitle("Dashboard");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeWindow() {
        stage = (Stage) loginWindow.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void keyEnterUser(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            txtClave.requestFocus();
        }
    }

    @FXML
    private void keyEnterClave(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            btnIniciar.fire();
        }
    }
}
