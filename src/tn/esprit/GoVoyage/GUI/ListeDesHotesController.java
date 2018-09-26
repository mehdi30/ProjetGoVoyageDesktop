/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tn.esprit.GoVoyage.entites.MaisonHotes;
import tn.esprit.GoVoyage.services.HebergementService;
import tn.esprit.GoVoyage.services.HotelService;
import tn.esprit.GoVoyage.services.MaisonHoteService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ListeDesHotesController implements Initializable {

    @FXML
    private ComboBox<String> hotes_combo;
    @FXML
    private Button reserverHotes;
    @FXML
    private Button retourHotes;
    @FXML
    private TableView<MaisonHotes> tableHotes;
ObservableList<String> ListHotes =FXCollections.observableArrayList("Tunis","Paris","Amesterdam","Italie");
    @FXML
    private TableColumn<MaisonHotes, String> t_nom;
    @FXML
    private TableColumn<MaisonHotes, String> t_add;
    @FXML
    private TableColumn<MaisonHotes, Float> t_pn;
    @FXML
    private TableColumn<MaisonHotes, Integer> t_numTel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    HotelService h = new HotelService();  
   t_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
   t_add.setCellValueFactory(new PropertyValueFactory<>("adresse"));
   t_pn.setCellValueFactory(new PropertyValueFactory<>("PrixNuit"));
   t_numTel.setCellValueFactory(new PropertyValueFactory<>("numerotel"));

     

    hotes_combo.setItems(ListHotes);       
// TODO
    }    

    @FXML
    private void hote_comboAction(ActionEvent event) throws SQLException {
    
        ObservableList<MaisonHotes> rmaison = FXCollections.observableArrayList();
        MaisonHotes m =new MaisonHotes();
        MaisonHoteService ma= new MaisonHoteService();  
        String c= hotes_combo.getValue();
        if (! c.isEmpty())
        {
        List<MaisonHotes> maisons = ma.findByAdresse(c);
        System.out.println(maisons);
     
        for (MaisonHotes maison : maisons)
        {
            rmaison.add(maison);
        }
        }
        else
        {      
    
        try {
            rmaison=ma.displayAll();
        } catch (SQLException ex) {
            Logger.getLogger(ListeDesHotelsController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        }
        tableHotes.setItems(rmaison);
    

        
    }
    

    @FXML
    private void reserverHotesAction(ActionEvent event) {
    
//     HebergementService H =new HebergementService();
//    int id =tableHotes.getSelectionModel().getSelectedItem().getId();
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            
//        alert.setTitle("reservation d'un hotel");
//        alert.setContentText("Vouslez-vous vraiment reserver cet hebergement ?");
//        Optional<ButtonType> result = alert.showAndWait();
  FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("FXMLGestionReservation.fxml"));
        
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
    private void retourHotesAction(ActionEvent event) throws IOException {
                     Node source = (Node) event.getSource();
   Stage stage = (Stage) source.getScene().getWindow();
   stage.close();
        
        Parent root = FXMLLoader.load(getClass().getResource("Client.fxml"));
       
        Scene s = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setScene(s);
        primaryStage.show();
   
       }
    }
    

