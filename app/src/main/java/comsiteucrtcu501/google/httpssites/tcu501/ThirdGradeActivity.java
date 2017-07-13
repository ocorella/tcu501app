package comsiteucrtcu501.google.httpssites.tcu501;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ThirdGradeActivity extends AppCompatActivity {

    ImageView hangmanButton, memory, paint, puzzle;
    Activity activity = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_grade);
        hangmanButton = (ImageView) findViewById(R.id.button_hangman);
        hangmanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activity, HangmanActivity.class);
                startActivity(i);

            }
        });
        memory = (ImageView) findViewById(R.id.memory_image);
        memory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startNewActivity = new Intent(activity,MemoryActivity.class);
                startNewActivity.putExtra("grade", 3);
                startActivity(startNewActivity);

            }
        });

        paint = (ImageView) findViewById(R.id.paint_image);
        paint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startNewActivity = new Intent(activity,PaintActivity.class);
                startActivity(startNewActivity);
            }
        });

        puzzle = (ImageView) findViewById(R.id.puzzle_image);
        puzzle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startNewActivity = new Intent(activity,MathToSpeech.class);
                startActivity(startNewActivity);
            }
        });


    }

    public void goToMemory(View view){
        Intent startNewActivity = new Intent(this,MemoryActivity.class);
        startNewActivity.putExtra("grade", 3);
        startActivity(startNewActivity);
    }
}
