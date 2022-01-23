/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.ens.controllers;

import cm.ens.bd.DAOElection;
import cm.ens.bd.GetConnection;
import cm.ens.tableClass.Candidat;
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
public class ListCandidatsController implements Initializable {

    @FXML
    private TableView<Candidat> tableCandidats;
    @FXML
    private TableColumn<Candidat, String> idCandidats;
    @FXML
    private TableColumn<Candidat, String> nomsCandidats;
    @FXML
    private TableColumn<Candidat, String> prenomsCanditats;
    @FXML
    private TableColumn<Candidat, Integer> agesCandidats;
    @FXML
    private TableColumn<Candidat, String> partiscandidats;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ChargementableCandidats();
    }

    private void ChargementableCandidats() {

        //Chargement de la table candidat lors du démarrage
        try {
            ObservableList<Candidat> data = FXCollections.observableArrayList(new DAOElection().getAllCandidat(new GetConnection().getConnnection()));
            chargerEnsembleEnseignants(data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Charger les candidats dans le tableau
    public void chargerEnsembleEnseignants(ObservableList<Candidat> data) {
        try {
            //chargement de la table des Candidats au niveau de l'interface apres la demande de la liste des candidats
            idCandidats.setCellValueFactory(new PropertyValueFactory<>("identifiantCandidat"));
            nomsCandidats.setCellValueFactory(new PropertyValueFactory<>("nomCandidat"));
            prenomsCanditats.setCellValueFactory(new PropertyValueFactory<>("prenomCandidat"));
            agesCandidats.setCellValueFactory(new PropertyValueFactory<>("age"));
            partiscandidats.setCellValueFactory(new PropertyValueFactory<>("nomParti"));

            tableCandidats.setItems(data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
