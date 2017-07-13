package comsiteucrtcu501.google.httpssites.tcu501;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainScreen extends AppCompatActivity {

    MediaPlayer mp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    public void irAPrimaria(View view){
        mp3 = MediaPlayer.create(getApplicationContext(), R.raw.elementary);
        mp3.start();
        Intent startNewActivity = new Intent(this,ElementarySchoolActivity.class);
        startActivity(startNewActivity);

    }

    public void irASecundaria(View view){
        mp3 = MediaPlayer.create(getApplicationContext(), R.raw.highschool);
        mp3.start();
        Intent startNewActivity = new Intent(this,SecundariaActivity.class);
        startActivity(startNewActivity);
    }
}
