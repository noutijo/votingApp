/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.ens.controllers;

import cm.ens.bd.DAOElection;
import cm.ens.bd.GetConnection;
import cm.ens.tableClass.Candidat;
import cm.ens.tableClass.Parti;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Noumodong
 */
public class AjouterCandidatController implements Initializable {

    @FXML
    Pane green;
    @FXML
    Pane red;
    @FXML
    private JFXTextField identiffiantCandidat;

    @FXML
    private JFXTextField nomCandidat;

    @FXML
    private JFXTextField prenomCandidat;

    @FXML
    private JFXTextField ageCandidat;

    @FXML
    private JFXComboBox<?> nomParti;
    private Connection myCon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            myCon = GetConnection.getConnnection();
            ArrayList<Parti> list = new DAOElection().getAllPartiNames(myCon);
            ArrayList<String> list2 = new ArrayList<>();
            for (Parti parti : list) {
                list2.add(parti.getNomParti());
            }
            ObservableList<Object> listFin = FXCollections.observableArrayList(list2);
            nomParti.setItems((ObservableList) listFin);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void validerCliquer(MouseEvent event) throws Exception {
        try {
            new DAOElection().addCandidat(new Candidat(identiffiantCandidat.getText(),
                    nomCandidat.getText(),
                    prenomCandidat.getText(), Integer.valueOf(ageCandidat.getText()),
                    nomParti.getSelectionModel().getSelectedItem().toString()
            ), this.myCon
            );
            identiffiantCandidat.setText("");
        } catch (Exception ex) {
            new Thread(() -> {
                red.setVisible(true);
                try {
                    Thread.sleep(3000);
                    red.setVisible(false);
                } catch (InterruptedException ex1) {

                }
            }).start();
        }
    }
//vider

    @FXML
    private void viderCliquer(MouseEvent event) {
        identiffiantCandidat.setText("");
        nomCandidat.setText("");
        prenomCandidat.setText("");
        ageCandidat.setText("");

    }

}
