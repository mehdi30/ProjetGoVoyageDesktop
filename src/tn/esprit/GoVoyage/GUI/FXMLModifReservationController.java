/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.GUI;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import tn.esprit.GoVoyage.entites.Clients;
import tn.esprit.GoVoyage.entites.Hebergement;
import tn.esprit.GoVoyage.entites.Vol;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLModifReservationController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    
    
//    
//    public void setApprenant(Apprenant apprenant) {
//        txtCin.setText(apprenant.getCin());
//        txtNom.setText(apprenant.getNom());
//        txtPrenom.setText(apprenant.getPrenom());
//        txtPassword.setText(apprenant.getPassword());
//        txtEmail.setText(apprenant.getEmail());
//        txtLogin.setText(apprenant.getLogin());
//        this.apprenant = apprenant;
//    }
//    
//    

    @FXML
    private void on_click_button_ok(ActionEvent event) {
    }

    void setList(int nbre_chbre_double, int nbre_chbre_single, int nombreAdultes, int nombreEnfants, float prixTotal, int nombreNuits, String date_sortie, String date_sortie0, String date_arrivee, Date date_res, Hebergement ref_hebergement_fk, Vol ref_vol_fk, Clients ref_client_fk, String type, int ref) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
