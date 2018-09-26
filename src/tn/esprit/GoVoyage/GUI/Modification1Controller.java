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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Modification1Controller implements Initializable {

    @FXML
    private TextField ref_Asupp;
    @FXML
    private Button btn_modif1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Modifier_Heb(ActionEvent event) throws IOException {

         Node source = (Node) event.getSource();
   Stage stage = (Stage) source.getScene().getWindow();
   stage.close();
        
        Parent root = FXMLLoader.load(getClass().getResource("Modification.fxml"));
       
        Scene s = new Scene(root);
         Stage primaryStage = new Stage();
        primaryStage.setScene(s);
        primaryStage.show();

    
    }
    
}
