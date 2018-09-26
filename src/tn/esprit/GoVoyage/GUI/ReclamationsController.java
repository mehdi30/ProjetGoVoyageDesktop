/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.GUI;

import tn.esprit.GoVoyage.ConnectionBD.MyBDConx;
import tn.esprit.GoVoyage.entites.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.esprit.GoVoyage.services.Reclamationmethodes;
import static tn.esprit.GoVoyage.GUI.ClientXMLController.idUserOnline;
import tn.esprit.GoVoyage.entites.Clients;

/**
 * FXML Controller class
 *
 * @author Kouka
 */
public class ReclamationsController implements Initializable {
    
     @FXML
        private TableView <Reclamation> reclamationstab;
        
     @FXML
        private TableColumn<Reclamation, String> ref ;
        @FXML
        private TableColumn<Reclamation, String> Description ;
        private ObservableList<Reclamation> data1 =
            FXCollections.observableArrayList(
            new Reclamation());
    @FXML
    private Text iduser;
   // private TableColumn<?, ?> ref;
    @FXML
    private TextField recherche;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                Reclamationmethodes reclamationmethode = null;
         try {
             reclamationmethode = new Reclamationmethodes();
         } catch (SQLException ex) {
             Logger.getLogger(ReclamationsController.class.getName()).log(Level.SEVERE, null, ex);
         }

         iduser.setText("ID User Logged in : " +String.valueOf(idUserOnline));
        
//         iduser.setText("ID User Logged in : " +String.valueOf(idUserOnline));
        
         
         ref.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("ref"));
        Description.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("Description"));
        
        
        reclamationstab.setItems(getReclamation());
            
        
          reclamationstab.setEditable(true);
       
        // TODO
    
     data1 = reclamationmethode.getAll();
         reclamationstab.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> 
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
            reclamationstab.setItems(data1);
        }
        else {
            ObservableList<Reclamation> filter = FXCollections.observableArrayList();
            for (Reclamation c : data1) {             
                if (String.valueOf(c.getRef()).contains(newValue)) 
                {     
                    filter.add(c);
                }  }
            reclamationstab.setItems(filter);  
       }
    }
    
      public ObservableList <Reclamation>  getReclamation() {
          ObservableList<Reclamation> recl = FXCollections.observableArrayList();
        try {
         Connection mycon= MyBDConx.getInstanceBD().getConnection();
            String req1 = "select * from reclamation";
            
            Statement ste = mycon.createStatement();
            ResultSet res= ste.executeQuery(req1);
            while (res.next()) {
                recl.add(new Reclamation(res.getInt("ref"),res.getString("description") ));
            
            reclamationstab.setItems(recl);
            }
         }
        catch (SQLException ex){
            System.err.println("Error"+ex);
        }
        return recl ;
        
        
        
    }

    @FXML
    private void supprimer1(ActionEvent event) throws SQLException {
           Connection mycon= MyBDConx.getInstanceBD().getConnection();
        Reclamation r = new Reclamation ();
        int id =0;
        
        Reclamationmethodes rec = new Reclamationmethodes();
        ObservableList<Reclamation> productSelected , allReclamations ;
        allReclamations =  reclamationstab.getItems();
        
         productSelected = reclamationstab.getSelectionModel().getSelectedItems();
         //productSelected.forEach(allClients::remove);
         for (Reclamation product : productSelected) {
             id = id+product.getRef();
             
             
         
             allReclamations.removeAll(productSelected);
         System.out.println(id);
        
//         c.setRef(productSelected.get(c.getRef()));
//         utili.supprimerClient(c);
//////         System.out.println(allClients.get(1));
        r.setRef(id);
       
       rec.supprimerReclamation(r);

        
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
