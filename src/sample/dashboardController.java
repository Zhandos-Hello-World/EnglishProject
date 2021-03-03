package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dashboardController {

    @FXML
    private Pane pnlStatus;

    @FXML
    private Label pnlStatusName;

    @FXML
    private Button btnReading;

    @FXML
    private Button btnVocabulary;

    @FXML
    private Button btnGrammar;

    @FXML
    private Button btnListening;
    @FXML
    private BorderPane OutputGLRV;

    @FXML
    void btnGrammar(ActionEvent event) {
        LoadUI("ExercisesGrammar/GrammarL");
        pnlStatus.setStyle("-fx-background-color: linear-gradient(to bottom right, green, deepskyblue);");
        pnlStatusName.setText("Grammar");
    }

    @FXML
    void btnListening(ActionEvent event) {
        LoadUI("ExerciseListening/Listening");
        pnlStatus.setStyle("-fx-background-color: linear-gradient(to bottom left, deepskyblue, #0048BAFF);");
        pnlStatusName.setText("Listening");
    }

    @FXML
    void btnReading(ActionEvent event) {
        LoadUI("ExerciseReading/Reading");
        pnlStatus.setStyle("-fx-background-color: linear-gradient(to bottom right, green, deepskyblue);");
        pnlStatusName.setText("Reading");
    }

    @FXML
    void btnVocabulary(ActionEvent event) {
        LoadUI("Vocabulary/Vocabulary");
        pnlStatus.setStyle("-fx-background-color: linear-gradient(to bottom right, green, deepskyblue);");
        pnlStatusName.setText("Vocabulary");
    }
    public void LoadUI(String ui){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        } catch (IOException e) {
            Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, e);
        }
        OutputGLRV.setCenter(root);
    }

}
