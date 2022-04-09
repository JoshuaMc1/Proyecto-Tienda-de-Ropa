/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.clases.Usuario;
import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Joshua Mc
 */
public class UserProfileController implements Initializable {

    @FXML
    private Hyperlink txtGitJoshua;
    @FXML
    private Hyperlink txtGitYosary;
    @FXML
    private Hyperlink txtGitCarlos;
    @FXML
    private ImageView txtProfile;
    @FXML
    private TextField txtDNI;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtEdad;
    @FXML
    private ComboBox slcGenero;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtDireccion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        slcGenero.getItems().addAll("Seleccione una opción", "Masculino", "Femenino", "Indefinido");
    }

    public void cargarDatos(Usuario objeto) {
        try {
            txtNombre.setText(objeto.getNombres());
            txtApellido.setText(objeto.getApellidos());
            txtEdad.setText(objeto.getEdad());
            txtDireccion.setText(objeto.getDireccion());
            txtDNI.setText(objeto.getDNI());
            txtTelefono.setText(objeto.getTelefono());
            slcGenero.getSelectionModel().select(objeto.getGenero());
            byte byteImage[] = null;
            byteImage = objeto.getEntradaFoto().getBytes(1, (int) objeto.getEntradaFoto().length());
            Image img = new Image(new ByteArrayInputStream(byteImage));
            txtProfile.setImage(img);
        } catch (SQLException ex) {
            Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void openBrowser1(ActionEvent event) {
        try {
            Desktop.getDesktop().browse(new URL(txtGitJoshua.getText()).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openBrowser3(ActionEvent event) {
        try {
            Desktop.getDesktop().browse(new URL(txtGitYosary.getText()).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openBrowser2(ActionEvent event) {
        try {
            Desktop.getDesktop().browse(new URL(txtGitCarlos.getText()).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
