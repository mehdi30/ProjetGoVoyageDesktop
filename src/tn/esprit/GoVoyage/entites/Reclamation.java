/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.entites;

import java.util.Objects;

/**
 *
 * @author Kouka
 */
public class Reclamation {
    int Ref;
    String description;

    public Reclamation() {
    }
    

    public Reclamation(int Ref, String description) {
        this.Ref = Ref;
        this.description = description;
    }

    public int getRef() {
        return Ref;
    }

    public String getDescription() {
        return description;
    }

    public void setRef(int Ref) {
        this.Ref = Ref;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "Ref=" + Ref + ", description=" + description + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Reclamation other = (Reclamation) obj;
        if (this.Ref != other.Ref) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
    
    
}
