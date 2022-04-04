package modulos;

import Clases.funciones;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProyectoTiendaDeRopaFX extends Application{
    
    
    private funciones fun = new funciones();
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
        stage.setOnCloseRequest(event -> {
        fun.setIsStopped(true);
        });
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
