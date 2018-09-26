/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.entites;

//import java.sql.Blob;
import java.sql.Blob;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

/**
 *
 * @author Kouka
 */
public class Clients {
     private int ref;
     private String username;
    private String nom;
    private String prenom;
    private String cin;
    private String email;
     String mdp;
      private String nationalite;
      private String dateDeNaissance ;
    private String tel;
    private String passeport;
   
   // private String Date_cretation;
    
    private String sexe;
  
    
   
   // private String pt_fidelite;
        private String role;

   
//        private Blob image;

    public Clients(int ref, String username, String nom, String prenom, String cin, String email, String mdp, String nationalite, String dateDeNaissance, String tel, String passeport, String sexe, String role) {
        this.ref = ref;
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.email = email;
        this.mdp = mdp;
        this.nationalite = nationalite;
        this.dateDeNaissance = dateDeNaissance;
        this.tel = tel;
        this.passeport = passeport;
        this.sexe = sexe;
        this.role = role;
    }

    public Clients() {
    }

    public Clients(int ref,String username, String nom, String prenom, String email, String mdp, String passeport, String sexe, String role) {
        this.ref=ref;
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.passeport = passeport;
        this.sexe = sexe;
        this.role=role;
    }

    public Clients(String username, String nom, String prenom, String cin, String email, String mdp, String nationalite, String dateDeNaissance, String tel, String passeport, String sexe, String role) {
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.email = email;
        this.mdp = mdp;
        this.nationalite = nationalite;
        this.dateDeNaissance = dateDeNaissance;
        this.tel = tel;
        this.passeport = passeport;
        this.sexe = sexe;
        this.role = role;
    }

    public Clients(int Ref_client) {

 this.ref=Ref_client;
    }

    public int getRef() {
        return ref;
    }

    public String getUsername() {
        return username;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCin() {
        return cin;
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public String getNationalite() {
        return nationalite;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public String getTel() {
        return tel;
    }

    public String getPasseport() {
        return passeport;
    }

    public String getSexe() {
        return sexe;
    }

    public String getRole() {
        return role;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setPasseport(String passeport) {
        this.passeport = passeport;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
       // return "Clients{" + "ref=" + ref + ", username=" + username + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", email=" + email + ", mdp=" + mdp + ", nationalite=" + nationalite + ", dateDeNaissance=" + dateDeNaissance + ", tel=" + tel + ", passeport=" + passeport + ", sexe=" + sexe + ", role=" + role + '}';
       return ref+""; 
    }

  
 public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.ref);                          
        hash = 11 * hash + Objects.hashCode(this.username);
        hash = 11 * hash + Objects.hashCode(this.nom);
        hash = 11 * hash + Objects.hashCode(this.prenom);
        hash = 11 * hash + Objects.hashCode(this.cin);
        hash = 11 * hash + Objects.hashCode(this.email);
        hash = 11 * hash + Objects.hashCode(this.mdp);
        hash = 11 * hash + Objects.hashCode(this.nationalite);
        hash = 11 * hash + Objects.hashCode(this.dateDeNaissance);
        hash = 11 * hash + Objects.hashCode(this.tel);
        hash = 11 * hash + Objects.hashCode(this.passeport);
        hash = 11 * hash + Objects.hashCode(this.sexe);
        hash = 11 * hash + Objects.hashCode(this.role);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clients other = (Clients) obj;
        if (this.ref != other.ref) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.cin, other.cin)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.mdp, other.mdp)) {
            return false;
        }
        if (!Objects.equals(this.nationalite, other.nationalite)) {
            return false;
        }
        if (!Objects.equals(this.dateDeNaissance, other.dateDeNaissance)) {
            return false;
        }
        if (!Objects.equals(this.tel, other.tel)) {
            return false;
        }
        if (!Objects.equals(this.passeport, other.passeport)) {
            return false;
        }
        if (!Objects.equals(this.sexe, other.sexe)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        return true;
    }
 
     public java.sql.Date convert(String date) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date1 = sdf1.parse(date);
        java.sql.Date sqldate = new java.sql.Date(date1.getTime());
        return sqldate;

    }

    public static String convert(java.sql.Date d) {
        SimpleDateFormat df = new SimpleDateFormat("dd MMMM yyyy");
        String text = df.format(d);
        return text;
    }

    
    
    
    
    
    
}
