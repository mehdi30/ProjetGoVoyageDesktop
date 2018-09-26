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
import tn.esprit.GoVoyage.entites.Hebergement;

/**
 *
 * @author asus
 */
public class HebergementService implements IHebergementService {
    Connection connexion;
    
        public HebergementService() {
    connexion = MyBdConnection.getInstanceBD().getConnection();

    }

    @Override
     public void insererHebergement(Hebergement h) throws SQLException{
    
        try {
   String req1 = "INSERT INTO `hebergement`(`id`,`nom`, `adresse`,`adresseMail`,`numerotel`,`type`,`image`,`rating`) VALUES (?,?,?,?,?,?,?,?) ";
        
       PreparedStatement ste = connexion.prepareStatement(req1);
       ste.setInt(1,h.getId());
       ste.setString(2,h.getNom());
       ste.setString(3,h.getAdresse());
       ste.setString(4,h.getAdresseMail());
       ste.setInt(5,h.getNumerotel());
       ste.setString(6,h.getType());
       ste.setString(7,h.getImage());
       ste.setInt(8,h.getRating());
       
      
       System.out.println(req1);
       ste.executeUpdate();
        } 
        catch (SQLException ex) {
            Logger.getLogger(HebergementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     @Override
    public void AfficherHebergement() throws SQLException {
    
        String req1 = "select * from hebergement";
       
       Statement ste = connexion.createStatement();
      ResultSet res= ste.executeQuery(req1);
        while (res.next()) {
            System.out.println("hebergement est "+
                    res.getInt(1)
             +" "+ res.getString(2)
                    +" "+ res.getString(3)
                    +" "+ res.getString(4)
                    +" "+ res.getInt(5)
            +" "+ res.getString(6)
                     +" "+ res.getString(7)
                         +" "+ res.getInt(8));
            
        }
    }
  
 // public void ModifierHebergement(Hebergement h)throws SQLException  {

       @Override
    public void modifierHebergement(Hebergement h)
    {
   try {
          String req1= "UPDATE `hebergement` SET `id`=?,`nom`=?,`adresse`=?,`adresseMail`=?,`numerotel`=?,"
                  + "`type`=?,`images`=?"
                  + "`rating`=? WHERE id= ?" ;
           
       PreparedStatement ste = connexion.prepareStatement(req1);
       ste.setInt(1,h.getId());
       ste.setString(2,h.getNom());
       ste.setString(3,h.getAdresse());
       ste.setString(4,h.getAdresseMail());
       ste.setInt(5,h.getNumerotel());
       ste.setString(6,h.getType());
       ste.setString(7,h.getImage());
       ste.setInt(8,h.getRating());
    
       
       ste.executeUpdate();
        
  System.out.println("hebergement modifié");
           
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la modification" + ex.getMessage()); 
            Logger.getLogger(HebergementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public ObservableList<Hebergement>  RechercheParAdresse(String adresse) 
        
    {
          ObservableList<Hebergement> hebergements = FXCollections.observableArrayList();
       // List<Hebergement> listeHebergement = new ArrayList ();
        try 
        { 
            String req;
            req = "SELECT * FROM Hebergement WHERE adresse LIKE ?";
            PreparedStatement ps = connexion.prepareStatement(req);
 
        ps.setString(1,"%"+adresse+"%");    
        ResultSet resultat = ps.executeQuery();
            while(resultat.next())
            {

             Hebergement hebergement = new Hebergement();
             hebergement.setId(resultat.getInt(1));
             hebergement.setNom(resultat.getString(2));
             hebergement.setAdresse(resultat.getString(3));
             hebergement.setAdresseMail(resultat.getString(4));
             hebergement.setNumerotel(resultat.getInt(5));
             hebergement.setType(resultat.getString(6));
             hebergement.setImage(resultat.getString(7));
             hebergement.setRating(resultat.getInt(8));
            
             hebergements.add(hebergement);
            // listeHebergement.add(hebergement);
            }
            return hebergements;                    
        } 
        catch (SQLException ex) 
        {
            System.out.println("erreur lors de la recherche de l'hebergement " + ex.getMessage());
            return null;
        } 

    }
    
     
     
    
    
    
    public ObservableList<Hebergement> displayAll() throws SQLException{
    
    
    ObservableList<Hebergement> hebergements = FXCollections.observableArrayList();
        String req4 = "SELECT * from hebergement" ;
                
       // ResultSet result = null;
        
           Statement ste = connexion.createStatement();
            ResultSet resultat= ste.executeQuery(req4);
            while(resultat.next())
            {
             Hebergement hebergement = new Hebergement();
             hebergement.setId(resultat.getInt(1));
             hebergement.setNom(resultat.getString(2));
             hebergement.setAdresse(resultat.getString(3));
             hebergement.setAdresseMail(resultat.getString(4));
             hebergement.setNumerotel(resultat.getInt(5));
             hebergement.setType(resultat.getString(6));
             hebergement.setImage(resultat.getString(7));
             hebergement.setRating(resultat.getInt(8));
                
                hebergements.add(hebergement);
            }
         return hebergements;
    }

     public void supprimerHebergement(int id)
    {
    try {
            String requete = "DELETE FROM `hebergement` WHERE id=?";
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setInt(1,id);
           
            pst.executeUpdate();
            System.out.println("hebergement supprimée");
            } catch (SQLException ex) {
            Logger.getLogger(HebergementService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        } 
 //public Hebergement findByNom(String adresse) 
   public ObservableList<Hebergement> findByNom(String adresse) throws SQLException
     {
        ObservableList<Hebergement> hebergements = FXCollections.observableArrayList();
        Hebergement hebergement = new Hebergement();
        
        try 
        { 
            String req;
            req = "SELECT * FROM hebergement WHERE adresse LIKE ?";
            PreparedStatement ps = connexion.prepareStatement(req);
            ps.setString(1,"%"+adresse+"%");
            ResultSet resultat = ps.executeQuery();
            while(resultat.next())
            {
            
             hebergement.setId(resultat.getInt(1));
             hebergement.setNom(resultat.getString(2));
             hebergement.setAdresse(resultat.getString(3));
             hebergement.setAdresseMail(resultat.getString(4));
             hebergement.setNumerotel(resultat.getInt(5));
             hebergement.setType(resultat.getString(6));
             hebergement.setImage(resultat.getString(7));
             hebergement.setRating(resultat.getInt(8));
                
            }
            return hebergements;                    
        } 
        catch (SQLException ex) 
        {
            System.out.println("erreur lors de la recherche de l'hotel " + ex.getMessage());
            return null;
        }   
    }

}
    

