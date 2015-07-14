package fedepiz.calcioquiz;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import fedepiz.calcioquiz.model.*;
import fedepiz.calcioquiz.ui.QuizSetupActivity;


public class MainActivity extends ActionBarActivity {

    private DataLoader dataLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            intitialSetup();
        }catch(Exception ex) {
            Log.i("CalcioQuiz", ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    //UI BACKEND CODE

    private void intitialSetup() throws Exception {
        this.dataLoader = new DataLoader(this.getResources());
        GameData.setQuestions(dataLoader.loadQuestions());
    }

    private void launchSinglePlayer(){
        Intent intent = new Intent(this,QuizSetupActivity.class);
        startActivity(intent);
    }

    //UI INTERACTION

    public void btnSinglePlayerOnClick(View view) {
        launchSinglePlayer();
    }
}

