package sample.ExercisesGrammar.Button2;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.io.IOException;
import java.net.ResponseCache;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

//This class for change Scene and show mistakes
public class PresentPerfectSimpleShowAnswer extends PresentPerfectSimpleController implements Initializable {
    //I create vBoxAddA for show all texts and mistakes etc.
    @FXML
    private VBox vBoxAddA;
    //I created for install another Scene when user click on buttons.
    @FXML
    private BorderPane InstallationScene;

    private FlowPane fp;


    // The statistics method show all correct answers
    private StackPane statistics(){
        FlowPane fp = new FlowPane();
        fp.setOrientation(Orientation.VERTICAL);
        System.out.println();
        int count = 0;
        for(int i = 0; i < election.length; i++){
            if(election[i] == c21[i]){
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
        fp.setMinHeight(120);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(fp);
        stackPane.setMinHeight(200);
        return stackPane;
    }
    @Override
    protected void getC1(int n){
        fp = new FlowPane();
        fp.setPadding(new Insets(20, 20, 20, 20));
        fp.setVgap(20);
        fp.setHgap(20);
        //set texts which contains in the array.
        Label label1 = new Label(getE21(n, (byte)0));
        Label label2 = new Label(getE21(n, (byte)1));
        //give values for labels with class Font which contains in the javafx
        label1.setFont(Font.font("Calibri Light", FontWeight.BLACK, FontPosture.REGULAR, 25));
        label2.setFont(Font.font("Calibri Light", FontWeight.BLACK, FontPosture.REGULAR, 25));
        //This is for numbers in exercise
        //here We add numbers, labels, choices in the flowPane
        fp.getChildren().add(numbers(n + 1));
        fp.getChildren().add(label1);
        fp.getChildren().add(choiced(n));
        fp.getChildren().add(label2);
        //Here need upload icons.

    }
    //this function explanation all exercises
    private StackPane announcement(int i){
        //I create StackPane for install Rectangle which will be blue and Text which will be explain all the exercises
        StackPane stackPane = new StackPane();
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(740);
        rectangle.setHeight(150);
        rectangle.setFill(new Color(.29,.54,.86, 1));
        Label label = new Label(getECAR11(getC21()[i]));
        label.setTextFill(new Color(1,1,1, 1));
        label.setFont(Font.font("Calibri Light", FontWeight.BLACK, FontPosture.REGULAR, 25));
        label.setWrapText(true);
        label.setPadding(new Insets(20, 20, 20, 20));
        stackPane.getChildren().add(rectangle);
        stackPane.getChildren().add(label);
        return stackPane;
    }

    protected StackPane choiced(int i){
        //this boolean for define correctly exercise and for change color text. Incorrect: Red Correct: Green
        boolean check = false;
        //this default value if user doesn't choice answer
        String showTextAnswer = "no answer";
        if(election[i] == getC21()[i]){
            if(election[i] == 0){
                //since = 0;
                showTextAnswer = "since";
            }
            else if(election[i] == 1){
                //for = 1;
                showTextAnswer = "for";
            }
            check = true;
        }
        if(election[i] == 0){
            showTextAnswer = "since";
        }
        else if(election[i] == 1){
            showTextAnswer = "for";
        }
        //Text need to convert in the Label
        Label showLabel = new Label(showTextAnswer);
        //color for incorrect and correct answers. Incorrect: red Correct: green
        showLabel.setStyle("-fx-text-fill: red");
        if(check){
            showLabel.setStyle("-fx-text-fill: green");
        }
        //I give value for label
        showLabel.setFont(Font.font("Calibri Light", FontWeight.BLACK, FontPosture.REGULAR, 25));
        Rectangle rectangle = new Rectangle();
        rectangle.setFill(new Color(1,1,1, 1));
        rectangle.setStroke(new Color(.74,.74,.74, 1));
        rectangle.setHeight(50);
        rectangle.setWidth(120);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(rectangle);
        stackPane.getChildren().add(showLabel);
        return stackPane;
    }
    // I want create icons. But I can't because I haven't knowlege
    private StackPane LoadUI(String ui){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        } catch (IOException e) {
            Logger.getLogger(PresentPerfectSimpleController.class.getName()).log(Level.SEVERE, null, e);
        }
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(root);
        return stackPane;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vBoxAddA.getChildren().add(statistics());
        for(int i = 0; i < getE21().length; i++){
            getC1(i);
            //for add Vbox
            vBoxAddA.getChildren().add(fp);
            //for free place
            fp = null;
            vBoxAddA.getChildren().add(announcement(i));
        }
        //for default values
        Arrays.fill(election, 2);
    }


}
