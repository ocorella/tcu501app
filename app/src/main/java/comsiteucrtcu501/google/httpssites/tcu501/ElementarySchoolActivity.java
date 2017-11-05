package comsiteucrtcu501.google.httpssites.tcu501;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import comsiteucrtcu501.google.httpssites.tcu501.Vocabulary.ClickAndListenSecond;
import comsiteucrtcu501.google.httpssites.tcu501.dragDrop.DragDropSecondActivity;

public class ElementarySchoolActivity extends AppCompatActivity {

    Button one,two,three,four,five,six;
    MediaPlayer mp3;
    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elementary_school);
        one = (Button) findViewById(R.id.button_1ro);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp3 = MediaPlayer.create(getApplicationContext(), R.raw.firstgrade);
                mp3.start();
                Intent startNewActivity = new Intent(activity,FirstGradeActivity.class);
                startActivity(startNewActivity);
            }
        });
        two = (Button) findViewById(R.id.button_2do);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp3 = MediaPlayer.create(getApplicationContext(), R.raw.secondgrade);
                mp3.start();
                Intent startNewActivity = new Intent(activity,SecondGradeActivity.class);
                startActivity(startNewActivity);

            }
        });
        three = (Button) findViewById(R.id.button_3ro);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp3 = MediaPlayer.create(getApplicationContext(), R.raw.thirdgrade);
                mp3.start();
                Intent startNewActivity = new Intent(activity,ThirdGradeActivity.class);
                startActivity(startNewActivity);

            }
        });
        four = (Button) findViewById(R.id.button_4to);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp3 = MediaPlayer.create(getApplicationContext(), R.raw.fourthgrade);
                mp3.start();
                Intent startNewActivity = new Intent(activity,CuartoGradoActivity.class);
                startActivity(startNewActivity);

            }
        });
        five = (Button) findViewById(R.id.button_5to);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp3 = MediaPlayer.create(getApplicationContext(), R.raw.fifthgrade);
                mp3.start();
               Intent startNewActivity = new Intent(activity,QuintoGradoActivity.class);
                startActivity(startNewActivity);

            }
        });
        six = (Button) findViewById(R.id.button_6to);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp3 = MediaPlayer.create(getApplicationContext(), R.raw.sixthgrade);
                mp3.start();
                Intent startNewActivity = new Intent(activity,SextoGradoActivity.class);
                startActivity(startNewActivity);

            }
        });
    }

    public void irA1ro(View view){
        Intent startNewActivity = new Intent(this,FirstGradeActivity.class);
        startActivity(startNewActivity);
    }
    public void irA2do(View view){
        Intent startNewActivity = new Intent(activity,SecondGradeActivity.class);
        startActivity(startNewActivity);
    }
    public void irA3ro(View view){
        Intent startNewActivity = new Intent(activity,ThirdGradeActivity.class);
        startActivity(startNewActivity);
    }
    public void irA4to(View view){
        Intent startNewActivity = new Intent(activity,CuartoGradoActivity.class);
        startActivity(startNewActivity);
    }
    public void irA5to(View view){
        Intent startNewActivity = new Intent(activity,QuintoGradoActivity.class);
        startActivity(startNewActivity);
    }
    public void irA6to(View view){
        Intent startNewActivity = new Intent(activity,SextoGradoActivity.class);
        startActivity(startNewActivity);
    }
}