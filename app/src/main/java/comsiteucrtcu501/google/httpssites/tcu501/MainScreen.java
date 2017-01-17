package comsiteucrtcu501.google.httpssites.tcu501;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    public void irAPrimaria(View view){
        Intent startNewActivity = new Intent(this,ElementarySchoolActivity.class);
        startActivity(startNewActivity);

    }

    public void irASecundaria(View view){
        Intent startNewActivity = new Intent(this,SecundariaActivity.class);
        startActivity(startNewActivity);
    }
}
