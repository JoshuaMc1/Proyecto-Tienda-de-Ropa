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
import javafx.collections.FXCollections;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.ConexionMySQL;
import modelo.funciones.funciones;
import modelo.inventoryModel.product;

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
    @FXML
    private Tab tabCompra;
    @FXML
    private TextField txtIdProduct;
    @FXML
    private TextField txtIdLote;
    @FXML
    private TextField txtNombreProduct;
    @FXML
    private ComboBox<?> slcTipoProduct;
    @FXML
    private TextField txtTalla;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtCantidad;
    @FXML
    private TextField txtColor;
    @FXML
    private ComboBox<?> slcGenreProduct;
    @FXML
    private ComboBox<?> slcProveedor;
    @FXML
    private ComboBox<?> slcDescuento;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnClean;
    @FXML
    private TextField txtBuscarProduct;
    @FXML
    private TableView<product> tblDatosProduct;
    @FXML
    private AnchorPane pnlCompra;
    @FXML
    private ComboBox<?> slcMarca;
    @FXML
    private Button btnAgregarMarca;
    private ObservableList<product> tablaProd;
    ConexionMySQL con = new ConexionMySQL();
    @FXML
    private TableColumn<product, Integer> col1;
    @FXML
    private TableColumn<product, Integer> col2;
    @FXML
    private TableColumn<product, String> col3;
    @FXML
    private TableColumn<product, String> col4;
    @FXML
    private TableColumn<product, String> col5;
    @FXML
    private TableColumn<product, String> col6;
    @FXML
    private TableColumn<product, String> col7;
    @FXML
    private TableColumn<product, String> col8;
    @FXML
    private TableColumn<product, String> col9;
    @FXML
    private TableColumn<product, Double> col10;
    @FXML
    private TableColumn<product, Integer> col11;
    @FXML
    private TableColumn<product, Double> col12;
    
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
        cargarTabla();
    }
    
    public void cargarTabla(){
        tablaProd = FXCollections.observableArrayList();
        tablaProd = product.llenarTablaProductos(con);
        tblDatosProduct.setItems(tablaProd);
        
        col1.setCellValueFactory(new PropertyValueFactory<product, Integer>("idP"));
        col2.setCellValueFactory(new PropertyValueFactory<product, Integer>("idLote"));
        col3.setCellValueFactory(new PropertyValueFactory<product, String>("nombreP"));
        col4.setCellValueFactory(new PropertyValueFactory<product, String>("marca"));
        col5.setCellValueFactory(new PropertyValueFactory<product, String>("color"));
        col6.setCellValueFactory(new PropertyValueFactory<product, String>("talla"));
        col7.setCellValueFactory(new PropertyValueFactory<product, String>("tipoP"));
        col8.setCellValueFactory(new PropertyValueFactory<product, String>("generoP"));
        col9.setCellValueFactory(new PropertyValueFactory<product, String>("proveedor"));
        col10.setCellValueFactory(new PropertyValueFactory<product, Double>("precio"));
        col11.setCellValueFactory(new PropertyValueFactory<product, Integer>("cantidad"));
        col12.setCellValueFactory(new PropertyValueFactory<product, Double>("descuento"));
    }
    
    public void permisoCompra(int permiso){
        if(permiso == 1)tabCompra.setDisable(false);
        else tabCompra.setDisable(true);
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

    @FXML
    private void clickSave(ActionEvent event) {
        
    }

    @FXML
    private void clickDelete(ActionEvent event) {
    }

    @FXML
    private void clickEdit(ActionEvent event) {
    }

    @FXML
    private void clickClean(ActionEvent event) {
    }

    @FXML
    private void buscarKeyPressed(KeyEvent event) {
        
    }

    @FXML
    private void precioKP(KeyEvent event) {
        fun.validaNumeros(txtPrecio, 10000000);
    }

    @FXML
    private void cantidadKP(KeyEvent event) {
        fun.validaNumeros(txtCantidad, 10000000);
    }

    @FXML
    private void idLoteKP(KeyEvent event) {
        fun.validaNumeros(txtIdLote, 10000000);
    }

    @FXML
    private void abrirMarca(ActionEvent event) {
    }
}
