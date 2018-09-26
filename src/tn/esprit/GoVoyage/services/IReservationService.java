/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.GoVoyage.services;

import tn.esprit.GoVoyage.entites.Reservation;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public interface IReservationService {
    
    
     public boolean ajouterReservation(Reservation r ) throws SQLException; 
     public boolean ajouterReservationVol(Reservation r ) throws SQLException; 
     public boolean ajouterReservationHHotel(Reservation r ) throws SQLException; 
     public boolean ajouterReservationHHote(Reservation r ) throws SQLException; 
     public boolean modifierReservationVol(Reservation r ) throws SQLException; 
     public boolean modifierReservationHHotel(Reservation r ) throws SQLException; 
     public boolean modifierReservationHHote(Reservation r ) throws SQLException; 
     public boolean supprimerReservation(Reservation r ) throws SQLException; 
      public boolean recherReservation(Reservation r ) throws SQLException; 
       public boolean recherReservation(String ref  ) throws SQLException; 
      public ObservableList<Reservation> afficherReservations() throws SQLException ;
      public ObservableList<Reservation> afficherReservations1() throws SQLException ;
       public void trierReservationsParType() throws SQLException;
       public void trierReservationsParDate()throws SQLException ;
      public boolean expedierReservation(Reservation r ) throws SQLException; 
}
