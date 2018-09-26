/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.GUI;

import com.jfoenix.controls.JFXDatePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Imen
 */
public class FXMLModifierReservationHoteController implements Initializable {

    @FXML
    private Label label_res_modif1111;
    @FXML
    private ComboBox<String> input_ref_ajout_adulte;
    @FXML
    private ComboBox<String> input_ref_ajout_enfant;
    @FXML
    private Label label_modifvol;
    @FXML
    private Button button_ok;
    @FXML
    private Label carac_vol;
    @FXML
    private Label blasset_prix_total;
    @FXML
    private JFXDatePicker calendar_arriv;
    @FXML
    private JFXDatePicker calendar_sortie;
    @FXML
    private Label label_date_arr;
    @FXML
    private Label label_date_sortie;
    @FXML
    private Button the_ok_butt;
    @FXML
    private Button calcul_butt;
    @FXML
    private Label label_res_modif11111;
    @FXML
    private Label nbr_nuit_label;
    @FXML
    private Label input_nbr_nuit;
    @FXML
    private Label label_datejour1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
        
    }    

    @FXML
    private void on_click_button_ok(ActionEvent event) {
    }

    @FXML
    private void on_click_ok_butt(ActionEvent event) {
    }

    @FXML
    private void on_click_calcul_butt(ActionEvent event) {
    }
    
}
