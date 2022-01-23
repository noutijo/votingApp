/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.ens.controllers;

import cm.ens.bd.DAOElection;
import cm.ens.bd.GetConnection;
import cm.ens.tableClass.Parti;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Noumodong
 */
public class EvaluationController implements Initializable {

    @FXML
    private TableView<Parti> tableResult;
    @FXML
    private TableColumn<Parti, String> nomsPartis;
    @FXML
    private TableColumn<Parti, Integer> nombresMillitants;
    @FXML
    private TableColumn<Parti, Integer> nombresVotes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ChargementableCandidats();
    }
/**
 * 
 * @param event 
 */
    @FXML
    private void reloadCliquer(MouseEvent event) {
        new Thread(() -> {
            while (true) {
        ChargementableCandidats();
            }
        }).start();

    }

    private void ChargementableCandidats() {

        //Chargement de la table votants lors du démarrage
        try {
            ObservableList<Parti> data = FXCollections.observableArrayList(new DAOElection().getAllPartis(new GetConnection().getConnnection()));
            chargerEnsembleEnseignants(data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Charger les Partis dans le tableau
    
    /**
     * 
     * @param data 
     */
    
    public void chargerEnsembleEnseignants(ObservableList<Parti> data) {
        try {
            //chargement de la table des Partis au niveau de l'interface apres la demande de la liste des Partis
            nomsPartis.setCellValueFactory(new PropertyValueFactory<>("nomParti"));
            nombresMillitants.setCellValueFactory(new PropertyValueFactory<>("nombreMillitants"));
            nombresVotes.setCellValueFactory(new PropertyValueFactory<>("nombreVotes"));

            tableResult.setItems(data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
