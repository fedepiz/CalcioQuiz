package fedepiz.calcioquiz.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import fedepiz.calcioquiz.R;
import fedepiz.calcioquiz.model.Answer;
import fedepiz.calcioquiz.model.Question;
import fedepiz.calcioquiz.quiz.*;


public class QuizActivity extends ActionBarActivity {

    private Quiz quiz;
    private Question currentQuestion;

    private TextView txtQuestion;
    private TextView txtQuestionCount;
    private TextView txtScore;
    private List<Button> btnAnswers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        List<Question> questionList = (List<Question>)getIntent().getSerializableExtra("questions");
        this.quiz = new Quiz(questionList);
        this.txtQuestion = (TextView)findViewById(R.id.txtQuestion);
        this.txtScore = (TextView)findViewById(R.id.txtScore);
        this.txtQuestionCount = (TextView)findViewById(R.id.txtQuestionCount);
        this.btnAnswers = new ArrayList<>();
        btnAnswers.add((Button)findViewById(R.id.btnAnsw1));
        btnAnswers.add((Button)findViewById(R.id.btnAnsw2));
        btnAnswers.add((Button)findViewById(R.id.btnAnsw3));
        btnAnswers.add((Button) findViewById(R.id.btnAnsw4));


        refresh();
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

    private void refresh() {
        try {
            this.currentQuestion = quiz.getCurrentQuestion();
        }catch(QuizException ex) {
            //Do nothing
        }

        txtQuestion.setText(this.currentQuestion.getText());
        for(int i = 0; i < currentQuestion.getAnswerList().size();i++) {
            Answer a = currentQuestion.getAnswerList().get(i);
            btnAnswers.get(i).setText(a.getAnswerText());
        }
        String questionText = "Domanda " + quiz.getCurrentQuestionIndex() + "/" + quiz.getNumberOfQuestions();
        txtQuestionCount.setText(questionText);
        String scoreText = "Punteggio" + quiz.getScore() + "/" + quiz.getMaxPossibleScore();
        txtScore.setText(scoreText);
    }

    private void handleAnswer(int n) {
        int index = n - 1;
        Answer selectedAnswer = this.currentQuestion.getAnswerList().get(index);
        try {
            quiz.answerCurrentQuestion(selectedAnswer);
        }catch(QuizException ex) {

        }
        if(quiz.isEndOfQuiz()) {
            invokeResults();
        } else  {
            this.refresh();
        }
    }


    private void invokeResults() {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("score",this.quiz.getScore());
        intent.putExtra("max_score",this.quiz.getMaxPossibleScore());
        intent.putExtra("num_questions",this.quiz.getNumberOfQuestions());
        intent.putExtra("correct_answers",this.quiz.getCorrectAnswersCount());
        startActivity(intent);
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
