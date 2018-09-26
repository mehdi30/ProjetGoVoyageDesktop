/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.entites;

/**
 *
 * @author Mehdi Chaabene
 */
public class VolAllerRetour extends Vol {

    private String dateDepartRetour;
    private String dateArriveeRetour;
    private String heureDepartR;

    public VolAllerRetour() {
    }

    public VolAllerRetour(int ref, String villeDepart, String villeArrivee, String dateDepartAller, String dateArriveeAller, String heureDepart, String numVol, String typeAvion, String cie_aerienne, String duree, int nbrPlaceEco, int nbrPlaceAffaire, float tarif,String dateDepartRetour, String dateArriveeRetour, String heureDepartR) {
        super(ref, villeDepart, villeArrivee, dateDepartAller, dateArriveeAller, heureDepart, numVol, typeAvion, cie_aerienne, duree, nbrPlaceEco, nbrPlaceAffaire, tarif);
        this.dateDepartRetour = dateDepartRetour;
        this.dateArriveeRetour = dateArriveeRetour;
        this.heureDepartR = heureDepartR;
    }



    /*public VolAllerRetour(String dateDepartRetour, String dateArriveeRetour, String heureDepartR, String villeDepart, String villeArrivee, String dateDepartAller, String dateArriveeAller, String heureDepart, String numVol, String typeAvion, String cie_aerienne, String duree, int nbrPlaceEco, int nbrPlaceAffaire, float tarif) {
        super(villeDepart, villeArrivee, dateDepartAller, dateArriveeAller, heureDepart, numVol, typeAvion, cie_aerienne, duree, nbrPlaceEco, nbrPlaceAffaire, tarif);
        this.dateDepartRetour = dateDepartRetour;
        this.dateArriveeRetour = dateArriveeRetour;
        this.heureDepartR = heureDepartR;
    }*/

    public VolAllerRetour(String villeDepart, String villeArrivee, String dateDepartAller, String dateArriveeAller, String heureDepart, String numVol, int nbrPlaceEco, String cie_aerienne,String dateDepartRetour, String heureDepartR, String dateArriveeRetour) {
        super(villeDepart, villeArrivee, dateDepartAller, dateArriveeAller, heureDepart, numVol, nbrPlaceEco, cie_aerienne);
        this.dateDepartRetour = dateDepartRetour;
        this.heureDepartR = heureDepartR;
        this.dateArriveeRetour = dateArriveeRetour;

    }
        public VolAllerRetour(String villeDepart, String villeArrivee, String dateDepartAller, String dateArriveeAller, String heureDepart, String numVol, String typeAvion, String cie_aerienne, String duree, int nbrPlaceEco, int nbrPlaceAffaire, float tarif,String dateDepartRetour, String dateArriveeRetour, String heureDepartR) {
        super(villeDepart, villeArrivee, dateDepartAller, dateArriveeAller, heureDepart, numVol, typeAvion, cie_aerienne, duree, nbrPlaceEco, nbrPlaceAffaire, tarif);
        this.dateDepartRetour = dateDepartRetour;
        this.dateArriveeRetour = dateArriveeRetour;
        this.heureDepartR = heureDepartR;
    }


    public String getHeureDepartR() {
        return heureDepartR;
    }

    public String getDateDepartRetour() {
        return dateDepartRetour;
    }

    public void setHeureDepartR(String heureDepartR) {
        this.heureDepartR = heureDepartR;
    }

    public String getDateArriveeRetour() {
        return dateArriveeRetour;
    }

    public void setDateDepartRetour(String dateDepartRetour) {
        this.dateDepartRetour = dateDepartRetour;
    }

    public void setDateArriveeRetour(String dateArriveeRetour) {
        this.dateArriveeRetour = dateArriveeRetour;
    }

}
