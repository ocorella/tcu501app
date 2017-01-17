package comsiteucrtcu501.google.httpssites.tcu501;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FirstGradeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_grade);
    }

    public void irAPaint(View view){
        Intent startNewActivity = new Intent(this,PaintActivity.class);
        startActivity(startNewActivity);
    }

    public void goToMemory(View view){
        Intent startNewActivity = new Intent(this,MemoryActivity.class);
        startNewActivity.putExtra("grade", 1);
        startActivity(startNewActivity);
    }

    public void irARompecabezas(View view){
        Intent startNewActivity = new Intent(this,RompecabezasActivity.class);
        startActivity(startNewActivity);
    }
}