package sample.Exercises.ImagesExercises;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import sample.dashboardController;

import java.net.URL;
import java.util.ResourceBundle;

public class ExercisesOutput implements Initializable{
    private byte num;
    @FXML
    private Label labelController;

    public void setNum(byte num){
        this.num = num;

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dashboardController d = new dashboardController();

    }
}
