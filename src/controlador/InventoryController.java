/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.funciones.funciones;

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
    @FXML
    private Label lblTotalInv;
    @FXML
    private Label lblCantidadInv;
    @FXML
    private Label lblProductoBajo;
    funciones fun = new funciones();
    @FXML
    private BarChart<String, Number> grfCantidadInvBajo;
    @FXML
    private NumberAxis navExistencias;
    @FXML
    private CategoryAxis navProducto;
    @FXML
    private PieChart grfContidadProductoPorMarcas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarTooltip();
        cargarTotalInventario();
        cargarCantidadInventario();
        cargarProductoBajo();
        cargarGraficoInvBajo();
        cargarGraficoProductoPorMarca();
    }

    public void cargarTooltip() {
        btnAgregarTipoProducto.setTooltip(new Tooltip("Agregar nuevo tipo de producto"));
        btnAgregarGenero.setTooltip(new Tooltip("Agregar un nuevo genero a los productos"));
        btnAgregarProveedor.setTooltip(new Tooltip("Agregar un nuevo proveedor"));
        btnAgregarDescuento.setTooltip(new Tooltip("Agregar un nuevo descuento"));
    }

    public void cargarTotalInventario() {
        lblTotalInv.setText(fun.totalInventario());
    }

    public void cargarCantidadInventario() {
        lblCantidadInv.setText(fun.catidadInventario());
    }

    public void cargarProductoBajo() {
        lblProductoBajo.setText(fun.catidadInventarioBajo());
    }

    public void cargarGraficoInvBajo() {
        ObservableList<XYChart.Data<String, Number>> data = fun.datosGrafico1Inventario();
        XYChart.Series<String, Number> series = new XYChart.Series<>("Productos con inventario bajo", data);
        grfCantidadInvBajo.getData().setAll(series);
    }

    public void cargarGraficoProductoPorMarca() {
        ObservableList<PieChart.Data> data = fun.datosGrafico2Inventario();
        grfContidadProductoPorMarcas.setData(data);
        grfContidadProductoPorMarcas.getData().forEach(this::installTooltip);
    }

    public void installTooltip(PieChart.Data d) {
        String msg = String.format("%s : %s", d.getName(), d.getPieValue());

        Tooltip tt = new Tooltip(msg);
        tt.setStyle("-fx-background-color: gray; -fx-text-fill: whitesmoke;");

        Tooltip.install(d.getNode(), tt);
    }

    @FXML
    private void abrirTipoProducto(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ProductOptions/createProductType.fxml"));
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

    @FXML
    private void abrirGeneroProducto(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ProductOptions/createProductGenre.fxml"));
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

    @FXML
    private void abrirProveedor(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ProductOptions/createSupplier.fxml"));
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

    @FXML
    private void abrirDescuento(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ProductOptions/createDiscount.fxml"));
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
