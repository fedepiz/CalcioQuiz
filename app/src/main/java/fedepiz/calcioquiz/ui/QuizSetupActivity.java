package fedepiz.calcioquiz.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import fedepiz.calcioquiz.R;


public class QuizSetupActivity extends ActionBarActivity {

    private TextView txtMinPoints;
    private TextView txtMaxPoints;
    private TextView txtNumQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_setup);

        this.txtMinPoints = (TextView)findViewById(R.id.txtMinPoints);
        this.txtMaxPoints = (TextView)findViewById(R.id.txtMaxPoints);
        this.txtNumQuestions = (TextView)findViewById(R.id.txtNumQuestions);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz_setup, menu);
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

    //UI BACKEND

    private void launchGame() {
        Integer minPoints = parseIntFromText(txtMinPoints.getText().toString(),0);
        Integer maxPoints = parseIntFromText(txtMaxPoints.getText().toString(),1000);
        Integer numQuestions = parseIntFromText(txtNumQuestions.getText().toString(),10);

        Intent intent = new Intent(this,QuizActivity.class);
        intent.putExtra("minPoints",minPoints);
        intent.putExtra("maxPoints",maxPoints);
        intent.putExtra("numQuestions",numQuestions);

        Log.i("CalcioQuiz",minPoints.toString());
        Log.i("CalcioQuiz",maxPoints.toString());
        Log.i("CalcioQuiz",numQuestions.toString());
        startActivity(intent);
    }

    //PROCESSING
    private int parseIntFromText(String str,int defaultValue) {
        if(str == "") {
            return defaultValue;
        } else {
            return Integer.parseInt(str);
        }
    }

    //UI FRONTEND

    public void btnStartGameOnClick(View view) {
        launchGame();
    }
}
