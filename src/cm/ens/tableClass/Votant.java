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
public class Votant {

    private String idendifiantVotant;
    private String nom;
    private String prenom;
    private int age;

    public Votant(String idendifiantVotant, String nom, String prenom, int age) {
        this.idendifiantVotant = idendifiantVotant;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdendifiantVotant() {
        return idendifiantVotant;
    }

    public void setIdendifiantVotant(String idendifiantVotant) {
        this.idendifiantVotant = idendifiantVotant;
    }

}
