package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dashboardController{

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
        LoadUI("Grammar");
    }

    @FXML
    void btnListening(ActionEvent event) {

    }

    @FXML
    void btnReading(ActionEvent event) {

    }

    @FXML
    void btnVocabulary(ActionEvent event) {

    }
    public void btnGrammarChoice(){
        LoadUI("");
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