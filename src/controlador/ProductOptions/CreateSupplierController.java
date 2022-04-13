/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ProductOptions;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.inventoryModel.proveedor;

/**
 * FXML Controller class
 *
 * @author Joshua Mc
 */
public class CreateSupplierController implements Initializable {

    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnLimpiar;
    @FXML
    private Button btnSalir;
    Stage stage = new Stage();

    @FXML
    private AnchorPane supplierWindow;
    @FXML
    private TableView<proveedor> tblProveedor;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextArea txtDireccion;
    private ObservableList<proveedor> tablaDato;
    @FXML
    private TableColumn<proveedor, Integer> col1;
    @FXML
    private TableColumn<proveedor, String> col2;
    @FXML
    private TableColumn<proveedor, String> col3;
    @FXML
    private TableColumn<proveedor, String> col4;
    @FXML
    private TableColumn<proveedor, String> col5;
    proveedor prv = new proveedor();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarTabla();
    }

    public void cargarTabla() {
        tablaDato = FXCollections.observableArrayList();
        prv.cargarDatos(tablaDato);
        tblProveedor.setItems(tablaDato);
        col1.setCellValueFactory(new PropertyValueFactory<proveedor, Integer>("idProveedor"));
        col2.setCellValueFactory(new PropertyValueFactory<proveedor, String>("nombreProveedor"));
        col3.setCellValueFactory(new PropertyValueFactory<proveedor, String>("telefono"));
        col4.setCellValueFactory(new PropertyValueFactory<proveedor, String>("correo"));
        col5.setCellValueFactory(new PropertyValueFactory<proveedor, String>("direccion"));
        dato();
    }

    public void limpiar() {
        txtID.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
    }

    public void dato() {
        tblProveedor.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<proveedor>() {
            @Override
            public void changed(ObservableValue<? extends proveedor> observable, proveedor oldValue, proveedor newValue) {
                if (newValue != null) {
                    txtID.setText(String.valueOf(newValue.getIdProveedor()));
                    txtNombre.setText(newValue.getNombreProveedor());
                    txtDireccion.setText(newValue.getDireccion());
                    txtTelefono.setText(newValue.getTelefono());
                    txtCorreo.setText(newValue.getCorreo());
                }
            }
        }
        );
    }

    @FXML
    private void clickSalir(ActionEvent event) {
        stage = (Stage) supplierWindow.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void clickGuardar(ActionEvent event) {
        proveedor p = new proveedor(0, txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText(), txtCorreo.getText());
        int rt = p.guardar();
        if (rt == 1) {
            Alert mensaje = new Alert(AlertType.INFORMATION);
            mensaje.setTitle("Registro agregado");
            mensaje.setHeaderText("Guardado");
            mensaje.setContentText("Datos guardados exitosamente");
            mensaje.show();
            cargarTabla();
            limpiar();
        } else {
            Alert mensaje = new Alert(AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setHeaderText("Error al guardar");
            mensaje.setContentText("No se han guardado los datos");
            mensaje.show();
        }
    }

    @FXML
    private void clickEditar(ActionEvent event) {
        proveedor p = new proveedor(Integer.parseInt(txtID.getText()), txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText(), txtCorreo.getText());
        int rt = p.actualizar();
        if (rt == 1) {
            Alert mensaje = new Alert(AlertType.INFORMATION);
            mensaje.setTitle("Registro modificado");
            mensaje.setHeaderText("Resultado:");
            mensaje.setContentText("Datos modificados exitosamente");
            mensaje.show();
            cargarTabla();
            limpiar();
        } else {
            Alert mensaje = new Alert(AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setHeaderText("Error al modificar");
            mensaje.setContentText("No se han modificado los datos");
            mensaje.show();
        }
    }

    @FXML
    private void clickEliminar(ActionEvent event) {
        proveedor p = new proveedor(Integer.parseInt(txtID.getText()), txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText(), txtCorreo.getText());
        int rt = p.eliminar();
        if (rt == 1) {
            Alert mensaje = new Alert(AlertType.INFORMATION);
            mensaje.setTitle("Registro eliminado");
            mensaje.setHeaderText("Resultado:");
            mensaje.setContentText("Datoseliminados exitosamente");
            mensaje.show();
            cargarTabla();
            limpiar();
        } else {
            Alert mensaje = new Alert(AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setHeaderText("Error al eliminar");
            mensaje.setContentText("No se han eliminado los datos");
            mensaje.show();
        }
    }

    @FXML
    private void clickLimpiar(ActionEvent event) {
        limpiar();
        cargarTabla();
    }

}
