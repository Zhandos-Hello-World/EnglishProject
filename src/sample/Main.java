package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Intro.fxml"));
        Scene scene = new Scene(fxml);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        loginController close = new loginController();
        close.setStage(primaryStage);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
