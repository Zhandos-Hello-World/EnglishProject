package sample.ExercisesGrammar;

public class dataBaseGrammar {
    private String[][]e21 = {{"A: We don’t have any bread. B: I know. I", "some. I took some money from your purse."}, {"A: We don’t have any bread. B: Really? I", "some from the shop then."},
            {"A: Why do you need to borrow my suitcase? B: Because I", "my mother in Scotland next month."}, {"A: I’m really cold. B: I", "the heating on."}, {"A: What are your plans after you leave university? B: I", "in a hospital in Africa."},
            {"A: All the lights have gone off! B: Don't worry. I ", " a look."},{"A: Why are you carrying your laptop? B: I", "some homework on the train."}, {"A: I can't find my keys. B: I ", "you look for them."},
            {"A: Did you remember to buy the tickets? B: Oh no, I forgot! I", " them online now."},  {"If you take a look at this graphic, you can see that the economy","worse very soon."}};
    private String[]ECAE11 = {"We use for + a period of time, e.g. for two weeks, for ten years, for ten days, for a few hours, etc.",
            "We use since + a moment in the past (the beginning of a period of time), e.g. since I was born, since 10 o’clock, since last Wednesday, etc."};
    private String s21 = "Choose for or since to complete the following present perfect sentences.";
    // since = 0; for = 1;
    public static int[]c21 = {1,0,0,1,0,1,0,1,1,0};
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
    protected String getECAR21(int i){
        return ECAE11[i];
    }
}
