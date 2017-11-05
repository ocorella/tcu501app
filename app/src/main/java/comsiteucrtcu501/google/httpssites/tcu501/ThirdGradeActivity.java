package comsiteucrtcu501.google.httpssites.tcu501;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import comsiteucrtcu501.google.httpssites.tcu501.dragDrop.DragDropFifthActivity;
import comsiteucrtcu501.google.httpssites.tcu501.dragDrop.DragDropThirdActivity;

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

        ImageView drag = (ImageView) findViewById(R.id.drag_drop_image);
        drag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startNewActivity = new Intent(activity,DragDropThirdActivity.class);
                startActivity(startNewActivity);
            }
        });


    }

}
