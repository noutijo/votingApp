/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.ens.controllers;

import cm.ens.bd.DAOElection;
import cm.ens.bd.GetConnection;
import cm.ens.tableClass.Votant;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Noumodong
 */
public class ListVotantsController implements Initializable {

    @FXML
    private TableView<Votant> tableVotants;
    @FXML
    private TableColumn<Votant, String> id_votant;
    @FXML
    private TableColumn<Votant, String> nomsVotant;
    @FXML
    private TableColumn<Votant, String> prenomsVotants;
    @FXML
    private TableColumn<Votant, Integer> ageVotants;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ChargementableCandidats();
    }

    private void ChargementableCandidats() {

        //Chargement de la table votants lors du démarrage
        try {
            ObservableList<Votant> data = FXCollections.observableArrayList(new DAOElection().getAllVotants(GetConnection.getConnnection()));
            chargerEnsembleEnseignants(data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Charger les votants dans le tableau
    public void chargerEnsembleEnseignants(ObservableList<Votant> data) {
        try {
            //chargement de la table des votants au niveau de l'interface apres la demande de la liste des votants
            id_votant.setCellValueFactory(new PropertyValueFactory<>("idendifiantVotant"));
            nomsVotant.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prenomsVotants.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            ageVotants.setCellValueFactory(new PropertyValueFactory<>("age"));

            tableVotants.setItems(data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
