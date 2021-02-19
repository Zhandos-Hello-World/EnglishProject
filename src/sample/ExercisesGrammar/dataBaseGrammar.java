package sample.ExercisesGrammar;

public class dataBaseGrammar {
    private String[][]e11 = {{"I've had this car", "years."}, {"We've known each other", "we were in school."},
            {"I haven't eaten anything", "this morning."}, {"She hasn't slept", "two days."}, {"I have wanted to be a writer", "I was a child."},
            {"We've been together", "over ten years."},{"I haven't seen John", "last July."}, {"It hasn't rained", "a long time."},
            {"She's worked in this bank", "25 years."},  {"She's worked in this bank","it first opened."}};
    private String s11 = "Choose for or since to complete the following present perfect sentences.";
    // since = 0; for = 1;
    private byte[]c11 = {1,0,0,1,0,1,0,1,1,0};
    public byte[]getC11(){
        return c11;
    }
    public String[][]getE11(){
        return e11;
    }
    public String getS11(){
        return s11;
    }


}
