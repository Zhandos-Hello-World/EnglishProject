package sample.ExerciseListening;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ListeningController {
    @FXML
    private BorderPane installScene;


    @FXML
    void btn1(ActionEvent event){
        LoadUI();
        ListeningShowController.setBtn(0);
    }
    @FXML
    void btn2(ActionEvent event){
        LoadUI();
        ListeningShowController.setBtn(1);
    }
    @FXML
    void btn3(ActionEvent event){
        LoadUI();
        ListeningShowController.setBtn(2);
    }
    @FXML
    void btn4(ActionEvent event){
        LoadUI();
        ListeningShowController.setBtn(3);
    }
    @FXML
    void btn5(ActionEvent event){
        LoadUI();
        ListeningShowController.setBtn(4);
    }
    @FXML
    void btn6(ActionEvent event){
        LoadUI();
        ListeningShowController.setBtn(5);
    }
    private void LoadUI(){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("ListeningShow.fxml"));
        }
        catch (IOException ex){
            Logger.getLogger(ListeningController.class.getName()).log(Level.SEVERE, null, ex);
        }
        installScene.setCenter(root);
    }
}
