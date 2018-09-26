/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.GUI;

import tn.esprit.GoVoyage.entites.Clients;
import tn.esprit.GoVoyage.entites.Proprietaire;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tn.esprit.GoVoyage.services.ClientsMethodes;
import tn.esprit.GoVoyage.services.ProprietaireMethodes;

/**
 * FXML Controller class
 *
 * @author Kouka
 */
public class InscriptionxmlController implements Initializable {
    
     public static int idUserOnline;
    
    public static int getidUserOnline () {
        
        return idUserOnline;
    }
    
    
 
    
 
    
    ObservableList<String> gender = FXCollections.observableArrayList("féminin","masculin");
        ObservableList<String> nation = FXCollections.observableArrayList("tunisienne",
            "francaise",
            "americaine");
        ObservableList<String> choice = FXCollections.observableArrayList("oui","non");
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField cin;
    @FXML
    private TextField tel;
    @FXML
    private ComboBox<String> nationalite;
    @FXML
    private ComboBox<String> sexe;
    @FXML
    private DatePicker date;
    @FXML
    private TextField username1;
    @FXML
    private TextField mdp1;
    @FXML
    private ComboBox<String> choix;
    @FXML
    private Button inscription;
    @FXML
    private TextField nomprop1;
    @FXML
    private TextField passport;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          sexe.setValue("féminin");
        sexe.setItems(gender);
        
        nationalite.setValue("tunisienne");
        nationalite.setItems(nation);
        
        choix.setValue("non");
        choix.setItems(choice);
        
        //choix.getSelectionModel().selectedItemProperty().addListener((v , oldValue, newValue )->  );
        
      
        
        
        final DatePicker datePicker = new DatePicker();
datePicker.setOnAction(new EventHandler() {
     public void handle(Event t) {
         LocalDate date = datePicker.getValue();
       //  System.err.println("Selected date: " + date);
     }
 });
        // TODO
    }
      private boolean validateEmail(){
         Pattern pat = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = pat.matcher(email.getText());
    if (m.find()&& m.group().equals(email.getText()))
            return true; 
    else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Email incorrect");
                    alert.setContentText("Veuillez saisir votre email");
                    alert.show();
                    return false;
                }} 
    
    private boolean validatenom(){
         
        Pattern pat = Pattern.compile("[a-zA-Z]+");
        Matcher m = pat.matcher(nom.getText());
    if (m.find()&& m.group().equals(nom.getText()))
            return true; 
    else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Nom incorrect");
                    alert.setContentText("Veuillez saisir votre nom");
                    alert.show();
                    return false;
                }
        
        
    }
    private boolean validateprenom() {
        Pattern pat = Pattern.compile("[a-zA-Z]+");
        Matcher m = pat.matcher(prenom.getText());
    if (m.find()&& m.group().equals(prenom.getText()))
            return true; 
    else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Prenom incorrect");
                alert.setContentText("Veuiilez saisir votre prenom");
                alert.show();
                return false;
            } 
      
    }
    private boolean validatecin () {
        Pattern pat = Pattern.compile("[0-9]+");
        Matcher m = pat.matcher(cin.getText());
    if (m.find()&& m.group().equals(cin.getText()))
            return true; 
    else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("CIN incorrect");
            alert.setContentText("Veuillez saisir votre CIN");
            alert.show();
            return false;
        } 
        
    }
    private boolean validatetel() {
        Pattern pat = Pattern.compile("[0-9]+");
        Matcher m = pat.matcher(tel.getText());
    if (m.find()&& m.group().equals(tel.getText()))
            return true; 
    else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Numéro téléphone incorrect");
            alert.setContentText("Veuillez saisir votre numéro téléphone");
            alert.show();
            return false;
        } 
    }
    private boolean validatemdp () {
         Pattern pat = Pattern.compile("[a-zA-Z0-9]+");
        Matcher m = pat.matcher(mdp1.getText());
    if (m.find()&& m.group().equals(mdp1.getText()))
            return true; 
    else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
    
            alert.setTitle(" MDP incorrect");
            alert.setContentText("Veuillez saisir votre mot de passe \n \"Votre mot de passe doit au moin contenir une lettre majuscule, une lettte miniscule et un chiffre\"");
            alert.show();
            return false;
        } 
    }
    private boolean validateusername () throws SQLException {
        ClientsMethodes utili = new ClientsMethodes();
        
          Pattern pat = Pattern.compile("[a-zA-Z0-9]+");
        Matcher m = pat.matcher(username1.getText());
        
    if (m.find()&& m.group().equals(username1.getText()))
            return true; 
    
//    else if (username1.getText().equals(utili.uniqueuser())) {
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Username existant");
//                    alert.setContentText("Veuillez saisir un autre username");
//                    alert.show();
//                    return false;
        
        
//    }
    else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Username incorrect");
                    alert.setContentText("Veuillez saisir votre username");
                    alert.show();
                    return false;
                }
        } 
    
    private boolean validatepass() {
         Pattern pat = Pattern.compile("[a-zA-Z0-9]+");
        Matcher m = pat.matcher(username1.getText());
    if (m.find()&& m.group().equals(username1.getText()))
            return true; 
    else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Numéro passeport incorrect");
                    alert.setContentText("Veuillez saisir votre Numéro de passeport");
                    alert.show();
                    return false;
                }
        
    }
    private boolean validateprop (){
        Pattern pat = Pattern.compile("[a-zA-Z]+");
        Matcher m = pat.matcher(nomprop1.getText());
    if (m.find()&& m.group().equals(nomprop1.getText()))
            return true; 
    else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Nom de la Propriete incorrect");
                    alert.setContentText("Veuillez saisir le Nom de votre Propriete");
                    alert.show();
                    return false;
                }
    }
    
         

    @FXML
    private void inscription(ActionEvent event) throws SQLException, IOException {
       
        ClientsMethodes clientsmethodes = new ClientsMethodes();
        Clients c = new Clients();
        ProprietaireMethodes proprietairemethodes = new ProprietaireMethodes();
        Proprietaire p = new Proprietaire ();
       
        
         
        
// 

 
            
          c.setNom(nom.getText());
        c.setPrenom(prenom.getText());
        c.setEmail(email.getText());
                c.setCin(cin.getText());
                c.setTel(tel.getText());
                c.setSexe(sexe.getValue());
                c.setNationalite(nationalite.getValue());
                 c.setDateDeNaissance(date.getEditor().getText());
                 c.setPasseport(passport.getText());
                
       
         
         
         c.setUsername(username1.getText());
         c.setMdp(mdp1.getText());
         
         
         
//         c.setDateDeNaissance(date.get);
            p.setNom(nom.getText());
        p.setPrenom(prenom.getText());
        p.setEmail(email.getText());
        p.setCin(cin.getText());
        p.setTel(tel.getText());
        p.setDateDeNaissance(date.getEditor().getText());
        
        
            p.setSexe(sexe.getValue());
                p.setNationalite(nationalite.getValue());
                                 p.setPasseport(passport.getText());

         
         
     
         p.setUsername(username1.getText());
         p.setMdp(mdp1.getText());
         p.setNom_propriete(nomprop1.getText());
         
    

       
 
//                if (email.getText().equals("")) 
//                {
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Email incorrect");
//                    alert.setContentText("Veuillez saisir votre email");
//                    alert.show();
//                } 
//                else 
//                else 
//            {
//                if (email.getText().equals(c.getEmail()) ) 
//                {
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Email incorrect");
//                    alert.setContentText("Cet email existe déjà");
//                    alert.show();
//                } 
                
                
                
//                else {
//                 if (cin.getText().equals(c.getCin())) 
//        {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("CIN incorrect");
//            alert.setContentText("Ce numéro de CIN existe déjà");
//            alert.show();
//        } 
                
                
//                 else 
//            {
//                if (username.getText().equals(c.getUsername())) 
//                {
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Email incorrect");
//                    alert.setContentText("Ce username existe déjà");
//                    alert.show();
//                } 
                
            
                
               
                        
                                
                   
        
//                                Clients utili = new Clients(username1.getText(),nom.getText(), prenom.getText(),cin.getText(), email.getText(),mdp1.getText(),nationalite.getPromptText(),date.getAccessibleText(),tel.getText(), mdp.getText(),sexe.getValue(),Role.Client);
//                                clientsmethodes.ajouterClient(utili);
//                                Proprietaire prop = new Proprietaire(nomprop.getText(),username1.getText(),nom.getText(), prenom.getText(),cin.getText(), email.getText(),mdp1.getText(),nationalite.getPromptText(),date.getAccessibleText(),tel.getText(), mdp.getText(),sexe.getValue(),Role.Proprietaire);
//                                proprietairemethodes.ajouterProprietaire(prop);
         if ( validateEmail() && validatecin() && validatemdp() && validatenom() && validatepass() && 
                     validateprenom()  && validatetel() && validateusername() )
         {
         if (choix.getValue().equals("non")) {
//             nomprop1.setVisible(false);
//             nomprop.setVisible(false);
//             
             
            clientsmethodes.ajouterClient(c);
             Parent root = FXMLLoader.load(getClass().getResource("ClientXML.fxml"));
             Scene admin = new Scene (root);
             Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage.setTitle("Ma page d'administrateur");
             app_stage.setScene(admin);
             
             app_stage.show();
        } else  
         { if (validateprop()) {
//             nomprop1.setVisible(true);
//             nomprop.setVisible(true);
         
        
         proprietairemethodes.ajouterProprietaire (p);
         JOptionPane.showMessageDialog(null, "Inscription effectuée avec succes !!");
          Parent root = FXMLLoader.load(getClass().getResource("ClientXML.fxml"));
             Scene admin = new Scene (root);
             Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage.setTitle("Ma page d'administrateur");
             app_stage.setScene(admin);
             
             app_stage.show();
//        } else {
//        }
        }  } } 
          
    
    }

    @FXML
    private void enleve(ActionEvent event) {
        nom.setText("");
     prenom.setText("");
     email.setText("");
    cin.setText("");
     tel.setText("");
     nationalite.setValue("");
    
    
     date.setValue(LocalDate.now());
     username1.setText("");
     mdp1.setText("");
   
    
   nomprop1.setText("");
    passport.setText("");
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
          
                 Parent root = FXMLLoader.load(getClass().getResource("ClientXML.fxml"));
             Scene admin = new Scene (root);
             Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage.setTitle("Ma page d'administrateur");
             app_stage.setScene(admin);
             
             app_stage.show();
    }
    
}
