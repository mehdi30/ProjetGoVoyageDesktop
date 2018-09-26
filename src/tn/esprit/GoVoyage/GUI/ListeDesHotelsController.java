/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.GUI;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import tn.esprit.GoVoyage.entites.Hotel;
import tn.esprit.GoVoyage.services.HebergementService;
import tn.esprit.GoVoyage.services.HotelService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ListeDesHotelsController implements Initializable {

    @FXML
    private TableView<Hotel> TableDesHotels;
    @FXML
    private TableColumn<Hotel, String> tableNom;
    @FXML
    private TableColumn<Hotel, Integer> tableEtoile;
    @FXML
    private TableColumn<Hotel, Float> tablePs;
    @FXML
    private TableColumn<Hotel, Float> tablePd;
    @FXML
    private TableColumn<Hotel, Float> tablePE;
    @FXML
    private TableColumn<Hotel, Integer> tableNumTel;
    @FXML
    private ComboBox<String> comboHotels;
ObservableList<String> ListHotels =FXCollections.observableArrayList("Tunis","Paris","Amesterdam","Italie");
    @FXML
    private Button reserver_btn;
    @FXML
    private Button retour_btn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
    HotelService h = new HotelService();  
   tableNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
   tableEtoile.setCellValueFactory(new PropertyValueFactory<>("nbEtoile"));
   tablePs.setCellValueFactory(new PropertyValueFactory<>("PrixSingle"));
   tablePd.setCellValueFactory(new PropertyValueFactory<>("PrixDouble"));
   tablePE.setCellValueFactory(new PropertyValueFactory<>("PrixEnfant"));
   tableNumTel.setCellValueFactory(new PropertyValueFactory<>("numerotel"));
     
   //ObservableList<Hotel> rHotels = FXCollections.observableArrayList();
       comboHotels.setItems(ListHotels);
 
    }    

    @FXML
    private void comboHotelAction(ActionEvent event) {
        ObservableList<Hotel> rHotels = FXCollections.observableArrayList();
        Hotel ho =new Hotel();
        HotelService h = new HotelService();  
        String c= comboHotels.getValue();
        if (! c.isEmpty())
        {
        List<Hotel> hotels = h.findByAdresse(c);
        System.out.println(hotels);
     
        for (Hotel hotel : hotels)
        {
            rHotels.add(hotel);
        }
        }
        else
        {      
    
        try {
            rHotels=h.displayAll();
        } catch (SQLException ex) {
            Logger.getLogger(ListeDesHotelsController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        }
        TableDesHotels.setItems(rHotels);
    
      //  TableDesHotels.setVisible(false);
    
   
    }

    @FXML
    private void reserverAction(ActionEvent event) {
//         HebergementService H =new HebergementService();
//    int id =TableDesHotels.getSelectionModel().getSelectedItem().getId();
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            
//        alert.setTitle("reservation d'un hotel");
//        alert.setContentText("Vouslez-vous vraiment reserver cet hebergement ?");
//        Optional<ButtonType> result = alert.showAndWait();
//        
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
    private void retour_btnAction(ActionEvent event) throws IOException {
        
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
    

