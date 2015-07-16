package fedepiz.calcioquiz.data;

import android.content.res.Resources;

import java.util.List;

import fedepiz.calcioquiz.model.Question;
import fedepiz.calcioquiz.model.QuestionParser;
import fedepiz.calcioquiz.model.QuestionParserException;

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

    public static void loadGameData(Resources resources) throws Exception {
        DataLoader dataLoader = new DataLoader(resources);
        GameData.setQuestions(dataLoader.loadQuestions());
    }
}
