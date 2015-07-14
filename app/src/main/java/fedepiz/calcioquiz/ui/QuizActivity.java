package fedepiz.calcioquiz.ui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import fedepiz.calcioquiz.R;
import fedepiz.calcioquiz.model.Answer;
import fedepiz.calcioquiz.model.Question;
import fedepiz.calcioquiz.quiz.*;


public class QuizActivity extends ActionBarActivity {

    private Quiz quiz;
    private Question currentQuestion;

    private TextView txtQuestion;
    private List<Button> btnAnswers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        this.quiz = (Quiz)getIntent().getSerializableExtra("quiz");

        this.txtQuestion = (TextView)findViewById(R.id.txtQuestion);

        this.btnAnswers = new ArrayList<>();
        btnAnswers.add((Button)findViewById(R.id.btnAnsw1));
        btnAnswers.add((Button)findViewById(R.id.btnAnsw2));
        btnAnswers.add((Button)findViewById(R.id.btnAnsw3));
        btnAnswers.add((Button) findViewById(R.id.btnAnsw4));


        refreshQuiz();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //UI BackEnd

    private void refreshQuiz() {
        try {
            this.currentQuestion = quiz.getCurrentQuestion();
        }catch(Exception ex) {
            //Do nothing
        }

        txtQuestion.setText(this.currentQuestion.getText());
        for(int i = 0; i < currentQuestion.getAnswerList().size();i++) {
            Answer a = currentQuestion.getAnswerList().get(i);
            btnAnswers.get(i).setText(a.getAnswerText());
        }
    }

    private void handleAnswer(int n) {
        int index = n - 1;

    }

    //UI FRONTEND

    public void btnAnswerOnClick1(View view){
        handleAnswer(1);
    }

    public void btnAnswerOnClick2(View view){
        handleAnswer(2);
    }

    public void btnAnswerOnClick3(View view) {
        handleAnswer(3);
    }

    public void btnAnswerOnClick4(View view) {
        handleAnswer(4);
    }
}
