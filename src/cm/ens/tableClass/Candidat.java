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
public class Candidat {

    private String identifiantCandidat;
    private String nomCandidat;
    private String prenomCandidat;
    private int age;
    private String nomParti;

    public Candidat(String identifiantCandidat, String nomCandidat, String prenomCandidat, int age, String nomParti) {
        this.identifiantCandidat = identifiantCandidat;
        this.nomCandidat = nomCandidat;
        this.prenomCandidat = prenomCandidat;
        this.nomParti = nomParti;
        this.age = age;
    }

    public String getNomCandidat() {
        return nomCandidat;
    }

    public void setNomCandidat(String nomCandidat) {
        this.nomCandidat = nomCandidat;
    }

    public String getPrenomCandidat() {
        return prenomCandidat;
    }

    public void setPrenomCandidat(String prenomCandidat) {
        this.prenomCandidat = prenomCandidat;
    }

    public String getNomParti() {
        return nomParti;
    }

    public void setNomParti(String nomParti) {
        this.nomParti = nomParti;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdentifiantCandidat() {
        return identifiantCandidat;
    }

    public void setIdentifiantCandidat(String identifiantCandidat) {
        this.identifiantCandidat = identifiantCandidat;
    }

}
