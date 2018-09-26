package tn.esprit.GoVoyage.services;




import tn.esprit.GoVoyage.ConnectionBD.MyBdConnection;

import tn.esprit.GoVoyage.entites.Clients;
import tn.esprit.GoVoyage.entites.Hebergement;
import tn.esprit.GoVoyage.entites.Reservation;
import tn.esprit.GoVoyage.entites.Vol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReservationService implements IReservationService{
  Connection mycon;

    public ReservationService() {
    mycon = MyBdConnection.getInstanceBD().getConnection();

    }
  
   
 
    @Override
    public boolean ajouterReservation(Reservation r) throws SQLException {

       String req1 ="INSERT INTO `reservation`"+"( `ref_client_fk`, `type`, `ref_vol_fk`, `ref_hebergement_fk`, `date_creation`,"+
               "`date_arrivee_h`, `date_sortie_h`, `nbre_Adultes`, `nbre_Enfants`, `nbre_nuits`,"+
               "`nbre_chbre_single`, `nbre_chbre_double`, `prix_total`)"
               +" VALUES ('"+r.getRef_client_fk().getRef()+"', '"+r.getType()+"','"
            +r.getRef_vol_fk().getRef()+"','"+r.getRef_hebergement_fk().getId()+"','"+r.getDate()+"','"+r.getDate_arrivee()+"','"+r.getDate_sortie()+
                    "','"+r.getNombreAdultes()+"','"+r.getNombreEnfants()+"','"+r.getNombreNuits()+"','"+r.getNbre_chbre_single()+"','"+
                    r.getNbre_chbre_double()+"','"+r.getPrixTotal()+"'); "; 
   
        
        
        
     
       
       Statement ste = mycon.createStatement();
    
      
          int x = ste.executeUpdate(req1);
      
       
       
       return true;
    }

    @Override
    public boolean supprimerReservation(Reservation r) throws SQLException {
String req = "delete from reservation where "
                + "ref= ? ";
        
       PreparedStatement ps = mycon.prepareStatement(req);
      ps.setInt(1, r.getRef());
         ps.executeUpdate();
     
              return true;
    }

    @Override
    public boolean recherReservation(Reservation r) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean recherReservation(String ref) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public void trierReservationsParType() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void trierReservationsParDate() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean expedierReservation(Reservation r) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public boolean modifierReservation(Reservation r) throws SQLException {
//        
//        
//       String req = "UPDATE `reservation` SET `ref_client_fk`=?,`type`=?,"+
//       " `ref_vol_fk`=?,`ref_hebergement_fk`=?,`date_creation`=?,"+
//        "`date_arrivee_h`=?,`date_sortie_h`=?,`nbre_Adultes`=?,"+
//        "`nbre_Enfants`=?,`nbre_nuits`=?,`nbre_chbre_single`=?,"+
//        "`nbre_chbre_double`=?,`prix_total`=? WHERE "+ "ref= ? ";
//        
//        
//
//        
//       PreparedStatement ps = mycon.prepareStatement(req);
//      ps.setInt(14, r.getRef());
//        ps.setInt(1, r.getRef_client_fk().getRef());
//         ps.setString(2, r.getType());
//          ps.setInt(3, r.getRef_vol_fk().getRef());
//           ps.setInt(4, r.getRef_hebergement_fk().getRef());
//            ps.setDate(5, r.getDate());
//            ps.setDate(6, r.getDate_arrivee());
//            ps.setDate(7, r.getDate_sortie());
//             ps.setInt(8, r.getNombreAdultes());
//              ps.setInt(9, r.getNombreEnfants());
//               ps.setInt(10, r.getNombreNuits());
//                ps.setInt(11, r.getNbre_chbre_single());
//                 ps.setInt(12, r.getNbre_chbre_double());
//                 ps.setFloat(13, r.getPrixTotal());
//                 
//            
//           
//            ps.executeUpdate();
//            System.out.println("Reservation modifiée");
//
//       
//     
//              return true;
//    }
    
    /**
     *
     * @return
     * @throws SQLException
     */
  @Override
    public ObservableList<Reservation> afficherReservations() throws SQLException 
    {
        
      //String req2 = "select o.*,h.id,h.nom from reservation o join hebergement h on o.ref_hebergement_fk=h.id";
      String req1 = "select r.*,v.ref,v.numVol from reservation r join vol v on r.ref_vol_fk=v.ref";
      ObservableList<Reservation> list = FXCollections.observableArrayList(); 
       
      Statement ste = mycon.createStatement();
      ResultSet res= ste.executeQuery(req1);
           

      //ResultSet res1= ste.executeQuery(req2);
        while (res.next()) {
                 
            Reservation r = new Reservation();
            Clients c = new Clients(res.getInt("ref_client_fk"));
            Vol v= new Vol(res.getInt("ref_vol_fk"));
            v.setNumVol(res.getString("v.numVol"));
            Hebergement h  = new Hebergement(res.getInt("ref_hebergement_fk"));
          //  h.setNom(res1.getString("h.id"));
        
           r.setRef(res.getInt("r.ref"));
       System.out.println(res.getInt("ref"));
           r.setType(res.getString("type"));
           r.setRef_client_fk(c);
           r.setRef_vol_fk(v);
           r.setRef_hebergement_fk(h);
           r.setDate_res(res.getDate("date_creation"));
           r.setDate_arrivee(res.getString("date_arrivee_h"));
           r.setDate_sortie(res.getString("date_sortie_h"));
           r.setNombreAdultes(res.getInt("nbre_Adultes"));
           r.setNombreEnfants(res.getInt("nbre_Enfants"));
           r.setNombreNuits(res.getInt("nbre_nuits"));
           r.setNbre_chbre_single(res.getInt("nbre_chbre_single"));
           r.setNbre_chbre_double(res.getInt("nbre_chbre_double"));
           r.setPrixTotal(res.getFloat("prix_total"));
             
                 list.add(r);   
            
                           }
       // System.out.println(list);
            return list;      
    }
 @Override
    public ObservableList<Reservation> afficherReservations1() throws SQLException 
    {
      String req1 = "select o.*,h.id,h.nom from reservation o join hebergement h on o.ref_hebergement_fk=h.id";
     // String req1 = "select r.*,v.ref,v.numVol from reservation r join Vol v on r.ref_vol_fk=v.ref";
      ObservableList<Reservation> list = FXCollections.observableArrayList(); 
       
      Statement ste = mycon.createStatement();
      ResultSet res= ste.executeQuery(req1);
     
      //ResultSet res1= ste.executeQuery(req2);
        while (res.next()) {
            Reservation r = new Reservation();
            Clients c = new Clients(res.getInt("ref_client_fk"));
            Vol v= new Vol(res.getInt("ref_vol_fk"));
          //  v.setNumVol(res.getString("v.numVol"));
            Hebergement h  = new Hebergement(res.getInt("ref_hebergement_fk"));
           h.setNom(res.getString("h.nom"));
           r.setRef(res.getInt("ref"));
           r.setType(res.getString("type"));
           r.setRef_client_fk(c);
           r.setRef_vol_fk(v);
           r.setRef_hebergement_fk(h);
           r.setDate_res(res.getDate("date_creation"));
           r.setDate_arrivee(res.getString("date_arrivee_h"));
           r.setDate_sortie(res.getString("date_sortie_h"));
           r.setNombreAdultes(res.getInt("nbre_Adultes"));
           r.setNombreEnfants(res.getInt("nbre_Enfants"));
           r.setNombreNuits(res.getInt("nbre_nuits"));
           r.setNbre_chbre_single(res.getInt("nbre_chbre_single"));
           r.setNbre_chbre_double(res.getInt("nbre_chbre_double"));
           r.setPrixTotal(res.getFloat("prix_total"));
            
                 list.add(r);        
                           }
            return list;      
    }
    @Override
    public boolean ajouterReservationVol(Reservation r) throws SQLException {

       String req1 ="INSERT INTO `reservation`"+"( `ref_client_fk`, `type`, `ref_vol_fk`, `date_creation`,"+
               "`nbre_Adultes`, `nbre_Enfants`, "+
               "`prix_total`)"
               +" VALUES ('"+r.getRef_client_fk().getRef()+"', '"+r.getType()+"','"
            +r.getRef_vol_fk().getRef()+"','"+r.getDate()+
                    "','"+r.getNombreAdultes()+"','"+r.getNombreEnfants()+"','"+
                    r.getPrixTotal()+"'); "; 
   
        
        
        
     
       
       Statement ste = mycon.createStatement();
    
      
          int x = ste.executeUpdate(req1);
      
       
       
       return true;



    }

    @Override
    public boolean ajouterReservationHHotel(Reservation r) throws SQLException {


       String req1 ="INSERT INTO `reservation`"+"( `ref_client_fk`, `type`, `ref_hebergement_fk`, `date_creation`,"+
               "`date_arrivee_h`, `date_sortie_h`, `nbre_Adultes`, `nbre_Enfants`, `nbre_nuits`,"+
               "`nbre_chbre_single`, `nbre_chbre_double`, `prix_total`)"
               +" VALUES ('"+r.getRef_client_fk().getRef()+"', '"+r.getType()+"','"
            +r.getRef_hebergement_fk().getId()+"','"+r.getDate()+"','"+r.getDate_arrivee()+"','"+r.getDate_sortie()+
                    "','"+r.getNombreAdultes()+"','"+r.getNombreEnfants()+"','"+r.getNombreNuits()+"','"+r.getNbre_chbre_single()+"','"+
                    r.getNbre_chbre_double()+"','"+r.getPrixTotal()+"'); "; 
   
        
        
        
     
       
       Statement ste = mycon.createStatement();
    
      
          int x = ste.executeUpdate(req1);
      
       
       
       return true;

    }

    @Override
    public boolean ajouterReservationHHote(Reservation r) throws SQLException {


       String req1 ="INSERT INTO `reservation`"+"( `ref_client_fk`, `type`,  `ref_hebergement_fk`, `date_creation`,"+
               "`date_arrivee_h`, `date_sortie_h`, `nbre_Adultes`, `nbre_Enfants`, `nbre_nuits`,"+
               " `prix_total`)"
               +" VALUES ('"+r.getRef_client_fk().getRef()+"', '"+r.getType()
           +"','"+r.getRef_hebergement_fk().getId()+"','"+r.getDate()+"','"+r.getDate_arrivee()+"','"+r.getDate_sortie()+
                    "','"+r.getNombreAdultes()+"','"+r.getNombreEnfants()+"','"+r.getNombreNuits()+"','"+r.getPrixTotal()+"'); "; 
   
        
        
        
     
       
       Statement ste = mycon.createStatement();
    
      
          int x = ste.executeUpdate(req1);
      
       
       
       return true;


    }

    @Override
    public boolean modifierReservationVol(Reservation r) throws SQLException {
  
       String req = "UPDATE `reservation` SET `nbre_Adultes`=?,"+
        "`nbre_Enfants`=?,`prix_total`=? WHERE "+ "ref= ? ";
        
        

        
       PreparedStatement ps = mycon.prepareStatement(req);
      ps.setInt(4, r.getRef());
      
      
      //  ps.setInt(1, r.getRef_client_fk().getRef());
         
             ps.setInt(1, r.getNombreAdultes());
              ps.setInt(2, r.getNombreEnfants());
               
                 ps.setFloat(3, r.getPrixTotal());
                 
            
           
            ps.executeUpdate();
            System.out.println("Reservation vol modifiée");

       
     
              return true;


    }

    @Override
    public boolean modifierReservationHHotel(Reservation r) throws SQLException {
  
       String req = "UPDATE `reservation` SET `date_arrivee_h`=?,`date_sortie_h`=?,`nbre_Adultes`=?,"+
        "`nbre_Enfants`=?,`nbre_nuits`=?,`nbre_chbre_single`=?,"+
        "`nbre_chbre_double`=?,`prix_total`=? WHERE "+ "ref= ? ";
        
        

        
       PreparedStatement ps = mycon.prepareStatement(req);
      ps.setInt(9, r.getRef());
       
            ps.setString(1, r.getDate_arrivee());
            ps.setString(2, r.getDate_sortie());
             ps.setInt(3, r.getNombreAdultes());
              ps.setInt(4, r.getNombreEnfants());
               ps.setInt(5, r.getNombreNuits());
                ps.setInt(6, r.getNbre_chbre_single());
                 ps.setInt(7, r.getNbre_chbre_double());
                 ps.setFloat(8, r.getPrixTotal());
                 
            
           
            ps.executeUpdate();
            System.out.println("Reservation hotel modifiée");

       
     
              return true;




    }

    @Override
    public boolean modifierReservationHHote(Reservation r) throws SQLException {
  
       String req = "UPDATE `reservation` SET `date_arrivee_h`=?,`date_sortie_h`=?,`nbre_Adultes`=?,"+
        "`nbre_Enfants`=?,`nbre_nuits`=?,`prix_total`=? WHERE "+ "ref= ? ";
        
        

        
       PreparedStatement ps = mycon.prepareStatement(req);
      ps.setInt(7, r.getRef());
       
            ps.setString(1, r.getDate_arrivee());
            ps.setString(2, r.getDate_sortie());
             ps.setInt(3, r.getNombreAdultes());
              ps.setInt(4, r.getNombreEnfants());
               ps.setInt(5, r.getNombreNuits());
               
                 ps.setFloat(6, r.getPrixTotal());
                 
            
           
            ps.executeUpdate();
            System.out.println("Reservation hote modifiée");

       
     
              return true;

    }

  

}
