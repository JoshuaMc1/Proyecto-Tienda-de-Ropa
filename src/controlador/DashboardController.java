/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import modelo.funciones.funciones;

/**
 * FXML Controller class
 *
 * @author Joshua Mc
 */
public class DashboardController implements Initializable {

    @FXML
    private Label lblVentasHoy;
    @FXML
    private Label lblVentasSemana;
    @FXML
    private Label lblVentasMes;
    @FXML
    private BarChart<String, Double> grfTopVentas;
    @FXML
    private PieChart grfVentasUsuario;
    
    funciones fun = new funciones();
    @FXML
    private LineChart<String, Double> grfVentasPorMes;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblVentasHoy.setText(fun.totalVentasHoy());
        lblVentasMes.setText(fun.totalVentasMes());
        lblVentasSemana.setText(fun.totalVentasSemana());
        cargarGraficaVentasMes();
        cargarGraficoTopVentas();
        cargarGraficaTopUsuarios();
    }    
    
    public void cargarGraficoTopVentas(){
        ObservableList<PieChart.Data> data = fun.cargarGraficoVentasUsuario();
        grfVentasUsuario.setData(data);
        grfVentasUsuario.getData().forEach(this::installTooltip);
    }
    
    public void installTooltip(PieChart.Data d) {
        String msg = String.format("%s : %s", d.getName(), d.getPieValue());

        Tooltip tt = new Tooltip(msg);
        tt.setStyle("-fx-background-color: gray; -fx-text-fill: whitesmoke;");

        Tooltip.install(d.getNode(), tt);
    }
    
    public void cargarGraficaVentasMes(){
        ObservableList<XYChart.Series<String, Double>> lineChartData = FXCollections.observableArrayList();
        LineChart.Series<String, Double> series = fun.graficoVentasPorMes();
        series.setName("Grafico ventas por mes");
        lineChartData.add(series);
        grfVentasPorMes.setCreateSymbols(true);
        grfVentasPorMes.setData(lineChartData);
        grfVentasPorMes.createSymbolsProperty();
    }
    
    public void cargarGraficaTopUsuarios(){
        ObservableList<XYChart.Data<String, Double>> data = fun.topUsuariosVentas();
        XYChart.Series<String, Double> series = new XYChart.Series<>("Top 5 Usuarios con mas ventas", data);
        grfTopVentas.getData().setAll(series);
    }
}
