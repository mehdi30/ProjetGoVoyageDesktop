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
import tn.esprit.GoVoyage.entites.MaisonHotes;

/**
 *
 * @author asus
 */
public class MaisonHoteService implements IMaisonHotesService{
            Connection connexion;
    
        public MaisonHoteService() {
    connexion = MyBdConnection.getInstanceBD().getConnection();
        }
            @Override
              public void insererMaisonHote(MaisonHotes m) throws SQLException{
    
        try {


    String requete = "INSERT INTO `hebergement` "
               + "(`id`, `nom`, `adresse`, `adresseMail`, `numerotel`, `type`,`PrixNuit`,  `image`, `rating`)"
                + " VALUES (?,?,?,?,?,?,?,?,?); ";


PreparedStatement pst =  connexion.prepareStatement(requete);
   pst.setInt(1, m.getId());
   pst.setString(2, m.getNom());
   pst.setString(3, m.getAdresse());
   pst.setString(4, m.getAdresseMail());
   pst.setInt(5, m.getNumerotel());
   pst.setString(6, m.getType());
   pst.setFloat(7, m.getPrixNuit());
   pst.setString(8, m.getImage());
   pst.setFloat(9, m.getRating());
  
       System.out.println(requete);
       pst.executeUpdate();
        } 
        catch (SQLException ex) {
            Logger.getLogger(HebergementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    
            @Override
    public void supprimerMaisonHotes(int id) throws SQLException {
       try {
            String requete = "DELETE FROM `hebergement` WHERE id=?";
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setInt(1,id);
           
            pst.executeUpdate();
            System.out.println("maisonHote supprimée");
            } catch (SQLException ex) {
            Logger.getLogger(HebergementService.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
 /*           @Override
    public void AfficherMaisonHotes() throws SQLException {
    
        String req1 = "select * from hebergement";
       
       Statement ste = connexion.createStatement();
      ResultSet res= ste.executeQuery(req1);
        while (res.next()) {
            System.out.println("hotel est "+
                    res.getInt("ref")
             +" "+ res.getString("nom")
                    +" "+ res.getString("adresse")
                    +" "+ res.getString("description")
            +" "+ res.getString("type")+""+res.getInt("numTelephone")
             +" "+ res.getInt("refProprietaire")+""+res.getInt("prixNuit")
            );
            
        }
    }
   */ 
    
    
            @Override
     public void ModifierMaisonHotes(MaisonHotes m) {

        try {


String requete ="UPDATE `hebergement` SET `id`=?,`nom`=?,`adresse`=?,`adresseMail`=?,`numerotel`=?,`type`=?,"
       
        + "`PrixEnfant`=?,`image`"
        + "=?,`rating`=? WHERE id= ?" ;


PreparedStatement pst =  connexion.prepareStatement(requete);
 pst.setInt(1, m.getId());
   pst.setString(2, m.getNom());
   pst.setString(3, m.getAdresse());
   pst.setString(4, m.getAdresseMail());
   pst.setInt(5, m.getNumerotel());
   pst.setString(6, m.getType());
   pst.setFloat(7, m.getPrixNuit());
   pst.setString(8, m.getImage());
   pst.setFloat(9, m.getRating());
   
   pst.setInt(10, m.getId());

  
       System.out.println(requete);
       pst.executeUpdate();
        } 
        catch (SQLException ex) {
            Logger.getLogger(HebergementService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void m() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    
            @Override
     public ObservableList<MaisonHotes> displayAll() throws SQLException{
    
    
    ObservableList<MaisonHotes> maisonsHotes = FXCollections.observableArrayList();
        String req4 = "SELECT * from hebergement" ;
                
       // ResultSet result = null;
           Statement ste = connexion.createStatement();
            ResultSet resultat= ste.executeQuery(req4);
            while(resultat.next())
            {
             MaisonHotes h = new MaisonHotes();

             h.setId(resultat.getInt(1));
             h.setNom(resultat.getString(2));
             h.setAdresse(resultat.getString(3));
             h.setAdresseMail(resultat.getString(4));
             h.setNumerotel(resultat.getInt(5));
             h.setType(resultat.getString(6));
            h.setPrixNuit(resultat.getFloat(11));
            h.setImage(resultat.getString(12));
            h.setRating(resultat.getInt(13));
                
                maisonsHotes.add(h);
            }
         return maisonsHotes;
    }
    
            @Override
     public ObservableList<MaisonHotes>  findByAdresse (String adresse) 
    {
       ObservableList<MaisonHotes> maisonsHotes = FXCollections.observableArrayList();
        MaisonHotes m = new MaisonHotes();
        
       
        try 
        { 
            String req;
            req = "SELECT * FROM hebergement WHERE adresse LIKE ?";
            PreparedStatement ps = connexion.prepareStatement(req);
            ps.setString(1,"%"+adresse+"%");
            ResultSet resultat = ps.executeQuery();
            while(resultat.next())
            {
             m.setId(resultat.getInt(1));
             m.setNom(resultat.getString(2));
             m.setAdresse(resultat.getString(3));
             m.setAdresseMail(resultat.getString(4));
             m.setNumerotel(resultat.getInt(5));
             m.setType(resultat.getString(6));
             m.setPrixNuit(resultat.getFloat(11));
             m.setImage(resultat.getString(12));
             m.setRating(resultat.getInt(13));
                
             maisonsHotes.add(m);
            }
            System.out.println("la maison d'hotes est "+m.getNom());
            return maisonsHotes;                    
        } 
        catch (SQLException ex) 
        {
            System.out.println("erreur lors de la recherche de l'hotel " + ex.getMessage());
            return null;
        }   
    }
    

    @Override
    public void AfficherMaisonHotes() throws SQLException {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
