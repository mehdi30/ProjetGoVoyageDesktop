/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.GUI;

import com.jfoenix.controls.JFXDatePicker;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Imen
 */
public class FXMLModifReservationHotelController implements Initializable {

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
    private ComboBox<String> combo_chbre_single;
    @FXML
    private ComboBox<String> combo_chbre_double;
    @FXML
    private Label label_chbre_single;
    @FXML
    private Label label_chbre_double;
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
    @FXML
    private ImageView img_res_hotel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void on_click_button_ok(ActionEvent event) {
         
//           
//       if( input_ref_ajout_adulte.getValue()==null)Label3.setText("Champs obligatoires.");if( input_ref_ajout_adulte.getValue()!=null)Label3.setText("");
//          if( input_ref_ajout_enfant.getValue()==null) Label4.setText("Champs obligatoires."); if( input_ref_ajout_enfant.getValue()!=null) Label4.setText("");
//              if( (Integer.parseInt(input_nbr_nuit.getText())<1)||(input_nbr_nuit.getText()=="..")) Label5.setText("Verifier vos dates SVP.");if( Integer.parseInt(input_nbr_nuit.getText())>0&&input_nbr_nuit.getText()!="..") Label5.setText("");
//                    
//                      if ((combo_chbre_single.getValue()==null)&&( combo_chbre_double.getValue()==null))  Label6.setText("Veuillez choisir les chambres :) ");
//          
//          
//          
//               Date_debut = java.sql.Date.valueOf( calendar_arriv.getValue());
//        Date_fin = java.sql.Date.valueOf( calendar_sortie.getValue() );
//      
//      int Ref_Type=Integer.parseInt(combo_ref_type.getValue());
//        Hebergement h =new Hebergement(Ref_Type);
//        r.setRef_hebergement_fk(h);
//         r.setDate_arrivee(Date_debut);
//        r.setDate_sortie(Date_fin);
//        r.setNombreAdultes(Integer.parseInt((String) input_ref_ajout_adulte.getValue()));
//        r.setNombreEnfants(Integer.parseInt((String) input_ref_ajout_adulte.getValue()));
//        r.setNombreNuits(Integer.parseInt(input_nbr_nuit.getText()));
//        r.setNbre_chbre_single(Integer.parseInt((String) combo_chbre_single.getValue()));
//        r.setNbre_chbre_double(Integer.parseInt((String) combo_chbre_double.getValue()));
//        
//        
//          float prix_total= Float.parseFloat(blasset_prix_total.getText());
//        r.setPrixTotal(prix_total);
//
//        r.setRef_client_fk(cli); 
//         String Date_debutString =label_date_du_jour.getText();
//        Date d;
//        d = java.sql.Date.valueOf( Date_debutString );
//        r.setDate_res(d);
//        
//        
//          try {
//                reservationService.ajouterReservationHHotel(r);
//            } catch (SQLException ex) {
//               
//            }
//        
//      
        
        
    }

    @FXML
    private void on_click_ok_butt(ActionEvent event) {
    }

    @FXML
    private void on_click_calcul_butt(ActionEvent event) {
    }
    
}
