/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
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
