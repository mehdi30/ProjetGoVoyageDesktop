/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.services;

import tn.esprit.GoVoyage.ConnectionBD.MyBDConx;
import tn.esprit.GoVoyage.entites.Clients;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



/**
 *
 * @author Kouka
 */
public class ClientsMethodes implements IClientsMethodes {
    Connection mycon;

    public ClientsMethodes() {
    mycon = MyBDConx.getInstanceBD().getConnection();

    }

    @Override
    public boolean ajouterClient(Clients c) throws SQLException {
        String req1 = "INSERT INTO `utilisateur` (`ref`, `username`, `nom`, `prenom`, `CIN`, `email`, `mdp`, `nationalite`,"
                + " `dateNaissance`, `telephone`, `numPassport`, `sexe`, `role`)"
                + " VALUES('"+c.getRef()+"','"+c.getUsername()+"', '"+c.getNom()+"', '"+c.getPrenom()+"', '"+c.getCin()+"', "
                + "'"+c.getEmail()+"', '"+c.getMdp()+"', '"+c.getNationalite()+"', '"+c.getDateDeNaissance()+"', '"+c.getTel()+"', "
                + "'"+c.getPasseport()+"', '"+c.getSexe()+"','Client') ";
         Statement ste = mycon.createStatement();
       int x = ste.executeUpdate(req1);
        System.out.println("Insertion effectuée avec succès");
      
       return true;
    } 
    
   
    @Override
    public boolean modifierClient(Clients c) throws SQLException {
         boolean b=false;
         String req1 = "UPDATE `utilisateur` SET `username`=?,`nom`=?,`prenom`=?,`CIN`=?,`email`=?,`mdp`=?,`nationalite`=?,`dateNaissance`=?,`telephone`=?,`numPassport`=?,`sexe`=?,`role`=? WHERE ref=?";
         PreparedStatement ste = mycon.prepareStatement(req1);
         ste.setString(1, c.getUsername());
         ste.setString(2, c.getNom());
         ste.setString(3, c.getPrenom());
         ste.setString(4, c.getCin());
         ste.setString(5, c.getEmail());
         ste.setString(6, c.getMdp());
         ste.setString(7, c.getNationalite());
         ste.setString(8, c.getDateDeNaissance());
         ste.setString(9, c.getTel());
         ste.setString(10, c.getPasseport());
      //   ste.setString(10, c.getDate_cretation());
         ste.setString(11, c.getSexe());
         
         //ste.setString(12, c.getPt_fidelite());
        // ste.setString(12, c.getUsername());
       
          
            ste.setString(12, c.getRole());
     
         ste.setInt(13, c.getRef());
         int x= ste.executeUpdate();
         System.out.println("Utilisateur modifié avec succès");
      
               
            
      
        
        
        return true;
    }

    @Override
    //suppression par ref
    public boolean supprimerClient(Clients c) throws SQLException {
String req = "delete from utilisateur where "
        + "ref= ? ";
        
       PreparedStatement ps = mycon.prepareStatement(req);
       ps.setInt(1, c.getRef());
       ps.executeUpdate();
        System.out.println("Suppression effectuée avec succès");
              return true;    }

    /**
     *
     * @param c
     * @param person_image
     * @return
     * @throws java.sql.SQLException
     */
//    
   
     
     
    
     
//    public List<Clients> findALL() {
//        ObservableList<Clients> ListeClient = new ArrayList<>();
    @Override
    public ObservableList<Clients> getAll() {
        ObservableList<Clients> ListeClients = FXCollections.observableArrayList();
        Clients c;
        try {

            String req = " select * from utilisateur";  // retourne une liste de personne // tjr la requette select retourne des differentes resultat
                     Statement ste = mycon.createStatement();

           //ste = mycon.prepareStatement(req);
            ResultSet resultat = mycon.prepareStatement(req).executeQuery(); //ensemble d'objet
            while (resultat.next()) {
                c = new Clients();
                //nom,prenom,cin,sexe,date_naissance,nom_utilisateur,mdp,email,telephone,points_fidelite,role
           c.setNom(resultat.getString("nom"));
         c.setPrenom(resultat.getString("prenom"));
         c.setCin(resultat.getString("CIN"));
         c.setEmail(resultat.getString("email"));
         c.setMdp(resultat.getString("mdp"));
         c.setNationalite( resultat.getString("nationalite"));
         c.setDateDeNaissance(resultat.getString("dateNaissance"));
         c.setTel(resultat.getString("telephone"));
         c.setPasseport(resultat.getString("numPassport"));
         //c.setDate_cretation(resultat.getString("date_creation"));
         c.setSexe(resultat.getString("sexe"));
         //c.setPt_fidelite(resultat.getString("pt_fidelite"));
         c.setRef(resultat.getInt("ref"));
         c.setUsername(resultat.getString("username"));
                  c.setRole(resultat.getString("role"));

         
               

               
                ListeClients.add(c);
                System.out.println(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("la liste ne peut pas etre affichée");
            ex.printStackTrace();
        }

        return ListeClients;

    }
   
//    }
   
    public boolean findByUsernameMdp(String username, String mdp)
    {
        ResultSet res_b;
        String req = "SELECT COUNT(*) FROM utilisateur WHERE username=? AND mdp=?";
        PreparedStatement ps = null;
        try
        {
            ps = mycon.prepareStatement(req);
            ps.setString(1, username);
            ps.setString(2, mdp);
            res_b = ps.executeQuery();
            while(res_b.next())
            {
                if(res_b.getInt(1) > 0)
                {
                    return true;
                }
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
  
   public boolean findByEmail (String email)
    {
        ResultSet resultat;
        String req = "SELECT * FROM utilisateur WHERE email = ?";
        PreparedStatement ps = null;
        try
        {
            ps = mycon.prepareStatement(req);
            ps.setString(1, email);
            resultat = ps.executeQuery();
            if (resultat.next())
                return true;
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    

//    public void m() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public void AfficherClient() throws SQLException {
          String req1 = "select * from utilisateur";
       
       Statement ste = mycon.createStatement();
      ResultSet res= ste.executeQuery(req1);
        while (res.next()) {
            System.out.println("client "+
                    res.getString("username")
             +" "+ res.getString("nom")
            +" "+ res.getString("prenom")
            +" "+ res.getString("cin")
            +" "+ res.getString("email")
            +" "+ res.getString("mdp")
            +" "+ res.getString("nationalite")
            +" "+ res.getString("dateNaissance")
            +" "+ res.getString("telephone")
            +" "+ res.getString("numPassport")
            +" "+ res.getString("sexe")
            +" "+ res.getString("role")
            +" "+ res.getString("nom_propriete"));
        }
    }

    @Override
    public Clients findUserByEmailPwd(String email, String mdp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    public boolean getuser (String username1 , String mdp1 ) throws SQLException {
    //Statement s = mycon.createStatement ();
//   s.executeQuery ("SELECT username, mdp FROM utilisateur");
  // ResultSet rs = s.getResultSet ();
//    Hashtable username = new Hashtable();
//List<String> mdp = new ArrayList<String>();
//while(rs.next()){
//   username.put(rs.getString("username"),rs.getString("mdp"));
//   mdp.add(rs.getString("mdp"));
//    System.out.println(username);
//    System.out.println(mdp);
//}
//        String req = "SELECT (username, mdp) FROM utilisateur WHERE (username = ? AND mdp = ?)";
//        PreparedStatement ps = mycon.prepareStatement(req);
//        ps.setString(1, username1);
//        ps.setString(2, mdp1);
//        ps.executeQuery();
//        ResultSet rs = ps.executeQuery();
//
//        String username = rs.getString(1);
//       String mdp = rs.getString(2);
//
//        if((username.equals(username1)) && (mdp.equals(mdp1)))
//        {
//            return true;
//            
//        }
//        else
//        {
//            return false;
//        }
    
    

    @Override
    public String authusername() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String authmdp() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String uniqueuser() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getuser(String username1, String mdp1) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
       public int getIdByUsernameMdp ( String username , String pwd) throws SQLException {
        int x = 0;
        String req = "select * from utilisateur";
        Statement ste = mycon.createStatement();
        ResultSet res = ste.executeQuery (req);
        while (res.next()) {
            
            if (res.getString("username").equals(username)&& (res.getString("mdp").equals(pwd)))
            {
                x =res.getInt("ref");
            }
            
        }
         System.out.println(x);
        return x;
       
        
        
    }
       
    @Override
       public int getRoleByUsernameMdp ( String username , String pwd) throws SQLException {
       
//        
          
          int x = 0 ;
         // Role x = Role.Client ;
           String req = "select * from utilisateur";
        Statement ste = mycon.createStatement();
        ResultSet res = ste.executeQuery (req);
        PreparedStatement ps = mycon.prepareStatement(req);
        
        while (res.next()) { 
            
            if (res.getString("username").equals(username)&& (res.getString("mdp").equals(pwd)))
            {
                if ( res.getString("role").equals("Administrateur"))
                    x = 1;
                else if ( res.getString("role").equals("Client"))
                    x=2;
                 else if ( res.getString("role").equals("Proprietaire"))
                     x=2;

                    
                        }
           
            
        }
         System.out.println(x);
          return  x;
           
       }

    @Override
    public boolean found(Clients c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
         public List<Clients> FiltrerAdmin() {
        List<Clients> admin = new ArrayList<>();
        ResultSet result = null;
        Clients c = null;
        try {
            String req1 = "SELECT * FROM `utilisateur` WHERE role = 'Administrateur'  "; 
            PreparedStatement pst = mycon.prepareStatement(req1);


            ResultSet res = pst.executeQuery();

            while (res.next()) {

                c = new Clients(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(7), res.getString(6), res.getString(11), res.getString(12), res.getString(13));

                admin.add(c);
                System.out.println(c);

            }
        } catch (SQLException ex) {
        }
        return admin;

    }
         public List<Clients> FiltrerClient() {
        List<Clients> admin = new ArrayList<>();
        ResultSet result = null;
        Clients c = null;
        try {
            String req1 = "SELECT * FROM `utilisateur` WHERE role = 'Client'  "; 
            PreparedStatement pst = mycon.prepareStatement(req1);


            ResultSet res = pst.executeQuery();

            while (res.next()) {

 c = new Clients(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(7), res.getString(6), res.getString(11), res.getString(12), res.getString(13));
                admin.add(c);

            }
        } catch (SQLException ex) {
        }
        return admin;
}
         public List<Clients> FiltrerProp() {
        List<Clients> admin = new ArrayList<>();
        ResultSet result = null;
        Clients c = null;
        try {
            String req1 = "SELECT * FROM `utilisateur` WhERE role = 'Proprietaire'  "; 
            PreparedStatement pst = mycon.prepareStatement(req1);


            ResultSet res = pst.executeQuery();

            while (res.next()) {

 c = new Clients(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(7), res.getString(6), res.getString(11), res.getString(12), res.getString(13));
                admin.add(c);

            }
        } catch (SQLException ex) {
        }
        return admin;
         
}
}
