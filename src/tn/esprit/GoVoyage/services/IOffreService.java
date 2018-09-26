/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.GoVoyage.services;

import tn.esprit.GoVoyage.entites.Offre;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/*
 * @author nizar
 */
public interface IOffreService 
{
    public  boolean insererOffreH(Offre o) throws SQLException;
    public  boolean modifierOffreH(Offre o) throws SQLException;
    public  boolean supprimerOffreH(Offre o) throws SQLException ;
    public  ObservableList<Offre> AfficherOffreH() throws SQLException;
public  boolean insererOffreV(Offre o) throws SQLException;
    public  boolean modifierOffreV(Offre o) throws SQLException;
    public  boolean supprimerOffreV(Offre o) throws SQLException ;
    public  ObservableList<Offre> AfficherOffreV() throws SQLException;
    public  void  Promotion(Offre o) throws SQLException;
    public  void  PrixInitial(Offre o) throws SQLException;
}
