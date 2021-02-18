package sample.Exercises.ImagesExercises;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import sample.GeneralController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExercisesOutput extends dataBaseGrammar implements Initializable{
    private byte num;
    @FXML
    private Label pnlStatusName;
    @FXML
    private VBox Vbox;
    @FXML
    private BorderPane mainBorder;

    public void setNum(byte num) {
        this.num = num;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void LoadUI(BorderPane mainBorder, boolean a){

        if(a){
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource( "ExercisesShow.fxml"));
            } catch (IOException e) {
                Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, e);
            }
            mainBorder.setCenter(root);
        }

    }
}
