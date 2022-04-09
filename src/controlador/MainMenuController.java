/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.clases.Usuario;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.image.Image;
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
    private int permisos[];
    private int accesoCompras;
    
    //Objetos
    funciones fun = new funciones();
    Usuario usuario = new Usuario();
    
    @FXML
    private Pane pnlProfileUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("/vista/dashboard.fxml"));
            pnlPrincipal.getChildren().removeAll();
            pnlPrincipal.getChildren().setAll(fxml);
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    @FXML
    private void openDashboard(ActionEvent event) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("/vista/dashboard.fxml"));
            pnlPrincipal.getChildren().removeAll();
            pnlPrincipal.getChildren().setAll(fxml);
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    @FXML
    private void openInventory(ActionEvent event) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("/vista/inventory.fxml"));
            pnlPrincipal.getChildren().removeAll();
            pnlPrincipal.getChildren().setAll(fxml);
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    @FXML
    private void btnExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void openSales(ActionEvent event) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("/vista/sales.fxml"));
            pnlPrincipal.getChildren().removeAll();
            pnlPrincipal.getChildren().setAll(fxml);
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    @FXML
    private void openUsers(ActionEvent event) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("/vista/users.fxml"));
            pnlPrincipal.getChildren().removeAll();
            pnlPrincipal.getChildren().setAll(fxml);
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void recibirId(int id) {
        cargarObjeto(id);
    }

    private void cargarObjeto(int id) {
        try {
            usuario = fun.llenarObejto(id);
            txtUsuario.setText(usuario.getUsuario().toUpperCase());
            txtRol.setText(usuario.getCargo().toUpperCase());
            byte byteImage[] = null;
            byteImage = usuario.getEntradaFoto().getBytes(1, (int) usuario.getEntradaFoto().length());
            Image img = new Image(new ByteArrayInputStream(byteImage));
            imgFoto.setImage(img);
            
            this.permisos = fun.permisos(id);
            activarOpciones(permisos);
        } catch (SQLException ex) {
            fun.msg(ex.getMessage());
        }
    }

    private void activarOpciones(int permisos[]){
        if(permisos.length >= 4){
            if(permisos[0] == 1){
                btnVentas.setDisable(false);
            }else btnVentas.setDisable(true);
            
            this.accesoCompras = permisos[1];
            
            if(permisos[2] == 1){
                btnInventario.setDisable(false);
            }else btnInventario.setDisable(true);
            if(permisos[3] == 1){
                btnUsuarios.setDisable(false);
            }else btnUsuarios.setDisable(true);
        }else System.exit(0);
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
            UserProfileController controlador = loader.<UserProfileController>getController();
            controlador.cargarDatos(usuario);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("Perfil del usuario");
            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
