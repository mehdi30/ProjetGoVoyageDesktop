/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.services;

import java.sql.SQLException;
import javafx.collections.ObservableList;
import tn.esprit.GoVoyage.entites.Hotel;

/**
 *
 * @author asus
 */
public interface IHotelService {
    public void insererHotel(Hotel h) throws SQLException ;
    public void supprimerHotel(int id);
    public ObservableList<Hotel> displayAll() throws SQLException ;
    public void ModifierHotel(Hotel h)throws SQLException;
    public ObservableList<Hotel>  findByAdresse(String adresse) ;
   // public Hotel findByAdresse(String adresse) ;
    
    public void m();
    
}
