/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.services;

import tn.esprit.GoVoyage.entites.Reclamation;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author Kouka
 */
public interface IReclamationmethodes {
     public boolean ajouterReclamation(Reclamation r) throws SQLException;
    public  boolean modifierReclamation(Reclamation r) throws SQLException;
        public  boolean supprimerReclamation(Reclamation r) throws SQLException ;
            public  void AfficherReclamation() throws SQLException;
            public ObservableList<Reclamation> getAll();
    
}
