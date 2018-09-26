/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.GoVoyage.Test;
//import java.util.Date;
import tn.esprit.GoVoyage.ConnectionBD.ConnexionBD;
import tn.esprit.GoVoyage.entites.Hebergement;
import tn.esprit.GoVoyage.entites.Offre;
import tn.esprit.GoVoyage.entites.Vol;
import java.sql.Connection;
import tn.esprit.GoVoyage.services.OffreService;
import java.sql.Date;
import java.sql.SQLException;
/*
 * @author nizar
 */
public class TestClass {
    
   static Connection mycon;
    
    public static void main(String[] args) 
    {   
         
        
        mycon = ConnexionBD.getInstanceBD().getConnection();
        Date d,c;
        d = java.sql.Date.valueOf( "2020-05-04" );
        c = java.sql.Date.valueOf( "1007-02-02" );
        OffreService offreService = new OffreService();
        Hebergement h = new Hebergement();
        h.setId(1);
           Vol v = new Vol();
          v.setRef(59);
       
        //v.setRef("");
      // Offre p = new Offre("noob",2,"ss",d,c,h,v);
        Offre p1 = new Offre(51,"aaaaaaaaaa",2,"Vol",d,c,h,v);
       // ClientService clientservice = new ClientService();
       try {
        //   System.out.println(clientservice.chercherClient(2));
         //  offreService.insererOffreH(p);
             //offreService.supprimerOffreH(p1);
        
           // System.out.println(offreService.AfficherOffreH());
          System.out.println(offreService.AfficherOffreV());
            offreService.modifierOffreV(p1);
            System.out.println(offreService.AfficherOffreV());
      } catch (SQLException ex) {
     
       }
    }  
}

