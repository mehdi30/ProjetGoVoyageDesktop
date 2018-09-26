/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.services;

import java.sql.SQLException;
import javafx.collections.ObservableList;
import tn.esprit.GoVoyage.entites.Hebergement;

/**
 *
 * @author asus
 */
    public interface IHebergementService {
    public void insererHebergement(Hebergement h) throws SQLException    ; 
    public void modifierHebergement(Hebergement h);
    public void supprimerHebergement(int id);
    public  void AfficherHebergement() throws SQLException;
   public ObservableList<Hebergement> displayAll() throws SQLException ;
   public ObservableList<Hebergement>  RechercheParAdresse(String adresse) ;

    public ObservableList<Hebergement> findByNom(String adresse) throws SQLException; 
}
