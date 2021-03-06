package fedepiz.calcioquiz;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import fedepiz.calcioquiz.data.DataLoader;
import fedepiz.calcioquiz.data.GameData;
import fedepiz.calcioquiz.ui.QuizSetupActivity;


public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean okInit = initialSetup();
        if(!okInit) {
            throw new RuntimeException("Errore critico: chiusura applicazione");
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

    private boolean initialSetup()  {
        try {
            GameData.loadGameData(this.getResources());
            return true;
        }catch (Exception ex) {
            Log.i("CalcioQuiz","An exception occurred while loading data");
            return false;
        }
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

