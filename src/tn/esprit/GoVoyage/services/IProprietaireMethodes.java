/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.services;

import tn.esprit.GoVoyage.entites.Proprietaire;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author Kouka
 */
public interface IProprietaireMethodes {
     public boolean ajouterProprietaire(Proprietaire p) throws SQLException;
    public  boolean modifierProprietaire(Proprietaire p) throws SQLException;
        public  boolean supprimerProprietaire(Proprietaire p) throws SQLException ;
            public  void AfficherProprietaire() throws SQLException;
               // public List<Clients> findALL() ;
    public boolean found(Proprietaire p) throws SQLException  ;
    public ObservableList<Proprietaire> getAll();
           // public boolean trouverproprietaire (Clients c) throws SQLException  ;
 public boolean removeByrefProp(int ref) throws SQLException ;
//      public boolean updatePhoto(Clients c, byte[] person_image) throws SQLException ;
//           public byte[] getUtilImageFromId(int ref) throws SQLException ;

    
}
