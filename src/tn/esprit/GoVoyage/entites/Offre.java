/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.GoVoyage.entites;

import java.sql.Date;
import java.util.Objects;

/*
 * @author nizar
 */
public class Offre {
     
    private int reference;
    private String duree;
    private int specification;
    private String type;
    private Date dateDebut;
    private Date dateFin;
    private Hebergement hebergement;
    private Vol vol;

    public Offre() {
    }

    public Offre(String duree, int specification, String type, Date dateDebut, Date dateFin, Hebergement hebergement, Vol vol) {
        this.duree = duree;
        this.specification = specification;
        this.type = type;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.hebergement = hebergement;
        this.vol = vol;
    }

    public Offre(int reference, String duree, int specification, String type, Date dateDebut, Date dateFin, Hebergement hebergement, Vol vol) {
        this.reference = reference;
        this.duree = duree;
        this.specification = specification;
        this.type = type;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.hebergement = hebergement;
        this.vol = vol;
    }

   

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public int getSpecification() {
        return specification;
    }

    public void setSpecification(int specification) {
        this.specification = specification;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Hebergement getHebergement() {
        return hebergement;
    }

    public void setHebergement(Hebergement hebergement) {
        this.hebergement = hebergement;
    }

    public Vol getVol() {
        return vol;
    }

    public void setVol(Vol vol) {
        this.vol = vol;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Offre other = (Offre) obj;
        if (this.reference != other.reference) {
            return false;
        }
        if (this.specification != other.specification) {
            return false;
        }
        if (!Objects.equals(this.duree, other.duree)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.dateDebut, other.dateDebut)) {
            return false;
        }
        if (!Objects.equals(this.dateFin, other.dateFin)) {
            return false;
        }
        if (!Objects.equals(this.hebergement, other.hebergement)) {
            return false;
        }
        if (!Objects.equals(this.vol, other.vol)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Offre{" + "reference=" + reference + ", duree=" + duree + ", specification=" + specification + ", type=" + type + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", hebergement=" + hebergement + ", vol=" + vol + '}'+"\n";
    }

}
