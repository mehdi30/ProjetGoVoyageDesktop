/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.services;

import java.sql.SQLException;
import javafx.collections.ObservableList;
import tn.esprit.GoVoyage.entites.MaisonHotes;

/**
 *
 * @author asus
 */
public interface IMaisonHotesService {
    
 public void insererMaisonHote(MaisonHotes m) throws SQLException ;
 public void supprimerMaisonHotes(int id) throws SQLException ;
 public void AfficherMaisonHotes() throws SQLException ;
 public void ModifierMaisonHotes(MaisonHotes m);
 public ObservableList<MaisonHotes> displayAll() throws SQLException;
 public ObservableList<MaisonHotes>  findByAdresse(String adresse) ;
}
