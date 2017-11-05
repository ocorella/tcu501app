package comsiteucrtcu501.google.httpssites.tcu501;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by oscar on 05/11/17.
 */

public class FreeForAllActivity extends AppCompatActivity {

    Activity activity = this;
    ImageView paint, memory, math;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.free_for_all_layout);
        paint = (ImageView) findViewById(R.id.paint);
        memory = (ImageView) findViewById(R.id.memory);
        math = (ImageView) findViewById(R.id.math);
        paint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startNewActivity = new Intent(activity,PaintActivity.class);
                startActivity(startNewActivity);
            }
        });
        memory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startNewActivity = new Intent(activity,MemoryActivity.class);
                startActivity(startNewActivity);

            }
        });
        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startNewActivity = new Intent(activity,MathToSpeech.class);
                startActivity(startNewActivity);

            }
        });
    }

}
