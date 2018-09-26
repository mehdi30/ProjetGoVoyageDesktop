/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.GoVoyage.entites;


import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Reservation {
     private int  ref ; 
     private String type;
     private Clients ref_client_fk;
     private Vol ref_vol_fk;
     private Hebergement ref_hebergement_fk;
     private Date date_res;
     private String date_arrivee;
     private String date_sortie;
     private int nombreNuits; 
     private float prixTotal ; 
     private int nombreEnfants ; 
     private int nombreAdultes ;
     private int nbre_chbre_single ; 
     private int nbre_chbre_double ;

    public int getNbre_chbre_single() {
        return nbre_chbre_single;
    }

    public void setNbre_chbre_single(int nbre_chbre_single) {
        this.nbre_chbre_single = nbre_chbre_single;
    }

    public int getNbre_chbre_double() {
        return nbre_chbre_double;
    }

    public void setNbre_chbre_double(int nbre_chbre_double) {
        this.nbre_chbre_double = nbre_chbre_double;
    }

    public Reservation(int ref, String type, Clients ref_client_fk, Vol ref_vol_fk, Hebergement ref_hebergement_fk, Date date_res, String date_arrivee, String date_sortie, int nombreNuits, float prixTotal, int nombreEnfants, int nombreAdultes, int nbre_chbre_single, int nbre_chbre_double) {
        this.ref = ref;
        this.type = type;
        this.ref_client_fk = ref_client_fk;
        this.ref_vol_fk = ref_vol_fk;
        this.ref_hebergement_fk = ref_hebergement_fk;
        this.date_res = date_res;
        this.date_arrivee = date_arrivee;
        this.date_sortie = date_sortie;
        this.nombreNuits = nombreNuits;
        this.prixTotal = prixTotal;
        this.nombreEnfants = nombreEnfants;
        this.nombreAdultes = nombreAdultes;
        this.nbre_chbre_single = nbre_chbre_single;
        this.nbre_chbre_double = nbre_chbre_double;
    }
     

    public Reservation(int ref, String type, Clients ref_client_fk, Vol ref_vol_fk, Hebergement ref_hebergement_fk, Date date_res, String date_arrivee, String date_sortie, int nombreNuits, float prixTotal, int nombreEnfants, int nombreAdultes) {
        this.ref = ref;
        this.type = type;
        this.ref_client_fk = ref_client_fk;
        this.ref_vol_fk = ref_vol_fk;
        this.ref_hebergement_fk = ref_hebergement_fk;
        this.date_res = date_res;
        this.date_arrivee = date_arrivee;
        this.date_sortie = date_sortie;
        this.nombreNuits = nombreNuits;
        this.prixTotal = prixTotal;
        this.nombreEnfants = nombreEnfants;
        this.nombreAdultes = nombreAdultes;
    }

    public String getDate_arrivee() {
        return date_arrivee;
    }

    public void setDate_arrivee(String date_arrivee) {
        this.date_arrivee = date_arrivee;
    }

    public String getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(String date_sortie) {
        this.date_sortie = date_sortie;
    }

    public int getNombreNuits() {
        return nombreNuits;
    }

    public void setNombreNuits(int nombreNuits) {
        this.nombreNuits = nombreNuits;
    }

    public float getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(float prixTotal) {
        this.prixTotal = prixTotal;
    }

    public int getNombreEnfants() {
        return nombreEnfants;
    }

    public void setNombreEnfants(int nombreEnfants) {
        this.nombreEnfants = nombreEnfants;
    }

    public int getNombreAdultes() {
        return nombreAdultes;
    }

    public void setNombreAdultes(int nombreAdultes) {
        this.nombreAdultes = nombreAdultes;
    }
     
     

    public Reservation( String type, Clients ref_client_fk, Vol ref_vol_fk, Hebergement ref_hebergement_fk,Date date_res) {
        
        this.type = type;
        this.ref_client_fk = ref_client_fk;
        this.ref_vol_fk = ref_vol_fk;
        this.ref_hebergement_fk = ref_hebergement_fk;
        this.date_res = date_res;
    }

    public Reservation() {
    }

    public int getRef() {
        return ref;
    }
    
    public Date getDate() {
        return date_res;
    }
     public Date getDate_res() {
        return date_res;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Clients getRef_client_fk() {
        return ref_client_fk;
    }

    public void setRef_client_fk(Clients ref_client_fk) {
        this.ref_client_fk = ref_client_fk;
    }

    public Vol getRef_vol_fk() {
        return ref_vol_fk;
    }

    public void setRef_vol_fk(Vol ref_vol_fk) {
        this.ref_vol_fk = ref_vol_fk;
    }

    public Hebergement getRef_hebergement_fk() {
        return ref_hebergement_fk;
    }

    public void setRef_hebergement_fk(Hebergement ref_hebergement_fk) {
        this.ref_hebergement_fk = ref_hebergement_fk;
    }

    @Override
    public String toString() {
        return "Reservation{" + "ref=" + ref + ", type=" + type + ", ref_client_fk=" + ref_client_fk + ", ref_vol_fk=" + ref_vol_fk + ", ref_hebergement_fk=" + ref_hebergement_fk + ", date_res=" + date_res + ", date_arrivee=" + date_arrivee + ", date_sortie=" + date_sortie + ", nombreNuits=" + nombreNuits + ", prixTotal=" + prixTotal + ", nombreEnfants=" + nombreEnfants + ", nombreAdultes=" + nombreAdultes + ", nbre_chbre_single=" + nbre_chbre_single + ", nbre_chbre_double=" + nbre_chbre_double + '}';
    }

    

   

    @Override
    public int hashCode() {
        int hash = 7;
        
         hash = 36 * hash + this.ref ;
        hash = 36 * hash + Objects.hashCode(this.type);
        hash = 36 * hash + Objects.hashCode(this.ref_client_fk );
        hash = 36 * hash + Objects.hashCode(this.ref_vol_fk );
        hash = 36 * hash + Objects.hashCode(this.ref_hebergement_fk );
        hash = 36 * hash + Objects.hashCode(this.date_res );
        hash = 36 * hash + Objects.hashCode(this.date_arrivee );
        hash = 36 * hash + Objects.hashCode(this.date_sortie );
        hash = 36 * hash + Objects.hashCode(this.nombreNuits );
        hash = 36 * hash + Objects.hashCode(this.prixTotal );
        hash = 36 * hash + Objects.hashCode(this.nombreEnfants );
        hash = 36 * hash + Objects.hashCode(this.nombreAdultes );
         hash = 36 * hash + Objects.hashCode(this.nbre_chbre_single  );
        hash = 36 * hash + Objects.hashCode(this.nbre_chbre_double  );

        
        
        return hash;
    }

    public void setDate_res(Date date_res) {
        this.date_res = date_res;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reservation other = (Reservation) obj;
        if (!Objects.equals(this.ref, other.ref)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.ref_client_fk, other.ref_client_fk)) {
            return false;
        }
        if (!Objects.equals(this.ref_vol_fk, other.ref_vol_fk)) {
            return false;
        }
        if (!Objects.equals(this.ref_hebergement_fk, other.ref_hebergement_fk)) {
            return false;
        }
        return true;
    }

    
     
    
  
}
