package comsiteucrtcu501.google.httpssites.tcu501;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class PrimariaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primaria);
    }

    public void irA1ro(View view){
        Intent startNewActivity = new Intent(this,PrimerGradoActivity.class);
        startActivity(startNewActivity);
    }
    public void irA2do(View view){
        Intent startNewActivity = new Intent(this,SegundoGradoActivity.class);
        startActivity(startNewActivity);
    }
    public void irA3ro(View view){
        Intent startNewActivity = new Intent(this,TercerGradoActivity.class);
        startActivity(startNewActivity);
    }
    public void irA4to(View view){
        Intent startNewActivity = new Intent(this,CuartoGradoActivity.class);
        startActivity(startNewActivity);
    }
    public void irA5to(View view){
        Intent startNewActivity = new Intent(this,QuintoGradoActivity.class);
        startActivity(startNewActivity);
    }
    public void irA6to(View view){
        Intent startNewActivity = new Intent(this,SextoGradoActivity.class);
        startActivity(startNewActivity);
    }
}
