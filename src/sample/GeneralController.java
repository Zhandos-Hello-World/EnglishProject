package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneralController implements Initializable {
        @FXML
        private Button dashboardButton;

        @FXML
        private Button myAccountButton;

        @FXML
        private Button settingsButton;

        @FXML
        private Button helpButton;

        @FXML
        private Button authorButton;
        @FXML
        private Label pnlStatusName;
        @FXML
        private BorderPane mainBorder;

        BorderPane getBr(){
            return this.mainBorder;
        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

        }
        @FXML
        void author(ActionEvent event) {
            LoadUI("AboutAuthor");
        }

        @FXML
        void dashboard(ActionEvent event) {
            LoadUI("Dashboard");
        }

        @FXML
        void help(ActionEvent event) {
            LoadUI("Help");

        }

        @FXML
        void myAccount(ActionEvent event) {
            LoadUI("MyAccount");
        }

        @FXML
        void settings(ActionEvent event) {
            LoadUI("Settings");
        }
        protected void LoadUI(String ui){
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
            } catch (IOException e) {
                Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, e);
            }
            mainBorder.setCenter(root);
        }
}

