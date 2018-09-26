/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.GUI;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import tn.esprit.GoVoyage.entites.Vol;
import tn.esprit.GoVoyage.entites.VolAllerRetour;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tn.esprit.GoVoyage.services.VolService;

/**
 * FXML Controller class
 *
 * @author Mehdi Chaabene
 */
public class ChercherVolClientController implements Initializable {

    @FXML
    private TextField villeDepartR;
    @FXML
    private TextField villeArriveR;
    @FXML
    private TextField dateDepartR;
    @FXML
    private TextField dateArriveR;
    @FXML
    private TableView<VolAllerRetour> tableViewRecherche;

    @FXML
    private TableColumn<VolAllerRetour, String> dateDep;
    @FXML
    private TableColumn<VolAllerRetour, String> heureD;
    @FXML
    private TableColumn<VolAllerRetour, String> NVoll;
    @FXML
    private TableColumn<VolAllerRetour, String> typeeAvion;
    @FXML
    private TableColumn<VolAllerRetour, String> ciee;
    @FXML
    private TableColumn<VolAllerRetour, String> dureee;
    @FXML
    private TableColumn<VolAllerRetour, Float> tariif;
    @FXML
    private TableColumn<VolAllerRetour, String> datedepartR;
    @FXML
    private TableColumn<VolAllerRetour, String> horaireR;

    //private ObservableList<VolAllerRetour> data;
    //private ObservableList<Vol> dataa;
    @FXML
    private TableColumn<VolAllerRetour, String> villeDepar;
    @FXML
    private TableColumn<VolAllerRetour, String> villeArriv;
    @FXML
    private TextField VilleDeparAll;
    @FXML
    private TextField villeArrAll;
    @FXML
    private TextField dateAll;
    @FXML
    private Button Sélectionner;
    @FXML
    private TableView<Vol> allerTabview;
    @FXML
    private TableColumn<Vol, String> allerVileD;
    @FXML
    private TableColumn<Vol, String> allerVilleA;
    @FXML
    private TableColumn<Vol, String> allerDateD;
    @FXML
    private TableColumn<Vol, String> allerHorr;
    @FXML
    private TableColumn<Vol, String> allerNVol;
    @FXML
    private TableColumn<Vol, String> allerTavion;
    @FXML
    private TableColumn<Vol, String> allerCie;
    @FXML
    private TableColumn<Vol, String> allerDuree;
    @FXML
    private TableColumn<Vol, String> allerTarif;
    @FXML
    private Tab tab11;
    @FXML
    private Tab tab22;
    @FXML
    private TabPane tabb;
    @FXML
    private ComboBox comTrierId;
    
        ObservableList<String> comTriList = FXCollections.observableArrayList("Tarif inférieur < 500 Dt", "Vols avec des compagnies Low Cost","Vols avec des compagnies en Tunisie","Vols avec Promotion");
    @FXML
    private JFXButton acceuill;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO     idEtatUp.setVisible(false);
        tableViewRecherche.setVisible(false);
        Sélectionner.setVisible(false);
        allerTabview.setVisible(false);
        tabb.setVisible(false);
                comTrierId.setItems(comTriList);


    }

    @FXML
    private void RechercherVoll(ActionEvent event) {

        tableViewRecherche.setVisible(false);
        Sélectionner.setVisible(false);

        VolService R = new VolService();

        String D = villeDepartR.getText();
        String A = villeArriveR.getText();
        String DD = dateDepartR.getText();
        String AA = dateArriveR.getText();
        float nb = 0;
        float nbaffaire = 0;

        // nb= Float.parseFloat(nbEcoR.getText());    
        // nbaffaire= Float.parseFloat(nbAffaireR.getText());
        ObservableList<VolAllerRetour> data = FXCollections.observableArrayList(R.RechercherVolaller(D, A, DD, AA));
        // VolAllerRetour.setTarif(nb);
       
        villeDepar.setCellValueFactory(new PropertyValueFactory<>("villeDepart"));
        villeArriv.setCellValueFactory(new PropertyValueFactory<>("villeArrivee"));
        dateDep.setCellValueFactory(new PropertyValueFactory<>("dateDepartAller"));
        typeeAvion.setCellValueFactory(new PropertyValueFactory<>("typeAvion"));
        ciee.setCellValueFactory(new PropertyValueFactory<>("cie_aerienne"));
        dureee.setCellValueFactory(new PropertyValueFactory<>("duree"));
        //tariif.setCellValueFactory(new PropertyValueFactory<>("tarif"));
        tariif.setCellValueFactory(new PropertyValueFactory<>("tarif"));

        datedepartR.setCellValueFactory(new PropertyValueFactory<>("dateDepartRetour"));
        horaireR.setCellValueFactory(new PropertyValueFactory<>("heureDepartR"));
        NVoll.setCellValueFactory(new PropertyValueFactory<>("numVol"));
        heureD.setCellValueFactory(new PropertyValueFactory<>("heureDepart"));

        if (!"".equals(D) && !"".equals(A)) {
            tableViewRecherche.setVisible(true);
            Sélectionner.setVisible(true);
            tabb.setVisible(true);

            tableViewRecherche.setItems(data);
        } else if ((("".equals(D) || "".equals(A)) || "".equals(AA)) || "".equals(DD)) {
            tableViewRecherche.setVisible(false);
            Sélectionner.setVisible(false);
            JOptionPane.showMessageDialog(null, "Veuillez Remplir tous les champs !");

        } else {
            tableViewRecherche.setVisible(false);
            Sélectionner.setVisible(false);

        }

    }

    ///////////////////////////////////////////////
    @FXML
    private void RechercherVolSimple(ActionEvent event) {

        allerTabview.setVisible(false);
        Sélectionner.setVisible(false);

        VolService R = new VolService();

        String D = VilleDeparAll.getText();
        String A = villeArrAll.getText();
        String DD = dateAll.getText();

        float nb = 0;
        // nb= Float.parseFloat(nbEcoR.getText());

        ObservableList<Vol> dataa = FXCollections.observableArrayList(R.RechercherVolSimple(D, A, DD));
        // VolAllerRetour.setTarif(nb);

        allerVileD.setCellValueFactory(new PropertyValueFactory<>("villeDepart"));
        allerVilleA.setCellValueFactory(new PropertyValueFactory<>("villeArrivee"));
        allerDateD.setCellValueFactory(new PropertyValueFactory<>("dateDepartAller"));
        allerTavion.setCellValueFactory(new PropertyValueFactory<>("typeAvion"));
        allerCie.setCellValueFactory(new PropertyValueFactory<>("cie_aerienne"));
        allerDuree.setCellValueFactory(new PropertyValueFactory<>("duree"));
        //tariif.setCellValueFactory(new PropertyValueFactory<>("tarif"));
        allerTarif.setCellValueFactory(new PropertyValueFactory<>("tarif"));

        //datedepartR.setCellValueFactory(new PropertyValueFactory<>("dateDepartRetour"));
        //horaireR.setCellValueFactory(new PropertyValueFactory<>("heureDepartR"));
        allerNVol.setCellValueFactory(new PropertyValueFactory<>("numVol"));
        allerHorr.setCellValueFactory(new PropertyValueFactory<>("heureDepart"));

        if (!"".equals(D) && !"".equals(A)) {
            allerTabview.setVisible(true);
            Sélectionner.setVisible(true);
            tabb.setVisible(true);

            allerTabview.setItems(dataa);

        } else if ((("".equals(D) || "".equals(A))) || "".equals(DD)) {
            allerTabview.setVisible(false);
            Sélectionner.setVisible(false);
            JOptionPane.showMessageDialog(null, "Veuillez Remplir tous les champs !");

        } else {
            allerTabview.setVisible(false);
            Sélectionner.setVisible(false);

        }

    }

    private void TrierPrix() {

        tableViewRecherche.setVisible(false);
        Sélectionner.setVisible(false);

        VolService R = new VolService();

        ObservableList<VolAllerRetour> data = FXCollections.observableArrayList(R.RechercherBox());
        
                   

        villeDepar.setCellValueFactory(new PropertyValueFactory<>("villeDepart"));
        villeArriv.setCellValueFactory(new PropertyValueFactory<>("villeArrivee"));
        dateDep.setCellValueFactory(new PropertyValueFactory<>("dateDepartAller"));
        typeeAvion.setCellValueFactory(new PropertyValueFactory<>("typeAvion"));
        ciee.setCellValueFactory(new PropertyValueFactory<>("cie_aerienne"));
        dureee.setCellValueFactory(new PropertyValueFactory<>("duree"));
        //tariif.setCellValueFactory(new PropertyValueFactory<>("tarif"));
        tariif.setCellValueFactory(new PropertyValueFactory<>("tarif"));

        datedepartR.setCellValueFactory(new PropertyValueFactory<>("dateDepartRetour"));
        horaireR.setCellValueFactory(new PropertyValueFactory<>("heureDepartR"));
        NVoll.setCellValueFactory(new PropertyValueFactory<>("numVol"));
        heureD.setCellValueFactory(new PropertyValueFactory<>("heureDepart"));

        tableViewRecherche.setVisible(true);
        Sélectionner.setVisible(true);
        tabb.setVisible(true);

        tableViewRecherche.setItems(data);

    }
    private void TrierCompagnie() {

        tableViewRecherche.setVisible(false);
        Sélectionner.setVisible(false);

        VolService R = new VolService();

        ObservableList<VolAllerRetour> data = FXCollections.observableArrayList(R.RechercherTun());
        
                   

        villeDepar.setCellValueFactory(new PropertyValueFactory<>("villeDepart"));
        villeArriv.setCellValueFactory(new PropertyValueFactory<>("villeArrivee"));
        dateDep.setCellValueFactory(new PropertyValueFactory<>("dateDepartAller"));
        typeeAvion.setCellValueFactory(new PropertyValueFactory<>("typeAvion"));
        ciee.setCellValueFactory(new PropertyValueFactory<>("cie_aerienne"));
        dureee.setCellValueFactory(new PropertyValueFactory<>("duree"));
        //tariif.setCellValueFactory(new PropertyValueFactory<>("tarif"));
        tariif.setCellValueFactory(new PropertyValueFactory<>("tarif"));

        datedepartR.setCellValueFactory(new PropertyValueFactory<>("dateDepartRetour"));
        horaireR.setCellValueFactory(new PropertyValueFactory<>("heureDepartR"));
        NVoll.setCellValueFactory(new PropertyValueFactory<>("numVol"));
        heureD.setCellValueFactory(new PropertyValueFactory<>("heureDepart"));

        tableViewRecherche.setVisible(true);
        Sélectionner.setVisible(true);
        tabb.setVisible(true);

        tableViewRecherche.setItems(data);

    }
    private void TrierLowCost() {

        tableViewRecherche.setVisible(false);
        Sélectionner.setVisible(false);

        VolService R = new VolService();

        ObservableList<VolAllerRetour> data = FXCollections.observableArrayList(R.RechercherLowCost());
        
                   

        villeDepar.setCellValueFactory(new PropertyValueFactory<>("villeDepart"));
        villeArriv.setCellValueFactory(new PropertyValueFactory<>("villeArrivee"));
        dateDep.setCellValueFactory(new PropertyValueFactory<>("dateDepartAller"));
        typeeAvion.setCellValueFactory(new PropertyValueFactory<>("typeAvion"));
        ciee.setCellValueFactory(new PropertyValueFactory<>("cie_aerienne"));
        dureee.setCellValueFactory(new PropertyValueFactory<>("duree"));
        //tariif.setCellValueFactory(new PropertyValueFactory<>("tarif"));
        tariif.setCellValueFactory(new PropertyValueFactory<>("tarif"));

        datedepartR.setCellValueFactory(new PropertyValueFactory<>("dateDepartRetour"));
        horaireR.setCellValueFactory(new PropertyValueFactory<>("heureDepartR"));
        NVoll.setCellValueFactory(new PropertyValueFactory<>("numVol"));
        heureD.setCellValueFactory(new PropertyValueFactory<>("heureDepart"));

        tableViewRecherche.setVisible(true);
        Sélectionner.setVisible(true);
        tabb.setVisible(true);

        tableViewRecherche.setItems(data);

    }
    
private void TrierPromotion() {

        tableViewRecherche.setVisible(false);
        Sélectionner.setVisible(false);

        VolService R = new VolService();

        ObservableList<VolAllerRetour> data = FXCollections.observableArrayList(R.RechercherPromotion());
        
                   

        villeDepar.setCellValueFactory(new PropertyValueFactory<>("villeDepart"));
        villeArriv.setCellValueFactory(new PropertyValueFactory<>("villeArrivee"));
        dateDep.setCellValueFactory(new PropertyValueFactory<>("dateDepartAller"));
        typeeAvion.setCellValueFactory(new PropertyValueFactory<>("typeAvion"));
        ciee.setCellValueFactory(new PropertyValueFactory<>("cie_aerienne"));
        dureee.setCellValueFactory(new PropertyValueFactory<>("duree"));
        //tariif.setCellValueFactory(new PropertyValueFactory<>("tarif"));
        tariif.setCellValueFactory(new PropertyValueFactory<>("tarif"));

        datedepartR.setCellValueFactory(new PropertyValueFactory<>("dateDepartRetour"));
        horaireR.setCellValueFactory(new PropertyValueFactory<>("heureDepartR"));
        NVoll.setCellValueFactory(new PropertyValueFactory<>("numVol"));
        heureD.setCellValueFactory(new PropertyValueFactory<>("heureDepart"));

        tableViewRecherche.setVisible(true);
        Sélectionner.setVisible(true);
        tabb.setVisible(true);

        tableViewRecherche.setItems(data);

    }
    @FXML
    private void SélectionnerVol(ActionEvent event) {
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
    private void comboboxTrier(ActionEvent event) {
                if (comTrierId.getValue() == "Tarif inférieur < 500 Dt") {
                 TrierPrix();
    }
                else if (comTrierId.getValue() == "Vols avec des compagnies Low Cost") {
                 TrierLowCost();
    }
                 else if (comTrierId.getValue() == "Vols avec des compagnies en Tunisie") {
                 TrierCompagnie();
    }
                 else if (comTrierId.getValue() == "Vols avec Promotion")
                 {
                     TrierPromotion();
                 }
    }

    @FXML
    private void acceuil(ActionEvent event) {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("ClientsSpace.fxml"));
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
