/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import tn.esprit.GoVoyage.services.VolService;


/**
 * FXML Controller class
 *
 * @author Mehdi Chaabene
 */
public class VolStatsController implements Initializable {

    @FXML
    private ImageView imgv;
    @FXML
    private BarChart<String, Number> barchart;
    @FXML
    private Label avg;
    final NumberAxis xAxis = new NumberAxis();
    final CategoryAxis yAxis = new CategoryAxis();
    @FXML
    private Button Fermerr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO  
        VolService v = new VolService();
        int m1 = v.caluclNum("allerSimple").size();
        int m2 = v.caluclNum("AllerRetour").size();
        
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Aller Simple");
        series1.getData().add(new XYChart.Data("0,10",m1));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Aller-Retour");
        series2.getData().add(new XYChart.Data("0,10",m2));
        
        				        barchart.getData().addAll(series1,series2);
				      // barchart.setBackground(Background.EMPTY);
				        barchart.setTitle("Vol Number par type");
				        barchart.setStyle("-fx-background-color: transparent;");
				        


    }

    @FXML
    private void FermerStats(ActionEvent event) throws IOException {
        Stage primaryStage =(Stage) Fermerr.getScene().getWindow();
        
        
        primaryStage.close();


    }

}
