/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.clases.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.funciones.funciones;

/**
 * FXML Controller class
 *
 * @author Joshua Mc
 */
public class MainMenuController implements Initializable {

    @FXML
    private AnchorPane mainMenu;
    @FXML
    private BorderPane panelMenu;
    @FXML
    private ImageView imgFoto;
    @FXML
    private Label txtUsuario;
    @FXML
    private Label txtRol;
    @FXML
    private Button btnCerrar;
    @FXML
    private Button btnDasboard;
    @FXML
    private Button btnInventario;
    @FXML
    private Button btnVentas;
    @FXML
    private Button btnUsuarios;
    @FXML
    private Button btnReportes;
    @FXML
    
    //Variables extras
    private StackPane pnlPrincipal;
    private int idUser;
    
    //Objetos
    funciones fun = new funciones();
    @FXML
    private Pane pnlProfileUser;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("/vista/dashboard.fxml"));
            pnlPrincipal.getChildren().removeAll();
            pnlPrincipal.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e.getStackTrace());
        }
    }    

    @FXML
    private void openDashboard(ActionEvent event) {
        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("/vista/dashboard.fxml"));
            pnlPrincipal.getChildren().removeAll();
            pnlPrincipal.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e.getStackTrace());
        }
    }

    @FXML
    private void openInventory(ActionEvent event) {
        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("/vista/inventory.fxml"));
            pnlPrincipal.getChildren().removeAll();
            pnlPrincipal.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e.getStackTrace());
        }
    }

    @FXML
    private void btnExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void openSales(ActionEvent event) {
        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("/vista/sales.fxml"));
            pnlPrincipal.getChildren().removeAll();
            pnlPrincipal.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e.getStackTrace());
        }
    }

    @FXML
    private void openUsers(ActionEvent event) {
        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("/vista/users.fxml"));
            pnlPrincipal.getChildren().removeAll();
            pnlPrincipal.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e.getStackTrace());
        }
    }
    
    public void recibirId(int id){
        this.idUser = id;
    }
    
    private void cargarObjeto(int id){
        
    }
    

    @FXML
    private void openReports(ActionEvent event) {
    }

    @FXML
    private void openProfileModal(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/userProfile.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
