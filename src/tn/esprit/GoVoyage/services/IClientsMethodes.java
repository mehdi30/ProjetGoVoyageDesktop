/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.services;

import tn.esprit.GoVoyage.entites.Clients;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Kouka
 */
public interface IClientsMethodes {
    public boolean ajouterClient(Clients c) throws SQLException;
    public  boolean modifierClient(Clients c) throws SQLException;
        public  boolean supprimerClient(Clients c) throws SQLException ;
            public  void AfficherClient() throws SQLException;
               // public List<Clients> findALL() ;
    public boolean found(Clients c) throws SQLException  ;
    public ObservableList<Clients> getAll();
           // public boolean trouverproprietaire (Clients c) throws SQLException  ;
 public Clients findUserByEmailPwd(String email, String mdp);
 public boolean findByUsernameMdp(String username, String mdp);
  public boolean findByEmail (String email);
  public String authusername () throws SQLException;
  public String authmdp () throws SQLException;
public String uniqueuser () throws SQLException ;
public boolean getuser (String username1 , String mdp1 ) throws SQLException;
 public int getRoleByUsernameMdp ( String username , String pwd) throws SQLException ;
  public int getIdByUsernameMdp ( String username , String pwd) throws SQLException ;
   public List<Clients> FiltrerClient();
    public List<Clients> FiltrerAdmin();
     public List<Clients> FiltrerProp();


//public void m();

    
}
