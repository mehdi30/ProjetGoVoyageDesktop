/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.entites;

/**
 *
 * @author asus
 */
public class Hotel extends Hebergement {
 
    
    int nbEtoile ;
    float PrixSingle ;
    float PrixDouble ;
    float PrixEnfant ;

    public Hotel(int nbEtoile, float PrixSingle, float PrixDouble, float PrixEnfant, int id, String nom, String adresse, String adresseMail, int numerotel, String type, String image, int rating) {
        super(id, nom, adresse, adresseMail, numerotel, type, image, rating);
        this.nbEtoile = nbEtoile;
        this.PrixSingle = PrixSingle;
        this.PrixDouble = PrixDouble;
        this.PrixEnfant = PrixEnfant;
    }

    public Hotel() {
    }

    public int getNbEtoile() {
        return nbEtoile;
    }

    public void setNbEtoile(int nbEtoile) {
        this.nbEtoile = nbEtoile;
    }

    public float getPrixSingle() {
        return PrixSingle;
    }

    public void setPrixSingle(float PrixSingle) {
        this.PrixSingle = PrixSingle;
    }

    public float getPrixDouble() {
        return PrixDouble;
    }

    public void setPrixDouble(float PrixDouble) {
        this.PrixDouble = PrixDouble;
    }

    public float getPrixEnfant() {
        return PrixEnfant;
    }

    public void setPrixEnfant(float PrixEnfant) {
        this.PrixEnfant = PrixEnfant;
    }

    @Override
    public String toString() {
        return "Hotel{" + "nbEtoile=" + nbEtoile + ", PrixSingle=" + PrixSingle + ", PrixDouble=" + PrixDouble + ", PrixEnfant=" + PrixEnfant + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hotel other = (Hotel) obj;
        if (this.nbEtoile != other.nbEtoile) {
            return false;
        }
        if (Float.floatToIntBits(this.PrixSingle) != Float.floatToIntBits(other.PrixSingle)) {
            return false;
        }
        if (Float.floatToIntBits(this.PrixDouble) != Float.floatToIntBits(other.PrixDouble)) {
            return false;
        }
        if (Float.floatToIntBits(this.PrixEnfant) != Float.floatToIntBits(other.PrixEnfant)) {
            return false;
        }
        return true;
    }


}
