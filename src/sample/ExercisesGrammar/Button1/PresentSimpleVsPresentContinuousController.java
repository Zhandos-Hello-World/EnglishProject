package sample.ExercisesGrammar.Button1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import sample.ExercisesGrammar.dataBaseGrammar;

import java.net.URL;
import java.util.ResourceBundle;

public class PresentSimpleVsPresentContinuousController extends dataBaseGrammar implements Initializable {
    @FXML
    private VBox vBoxAdd;
    private FlowPane fp;
    private byte []choices = {2,2,2,2,2,2,2,2,2,2};
    private Button checkAnswer;

    private void getC1(int n){
        fp = new FlowPane();
        fp.setPadding(new Insets(20, 20, 20, 20));
        fp.setVgap(20);
        fp.setHgap(20);
        String[][]temp = getE11();
        Label label1 = new Label(temp[n][0]);
        label1.setFont(Font.font("Calibri Light", FontWeight.BLACK, FontPosture.REGULAR, 25));
        Label label2 = new Label(temp[n][1]);
        label2.setFont(Font.font("Calibri Light", FontWeight.BLACK, FontPosture.REGULAR, 25));
        fp.getChildren().add(numbers(n + 1));
        fp.getChildren().add(label1);
        fp.getChildren().add(choice(n));
        fp.getChildren().add(label2);
    }
    private StackPane tittle(){
        StackPane stackPanePane = new StackPane();
        Rectangle rectangle = new Rectangle();
        rectangle.setStroke(new Color(.81,.81,.81, 1));
        rectangle.setFill(new Color(.96,.96, .96, 1));
        rectangle.setWidth(670);
        rectangle.setHeight(80);
        rectangle.setArcHeight(13);
        stackPanePane.setPadding(new Insets(40,40,40,40));
        stackPanePane.getChildren().add(rectangle);
        Label label = new Label(getS11());
        label.setFont(Font.font("Times New Roman", FontWeight.BLACK, FontPosture.REGULAR, 20));
        stackPanePane.getChildren().add(label);
        return stackPanePane;
    }
    private StackPane checkAnswer(){
        checkAnswer = new Button("Check answer");
        checkAnswer.setStyle("-fx-background-color: green");
        checkAnswer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for(byte i = 0; i < choices.length; i++){
                    if(choices[i] != getC11()[i]){
                        System.out.println((byte)(i + 1) + "false");
                    }
                    else{
                        System.out.println((byte)(i + 1) + "true");
                    }
                }
            }
        });
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(checkAnswer);
        return stackPane;
    }
    private MenuButton choice(int i){
        MenuItem choice1 = new MenuItem("since");
        MenuItem choice2 = new MenuItem("for");
        MenuButton menuButton = new MenuButton("   ", null, choice1, choice2);
        choice1.setOnAction(event -> {
            choices[i] = 0;
            menuButton.setText(choice1.getText());
        });
        choice2.setOnAction(event -> {
            choices[i] = 1;
            menuButton.setText(choice2.getText());
        });
        return menuButton;
    }
    private StackPane numbers(int i){
        StackPane stackPane = new StackPane();
        Circle circle = new Circle();
        circle.setRadius(24);
        circle.setFill(new Color(.31,.69,.19, 1));
        Label label = new Label("" + i);
        label.setFont(Font.font("Calibri Light", FontWeight.BLACK, FontPosture.REGULAR, 20));
        label.setTextFill(new Color(1,1,1,1));
        stackPane.getChildren().add(circle);
        stackPane.getChildren().add(label);
        return stackPane;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vBoxAdd.getChildren().add(tittle());
        for(int i = 0; i < getE11().length; i++){
            getC1(i);
            vBoxAdd.getChildren().add(fp);
            fp = null;
        }
        vBoxAdd.getChildren().add(checkAnswer());
    }
}
