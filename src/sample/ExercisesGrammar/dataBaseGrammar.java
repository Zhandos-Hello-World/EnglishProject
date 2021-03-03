package sample.ExercisesGrammar;

public class dataBaseGrammar {
    private String[][]e21 = {{"A: We don’t have any bread. B: I know. I", "some. I took some money from your purse."}, {"A: We don’t have any bread. B: Really? I", "some from the shop then."},
            {"A: Why do you need to borrow my suitcase? B: Because I", "my mother in Scotland next month."}, {"A: I’m really cold. B: I", "the heating on."}, {"A: What are your plans after you leave university? B: I", "in a hospital in Africa."},
            {"A: All the lights have gone off! B: Don't worry. I ", " a look."},{"A: Why are you carrying your laptop? B: I", "some homework on the train."}, {"A: I can't find my keys. B: I ", "you look for them."},
            {"A: Did you remember to buy the tickets? B: Oh no, I forgot! I", " them online now."},  {"If you take a look at this graphic, you can see that the economy","worse very soon."}};
    private String s21 = "Choose the correct forms of will and be going to to complete the sentences below.";

    private final static String[]app = {"➪ Use be going to for intentions or plans (the decision was made before speaking).","➪ Use will + infinitive (without to) for instant decisions. In this sentence, speaker B made his decision during the conversation.",
            "➪ Use be going to for intentions or plans (the decision was made before speaking).", "➪ Use will + infinitive (without to) for instant decisions. In this sentence, speaker B made his decision during the conversation.",
            "➪ Use be going to for intentions or plans (the decision was made before speaking).", "➪ Use will + infinitive (without to) for instant decisions. In this sentence, speaker B made his decision during the conversation.",
    "➪ Use be going to for intentions or plans (the decision was made before speaking).", "➪ Use will + infinitive (without to) for instant decisions. In this sentence, speaker B made his decision during the conversation.", "➪ Use will + infinitive (without to) for instant decisions. In this sentence, speaker B made his decision during the conversation.",
    "➪ Use be going to to talk about something that you see is going to happen (predictions based on present evidence)."};
    private static final String [][]choices = {{"going to bye", "'m going to buy", "'ll buy"}, {"'m going to get", "will to get", "'ll get"}, {"'m going to visit", "'ll visit", "going to visit"},
            {"going to turn", "'m going to turn", "'ll turn"}, {"going to work", "'ll work", "'m going to work"}, {"'ll take", "will to take", "'m going to take"},
            {"'m going to do", "will to do", "will do"}, {"will to help", "'ll help", "'m going to help"}, {"'ll buy", "'m going to buy", "will to buy"}, {"is going get", "is going to get", "will get"}};
    protected static String getChoice(int btn, int x){
        return choices[btn][x];
    }
    protected static String getApp(int x){
        return app[x];
    }
    protected static String[] getChoice(int btn){
        return choices[btn];
    }
    // since = 0; for = 1;
    public static int[]c21 = {1,2,0,2,2,0,0,1,0,1};
    public int[]getC21(){
        return c21;
    }
    public String[][]getE21(){
        return e21;
    }
    public String getS21(){ return s21; }
    protected String getE21(int i, byte j){
        return e21[i][j];
    }
}
