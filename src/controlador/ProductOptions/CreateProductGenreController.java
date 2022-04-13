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
import modelo.inventoryModel.generoProducto;

/**
 * FXML Controller class
 *
 * @author Joshua Mc
 */
public class CreateProductGenreController implements Initializable {

    @FXML
    private AnchorPane genreWindow;
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
    private TableView<generoProducto> tblDatos;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtGenero;
    @FXML
    private TableColumn<generoProducto, Integer> col1;
    @FXML
    private TableColumn<generoProducto, String> col2;
    private ObservableList<generoProducto> tablaDato;
    generoProducto gp = new generoProducto();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarTabla();
    }    

    public void cargarTabla(){
        tablaDato = FXCollections.observableArrayList();
        gp.cargarDatos(tablaDato);
        tblDatos.setItems(tablaDato);
        col1.setCellValueFactory(new PropertyValueFactory<generoProducto, Integer>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<generoProducto, String>("genero"));
        dato();
    }
    
    public void limpiar(){
        txtID.setText("");
        txtGenero.setText("");
    }
    
    public void dato(){
        tblDatos.getSelectionModel().selectedItemProperty().addListener(
        new ChangeListener<generoProducto>(){
            @Override
            public void changed(ObservableValue<? extends generoProducto> observable, generoProducto oldValue, generoProducto newValue) {
                txtID.setText(String.valueOf(newValue.getId()));
                txtGenero.setText(newValue.getGenero());
            }
            
        });
    }
    
    @FXML
    private void clickSalir(ActionEvent event) {
        stage = (Stage) genreWindow.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void clickGuardar(ActionEvent event) {
        generoProducto gps = new generoProducto(0, txtGenero.getText());
        int rt = gps.guardar();
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
        generoProducto gps = new generoProducto(Integer.parseInt(txtID.getText()), txtGenero.getText());
        int rt = gps.actualizar();
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
        generoProducto gps = new generoProducto(Integer.parseInt(txtID.getText()), txtGenero.getText());
        int rt = gps.eliminar();
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
