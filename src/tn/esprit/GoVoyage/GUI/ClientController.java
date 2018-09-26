/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ClientController implements Initializable {


    @FXML
    private ImageView hotel1;
    @FXML
    private ImageView hotel2;
    @FXML
    private ImageView hotel3;
   
    @FXML
    private ImageView hote1;
    @FXML
    private ImageView hote2;
    @FXML
    private Button Mdestinations;
    @FXML
    private Button idee;
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 


        // TODO
    }    


    @FXML
    private void ActionRecherche(ActionEvent event) throws IOException {
                     Node source = (Node) event.getSource();
   Stage stage = (Stage) source.getScene().getWindow();
   stage.close();
        
        Parent root = FXMLLoader.load(getClass().getResource("ListeDesHotels.fxml"));
       
        Scene s = new Scene(root);
         Stage primaryStage = new Stage();
        primaryStage.setScene(s);
        primaryStage.show();
        
    }



    @FXML
    private void Action_HotesRecheche(ActionEvent event) throws IOException {
        
                             Node source = (Node) event.getSource();
   Stage stage = (Stage) source.getScene().getWindow();
   stage.close();
        
        Parent root = FXMLLoader.load(getClass().getResource("ListeDesHotes.fxml"));
       
        Scene s = new Scene(root);
         Stage primaryStage = new Stage();
        primaryStage.setScene(s);
        primaryStage.show();
    }

    @FXML
    private void MDestinationAction(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
   Stage stage = (Stage) source.getScene().getWindow();
   stage.close();
        
        Parent root = FXMLLoader.load(getClass().getResource("MeuilleresDestinations.fxml"));
       
        Scene s = new Scene(root);
         Stage primaryStage = new Stage();
        primaryStage.setScene(s);
        primaryStage.show();
    }

    @FXML
    private void ideeAction(ActionEvent event) throws IOException {
        
        
                Node source = (Node) event.getSource();
   Stage stage = (Stage) source.getScene().getWindow();
   stage.close();
        
        Parent root = FXMLLoader.load(getClass().getResource("IdeeHotes.fxml"));
       
        Scene s = new Scene(root);
         Stage primaryStage = new Stage();
        primaryStage.setScene(s);
        primaryStage.show() ;
    }


    @FXML
    private void accHAction(ActionEvent event) {
          
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("ClientsSpace.fxml"));
        try {
            Loader.load();
      
        
        Parent p = Loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("GoVoyage");
        stage.setScene(new Scene(p));
        stage.show();
        ((Node)event.getSource()).getScene().getWindow().hide();
          } catch (IOException ex) {}
    }

    @FXML
    private void accMAction(ActionEvent event) {
          
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("ClientsSpace.fxml"));
        try {
            Loader.load();
      
        
        Parent p = Loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("GoVoyage");
        stage.setScene(new Scene(p));
        stage.show();
        ((Node)event.getSource()).getScene().getWindow().hide();
          } catch (IOException ex) {}
    }

    
}
