package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class ProgressController implements Initializable {
    private static String Sname;
    private static String SlastName;

    public static String getLastName() {
        return SlastName;
    }
    public static void setLastName(String SlastName) {
        ProgressController.SlastName = SlastName;
    }
    public static void setName(String Sname) {
        ProgressController.Sname = Sname;
    }
    public static String getSname() {
        return Sname;
    }

    private static final File[] files = {new File("G0"), new File("l0"), new File("R0"), new File("SaveProgress"), new File("YourMistakeWordSave"), new File("YourWordSave")};

    @FXML
    private Label name;

    @FXML
    private Label lastname;

    @FXML
    private Label percentGr;

    @FXML
    private Label percentRe;

    @FXML
    private Label percentLi;

    @FXML
    private Label percentVo;

    @FXML
    private ProgressBar percentVShow;

    @FXML
    private ProgressBar percentLShow;

    @FXML
    private ProgressBar percentGShow;

    @FXML
    private ProgressBar percentRShow;

    @FXML
    void actionReset(ActionEvent event) {
        try {
            PrintWriter pw = new PrintWriter(files[0]);
            pw.print(0);
            pw.close();

            pw = new PrintWriter(files[1]);
            for(int i = 0; i < 6; i++){
                pw.println(0);
            }
            pw.close();

            pw = new PrintWriter(files[2]);
            for(int i = 0; i < 6; i++){
                pw.println(0);
            }
            pw.close();

            pw = new PrintWriter(files[3]);
            for(int i = 0; i < 2; i++){
                pw.println(0);
            }
            pw.close();

            pw = new PrintWriter(files[4]);
            pw.print("");
            pw.close();

            pw = new PrintWriter(files[5]);
            pw.print("");
            pw.close();

            percentRShow.setProgress(0);
            percentGShow.setProgress(0);
            percentVShow.setProgress(0);
            percentLShow.setProgress(0);

            percentVo.setText(0 + "%");
            percentRe.setText(0 + "%");
            percentGr.setText(0 + "%");
            percentLi.setText(0 + "%");
        }
        catch (FileNotFoundException ex){
            System.out.print("Hello Reset Error");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setText(Sname);
        lastname.setText(SlastName);
        try{
            Scanner scanner = new Scanner(new File("SaveProgress"));
            int i = scanner.nextInt();
            int score = scanner.nextInt();
            percentVo.setText(score + "%");
            percentVShow.setProgress(score / 100.0);
        }catch (FileNotFoundException ex){
            System.out.print("Hello error");
        }
        try{
            Scanner scanner = new Scanner(new File("l0"));
            double[]arr = new double[6];
            int x = 0;
            while(scanner.hasNext()){
                arr[x] = (double)scanner.nextInt();
                x++;
            }
            scanner.close();
            double percent = 0;
            for(int i = 0; i < arr.length; i++){
                percent += arr[i];
            }
            percent /= 36.0;
            percentLShow.setProgress(percent);
            percent *= 100;
            percentLi.setText((int)percent + "%");

        }catch (FileNotFoundException ex){
            System.out.print("Hello error");
        }

        try{
            Scanner scanner = new Scanner(new File("R0"));
            double[]arr = new double[6];
            int x = 0;
            while(scanner.hasNext()){
                arr[x] = (double)scanner.nextInt();
                x++;
            }
            scanner.close();
            double percent = 0;
            for(int i = 0; i < arr.length; i++){
                percent += arr[i];
            }
            percent /= 36.0;
            percentRShow.setProgress(percent);
            percent *= 100;
            percentRe.setText((int)percent + "%");

        }catch (FileNotFoundException ex){
            System.out.print("Hello error");
        }
        try{
            Scanner scanner = new Scanner(new File("G0"));
            double percent = scanner.nextDouble();
            scanner.close();
            percent = (percent / 20.0);
            percentGShow.setProgress(percent);
            percent *= 100;
            percentGr.setText((int)percent + "%");
        }catch (FileNotFoundException ex){
            System.out.print("Hello error");
        }
    }
}
