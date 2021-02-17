package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

public class loginController {
    String []arr = {"Admin", "909588aass"};
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField enterPasswordField;
    @FXML
    private static Stage stage;


    public void loginButton(ActionEvent event) throws IOException {
        if(usernameTextField.getText().equals("") || enterPasswordField.getText().equals("")){
            loginMessageLabel.setText("Please enter username and password");
            // Временно
            Parent fxml = FXMLLoader.load(getClass().getResource("General.fxml"));
            Scene scene = new Scene(fxml);
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.show();
            closeStageLogin();
            ///////////////////////////
        }
        else if(usernameTextField.getText().equals(arr[0]) && enterPasswordField.getText().equals(arr[1])){
            Parent fxml = FXMLLoader.load(getClass().getResource("General.fxml"));
            Scene scene = new Scene(fxml);
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.show();
            closeStageLogin();
        }

        else
            loginMessageLabel.setText("Invalid Login or password. Please try again ");
        }
    public static void setStage(Stage stage1){
        stage = stage1;
    }
    public void closeStageLogin() {
        stage.close();
    }


    public void cancelButton(ActionEvent event) {
        Stage stage = (Stage)cancelButton.getScene().getWindow();
        stage.close();
    }

}
