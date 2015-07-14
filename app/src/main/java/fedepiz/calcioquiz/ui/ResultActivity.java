package fedepiz.calcioquiz.ui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import fedepiz.calcioquiz.R;

public class ResultActivity extends ActionBarActivity {
    private TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        this.txtResult = (TextView)findViewById(R.id.txtResult);

        int score = getIntent().getIntExtra("score",-1);
        int maxScore = getIntent().getIntExtra("max_score",-1);
        int questionCount = getIntent().getIntExtra("num_questions",-1);
        int correctAnswerCount = getIntent().getIntExtra("correct_answers",-1);

        double average = ((double)score)/((double)questionCount);

        StringBuilder sb = new StringBuilder("");
        sb.append("Numero di domande:\t\t\t" + questionCount + "\n");
        sb.append("Corrette:\t\t\t\t" + correctAnswerCount + "\n");
        sb.append("Punteggio accumulato\t\t\t" + score + "\n");
        sb.append("Massimo raggiungibile\t\t\t" + maxScore + "\n");
        sb.append("Punteggio medio per domanda\t\t" + average + "\n");

        this.txtResult.setText(sb.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
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
}
