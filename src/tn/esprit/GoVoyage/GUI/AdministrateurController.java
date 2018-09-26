/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.GUI;

import tn.esprit.GoVoyage.gf.animations.FadeInUpTransition;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static tn.esprit.GoVoyage.GUI.ClientXMLController.idUserOnline;

/**
 * FXML Controller class
 *
 * @author Kouka
 */
public class AdministrateurController implements Initializable {
    @FXML
    private Text iduser;
  
    
    
    

    
    public void start (Stage stage) throws SQLException {
//       
//            }
         
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
         iduser.setText("ID User Logged in : " +String.valueOf(idUserOnline));
//        Image image = new Image ("");
//       new FadeInUpTransition(gererOffre).play();
//        new FadeInUpTransition(gererVol).play();
//        new FadeInUpTransition(gererHeberg).play();
       
   
}

    @FXML
    private void clients(ActionEvent event) throws IOException {
        
         Parent root = FXMLLoader.load(getClass().getResource("gestionclients.fxml"));
             Scene admin = new Scene (root);
             Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage.setTitle("Ma page d'administrateur");
             app_stage.setScene(admin);
             
             app_stage.show();
    }

    @FXML
    private void vols(ActionEvent event) 
    {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("AjouterVol.fxml"));
        try {
            Loader.load();
      ((Node)event.getSource()).getScene().getWindow().hide();
        
        Parent p = Loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("GoVoyage");
        stage.setScene(new Scene(p));
        stage.show();
          } catch (IOException ex) {}
    }

    @FXML
    private void reclamations(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Reclamations.fxml"));
             Scene admin = new Scene (root);
             Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage.setTitle("Ma page de Reclamations");
             app_stage.setScene(admin);
             
             app_stage.show();
    }

    @FXML
    private void guides(ActionEvent event) {
    }

    @FXML
    private void hotels(ActionEvent event) 
    {
        
         FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("InterfaceHebergement.fxml"));
        try {
            Loader.load();
      ((Node)event.getSource()).getScene().getWindow().hide();
        
        Parent p = Loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("GoVoyage");
        stage.setScene(new Scene(p));
        stage.show();
          } catch (IOException ex) {}
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
    private void offres(ActionEvent event)
    {
          FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("GestionOffre.fxml"));
        try {
            Loader.load();
      ((Node)event.getSource()).getScene().getWindow().hide();
        
        Parent p = Loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("GoVoyage");
        stage.setScene(new Scene(p));
        stage.show();
          } catch (IOException ex) {}
    }
}

            
            
        
 
//        final VBox vbox = new VBox();
//        vbox.setSpacing(5);
//        vbox.setPadding(new Insets(10, 0, 0, 10));
//        vbox.getChildren().addAll(label, table);
// 
//        ((Group) scene.getRoot()).getChildren().addAll(vbox);
// 
//        stage.setScene(scene);
//        stage.show();
        
    

    /**
     * Initializes the controller class.
     */
   
