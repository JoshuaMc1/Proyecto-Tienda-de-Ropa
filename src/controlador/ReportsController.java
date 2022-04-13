/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
        
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * FXML Controller class
 *
 * @author Joshua Mc
 */
public class ReportsController implements Initializable {


    public static void main(String[] args){
           
    
            crearexcel();
        
    }



   

        public static void crearexcel() {
  Workbook book = new HSSFWorkbook();
 Sheet sheet = book.createSheet("REPORTES EXCEL");
 
        try {
            FileOutputStream fileout = new FileOutputStream("reporte.xls");
            book.write(fileout);
            fileout.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        
            
    
    
    
    
    }
        }
       
   
    
    @FXML
    private Button reporte;
    @FXML
    private Pane reporte2;
    
 
    
    
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
