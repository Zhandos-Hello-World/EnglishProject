package sample.ExerciseListening;

public class dataBaseListening {
    private static final String[][]questions = {{"What did Marta do after leaving school?", "How did she find out about the apprenticeship?", "How many departments does she work in each year?", "Which department is she working in at the moment?", "How often does she attend lectures?", "How many apprentices attend her lectures?"},
            {"How long has Tom lived in Brighton?", "How long has he lived in his flat?", "What does he like about the city?", "What does he dislike about the city?", "How does he get around the city now?", "Which is his favourite place to eat out?"},
            {"Nicolas met Kevin at primary school.", "Nicolas and Kevin often went swimming together.", "Nicolas and Kevin were both good at their schoolwork at primary school.", "Neither Nicolas nor Kevin enjoyed playing sports.", "Kevin enjoyed going to the gym at secondary school, but Nicolas didn’t.", "Nicolas doesn’t see Kevin very often these days."},
            {"Who moved here to London over a year ago?", "Who moved to London after a relationship ended?", "Who has a relative in London?", "Who came to London because they were offered a good job?", "Who likes London’s international culture?", "Who finds London expensive?", "Who has experienced problems with crime in London", "Who came to London because they were offered a good job?", "Who likes London’s international culture?", "Who finds London expensive?", },
            {"The London eye ...", "You can't ... in the parks.", "What happened to the Millennium Bridge?","At St Paul's Cathedral, you can go up ...", "About the changing of the guard, they say that ...", "About Tower Bridge, they say that you can ..."},
            {"A 'cabbie' is a ...", "It is common to give a tip to taxi drivers.", "Cycling around London is ...", "Traditional red double-decker buses are the best option if ...", "The underground is the best option if ...", "There are lifts ..."}};
    private static final String[] explain = {"Listen to Marta talking about her apprenticeship. For questions 1 to 7, choose the correct answer.",
                                "Listen to Tom talking about living in Brighton. For questions 1 to 6, choose the correct answer.",
                                "Listen to Nicolas talking about his friends. For questions 1 to 10, choose true or false.",
                                "Kevin and Samantha moved to London recently. Listen to their experiences. For questions 1 to 7, choose the correct answer.",
                                "Listen to about the main tourist attractions in London. For questions 1 to 6, choose the correct answer.",
                                "Listen to  about transport s in London. For questions 1 to 7, choose the correct answer."};

    private static final String[][][]answers = {{{"She got a job.", "She went to university.", "She started her apprenticeship." }, {"from a friend", "from a university jobcentre","from a magazine"}, {"three", "four", "five"}, {"administration", "services", "environment"},{"one day a week", "two days a week", "three days a week"}, {"four", "twelve", "fifty"}},
            {{"1 years", "2 years", "3 years"}, {"1 years", "2 years", "3 years"},{"the sea", "the events", "the nightlife"},{"the crime", "the poor transport", "how dirty it is"}, {"bike and skateboard", "bus and skateboard", "skateboard and car"},  {"a restaurant in the city centre", "a café near his office", "a café by the sea"}},
            {{"True", "False"}, {"True", "False"}, {"True", "False"},{"True", "False"}, {"True", "False"},{"True", "False"},},
            {{"Kevin", "Samantha", "Both Kevin and Samantha", "Neither Kevin nor Samantha"},{"Kevin", "Samantha", "Both Kevin and Samantha", "Neither Kevin nor Samantha"}, {"Kevin", "Samantha", "Both Kevin and Samantha", "Neither Kevin nor Samantha"},{"Kevin", "Samantha", "Both Kevin and Samantha", "Neither Kevin nor Samantha"},{"Kevin", "Samantha", "Both Kevin and Samantha", "Neither Kevin nor Samantha"}, {"Kevin", "Samantha", "Both Kevin and Samantha", "Neither Kevin nor Samantha"}},
            {{"is 135 meters high.", "is more than 35 meters high.", "has 35 glass capsules."},{"run fast", "walk and relax", "cycle"},{"They had to close it because of the bad weather.", "There was a problem and was closed temporarily.", "There was an accident."},{"530 steps and see a view of London.", "513 steps and see the Gallery.", "513 steps and see a view of London."},{"it happens twice a day.", "it lasts thirty minutes.", "you should arrive early to see it."},{"cross Tower Bridge in 15 minutes.", "walk from one tower to the other of the bridge.", "see big boats crossing the bridge every 15 minutes."}},
            {{"taxi", "black taxi", "taxi driver"},{"True", "False"},{"not very healthy.", "not very safe.", "the best option."}, {"you want to see the city.", "you want to travel fast.", "you want to travel cheap."},{"you want to travel fast.", "you want to be relaxed.", "you need the cheapest option."},{"in all underground stations.", "in some underground stations.", "and they are faster than the stairs at busy times."}}
    };
    private static final int[][] correctAnswer = {{0, 2, 0, 2, 1, 1}, {2, 1, 1, 0, 1, 2}, {1, 1, 0, 0, 0, 0}, {0, 1, 1, 3, 2, 1}, {0, 2, 1, 0, 2, 1}, {2, 0, 1, 0, 0, 1}};

    protected static int[]getCorrectAnswer(int b){
        return correctAnswer[b];
    }

    protected static String[]getQuestion(int b){
        return questions[b];
    }
    protected static String getExplain(int b){
        return explain[b];
    }
    protected static String getAnswers(int b, int index1, int index2){
        return answers[b][index1][index2];
    }
    protected static String[]getAnswers(int b, int index1){
        return answers[b][index1];
    }
}
