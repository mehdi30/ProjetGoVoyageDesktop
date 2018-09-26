    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.GoVoyage.services;

/*
 * @author nizar
 */

import tn.esprit.GoVoyage.ConnectionBD.ConnexionBD;
import static tn.esprit.GoVoyage.GUI.NewFXMain.dateString;
import tn.esprit.GoVoyage.entites.Offre;
import tn.esprit.GoVoyage.entites.Hebergement;
import tn.esprit.GoVoyage.entites.Vol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OffreService implements IOffreService {

    Connection mycon;

    public OffreService() 
    {
    mycon = ConnexionBD.getInstanceBD().getConnection();
    }
  
    @Override
    public  boolean insererOffreH(Offre o) throws SQLException
    {
    //execute a sql query
    String req1 = "   INSERT INTO `offreh`(`duree`, `specification`, `type`, `dateDebut`, `dateFin`, `ref_heberg`)"
            +" VALUES ('"+o.getDuree()+"','"+o.getSpecification()+"','"+o.getType()+"','"+o.getDateDebut()+"','"
                         +o.getDateFin()+"','"+o.getHebergement().getId()+"')";
    //create a statement
    Statement ste = mycon.createStatement();
    int x = ste.executeUpdate(req1);
       
       return true;
    }
  
    @Override
    public  boolean modifierOffreH(Offre o) throws SQLException 
    {  
            String req = "UPDATE `offreh` SET `duree`=?,`specification`=?,`type`=?,`dateDebut`=?,`dateFin`=?,`ref_heberg`=? WHERE id=?";
            PreparedStatement ps = mycon.prepareStatement(req);
           
            ps.setString(1, o.getDuree());
            ps.setInt(2, o.getSpecification());
            ps.setString(3, o.getType());
            ps.setDate(4, o.getDateDebut());
            ps.setDate(5, o.getDateFin());            
            ps.setInt(6, o.getHebergement().getId());
            ps.setInt(7, o.getReference());
            ps.executeUpdate();

        return true;
    }
    
    @Override
    public  boolean supprimerOffreH(Offre o) throws SQLException 
    {
       String req = "delete from offreh where ref= ? ";
        
       PreparedStatement ps = mycon.prepareStatement(req);
       ps.setInt(1,o.getReference());
       ps.executeUpdate();
              return true;
    }

    @Override
    public ObservableList<Offre> AfficherOffreH() throws SQLException 
    {     
      
      ObservableList<Offre> list = FXCollections.observableArrayList(); 
      String req1 = "select o.*,h.nom,h.id from offreh o join hebergement h on o.ref_heberg=h.id";

      Statement ste = mycon.createStatement();
      ResultSet res= ste.executeQuery(req1);
        while (res.next()) {
            Offre o = new Offre();
            Hebergement h = new Hebergement();
            Vol v = new Vol();
            h.setNom(res.getString("h.nom"));
            h.setId(res.getInt("h.id"));
            v.setNumVol("--");
           o.setReference(res.getInt("ref"));
           o.setDuree(res.getString("duree"));
           o.setSpecification(res.getInt("specification"));
           o.setType(res.getString("type"));
           o.setDateDebut(res.getDate("dateDebut"));
           o.setDateFin(res.getDate("dateFin"));
           o.setVol(v);
           o.setHebergement(h);
                 list.add(o);        
                           }
            return list;      
    }

    @Override
     public  boolean insererOffreV(Offre o) throws SQLException
    {
    //execute a sql query
    String req1 = "   INSERT INTO `offrev`(`duree`, `specification`, `type`, `dateDebut`, `dateFin`, `ref_vol`)"
            +" VALUES ('"+o.getDuree()+"','"+o.getSpecification()+"','"+o.getType()+"','"+o.getDateDebut()+"','"
                         +o.getDateFin()+"','"+o.getVol().getRef()+"')";
    //create a statement
    Statement ste = mycon.createStatement();
    int x = ste.executeUpdate(req1);
       
       return true;
    }
    @Override
    public  boolean modifierOffreV(Offre o) throws SQLException 
    {  
            String req = "UPDATE `offrev` SET `duree`=?,`specification`=?,`type`=?,`dateDebut`=?,`dateFin`=?,`ref_vol`=? WHERE ref=?";
            PreparedStatement ps = mycon.prepareStatement(req);
           
            ps.setString(1, o.getDuree());
            ps.setInt(2, o.getSpecification());
            ps.setString(3, o.getType());
            ps.setDate(4, o.getDateDebut());
            ps.setDate(5, o.getDateFin());            
            ps.setInt(6, o.getVol().getRef());
            ps.setInt(7, o.getReference());
            ps.executeUpdate();

        return true;
    }
    
    @Override
    public  boolean supprimerOffreV(Offre o) throws SQLException 
    {
       String req = "delete from offrev where ref= ? ";
        
       PreparedStatement ps = mycon.prepareStatement(req);
       ps.setInt(1,o.getReference());
       ps.executeUpdate();
              return true;
    }

    @Override
    public ObservableList<Offre> AfficherOffreV() throws SQLException 
    {     
      
      ObservableList<Offre> list = FXCollections.observableArrayList(); 
      String req1 = "select o.*,h.numVol,h.ref from offrev o join vol h on o.ref_vol=h.ref";
//String req1 = "select * from offrev";
      Statement ste = mycon.createStatement();
      ResultSet res= ste.executeQuery(req1);
        while (res.next()) {
              Hebergement h = new Hebergement();
           Offre o = new Offre();
            Vol v = new Vol();
            v.setNumVol(res.getString("h.numVol"));
            v.setRef(res.getInt("h.ref"));
            h.setNom(" -- ");
           o.setReference(res.getInt("ref"));
           o.setDuree(res.getString("duree"));
           o.setSpecification(res.getInt("specification"));
           o.setType(res.getString("type"));
           o.setDateDebut(res.getDate("dateDebut"));
           o.setDateFin(res.getDate("dateFin"));
           o.setVol(v);
           o.setHebergement(h);
                 list.add(o);        
                           }
            return list;      
    }

    @Override
    public void Promotion(Offre o) throws SQLException 
    {
//             List<Offre> liste;List<Offre> liste1;
//             liste =AfficherOffreH();
//             liste1 =AfficherOffreV();
//             liste.addAll(liste1);
//             for (Offre o : liste)
//             {
                 try {
                     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                     if (sdf.parse(dateString).compareTo(sdf.parse(o.getDateDebut()+""))>=0)
                     {if(o.getType().equals("Vol"))                            
                     {
                         String req1 = "select * from vol where ref='"+o.getVol().getRef()+"'";
                          Statement ste = mycon.createStatement();
                          ResultSet res= ste.executeQuery(req1);
        while (res.next()) {
            float tarif = res.getFloat("tarif");
            float tarif_apres_promotion = tarif-(tarif*o.getSpecification())/100;
        //    System.out.println(tarif); System.out.println(tarif_apres_promotion);
        String req2 = "UPDATE `vol` SET `tarif`=? ,`promo`=? WHERE ref=?";
                  
            PreparedStatement ps = mycon.prepareStatement(req2);          
            ps.setFloat(1,tarif_apres_promotion );
            ps.setString(2,"oui");
            ps.setInt(3, o.getVol().getRef());        
            ps.executeUpdate();    
                           }                   
                     }
                     else
                     {
                         String req1 = "select * from hebergement where id='"+o.getHebergement().getId()+"'";
                          Statement ste = mycon.createStatement();
                          ResultSet res= ste.executeQuery(req1);
        while (res.next()) {
            int prixNuit = res.getInt("PrixNuit");
            int prixNuit_apres_promotion = prixNuit-(prixNuit*o.getSpecification())/100;
         // System.out.println(prixNuit); System.out.println(prixNuit_apres_promotion);
        String req2 = "UPDATE `hebergement` SET `PrixNuit`=?,`promo`=? WHERE id=?";
                  
            PreparedStatement ps = mycon.prepareStatement(req2);          
            ps.setInt(1,prixNuit_apres_promotion );
            ps.setString(2,"oui");
            ps.setInt(3, o.getHebergement().getId());        
            ps.executeUpdate();    
                           }                   
                     }
                     }        
                 } catch (ParseException ex) {}
                     
                 
             //}
    }

    @Override
    public void PrixInitial(Offre o) throws SQLException {
 //      List<Offre> liste;List<Offre> liste1;
//             liste =AfficherOffreH();
//             liste1 =AfficherOffreV();
//             liste.addAll(liste1);
//             for (Offre o : liste)
//             {
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //   }
        try {
            if (sdf.parse(dateString).compareTo(sdf.parse(o.getDateDebut()+""))>=0)
            {if(o.getType().equals("Vol"))
            {
                String req1 = "select * from vol where ref='"+o.getVol().getRef()+"'";
                Statement ste = mycon.createStatement();
                ResultSet res= ste.executeQuery(req1);
                while (res.next()) {
                    float tarif = res.getFloat("tarif");
                    float tarif_apres_promotion = (tarif/(100-o.getSpecification()))*100;
                    //    System.out.println(tarif); System.out.println(tarif_apres_promotion);
                    String req2 = "UPDATE `vol` SET `tarif`=?,`promo`=? WHERE ref=?";
                    
                    PreparedStatement ps = mycon.prepareStatement(req2);
                    ps.setFloat(1,tarif_apres_promotion );
                    ps.setString(2,"non");
                    ps.setInt(3, o.getVol().getRef());
                    ps.executeUpdate();
                }
            }
            else
            {
                String req1 = "select * from hebergement where id='"+o.getHebergement().getId()+"'";
                Statement ste = mycon.createStatement();
                ResultSet res= ste.executeQuery(req1);
                while (res.next()) {
                    int prixNuit = res.getInt("PrixNuit");
                    int prixNuit_apres_promotion = (prixNuit/(100-o.getSpecification()))*100;
                    // System.out.println(prixNuit); System.out.println(prixNuit_apres_promotion);
                    String req2 = "UPDATE `hebergement` SET `PrixNuit`=?,`promo`=? WHERE id=?";
                    
                    PreparedStatement ps = mycon.prepareStatement(req2);
                    ps.setInt(1,prixNuit_apres_promotion );
                    ps.setString(2,"non");
                    ps.setInt(3, o.getHebergement().getId());
                    ps.executeUpdate();
                }
            }
            }      } catch (ParseException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
}
 