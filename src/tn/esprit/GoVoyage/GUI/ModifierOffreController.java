/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.GUI;

import tn.esprit.GoVoyage.ConnectionBD.ConnexionBD;
import static tn.esprit.GoVoyage.GUI.GestionOffreController.imlegend;
import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import tn.esprit.GoVoyage.entites.Hebergement;
import tn.esprit.GoVoyage.entites.Offre;
import tn.esprit.GoVoyage.entites.Vol;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import tn.esprit.GoVoyage.services.OffreService;

/**
 * FXML Controller class
 *
 * @author nizar
 */
public class ModifierOffreController implements Initializable {

    
     
    /**
     * Initializes the controller class.
     * @param o
     */
   Connection mycon=ConnexionBD.getInstanceBD().getConnection(); 
   ObservableList<Offre> data = FXCollections.observableArrayList();
   OffreService offreService = new OffreService();
   
    @FXML
    private JFXDatePicker cal1;
    @FXML
    private JFXDatePicker cal2;
    @FXML
    private JFXComboBox<String> comboRef; 
    @FXML
    private JFXTextField text_spec;
    @FXML
    private JFXTextField text_duree;
    @FXML
    private JFXComboBox<String> typeDoffre;
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
    private AnchorPane calend2;
    @FXML
    private Label dureelabel;
    @FXML
    private Label liste_des_vol;
    @FXML
    private JFXButton bnt_ajouter;
    @FXML
    private JFXComboBox<String> typeDoffre1;
    @FXML
    private JFXComboBox<String> comboRef1;
    @FXML
    private Label labelRefhebrg;
    @FXML
    private Label labelRefVol;
    @FXML
    private Label labelref;
    public void refresh() {
        data.clear();
        imlegend.getItems().clear();
        List<Offre> liste;List<Offre> liste1;
        try {
            liste = offreService.AfficherOffreH();
            liste1 = offreService.AfficherOffreV();
             liste.addAll(liste1);data.setAll(liste);
            imlegend.setItems(data);
        } catch (SQLException ex) {}}
    public void setList(String duree,int spec,String type,Hebergement heb,Vol vol,int ref)
    {    
       if("--".equals(vol.getNumVol()))
       {this.comboRef1.setPromptText(heb.getNom());
       this.comboRef.setPromptText(heb.getNom());
       }
       else if (" -- ".equals(heb.getNom()))
       {this.comboRef1.setPromptText(vol.getNumVol());
       this.comboRef.setPromptText(vol.getNumVol());
       }
       this.labelRefhebrg.setText(heb.getId()+"");
       this.labelRefVol.setText(vol.getRef()+"");
        this.text_spec.setText(spec+"");
        this.text_duree.setText(duree);
        this.typeDoffre1.setPromptText(type);
        this.typeDoffre.setPromptText(type); 
        this.labelref.setText(ref+""); 
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                    typeDoffre.getItems().addAll("Vol","Hotel","Hote");
                     // System.out.println(h);
                    
             
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
             case "Hote":
            {req1 ="select * from hebergement";
            ResultSet res1= ste.executeQuery(req1);
            while (res1.next())
            {
                if("hote".equals(res1.getString("type")))
                 comboRef.getItems().addAll(res1.getString("nom")); 
            }         }break;
            case "Hotel":    
            {req1 ="select * from hebergement";
            ResultSet res1= ste.executeQuery(req1);
            while (res1.next())
            {
                if("hotel".equals(res1.getString("type")))
                 comboRef.getItems().addAll(res1.getString("nom")); 
            } }
                     }  } catch (SQLException ex) {}
    }

    @FXML
    private void on_btnAjouter_click(ActionEvent event) throws SQLException {
        
       //  if (typeDoffre.getValue()==null) label3.setText("Ces informations sont nécessaires.");if (typeDoffre.getValue()!=null) label3.setText("");
      // if( comboRef.getValue()==null)label4.setText("Ces informations sont nécessaires.");if( comboRef.getValue()!=null)label4.setText("");
          if( cal1.getValue()==null) label5.setText("Ces informations sont nécessaires."); if( cal1.getValue()!=null) label5.setText("");
              if( cal2.getValue()==null) label6.setText("Ces informations sont nécessaires.");if( cal2.getValue()!=null) label6.setText("");
                  if( "".equals(text_duree.getText())) label1.setText("Ces informations sont nécessaires.");if( !"".equals(text_duree.getText())) label1.setText("");
                      if( "".equals(text_spec.getText())) label2.setText("Ces informations sont nécessaires."); if( !"".equals(text_spec.getText())) label2.setText("");
                      if (( cal1.getValue()!=null)&&( cal2.getValue()!=null)&&( !"".equals(text_duree.getText()))&&( !"".equals(text_spec.getText())))
                {               
        Date Date_debut,Date_fin;           
        Date_debut = java.sql.Date.valueOf( cal1.getValue());
        Date_fin = java.sql.Date.valueOf( cal2.getValue() );
        if ( Date_debut.before(Date_fin))
            {
           Alert alert1 = new Alert(Alert.AlertType.INFORMATION,"Offre Modifier Avec Succés ");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Etes vous sure d'ajouter cette Offre  ?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
           if (alert.getResult() == ButtonType.YES) 
           {
         String typeOffre=typeDoffre.getPromptText();
         String type=comboRef.getPromptText();
         Offre p = new Offre(); Hebergement h = new Hebergement(); Vol v = new Vol();  
          p.setType(typeOffre);
        p.setDuree(text_duree.getText());
        p.setSpecification(parseInt(text_spec.getText()));    
        p.setDateDebut(Date_debut);
        p.setDateFin(Date_fin);
          p.setReference(parseInt(labelref.getText()));   
        switch(typeOffre)
        {    
            case "Vol":    
            { v.setNumVol(type);
            v.setRef(parseInt(labelRefVol.getText()));  
            p.setVol(v);
            offreService.modifierOffreV(p); alert1.showAndWait();
            }
             break;  
            default :   
            { h.setNom(type);
            h.setId(parseInt(labelRefhebrg.getText()));
            p.setHebergement(h);
            offreService.modifierOffreH(p); alert1.showAndWait();
            }
            
        }           
        refresh();
            ((Node)event.getSource()).getScene().getWindow().hide();
           } } else 
      { Alert alert2 = new Alert(Alert.AlertType.INFORMATION,"La date de début doit etre inférieure a la date de fin ");
          alert2.showAndWait();}
                 }         }    }            

