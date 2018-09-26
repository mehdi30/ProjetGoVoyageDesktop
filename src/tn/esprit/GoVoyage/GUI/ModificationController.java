/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.GUI;

import java.io.IOException;
import static java.lang.Integer.parseInt;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.GoVoyage.entites.Hotel;
import tn.esprit.GoVoyage.entites.MaisonHotes;
import tn.esprit.GoVoyage.services.HotelService;
import tn.esprit.GoVoyage.services.MaisonHoteService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ModificationController implements Initializable {

    @FXML
    private TextField txt_adresse;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_numTel;
    private TextField txt_type;
    @FXML
    private TextField txt_description;
    @FXML
    private TextField txt_pe;
    @FXML
    private TextField txt_pd;
    @FXML
    private TextField txt_ps;
    @FXML
    private TextField txt_nbE;
    @FXML
    private TextField txt_pn;
    private TextField txt_pa;
    @FXML
    private Button btn_modificationS;
    @FXML
    private ComboBox<String> comboModif;
ObservableList<String> List =FXCollections.observableArrayList("Hotel","Hote");
    @FXML
    private Button HotesModif;
    @FXML
    private Button retourner;
    @FXML
    private Label id_nbe;
    @FXML
    private Label id_ps;
    @FXML
    private Label id_pd;
    @FXML
    private Label id_pn;
    @FXML
    private Label id_pe;
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       comboModif.setItems(List);
        // TODO
    }    

    @FXML
    private void HandleButtonModifS(ActionEvent event) throws SQLException {
         {  

          
             HotelService hotelService =new HotelService();
             Hotel ho = new Hotel();
          
          ho.setNom(txt_nom.getText());
          ho.setAdresse(txt_adresse.getText());
          ho.setAdresseMail(txt_description.getText());
          ho.setType( comboModif.getValue());
          int y=parseInt(txt_numTel.getText());
          ho.setNumerotel(y);
           int z=parseInt(txt_nbE.getText());
          ho.setNbEtoile(z);
          ho.setPrixSingle(Float.parseFloat(txt_ps.getText()));
          ho.setPrixDouble(Float.parseFloat(txt_pd.getText()));
          ho.setPrixEnfant(Float.parseFloat(txt_pe.getText()));
         

          hotelService.ModifierHotel(ho);
        
          } 
         }
        
    

    @FXML
    private void comboModifAction(ActionEvent event) {
     String choix =comboModif.getValue();
      if("Hote".equals(choix))
 {
     
      txt_nbE.setVisible(false);
      txt_ps.setVisible(false);
      txt_pd.setVisible(false);
      txt_pe.setVisible(false);
      txt_pn.setVisible(true);
      btn_modificationS.setVisible(false);
      HotesModif.setVisible(true);
      id_nbe.setVisible(false);
      id_ps.setVisible(false);
      id_pd.setVisible(false);
      id_pd.setVisible(false);
      id_pe.setVisible(false);
   } 
      if("Hotel".equals(choix))
 {

      txt_pn.setVisible(false);
      txt_nbE.setVisible(true);
      txt_ps.setVisible(true);
      txt_pd.setVisible(true);
      txt_pe.setVisible(true);
      HotesModif.setVisible(false);
      btn_modificationS.setVisible(true);
      id_pn.setVisible(false);
      txt_pn.setVisible(false);
 }
    }

    @FXML
    private void HotesModifAction(ActionEvent event) {
    
     
             MaisonHoteService maisonHoteService =new MaisonHoteService();
             MaisonHotes m = new MaisonHotes();
          m.setNom(txt_nom.getText());
          m.setAdresse(txt_adresse.getText());
          m.setAdresseMail(txt_description.getText());
          m.setType( comboModif.getValue());
          int y=parseInt(txt_numTel.getText());
          m.setNumerotel(y);
          m.setPrixNuit(Float.parseFloat(txt_pn.getText()));
         
          maisonHoteService.ModifierMaisonHotes(m); 
    }
    
 /*   @FXML
    private void RetournerAction(ActionEvent event) throws IOException  {

                Node source = (Node) event.getSource();
   Stage stage = (Stage) source.getScene().getWindow();
   stage.close();
        
        Parent root = FXMLLoader.load(getClass().getResource("InterfaceHebergement.fxml"));
        Scene s = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setScene(s);
        primaryStage.show();
    }
*/

    @FXML
    private void retournerAction(ActionEvent event) throws IOException {
        
        
        
                Node source = (Node) event.getSource();
   Stage stage = (Stage) source.getScene().getWindow();
   stage.close();
        
        Parent root = FXMLLoader.load(getClass().getResource("InterfaceHebergement.fxml"));
        Scene s = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setScene(s);
        primaryStage.show();
    }
}
