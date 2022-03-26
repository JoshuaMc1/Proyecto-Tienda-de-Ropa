/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos;

//import java.awt.Image;
import clases.funciones;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author carlo
 */
public class loginController implements Initializable {
    
    private funciones fun = new funciones();
    private Stage stage, stage2;
    
    @FXML
    private ImageView img;
    @FXML
    private Button btnIS;
    @FXML
    private Pane mainPane;
    
    public void ajustarImagen(String dir, ImageView lblImagen) {
        try{
            Image img = new Image(getClass().getResourceAsStream(dir), lblImagen.getFitWidth(), lblImagen.getFitHeight(), false, false);
            lblImagen.setImage(img);
        }catch(Exception e){
           e.printStackTrace();
        }
    }
    
    private void logout(){
        stage = (Stage) mainPane.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void iSesion(javafx.event.ActionEvent evt){
        try{
        Stage nStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("pPrincipal.fxml"));
        Scene scene = new Scene(root);
        nStage.setScene(scene);
        nStage.show();
        logout();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void mEn(javafx.event.Event evt){
        fun.Hover(btnIS, 143, 6, 22, 255, 255, 255);
    }
    
    @FXML
    private void mEx(javafx.event.Event evt){
        fun.Hover(btnIS, 255, 255, 255, 75, 69, 255);
    }    
    
    @FXML
    private Label label;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ajustarImagen("/imagenes/Fondo-login.jpg", img);
    }    
    
}
