/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.GoVoyage.GUI;

import com.jfoenix.controls.JFXButton;
import tn.esprit.GoVoyage.ConnectionBD.MyBdConnection;
import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;

import tn.esprit.GoVoyage.entites.Clients;
import tn.esprit.GoVoyage.entites.Hebergement;
import tn.esprit.GoVoyage.entites.Reservation;
import tn.esprit.GoVoyage.entites.Vol;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import tn.esprit.GoVoyage.services.ReservationService;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLController implements Initializable {
    @FXML
    private Label votre_carte_label;
    @FXML
    private AnchorPane reserv_hotel;
    @FXML
    private Tab hotels_tab;
    private TableView<Reservation> tableview;
    @FXML
    private TableView<Reservation> treeview1;
    @FXML
    private TextField input_ref_supp;
    @FXML
    private Button Supprimer_butt;
    @FXML
    private Button modifier_butt;
    @FXML
    private AnchorPane tts111;
    @FXML
    private Label label_res_modif1;
    @FXML
    private Button ajouter_butt;
    @FXML
    private Label label_res_modif11;
    @FXML
    private Label label_res_modif111;
    @FXML
    private Label label_res_modif1111;
    @FXML
    private Label label_res_modif11111;
    @FXML
    private Label label_date_du_jour;
    @FXML
    private Tab ajou_res_tab;
    @FXML
    private AnchorPane reservation_card;
    @FXML
    private ComboBox<String> type_combo;
    @FXML
    private ComboBox<String> combo_ref_type;
    @FXML
    private Label nbr_nuit_label;
    @FXML
    private Label input_nbr_nuit;
    @FXML
    private Label label_warning_type;
    @FXML
    private JFXDatePicker calendar_arriv;
    @FXML
    private JFXDatePicker calendar_sortie;
    @FXML
    private Button the_ok_butt;
    @FXML
    private Label label_date_arr;
    @FXML
    private Label label_date_sortie;
    @FXML
    private TextField input_ref_ajout_ref_client;
    @FXML
    private ComboBox<String> input_ref_ajout_adulte;
    @FXML
    private ComboBox<String> input_ref_ajout_enfant;
    @FXML
    private Label blasset_prix_total;
    @FXML
    private ComboBox<String> combo_chbre_single;
    @FXML
    private ComboBox<String> combo_chbre_double;
    @FXML
    private Label label_chbre_single;
    @FXML
    private Label label_chbre_double;
    @FXML
    private Button calcul_butt;
    @FXML
    private Label label_datejour1;
    @FXML
    private Label Label2;
    @FXML
    private Label Label3;
    @FXML
    private Label Label4;
    @FXML
    private Label Label5;
    @FXML
    private Label Label6;
    @FXML
    private Button cancel;
    @FXML
    private ImageView img_carte_res;
    @FXML
    private JFXButton acceuill;

    /**
     * Initializes the controller class.
     */
    
         
       
         public void refresh() {
        treeview1.getItems().clear();
       Reservation r =new Reservation();
       ReservationService rs=new ReservationService();
      
        try {
            List<Reservation> reservations = rs.afficherReservations();
            ObservableList<Reservation> data =rs.afficherReservations();
            data.clear();
             data.setAll(reservations);
            treeview1.setItems(data);
        } catch (SQLException ex) {
          
        }}

      
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
//       
//         public void refresh() {
//        data.clear();
//        treeview1.getItems().clear();
//        List<Reservation> liste;
//        try {
//            liste = reservationService.afficherReservations();
//             data.setAll(liste);
//            treeview1.setItems(data);
//        } catch (SQLException ex) {
//          
//        }
//
//        
        
//        try {
//            ReservationService reservationService = new ReservationService();
//            ObservableList <Reservation> list = reservationService.afficherReservations();
////            
//            TableColumn Ref = new TableColumn("Ref");
//            Ref.setPrefWidth(100);
//            Ref.setCellValueFactory(new PropertyValueFactory<>("ref"));
//            TableColumn type = new TableColumn("Type de la reservation");
//            type.setPrefWidth(150);
//            type.setCellValueFactory(new PropertyValueFactory<>("type"));
//            TableColumn ref_client_fk = new TableColumn("nom de client");
//            ref_client_fk.setPrefWidth(150);
//            ref_client_fk.setCellValueFactory(new PropertyValueFactory<>("ref_client_fk"));
//            TableColumn ref_vol_fk = new TableColumn("ref_vol_fk");
//            ref_vol_fk.setPrefWidth(100);
//            ref_vol_fk.setCellValueFactory(new PropertyValueFactory<>("ref_vol_fk"));
//            TableColumn ref_hebergement_fk = new TableColumn("ref_hebergement_fk");
//            ref_hebergement_fk.setPrefWidth(100);
//            ref_hebergement_fk.setCellValueFactory(new PropertyValueFactory<>("ref_hebergement_fk"));
//            TableColumn date_res = new TableColumn("date de la reservation");
//            date_res.setPrefWidth(120);
//            date_res.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
//            
//            //java.util.Date newDate = result.getDate("VALUEDATE");
//            //ObservableList<Offre> data =FXCollections.observableArrayList(x);
//            tableview.setItems(list);
//            tableview.getColumns().addAll(Ref, type, ref_client_fk,ref_vol_fk,ref_hebergement_fk,date_res);
//            // TODO
//        } catch (SQLException ex) {
//            Logger.getLogger(FXMLGestionReservationController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }    


    
        
 

    @FXML
    private void click_hotel(Event event) {
        treeview1.getColumns().clear();
         try {
            ReservationService reservationService = new ReservationService();
            // System.out.println("nizar");
            ObservableList <Reservation> list = reservationService.afficherReservations();
           ObservableList <Reservation> list1 = reservationService.afficherReservations1();
           list.addAll(list1);
            
            TableColumn Ref = new TableColumn("Ref");
            Ref.setPrefWidth(100);
            Ref.setCellValueFactory(new PropertyValueFactory<>("ref"));
            
            TableColumn type = new TableColumn("Type de la reservation");
            type.setPrefWidth(150);
            type.setCellValueFactory(new PropertyValueFactory<>("type"));
            
            TableColumn ref_client_fk = new TableColumn("ref de client");
            ref_client_fk.setPrefWidth(150);
            ref_client_fk.setCellValueFactory(new PropertyValueFactory<>("ref_client_fk"));
            
            TableColumn ref_vol_fk = new TableColumn("ref_vol_fk");
            ref_vol_fk.setPrefWidth(120);
            ref_vol_fk.setCellValueFactory(new PropertyValueFactory<>("ref_vol_fk"));
            
            TableColumn ref_hebergement_fk = new TableColumn("ref_hebergement_fk");
            ref_hebergement_fk.setPrefWidth(150);
            ref_hebergement_fk.setCellValueFactory(new PropertyValueFactory<>("ref_hebergement_fk"));
            
            TableColumn date_res = new TableColumn("date_res");
            date_res.setPrefWidth(150);
            date_res.setCellValueFactory(new PropertyValueFactory<>("date_res"));
            
             
            TableColumn date_arrivee_h = new TableColumn("date_arrivee");
            date_arrivee_h.setPrefWidth(120);
            date_arrivee_h.setCellValueFactory(new PropertyValueFactory<>("date_arrivee"));
            
            TableColumn date_sortie_h = new TableColumn("date_sortie");
            date_sortie_h.setPrefWidth(150);
            date_sortie_h.setCellValueFactory(new PropertyValueFactory<>("date_sortie"));
            
            TableColumn nbre_Adultes = new TableColumn("nombreAdultes ");
            nbre_Adultes.setPrefWidth(150);
            nbre_Adultes.setCellValueFactory(new PropertyValueFactory<>("nombreAdultes"));
            
             TableColumn nbre_Enfants = new TableColumn("nombreEnfants  ");
            nbre_Enfants.setPrefWidth(150);
            nbre_Enfants.setCellValueFactory(new PropertyValueFactory<>("nombreEnfants"));
            
             TableColumn nbre_nuits = new TableColumn("nbre_nuits");
            nbre_nuits.setPrefWidth(150);
            nbre_nuits.setCellValueFactory(new PropertyValueFactory<>("nombreNuits"));
            
             TableColumn nbre_chbre_single = new TableColumn("nbre_chbre_single");
            nbre_chbre_single.setPrefWidth(150);
            nbre_chbre_single.setCellValueFactory(new PropertyValueFactory<>("nbre_chbre_single"));
            
             TableColumn nbre_chbre_double = new TableColumn("nbre_chbre_double");
            nbre_chbre_double.setPrefWidth(150);
            nbre_chbre_double.setCellValueFactory(new PropertyValueFactory<>("nbre_chbre_double"));
            
             TableColumn prix_total = new TableColumn("prixTotal");
            prix_total.setPrefWidth(150);
            prix_total.setCellValueFactory(new PropertyValueFactory<>("prixTotal"));
             
          
            
            
            
            
            
            
            //ObservableList<Offre> data =FXCollections.observableArrayList(x);
             //System.out.println(list);
            treeview1.setItems(list);
            treeview1.getColumns().addAll(Ref, type, ref_client_fk,ref_vol_fk,ref_hebergement_fk,date_res,date_arrivee_h,
                    date_sortie_h,nbre_Adultes,nbre_Enfants,nbre_nuits,nbre_chbre_single,nbre_chbre_double,prix_total);
            // TODO
        } catch (SQLException ex) {
            
        }
        
    }



    @FXML
    private void on_clicked_supp_butt(ActionEvent event) {
        
        int a=Integer.parseInt(input_ref_supp.getText());
        Reservation r =new Reservation(); 
        r.setRef(a);
         ReservationService reservationService =new ReservationService() ;
      
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
              
        alert.setTitle("Suppression d'une reservation");
        alert.setContentText("Vouslez-vous vraiment supprimer cette reservation ?");
        Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK)
                { 
            try {
                reservationService.supprimerReservation(r);
            } catch (SQLException ex) {
               
            }
                  
                }

    refresh();
    
    }

    @FXML
    private void on_clicked_ajout_butt(ActionEvent event) {
        
        {
        
        int Ref_client=Integer.parseInt(input_ref_ajout_ref_client.getText());      
      
        Date Date_debut,Date_fin;        
        Reservation r =new Reservation(); 
        Clients cli = new Clients(Ref_client);
        
        
        ReservationService reservationService =new ReservationService() ;
      
   
      String test_type =type_combo.getValue();
      r.setType(test_type);
      
      
      if(test_type=="Hote"){
          
         
    if (combo_ref_type.getValue()==null) Label2.setText("Ces informations sont nécessaires.");if (combo_ref_type.getValue()!=null) Label2.setText("");
       if( input_ref_ajout_adulte.getValue()==null)Label3.setText("Ces informations sont nécessaires.");if( input_ref_ajout_adulte.getValue()!=null)Label3.setText("");
          if( input_ref_ajout_enfant.getValue()==null) Label4.setText("Ces informations sont nécessaires."); if( input_ref_ajout_enfant.getValue()!=null) Label4.setText("");
              if( Integer.parseInt(input_nbr_nuit.getText())<1||input_nbr_nuit.getText()=="..") Label5.setText("Veuillez bien parametrer vos dates SVP.");if( Integer.parseInt(input_nbr_nuit.getText())>0&&input_nbr_nuit.getText()!="..") Label5.setText("");
                    
                      if ((combo_chbre_single.getValue()==null)&&( combo_chbre_double.getValue()==null))  Label6.setText("Veuillez choisir les chambres :) ");
          

          
          
          
          
          
    
        Date_debut = java.sql.Date.valueOf( calendar_arriv.getValue());
        Date_fin = java.sql.Date.valueOf( calendar_sortie.getValue() );
      
      int Ref_Type=Integer.parseInt(combo_ref_type.getValue());
        Hebergement h =new Hebergement(Ref_Type);
        r.setRef_hebergement_fk(h);
        r.setDate_arrivee(Date_debut.toString());
        r.setDate_sortie(Date_fin.toString());
        r.setNombreAdultes(Integer.parseInt((String) input_ref_ajout_adulte.getValue()));
        r.setNombreEnfants(Integer.parseInt((String) input_ref_ajout_adulte.getValue()));
        r.setNombreNuits(Integer.parseInt(input_nbr_nuit.getText()));
        
        
        
          float prix_total= Float.parseFloat(blasset_prix_total.getText());
        r.setPrixTotal(prix_total);

        r.setRef_client_fk(cli); 
         String Date_debutString =label_date_du_jour.getText();
        Date d;
        d = java.sql.Date.valueOf( Date_debutString );
        r.setDate_res(d);
          
            
          try {
            if ( Date_debut.before(Date_fin))
            {
            Alert alert = new Alert(AlertType.CONFIRMATION, "Etes vous sure d'ajouter cette Reservation  ?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();

           if (alert.getResult() == ButtonType.YES) 
           {
                    reservationService.ajouterReservationHHote(r);

    Alert alert1 = new Alert(AlertType.INFORMATION,"Reservation Ajoutée Avec Succés ");
    alert1.showAndWait();
}} else {
                 Alert alert2 = new Alert(AlertType.INFORMATION,"La date de début doit etre inférieure a la date de fin ");
    alert2.showAndWait();
            }
            
           
         } catch (SQLException ex) {     }
    

            
            
        
      }
      else if (test_type=="Hotel"){
          
          
           if (combo_ref_type.getValue()==null) Label2.setText("Champs obligatoires.");if (combo_ref_type.getValue()!=null) Label2.setText("");
       if( input_ref_ajout_adulte.getValue()==null)Label3.setText("Champs obligatoires.");if( input_ref_ajout_adulte.getValue()!=null)Label3.setText("");
          if( input_ref_ajout_enfant.getValue()==null) Label4.setText("Champs obligatoires."); if( input_ref_ajout_enfant.getValue()!=null) Label4.setText("");
              if( (Integer.parseInt(input_nbr_nuit.getText())<1)||(input_nbr_nuit.getText()=="..")) Label5.setText("Verifier vos dates SVP.");if( Integer.parseInt(input_nbr_nuit.getText())>0&&input_nbr_nuit.getText()!="..") Label5.setText("");
                    
                      if ((combo_chbre_single.getValue()==null)&&( combo_chbre_double.getValue()==null))  Label6.setText("Veuillez choisir les chambres :) ");
          
          
          
               Date_debut = java.sql.Date.valueOf( calendar_arriv.getValue());
        Date_fin = java.sql.Date.valueOf( calendar_sortie.getValue() );
      
      int Ref_Type=Integer.parseInt(combo_ref_type.getValue());
        Hebergement h =new Hebergement(Ref_Type);
        r.setRef_hebergement_fk(h);
         r.setDate_arrivee(Date_debut.toString());
        r.setDate_sortie(Date_fin.toString());
        r.setNombreAdultes(Integer.parseInt((String) input_ref_ajout_adulte.getValue()));
        r.setNombreEnfants(Integer.parseInt((String) input_ref_ajout_adulte.getValue()));
        r.setNombreNuits(Integer.parseInt(input_nbr_nuit.getText()));
        r.setNbre_chbre_single(Integer.parseInt((String) combo_chbre_single.getValue()));
        r.setNbre_chbre_double(Integer.parseInt((String) combo_chbre_double.getValue()));
        
        
          float prix_total= Float.parseFloat(blasset_prix_total.getText());
        r.setPrixTotal(prix_total);

        r.setRef_client_fk(cli); 
         String Date_debutString =label_date_du_jour.getText();
        Date d;
        d = java.sql.Date.valueOf( Date_debutString );
        r.setDate_res(d);
        
        
          try {
                reservationService.ajouterReservationHHotel(r);
            } catch (SQLException ex) {
               
            }
        
      }
      else if(test_type=="Vol"){
          
          
           if (combo_ref_type.getValue()==null) Label2.setText("Champs obligatoires.");if (combo_ref_type.getValue()!=null) Label2.setText("");
       if( input_ref_ajout_adulte.getValue()==null)Label3.setText("Champs obligatoires.");if( input_ref_ajout_adulte.getValue()!=null)Label3.setText("");
          if( input_ref_ajout_enfant.getValue()==null) Label4.setText("Champs obligatoires."); if( input_ref_ajout_enfant.getValue()!=null) Label4.setText("");
             
          
          
          
          
      int Ref_Type=Integer.parseInt(combo_ref_type.getValue());
        Vol v  =new Vol(Ref_Type);
        r.setRef_vol_fk(v);
         Hebergement h =new Hebergement();
         r.setRef_hebergement_fk(h);
         
          float prix_total= Float.parseFloat(blasset_prix_total.getText());
        r.setPrixTotal(prix_total);

        r.setRef_client_fk(cli); 
        String Date_debutString =label_date_du_jour.getText();
        //String Date_debutString ="2005-12-01";
        r.setNombreAdultes(Integer.parseInt((String) input_ref_ajout_adulte.getValue()));
        r.setNombreEnfants(Integer.parseInt((String) input_ref_ajout_adulte.getValue()));
        Date d;
        d = java.sql.Date.valueOf( Date_debutString );
        r.setDate_res(d);
        
        
          try {
                reservationService.ajouterReservationVol(r);
            } catch (SQLException ex) {
              
            }
        
      }
      else{
          System.out.println("mochkla ");
      }
        
//        float prix_total= Float.parseFloat(blasset_prix_total.getText());
//        r.setPrixTotal(prix_total);
//
//        r.setRef_client_fk(cli); 
//         String Date_debutString =label_date_du_jour.getText();
//        Date d;
//        d = java.sql.Date.valueOf( Date_debutString );
//        r.setDate_res(d);
        
        
//        try {
//            reservationService.ajouterReservation(r);
//            //ReservationService.AfficherReservation();
//         } catch (SQLException ex) {     }
    }
        
        
    }

    @FXML
    private void click_res_ajout(Event event) {
        
        label_date_du_jour.setVisible(false);
        
        
       //remplir combobox_type
        
        ObservableList<String> options = 
    FXCollections.observableArrayList(
        "Vol",
        "Hotel",
        "Hote"
    );

 type_combo.setItems(options);
        
        //******************
        //remplir combobox de chbre single
           
        ObservableList<String> optionssin = 
    FXCollections.observableArrayList(
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11",
        "12",
        "14",
        "15"
    );

 combo_chbre_single.setItems(optionssin);
        
        //remplir combobox de chbre double
        
           ObservableList<String> optionsdoub = 
    FXCollections.observableArrayList(
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11",
        "12",
        "14",
        "15"
    );

 combo_chbre_double.setItems(optionsdoub);
 //***********
 //remplir les combobox nbre enfants et adultes 
     ObservableList<String> optionsAd = 
    FXCollections.observableArrayList(
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11",
        "12",
        "14",
        "15"
    );

 input_ref_ajout_adulte.setItems(optionsAd);
 
   ObservableList<String> optionsEn = 
    FXCollections.observableArrayList(
         "0",
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11",
        "12",
        "14",
        "15"
    );

 input_ref_ajout_enfant.setItems(optionsEn);
 
         
 
 
        
        //*********************
String format1 = "dd/MM/yy H:mm:ss"; 
//String format = "dd-MM-yy";
String format = "yyyy-MM-dd";

java.text.SimpleDateFormat formater1 = new java.text.SimpleDateFormat( format1 ); 
java.util.Date date1 = new java.util.Date(); 
label_datejour1.setText(formater1.format( date1 )); 
        
        
        
java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
java.util.Date date = new java.util.Date(); 
        label_date_du_jour.setText(formater.format( date )); 
        
        
        
        
    }

    @FXML
    private void on_clicked_modif_butt(ActionEvent event) throws IOException {
        
        
        if(treeview1.getSelectionModel().getSelectedItem()!=null)
        {
           int  ref =treeview1.getSelectionModel().getSelectedItem().getRef(); 
      String type=treeview1.getSelectionModel().getSelectedItem().getType();
      Clients ref_client_fk=treeview1.getSelectionModel().getSelectedItem().getRef_client_fk();
      Vol ref_vol_fk=treeview1.getSelectionModel().getSelectedItem().getRef_vol_fk();
      Hebergement ref_hebergement_fk=treeview1.getSelectionModel().getSelectedItem().getRef_hebergement_fk();
      Date date_res=treeview1.getSelectionModel().getSelectedItem().getDate();
      
      String date_arrivee=treeview1.getSelectionModel().getSelectedItem().getDate_arrivee();
      String date_sortie=treeview1.getSelectionModel().getSelectedItem().getDate_sortie();
      int nombreNuits=treeview1.getSelectionModel().getSelectedItem().getNombreNuits(); 
      float prixTotal =treeview1.getSelectionModel().getSelectedItem().getPrixTotal(); 
      int nombreEnfants =treeview1.getSelectionModel().getSelectedItem().getNombreEnfants(); 
      int nombreAdultes =treeview1.getSelectionModel().getSelectedItem().getNombreAdultes();
      int nbre_chbre_single=treeview1.getSelectionModel().getSelectedItem().getNbre_chbre_single() ; 
      int nbre_chbre_double=treeview1.getSelectionModel().getSelectedItem().getNbre_chbre_double() ; 
            
            
        String c=treeview1.getSelectionModel().getSelectedItem().getType();
            System.out.println(c);
 if (c.trim()=="Vol"){
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("FXMLModifReservationVol.fxml"));
        Loader.load();
        FXMLModifReservationController chaine = Loader.getController();
        chaine.setList(nbre_chbre_double,nbre_chbre_single,nombreAdultes,nombreEnfants,prixTotal,
                nombreNuits, date_sortie, date_sortie, date_arrivee, date_res,  ref_hebergement_fk ,ref_vol_fk,ref_client_fk,type,ref);
        Parent p = Loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("GoVoyage");
        stage.setScene(new Scene(p));
        stage.show();
 }
  else if(c=="Hotel"){}
  else if(c=="Hote"){}
  else {
   FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("FXMLModifReservationVol.fxml"));
        Loader.load();
        FXMLModifReservationController chaine = Loader.getController();
        chaine.setList(nbre_chbre_double,nbre_chbre_single,nombreAdultes,nombreEnfants,prixTotal,
                nombreNuits, date_sortie, date_sortie, date_arrivee, date_res,  ref_hebergement_fk ,ref_vol_fk,ref_client_fk,type,ref);
        Parent p = Loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("GoVoyage");
        stage.setScene(new Scene(p));
        stage.show();
  }
 
 
 
 
 
 
 
 
 
        }
        
    }

    @FXML
    private void on_select_ajout_combo(ActionEvent event) {
        String c = type_combo.getValue();
        if (c=="Vol")
        {
            try {
        input_nbr_nuit.setVisible(false);
        nbr_nuit_label.setVisible(false);
        label_warning_type.setVisible(false);
        label_date_arr.setVisible(false);
        label_date_sortie.setVisible(false);
        calendar_arriv.setVisible(false);
        calendar_sortie.setVisible(false);
        the_ok_butt.setVisible(false);
         label_chbre_single.setVisible(false);
        label_chbre_double.setVisible(false);
        combo_chbre_single.setVisible(false);
        combo_chbre_double.setVisible(false);
           
                Connection mycon=MyBdConnection.getInstanceBD().getConnection();
                //String req1 = "select * from vol";
                String req1 = "select `ref` from vol";
                 combo_ref_type.getItems().removeAll(combo_ref_type.getItems());
                Statement ste = mycon.createStatement();
                ResultSet res= ste.executeQuery(req1);
                while (res.next()) {              
                   // combo_ref_type.getItems().addAll(res.getInt("ref")+" "+res.getString("villeDepart")+" "+res.getString("villeArrivee")+" "+res.getDate("dateDepartAller"));
                   combo_ref_type.getItems().addAll(res.getInt("ref")+"");
                }
            } catch (SQLException ex) {
                
            }
        
        
        
        }
        else if(c=="Hotel")
        {  try {
            input_nbr_nuit.setVisible(true);
        nbr_nuit_label.setVisible(true);
        label_warning_type.setVisible(false);
         label_date_arr.setVisible(true);
        label_date_sortie.setVisible(true);
        calendar_arriv.setVisible(true);
        calendar_sortie.setVisible(true);
        the_ok_butt.setVisible(true);
        label_chbre_single.setVisible(true);
        label_chbre_double.setVisible(true);
        combo_chbre_single.setVisible(true);
        combo_chbre_double.setVisible(true);
        
        
        
        
        Connection mycon=MyBdConnection.getInstanceBD().getConnection();
                String req1 = "select `id` from hebergement where type='hotel'";
                combo_ref_type.getItems().removeAll(combo_ref_type.getItems());
               
                Statement ste = mycon.createStatement();
                ResultSet res= ste.executeQuery(req1);
                while (res.next()) {              
                   // combo_ref_type.getItems().addAll(res.getInt("ref")+" "+res.getString("nom")+" "+res.getString("nbEtoile"));
                    combo_ref_type.getItems().addAll(res.getInt("id")+"");
                }
            } catch (SQLException ex) {
                
            }
        
        
        
        }
        else if (c=="Hote")
        {
            try {
                input_nbr_nuit.setVisible(true);
                nbr_nuit_label.setVisible(true);
                label_warning_type.setVisible(false);
                label_date_arr.setVisible(true);
                label_date_sortie.setVisible(true);
                calendar_arriv.setVisible(true);
                calendar_sortie.setVisible(true);
                the_ok_butt.setVisible(true);
                 label_chbre_single.setVisible(false);
                label_chbre_double.setVisible(false);
                combo_chbre_single.setVisible(false);
                combo_chbre_double.setVisible(false);
                
                Connection mycon=MyBdConnection.getInstanceBD().getConnection();
                
                String req1 = "select `id` from hebergement where type='hote'";
                 combo_ref_type.getItems().removeAll(combo_ref_type.getItems());
                
                Statement ste = mycon.createStatement();
                ResultSet res= ste.executeQuery(req1);
                while (res.next()) {              
                   // combo_ref_type.getItems().addAll(res.getInt("ref")+" "+res.getString("nom")+" "+res.getString("nbEtoile"));
                   combo_ref_type.getItems().addAll(res.getInt("id")+"");
                }
            } catch (SQLException ex) {
                
            }
        
        
        }
        else {
        label_warning_type.setVisible(true);
        
        }
        
        
        
    }

    @FXML
    private void on_click_(ActionEvent event) {
    }

    @FXML
    private void on_click_ok_butt(ActionEvent event) {
        
//        
//        Date oDate = java.sql.Date.valueOf(calendar_arriv.getValue()); 
//        Date oDate1 = java.sql.Date.valueOf(calendar_sortie.getValue()); 
//DateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//DateFormat oDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
//int  daysBetween = DAYS.between(calendar_arriv.getValue(), calendar_sortie.getValue());
long c= ChronoUnit.DAYS.between(calendar_arriv.getValue(), calendar_sortie.getValue());
//String szDate = oDateFormat.format(oDate);

       String  s=c+"";
       input_nbr_nuit.setText(s);
       
       
    }

    @FXML
    private void on_click_calcul_butt(ActionEvent event) {
      
        
        float amount;
        amount = (Float.parseFloat(input_ref_ajout_adulte.getValue())+Float.parseFloat(input_ref_ajout_enfant.getValue())*200);
        String strAmount=String.valueOf(amount);
        blasset_prix_total.setText(strAmount); 
        
        
        
    }

    @FXML
    private void cancelClick(ActionEvent event) {
        
    Stage stage = (Stage) cancel.getScene().getWindow();
    stage.close();

    }

    @FXML
    private void acceuil(ActionEvent event) {
         Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("ClientsSpace.fxml"));
       
             Scene admin = new Scene (root);
             Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage.setTitle("Ma page d'administrateur");
             app_stage.setScene(admin);
             
             app_stage.show();
              } catch (IOException ex) {
        }
    }

    
    
    
  
    
    
}
