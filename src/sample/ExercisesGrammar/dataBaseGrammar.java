package sample.ExercisesGrammar;

public class dataBaseGrammar {
    private String[][]e21 = {{"I've had this car", "years."}, {"We've known each other", "we were in school."},
            {"I haven't eaten anything", "this morning."}, {"She hasn't slept", "two days."}, {"I have wanted to be a writer", "I was a child."},
            {"We've been together", "over ten years."},{"I haven't seen John", "last July."}, {"It hasn't rained", "a long time."},
            {"She's worked in this bank", "25 years."},  {"She's worked in this bank","it first opened."}};
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
    //This method need for subclass of the PresentPerfectSimpleShowAnswer.
    protected int getC21Index(int index){
        return c21[index];
    }
    

}
