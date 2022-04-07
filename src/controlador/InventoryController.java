/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

/**
 * FXML Controller class
 *
 * @author Joshua Mc
 */
public class InventoryController implements Initializable {

    @FXML
    private Button btnAgregarTipoProducto;
    @FXML
    private Button btnAgregarGenero;
    @FXML
    private Button btnAgregarProveedor;
    @FXML
    private Button btnAgregarDescuento;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnAgregarTipoProducto.setTooltip(new Tooltip("Agregar nuevo tipo de producto"));
        btnAgregarGenero.setTooltip(new Tooltip("Agregar un nuevo genero a los productos"));
        btnAgregarProveedor.setTooltip(new Tooltip("Agregar un nuevo proveedor"));
        btnAgregarDescuento.setTooltip(new Tooltip("Agregar un nuevo descuento"));
    }    
    
}
