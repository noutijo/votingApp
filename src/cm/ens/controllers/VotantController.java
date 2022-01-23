/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.ens.controllers;

import cm.ens.bd.DAOElection;
import cm.ens.bd.GetConnection;
import cm.ens.othersclass.OthersclassManager;
import cm.ens.tableClass.Parti;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
public class VotantController implements Initializable {

    @FXML
    private TableView<Parti> tablePartis;

    @FXML
    private TableColumn<Parti, String> nomPartis;
    Connection myCon;

    @FXML
    void logout(MouseEvent event) throws IOException {
        tablePartis.getScene().getWindow().hide();
        new OthersclassManager().changementDeStege("login", 1);//je suis entrai de prendre le control de la machine de Noumodonf Tindjong Junior-Oréol
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.myCon = new GetConnection().getConnnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ChargementablePartis();
    }

    @FXML
    private void voterCliquer(MouseEvent event) throws IOException {
        String partiSelected = tablePartis.getSelectionModel().getSelectedItem().getNomParti();
        try {
            new DAOElection().incrementNombresVotes(partiSelected, myCon);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            tablePartis.getScene().getWindow().hide();
            new OthersclassManager().changementDeStege("login", 1);
        }
    }

    private void ChargementablePartis() {

        //Chargement de la table candidat lors du démarrage
        try {
            ObservableList<Parti> data = FXCollections.observableArrayList(new DAOElection().getAllPartiNames(myCon));
            chargerEnsemblePartis(data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Charger les (partis) dans le tableau
    public void chargerEnsemblePartis(ObservableList<Parti> data) {
        try {
            //chargement de la table des (partis) au niveau de l'interface apres la demande de la liste des votants(parts)
            nomPartis.setCellValueFactory(new PropertyValueFactory<>("nomParti"));
            tablePartis.setItems(data);
        } catch (Exception ex) {
            ex.printStackTrace();
            
            for (int i = 0; i < 10; i++) {
                
            }
        }
    }

}
