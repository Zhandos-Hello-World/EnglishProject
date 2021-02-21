package sample.ExercisesGrammar.Button2;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.awt.desktop.SystemSleepEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


//This class for change Scene and show mistakes
public class PresentPerfectSimpleShowAnswer extends PresentPerfectSimpleController implements Initializable {
    //I create vBoxAddA for show all texts and mistakes etc.
    @FXML
    private VBox vBoxAddA;
    //I created for install another Scene when user click on buttons.
    @FXML
    private BorderPane InstallationScene;


    // The statistics method show all correct answers
    public FlowPane statistics(){
        FlowPane fp = new FlowPane();
        fp.setOrientation(Orientation.VERTICAL);
        System.out.println();
        int count = 0;
        int []arr = getElection();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == c21[i]){
                count++;
            }
        }
        //This texts for show statistics
        Label[]labels = {new Label("You have completed this test."),
                new Label("Correct answers: " + count + "/10"), new Label("Your score is " + (int)(count * 10) +"%."),
                new Label("Check your answers:")};
        //I need set value each labels
        for(byte i = 0; i < labels.length; i++){
            labels[i].setFont(Font.font("Calibri Light", FontWeight.BLACK, FontPosture.REGULAR, 30));
            labels[i].setTextFill(new Color(.31,.69,.19, 1));
        }
        //I need set each labels in the flowPane;
        for(byte i = 0; i < labels.length; i++){
            fp.getChildren().add(labels[i]);
        }
        fp.setPadding(new Insets(30, 30, 20, 20));
        return fp;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        vBoxAddA.getChildren().add(statistics());
    }


}
