package sample.ExerciseReading;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadingController extends dataBaseReading{
    @FXML
    private BorderPane installScene;

    @FXML
    void btn1(ActionEvent event) {
        ShowReadingController.setBtn(1);
        LoadUI("ShowReading");
    }

    @FXML
    void btn2(ActionEvent event) {
        ShowReadingController.setBtn(2);
        LoadUI("ShowReading");
    }

    @FXML
    void btn3(ActionEvent event) {
        ShowReadingController.setBtn(3);
        LoadUI("ShowReading");
    }

    @FXML
    void btn4(ActionEvent event) {
        ShowReadingController.setBtn(4);
        LoadUI("ShowReading");
    }

    @FXML
    void btn5(ActionEvent event) {
        ShowReadingController.setBtn(5);
        LoadUI("ShowReading");
    }

    @FXML
    void btn6(ActionEvent event) {
        ShowReadingController.setBtn(6);
        LoadUI("ShowReading");
    }
    private void LoadUI(String ui){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        } catch (IOException e) {
            Logger.getLogger(ReadingController.class.getName()).log(Level.SEVERE, null, e);
        }
        installScene.setCenter(root);
    }

}
