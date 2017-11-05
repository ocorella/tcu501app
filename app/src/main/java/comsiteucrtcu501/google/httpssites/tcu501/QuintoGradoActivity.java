package comsiteucrtcu501.google.httpssites.tcu501;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import comsiteucrtcu501.google.httpssites.tcu501.dragDrop.DragDropFifthActivity;

public class QuintoGradoActivity extends AppCompatActivity {

    Activity activity = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quinto_grado);
        ImageView drag = (ImageView) findViewById(R.id.drag_drop_image);
        drag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startNewActivity = new Intent(activity,DragDropFifthActivity.class);
                startActivity(startNewActivity);
            }
        });
    }
}
