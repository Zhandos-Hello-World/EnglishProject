package sample.ExercisesGrammar.Button1;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import sample.ExercisesGrammar.Button2.PresentPerfectSimpleController;
import sample.ExercisesGrammar.dataBaseGrammar;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

//I extends dataBaseGrammar for give data from dataBaseGrammar
public class PresentSimpleVsPresentContinuousController extends dataBaseGrammar implements Initializable {
    //I call id vBoxAdd for change scene when user in click button which is "1", "2", "3", "4" or "Check answer"
    @FXML
    private VBox vBoxAdd;
    //We need to save Texts, textFields or MenuButton in FlowPane which contains each vBoxAdd
    private FlowPane fp;
    //This button which check all choices
    private Button checkAnswer;
    //This BorderPane for change Scene
    @FXML
    private BorderPane InstallationScene;

    protected static int [] election = {3, 3, 3, 3, 3,  3, 3, 3, 3, 3,  3, 3, 3, 3, 3};


    //set texts from (super class)dataBaseGrammar
    protected void getC1(int n){
        fp = new FlowPane();
        fp.setPadding(new Insets(20, 20, 20, 20));
        fp.setVgap(20);
        fp.setHgap(20);
        //set texts which contains in the array.
        Label label1 = new Label(getE11(n, (byte)0));
        Label label2 = new Label(getE11(n, (byte)1));
        //give values for labels with class Font which contains in the javafx
        label1.setFont(Font.font("Calibri Light", FontWeight.BLACK, FontPosture.REGULAR, 25));
        label2.setFont(Font.font("Calibri Light", FontWeight.BLACK, FontPosture.REGULAR, 25));
        //This is for numbers in exercise
        //here We add numbers, labels, choices in the flowPane
        fp.getChildren().add(numbers(n + 1));
        fp.getChildren().add(label1);
        fp.getChildren().add(choice(n));
        fp.getChildren().add(label2);
    }
    //The method for show explanation exercises
    private StackPane tittle(){
        StackPane stackPanePane = new StackPane();
        Rectangle rectangle = new Rectangle();
        rectangle.setStroke(new Color(.81,.81,.81, 1));
        rectangle.setFill(new Color(.96,.96, .96, 1));
        rectangle.setWidth(670);
        rectangle.setHeight(80);
        rectangle.setArcHeight(43);
        stackPanePane.setPadding(new Insets(40,40,40,40));
        stackPanePane.getChildren().add(rectangle);
        //We give getS11 from dataBaseGrammar
        Label label = new Label(getS21());
        label.setFont(Font.font("Times New Roman", FontWeight.BLACK, FontPosture.REGULAR, 20));
        stackPanePane.getChildren().add(label);
        return stackPanePane;
    }

    private StackPane checkAnswer(){
        //This button which check all exercises.
        checkAnswer = new Button("Check answer");
        checkAnswer.setTextFill(new Color(1,1,1,1));
        checkAnswer.setStyle("-fx-background-color: green");
        checkAnswer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //New Scene which will be display correctAnswers
                LoadUI("PresentSimpleVsPresentContinuousShowAnswers");
            }
        });
        checkAnswer.setMinWidth(200);
        checkAnswer.setMinHeight(100);
        //the button of the checkAnswer contains in StackPane for set the vBoxAdd
        StackPane stackPane = new StackPane();
        stackPane.setMinHeight(100);
        stackPane.getChildren().add(checkAnswer);
        //I sent the stackPane in the initialize method
        return stackPane;
    }
    //The choice method through arg define index choices(array).
    private MenuButton choice(int i){
        //this method for MenuButton.
        MenuItem choice1 = new MenuItem(getCC11(i, 0));
        MenuItem choice2 = new MenuItem(getCC11(i, 1));
        MenuItem choice3 = new MenuItem(getCC11(i, 2));
        MenuButton menuButton = new MenuButton("      ", null, choice1, choice2, choice3);
        menuButton.setMinWidth(100);
        menuButton.setMinHeight(40);
        menuButton.setStyle("-fx-background-color: white; -fx-stroke: black; -fx-text-fill: black");
        choice1.setOnAction(event -> {
            election[i] = 0;
            menuButton.setText(choice1.getText());
        });
        choice2.setOnAction(event -> {
            election[i] = 1;
            menuButton.setText(choice2.getText());
        });
        choice3.setOnAction(event -> {
            election[i] = 2;
            menuButton.setText(choice3.getText());
        });
        return menuButton;
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
    //start
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vBoxAdd.getChildren().add(tittle());
        for(int i = 0; i < getE11().length; i++){
            //for set texts, menuButtons, numbers in flowPane.
            getC1(i);
            //add the flowPane in vBoxAdd
            vBoxAdd.getChildren().add(fp);
            //I did do so because I wanted free space under each appeared new vBoxAdd
            fp = null;
        }
        //Add button
        vBoxAdd.getChildren().add(checkAnswer());
    }

    private void LoadUI(String ui){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        } catch (IOException e) {
            Logger.getLogger(PresentPerfectSimpleController.class.getName()).log(Level.SEVERE, null, e);
        }
        InstallationScene.setCenter(root);
    }
}
