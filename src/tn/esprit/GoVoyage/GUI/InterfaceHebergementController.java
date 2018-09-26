/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.GUI;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.util.List;
import tn.esprit.GoVoyage.entites.Hebergement;
import tn.esprit.GoVoyage.entites.Hotel;
import tn.esprit.GoVoyage.entites.MaisonHotes;
import tn.esprit.GoVoyage.services.HebergementService;
import tn.esprit.GoVoyage.services.HotelService;
import tn.esprit.GoVoyage.services.MaisonHoteService;


/**
 * FXML Controller class
 *
 * @author asus
 */
public class InterfaceHebergementController implements Initializable {
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_adresse;
 //   private TextField txt_description;
 //   private TextField txt_refP;
    @FXML
    private TextField txt_nbE;
    @FXML
    private TextField txt_ps;
    @FXML
    private TextField txt_pd;
    @FXML
    private TextField txt_pe;
   // private TextField txt_pa;
    @FXML
    private TextField txt_pn;
    @FXML
    private TextField txt_numTel;
    @FXML
    private ComboBox<String> comType;
    

    @FXML
    private Tab liste;
    @FXML
    private TableView<Hebergement> TableV;
    @FXML
    private TableColumn<Hebergement, Integer> ref_tv;
    @FXML
    private TableColumn<Hebergement, String> nom_tv;
    @FXML
    private TableColumn<Hebergement, String> adresse_tv;
    @FXML
    private TableColumn<Hebergement, String> desc_tv;
    @FXML
    private TableColumn<Hebergement, String> type_tv;
    @FXML
    private TableColumn<Hebergement, Integer> num_tv;
    @FXML
    private Button ajouter_btn;

      ObservableList<String> List =FXCollections.observableArrayList("Hotel","Hote");
    @FXML
    private Button ajouterM;
    @FXML
    private TextField txt_addmail1;
    private TextField txt_img1;
    @FXML
    private Label fx_ps;
    @FXML
    private Label fx_pd;
    @FXML
    private Label fx_pe;
    @FXML
    private Label fx_pn;
    @FXML
    private Label fx_nbe;
    @FXML
    private JFXButton acceuill;
    @FXML
    private JFXButton acceuill1;
    
    
    /**
     * Initializes the controller class.
     */
     public void refresh() {
        
       TableV.getItems().clear();
       Hebergement h =new Hebergement();
       HebergementService hebergementService =new HebergementService();
       
        try {
            List<Hebergement> hebergements = hebergementService.displayAll();
           ObservableList<Hebergement> data = hebergementService.displayAll();
           data.clear();
           data.setAll(hebergements);
            TableV.setItems(data);
        } catch (SQLException ex) {}}
    
    @Override   
    public void initialize(URL url, ResourceBundle rb) {
         try {
        HebergementService hebergementService = new HebergementService();
       List <Hebergement> hebergements = hebergementService.displayAll() ;
        Hebergement h=new Hebergement();
       ObservableList<Hebergement> data =hebergementService.displayAll();
               
       ref_tv.setCellValueFactory(new PropertyValueFactory<>("id")); 
       nom_tv.setCellValueFactory(new PropertyValueFactory<>("nom"));
       adresse_tv.setCellValueFactory(new PropertyValueFactory<>("adresse"));
       type_tv.setCellValueFactory(new PropertyValueFactory<>("type"));
       desc_tv.setCellValueFactory(new PropertyValueFactory<>("adresseMail"));
       num_tv.setCellValueFactory(new PropertyValueFactory<>("numerotel"));
      
       // Table.setItems(null);
       TableV.setItems(data);
        } catch (SQLException ex) {
            //    Logger.getLogger(ServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        comType.setItems(List); 
        }    

    @FXML
    private void supprimButton(ActionEvent event) throws IOException {
         Node source = (Node) event.getSource();
   Stage stage = (Stage) source.getScene().getWindow();
   //stage.close();
        
         HebergementService H =new HebergementService();
    int id =TableV.getSelectionModel().getSelectedItem().getId();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            
        alert.setTitle("Suppression d'un hotel");
        alert.setContentText("Vouslez-vous vraiment supprimer cet hebergement ?");
        Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK)
                { 
                    H.supprimerHebergement(id) ;
                  
                }
        refresh();
    
}

    @FXML
    private void modifButtton(ActionEvent event) throws IOException {
      
        /* Node source = (Node) event.getSource();
   Stage stage = (Stage) source.getScene().getWindow();
   stage.close();
*/
        
         Node source = (Node) event.getSource();
   Stage stage = (Stage) source.getScene().getWindow();
   //stage.close();
        
         HebergementService H =new HebergementService();
         int ref =TableV.getSelectionModel().getSelectedItem().getId();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            
        alert.setTitle("modification d'un hebergement");
        alert.setContentText("Vouslez-vous vraiment modifier cet hebergement ?");
        Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK)
                { 
                       
        Parent root = FXMLLoader.load(getClass().getResource("Modification.fxml"));
       
        Scene s = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setScene(s);
        primaryStage.show();
        
                   
                  
                }
                 refresh();
         }

    @FXML
    private void ajouterButton(ActionEvent event) throws SQLException {
    
         HotelService hotelService = new HotelService();
         Hotel ho = new Hotel();
      
  
      
        //  int x=parseInt(txt_ref.getText());
        //  ho.setRef(x);
          ho.setNom(txt_nom.getText());
          ho.setAdresse(txt_adresse.getText());
          ho.setAdresseMail(txt_addmail1.getText());
          ho.setType( comType.getValue());
          int y=parseInt(txt_numTel.getText());
          ho.setNumerotel(y);
           int z=parseInt(txt_nbE.getText());
          ho.setNbEtoile(z);
          ho.setPrixSingle(Float.parseFloat(txt_ps.getText()));
          ho.setPrixDouble(Float.parseFloat(txt_pd.getText()));
          ho.setPrixEnfant(Float.parseFloat(txt_pe.getText()));
        
          //verif() ;
          if(verifHotel()==true);
          {
          hotelService.insererHotel(ho);
          refresh();         
          } 
          
    }
        
  

    @FXML
    private void listeAction(Event event) {
          try {
        HebergementService hebergementService = new HebergementService();
        List <Hebergement> hebergements = hebergementService.displayAll() ;
        Hebergement h=new Hebergement();
       ObservableList<Hebergement> data =hebergementService.displayAll();
               
    ref_tv.setCellValueFactory(new PropertyValueFactory<>("id")); 
    nom_tv.setCellValueFactory(new PropertyValueFactory<>("nom"));
    adresse_tv.setCellValueFactory(new PropertyValueFactory<>("adresse"));
    type_tv.setCellValueFactory(new PropertyValueFactory<>("type"));
    desc_tv.setCellValueFactory(new PropertyValueFactory<>("adresseMail"));
    num_tv.setCellValueFactory(new PropertyValueFactory<>("numTelephone"));
      
       TableV.setItems(data);
        } catch (SQLException ex) {
         //       Logger.getLogger(ServiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
 
    }    

    @FXML
    private void comboAction(ActionEvent event) {
    
        
    String choix =comType.getValue();
      if("Hote".equals(choix))
 {
      txt_nbE.setVisible(false);
      txt_ps.setVisible(false);
      txt_pd.setVisible(false);
      txt_pe.setVisible(false);
      txt_pn.setVisible(true);
      ajouter_btn.setVisible(false);
      ajouterM.setVisible(true);
      fx_nbe.setVisible(false);
      fx_ps.setVisible(false);
      fx_pd.setVisible(false);
      fx_pd.setVisible(false);
      fx_pe.setVisible(false);
       fx_pe.setVisible(true);

   } 
      if("Hotel".equals(choix))
 {

      txt_pn.setVisible(false);
      txt_nbE.setVisible(true);
      txt_ps.setVisible(true);
      txt_pd.setVisible(true);
      txt_pe.setVisible(true);
      ajouterM.setVisible(false);
      ajouter_btn.setVisible(true);
      fx_pn.setVisible(false);
      
 }

    }

    void setList(String adresse, Hebergement hebergement) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void ajouterMAction(ActionEvent event) throws SQLException, IOException {
    
            MaisonHoteService maisonHoteService = new MaisonHoteService();
         MaisonHotes m = new MaisonHotes();
  
        //  int x=parseInt(txt_ref.getText());
        //  ho.setRef(x);
          m.setNom(txt_nom.getText());
          m.setAdresse(txt_adresse.getText());
          m.setAdresseMail(txt_addmail1.getText());
          m.setType( comType.getValue());
          int y=parseInt(txt_numTel.getText());
          m.setNumerotel(y);

          m.setPrixNuit(Float.parseFloat(txt_pn.getText()));
        
          //verif() ;
          if(verifHote()==true);
          {
          maisonHoteService.insererMaisonHote(m);
          refresh();         
          } 
     // SMS.sendData();
    
    }



     public  boolean verifHotel() 
    {
       
        
        if (txt_nom.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Veuillez entrez votre Nom");
            alert.showAndWait();
          txt_nom.requestFocus();
            return  false;
        }
        if (txt_adresse.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Veuillez entrez l'adresse de l'hebergement");
            alert.showAndWait();
            txt_adresse.requestFocus();
              return  false;
        }
          

                if (comType.getValue().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Veuillez choisir le type");
            alert.showAndWait();
           comType.requestFocus();
           return  false;
        }

                 if (txt_nbE.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Veuillez saisir le nombre d'etoiles");
            alert.showAndWait();
          txt_nbE.requestFocus();
           return  false;
        }
       
       
                if (txt_numTel.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Veuillez entrez votre Numero de Telephone");
            alert.showAndWait();
            txt_numTel.requestFocus();
          return  false;
        }
                       
        if (txt_numTel.getText().length() != 8) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Veuillez verifiez votre Numero de Telephone");
            alert.showAndWait();
            txt_numTel.requestFocus();
           return  false;
        }
        if (!verifnum(txt_numTel.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Il faut que votre Numero de Telephone de type integer");
            alert.showAndWait();
            txt_numTel.requestFocus();
           return  false;
        }
                
         if (txt_ps.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Veuillez verifiez le prix single");
            alert.showAndWait();
            txt_ps.requestFocus();
           return  false;
        }
         if (txt_pd.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Veuillez verifiez le prix double");
            alert.showAndWait();
            txt_pd.requestFocus();
            return  false;
        }
         if (txt_pe.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Veuillez verifiez le prix enfant");
            alert.showAndWait();
            txt_pe.requestFocus();
           return  false;
        }


       return true;
    } 
        
     
      public  boolean verifHote() 
    {
       
        
        if (txt_nom.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Veuillez entrez votre Nom");
            alert.showAndWait();
          txt_nom.requestFocus();
            return  false;
        }
        if (txt_adresse.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Veuillez entrez l'adresse de l'hebergement");
            alert.showAndWait();
            txt_adresse.requestFocus();
              return  false;
        }

        
                if (comType.getValue().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Veuillez choisir le type");
            alert.showAndWait();
           comType.requestFocus();
           return  false;
        }


                 if (txt_numTel.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Veuillez entrez votre Numero de Telephone");
            alert.showAndWait();
            txt_numTel.requestFocus();
          return  false;
        }
                       
        if (txt_numTel.getText().length() != 8) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Veuillez verifiez votre Numero de Telephone");
            alert.showAndWait();
            txt_numTel.requestFocus();
           return  false;
        }
        if (!verifnum(txt_numTel.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Il faut que votre Numero de Telephone de type integer");
            alert.showAndWait();
            txt_numTel.requestFocus();
           return  false;
        }
          if (txt_pn.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Veuillez verifiez le prix par nuit");
            alert.showAndWait();
            txt_pn.requestFocus();
           return  false;
           }
           

        return true ;
    }
     
        
        public static  boolean verifnum(String a) 
        {//boolean n=true;
            try {
    int f = Integer.parseInt(a);
} catch (NumberFormatException nfe) {
    return false;
    
}
            return true;
            
        }

    @FXML
    private void acceuil(ActionEvent event) {
          
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("Administrateur.fxml"));
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
    private void acceuil1(ActionEvent event) {
          
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("Administrateur.fxml"));
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
        
      //  @FXML
  /*      public static boolean verifadresse(String b)
        {String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
Pattern pattern = Pattern.compile(masque);
Matcher controler = pattern.matcher(b);
if (controler.matches()){
return true;
 
}
return false;
        }
    
    */
    


       


   
    
