package sample.ExerciseListening;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
public class ListeningShowController extends dataBaseListening implements Initializable {

    @FXML
    private MenuButton btn1;
    @FXML
    private MenuButton btn2;
    @FXML
    private MenuButton btn3;
    @FXML
    private MenuButton btn4;
    @FXML
    private MenuButton btn5;
    @FXML
    private MenuButton btn6;


    @FXML
    private Label text1;
    @FXML
    private Label text2;
    @FXML
    private Label text3;
    @FXML
    private Label text4;
    @FXML
    private Label text5;
    @FXML
    private Label text6;

    @FXML
    private Label booleanAnswer1;
    @FXML
    private Label booleanAnswer2;
    @FXML
    private Label booleanAnswer3;
    @FXML
    private Label booleanAnswer4;
    @FXML
    private Label booleanAnswer5;
    @FXML
    private Label booleanAnswer6;


    @FXML
    private Label Title;
    @FXML
    private Button CheckAnswer;

    private static int b;
    private static int[]election = {10, 10, 10, 10, 10, 10};

    private static void setElection(){
        Arrays.fill(election, 10);
    }

    public static void setBtn(int q){
        b = q;
    }

    @FXML
    private void play(ActionEvent event){

    }
    @FXML
    private void stop(ActionEvent event){
        System.out.print("stop");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Label []texts = {text1, text2, text3, text4, text5, text6};
        for(int i = 0; i < texts.length; i++){
            texts[i].setText(getQuestion(b)[i]);
        }
        Title.setText(getExplain(b));
        MenuItem[][]menuItems = new MenuItem[6][];
        MenuButton[] menuButtons = {btn1, btn2, btn3, btn4, btn5, btn6};
        ArrayList<MenuItem> temp = new ArrayList<>();
        for(int i = 0; i < menuItems.length; i ++){
            for(int j = 0; j < getAnswers(b, i).length; j++){
                MenuItem menuItem = new MenuItem();
                menuItem.setText(getAnswers(b, i, j));
                temp.add(j, menuItem);
            }
            menuItems[i] = new MenuItem[temp.size()];
            for(int j = 0; j < temp.size(); j ++){
                menuItems[i][j] = temp.get(j);
            }
            temp.clear();
        }
        for(int i = 0; i < menuButtons.length; i++) {
            menuButtons[i].getItems().clear();
            menuButtons[i].getItems().addAll(menuItems[i]);
        }
        for(int i = 0; i < menuItems.length; i++){
            for(int j = 0; j < menuItems[i].length; j++){
                int finalI = i;
                int finalJ = j;
                menuItems[i][j].setOnAction(event -> {
                    menuButtons[finalI].setText(menuItems[finalI][finalJ].getText());
                    election[finalI] = finalJ;
                });
            }
        }

        CheckAnswer.setOnAction(event -> {
            if(CheckAnswer.getText().equals("Check Answer")){
                Label[] labels = {booleanAnswer1, booleanAnswer2,booleanAnswer3,booleanAnswer4,booleanAnswer5,booleanAnswer6};
                int count = 0;
                for(int i = 0; i < election.length; i++){
                    labels[i].setFont(Font.font("Calibri Light", FontWeight.NORMAL, FontPosture.REGULAR, 30));
                    if(election[i] == 10){
                        labels[i].setText("No Answer");
                        labels[i].setTextFill(new Color(.67,0,.08, 1));
                    }else{
                        if(election[i] == getCorrectAnswer(b)[i]){
                            count++;
                            labels[i].setText("Correct");
                            labels[i].setTextFill(new Color(.27,.80,.09, 1));
                        }
                        else{
                            labels[i].setText("Incorrect");
                            labels[i].setTextFill(new Color(.67,0,.08, 1));
                        }
                    }
                }
                String statictics = "You have completed this test.\nCorrect answers: " + count + "/6.\nYour score is " + (int)(((double)(count) / 6.0) * 100 * 100) / 100 + "%\nCheck your answers:";
                Title.setText(statictics);
                Title.setFont(Font.font("Calibri Light", FontWeight.MEDIUM, FontPosture.REGULAR, 16));
                Title.setTextFill(new Color(.27,.80,.09, 1));
                setElection();
                count = 0;
                CheckAnswer.setText("Ok");
            }
        });

    }
}
