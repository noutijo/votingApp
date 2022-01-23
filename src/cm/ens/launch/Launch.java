/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.ens.launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Noumodong
 */
public class Launch extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        Scene scene = new Scene((AnchorPane) FXMLLoader.load(getClass().getResource("/cm/ens/fxml/login.fxml")));
        scene.setFill(Paint.valueOf("transparent"));
        stage.setScene(scene);
        stage.show();
        Pagination pan = new Pagination(4);

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
