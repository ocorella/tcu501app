package comsiteucrtcu501.google.httpssites.tcu501;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import comsiteucrtcu501.google.httpssites.tcu501.dragDrop.DragDropFifthActivity;
import comsiteucrtcu501.google.httpssites.tcu501.dragDrop.DragDropFirstActivity;

public class FirstGradeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_grade);
        final Activity mActivity = this;
        ImageView drag = (ImageView) findViewById(R.id.drag_drop_image);
        drag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startNewActivity = new Intent(mActivity,DragDropFirstActivity.class);
                startActivity(startNewActivity);
            }
        });
    }

}