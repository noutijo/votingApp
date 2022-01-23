package cm.ens.bd;

import cm.ens.tableClass.Candidat;
import cm.ens.tableClass.Parti;
import cm.ens.tableClass.Votant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Noumodong
 */
public class DAOElection {

    /**
     * ***GESTIONS DES AJOUTS DANS LES TABLEES DE LA BASE DE DONNE **
     */
    /**
     *
     * @param candidat
     * @param myConn
     * @throws SQLException
     */
    public void addCandidat(Candidat candidat, Connection myConn) throws SQLException {

        PreparedStatement stmnt = null;

        try {
            stmnt = myConn.prepareStatement("insert into candidat values(?,?,?,?,?)");
            stmnt.setString(1, candidat.getIdentifiantCandidat());
            stmnt.setString(2, candidat.getNomCandidat());
            stmnt.setString(3, candidat.getPrenomCandidat());
            stmnt.setInt(4, candidat.getAge());
            stmnt.setString(5, candidat.getNomParti());

            stmnt.execute();
            System.out.println("Enregistrer avec succes ...");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

        }
    }
//VOTANT

    /**
     *
     * @param votant
     * @param myConn
     * @throws SQLException
     */
    public void addVotant(Votant votant, Connection myConn) throws SQLException {

        PreparedStatement stmnt = null;

        try {
            stmnt = myConn.prepareStatement("insert into votant values(?,?,?,?)");
            stmnt.setString(1, votant.getIdendifiantVotant());
            stmnt.setString(2, votant.getNom());
            stmnt.setString(3, votant.getPrenom());
            stmnt.setInt(4, votant.getAge());

            stmnt.execute();
            System.out.println("Enregistrer avec succes ...");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

        }
    }
    //PARTI

    /**
     *
     * @param parti
     * @param myConn
     * @throws SQLException
     */
    public void addParti(Parti parti, Connection myConn) throws SQLException {

        PreparedStatement stmnt = null;

        try {
            stmnt = myConn.prepareStatement("insert into parti (`nom_parti`,`nombre_millitants`) values(?,?)");
            stmnt.setString(1, parti.getNomParti());
            stmnt.setInt(2, parti.getNombreMillitants());

            stmnt.execute();
            System.out.println("Enregistrer avec succes ...");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

        }
    }

    /**
     * ****GESTIONS DES RECUPERATIONS DES DONNNES DANS LA BASE DONNEE
     *
     *
     * @param myConn
     * @return
     * @throws java.lang.Exception
     */
    public ArrayList<Parti> getAllPartiNames(Connection myConn) throws Exception {

        ArrayList<Parti> list = new ArrayList<>();

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select nom_parti from parti");
            while (myRs.next()) {
                Parti tempParti = convertRowToParti(myRs);
                list.add(tempParti);
            }
            return list;

        } finally {
            System.out.println("voila tous les partis de la listes des elections :)");
        }
    }

    //AVOIE TOUS LES CHAMPS DE LA TABLE DU PARTI
    /**
     *
     * @param myConn
     * @return
     * @throws Exception
     */
    public ArrayList<Parti> getAllPartis(Connection myConn) throws Exception {

        ArrayList<Parti> list = new ArrayList<>();

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select *from parti");
            while (myRs.next()) {
                Parti tempParti = convertRowToPartis(myRs);
                list.add(tempParti);
            }
            return list;

        } finally {
            System.out.println("voila tous les partis de la listes des elections :)");
        }
    }

//VOTANT
    /**
     *
     * @param myConn
     * @return
     * @throws Exception
     */
    public List<Votant> getAllVotants(Connection myConn) throws Exception {

        List<Votant> list = new ArrayList<>();

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myConn.createStatement();  
            myRs = myStmt.executeQuery("SELECT * FROM votant /* sélectionner en ordre alphabétique "
                    + "tous les votants.*/ ORDER BY nom_votant ASC");
            while (myRs.next()) {
                Votant tempVotant = convertRowToVotants(myRs);
                list.add(tempVotant);
            }
            return list;

        } finally {
            System.out.println("voila tous les noms votants de la listes des elections :)");
        }

    }

    //PARTI NAMES
    /**
     *
     * @param myConn
     * @return
     * @throws Exception
     */
    public List<Parti> getAllVotantsNames(Connection myConn) throws Exception {

        List<Parti> list = new ArrayList<>();

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select `nom_parti` from Parti");
            while (myRs.next()) {
                Parti tempParti = convertRowToPartiNames(myRs);
                list.add(tempParti);
            }
            return list;

        } finally {
            System.out.println("voila tous les partis names de la listes des elections :)");
        }
    }

    //CANDIDAT
    /**
     *
     * @param myConn
     * @return
     * @throws Exception
     */
    public List<Candidat> getAllCandidat(Connection myConn) throws Exception {

        List<Candidat> list = new ArrayList<>();

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from candidat");
            while (myRs.next()) {
                Candidat tempCandidat = convertRowToCandidats(myRs);
                list.add(tempCandidat);
            }
            return list;

        } finally {
            System.out.println("voila tous les candidats de la listes des elections :)");
        }
    }

    /**
     * ****GESTIONS DES CONVERTIONS DES DONNEES VENANT DE LA BASE DE DONNEE****
     */
    /**
     *
     * @param myRs
     * @return
     * @throws SQLException
     */
    private Parti convertRowToParti(ResultSet myRs) throws SQLException {
        String nom_parti = myRs.getString("nom_parti");
        Parti tempParti = new Parti(nom_parti);
        return tempParti;
    }

    //Tous les partis 
    /**
     *
     * @param myRs
     * @return
     * @throws SQLException
     */
    private Parti convertRowToPartis(ResultSet myRs) throws SQLException {
        String nom_parti = myRs.getString("nom_parti");
        int nombre_milli = myRs.getInt("nombre_millitants");
        int nom_votant = myRs.getInt("nombres_votes");
        Parti tempParti = new Parti(nom_parti, nombre_milli, nom_votant);
        return tempParti;
    }

    /**
     * votant*
     */
    /**
     *
     * @param myRs
     * @return
     * @throws SQLException
     */
    private Votant convertRowToVotants(ResultSet myRs) throws SQLException {

        String id_votant = myRs.getString("id_votant");
        String nom_votant = myRs.getString("nom_votant");
        String prenom_votant = myRs.getString("prenom_votant");
        int age = myRs.getInt("age");

        Votant tempVotant = new Votant(id_votant, nom_votant, prenom_votant, age);
        return tempVotant;
    }

    //Parti name
    /**
     *
     * @param myRs
     * @return
     * @throws SQLException
     */
    private Parti convertRowToPartiNames(ResultSet myRs) throws SQLException {
        String id_name = myRs.getString("nom_parti");
        Parti tempParti = new Parti(id_name);
        return tempParti;
    }

    /**
     *
     * @param myRs
     * @return
     * @throws SQLException
     */
    private Candidat convertRowToCandidats(ResultSet myRs) throws SQLException {

        String id_candidat = myRs.getString("id_candidat");
        String nom_candidat = myRs.getString("nom_candidat");
        String prenom_candidat = myRs.getString("prenom_candidat");
        int age = myRs.getInt("age");

        String nom_parti = myRs.getString("nom_parti");

        Candidat tempCandidat = new Candidat(id_candidat, nom_candidat, prenom_candidat, age, nom_parti);
        return tempCandidat;
    }

    //mise à jour des valeur lorsque les electeurs ont votés
    /**
     *
     * @param idendifiant
     * @param myConn
     * @throws Exception
     */
    public void incrementNombresVotes(String idendifiant, Connection myConn) throws Exception {

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from parti where nom_parti='" + idendifiant + "'");
            int nbr = 0;
            while (myRs.next()) {
                nbr = myRs.getInt("nombres_votes") + 1;
            }
            addVote(nbr, idendifiant, myConn);
        } finally {
            System.out.println("voila nous avons bien incrementé le votes ...:)");
        }
    }

    //la mise à jour des nouvelles valeurs de du nombre de vote : excuse moi pourle francais banal :) 
    /**
     *
     * @param nombre
     * @param nomParti
     * @param myConn
     * @throws SQLException
     */
    public void addVote(int nombre, String nomParti, Connection myConn) throws SQLException {

        PreparedStatement stmnt = null;

        try {
            stmnt = myConn.prepareStatement("update parti set `nombres_votes`=? where `nom_parti`='" + nomParti + "'");
            /*stmnt = myConn.prepareStatement("update parti set `nombres_votes`=(CASE "
                    + "WHEN nombres_votes>=0 THEN nombres_votes+1)"
                    + " ELSE nombres_votes"
                    + " END) WHERE `nom_parti`='" + nomParti +"'" );*/
            stmnt.setInt(1, nombre);
            stmnt.executeUpdate();
            System.out.println("nombres de vote incrementer avec succès:)  soit la mise à jour avec succès...");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

        }
    }

}
