package fedepiz.calcioquiz.data;

import android.content.res.Resources;
import android.util.Log;

import java.io.InputStream;
import java.util.List;

import fedepiz.calcioquiz.R;
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
        loadQuestions(resources);
    }

    private static void loadQuestions(Resources resources) throws QuestionParserException{
        Log.i("CalcioQuiz", "Main launched");
        InputStream ins = resources.openRawResource(R.raw.domande);
        QuestionParser parser = new QuestionParser();
        List<Question> questionList = parser.questionsFromXML(ins);
        setQuestions(questionList);
    }

}


