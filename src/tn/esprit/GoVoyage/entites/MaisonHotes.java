/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.entites;

import java.util.Objects;

/**
 *
 * @author asus
 */
public class MaisonHotes extends Hebergement{
 //   int refProprietaire ;
    float PrixNuit ;

    public MaisonHotes() {
    }

    public MaisonHotes(float PrixNuit) {
        this.PrixNuit = PrixNuit;
    }

    public MaisonHotes(float PrixNuit, int id, String nom, String adresse, String adresseMail, int numerotel, String type, String image, int rating) {
        super(id, nom, adresse, adresseMail, numerotel, type, image, rating);
        this.PrixNuit = PrixNuit;
    }

    public float getPrixNuit() {
        return PrixNuit;
    }

    public void setPrixNuit(float PrixNuit) {
        this.PrixNuit = PrixNuit;
    }

    @Override
    public String toString() {
        return "MaisonHotes{" + "PrixNuit=" + PrixNuit + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Float.floatToIntBits(this.PrixNuit);
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
        final MaisonHotes other = (MaisonHotes) obj;
        if (Float.floatToIntBits(this.PrixNuit) != Float.floatToIntBits(other.PrixNuit)) {
            return false;
        }
        return true;
    }

   
}
