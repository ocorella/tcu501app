package comsiteucrtcu501.google.httpssites.tcu501;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondGradeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_grade);
    }

    public void goToMemory(View view){
        Intent startNewActivity = new Intent(this,MemoryActivity.class);
        startNewActivity.putExtra("grade", 2);
        startActivity(startNewActivity);
    }
}
