/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.GUI;

import tn.esprit.GoVoyage.ConnectionBD.MyBDConx;
import tn.esprit.GoVoyage.entites.Clients;
import tn.esprit.GoVoyage.entites.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.esprit.GoVoyage.services.ClientsMethodes;

/**
 * FXML Controller class
 *
 * @author Kouka
 */
public class GestionclientsController implements Initializable {
    
        ObservableList<String> gender = FXCollections.observableArrayList("féminin","masculin");
        @FXML
//        private TableView<Clients> clientstab;
         private TableView <Clients> clientstab;
        @FXML
        private TableColumn<Clients, String> Ref ;
         @FXML
        private TableColumn<Clients, String> Nom ;
          @FXML
        private TableColumn<Clients, String> Prenom ;
           @FXML
        private TableColumn<Clients, String> Sexe ;
    @FXML
        private TableColumn<Clients, String> Numéro_Passeport ;
             @FXML
        private TableColumn<Clients, String> Email ;
              @FXML
        private TableColumn<Clients, String> Mdp ;
        @FXML
        private TableColumn<Clients, String> Role ;
               @FXML
        private TableColumn<Clients, String> Username ;
               Clients c = new Clients ();
               ClientsMethodes clientsmethodes = new ClientsMethodes();
        private ObservableList<Clients> data = FXCollections.observableArrayList(clientsmethodes.getAll());
        
       
        
          
    @FXML
    //private TableView<?> reclamationstab;
    //@FXML
    private ComboBox<String> filtrer;
    @FXML
    private TextField recherche;
    //Clients c = new Clients ();
    private Text iduser;
    
                ObservableList<String> role1 = FXCollections.observableArrayList("Administrateur","Client","Proprietaire");

    
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                filtrer.setItems(role1);

        
//        iduser.setText("ID User Logged in : " +String.valueOf(idUserOnline));
        
        
        Ref.setCellValueFactory(new PropertyValueFactory<Clients,String>("Ref"));
        Nom.setCellValueFactory(new PropertyValueFactory<Clients,String>("Nom"));
        Prenom.setCellValueFactory(new PropertyValueFactory<Clients,String>("Prenom"));
        Username.setCellValueFactory(new PropertyValueFactory<Clients,String>("Username"));
        Email.setCellValueFactory(new PropertyValueFactory<Clients,String>("Email"));
        Sexe.setCellValueFactory(new PropertyValueFactory<Clients,String>("Sexe"));
        Mdp.setCellValueFactory(new PropertyValueFactory<Clients,String>("Mdp"));
        Numéro_Passeport.setCellValueFactory(new PropertyValueFactory<Clients,String>("Numéro_Passeport"));
               Role.setCellValueFactory(new PropertyValueFactory<Clients,String>("Role"));
               clientstab.setVisible(true);
       // Sélectionner.setVisible(true);
        //tabb.setVisible(true);

       clientstab.setItems(data);


            
        
        
         
               
            
            
            clientstab.setEditable(true);
           
           
            
            Nom.setCellFactory(TextFieldTableCell.forTableColumn());
            
            
            
            Prenom.setCellFactory(TextFieldTableCell.forTableColumn());
           
            Username.setCellFactory(TextFieldTableCell.forTableColumn());
            
            Email.setCellFactory(TextFieldTableCell.forTableColumn());
            
            Numéro_Passeport.setCellFactory(TextFieldTableCell.forTableColumn());
            Mdp.setCellFactory(TextFieldTableCell.forTableColumn());
            Role.setCellFactory(TextFieldTableCell.forTableColumn());

         
            
            
                        
//            FilteredList<Clients> FiltreRef = new FilteredList <> (data , e -> true);
//          recherche.setOnKeyPressed(e -> {
//              recherche.textProperty().addListener((observableValue, oldValue, newValue) -> {
//                
//              FiltreRef.setPredicate((Predicate<?super Clients >) user -> {
//                  if ( newValue == null || newValue.isEmpty()){
//                  return true;
//              }
//                        String LowerCaseFilter = newValue.toLowerCase();
////                      if (String.valueOf(user.getRef()).contains(newValue)) {
////                          return true;
////                          
////                      }else 
//                        if (user.getUsername().toLowerCase().contains(LowerCaseFilter)) {
//                          return true;
////                      }else if (user.getNom().toLowerCase().contains(LowerCaseFilter)) {
////                          return true;
//                      }
//                      return false;
//          });
//                  
//          });
//              SortedList<Clients> sortedData = new SortedList<>(FiltreRef);
//          sortedData.comparatorProperty().bind(clientstab.comparatorProperty());
//          clientstab.setItems(sortedData);
//              
//          });
            
             data = clientsmethodes.getAll();
         clientstab.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> 
            {      if (newSelection != null) {  }     });
        
            recherche.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                filter(oldValue, newValue);
            }}); }
         //catch (SQLException ex) {   } }      
    

    public void filter(String oldValue, String newValue) {
        if (newValue == null || oldValue.length() == newValue.length() || oldValue == null) 
        {
            clientstab.setItems(data);
        }
        else {
            ObservableList<Clients> filter = FXCollections.observableArrayList();
            for (Clients c : data) {             
                if ((c.getNom()).contains(newValue)||(c.getUsername()).contains(newValue)) 
                {     
                    filter.add(c);
                }  }
            clientstab.setItems(filter);  
       }}
            
            
            
            

    @FXML
    public void changeusername (TableColumn.CellEditEvent edittedCell) throws SQLException {
        ClientsMethodes utili = new ClientsMethodes();
        ObservableList<Clients>   allnames ;
         

                Clients nameselected = new Clients ();
                Reclamation recselected = new Reclamation();

        nameselected = clientstab.getSelectionModel().getSelectedItem();
         
      
     
        nameselected.setUsername(edittedCell.getNewValue().toString());
         Pattern pat = Pattern.compile("[a-zA-Z0-9]+");
        Matcher m = pat.matcher(nameselected.getUsername());
        
    if (m.find()&& m.group().equals(nameselected.getUsername()))
                utili.modifierClient(nameselected);

         
        
        
//    }
    else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Username incorrect");
                    alert.setContentText("Veuillez saisir votre username");
                    alert.show();
                }
        
        
        
        
      //  recselected.setRef(edittedCell.getNewValue().toString());
         
        
    }
    @FXML
     public void changename (TableColumn.CellEditEvent edittedCell) throws SQLException {
        ClientsMethodes utili = new ClientsMethodes();
        ObservableList<Clients>   allnames ;
         

                Clients nameselected = new Clients ();

        nameselected = clientstab.getSelectionModel().getSelectedItem();
        
     
        nameselected.setNom(edittedCell.getNewValue().toString());
        Pattern pat = Pattern.compile("[a-zA-Z]+");
        Matcher m = pat.matcher(nameselected.getNom());
    if (m.find()&& m.group().equals(nameselected.getNom()))
        utili.modifierClient(nameselected);
    else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Nom incorrect");
                    alert.setContentText("Veuillez saisir votre nom");
                    alert.show();
                }
         
        utili.modifierClient(nameselected);
    }
     
     
     
     
    @FXML
      public void changeprenom (TableColumn.CellEditEvent edittedCell) throws SQLException {
        ClientsMethodes utili = new ClientsMethodes();
        ObservableList<Clients>   allnames ;
         

                Clients nameselected = new Clients ();

        nameselected = clientstab.getSelectionModel().getSelectedItem();
        
     
        nameselected.setPrenom(edittedCell.getNewValue().toString());
        Pattern pat = Pattern.compile("[a-zA-Z]+");
        Matcher m = pat.matcher(nameselected.getPrenom());
    if (m.find()&& m.group().equals(nameselected.getPrenom()))
        utili.modifierClient(nameselected);
    else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Prenom incorrect");
                alert.setContentText("Veuiilez saisir votre prenom");
                alert.show();
            } 
         
    }
      
      
      
      
    @FXML
       public void changeemail (TableColumn.CellEditEvent edittedCell) throws SQLException {
        ClientsMethodes utili = new ClientsMethodes();
        ObservableList<Clients>   allnames ;
         

                Clients nameselected = new Clients ();

        nameselected = clientstab.getSelectionModel().getSelectedItem();
        
     
        nameselected.setEmail(edittedCell.getNewValue().toString());
        Pattern pat = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = pat.matcher(nameselected.getEmail());
    if (m.find()&& m.group().equals(nameselected.getEmail()))
        utili.modifierClient(nameselected);   

             
    else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Email incorrect");
                    alert.setContentText("Veuillez saisir votre email");
                    alert.show();
                   
                }
         
    }
       
       
       
    @FXML
    public void changemdp (TableColumn.CellEditEvent edittedCell) throws SQLException {
        ClientsMethodes utili = new ClientsMethodes();
        ObservableList<Clients>   allnames ;
         

                Clients nameselected = new Clients ();

        nameselected = clientstab.getSelectionModel().getSelectedItem();
        
     
        nameselected.setMdp(edittedCell.getNewValue().toString());
          Pattern pat = Pattern.compile("[a-zA-Z0-9]+");
        Matcher m = pat.matcher(nameselected.getUsername());
    if (m.find()&& m.group().equals(nameselected.getUsername()))
utili.modifierClient(nameselected);   
    else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
    
            alert.setTitle(" MDP incorrect");
            alert.setContentText("Veuillez saisir votre mot de passe \n \"Votre mot de passe doit au moin contenir une lettre majuscule, une lettte miniscule et un chiffre\"");
            alert.show();
         
    } }
    
    
    
  
     
     
     
     
    @FXML
      public void changepass (TableColumn.CellEditEvent edittedCell) throws SQLException {
        ClientsMethodes utili = new ClientsMethodes();
        ObservableList<Clients>   allnames ;
         

                Clients nameselected = new Clients ();

        nameselected = clientstab.getSelectionModel().getSelectedItem();
        
     
        nameselected.setPasseport(edittedCell.getNewValue().toString());
        
        Pattern pat = Pattern.compile("[a-zA-Z0-9]+");
        Matcher m = pat.matcher(nameselected.getPasseport());
    if (m.find()&& m.group().equals(nameselected.getPasseport()))
utili.modifierClient(nameselected);
    else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Numéro passeport incorrect");
                    alert.setContentText("Veuillez saisir votre Numéro de passeport");
                    alert.show();
                }
         
        
    }
        
        
    
    
    public ObservableList<Clients> getClients () throws SQLException {
        ObservableList<Clients> clients = FXCollections.observableArrayList();
        try {
         Connection mycon= MyBDConx.getInstanceBD().getConnection();
            String req1 = "select * from utilisateur";
            
            Statement ste = mycon.createStatement();
            ResultSet res= ste.executeQuery(req1);
            while (res.next()) {
                clients.add(new Clients(res.getInt(1), res.getString(2), 
                        res.getString(3), res.getString(4), res.getString(7), res.getString(6),
                        res.getString(11), res.getString(12), res.getString(13)));
            
            clientstab.setItems(data);
            }
         }
        catch (SQLException ex){
            System.err.println("Error"+ex);
        }
        return clients;
        
        
  }
    
   
    
    
        
        
        
        

    @FXML
    private void delete(ActionEvent event) throws SQLException {
        Connection mycon= MyBDConx.getInstanceBD().getConnection();
        Clients c = new Clients ();
        int id =0;
        
        ClientsMethodes utili = new ClientsMethodes();
        ObservableList<Clients> productSelected , allClients ;
        allClients =  clientstab.getItems();
        
         productSelected = clientstab.getSelectionModel().getSelectedItems();
         //productSelected.forEach(allClients::remove);
         for (Clients product : productSelected) {
             id = id+product.getRef();
             
             
         
             allClients.removeAll(productSelected);
         System.out.println(id);
        
//         c.setRef(productSelected.get(c.getRef()));
//         utili.supprimerClient(c);
//////         System.out.println(allClients.get(1));
        c.setRef(id);
       
       utili.supprimerClient(c);

        
        }
    }
    

//        
   

    private void Modifier(ActionEvent event) throws SQLException {
        
        
        
               Connection mycon= MyBDConx.getInstanceBD().getConnection();
        Clients c = new Clients ();
        int id =0;
        
        ClientsMethodes utili = new ClientsMethodes();
        ObservableList<Clients> productSelected , allClients ;
        allClients =  clientstab.getItems();
        
         productSelected = clientstab.getSelectionModel().getSelectedItems();
         //productSelected.forEach(allClients::remove);
         for (Clients product : productSelected) {
             id = id+product.getRef();

        
        
        
    }}
         public void FAdmin () { 
             clientstab.setVisible(false);
        //.setVisible(false);
             

        ObservableList<Clients> roles = FXCollections.observableArrayList(clientsmethodes.FiltrerAdmin());
        
                   

        Ref.setCellValueFactory(new PropertyValueFactory<Clients,String>("Ref"));
        Nom.setCellValueFactory(new PropertyValueFactory<Clients,String>("Nom"));
        Prenom.setCellValueFactory(new PropertyValueFactory<Clients,String>("Prenom"));
        Username.setCellValueFactory(new PropertyValueFactory<Clients,String>("Username"));
        Email.setCellValueFactory(new PropertyValueFactory<Clients,String>("Email"));
        Sexe.setCellValueFactory(new PropertyValueFactory<Clients,String>("Sexe"));
        Mdp.setCellValueFactory(new PropertyValueFactory<Clients,String>("Mdp"));
        Numéro_Passeport.setCellValueFactory(new PropertyValueFactory<Clients,String>("Numéro_Passeport"));
               Role.setCellValueFactory(new PropertyValueFactory<Clients,String>("Role"));

        clientstab.setVisible(true);
       // Sélectionner.setVisible(true);
        //tabb.setVisible(true);

       clientstab.setItems(roles);

             
         }
          public void FClient () { 
             clientstab.setVisible(false);
        //.setVisible(false);
             

        ObservableList<Clients> roles = FXCollections.observableArrayList(clientsmethodes.FiltrerClient());
        
                   

        Ref.setCellValueFactory(new PropertyValueFactory<Clients,String>("Ref"));
        Nom.setCellValueFactory(new PropertyValueFactory<Clients,String>("Nom"));
        Prenom.setCellValueFactory(new PropertyValueFactory<Clients,String>("Prenom"));
        Username.setCellValueFactory(new PropertyValueFactory<Clients,String>("Username"));
        Email.setCellValueFactory(new PropertyValueFactory<Clients,String>("Email"));
        Sexe.setCellValueFactory(new PropertyValueFactory<Clients,String>("Sexe"));
        Mdp.setCellValueFactory(new PropertyValueFactory<Clients,String>("Mdp"));
        Numéro_Passeport.setCellValueFactory(new PropertyValueFactory<Clients,String>("Numéro_Passeport"));
               Role.setCellValueFactory(new PropertyValueFactory<Clients,String>("Role"));

        clientstab.setVisible(true);
       // Sélectionner.setVisible(true);
        //tabb.setVisible(true);

       clientstab.setItems(roles);

             
         }
          public void FProp() { 
             clientstab.setVisible(false);
        //.setVisible(false);
             

        ObservableList<Clients> roles = FXCollections.observableArrayList(clientsmethodes.FiltrerProp());
        
                   

        Ref.setCellValueFactory(new PropertyValueFactory<Clients,String>("Ref"));
        Nom.setCellValueFactory(new PropertyValueFactory<Clients,String>("Nom"));
        Prenom.setCellValueFactory(new PropertyValueFactory<Clients,String>("Prenom"));
        Username.setCellValueFactory(new PropertyValueFactory<Clients,String>("Username"));
        Email.setCellValueFactory(new PropertyValueFactory<Clients,String>("Email"));
        Sexe.setCellValueFactory(new PropertyValueFactory<Clients,String>("Sexe"));
        Mdp.setCellValueFactory(new PropertyValueFactory<Clients,String>("Mdp"));
        Numéro_Passeport.setCellValueFactory(new PropertyValueFactory<Clients,String>("Numéro_Passeport"));
               Role.setCellValueFactory(new PropertyValueFactory<Clients,String>("Role"));

        clientstab.setVisible(true);
       // Sélectionner.setVisible(true);
        //tabb.setVisible(true);

       clientstab.setItems(roles);

             
         }
         
    
        @FXML
    private void ComboboxFiltrer(ActionEvent event) {
                if (filtrer.getValue() == "Administrateur" ){
                 FAdmin();
    }
                else if (filtrer.getValue()=="Client") {
                 FClient();
    }
                 else if (filtrer.getValue()=="Proprietaire") {
                 FProp();
    }
               
    }


       

 

    @FXML
    private void retour(ActionEvent event) throws IOException {
          
                 Parent root = FXMLLoader.load(getClass().getResource("Administrateur.fxml"));
             Scene admin = new Scene (root);
             Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             app_stage.setTitle("Ma page d'administrateur");
             app_stage.setScene(admin);
             
             app_stage.show();
    }
    
}
