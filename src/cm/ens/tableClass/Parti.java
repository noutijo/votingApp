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
public class Parti {

    private String nomParti;
    private int nombreMillitants;
    private int nombreVotes;

    public Parti(String nomParti, int nombreMillitants, int nombreVotes) {
        this.nomParti = nomParti;
        this.nombreMillitants = nombreMillitants;
        this.nombreVotes = nombreVotes;
    }

    public Parti(String nomParti, int nombreMillitants) {
        this.nomParti = nomParti;
        this.nombreMillitants = nombreMillitants;
    }
    public Parti(String nomParti) {
        this.nomParti = nomParti;
    }

    public String getNomParti() {
        return nomParti;
    }

    public void setNomParti(String nomParti) {
        this.nomParti = nomParti;
    }

    public int getNombreMillitants() {
        return nombreMillitants;
    }

    public void setNombreMillitants(int nombreMillitants) {
        this.nombreMillitants = nombreMillitants;
    }

    public int getNombreVotes() {
        return nombreVotes;
    }

    public void setNombreVotes(int nombreVotes) {
        this.nombreVotes = nombreVotes;
    }

}
