package comsiteucrtcu501.google.httpssites.tcu501;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainScreen extends AppCompatActivity {

    MediaPlayer mp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        LinearLayout games = (LinearLayout) findViewById(R.id.games);
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irAJuegos();
            }
        });
    }

    public void irAPrimaria(View view){
        mp3 = MediaPlayer.create(getApplicationContext(), R.raw.elementary);
        mp3.start();
        Intent startNewActivity = new Intent(this,ElementarySchoolActivity.class);
        startActivity(startNewActivity);

    }

    public void irAJuegos(){
        Intent startNewActivity = new Intent(this,FreeForAllActivity.class);
        startActivity(startNewActivity);

    }

}
