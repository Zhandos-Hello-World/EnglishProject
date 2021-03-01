package sample.ExerciseReading;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowReadingController extends ReadingController implements Initializable{
    private static final String STANDARD_BUTTON_STYLE = "-fx-background-color: #C40233FF;";
    private static final String HOVERED_BUTTON_STYLE  = "-fx-background-color: #ED1C24FF;";
    @FXML
    private VBox VboxAdd;
    @FXML
    private BorderPane installScene;
    private static int check = 1;
    private static int b = 0;
    private final static int[] height = {1200, 900, 800, 900, 1200, 800};
    private static int[] election;

    protected void setElection(){
        election = new int[getNumberOFAnswer(b - 1).length];
        for(int i = 0; i < election.length; i++){
            election[i] = 10;
        }
    }

    static void setBtn(int q){
        b = q;
    }
    private StackPane tittle(){
        StackPane stackPanePane = new StackPane();
        stackPanePane.setPadding(new Insets(40,40,40,40));
        //We give getS11 from dataBaseGrammar
        Label label = new Label("A2 Reading Test");
        label.setFont(Font.font("Calibri Light", FontWeight.BLACK, FontPosture.REGULAR, 40));
        stackPanePane.getChildren().add(label);
        return stackPanePane;
    }
    private StackPane explain(String explainT){
        StackPane stackPanePane = new StackPane();
        Rectangle rectangle = new Rectangle();
        rectangle.setStroke(new Color(.81,.81,.81, 1));
        rectangle.setFill(new Color(.96,.96, .96, 1));
        rectangle.setWidth(600);
        rectangle.setHeight(100);
        rectangle.setArcHeight(43);
        stackPanePane.getChildren().add(rectangle);
        //We give getS11 from dataBaseGrammar
        Label label = new Label(explainT);
        label.setFont(Font.font("Calibri Light", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
        label.setWrapText(true);
        label.setPadding(new Insets(0, 100, 0, 100));

        stackPanePane.getChildren().add(label);
        return stackPanePane;
    }
    private StackPane name(String name){
        StackPane stackPanePane = new StackPane();
        stackPanePane.setPadding(new Insets(10,40,40,100));
        //We give getS11 from dataBaseGrammar
        Label label = new Label(name);
        label.setTextFill(new Color(.31,.69,.19, 1));
        label.setFont(Font.font("Calibri Light", FontWeight.BLACK, FontPosture.REGULAR, 30));
        label.setWrapText(true);
        stackPanePane.getChildren().add(label);
        return stackPanePane;
    }
    private StackPane text(int height){
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(600);
        rectangle.setHeight(height);
        rectangle.setStroke(new Color(0,0,0,1));
        rectangle.setFill(new Color(1,1,1, 1));
        rectangle.setArcHeight(15);
        rectangle.setArcWidth(15);
        Label label = new Label(getTexts(b - 1));
        label.setFont(Font.font("Calibri Light", FontWeight.BLACK, FontPosture.REGULAR, 20));
        label.setTextFill(new Color(0,0,0,1));
        label.setWrapText(true);
        label.setPadding(new Insets(0, 100, 0, 100));
        StackPane s = new StackPane();
        s.getChildren().add(rectangle);
        s.getChildren().add(label);
        //maybe make shadow
        return s;
    }
    private FlowPane question(int index){
        // Write here
        Label question = new Label(getQuestion(b - 1, index));
        question.setPadding(new Insets(0, 0, 0, 0));
        question.setWrapText(true);
        question.setFont(Font.font("Calibri Light", FontWeight.BLACK, FontPosture.REGULAR, 19));

        MenuItem []menuItems = new MenuItem[getAnswerForQuestion(b - 1, index).length];
        for(int i = 0; i < getAnswerForQuestion(b - 1, 0).length; i++){
            menuItems[i] = new MenuItem();
            menuItems[i].setText(getAnswerForQuestion(b - 1, index)[i]);
        }

        //btn0 = 5 btn1, btn2, btn3 = 1, btn4 = 3, btn5 = 2;
        MenuButton menuButton = new MenuButton("   ", null, menuItems);

        //here choices
        menuItems[0].setOnAction(ActionEvent -> {
            menuButton.setText(menuItems[0].getText());
            election[index] = 0;
        });
        menuItems[1].setOnAction(ActionEvent -> {
            menuButton.setText(menuItems[1].getText());
            election[index] = 1;
        });
        if(b - 1 == 4){
            menuItems[2].setOnAction(ActionEvent -> {
                menuButton.setText(menuItems[2].getText());
                election[index] = 2;
            });
            menuItems[3].setOnAction(ActionEvent -> {
                menuButton.setText(menuItems[3].getText());
                election[index] = 3;
            });
        }
        else if(b - 1 == 5){
            menuItems[2].setOnAction(ActionEvent -> {
                menuButton.setText(menuItems[2].getText());
                election[index] = 2;
            });
        }
        else if(b - 1 == 0){
            menuItems[2].setOnAction(ActionEvent -> {
                menuButton.setText(menuItems[2].getText());
                election[index] = 2;
            });
            menuItems[3].setOnAction(ActionEvent -> {
                menuButton.setText(menuItems[3].getText());
                election[index] = 3;
            });
            menuItems[4].setOnAction(ActionEvent -> {
                menuButton.setText(menuItems[4].getText());
                election[index] = 4;
            });
            menuItems[5].setOnAction(ActionEvent -> {
                menuButton.setText(menuItems[5].getText());
                election[index] = 5;
            });
        }
        //here finished chooses
        FlowPane fp = new FlowPane();
        fp.setMinHeight(70);
        fp.getChildren().add(numbers(index+1));
        fp.getChildren().add(question);
        fp.getChildren().add(menuButton);
        return fp;
    }
    protected StackPane numbers(int i){
        //we create StackPane for circle
        StackPane stackPane = new StackPane();
        Circle circle = new Circle();
        circle.setRadius(24);
        circle.setFill(new Color(.31,.69,.19, 1));
        //this numbers when we give from arguments
        Label label = new Label("" + i);
        label.setFont(Font.font("Calibri Light", FontWeight.BLACK, FontPosture.REGULAR, 20));
        label.setTextFill(new Color(1,1,1,1));
        stackPane.getChildren().add(circle);
        stackPane.getChildren().add(label);
        return stackPane;
    }

    private StackPane checkAnswer(){
        Button button = new Button("Check Answer");
        button.setFont(Font.font("Calibri Light", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        button.setTextFill(new Color(1,1,1,1));
        changeBackgroundOnHoverUsingEvents(button);
        button.setOnAction(event -> {
            if(Check() == 2 || button.getText().equals("Check Answer")){
                FlowPane fp = new FlowPane();
                fp.setOrientation(Orientation.VERTICAL);
                double count = 0;
                for(int i = 0; i < election.length; i++){
                    if(election[i] == getNumberOFAnswer(b - 1)[i]){
                        count++;
                    }
                }
                count = (count / (double)election.length) * 10;
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
                VboxAdd.getChildren().add(stackPane);


                for(int i = 0; i < getQuestion(b - 1).length; i++){
                    Label question = new Label(getQuestion(b - 1, i));
                    question.setPadding(new Insets(0, 0, 0, 0));
                    question.setWrapText(true);
                    question.setFont(Font.font("Calibri Light", FontWeight.BLACK, FontPosture.REGULAR, 19));

                    Label userAnswer = null;
                    if(election[i] == 10){
                        userAnswer = new Label("No answer");
                        userAnswer.setTextFill(new Color(.53,0,.07, 1));
                    }
                    else{
                        userAnswer = new Label(getAnswerForQuestion(b - 1, i)[election[i]]);
                        if(election[i] == getNumberOFAnswer(b - 1)[i]){
                            userAnswer.setTextFill(new Color(.31,.69,.19, 1));
                        }
                        else{
                            userAnswer.setTextFill(new Color(.53,0,.07, 1));
                        }
                    }

                    FlowPane flowPane = new FlowPane();
                    flowPane.getChildren().add(question);
                    flowPane.getChildren().add(userAnswer);
                    VboxAdd.getChildren().add(flowPane);
                }
                VboxAdd.getChildren().remove(button);
                button.setText("Ok");
                setElection();
            }
            });



        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);
        stackPane.setMinHeight(120);
        return stackPane;
    }
    private int Check(){
        if(check == 2){
            check = 0;
        }
        if(check == 1){
            check = 2;
        }
        return check;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setElection();
        VboxAdd.getChildren().add(tittle());
        VboxAdd.getChildren().add(explain(getExplain(b - 1)));
        VboxAdd.getChildren().add(name(getNameTexts(b - 1)));
        VboxAdd.getChildren().add(text(height[b - 1]));
        for(int i = 0; i < getQuestion(b - 1).length; i++){
            VboxAdd.getChildren().add(question(i));
        }
        VboxAdd.getChildren().add(checkAnswer());
    }


    private void changeBackgroundOnHoverUsingBinding(Node node) {
        node.styleProperty().bind(
                Bindings.when(node.hoverProperty())
                        .then(
                                new SimpleStringProperty(HOVERED_BUTTON_STYLE)
                        )
                        .otherwise(
                                new SimpleStringProperty(STANDARD_BUTTON_STYLE)
                        )
        );
    }

    public void changeBackgroundOnHoverUsingEvents(final Node node) {
        node.setStyle(STANDARD_BUTTON_STYLE);
        node.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                node.setStyle(HOVERED_BUTTON_STYLE);
            }
        });
        node.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                node.setStyle(STANDARD_BUTTON_STYLE);
            }
        });
    }

}
