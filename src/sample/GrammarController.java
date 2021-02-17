package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class GrammarController implements Initializable {

    @FXML
    private VBox VBoxExercises;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Node[] n = new Node[33];
        for(int i = 0; i < n.length; i++){
            try {
                n[i] = FXMLLoader.load(getClass().getResource("Exercises/ImagesExercises/Button" + i +".fxml"));
                VBoxExercises.getChildren().add(n[i]);
            }catch (Exception e) {
                System.out.print("HJello");
            }
        }
    }
}
