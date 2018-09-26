/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.GoVoyage.services;

import tn.esprit.GoVoyage.entites.Vol;
import tn.esprit.GoVoyage.entites.VolAllerRetour;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Mehdi Chaabene
 */
public interface IVolService {
    
         public boolean insererVol(Vol v) throws SQLException;
         public boolean insererVolAllerRetour(VolAllerRetour v) throws SQLException;

    public  boolean modifierVol(Vol v) throws SQLException;
        public  boolean supprimerVol(Vol v) throws SQLException ;
            public  void afficherVol() throws SQLException;
                   public List<Vol> afficher() throws SQLException ;
                   public void updateVolSimple(String numVol,String villeDepart, String villeArrivee, String dateDepartAller, String dateArriveeAller, String heureDepart, String typeAvion, String cie_aerienne, String duree, int nbrPlaceEco, int nbrPlaceAffaire, float tarif) throws SQLException;
     public List<VolAllerRetour> RechercherPromotion()throws SQLException ;


 //public java.sql.Date convert(String date) throws ParseException;
 //public static String convert(java.sql.Date d);
 
}
