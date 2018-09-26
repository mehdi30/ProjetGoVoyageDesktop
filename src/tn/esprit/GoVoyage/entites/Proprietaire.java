/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.entites;

/**
 *
 * @author Kouka
 */
public class Proprietaire extends Clients {
    String nom_propriete;

    public Proprietaire() {
    }

    public Proprietaire(String nom_propriete) {
        this.nom_propriete = nom_propriete;
    }

    public Proprietaire(String nom_propriete, int ref, String username, String nom, String prenom, String cin, String email, String mdp, String nationalite, String dateDeNaissance, String tel, String passeport, String sexe, String role) {
        super(ref, username, nom, prenom, cin, email, mdp, nationalite, dateDeNaissance, tel, passeport, sexe, role);
        this.nom_propriete = nom_propriete;
    }

    public Proprietaire(String nom_propriete, String username, String nom, String prenom, String cin, String email, String mdp, String nationalite, String dateDeNaissance, String tel, String passeport, String sexe, String role) {
        super(username, nom, prenom, cin, email, mdp, nationalite, dateDeNaissance, tel, passeport, sexe, role);
        this.nom_propriete = nom_propriete;
    }

    

   

   

    public String getNom_propriete() {
        return nom_propriete;
    }

    public void setNom_propriete(String nom_propriete) {
        this.nom_propriete = nom_propriete;
    }

    @Override
    public String toString() {
        return "Proprietaire{" + "nom_propriete=" + nom_propriete + '}';
    }

    
    public boolean equals(Object o){ 
        if (o instanceof Proprietaire) {
             Proprietaire p =  (Proprietaire)o;
        
        if(this.nom_propriete.equals(p.nom_propriete) )
            return true;
        }
      return false;
    }
    
    
    
}
