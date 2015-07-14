package fedepiz.calcioquiz.main;

import fedepiz.calcioquiz.R;
import fedepiz.calcioquiz.model.*;

import android.content.res.Resources;
import android.util.Log;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Federico on 14/7/15.
 */
public class Main {

    private Resources resources;

    public Main(Resources resources) {
        this.resources = resources;
    }


    public  void run() {
        try {
            Log.i("CalcioQuiz", "Main launched");
            List<Question> questionList = loadQuestions();
            if (questionList.size() > 0) {
            } else {
                Log.i("CalcioQuiz","No question parsed");
            }
        } catch (Exception ex) {
            Log.i("CalcioQuiz", "ERROR: " + ex.getMessage());
        }
        Log.i("CalcioQuiz","Application terminated successfully");
    }


    public List<Question> loadQuestions() throws QuestionParserException {
        Log.i("CalcioQuiz", "Main launched");
        InputStream ins = resources.openRawResource(R.raw.domande);
        QuestionParser parser = new QuestionParser();
        List<Question> questionList = parser.questionsFromXML(ins);
        return questionList;
    }
}
