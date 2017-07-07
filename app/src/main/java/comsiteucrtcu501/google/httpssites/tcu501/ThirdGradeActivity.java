package comsiteucrtcu501.google.httpssites.tcu501;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdGradeActivity extends AppCompatActivity {

    Button hangmanButton;
    Activity activity = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_grade);
        hangmanButton = (Button) findViewById(R.id.button_hangman);
        hangmanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activity, HangmanActivity.class);
                startActivity(i);

            }
        });
    }

    public void goToMemory(View view){
        Intent startNewActivity = new Intent(this,MemoryActivity.class);
        startNewActivity.putExtra("grade", 3);
        startActivity(startNewActivity);
    }
}
