/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.services;

import tn.esprit.GoVoyage.ConnectionBD.MyBDConx;
import tn.esprit.GoVoyage.entites.Clients;
import tn.esprit.GoVoyage.entites.Proprietaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Kouka
 */
public class ProprietaireMethodes implements IProprietaireMethodes {
    Connection mycon;

    public ProprietaireMethodes() {
    mycon = MyBDConx.getInstanceBD().getConnection();

    }


    @Override
    public boolean ajouterProprietaire(Proprietaire p) throws SQLException {
       String req1 = "INSERT INTO `utilisateur` (`ref`, `username`, `nom`, `prenom`, `CIN`, `email`, `mdp`, `nationalite`,"
                + " `dateNaissance`, `telephone`, `numPassport`, `sexe`, `role`,`nom_propriete`)"
                + " VALUES('"+p.getRef()+"','"+p.getUsername()+"', '"+p.getNom()+"', '"+p.getPrenom()+"', '"+p.getCin()+"', "
                + "'"+p.getEmail()+"', '"+p.getMdp()+"', '"+p.getNationalite()+"', '"+p.getDateDeNaissance()+"', '"+p.getTel()+"', "
                + "'"+p.getPasseport()+"', '"+p.getSexe()+"','Proprietaire','"+p.getNom_propriete()+"') " ;
         Statement ste = mycon.createStatement();
       int x = ste.executeUpdate(req1);
        System.out.println("Insertion effectuée avec succès");
      
       return true;
    }

    @Override
    public boolean modifierProprietaire(Proprietaire p) throws SQLException {
         boolean b=false;
         String req1 = "UPDATE `utilisateur` SET `username`=?,`nom`=?,`prenom`=?,`CIN`=?,`email`=?,`mdp`=?,`nationalite`=?,`dateNaissance`=?,`telephone`=?,`numPassport`=?,`sexe`=?,`role`=? ,`nom_propriete` WHERE ref=?";
         PreparedStatement ste = mycon.prepareStatement(req1);
         ste.setString(1, p.getUsername());
         ste.setString(2, p.getNom());
         ste.setString(3, p.getPrenom());
         ste.setString(4, p.getCin());
         ste.setString(5, p.getEmail());
         ste.setString(6, p.getMdp());
         ste.setString(7, p.getNationalite());
         ste.setString(8, p.getDateDeNaissance());
         ste.setString(9, p.getTel());
         ste.setString(10, p.getPasseport());
      //   ste.setString(10, c.getDate_cretation());
         ste.setString(11, p.getSexe());
         //ste.setString(12, c.getPt_fidelite());
        // ste.setString(12, c.getUsername());
         ste.setString(12, p.getRole());
        
        ste.setString(13, p.getNom_propriete());
         ste.setInt(14, p.getRef());
         int x= ste.executeUpdate();
         System.out.println("Utilisateur modifié avec succès");
      
               
            
      
        
        
        return true;
    }

    @Override
    public boolean supprimerProprietaire(Proprietaire p) throws SQLException {
        String req = "delete from utilisateur where "
        + "ref= ? ";
        
       PreparedStatement ps = mycon.prepareStatement(req);
       ps.setInt(1, p.getRef());
       ps.executeUpdate();
        System.out.println("Suppression effectuée avec succès");
              return true;
    }

    @Override
    public void AfficherProprietaire() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean found(Proprietaire p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<Proprietaire> getAll() {
       ObservableList<Proprietaire> ListeClients = FXCollections.observableArrayList();
        Proprietaire p;
        try {

            String req = " select * from utilisateur";  // retourne une liste de personne // tjr la requette select retourne des differentes resultat
                     Statement ste = mycon.createStatement();

           //ste = mycon.prepareStatement(req);
            ResultSet resultat = mycon.prepareStatement(req).executeQuery(); //ensemble d'objet
            while (resultat.next()) {
                p = new Proprietaire();
                //nom,prenom,cin,sexe,date_naissance,nom_utilisateur,mdp,email,telephone,points_fidelite,role
                p.setNom(resultat.getString("nom"));
         p.setPrenom(resultat.getString("prenom"));
         p.setCin(resultat.getString("CIN"));
         p.setEmail(resultat.getString("email"));
         p.setMdp(resultat.getString("mdp"));
         p.setNationalite( resultat.getString("nationalite"));
         p.setDateDeNaissance(resultat.getString("dateNaissance"));
         p.setTel(resultat.getString("telephone"));
         p.setPasseport(resultat.getString("numPassport"));
         //c.setDate_cretation(resultat.getString("date_creation"));
         p.setSexe(resultat.getString("sexe"));
         //c.setPt_fidelite(resultat.getString("pt_fidelite"));
         p.setRef(resultat.getInt("ref"));
         p.setUsername(resultat.getString("username"));
                  p.setRole(resultat.getString("role"));

         p.setNom_propriete(resultat.getString("nom_propriete"));
//         if (p.getRole()==Role.Administrateur)
//            p.setRole(resultat.Role.Administrateur);
//            else if (p.getRole()==Role.Client)
//             p.setRole(resultat.Role.Clients);
               

               
                ListeClients.add(p);
                System.out.println(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("la liste ne peut pas etre affichée");
            ex.printStackTrace();
        }

        return ListeClients;

    }

    @Override
    public boolean removeByrefProp(int ref) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
