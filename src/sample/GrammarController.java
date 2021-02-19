package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class GrammarController {
    @FXML
    private BorderPane grammarNewScene;
    @FXML
    public void ActionButtonPSPC(ActionEvent event){
        LoadUI("ExercisesGrammar/Button1/PresentSimpleVsPresentContinuous1");
    }
    @FXML
    public void ActionButtonPPS(ActionEvent event){
        LoadUI("ExercisesGrammar/Button2/PresentPerfectSimple1");
    }
    @FXML
    public void ActionButtonQ(ActionEvent event){
        LoadUI("ExercisesGrammar/Button3/Quantifiers1");
    }
    @FXML
    public void ActionButtonPP(ActionEvent event){
        LoadUI("ExercisesGrammar/Button4/PastProgressive1");
    }
    @FXML
    public void ActionButtonPastPS(ActionEvent event){
        LoadUI("ExercisesGrammar/Button5/PastPerfectSimple1");
    }
    @FXML
    public void ActionButtonFW(ActionEvent event){
        LoadUI("ExercisesGrammar/Button1/FutureWill1");
    }

    public void LoadUI(String ui){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        } catch (IOException e) {
            Logger.getLogger(GrammarController.class.getName()).log(Level.SEVERE, null, e);
        }
        grammarNewScene.setCenter(root);
    }
}
