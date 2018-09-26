/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.GUI;

import tn.esprit.GoVoyage.entites.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tn.esprit.GoVoyage.services.Reclamationmethodes;
import static tn.esprit.GoVoyage.GUI.ClientXMLController.idUserOnline;

/**
 * FXML Controller class
 *
 * @author Kouka
 */
public class EnvoyerReclamationController implements Initializable {
    @FXML
    private TextArea reclamationtext;
    @FXML
    private TextField username;
    @FXML
    private Text iduser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         iduser.setText("ID User Logged in : " +String.valueOf(idUserOnline));
        // TODO
    }    

    @FXML
    private void envoyer(ActionEvent event) throws SQLException {
        Reclamation r = new Reclamation ();
        Reclamationmethodes rec = new Reclamationmethodes();
        // r.setRef(username.getText());
        r.setDescription(reclamationtext.getText());
        rec.ajouterReclamation(r);
        JOptionPane.showMessageDialog(null, "Réclamation envoyée avec succes !!");
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("ClientsSpace.fxml"));
             Scene admin = new Scene (root);
             Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage.setTitle("Ma page d'inscription");
             app_stage.setScene(admin);
             
             app_stage.show();
    }
    
}
