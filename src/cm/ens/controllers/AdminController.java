/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.ens.controllers;

import cm.ens.othersclass.OthersclassManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Noumodong
 */
public class AdminController implements Initializable {

    @FXML
    private VBox panneauAdminChargement;

    @FXML
    void logout(MouseEvent event) throws IOException {
        panneauAdminChargement.getScene().getWindow().hide();
        new OthersclassManager().changementDeStege("login",1);
    }
    
    @FXML
    void ajouterPartiVotantCliquer(MouseEvent event) throws IOException {
        chargementPan("ajouterParti");
    }

    @FXML
    void EvaluationCliquer(MouseEvent event) throws IOException {
        chargementPan("evaluation");
    }

    @FXML
    void listeCanditsCliquer(MouseEvent event) throws IOException {
        chargementPan("listCandidats");
    }

    @FXML
    void listeVotantsCliquer(MouseEvent event) throws IOException {
        chargementPan("listVotants");
    }

    @FXML
    void ajouterCandidatCliquer(MouseEvent event) throws IOException {
        chargementPan("ajouterCandidat");
    }

    @FXML
    void ajouterVotantCliquer(MouseEvent event) {
        try {
            chargementPan("ajouterVotant");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            chargementPan("ajouterCandidat");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void chargementPan(String fichierfxml) throws IOException {
        panneauAdminChargement.getChildren().clear();
        panneauAdminChargement.getChildren().add((AnchorPane) FXMLLoader.load(getClass().getResource("/cm/ens/fxml/" + fichierfxml + ".fxml")));
    }

}
