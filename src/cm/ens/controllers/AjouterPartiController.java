/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.ens.controllers;

import cm.ens.bd.DAOElection;
import cm.ens.bd.GetConnection;
import cm.ens.tableClass.Parti;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Noumodong
 */
public class AjouterPartiController implements Initializable {

    @FXML
    private JFXTextField nomParti;
    @FXML
    private JFXTextField nombreMilllitants;
    @FXML
    private Pane green;
    @FXML
    private Pane red;
    private Connection myCon;

    /**
     * Initializes the controller class.
     */
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
            new DAOElection().addParti(new Parti(nomParti.getText(), Integer.valueOf(nombreMilllitants.getText())),myCon);
            nomParti.setText("");
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
    }

}
