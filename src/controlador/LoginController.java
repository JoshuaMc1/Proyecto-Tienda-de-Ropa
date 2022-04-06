/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.clases.ConexionMySQL;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ConexionMySQL con = new ConexionMySQL();
        con.ConectarBasedeDatos();
    }

    @FXML
    private void click(ActionEvent event) {
        closeWindow();
        openWindow();
    }

    private void openWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/mainMenu.fxml"));
            Parent root = loader.load();
            MainMenuController controlador = loader.getController();
            
            Scene scene = new Scene(root);
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
}
