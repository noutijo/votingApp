/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.ens.tableClass;

/**
 *
 * @author Noumodong
 */
public class Administrateur {

    private String nomAdmin;
    private String motDePasse;

    public Administrateur(String nomAdmin, String motDePasse) {
        this.nomAdmin = nomAdmin;
        this.motDePasse = motDePasse;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    
}
