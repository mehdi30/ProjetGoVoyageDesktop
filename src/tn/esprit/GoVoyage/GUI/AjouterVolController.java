/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.GUI;

import tn.esprit.GoVoyage.ConnectionBD.MyBdConnection;
import tn.esprit.GoVoyage.entites.Vol;
import tn.esprit.GoVoyage.entites.VolAllerRetour;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import tn.esprit.GoVoyage.services.VolService;

/**
 * FXML Controller class
 *
 * @author Mehdi Chaabene
 */
public class AjouterVolController implements Initializable {

    @FXML
    private TextField VilleDText;
    @FXML
    private TextField VilleAText;
    @FXML
    private TextField DateDText;
    @FXML
    private TextField DateAText;
    @FXML
    private TextField HDText;
    @FXML
    private TextField NumvolText;
    @FXML
    private TextField TAvionText;
    @FXML
    private TextField CieAText;

    @FXML
    private TextField DureeText;
    @FXML
    private TextField PEcoText;
    @FXML
    private TextField PaffaireText;
    @FXML
    private TextField TarifText;
    @FXML
    private ComboBox TVolText;

    @FXML
    private TextField DARetourText;
    @FXML
    private TextField DDRetourText;
    @FXML
    private TextField HDRetourText;

    ObservableList<String> TVollist = FXCollections.observableArrayList("allerSimple", "AllerRetour");
    @FXML
    private TableView<Vol> tableViewVol;
    @FXML
    private Button modifierVol;
    @FXML
    private Button supprimerVol;
    @FXML
    private TableColumn<Vol, String> villeDepart;
    @FXML
    private TableColumn<Vol, String> villeArrivee;
    @FXML
    private TableColumn<Vol, String> dateDepart;
    @FXML
    private TableColumn<Vol, String> dateArrivee;
    @FXML
    private TableColumn<Vol, String> numeroVol;
    @FXML
    private TableColumn<Vol, String> heureD;
    @FXML
    private TableColumn<Vol, Integer> placesEco;
    @FXML
    private TableColumn<Vol, String> Cie;
    @FXML
    private TableColumn<Vol, String> dateDR;
    @FXML
    private TableColumn<Vol, String> HeureR;

    private ObservableList<Vol> data;
    @FXML
    private TableColumn<Vol, String> DateArriveeR;
    @FXML
    private TableColumn<Vol, String> DureeVol;
    @FXML
    private TableColumn<Vol, String> Tariif;
    @FXML
    private TableColumn<Vol, String> placesAffaire;
    @FXML
    private TableColumn<Vol, String> TAvion;
    @FXML
    private TextField RechercheText;
    @FXML
    private Label labelo;
    @FXML
    private Label ad;
    @FXML
    private Label bc;
    @FXML
    private Label ab;
    @FXML
    private Button returnmenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoadDataFromDatabase();
        refrechir();

        TVolText.setValue("allerSimple");
        TVolText.setItems(TVollist);
    }

    @FXML
    private void BtnAjouterVol(ActionEvent event) throws SQLException {

        VolService volservice = new VolService();

        Vol v = new Vol();

        v.setVilleDepart(VilleDText.getText());
        v.setVilleArrivee(VilleAText.getText());
        v.setDateDepartAller(DateDText.getText());
        v.setDateArriveeAller(DateAText.getText());
        v.setHeureDepart(HDText.getText());
        v.setNumVol(NumvolText.getText());
        v.setTypeAvion(TAvionText.getText());
        v.setCie_aerienne(CieAText.getText());
        v.setDuree(DureeText.getText());
        v.setNbrPlaceEco(Integer.parseInt(PEcoText.getText()));
        v.setNbrPlaceAffaire(Integer.parseInt(PaffaireText.getText()));

        v.setTarif(Float.parseFloat(TarifText.getText()));

        VolAllerRetour v2 = new VolAllerRetour();

        v2.setVilleDepart(VilleDText.getText());

        v2.setVilleDepart(VilleDText.getText());
        v2.setVilleArrivee(VilleAText.getText());
        v2.setDateDepartAller(DateDText.getText());
        v2.setDateArriveeAller(DateAText.getText());
        v2.setHeureDepart(HDText.getText());
        v2.setNumVol(NumvolText.getText());
        v2.setTypeAvion(TAvionText.getText());
        v2.setCie_aerienne(CieAText.getText());
        v2.setDuree(DureeText.getText());
        v2.setNbrPlaceEco(Integer.parseInt(PEcoText.getText()));
        v2.setNbrPlaceAffaire(Integer.parseInt(PaffaireText.getText()));
        v2.setTarif(Float.parseFloat(TarifText.getText()));

        v2.setDateDepartRetour(DDRetourText.getText());
        v2.setDateArriveeRetour(DARetourText.getText());
        v2.setHeureDepartR(HDRetourText.getText());

        if (TVolText.getValue() == "allerSimple") {
            volservice.insererVol(v);
            LoadDataFromDatabase();
            labelo.setText("Vol Aller Simple a été Ajouté");
            refrechir();

        } else if (TVolText.getValue() == "AllerRetour") {
            volservice.insererVolAllerRetour(v2);
            labelo.setText("Vol Aller et Retour a été Ajouté");

            LoadDataFromDatabase();
            refrechir();

        } else {
            labelo.setText(" Veuillez cliquer sur  un choix parmi la liste ");

        }

    }

    /*@FXML
    private void btnaffichageVol(ActionEvent event) {
        VolService s1 = new VolService();
        Vol p = tableViewVol.getSelectionModel().getSelectedItem();
        if (p != null) {

            int idtemp = p.getRef();
            VilleDText.setText(p.getVilleDepart());
            VilleAText.setText(p.getVilleArrivee());
            DateDText.setText(p.getDateDepartAller());
            DateAText.setText(p.getDateArriveeAller());
            NumvolText.setText(p.getNumVol());
            HDText.setText(p.getHeureDepart());
            CieAText.setText(p.getCie_aerienne());
            TAvionText.setText(p.getTypeAvion());
            DureeText.setText(p.getDuree());
            PaffaireText.setText(String.valueOf(p.getNbrPlaceAffaire()));
            TarifText.setText(String.valueOf(p.getTarif()));
            PEcoText.setText(String.valueOf(p.getNbrPlaceEco()));
            TVolText.setValue("allerSimple");

            HDRetourText.setText("");
            DARetourText.setText("");
            DDRetourText.setText("");
        } else {
            labelo.setText(" Veuillez cliquer sur un Vol aller Simple choix parmi la liste ");

        }

    }*/
    @FXML
    private void BtnModifierVol(ActionEvent event){

                    if (JOptionPane.showConfirmDialog(null, "Confirmer la modification", "Modification",
                JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

                if (TVolText.getValue() == "allerSimple") {
                VolService s1 = new VolService();
                
                Vol p = tableViewVol.getSelectionModel().getSelectedItem();
                        

                
                    try {
                        s1.updateVolSimple(p.getNumVol(), VilleDText.getText(), VilleAText.getText(), DateDText.getText(), DateAText.getText(), HDText.getText(), TAvionText.getText(), CieAText.getText(), DureeText.getText(), Integer.parseInt(PEcoText.getText()), Integer.parseInt(PaffaireText.getText()), Float.parseFloat(TarifText.getText()));
                    } catch (SQLException ex) {
                        Logger.getLogger(AjouterVolController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                labelo.setText("Vol Aller Simple a été Modifié"); }
                
            else if (TVolText.getValue() == "AllerRetour") {
                VolService s2 = new VolService();
                
                VolAllerRetour p = (VolAllerRetour) tableViewVol.getSelectionModel().getSelectedItem();
                        

                
                    try {
                        s2.updateVolAllerRetour(p.getNumVol(), VilleDText.getText(), VilleAText.getText(), DateDText.getText(), DateAText.getText(), HDText.getText(), TAvionText.getText(), CieAText.getText(), DureeText.getText(), Integer.parseInt(PEcoText.getText()), Integer.parseInt(PaffaireText.getText()), Float.parseFloat(TarifText.getText()),DDRetourText.getText(),DARetourText.getText(),HDRetourText.getText());
                    } catch (SQLException ex) {
                        Logger.getLogger(AjouterVolController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                labelo.setText("Vol Aller Retour a été Modifié"); }
     

       

        refrechir();
        LoadDataFromDatabase();
                    }
    }

    /*
    @FXML
    private void BtnSupprimer(ActionEvent event) {
        
  if (JOptionPane.showConfirmDialog (null,"Confirmer la Suppression","Suppression",
          JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){

        
        
        VolService s = new VolService();
        Vol p = tableViewVol.getSelectionModel().getSelectedItem();
        VolAllerRetour p1 = (VolAllerRetour) tableViewVol.getSelectionModel().getSelectedItem();
                  if(p!=null && p1!=null)
                  { 
                      

        data.remove(p);
        data.remove(p1);
        try {
            s.supprimerVolByNumVol(p.getNumVol());

            s.supprimerVolByNumVol(p1.getNumVol());
                        labelo.setText(" Le Vol a été Supprimé");

        } catch (SQLException ex) {
            Logger.getLogger(AjouterVolController.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoadDataFromDatabase();
                  }
                  else {
                   labelo.setText(" Veuillez cliquer sur  un choix parmi la liste ");

                  }
  }

    }*/
    @FXML
    private void BtnSupprimer(ActionEvent event) {

        if (JOptionPane.showConfirmDialog(null, "Confirmer la Suppression", "Suppression",
                JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

            VolService s = new VolService();
            // VolAllerRetour p1 = (VolAllerRetour) tableViewVol.getSelectionModel().getSelectedItem();
            Vol p = tableViewVol.getSelectionModel().getSelectedItem();

            if (p != null) {

                data.remove(p);

                try {
                    s.supprimerVolByNumVol(p.getNumVol());
                } catch (SQLException ex) {
                    Logger.getLogger(AjouterVolController.class.getName()).log(Level.SEVERE, null, ex);
                }

                //labelo.setText(" Le Vol a été Supprimé");

                //labelo.setText(" Le Vol a été Supprimé");
            } else if (p == null) {
                //Vol p = tableViewVol.getSelectionModel().getSelectedItem();
                VolAllerRetour p1 = (VolAllerRetour) tableViewVol.getSelectionModel().getSelectedItem();

                data.remove(p1);
                labelo.setText(" Le Vol Aller-retour a été Supprimé ");
                //JOptionPane.showMessageDialog(null,"Le Vol Aller Retour a été Supprimé");

                try {
                    s.supprimerVolByNumVol(p1.getNumVol());
                } catch (SQLException ex) {
                    Logger.getLogger(AjouterVolController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                labelo.setText(" Veuillez cliquer sur  un choix parmi la liste ");

            }
            LoadDataFromDatabase();

        }

    }

    public void refrechir() {
        VilleDText.setText("");
        VilleAText.setText("");
        DateDText.setText("");
        DateAText.setText("");
        NumvolText.setText("");
        HDText.setText("");
        CieAText.setText("");
        TAvionText.setText("");
        DureeText.setText("");
        PaffaireText.setText("");
        TarifText.setText("");
        PEcoText.setText("");
        //TVolText.setValue("allerSimple");

        HDRetourText.setText("");
        DARetourText.setText("");
        DDRetourText.setText("");

    }

    public void LoadDataFromDatabase() {
        try {
            tableViewVol.setVisible(true);
            Connection con = MyBdConnection.getInstanceBD().getConnection();
            data = FXCollections.observableArrayList();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM vol WHERE typeVol='allerSimple'"); //
            ResultSet as = con.createStatement().executeQuery("SELECT * FROM vol WHERE typeVol='AllerRetour'");

            while (rs.next()) {
                data.add(new Vol(
                        rs.getString("villeDepart"),
                        rs.getString("villeArrivee"),
                        rs.getString("dateDepartAller"),
                        rs.getString("dateArriveeAller"),
                        rs.getString("heureDepart"),
                        rs.getString("numVol"),
                        rs.getString("typeAvion"),
                        rs.getString("cie_aerienne"),
                        rs.getString("duree"),
                        rs.getInt("nbrPlaceEco"),
                        rs.getInt("nbrPlaceAffaire"),
                        rs.getFloat("tarif")
                // rs.getString("dateDepartRetour"),
                // rs.getString("heureDepartR")
                ));
                tableViewVol.setItems(data);
            }
            while (as.next()) {

                data.add(new VolAllerRetour(
                        as.getString("villeDepart"),
                        as.getString("villeArrivee"),
                        as.getString("dateDepartAller"),
                        as.getString("dateArriveeAller"),
                        as.getString("heureDepart"),
                        as.getString("numVol"),
                        as.getString("typeAvion"),
                        as.getString("cie_aerienne"),
                        as.getString("duree"),
                        as.getInt("nbrPlaceEco"),
                        as.getInt("nbrPlaceAffaire"),
                        as.getFloat("tarif"),
                        as.getString("dateDepartRetour"),
                        as.getString("dateArriveeRetour"),
                        as.getString("heureDepartR")
                ));
                tableViewVol.setItems(data);

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        villeDepart.setCellValueFactory(new PropertyValueFactory<>("villeDepart"));
        villeArrivee.setCellValueFactory(new PropertyValueFactory<>("villeArrivee"));
        dateDepart.setCellValueFactory(new PropertyValueFactory<>("dateDepartAller"));
        dateArrivee.setCellValueFactory(new PropertyValueFactory<>("dateArriveeAller"));
        heureD.setCellValueFactory(new PropertyValueFactory<>("heureDepart"));
        TAvion.setCellValueFactory(new PropertyValueFactory<>("typeAvion"));
        DureeVol.setCellValueFactory(new PropertyValueFactory<>("duree"));

        numeroVol.setCellValueFactory(new PropertyValueFactory<>("numVol"));
        placesEco.setCellValueFactory(new PropertyValueFactory<>("nbrPlaceEco"));
        placesAffaire.setCellValueFactory(new PropertyValueFactory<>("nbrPlaceAffaire"));

        Cie.setCellValueFactory(new PropertyValueFactory<>("cie_aerienne"));
        Tariif.setCellValueFactory(new PropertyValueFactory<>("tarif"));

        dateDR.setCellValueFactory(new PropertyValueFactory<>("dateDepartRetour"));

        DateArriveeR.setCellValueFactory(new PropertyValueFactory<>("dateArriveeRetour"));

        HeureR.setCellValueFactory(new PropertyValueFactory<>("heureDepartR"));

//       
    }

    /*@FXML
    private void afficherVolRetour(ActionEvent event) {
        VolAllerRetour v = (VolAllerRetour) tableViewVol.getSelectionModel().getSelectedItem();
//     ALLER RETOUR
        if (v != null) {
            VilleDText.setText(v.getVilleDepart());
            VilleAText.setText(v.getVilleArrivee());
            DateDText.setText(v.getDateDepartAller());
            DateAText.setText(v.getDateArriveeAller());
            NumvolText.setText(v.getNumVol());
            HDText.setText(v.getHeureDepart());
            CieAText.setText(v.getCie_aerienne());
            TAvionText.setText(v.getTypeAvion());
            DureeText.setText(v.getDuree());
            PaffaireText.setText(String.valueOf(v.getNbrPlaceAffaire()));

            TarifText.setText(String.valueOf(v.getTarif()));
            DARetourText.setText(v.getDateArriveeRetour());
            DDRetourText.setText(v.getDateDepartRetour());
            HDRetourText.setText(v.getHeureDepartR());

            PEcoText.setText(String.valueOf(v.getNbrPlaceEco()));
            TVolText.setValue("AllerRetour");
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez cliquer sur un Vol Aller et Retour choix parmi la liste");

        }

    }*/
    @FXML
    private void Rechercheintanta(KeyEvent event) {
        VolService R = new VolService();

        String D = RechercheText.getText();
        float nb = 0;
        // nb= Float.parseFloat(nbEcoR.getText());

        ObservableList<Vol> dat = FXCollections.observableArrayList(R.RechercherSeul(D, D));

        villeDepart.setCellValueFactory(new PropertyValueFactory<>("villeDepart"));
        villeArrivee.setCellValueFactory(new PropertyValueFactory<>("villeArrivee"));
        dateDepart.setCellValueFactory(new PropertyValueFactory<>("dateDepartAller"));
        dateArrivee.setCellValueFactory(new PropertyValueFactory<>("dateArriveeAller"));
        heureD.setCellValueFactory(new PropertyValueFactory<>("heureDepart"));
        TAvion.setCellValueFactory(new PropertyValueFactory<>("typeAvion"));
        DureeVol.setCellValueFactory(new PropertyValueFactory<>("duree"));

        numeroVol.setCellValueFactory(new PropertyValueFactory<>("numVol"));
        placesEco.setCellValueFactory(new PropertyValueFactory<>("nbrPlaceEco"));
        placesAffaire.setCellValueFactory(new PropertyValueFactory<>("nbrPlaceAffaire"));

        Cie.setCellValueFactory(new PropertyValueFactory<>("cie_aerienne"));
        Tariif.setCellValueFactory(new PropertyValueFactory<>("tarif"));

        dateDR.setCellValueFactory(new PropertyValueFactory<>("dateDepartRetour"));

        DateArriveeR.setCellValueFactory(new PropertyValueFactory<>("dateArriveeRetour"));

        HeureR.setCellValueFactory(new PropertyValueFactory<>("heureDepartR"));
        //tableViewVol.setVisible(true);
        if (!"".equals(D)) {
            tableViewVol.setItems(dat);
        } else {
            LoadDataFromDatabase();
        }

    }

    @FXML
    private void ComboBoxTypeVol(ActionEvent event) {

        if (TVolText.getValue() == "allerSimple") {

            DDRetourText.setVisible(false);
            DARetourText.setVisible(false);
            HDRetourText.setVisible(false);
            ab.setVisible(false);
            bc.setVisible(false);
            ad.setVisible(false);

        } else {
            DDRetourText.setVisible(true);
            DARetourText.setVisible(true);
            HDRetourText.setVisible(true);

            ab.setVisible(true);
            bc.setVisible(true);
            ad.setVisible(true);

        }

    }

    @FXML
    private void selectionAction(MouseEvent event) throws SQLException {
        Integer i = tableViewVol.getSelectionModel().getSelectedIndex();
        // if(i.equals(null)){
        VolService A = new VolService();
        Vol p = A.finbById((tableViewVol.getItems()).get(i).getNumVol());

        if (p != null) {
            //  VilleDText.setText(v.getVilleDepart());
            // refrechir();
            VilleDText.setText(p.getVilleDepart());
            VilleAText.setText(p.getVilleArrivee());
            DateDText.setText(p.getDateDepartAller());
            DateAText.setText(p.getDateArriveeAller());
            NumvolText.setText(p.getNumVol());
            HDText.setText(p.getHeureDepart());
            CieAText.setText(p.getCie_aerienne());
            TAvionText.setText(p.getTypeAvion());
            DureeText.setText(p.getDuree());
            PaffaireText.setText(String.valueOf(p.getNbrPlaceAffaire()));
            TarifText.setText(String.valueOf(p.getTarif()));
            PEcoText.setText(String.valueOf(p.getNbrPlaceEco()));
            TVolText.setValue("allerSimple");

        } else {

            VolAllerRetour v = (VolAllerRetour) A.finbByIdtwo((tableViewVol.getItems()).get(i).getNumVol());

            VilleDText.setText(v.getVilleDepart());
            VilleAText.setText(v.getVilleArrivee());
            DateDText.setText(v.getDateDepartAller());
            DateAText.setText(v.getDateArriveeAller());
            NumvolText.setText(v.getNumVol());
            HDText.setText(v.getHeureDepart());
            CieAText.setText(v.getCie_aerienne());
            TAvionText.setText(v.getTypeAvion());
            DureeText.setText(v.getDuree());
            PaffaireText.setText(String.valueOf(v.getNbrPlaceAffaire()));

            TarifText.setText(String.valueOf(v.getTarif()));
            DARetourText.setText(v.getDateArriveeRetour());
            DDRetourText.setText(v.getDateDepartRetour());
            HDRetourText.setText(v.getHeureDepartR());

            PEcoText.setText(String.valueOf(v.getNbrPlaceEco()));
            TVolText.setValue("AllerRetour");

        }

        // }
    }

    @FXML
    private void ReturnMenu(ActionEvent event) {
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
    private void ConsulterStats(ActionEvent event) throws IOException {
        
       /* FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("ModifierOffre.fxml"));
        Loader.load();
        ModifierOffreController chaine = Loader.getController();
        chaine.setList(duree,spec,type,heb,vol,ref);
        Parent p = Loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("GoVoyage");
        stage.setScene(new Scene(p));
        stage.show();*/
       
        Parent root = FXMLLoader.load(getClass().getResource("VolStat.fxml"));
        Stage primaryStage = new Stage();

        primaryStage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("GoVoyage");

        primaryStage.setScene(scene);
        
        primaryStage.show();



        
    }

}
