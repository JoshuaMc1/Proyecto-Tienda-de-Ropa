/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos;

import clases.funciones;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javax.swing.JOptionPane;

public class PPrincipalController implements Initializable {

    private funciones fun = new funciones();
    private String opc []={"Si", "No"};//
    
    @FXML
    private StackPane paneCont;
    @FXML
    private Button btnUsu, btnVentas, btnCompra, btnInv, btnRepo, btnMM, btnCUsu, btnSalir;
    
    @FXML
    private void maPane(javafx.event.ActionEvent evt){
        fun.GroupController(paneCont, "prPane");
    }
    
    @FXML
    private void uPane(javafx.event.ActionEvent evt) {
        fun.GroupController(paneCont, "usPane");
    }
    
    @FXML
    private void vePane(javafx.event.ActionEvent evt){
        fun.GroupController(paneCont, "saPane");
    }
    
    @FXML
    private void coPane(javafx.event.ActionEvent evt){
        fun.GroupController(paneCont, "buPane");
    }
    
    @FXML
    private void inPane(javafx.event.ActionEvent evt){
        fun.GroupController(paneCont, "invPane");
    }
    
    @FXML
    private void rePane(javafx.event.ActionEvent evt){
        fun.GroupController(paneCont, "repPane");
    }
    
    @FXML
    private void chUsu(javafx.event.ActionEvent evt){
        fun.Msg("Trabajo en progreso");
    }
    
    @FXML
    private void exBtn(javafx.event.ActionEvent evt){
        int dec = JOptionPane.showOptionDialog(null,"Desea cerrar la aplicacion","Opciones",JOptionPane.YES_OPTION,JOptionPane.WARNING_MESSAGE,null,opc,opc[0]);
        if(dec == 0){
            //state = 1;
            System.exit(0);
        }
    }
    
    @FXML
    private void mouseU(javafx.event.Event evt){
        fun.Hover(btnUsu, 75, 112, 243, 255, 255, 255);
    }
    
    @FXML
    private void mouseUe(javafx.event.Event evt){
        fun.Hover(btnUsu, 255, 255, 255, 75, 69, 255);
    }
    
    @FXML
    private void mouseV(javafx.event.Event evt){
        fun.Hover(btnVentas, 75, 112, 243, 255, 255, 255);
    }
    
    @FXML
    private void mouseVe(javafx.event.Event evt){
        fun.Hover(btnVentas, 255, 255, 255, 75, 69, 255);
    }
    
    @FXML
    private void mouseC(javafx.event.Event evt){
        fun.Hover(btnCompra, 75, 112, 243, 255, 255, 255);
    }
    
    @FXML
    private void mouseCe(javafx.event.Event evt){
        fun.Hover(btnCompra, 255, 255, 255, 75, 69, 255);
    }
    
    @FXML
    private void mouseI(javafx.event.Event evt){
        fun.Hover(btnInv, 75, 112, 243, 255, 255, 255);
    }
    
    @FXML
    private void mouseIe(javafx.event.Event evt){
        fun.Hover(btnInv, 255, 255, 255, 75, 69, 255);
    }
    
    @FXML
    private void mouseR(javafx.event.Event evt){
        fun.Hover(btnRepo, 75, 112, 243, 255, 255, 255);
    }
    
    @FXML
    private void mouseRe(javafx.event.Event evt){
        fun.Hover(btnRepo, 255, 255, 255, 75, 69, 255);
    }
    
    @FXML
    private void mouseP(javafx.event.Event evt){
        fun.Hover(btnMM, 75, 112, 243, 255, 255, 255);
    }
    
    @FXML
    private void mousePe(javafx.event.Event evt){
        fun.Hover(btnMM, 255, 255, 255, 75, 69, 255);
    }
    
    @FXML
    private void mouseCU(javafx.event.Event evt){
        fun.Hover(btnCUsu, 75, 112, 243, 255, 255, 255);
    }
    
    @FXML
    private void mouseCUe(javafx.event.Event evt){
        fun.Hover(btnCUsu, 255, 255, 255, 75, 69, 255);
    }
    
    @FXML
    private void mouseS(javafx.event.Event evt){
        fun.Hover(btnSalir, 75, 112, 243, 255, 255, 255);
    }
    
    @FXML
    private void mouseSe(javafx.event.Event evt){
        fun.Hover(btnSalir, 255, 255, 255, 75, 69, 255);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
