/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.GUI;

import tn.esprit.GoVoyage.entites.Hebergement;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tn.esprit.GoVoyage.services.HebergementService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ServiceController implements Initializable {

    @FXML
    private TextField txt_adresse;
    @FXML
    private TextField txt_ref;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_numTel;
    @FXML
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
    @FXML
    private TextField txt_pa;
    @FXML
    private Button btn_ajouter;
     @FXML
    private TextField txt_RefP;
 

   @FXML
  private TableColumn< Hebergement, Integer> ref ;
    @FXML
    private TableColumn<Hebergement,String > nom;
    @FXML
    private TableColumn<Hebergement, String> adresse;
    @FXML
    private TableColumn<Hebergement, String> type;
    private TableColumn<Hebergement, Integer> num;
    @FXML
    private TableColumn<Hebergement, String> desc;
 //   @FXML
  // private Tab changer;
    @FXML
    private Button btn_afficher;
    @FXML
    private Tab changer;
    @FXML
    private TableView<Hebergement> Table;
    @FXML
    private TableColumn<Hebergement,String> numTel;

  
    
    

     
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   //  chargerAll();
     
    }
  
   
           
    

    @FXML
    private void handleButtonAction_ajout(ActionEvent event)  throws IOException, SQLException {
    
    HebergementService hebergementService = new HebergementService();
    Hebergement h = new Hebergement();
        
   // HotelService hotelService = new HotelService() ;
    //Hotel h =new Hotel() ;
        
//          int x=parseInt(txt_ref.getText());
//          h.setRef(x);
//          h.setNom(txt_nom.getText());
//          h.setAdresse(txt_adresse.getText());
//          h.setDescription(txt_description.getText());
//          h.setType( txt_type.getText());
//          int y=parseInt(txt_numTel.getText());
//          h.setNumTelephone(y);
      //   int z=parseInt(txt_nbE.getText());
       //   h.setNbreEtoile(z);
      // h.setPrixSingle(Float.parseFloat(txt_ps.getText()));
        //  h.setPrixDouble(Float.parseFloat(txt_pd.getText()));
         // h.setPrixEnfant(Float.parseFloat(txt_pe.getText()));
         // h.setPrixAdulte(Float.parseFloat(txt_pa.getText()));
    //     int d=parseInt(txt_refP.getText());
      //   h.setRefProprietaire(d)
        //    h.setPrixNuit(Float.parseFloat(txt_pn.getText()));
      //    hotelService.insererHotel(h);
   hebergementService.insererHebergement(h);
    
    }
      @FXML
    private void handleButtonAction_modif(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("Modification1.fxml"));
       
        Scene s = new Scene(root);
         Stage primaryStage = new Stage();
        primaryStage.setScene(s);
        primaryStage.show();
    
}

    @FXML
   private void handleButtonAction_supr(ActionEvent event) throws IOException {
  //  public void handleButtonAction_supr(Stage primaryStage) throws IOException {
Parent root = FXMLLoader.load(getClass().getResource("Supression.fxml"));
       
        Scene s = new Scene(root);
         Stage primaryStage = new Stage();
        primaryStage.setScene(s);
        primaryStage.show();

    }

    @FXML
    private void chargerlist(Event event) {
            
        
    }

    @FXML
    private void handleButtonAction_affich(ActionEvent event) {
    
      try {
        HebergementService hebergementService = new HebergementService();
       // List <Hebergement> hebergements = hebergementService.displayAll() ;
        Hebergement h=new Hebergement();
         ObservableList<Hebergement> data=hebergementService.displayAll();
       ref.setCellValueFactory(new PropertyValueFactory<>("ref")); 
       nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
       adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
       type.setCellValueFactory(new PropertyValueFactory<>("type"));
       num.setCellValueFactory(new PropertyValueFactory<>("numTelephone"));
       desc.setCellValueFactory(new PropertyValueFactory<>("description"));
      
        //Table.setItems(null);
        Table.setItems(data);
        } catch (SQLException ex) {
                Logger.getLogger(ServiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
            
}
