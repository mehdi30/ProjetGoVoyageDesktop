/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.entites;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Mehdi Chaabene
 */
public class Vol {

    private int ref;

    protected String villeDepart;
    protected String villeArrivee;
    protected String dateDepartAller;
    protected String dateArriveeAller;
    protected String heureDepart;

    protected String numVol;
    protected String typeAvion;
    protected String cie_aerienne;
    protected String duree;
    protected int nbrPlaceEco;
    protected int nbrPlaceAffaire;
    protected float tarif;
    protected String typeVol;

    public Vol() {
    }

    public Vol(int ref, String villeDepart, String villeArrivee, String dateDepartAller, String dateArriveeAller, String heureDepart, String numVol, String typeAvion, String cie_aerienne, String duree, int nbrPlaceEco, int nbrPlaceAffaire, float tarif) {
        this.ref = ref;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.dateDepartAller = dateDepartAller;
        this.dateArriveeAller = dateArriveeAller;
        this.heureDepart = heureDepart;
        this.numVol = numVol;
        this.typeAvion = typeAvion;
        this.cie_aerienne = cie_aerienne;
        this.duree = duree;
        this.nbrPlaceEco = nbrPlaceEco;
        this.nbrPlaceAffaire = nbrPlaceAffaire;
        this.tarif = tarif;
    }

    public Vol(String villeDepart, String villeArrivee, String dateDepartAller, String dateArriveeAller, String heureDepart, String numVol, String typeAvion, String cie_aerienne, String duree, int nbrPlaceEco, int nbrPlaceAffaire, float tarif) {
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.dateDepartAller = dateDepartAller;
        this.dateArriveeAller = dateArriveeAller;
        this.heureDepart = heureDepart;
        this.numVol = numVol;
        this.typeAvion = typeAvion;
        this.cie_aerienne = cie_aerienne;
        this.duree = duree;
        this.nbrPlaceEco = nbrPlaceEco;
        this.nbrPlaceAffaire = nbrPlaceAffaire;
        this.tarif = tarif;


    }

    public Vol(String villeDepart, String villeArrivee, String dateDepartAller, String dateArriveeAller, String heureDepart, String numVol, int nbrPlaceEco, String cie_aerienne) {
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.dateDepartAller = dateDepartAller;
        this.dateArriveeAller = dateArriveeAller;
        this.heureDepart = heureDepart;
        this.numVol = numVol;
        this.cie_aerienne = cie_aerienne;
        this.nbrPlaceEco = nbrPlaceEco;
    }

    public Vol(String villeDepart, String villeArrivee, String dateDepartAller, String dateArriveeAller, String heureDepart, String typeAvion, String cie_aerienne, String duree, int nbrPlaceEco, int nbrPlaceAffaire, float tarif) {
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.dateDepartAller = dateDepartAller;
        this.dateArriveeAller = dateArriveeAller;
        this.heureDepart = heureDepart;
        this.typeAvion = typeAvion;
        this.cie_aerienne = cie_aerienne;
        this.duree = duree;
        this.nbrPlaceEco = nbrPlaceEco;
        this.nbrPlaceAffaire = nbrPlaceAffaire;
        this.tarif = tarif;

    }

    public Vol(int Ref_Type) {

  this.ref = Ref_Type;
    }


    public String getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }

    public int getRef() {

        return ref;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

        public String getTypeVol() {
        return typeVol;
    }

    public void setTypeVol(String typeVol) {
        this.typeVol = typeVol;
    }

    public String getDuree() {
        return duree;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public String getDateDepartAller() {
        return dateDepartAller;
    }

    public String getDateArriveeAller() {
        return dateArriveeAller;
    }

    public String getNumVol() {
        return numVol;
    }

    public String getTypeAvion() {
        return typeAvion;
    }

    public String getCie_aerienne() {
        return cie_aerienne;
    }

    public int getNbrPlaceEco() {
        return nbrPlaceEco;
    }

    public int getNbrPlaceAffaire() {
        return nbrPlaceAffaire;
    }

    public float getTarif() {
        return tarif;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public void setDateDepartAller(String dateDepartAller) {
        this.dateDepartAller = dateDepartAller;
    }

    public void setDateArriveeAller(String dateArriveeAller) {
        this.dateArriveeAller = dateArriveeAller;
    }

    public void setNumVol(String NumVol) {
        this.numVol = NumVol;
    }

    public void setTypeAvion(String typeAvion) {
        this.typeAvion = typeAvion;
    }

    public void setCie_aerienne(String cie_aerienne) {
        this.cie_aerienne = cie_aerienne;
    }

    public void setNbrPlaceEco(int nbrPlaceEco) {
        this.nbrPlaceEco = nbrPlaceEco;
    }

    public void setNbrPlaceAffaire(int nbrPlaceAffaire) {
        this.nbrPlaceAffaire = nbrPlaceAffaire;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public boolean equals(Object o) {
        if (o instanceof Vol) {
            Vol v = (Vol) o;

            if (this.numVol.equals(v.numVol)) {
                return true;
            }
        }
        return false;
    }

    public java.sql.Date convert(String date) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date1 = sdf1.parse(date);
        java.sql.Date sqldate = new java.sql.Date(date1.getTime());
        return sqldate;

    }

    public static String convert(java.sql.Date d) {
        SimpleDateFormat df = new SimpleDateFormat("dd MMMM yyyy");
        String text = df.format(d);
        return text;
    }

    @Override
    public String toString() {
        return  numVol;
    }

}
