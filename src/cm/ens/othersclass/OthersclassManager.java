/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.ens.othersclass;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Noumodong
 */
public class OthersclassManager {

    public void changementDeStege(String fichierfxlm, int ctx) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene((AnchorPane) FXMLLoader.load(getClass().getResource("/cm/ens/fxml/" + fichierfxlm + ".fxml")));

        if (ctx == 0) {
            stage.setResizable(true);
        } else {
            stage.initStyle(StageStyle.UNDECORATED);
            stage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Paint.valueOf("transparent"));
            stage.setResizable(true);
        }

        stage.setScene(scene);

        stage.show();
    }
}
