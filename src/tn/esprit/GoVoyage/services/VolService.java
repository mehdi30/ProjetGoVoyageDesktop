/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.services;

import tn.esprit.GoVoyage.ConnectionBD.MyBdConnection;
import tn.esprit.GoVoyage.entites.Vol;
import tn.esprit.GoVoyage.entites.VolAllerRetour;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Mehdi Chaabene
 */
public class VolService implements IVolService {

    Connection mycon;
    private Statement st;
    private Statement ste;
    private PreparedStatement stee;

    public VolService() {
        mycon = MyBdConnection.getInstanceBD().getConnection();
        try {
            ste = mycon.createStatement();
        } catch (SQLException ex) {
            System.out.println("ex");
        }

    }

    @Override
    public boolean insererVol(Vol v) throws SQLException {
        try {
            String req1 = "INSERT INTO `vol`(`villeDepart`, `villeArrivee`, `dateDepartAller`, `dateArriveeAller`,`heureDepart`, `numVol`, `typeAvion`, `cie_aerienne`,`duree`, `nbrPlaceEco`, `nbrPlaceAffaire`,`tarif`, `typeVol`)"
                    + " VALUES ('" + v.getVilleDepart() + "','"
                    + v.getVilleArrivee() + "', '"
                    + v.convert(v.getDateDepartAller()) + "', '"
                    + v.convert(v.getDateArriveeAller()) + "', '"
                    + v.getHeureDepart() + "', '"
                    + v.getNumVol() + "', '"
                    + v.getTypeAvion() + "', '"
                    + v.getCie_aerienne() + "', '"
                    + v.getDuree() + "', '"
                    + v.getNbrPlaceEco() + "', '"
                    + v.getNbrPlaceAffaire() + "', '"
                    + v.getTarif() + "', 'allerSimple'); ";

            Statement ste = mycon.createStatement();
            int x = ste.executeUpdate(req1);

            return true;
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());

        }
        return false;
    }

    public List<Vol> afficher() throws SQLException {
        List<Vol> ls = new ArrayList();
        ResultSet rs = ste.executeQuery("select * from voyage");
        Vol s = null;
        while (rs.next()) {
            s = new Vol(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getFloat(13));

            s.setNumVol(rs.getString(7));
            ls.add(s);
        }
        return ls;
    }

    @Override
    public boolean modifierVol(Vol p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimerVol(Vol p) throws SQLException {
        String req = "delete from vol where "
                + "numVol= ? ";

        PreparedStatement ps = mycon.prepareStatement(req);
        ps.setString(1, p.getNumVol());
        ps.executeUpdate();
        return true;
    }

    public void supprimerVolByNumVol(String numVol) throws SQLException {
        String sql = "DELETE FROM vol WHERE numVol=?";
        PreparedStatement statement = mycon.prepareStatement(sql);
        statement.setString(1, numVol);
        statement.executeUpdate();
    }
    
    public Vol finbById(String numVol) throws SQLException {
        String sql = "select * FROM vol WHERE numVol=? AND typeVol='allerSimple'";
        stee = mycon.prepareStatement(sql);
            
            stee.setString(1, numVol);

            ResultSet result = stee.executeQuery();
            
            while (result.next()) {

              
               /* c = new Vol(result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6),
                        result.getString(7), result.getString(8), result.getString(9), result.getString(10), result.getInt(11), result.getInt(12), result.getFloat(13));
                 */
             Vol v = new VolAllerRetour(result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6),
                        result.getString(7), result.getString(8), result.getString(9), result.getString(10), result.getInt(11), result.getInt(12), result.getFloat(13), result.getString(15), result.getString(16), result.getString(17));

                
             return v;
            }
           return null; 
    }
    public Vol finbByIdtwo(String numVol) throws SQLException {
        String sql = "select * FROM vol WHERE numVol=? AND typeVol='AllerRetour'";
        stee = mycon.prepareStatement(sql);
            
            stee.setString(1, numVol);

            ResultSet result = stee.executeQuery();
            
            while (result.next()) {

              
               /* c = new Vol(result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6),
                        result.getString(7), result.getString(8), result.getString(9), result.getString(10), result.getInt(11), result.getInt(12), result.getFloat(13));
                 */
             VolAllerRetour v = new VolAllerRetour(result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6),
                        result.getString(7), result.getString(8), result.getString(9), result.getString(10), result.getInt(11), result.getInt(12), result.getFloat(13), result.getString(15), result.getString(16), result.getString(17));

                
             return v;
            }
           return null; 
    }

    @Override
    public void afficherVol() throws SQLException {
        String req1 = "select * from vol";

        Statement ste = mycon.createStatement();
        ResultSet res = ste.executeQuery(req1);
        while (res.next()) {
            System.out.println("Numero de vol est : "
                    + res.getString("NumVol")
                    + " De " + res.getString("villeDepart")
                    + " vers " + res.getString("villeArrivee")
                    + " avec " + res.getString("cie_aerienne")
                    + " la date de depart est :" + Vol.convert(res.getDate("dateDepartAller"))
                    + " la date d'arrivee est : " + Vol.convert(res.getDate("dateArriveeAller")));

        }
    }

    @Override
    public boolean insererVolAllerRetour(VolAllerRetour v) throws SQLException {
        try {
            String req1 = "INSERT INTO `vol`(`villeDepart`, `villeArrivee`, `dateDepartAller`, `dateArriveeAller`,`heureDepart`, `numVol`, `typeAvion`, `cie_aerienne`,`duree`, `nbrPlaceEco`, `nbrPlaceAffaire`,`tarif`, `typeVol`, `dateDepartRetour`, `dateArriveeRetour`,`heureDepartR`)"
                    + " VALUES ('" + v.getVilleDepart() + "','"
                    + v.getVilleArrivee() + "', '"
                    + v.convert(v.getDateDepartAller()) + "', '"
                    + v.convert(v.getDateArriveeAller()) + "', '"
                    + v.getHeureDepart() + "', '"
                    + v.getNumVol() + "', '"
                    + v.getTypeAvion() + "', '"
                    + v.getCie_aerienne() + "', '"
                    + v.getDuree() + "', '"
                    + v.getNbrPlaceEco() + "', '"
                    + v.getNbrPlaceAffaire() + "', '"
                    + v.getTarif() + "', 'AllerRetour', '"
                    + v.convert(v.getDateDepartRetour()) + "', '"
                    + v.convert(v.getDateArriveeRetour()) + "', '"
                    + v.getHeureDepartR() + "'); "; // getDateArriveeRetour getDateDepartRetour

            Statement ste = mycon.createStatement();
            int x = ste.executeUpdate(req1);

            return true;
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());

        }
        return false;
    }

    public void updateVolSimple(String numVol, String villeDepart, String villeArrivee, String dateDepartAller, String dateArriveeAller, String heureDepart, String typeAvion, String cie_aerienne, String duree, int nbrPlaceEco, int nbrPlaceAffaire, float tarif) throws SQLException {

        //String sql = "UPDATE voyage SET duree='" + villeDepart + "',date_depart='" + date_depart + "',date_arrivee='" + date_arrivee +"',origine='" + origine +"',destination='" + destination+"',Nb_place='" + Nb_place + "' WHERE id='" + id + "'";
        String sq = "UPDATE `vol` SET `villeDepart`='" + villeDepart + "',`villeArrivee`='" + villeArrivee + "',`dateDepartAller`='" + dateDepartAller + "',`dateArriveeAller`='" + dateArriveeAller + "',`heureDepart`='" + heureDepart + "',`typeAvion`='" + typeAvion + "',`cie_aerienne`='" + cie_aerienne + "',`duree`='" + duree + "',`nbrPlaceEco`='" + nbrPlaceEco + "',`nbrPlaceAffaire`='" + nbrPlaceAffaire + "',`tarif`='" + tarif + "' WHERE numVol='" + numVol + "'";

        try {

            st = mycon.prepareStatement(sq);
            st.executeUpdate(sq);

            //st.execute(sq);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public void updateVolAllerRetour(String numVol, String villeDepart, String villeArrivee, String dateDepartAller, String dateArriveeAller, String heureDepart, String typeAvion, String cie_aerienne, String duree, int nbrPlaceEco, int nbrPlaceAffaire, float tarif,String dateDepartRetour,String dateArriveeRetour,String heureDepartR) throws SQLException {

        //String sql = "UPDATE voyage SET duree='" + villeDepart + "',date_depart='" + date_depart + "',date_arrivee='" + date_arrivee +"',origine='" + origine +"',destination='" + destination+"',Nb_place='" + Nb_place + "' WHERE id='" + id + "'";
        String sq = "UPDATE `vol` SET `villeDepart`='" + villeDepart + "',`villeArrivee`='" + villeArrivee + "',`dateDepartAller`='" + dateDepartAller + "',`dateArriveeAller`='" + dateArriveeAller + "',`heureDepart`='" + heureDepart + "',`typeAvion`='" + typeAvion + "',`cie_aerienne`='" + cie_aerienne + "',`duree`='" + duree + "',`nbrPlaceEco`='" + nbrPlaceEco + "',`nbrPlaceAffaire`='" + nbrPlaceAffaire + "',`tarif`='" + tarif + "',`dateDepartRetour`='" + dateDepartRetour + "',`dateArriveeRetour`='" + dateArriveeRetour + "',`heureDepartR`='" + heureDepartR + "' WHERE numVol='" + numVol + "'";

        try {

            st = mycon.prepareStatement(sq);
            st.executeUpdate(sq);

            //st.execute(sq);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<VolAllerRetour> RechercherVolaller(String villeDepart,String villeArrivee,String dateDepartAller,String dateDepartRetour) {
        List<VolAllerRetour> covs = new ArrayList<>();
        ResultSet result = null;
        VolAllerRetour c = null;
        try {
            String req3 = "select * from vol where villeDepart=? OR villeArrivee=? AND dateDepartAller=? OR dateDepartRetour=? AND dateDepartAller >= Now()  "; // AND arrivee=? AND date=?  dateDepartAller=? OR dateDepartRetour=?

            stee = mycon.prepareStatement(req3);
            stee.setString(1, villeDepart);
             stee.setString(2, villeArrivee);
             stee.setString(3, dateDepartAller);
             stee.setString(4, dateDepartRetour);


            /* ste.setString(2, arrivee);
            ste.setDate(3, date);*/
            result = stee.executeQuery();

            while (result.next()) {

                /* c = new VolAllerRetour(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5),
                        result.getString(6), result.getString(7), result.getString(8), result.getString(9), result.getInt(10), result.getInt(11), result.getFloat(12), result.getString(13), result.getString(14), result.getString(15));
                 */
                c = new VolAllerRetour(result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6),
                        result.getString(7), result.getString(8), result.getString(9), result.getString(10), result.getInt(11), result.getInt(12), result.getFloat(13), result.getString(15), result.getString(12), result.getString(17));

                covs.add(c);

            }
        } catch (SQLException ex) {
        }
        return covs;

    }
    
        public List<Vol> RechercherSeul(String villeDepart,String numVol) {
        List<Vol> covs = new ArrayList<>();
        ResultSet result = null;
        Vol c = null;
        try {
            String req3 = "select * from vol where villeDepart=? OR numVol=? ;"; // AND arrivee=? AND date=?  dateDepartAller=? OR dateDepartRetour=?

            stee = mycon.prepareStatement(req3);
            stee.setString(1, villeDepart);
            stee.setString(2, numVol);

            result = stee.executeQuery();

            while (result.next()) {

              
               /* c = new Vol(result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6),
                        result.getString(7), result.getString(8), result.getString(9), result.getString(10), result.getInt(11), result.getInt(12), result.getFloat(13));
                 */
             c = new VolAllerRetour(result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6),
                        result.getString(7), result.getString(8), result.getString(9), result.getString(10), result.getInt(11), result.getInt(12), result.getFloat(13), result.getString(15), result.getString(16), result.getString(17));

                covs.add(c);

            }
        } catch (SQLException ex) {
        }
        return covs;

    }

             public List<Vol> RechercherVolSimple(String villeDepart,String villeArrivee,String dateDepartAller) {
        List<Vol> covs = new ArrayList<>();
        ResultSet result = null;
        Vol c = null;
        try {
            String req3 = "select * from vol where villeDepart=? OR villeArrivee=? OR dateDepartAller=?   "; // AND arrivee=? AND date=?  dateDepartAller=? OR dateDepartRetour=?

            stee = mycon.prepareStatement(req3);
            stee.setString(1, villeDepart);
             stee.setString(2, villeArrivee);
             stee.setString(3, dateDepartAller);
             


            /* ste.setString(2, arrivee);
            ste.setDate(3, date);*/
            result = stee.executeQuery();

            while (result.next()) {

                /* c = new VolAllerRetour(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5),
                        result.getString(6), result.getString(7), result.getString(8), result.getString(9), result.getInt(10), result.getInt(11), result.getFloat(12), result.getString(13), result.getString(14), result.getString(15));
                 */
                c = new Vol(result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6),
                        result.getString(7), result.getString(8), result.getString(9), result.getString(10), result.getInt(11), result.getInt(12), result.getFloat(13));

                covs.add(c);

            }
        } catch (SQLException ex) {
        }
        return covs;

    }
             /*public List<Vol> caluclNum(String typeVol)
             {
                 String req ="select * from vol where typeVol=? ";
                 
             }*/
                     public List<Vol> caluclNum(String typeVol) {
        List<Vol> covs = new ArrayList<>();
        ResultSet result = null;
        Vol c = null;
        try {
            String req3 = "select * from vol where typeVol=?"; // AND arrivee=? AND date=?  dateDepartAller=? OR dateDepartRetour=?

            stee = mycon.prepareStatement(req3);
            
            stee.setString(1, typeVol);

            result = stee.executeQuery();

            while (result.next()) {

              
               /* c = new Vol(result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6),
                        result.getString(7), result.getString(8), result.getString(9), result.getString(10), result.getInt(11), result.getInt(12), result.getFloat(13));
                 */
             c = new VolAllerRetour(result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6),
                        result.getString(7), result.getString(8), result.getString(9), result.getString(10), result.getInt(11), result.getInt(12), result.getFloat(13), result.getString(15), result.getString(16), result.getString(17));

                covs.add(c);

            }
        } catch (SQLException ex) {
        }
        return covs;

    }
        public List<VolAllerRetour> RechercherBox() {
        List<VolAllerRetour> covs = new ArrayList<>();
        ResultSet result = null;
        VolAllerRetour c = null;
        try {
            String req3 = "SELECT * FROM `vol` Where tarif<500  "; // AND arrivee=? AND date=?  dateDepartAller=? OR dateDepartRetour=?

            stee = mycon.prepareStatement(req3);


            result = stee.executeQuery();

            while (result.next()) {

                c = new VolAllerRetour(result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6),
                        result.getString(7), result.getString(8), result.getString(9), result.getString(10), result.getInt(11), result.getInt(12), result.getFloat(13), result.getString(15), result.getString(12), result.getString(17));

                covs.add(c);

            }
        } catch (SQLException ex) {
        }
        return covs;

    }
            public List<VolAllerRetour> RechercherTun() {
        List<VolAllerRetour> covs = new ArrayList<>();
        ResultSet result = null;
        VolAllerRetour c = null;
        try {
            String req3 = "SELECT * FROM `vol` WHERE cie_aerienne=\"Tunisair\" or cie_aerienne=\"Nouvelair\"   "; // AND arrivee=? AND date=?  dateDepartAller=? OR dateDepartRetour=?

            stee = mycon.prepareStatement(req3);


            result = stee.executeQuery();

            while (result.next()) {

                c = new VolAllerRetour(result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6),
                        result.getString(7), result.getString(8), result.getString(9), result.getString(10), result.getInt(11), result.getInt(12), result.getFloat(13), result.getString(15), result.getString(12), result.getString(17));

                covs.add(c);

            }
        } catch (SQLException ex) {
        }
        return covs;

    }
                   public List<VolAllerRetour> RechercherLowCost() {
        List<VolAllerRetour> covs = new ArrayList<>();
        ResultSet result = null;
        VolAllerRetour c = null;
        try {
            String req3 = "SELECT * FROM `vol` WHERE cie_aerienne=\"Low Cost\" or cie_aerienne=\"Easyjet\" or cie_aerienne=\"Transavia\"   "; // AND arrivee=? AND date=?  dateDepartAller=? OR dateDepartRetour=?

            stee = mycon.prepareStatement(req3);


            result = stee.executeQuery();

            while (result.next()) {

                c = new VolAllerRetour(result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6),
                        result.getString(7), result.getString(8), result.getString(9), result.getString(10), result.getInt(11), result.getInt(12), result.getFloat(13), result.getString(15), result.getString(12), result.getString(17));

                covs.add(c);

            }
        } catch (SQLException ex) {
        }
        return covs;

    }

                    public List<VolAllerRetour> RechercherPromotion() {
        List<VolAllerRetour> covs = new ArrayList<>();
        ResultSet result = null;
        VolAllerRetour c = null;
        try {
            String req3 = "SELECT * FROM `vol` WHERE promo=\"oui\" "; // AND arrivee=? AND date=?  dateDepartAller=? OR dateDepartRetour=?

            stee = mycon.prepareStatement(req3);


            result = stee.executeQuery();

            while (result.next()) {

                c = new VolAllerRetour(result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6),
                        result.getString(7), result.getString(8), result.getString(9), result.getString(10), result.getInt(11), result.getInt(12), result.getFloat(13), result.getString(15), result.getString(12), result.getString(17));

                covs.add(c);

            }
        } catch (SQLException ex) {
        }
        return covs;

    }

}
