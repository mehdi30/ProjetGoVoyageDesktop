/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tn.esprit.GoVoyage.services.ClientsMethodes;

/**
 * FXML Controller class
 *
 * @author Kouka
 */
public class ClientXMLController implements Initializable {
    
    public static int idUserOnline;
    
    public static int getidUserOnline () {
        
        return idUserOnline;
    }
    
    
 
    
 
    
    ObservableList<String> gender = FXCollections.observableArrayList("féminin","masculin");
        ObservableList<String> nation = FXCollections.observableArrayList("tunisienne",
            "francaise",
            "americaine");
        ObservableList<String> choice = FXCollections.observableArrayList("oui","non");
       
        
        
        

    private Stage primaryStage;
    @FXML
    private TextField username;
    @FXML
    private PasswordField mdp;
    @FXML
    private Button fb;

    
    
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        Image image = new Image ("");
//         nomprop1.setVisible(false);
//             nomprop.setVisible(false);
//     
//        
        
      
       
//        
        
        // TODO
    }   
    
    

    @FXML
    private void connexion(ActionEvent event) throws IOException, SQLException {
       //  mycon = MyBDConx.getInstanceBD().getConnection();
           
        ClientsMethodes utili = new ClientsMethodes();
         try
        {
       int x = utili.getIdByUsernameMdp(username.getText(), mdp.getText());
       
       int y = utili.getRoleByUsernameMdp(username.getText(), mdp.getText());
         System.out.println(y);
        idUserOnline = x ;
        System.out.println(idUserOnline);
      
         
        if (y == 1) {
                JOptionPane.showMessageDialog(null, "Username and Password correct. Bienvenu à l'espace Administrateur");
                
                 Parent root = FXMLLoader.load(getClass().getResource("Administrateur.fxml"));
             Scene admin = new Scene (root);
             Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage.setTitle("Ma page d'administrateur");
             app_stage.setScene(admin);
             
             app_stage.show();
             
            } 
          
            
             else if (y == 2) {
                  JOptionPane.showMessageDialog(null, "Username and Password correct. Bienvenu à votre espace Client");
             Parent root = FXMLLoader.load(getClass().getResource("ClientsSpace.fxml"));
             Scene client = new Scene (root);
             Stage app_stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage1.setTitle("Ma page Client");
             app_stage1.setScene(client);
             
             app_stage1.show();
         }
               else
            {
                JOptionPane.showMessageDialog(null, "invalid username and password");
        } }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
        
             
   
//     
        
            
//}
     
    
  

    @FXML
    private void faceb(ActionEvent event) {
        
    }

    @FXML
    private void signup(ActionEvent event) throws IOException {
    

  
          Parent root = FXMLLoader.load(getClass().getResource("inscriptionxml.fxml"));
             Scene admin = new Scene (root);
             Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage.setTitle("Ma page d'inscription");
             app_stage.setScene(admin);
             
             app_stage.show();
             
        
    }


  
   

    
                           
                        

                    } 
          

    

