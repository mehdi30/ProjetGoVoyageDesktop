/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.services;

import tn.esprit.GoVoyage.ConnectionBD.MyBDConx;
import tn.esprit.GoVoyage.entites.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.esprit.GoVoyage.entites.Clients;

/**
 *
 * @author Kouka
 */
public class Reclamationmethodes implements IReclamationmethodes {
    Connection mycon;

    public Reclamationmethodes() throws SQLException {
    mycon = MyBDConx.getInstanceBD().getConnection();
    }
 
   
        public  boolean supprimerReclamation(Reclamation r) throws SQLException {
            String req = "delete from reclamation where "
        + "ref= ? ";
        
       PreparedStatement ps = mycon.prepareStatement(req);
       ps.setInt(1, r.getRef());
       ps.executeUpdate();
        System.out.println("Suppression effectuée avec succès");
              return true;  
        }

    @Override
    public boolean ajouterReclamation(Reclamation r) throws SQLException {
String req1 =" INSERT INTO `reclamation`(`ref`, `description`) VALUES ('"+r.getRef()+"', '"+r.getDescription()+"')";
         Statement ste = mycon.createStatement();
       int x = ste.executeUpdate(req1);
        System.out.println("Insertion effectuée avec succès");
      
       return true;      }

    @Override
    public boolean modifierReclamation(Reclamation r) throws SQLException {
boolean b=false;
         String req1 = "UPDATE `reclamation` SET `description`=? WHERE `ref`=?";
         PreparedStatement ste = mycon.prepareStatement(req1);
         ste.setString(1, r.getDescription());
         ste.setInt(2, r.getRef());
         
         int x= ste.executeUpdate();
         System.out.println("Reclamation modifiée avec succès");
      
               
            
      
        
        
        return true;    }

    @Override
    public void AfficherReclamation() throws SQLException {
        String req1 = "select * from reclamation";

        Statement ste = mycon.createStatement();
        ResultSet res = ste.executeQuery(req1);
        while (res.next()) {
            System.out.println("La reclamation : "
                    + res.getString("description"));
                    

        }
    }
     public ObservableList<Reclamation> getAll() {
        ObservableList<Reclamation> ListeReclamations = FXCollections.observableArrayList();
        Reclamation c;
        try {

            String req = " select * from reclamation";  // retourne une liste de personne // tjr la requette select retourne des differentes resultat
                     Statement ste = mycon.createStatement();

           //ste = mycon.prepareStatement(req);
            ResultSet resultat = mycon.prepareStatement(req).executeQuery(); //ensemble d'objet
            while (resultat.next()) {
                c = new Reclamation();
                //nom,prenom,cin,sexe,date_naissance,nom_utilisateur,mdp,email,telephone,points_fidelite,role
           c.setDescription(resultat.getString("description"));
         c.setRef(resultat.getInt("ref"));
         

         
               

               
                ListeReclamations.add(c);
                System.out.println(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("la liste ne peut pas etre affichée");
            ex.printStackTrace();
        }

        return ListeReclamations;

    }
   
            
        }
           

    
  

