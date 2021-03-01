package sample.Vocabulary;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;
public class VocabularyController implements Initializable {
    private static final String[] EnglishWords = {"activity", "already", "amount", "annoy", "appear", "atom", "author", "biography", "blind", "brain",
            "cancel", "cartoon", "cathy", "character", "cinema", "circle", "circus", "common", "complain", "compose",
            "composer", "concert", "congratulate", "correct", "daily routine", "dictionary", "dramatic", "dream", "drummer", "enormous",
            "environment", "event", "excited", "exotic", "expensive", "fall asleep", "famous", "farmhouse", "field", "find out",
            "government", "guess", "horror", "human", "important", "improve", "inspiration", "intrigued", "invent", "investigate",
            "jealous", "jewellery", "laboratory", "laughter", "literature", "lucky", "masterpiece", "medicine", "melody", "memory",
            "mention", "message", "messy", "mistake", "moon", "mountain", "mysterious", "mystery", "nightmare", "novel",
            "oil", "payment", "piano", "poem", "poetry", "publish", "realize", "refuse", "revise", "scientific",
            "scientist", "sentimental", "sheep", "solve", "step", "story", "stranger", "success", "thought", "tidy up",
            "travel", "unforgettable", "violin", "vocabulary", "wander", "weather forecast", "weird", "wheel", "win", "writer"};
    private static final String[] RussianWords = {"Деятельность", "уже", "количество", "раздражать", "появляться", "атом", "автор", "биография", "слепой", "мозг",
            "Отменить", "мультфильм", "броский", "персонаж", "кинотеатр", "круг", "цирк", "обычный", "жаловаться", "сочинять",
            "композитор", "концерт", "поздравлять", "исправлять", "распорядок дня", "Словарь", "Драматический", "мечта", "барабанщик", "огромный",
            "Окружающая среда", "событие", "взволнованный", "экзотический", "дорогой", "заснуть", "известный", "фермерский дом", "поле", "выяснить",
            "правительство", "Догадка", "ужас", "человек", "важный", "улучшать", "вдохновение", "заинтригованный", "изобретать", "исследовать",
            "завистливый", "драгоценности", "лаборатория", "смех", "литература", "счастливый", "шедевр", "лекарство", "мелодия", "Память",
            "упоминать", "сообщение", "неряшливый", "ошибка", "Луна", "гора", "загадочный", "загадка", "кошмар", "роман",
            "масло", "оплата", "пианино", "стихотворение", "поэзия", "публиковать", "осознавать", "отказывать", "пересматривать", "научный",
            "ученый", "чувствительный", "овца", "решить", "шаг", "история", "незнакомец", "успех", "мысль", "убирать",
            "путешествовать", "незабываемый", "скрипка", "словарный запас", "бродить", "прогноз погоды", "странный", "рулевое колесо", "выигрывать", "писатель"};

    private static int i = 0;
    private static int []choicesRandom = {101, 101, 101, 101, 101, 101};
    private static int []choicesRandomR = {101, 101, 101, 101, 101, 101};
    private static boolean choiceR = false;
    private static byte []correctAnswerData = new byte[EnglishWords.length];
    private static int score = 0;

    //true for en, false for ru.
    private static boolean EnRu = true;
    private static File filepath;
    private static final String[]dataLocationSave = {"C:\\Users\\Zhandos\\Documents\\GitHub\\EnglishProject\\src\\sample\\Vocabulary\\Progress\\SaveProgress",
            "C:\\Users\\Zhandos\\Documents\\GitHub\\EnglishProject\\src\\sample\\Vocabulary\\Progress\\YourMistakeWordSave",
            "C:\\Users\\Zhandos\\Documents\\GitHub\\EnglishProject\\src\\sample\\Vocabulary\\Progress\\YourWordSave"};

    private static void setCorrectAnswerData(){
        Arrays.fill(correctAnswerData, (byte)2);
    }

    @FXML
    private BorderPane installScene;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Label progressShow;

    @FXML
    private Label scoreShow;

    @FXML
    private Button checkBtn;

    @FXML
    private Label word;

    @FXML
    private Label Error;

    @FXML
    private Button getActionRUENEvent;


    void getActionRUEN(){
        // I create an array which contains all buttons for FXML
        Button[] buttons = {btn1, btn2, btn3, btn4, btn5, btn6};
        //default color
        for(int i = 0; i < buttons.length; i++){
            buttons[i].setStyle("-fx-background-color: #0FC0FCFF");
        }
        //This text will be show text which need translate
        word.setText(RussianWords[i]);
        //I create bntChoice for change place between buttons correct answer
        int btnChoice = (int)(Math.random() * buttons.length + 0);
        //install correct answer one of buttons
        buttons[btnChoice].setText(EnglishWords[i]);
        // I create while for install random incorrect answers.
        int x = 0;
        while(x < buttons.length){
            //it shouldn't equals in the button of the correct answer because it condition for incorrect answers.
            if(x != btnChoice){
                //I create boolean because if incorrect answer equals previous incorrect answer, then check = false.
                boolean check = true;
                //random  incorrect answer translate in 5 buttons.
                int btnAnotherChoice = (int)(Math.random() * EnglishWords.length + 0);
                for(int j = 0; j < choicesRandomR.length; j++){
                    if(btnAnotherChoice == choicesRandomR[j]){
                        // there was such an answer and we write check = false which block x for correct define.
                        check = false;
                        break;
                    }
                }
                if(check && btnAnotherChoice != btnChoice){
                    choicesRandomR[x] = btnAnotherChoice;
                    x++;
                }
            }
            else{
                choicesRandomR[x] = btnChoice;
                x++;
            }
        }

        //There install answers in the button
        for(int q = 0; q < buttons.length; q++){
            if(choicesRandomR[q] != btnChoice){
                buttons[q].setText(EnglishWords[choicesRandomR[q]]);
                int finalQ = q;
                buttons[q].setOnAction(event -> {
                    saveMistake();
                    correctAnswerData[i] = 0;
                    for(int i = 0; i < buttons.length; i++){
                        if(buttons[i] != buttons[finalQ] && buttons[i] != buttons[btnChoice]){
                            //set incorrect answer
                            buttons[i].setStyle("-fx-background-color: #F81200FF");
                        }
                        else if(buttons[i] == buttons[finalQ]){
                            buttons[i].setStyle("-fx-background-color: #F76807FF");
                        }
                        else if(buttons[i] == buttons[btnChoice]){
                            buttons[i].setStyle("-fx-background-color: linear-gradient(#46AD04FF, #00BE00FF)");
                        }
                    }
                });
            }
            else{
                correctAnswerData[i] = 1;
                int finalQ = q;
                buttons[q].setOnAction(event -> {
                    score++;
                    scoreShow.setText("score: " + score);
                    buttons[btnChoice].setStyle("-fx-background-color: #46AD04FF");
                    for(int i = 0; i < buttons.length; i++) {
                        if(buttons[i] != buttons[btnChoice]){
                            buttons[i].setStyle("-fx-background-color: #F81200FF");
                        }
                    }
                });
            }
        }
    }
    void getActionENRU(){
        // I create an array which contains all buttons for FXML
        Button[] buttons = {btn1, btn2, btn3, btn4, btn5, btn6};
        //default color
        for(int i = 0; i < buttons.length; i++){
            buttons[i].setStyle("-fx-background-color: linear-gradient(to bottom left, #0FC0FCFF, #1A9AC4FF)");
        }
        //This text will be show text which need translate
        word.setText(EnglishWords[i]);
        //I create bntChoice for change place between buttons correct answer
        int btnChoice = (int)(Math.random() * buttons.length + 0);
        //install correct answer one of buttons
        buttons[btnChoice].setText(RussianWords[i]);
        // I create while for install random incorrect answers.
        int x = 0;
        while(x < buttons.length){
            //it shouldn't equals in the button of the correct answer because it condition for incorrect answers.
            if(x != btnChoice){
                //I create boolean because if incorrect answer equals previous incorrect answer, then check = false.
                boolean check = true;
                //random  incorrect answer translate in 5 buttons.
                int btnAnotherChoice = (int)(Math.random() * RussianWords.length + 0);
                for(int j = 0; j < choicesRandom.length; j++){
                    if(btnAnotherChoice == choicesRandom[j]){
                        // there was such an answer and we write check = false which block x for correct define.
                        check = false;
                        break;
                    }
                }
                if(check && btnAnotherChoice != btnChoice){
                    choicesRandom[x] = btnAnotherChoice;
                    x++;
                }
            }
            else{
                choicesRandom[x] = btnChoice;
                x++;
            }
        }

        //There install answers in the button
        for(int q = 0; q < buttons.length; q++){
            if(choicesRandom[q] != btnChoice){
                buttons[q].setText(RussianWords[choicesRandom[q]]);
                int finalQ = q;
                buttons[q].setOnAction(event -> {
                    saveMistake();
                    correctAnswerData[i] = 0;
                    for(int i = 0; i < buttons.length; i++){
                        if(buttons[i] != buttons[finalQ] && buttons[i] != buttons[btnChoice]){
                            //set incorrect answer
                            buttons[i].setStyle("-fx-background-color: #F81200FF");
                        }
                        else if(buttons[i] == buttons[finalQ]){
                            buttons[i].setStyle("-fx-background-color: #F76807FF");
                        }//#46AD04FF
                        else if(buttons[i] == buttons[btnChoice]){
                            buttons[i].setStyle("-fx-background-color: linear-gradient(to bottom left, #46AD04FF, #00BE00FF)");
                        }
                    }
                });
            }
            else{
                int finalQ = q;
                correctAnswerData[i] = 1;
                buttons[q].setOnAction(event -> {
                    score++;
                    scoreShow.setText("score: " + score);
                    buttons[btnChoice].setStyle("-fx-background-color: linear-gradient(to bottom left, #46AD04FF, #00BE00FF)");
                    for(int i = 0; i < buttons.length; i++) {
                        if(buttons[i] != buttons[btnChoice]){
                            buttons[i].setStyle("-fx-background-color: #F81200FF");
                        }
                    }
                });
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File(dataLocationSave[0]);
        try{
            Scanner scanner = new Scanner(file);
            i = scanner.nextInt();
            score = scanner.nextInt();
            scanner.close();
        }catch (FileNotFoundException ex){
            i = 0;
            score = 0;
        }
        scoreShow.setText("score: " + score);
        progressShow.setText(i + "/" + EnglishWords.length);
        checkBtn.setStyle("-fx-background-color: linear-gradient(to bottom left, lightgreen, limegreen); -fx-arc-width: 20; -fx-arc-height: 20" );
        // maybe I connect mysql
        setCorrectAnswerData();
        getActionRUENEvent.setOnAction(event -> {
            if(choiceR){
                choiceR = false;
                getActionRUEN();
            }
            else{
                choiceR = true;
                getActionENRU();
            }
        });
        if(choiceR){
            getActionRUEN();
            checkBtn.setOnAction(event -> {
                i += 1;
                if(i == 100){
                    i = 0;
                }
                word.setText(EnglishWords[i]);
                progressShow.setText(i + "/" + EnglishWords.length);
                getActionRUEN();
            });
        }
        else{
            getActionENRU();
            checkBtn.setOnAction(event -> {
                i += 1;
                if(i == 100){
                    i = 0;
                }
                progressShow.setText(i + "/" + EnglishWords.length);
                word.setText(RussianWords[i]);
                getActionENRU();
            });
        }
    }
    @FXML
    private void saveWordAction(){
        String filePath = dataLocationSave[2];
        String text = EnglishWords[i] + ":" + RussianWords[i] + "\n";
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(text);
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
    @FXML
    private void opeSaveWordsAction(){
        Stage stage = new Stage();
        File file = new File(dataLocationSave[2]);
        try{
            Scanner scanner = new Scanner(file);
            String s = "";
            while(scanner.hasNext()){
                s = s.concat(scanner.nextLine() + "\n");
            }
            scanner.close();
            Label label = new Label(s);
            Scene scene = new Scene(new StackPane(label));
            stage.setScene(scene);
            stage.show();

        }
        catch (FileNotFoundException ex){
            System.out.print(ex.getMessage());
        }
    }
    @FXML
    private void reset(){
        File []filepath = {new File(dataLocationSave[0]), new File(dataLocationSave[1]), new File(dataLocationSave[2])};
        try{
            PrintWriter pw = new PrintWriter(filepath[0]);
            pw.println(0);
            pw.println(0);
            pw.close();

            pw = new PrintWriter(filepath[1]);
            pw.print("");
            pw.close();

            pw = new PrintWriter(filepath[2]);
            pw.print("");
            pw.close();

            score = 0;
            i = 0;
            progressShow.setText(i + "/" + EnglishWords.length);
            scoreShow.setText("score: " + score);
            getActionENRU();
        }
        catch (FileNotFoundException ex){
            System.out.print(ex.getMessage());
        }
    }



    private void saveMistake(){
        String filePath = dataLocationSave[1];
        String text = EnglishWords[i] + ":" + RussianWords[i] + "\n";
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(text);
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void yourMistakesAction(){
        Stage stage = new Stage();
        File file = new File(dataLocationSave[1]);
        try{
            Scanner scanner = new Scanner(file);
            String s = "";
            while(scanner.hasNext()){
                s = s.concat(scanner.nextLine() + "\n");
            }
            scanner.close();
            Label label = new Label(s);
            Scene scene = new Scene(new StackPane(label));
            stage.setScene(scene);
            stage.show();

        }
        catch (FileNotFoundException ex){
            System.out.print(ex.getMessage());
        }
    }
    @FXML
    private void SaveProgressAction() {
        String filePath = dataLocationSave[0];
        File file = new File(filePath);
        String text = i + "\n" + score;
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.println(text);
            pw.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

