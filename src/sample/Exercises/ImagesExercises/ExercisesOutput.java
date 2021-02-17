package sample.Exercises.ImagesExercises;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import sample.ButtonsOfTheExercises;
import sample.GeneralController;
import sample.GrammarController;
import sample.dashboardController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ExercisesOutput extends dataBaseGrammar implements Initializable{
    private byte num;
    @FXML
    private Label pnlStatusName;
    @FXML
    private VBox Vbox;

    public void setNum(byte num) {
        this.num = num;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
