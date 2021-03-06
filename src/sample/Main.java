package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
//u3[gCm  BaimuratZhandos.enbite
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Intro.fxml"));
        Scene scene = new Scene(fxml);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        loginController close = new loginController();
        close.setStage(primaryStage);
        primaryStage.setTitle("ENBITE");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
