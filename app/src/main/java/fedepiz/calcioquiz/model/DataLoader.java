package fedepiz.calcioquiz.model;

import android.content.res.Resources;
import android.util.Log;

import java.io.InputStream;
import java.util.List;

import fedepiz.calcioquiz.R;

/**
 * Created by Federico on 14/7/15.
 */
public class DataLoader {
    private Resources resources;

    public DataLoader(Resources resources){
        this.resources = resources;
    }

    public List<Question> loadQuestions() throws QuestionParserException {
        Log.i("CalcioQuiz", "Main launched");
        InputStream ins = resources.openRawResource(R.raw.domande);
        QuestionParser parser = new QuestionParser();
        List<Question> questionList = parser.questionsFromXML(ins);
        return questionList;
    }
}
