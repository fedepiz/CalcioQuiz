package fedepiz.calcioquiz.model;

import java.util.List;

/**
 * Created by Federico on 14/7/15.
 */
public class GameData {
    private static List<Question> questions;


    public static List<Question> getQuestions() {
        return questions;
    }

    public static void setQuestions(List<Question> questions) {
        GameData.questions = questions;
    }
}
