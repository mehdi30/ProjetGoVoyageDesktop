/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.GUI;

import tn.esprit.GoVoyage.entites.Hebergement;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import tn.esprit.GoVoyage.services.HebergementService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class SupressionController implements Initializable {

    @FXML
    private TextField ref_Asupp;
    @FXML
    private Button btn_supprimerS;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonSupS(ActionEvent event) {
        
 ObservableList<Hebergement> hebergements = FXCollections.observableArrayList();
            HebergementService H =new HebergementService();
             int x=parseInt(ref_Asupp.getText());
             
        
       //  h.supprimer(Table.getSelectionModel().getSelectedItem().getRef());
        //  Main.showHebergements();
    
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            
        alert.setTitle("Suppression d'un hotel");
        alert.setContentText("Vouslez-vous vraiment supprimer cet hebergement ?");
        Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK)
                { 
                    H.supprimerHebergement(x) ;
                  
                }
     
    }
        
        
    }

    
   
