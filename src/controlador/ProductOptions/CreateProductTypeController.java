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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.inventoryModel.tipoProducto;

/**
 * FXML Controller class
 *
 * @author Joshua Mc
 */
public class CreateProductTypeController implements Initializable {

    @FXML
    private AnchorPane typeWindow;
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
    private TableView<tipoProducto> tblDatos;
    @FXML
    private TableColumn<tipoProducto, Integer> col1;
    @FXML
    private TableColumn<tipoProducto, String> col2;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtTipo;
    private ObservableList<tipoProducto> tablaDato;
    tipoProducto tp = new tipoProducto();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarTabla();
    }    

    @FXML
    private void clickSalir(ActionEvent event) {
        stage = (Stage) typeWindow.getScene().getWindow();
        stage.close();
    }

    public void cargarTabla(){
        tablaDato = FXCollections.observableArrayList();
        tp.cargarDatos(tablaDato);
        tblDatos.setItems(tablaDato);
        col1.setCellValueFactory(new PropertyValueFactory<tipoProducto, Integer>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<tipoProducto, String>("tipo"));
        dato();
    }
    
    public void limpiar(){
        txtID.setText("");
        txtTipo.setText("");
    }
    
    public void dato(){
        tblDatos.getSelectionModel().selectedItemProperty().addListener(
        new ChangeListener<tipoProducto>(){
            @Override
            public void changed(ObservableValue<? extends tipoProducto> observable, tipoProducto oldValue, tipoProducto newValue) {
                txtID.setText(String.valueOf(newValue.getId()));
                txtTipo.setText(newValue.getTipo());
            }
            
        });
    }
    
    @FXML
    private void clickGuardar(ActionEvent event) {
        tipoProducto tp = new tipoProducto(0, txtTipo.getText());
        int rt = tp.guardar();
        if(rt == 1){
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Registro agregado");
            mensaje.setHeaderText("Guardado");
            mensaje.setContentText("Datos guardados exitosamente");
            mensaje.show();
            cargarTabla();
            limpiar();
        }else {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setHeaderText("Error al guardar");
            mensaje.setContentText("No se han guardado los datos");
            mensaje.show();
        }
    }

    @FXML
    private void clickEditar(ActionEvent event) {
        tipoProducto tp = new tipoProducto(Integer.parseInt(txtID.getText()), txtTipo.getText());
        int rt = tp.actualizar();
        if (rt == 1) {
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Registro modificado");
            mensaje.setHeaderText("Resultado:");
            mensaje.setContentText("Datos modificados exitosamente");
            mensaje.show();
            cargarTabla();
            limpiar();
        } else {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setHeaderText("Error al modificar");
            mensaje.setContentText("No se han modificado los datos");
            mensaje.show();
        }
    }

    @FXML
    private void clickEliminar(ActionEvent event) {
        tipoProducto tp = new tipoProducto(Integer.parseInt(txtID.getText()), txtTipo.getText());
        int rt = tp.eliminar();
        if (rt == 1) {
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Registro eliminado");
            mensaje.setHeaderText("Resultado:");
            mensaje.setContentText("Datoseliminados exitosamente");
            mensaje.show();
            cargarTabla();
            limpiar();
        } else {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setHeaderText("Error al eliminar");
            mensaje.setContentText("No se han eliminado los datos");
            mensaje.show();
        }
    }

    @FXML
    private void clickLimpiar(ActionEvent event) {
        limpiar();
    }
    
}
