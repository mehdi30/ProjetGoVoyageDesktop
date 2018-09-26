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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static tn.esprit.GoVoyage.GUI.ClientXMLController.idUserOnline;

/**
 * FXML Controller class
 *
 * @author Kouka
 */
public class ClientsSpaceController implements Initializable {
    @FXML
    private Text iduser;
    @FXML
    private Button VolBnt;
    @FXML
    private Button HeberBtn;
    @FXML
    private Button GuideBnt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iduser.setText("ID User Logged in : " +String.valueOf(idUserOnline));
        // TODO
    }    

    @FXML
    private void reclamer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EnvoyerReclamation.fxml"));
             Scene admin = new Scene (root);
             Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage.setTitle("Ma page de Reclamation");
             app_stage.setScene(admin);
             
             app_stage.show();
    }

    @FXML
    private void out(ActionEvent event) throws IOException {
           Parent root = FXMLLoader.load(getClass().getResource("ClientXML.fxml"));
             Scene admin = new Scene (root);
             Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage.setTitle("Ma page d'administrateur");
             app_stage.setScene(admin);
             
             app_stage.show();
    }

    @FXML
    private void VolBnt(ActionEvent event) throws IOException{
         Parent root = FXMLLoader.load(getClass().getResource("ChercherVolClient.fxml"));
             Scene admin = new Scene (root);
             Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage.setTitle("GoVoyage");
             app_stage.setScene(admin);
             
             app_stage.show();
    }

    @FXML
    private void HeberBtn(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("Client.fxml"));
             Scene admin = new Scene (root);
             Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage.setTitle("GoVoyage");
             app_stage.setScene(admin);
             
             app_stage.show();
    }

    @FXML
    private void GuideBnt(ActionEvent event) {
    }

    
}
