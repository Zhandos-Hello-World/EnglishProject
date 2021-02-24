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
    protected String getECAR21(int i){
        return ECAE11[i];
    }




    private String[][]e11 ={{"Luke: What", "? Sarah: I am watching TV."},  {"Luke:", "TV in the afternoon? Sarah: Yes, I do."},
            {"Luke: What kind of programs ", "?"} ,{"Sarah: I ", "talk shows."}, {" But now I ", " a sports show."},
            {"Peter: What ", "?"}, {"Rebecca: He", "an architect"}, {"but he", "at the moment."},{"He ", "for a job desperately,"}, {"because he", "money for the house."},
            {"Sandra: Can I have that magazine or you", "it?"}, {"Tim: No, I", " it"}, {"I", "that magazine. I sports magazines."}, {"I", "sports magazines."}, {"Sandra: I ", "sports magazines."}};
    protected String getE11(int i, byte a){
        return e11[i][a];
    }
    protected String[][] getE11(){
        return e11;
    }
    protected String getCC11(int index, int index2){
        return CC11[index][index2];
    }
    protected String[][]getCC11(){
        return CC11;
    }
    private String[][]CC11= {{"do you do", "you doing", "are you doing"}, {"Are you often watching", "Do you watch", "Are you often watch"},
            {"you watch", "are you watching", "do you watch"}, {"'m watching", "watch", "watching"}, {"watch", "'m watching", "are watch"},
    /*2*/   {"is Jonatan doing", "does Jonatan", "does Jonatan do"}, {"does", "is", "is being"}, {"does not work", "not works", "is not working"},
            {"is look", "is looking", "looks"}, {"is need", "needs", "is needing"},
    /*3*/   {"read", "reading", "are  reading"}, {"don't read", "'m not reading", "not reading"}, {"never read", "am never read", "am never reading"},
            {"'m preferring", "am prefer", "prefer"}, {"hating", "'m hating", "hate"}
            };
    protected int[] getC11(){
        return c11;
    }
    private String[]ECAR11 = {"➪ We use the present continuous to talk about things that are happening now.","➪ We use present simple for actions that we do (o we don’t do) regularly, often with adverbs or expressions of frequency (often).",
    "➪ We use present simple for actions that we do (o we don’t do) regularly. We use the verb do to make questions and negatives in present simple.", "➪ We use present simple for actions that we do (o we don’t do) regularly. In this sentence we mean 'watch normally'",
    "➪ We use the present continuous to talk about things that are happening now.", "➪ We use present simple for actions that we do (o we don’t do) regularly.The question what do you do? means 'what is your job?", "Be is a stative verb and non–action or stative verbs cannot be used in present continuous. You can see a list of these verbs in the 'Explanation' tab.",
    "➪ We use the present continuous to talk about things that are happening now or around now (at the moment).", "➪ We use the present continuous to talk about things that are happening now or around now (at the moment).", "➪ Need is a stative verb and non–action or stative verbs cannot be used in present continuous. You can see a list of these verbs in the 'Explanation' tab.",
    "➪ We use the present continuous to talk about things that are happening now.", "➪ We use the present continuous to talk about things that are happening now.", "➪ We use present simple for actions that we do (o we don’t do) regularly, often with adverbs or expressions of frequency (often).",
    "➪ Prefer is a stative verb and non–action or stative verbs cannot be used in present continuous. You can see a list of these verbs in the 'Explanation' tab.", "➪ Hate is a stative verb and non–action or stative verbs cannot be used in present continuous. You can see a list of these verbs in the 'Explanation' tab."};
    protected String getECAR11(int i){
        return ECAR11[i];
    }
    private int[]c11 = {2, 1, 2, 1, 1,  2, 1, 2, 1, 1,  2, 2, 0, 2, 2};














}
