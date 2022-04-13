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
import modelo.inventoryModel.marca;

/**
 * FXML Controller class
 *
 * @author JoshuaMc
 */
public class MarcaController implements Initializable {

    @FXML
    private TableView<marca> tblDatos;
    @FXML
    private TableColumn<marca, Integer> col1;
    @FXML
    private TableColumn<marca, String> col2;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtMarca;
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
    private ObservableList<marca> tablaDato;
    marca mc = new marca();
    Stage stage = new Stage();
    @FXML
    private AnchorPane marcaWindow;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarTabla();
    }    
    
    public void cargarTabla(){
        tablaDato = FXCollections.observableArrayList();
        mc.cargarDatos(tablaDato);
        tblDatos.setItems(tablaDato);
        col1.setCellValueFactory(new PropertyValueFactory<marca, Integer>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<marca, String>("nombre"));
        dato();
    }
    
    public void limpiar(){
        txtID.setText("");
        txtMarca.setText("");
    }
    
    public void dato(){
        tblDatos.getSelectionModel().selectedItemProperty().addListener(
        new ChangeListener<marca>(){
            @Override
            public void changed(ObservableValue<? extends marca> observable, marca oldValue, marca newValue) {
                txtID.setText(String.valueOf(newValue.getId()));
                txtMarca.setText(newValue.getNombre());
            }
            
        });
    }
    
    @FXML
    private void clickGuardar(ActionEvent event) {
        marca mr = new marca(0, txtMarca.getText());
        int rt = mr.guardar();
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
        marca mr = new marca(Integer.parseInt(txtID.getText()), txtMarca.getText());
        int rt = mr.actualizar();
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
        marca mr = new marca(Integer.parseInt(txtID.getText()), txtMarca.getText());
        int rt = mr.eliminar();
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

    @FXML
    private void clickSalir(ActionEvent event) {
        stage = (Stage) marcaWindow.getScene().getWindow();
        stage.close();
    }
    
}
