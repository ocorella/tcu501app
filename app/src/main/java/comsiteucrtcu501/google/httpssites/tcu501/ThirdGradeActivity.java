package comsiteucrtcu501.google.httpssites.tcu501;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ThirdGradeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_grade);
    }

    public void goToMemory(View view){
        Intent startNewActivity = new Intent(this,MemoryActivity.class);
        startNewActivity.putExtra("grade", 3);
        startActivity(startNewActivity);
    }
}
