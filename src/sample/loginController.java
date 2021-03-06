package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class loginController implements Initializable{
    private static final String [][]arr = {{"Merim", "Ibraeva"},{"Kamila", "Khojabergenova"},{"Adilkhan", "Timuruly"}, {"Belgibayeva", "Zarina"}, {"Amangaliyev", "Daulet"}, {"Zhumagaliyev", "Alibi"}, {"Amantaev", "Madi"},
            {"Myrzagulov", "Nursultan"}, {"Baimurat", "Zhandos"}, {"Uali", "Abdimalik"}, {"Bastemi", "Madiyar"}, {"Tasbolat", "Zangar"}, {"Katekov", "Erkebulan"},
            {"Sarsenbay", "Rakhim"}, {"Nessipkulov", "Yrysbek"}, {"Serik", "Kaussar"}, {"Kurmanali", "Markiya"}, {"Nurlanbek", "Karlygash"}, {"Sanakuly", "Dauirbek"},
            {"Rakhmanberdi", "Yerkebulan"}, {"Sagalov", "Zhandos"}, {"Sagitzhanova", "Gulsezim"}, {"Naraly", "Zharkyn"}, {"Yergeshbayev", "Sherzod"}, {"Smetullayev", "Bakhtiyar"}};

    private static final String[][] logpasw = {{"IbraevaMerim.enbite", "R0Z/BT"}, {"KhojabergenovaKamila.enbite", ";4L!QT"},{"AdilkhanTimuruly.enbite", "Vx2{UJ"}, {"BelgibayevaZarina.enbite", "U9QNfK"}, {"AmangaliyevDaulet.enbite", "h;E7GT"}, {"ZhumagaliyevAlibi.enbite", "]MSd6R"}, {"AmantaevMadi.enbite", "A5`x=;"},
            {"MyrzagulovNursultan.enbite", "9G(kSL"}, {"BaimuratZhandos.enbite", "u3[gCm"}, {"UaliAbdimalik.enbite", "x^3#YE"}, {"BastemiMadiyar.enbite", "Rt;4`N"}, {"TasbolatZangar.enbite", "S=#a3)"}, {"KatekovErkebulan.enbite", "4/?Gkb"},
            {"SarsenbayRakhim.enbite", "7hnRau"}, {"NessipkulovYrysbek.enbite", ";8t!YU"}, {"SerikKaussar.enbite", "=7d=Hw"}, {"KurmanaliMarkiya.enbite", "6VN{zd"}, {"NurlanbekKarlygash.enbite", "5y'Nt-"}, {"SanakulyDauirbek.enbite", "xK4`z~"},
            {"RakhmanberdiYerkebulan.enbite", "fu6XWL"}, {"SagalovZhandos.enbite", "b[W5;>"}, {"SagitzhanovaGulsezim.enbite", "Kf2=$3"}, {"NaralyZharkyn.enbite", "mu2tKK"}, {"YergeshbayevSherzod.enbite", "jN7Trf"}, {"SmetullayevBakhtiyar.enbite", "Abc7bZ"}};
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


    public void loginButton() throws IOException {
        boolean check = false;
        for(int i = 0; i < logpasw.length; i++){
            if(usernameTextField.getText().equals(logpasw[i][0]) && enterPasswordField.getText().equals(logpasw[i][1])){
                check = true;
                try{
                    PrintWriter pw = new PrintWriter(new File("CurrentUser"));
                    pw.println(logpasw[i][0]);
                    pw.println(logpasw[i][1]);
                    pw.close();
                    ProgressController.setName(arr[i][1]);
                    ProgressController.setLastName(arr[i][0]);
                }
                catch (FileNotFoundException ex){
                    System.out.print(ex.getMessage());
                }
                break;
            }
        }


        if(check){
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            Scanner scanner = new Scanner(new File("CurrentUser"));
            while(scanner.hasNext()){
                usernameTextField.setText(scanner.nextLine());
                enterPasswordField.setText(scanner.nextLine());
            }
            scanner.close();

        }catch (FileNotFoundException ex){
            System.out.print("Welcome");
        }
    }
}
