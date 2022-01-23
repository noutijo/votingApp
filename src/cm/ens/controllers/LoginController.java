/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.ens.controllers;

import cm.ens.othersclass.OthersclassManager;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Noumodong
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField identifiant;

    @FXML
    private JFXPasswordField motDePasse;
    @FXML
    private JFXComboBox<String> identifiantPlus;
    @FXML
    private Text messageError;

    @FXML
    void valider(MouseEvent event) throws IOException {
        try {
            if ("Administrateur".equals(identifiantPlus.getSelectionModel().getSelectedItem())) {
                identifiant.getScene().getWindow().hide();
                new OthersclassManager().changementDeStege("admin", 0);
            } else if ("Electeur".equals(identifiantPlus.getSelectionModel().getSelectedItem())) {
                identifiant.getScene().getWindow().hide();
                new OthersclassManager().changementDeStege("votant", 0);
            } else {
                new Thread(() -> {
                    messageError.setVisible(true);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex1) {
                    }
                    messageError.setVisible(false);
                }).start();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void fermercliquer(MouseEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ArrayList<String> list = new ArrayList<>();
            list.add("Administrateur");
            list.add("Electeur");
            ObservableList<Object> listFin = FXCollections.observableArrayList(list);
            identifiantPlus.setItems((ObservableList) listFin);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //vérifions si c'est un électeur.
    public boolean verifierLecteur() {

        return true;
    }

    //vérifiions si c'est un administrateur.
    public boolean verifierAdmin() {

        if ((identifiantPlus.getSelectionModel().getSelectedItem().equals("Administrateur")) && (!identifiant.getText().equals("") && !motDePasse.getText().equals(""))) {

        }
        return true;
    }
}
