/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.esprit.GoVoyage.ConnectionBD.MyBdConnection;
import tn.esprit.GoVoyage.entites.Hotel;

/**
 *
 * @author asus
 */




public class HotelService implements IHotelService{
        Connection connexion;
    
        public HotelService() {
    connexion = MyBdConnection.getInstanceBD().getConnection();

    }

        @Override
             public void insererHotel(Hotel h) throws SQLException{
    
        try {
 /* String req1 = "INSERT INTO `hebergement` "
               + "(`id`, `nom`, `adresse`, `adresseMail`, `numerotel`, `type`, `nbEtoile`, `PrixSingle`, `PrixDouble`, `PrixEnfant`,  `image`, `rating`)"
                + " VALUES ('"+h.getId()+"','"+h.getNom()+"', '"+h.getAdresse()+"','"
            +h.getAdresseMail()+"','"+h.getType()+"','"+h.getNbEtoile()+"','"+h.getPrixSingle()+
          "','"+h.getPrixDouble()+"','"+h.getPrixEnfant()+"','"+h.getImage()+
          "','"+h.getRating()+"'); ";
*/

    String req1 = "INSERT INTO `hebergement` "
               + "(`id`, `nom`, `adresse`, `adresseMail`, `numerotel`, `type`, `nbEtoile`, `PrixSingle`, `PrixDouble`, `PrixEnfant`,  `image`, `rating`)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?); ";
       
          
       PreparedStatement ste = connexion.prepareStatement(req1);
       ste.setInt(1,h.getId());
       ste.setString(2,h.getNom());
       ste.setString(3,h.getAdresse());
       ste.setString(4,h.getAdresseMail());
       ste.setInt(5,h.getNumerotel());
       ste.setString(6,h.getType());
       ste.setInt(7,h.getNbEtoile());
       ste.setFloat(8,h.getPrixSingle());
       ste.setFloat(9,h.getPrixDouble());
       ste.setFloat(10,h.getPrixEnfant());
       ste.setString(11,h.getImage());
       ste.setInt(12,h.getRating());
       
      
       System.out.println(req1);
       ste.executeUpdate();
        } 
        catch (SQLException ex) {
            Logger.getLogger(HebergementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        

            
        @Override
     public void supprimerHotel(int id)
    {
    try {
            String requete = "DELETE FROM `hebergement` WHERE id=?";
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setInt(1,id);
           
            pst.executeUpdate();
            System.out.println("hotel supprimée");
            } catch (SQLException ex) {
            Logger.getLogger(HebergementService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        } 

        @Override
   public void ModifierHotel(Hotel h) {

        try {

String requete ="UPDATE `hebergement` SET `id`=?,`nom`=?,`adresse`=?,`adresseMail`=?,`numerotel`=?,`type`=?,"
        + "`nbEtoile`=?,`PrixSingle`=?,`PrixDouble`=?,"
        + "`PrixEnfant`=?,`image`"
        + "=?,`rating`=? " 
      + "WHERE id= ?" ;


       PreparedStatement ste = connexion.prepareStatement(requete);
       ste.setInt(1,h.getId());
       ste.setString(2,h.getNom());
       ste.setString(3,h.getAdresse());
       ste.setString(4,h.getAdresseMail());
       ste.setInt(5,h.getNumerotel());
       ste.setString(6,h.getType());
       ste.setInt(7,h.getNbEtoile());
       ste.setFloat(8,h.getPrixSingle());
       ste.setFloat(9,h.getPrixDouble());
       ste.setFloat(10,h.getPrixEnfant());
       ste.setString(11,h.getImage());
       ste.setInt(12,h.getRating());
       ste.setInt(13, h.getId());
       System.out.println(requete);
       ste.executeUpdate();
        } 
        catch (SQLException ex) {
            Logger.getLogger(HebergementService.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    @Override
    public void m() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
        @Override
     public ObservableList<Hotel> displayAll() throws SQLException{
    
    
    ObservableList<Hotel> hotels = FXCollections.observableArrayList();
        String req4 = "SELECT * from hebergement" ;
                
       // ResultSet result = null;
        
           Statement ste = connexion.createStatement();
            ResultSet resultat= ste.executeQuery(req4);
            while(resultat.next())
            {
             Hotel h = new Hotel();

             h.setId(resultat.getInt(1));
             h.setNom(resultat.getString(2));
             h.setAdresse(resultat.getString(3));
             h.setAdresseMail(resultat.getString(4));
             h.setNumerotel(resultat.getInt(5));
             h.setType(resultat.getString(6));
            h.setNbEtoile(resultat.getInt(7));
            h.setPrixSingle(resultat.getFloat(8));
            h.setPrixDouble(resultat.getFloat(9));
            h.setPrixEnfant(resultat.getFloat(10));
            h.setImage(resultat.getString(12));
            h.setRating(resultat.getInt(13));
                
                hotels.add(h);
            }
         return hotels;
    }

        @Override
      public ObservableList<Hotel>  findByAdresse(String adresse) 
    {
       ObservableList<Hotel> hotels = FXCollections.observableArrayList();
        Hotel h = new Hotel();
        
        try 
        { 
            String req;
            req = "SELECT * FROM hebergement WHERE adresse LIKE ?";
            PreparedStatement ps = connexion.prepareStatement(req);
            ps.setString(1,"%"+adresse+"%");
            ResultSet resultat = ps.executeQuery();
            while(resultat.next())
            {

            h.setId(resultat.getInt(1));
            h.setNom(resultat.getString(2));
            h.setAdresse(resultat.getString(3));
            h.setAdresseMail(resultat.getString(4));
            h.setNumerotel(resultat.getInt(5));
            h.setType(resultat.getString(6));
            h.setNbEtoile(resultat.getInt(7));
            h.setPrixSingle(resultat.getFloat(8));
            h.setPrixDouble(resultat.getFloat(9));
            h.setPrixEnfant(resultat.getFloat(10));
            h.setImage(resultat.getString(12));
            h.setRating(resultat.getInt(13));
                
            hotels.add(h);
            }
            System.out.println("l'hotel est "+h.getNom());
            return hotels;                    
        } 
        catch (SQLException ex) 
        {
            System.out.println("erreur lors de la recherche de l'hotel " + ex.getMessage());
            return null;
        }   
    }
}
