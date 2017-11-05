package comsiteucrtcu501.google.httpssites.tcu501;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import comsiteucrtcu501.google.httpssites.tcu501.Vocabulary.ClickAndListenSecond;
import comsiteucrtcu501.google.httpssites.tcu501.dragDrop.DragDropSecondActivity;

public class SecondGradeActivity extends AppCompatActivity {

    ImageView drag, touch, guess;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_grade);
        activity = this;
        drag = (ImageView) findViewById(R.id.drag_drop);
        drag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startNewActivity = new Intent(activity,DragDropSecondActivity.class);
                startActivity(startNewActivity);
            }
        });
        touch = (ImageView) findViewById(R.id.touch);
        touch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startNewActivity = new Intent(activity,ClickAndListenSecond.class);
                startActivity(startNewActivity);
            }
        });



    }


}
