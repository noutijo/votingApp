/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.ens.controllers;

import cm.ens.bd.DAOElection;
import cm.ens.bd.GetConnection;
import cm.ens.tableClass.Votant;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Noumodong
 */
public class AjouterVotantController implements Initializable {

    @FXML
    Pane green;
    @FXML
    Pane red;
    @FXML
    private JFXTextField identifiantVotant;
    @FXML
    private JFXTextField nomVotant;
    @FXML
    private JFXTextField prenomVotant;
    @FXML
    private JFXTextField ageVotant;
    private Connection myCon;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            myCon = GetConnection.getConnnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void validerCliquer(MouseEvent event) {
        try { 
            new DAOElection().addVotant(new Votant(identifiantVotant.getText(), nomVotant.getText(), prenomVotant.getText(),
                    Integer.valueOf(ageVotant.getText())),
                    myCon);
            identifiantVotant.setText("");
            
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

    @FXML
    private void vidercliquer(MouseEvent event) {
        identifiantVotant.setText("");
        nomVotant.setText("");
        prenomVotant.setText("");
        ageVotant.setText("");
    }

}
