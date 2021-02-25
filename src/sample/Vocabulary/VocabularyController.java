package sample.Vocabulary;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import sample.GrammarController;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                if(check){
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
                            buttons[i].setStyle("-fx-background-color: #46AD04FF");
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
            buttons[i].setStyle("-fx-background-color: #0FC0FCFF");
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
                if(check){
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
                            buttons[i].setStyle("-fx-background-color: #46AD04FF");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        score = 0;
        scoreShow.setText("score: " + score);
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
        if(!choiceR){
            getActionRUEN();
            checkBtn.setOnAction(event -> {
                i += 1;
                word.setText(EnglishWords[i]);
                progressShow.setText(i + "/" + EnglishWords.length);
                getActionRUEN();
            });
        }
        else{
            getActionENRU();
            checkBtn.setOnAction(event -> {
                i += 1;
                word.setText(EnglishWords[i]);
                getActionENRU();
            });
        }
    }
    private void LoadUI(String ui){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        }catch (IOException ex){
            Logger.getLogger(GrammarController.class.getName()).log(Level.SEVERE, null, ex);
        }
        installScene.setRight(root);
    }
}
