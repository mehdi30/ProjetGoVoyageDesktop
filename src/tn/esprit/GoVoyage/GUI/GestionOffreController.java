package tn.esprit.GoVoyage.GUI;

import tn.esprit.GoVoyage.ConnectionBD.ConnexionBD;
import static tn.esprit.GoVoyage.GUI.NewFXMain.dateString;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import tn.esprit.GoVoyage.entites.Mail;
import tn.esprit.GoVoyage.entites.Hebergement;
import tn.esprit.GoVoyage.entites.Offre;
import tn.esprit.GoVoyage.entites.Vol;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tn.esprit.GoVoyage.services.OffreService;
/**
 * FXML Controller class
 *
 * @author nizar
 */
public class GestionOffreController implements Initializable {
    
   

    @FXML
    private JFXComboBox<String> comboRef;
    public static TableView<Offre> imlegend;
    public  TableView<Offre> tableview;
    Connection mycon=ConnexionBD.getInstanceBD().getConnection(); 
    OffreService offreService = new OffreService();
    ObservableList<Offre> data = FXCollections.observableArrayList();
    @FXML
    private AnchorPane calend2;
    @FXML
    private Label dureelabel;
    @FXML
    private JFXDatePicker cal1;
    @FXML
    private JFXDatePicker cal2;
    @FXML
    private JFXButton bnt_ajouter;
    @FXML
    private JFXTextField text_spec;
    @FXML
    private JFXTextField text_duree;
    @FXML
    private Label label1;
    @FXML
    private Label label6;
    @FXML
    private Label label5;
    @FXML
    private Label label4;
    @FXML
    private Label label3;
    @FXML
    private Label label2;
    @FXML
    private JFXButton bntModifier;
    @FXML
    private JFXButton cancel;
    @FXML
    private JFXButton bntSupp;
    @FXML
    private JFXTextField FieldCherch;
    @FXML
    private Label liste_des_vol;
    @FXML
    private JFXComboBox<String> typeDoffre;
    @FXML
    private JFXButton envoyermail;
    @FXML
    private JFXTextField sujet;
    @FXML
    private JFXTextArea objet;
    @FXML
    private ImageView image;
    @FXML
    private ImageView image1;
    @FXML
    private JFXButton acceuill;
    @FXML
    private JFXButton acceuill1;
      
    public TableView<Offre> imlegend(){
         return tableview;
     } 
    public void refresh() {
        data.clear();
        tableview.getItems().clear();
        List<Offre> liste;List<Offre> liste1;
        try {
            liste = offreService.AfficherOffreH();
            liste1 = offreService.AfficherOffreV();
             liste.addAll(liste1);data.setAll(liste);
            tableview.setItems(data);
        } catch (SQLException ex) {}}
    @FXML
    private void cancelClick(ActionEvent event) 
    {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
      @Override
                  public void initialize(URL url, ResourceBundle rb) 
    { imlegend=tableview;
       // ImageView image = new ImageView();
      try {  
                
             List<Offre> liste;List<Offre> liste1;
             liste = offreService.AfficherOffreH();
             liste1 = offreService.AfficherOffreV();
             liste.addAll(liste1);data.setAll(liste);
        
             for (Offre o : liste) {  
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                 try {
                     if (sdf.parse(dateString).compareTo(sdf.parse(o.getDateFin()+""))>0)
                     {if (o.getType().equals("Vol"))
                     { offreService.PrixInitial(o);
                         offreService.supprimerOffreV(o);refresh();}
                     else
                     { offreService.PrixInitial(o);
                         offreService.supprimerOffreH(o);refresh();}
                     }} catch (ParseException ex) {
                     Logger.getLogger(GestionOffreController.class.getName()).log(Level.SEVERE, null, ex);
                 }
 }
            typeDoffre.getItems().addAll("Vol","Hotel","Hote");     
            
            //data = offreService.AfficherOffreH();data1 = offreService.AfficherOffreV();
            tableview.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> 
            {      if (newSelection != null) {  }     });
        
            FieldCherch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                filter(oldValue, newValue);
            }});
        } catch (SQLException ex) {   }      
    }
      public void filter(String oldValue, String newValue) {
        if (newValue == null || oldValue.length() == newValue.length() || oldValue == null) 
        {
            tableview.setItems(data);
        }
        else {
            ObservableList<Offre> filter = FXCollections.observableArrayList();
            for (Offre o : data) {             
                if ((o.getHebergement().getNom()).contains(newValue)||(o.getVol().getNumVol()).contains(newValue)) 
                {     
                    filter.add(o);
                }  }
            tableview.setItems(filter);  
       }}
     
    @FXML
    private void on_btnAjouter_click(ActionEvent event) throws SQLException {
        Hebergement h = new Hebergement();Offre p = new Offre();
           Vol v = new Vol();
           String typeOffre=typeDoffre.getValue();
         String type=comboRef.getValue();
         Statement  ste = mycon.createStatement();
          try {
     if (typeDoffre.getValue()==null) label3.setText("Ces informations sont nécessaires.");if (typeDoffre.getValue()!=null) label3.setText("");
       if( comboRef.getValue()==null)label4.setText("Ces informations sont nécessaires.");if( comboRef.getValue()!=null)label4.setText("");
          if( cal1.getValue()==null) label5.setText("Ces informations sont nécessaires."); if( cal1.getValue()!=null) label5.setText("");
              if( cal2.getValue()==null) label6.setText("Ces informations sont nécessaires.");if( cal2.getValue()!=null) label6.setText("");
                  if( "".equals(text_duree.getText())) label1.setText("Ces informations sont nécessaires.");if( !"".equals(text_duree.getText())) label1.setText("");
                      if( "".equals(text_spec.getText())) label2.setText("Ces informations sont nécessaires.");     
                        if( !"".equals(text_spec.getText())) 
                              { 
                                  label2.setText("");
                                 
                                  if (parseInt(text_spec.getText())>100) label2.setText("Choisissez un nombre entre 0 et 100");
                                  if (parseInt(text_spec.getText())<0) label2.setText("Choisissez un nombre entre 0 et 100"); 
                             } 
                             
if ((typeDoffre.getValue()!=null)&&( comboRef.getValue()!=null)&&( cal1.getValue()!=null)&&( cal2.getValue()!=null)&&( !"".equals(text_duree.getText()))&&( !"".equals(text_spec.getText()))&& (parseInt(text_spec.getText())<100)&&(parseInt(text_spec.getText())>0)){    
      try {
                                  if (parseInt(text_spec.getText())>100) label2.setText("Choisissez un nombre entre 0 et 100");
                                  if (parseInt(text_spec.getText())<0) label2.setText("Choisissez un nombre entre 0 et 100"); 
                          
      
                          Date Date_debut,Date_fin;
         Date_debut = java.sql.Date.valueOf( cal1.getValue());
         Date_fin = java.sql.Date.valueOf( cal2.getValue() );
        if ( Date_debut.before(Date_fin))
            {
            Alert alert1 = new Alert(AlertType.INFORMATION,"Offre Ajoutée Avec Succés ");
            Alert alert = new Alert(AlertType.CONFIRMATION, "Etes vous sure d'ajouter cette Offre  ?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();

           if (alert.getResult() == ButtonType.YES) 
           {                  
        p.setType(typeOffre);
        p.setDuree(text_duree.getText());
        p.setSpecification(parseInt(text_spec.getText()));    
        p.setDateDebut(Date_debut);
        p.setDateFin(Date_fin); 
            
            switch(typeOffre){    
            case "Vol":    
            {  String req1="SELECT * FROM `vol` WHERE numVol='"+type+"'";
              ResultSet res= ste.executeQuery(req1);
              while (res.next()) {
              v.setRef(res.getInt("ref"));
              p.setVol(v);            
              offreService.insererOffreV(p);
               offreService.Promotion(p);
              }
            }
             break;  
            default :   
            { String req1="SELECT * FROM `hebergement` WHERE nom='"+type+"'"; 
            ResultSet res= ste.executeQuery(req1);
            while (res.next()) {
            h.setId(res.getInt("id"));
             p.setHebergement(h); 
            offreService.insererOffreH(p);
             offreService.Promotion(p);
            }
            }}  
    alert1.showAndWait();
          } } else {
                 Alert alert2 = new Alert(AlertType.INFORMATION,"La date de début doit etre inférieure a la date de fin ");
                  alert2.showAndWait();
            }   
         } catch (NumberFormatException e)
                             {label2.setText("Choisissez un nombre entre 0 et 100"); }} }catch (NumberFormatException e)
                             {label2.setText("Choisissez un nombre entre 0 et 100"); }
}
    
    @FXML
    private void on_btnSupp_click(ActionEvent event) {
       try { if(tableview.getSelectionModel().getSelectedItem()!=null)
        {
        int ref = tableview.getSelectionModel().getSelectedItem().getReference();
        Hebergement heb = tableview.getSelectionModel().getSelectedItem().getHebergement();
        Vol vol =tableview.getSelectionModel().getSelectedItem().getVol();
         String type = tableview.getSelectionModel().getSelectedItem().getType();
         int spec = tableview.getSelectionModel().getSelectedItem().getSpecification();
         Date date1 =  tableview.getSelectionModel().getSelectedItem().getDateDebut();
        
        Offre p = new Offre();
        p.setDateDebut(date1);
        p.setSpecification(spec);
        p.setType(type);
        p.setReference(ref);
        p.setHebergement(heb);
        p.setVol(vol);
        Alert alert1 = new Alert(AlertType.INFORMATION,"Offre Supprimée Avec Succés ");
        Alert alert = new Alert(AlertType.CONFIRMATION, "Etes vous sure de Supprimer cette Offre  ?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
        if ("Vol".equals(type))   
        {
            offreService.PrixInitial(p);
            offreService.supprimerOffreV(p);refresh(); alert1.showAndWait();
        }
        else    
        { offreService.PrixInitial(p);
            offreService.supprimerOffreH(p);refresh(); alert1.showAndWait();}
        }
        
    }} catch (SQLException ex) {      }    
    }    
     @FXML
    private void on_btnModifier_click(ActionEvent event) throws IOException {
        if(tableview.getSelectionModel().getSelectedItem()!=null)
        {
        String duree = tableview.getSelectionModel().getSelectedItem().getDuree();
        int spec = tableview.getSelectionModel().getSelectedItem().getSpecification();
        String type = tableview.getSelectionModel().getSelectedItem().getType();
        Hebergement heb = tableview.getSelectionModel().getSelectedItem().getHebergement();
            int ref = tableview.getSelectionModel().getSelectedItem().getReference();
        Vol vol = tableview.getSelectionModel().getSelectedItem().getVol();

        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("ModifierOffre.fxml"));
        Loader.load();
        ModifierOffreController chaine = Loader.getController();
        chaine.setList(duree,spec,type,heb,vol,ref);
        Parent p = Loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("GoVoyage");
        stage.setScene(new Scene(p));
        stage.show();
        //((Node)event.getSource()).getScene().getWindow().hide(); 
    }
    }
    @FXML
    private void onclick(Event event) throws ParseException {
        
        tableview.getColumns().clear();
        ObservableList<Offre> list;
        ObservableList<Offre> list1;
        try {
            Statement ste = mycon.createStatement();
            list = offreService.AfficherOffreH();
             list1=  offreService.AfficherOffreV(); 
              list.addAll(list1);
             for (Offre o : list) {  
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
               if (sdf.parse(dateString).compareTo(sdf.parse(o.getDateFin()+""))>0)
               {if (o.getType().equals("Vol"))
                   { offreService.PrixInitial(o);
                       offreService.supprimerOffreV(o);refresh();}
                   else
                   { offreService.PrixInitial(o);
                       offreService.supprimerOffreH(o);refresh();}
                }  }
             
        TableColumn id = new TableColumn("id");
        id.setPrefWidth(80);
        id.setCellValueFactory(new PropertyValueFactory<>("reference"));
        TableColumn Durée = new TableColumn("Durée de l'offre");
        Durée.setPrefWidth(80);
        Durée.setCellValueFactory(new PropertyValueFactory<>("duree"));
        TableColumn spec = new TableColumn("Déscription");
        spec.setPrefWidth(120);
        spec.setCellValueFactory(new PropertyValueFactory<>("specification"));
        TableColumn type = new TableColumn("Type de l'offre");
        type.setPrefWidth(120);
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        TableColumn dateD = new TableColumn("Date Debut");
        dateD.setPrefWidth(80);
        dateD.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        TableColumn dateF = new TableColumn("Date fin");
        dateF.setPrefWidth(80);
        dateF.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        TableColumn a = new TableColumn("Associée à");
        a.setPrefWidth(130);
        a.setCellValueFactory(new PropertyValueFactory<>("hebergement"));
        TableColumn aa = new TableColumn("Associée à");
        aa.setPrefWidth(130);
        aa.setCellValueFactory(new PropertyValueFactory<>("vol"));
       
         // tableview.setItems(list,list1);
       
          tableview.setItems(list);
          tableview.getColumns().addAll(Durée,spec,type,dateD,dateF,a,aa);
        } catch (SQLException ex) {}
    }
  
    @FXML
    private void selctcombobox(ActionEvent event) {
       comboRef.getItems().removeAll(comboRef.getItems());
            
            Statement ste;
        try {
            ste = mycon.createStatement();
            String req1;
            
            switch(typeDoffre.getValue()){    
            case "Vol":    
            {req1 ="select * from vol";
            ResultSet res= ste.executeQuery(req1);
            while (res.next())
            {
             comboRef.getItems().addAll(res.getString("numVol"));                 
// comboRef.getItems().addAll(res.getString("villeDepart")+" "+res.getString("villeArrivee")+" "+res.getString("dateDepartAller") +" "+res.getString("numVol"));              
            }}
             break;  
            case "Hotel":    
            {req1 ="select * from hebergement";
            ResultSet res1= ste.executeQuery(req1);
            while (res1.next())
            {
                if("hotel".equals(res1.getString("type")))
                 comboRef.getItems().addAll(res1.getString("nom")); 
            } }break;
            case "Hote":
            {req1 ="select * from hebergement";
            ResultSet res1= ste.executeQuery(req1);
            while (res1.next())
            {
                if("hote".equals(res1.getString("type")))
                 comboRef.getItems().addAll(res1.getString("nom")); 
            }         }break;}  } catch (SQLException ex) {}
    }

    @FXML
    private void enoyerMailClick(ActionEvent event) {
        
        Statement ste;
        try {
            ste = mycon.createStatement();
            String req1;                 
            req1 ="select * from utilisateur";
             ResultSet res= ste.executeQuery(req1);
            while (res.next())
            {
             String to=res.getString("email");
             Mail.sendFromGMaill("smidanizar.ns@gmail.com", "nizar1995", to , sujet.getText(),objet.getText());
    //  System.out.println(to); System.out.println(sujet.getText()); System.out.println(objet.getText());
            }
                      

        } catch (SQLException ex) {}
       
       
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
}

 
    //@FXML
   // private void bntChercherClient(ActionEvent event) 
 //   {   
            //if(tableview.getSelectionModel().getSelectedItem()!=null)
//        { 
//        int cliId = tableview.getSelectionModel().getSelectedItem().getRef_client_fk().getRef();
//        Client client = new Client();
//         ClientService clientService = new ClientService();
//         
//        try {
//            client = clientService.chercherClient(cliId);          
//        } catch (SQLException ex) {
//        }
//        try {
//            FXMLLoader Loader = new FXMLLoader();
//            Loader.setLocation(getClass().getResource("ChercherClient.fxml"));
//            Loader.load();         
//            Parent p = Loader.getRoot();
//            ChercherClientController chaine = Loader.getController();
//            chaine.setList(cliId,client);
//            
//            Stage stage = new Stage();
//            stage.setTitle("GoVoyage");
//            stage.setScene(new Scene(p));
//            stage.show();          
//        } catch (IOException ex) {
//            Logger.getLogger(GestionOffreController.class.getName()).log(Level.SEVERE, null, ex);
//        }}
  //  }
