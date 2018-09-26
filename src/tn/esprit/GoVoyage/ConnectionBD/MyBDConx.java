/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.ConnectionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Kouka
 */
public class MyBDConx {
    
  String url = "jdbc:mysql:"+ "//localhost:3306/voyag";
   String login ="root";
   String pwd ="";
   Connection mycon;
   static MyBDConx instanceBD;
  
    private MyBDConx() {
      try {
          
          //get a connection to database
          mycon = DriverManager.getConnection(url, login, pwd);
          System.out.println("connexion etablie !!");
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }
        
    }
    
    public static MyBDConx  getInstanceBD(){
        if(instanceBD == null)
            instanceBD = new MyBDConx();
        return instanceBD;
        
    }
    
    public Connection getConnection(){
        return mycon;
    }
}
