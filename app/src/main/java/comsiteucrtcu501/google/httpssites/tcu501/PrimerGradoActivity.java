package comsiteucrtcu501.google.httpssites.tcu501;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PrimerGradoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primer_grado);
    }

    public void irAPaint(View view){
        Intent startNewActivity = new Intent(this,PaintActivity.class);
        startActivity(startNewActivity);
    }
    public void irAMemoria(View view){
        Intent startNewActivity = new Intent(this,MemoriaActivity.class);
        startActivity(startNewActivity);
    }
    public void irARompecabezas(View view){
        Intent startNewActivity = new Intent(this,RompecabezasActivity.class);
        startActivity(startNewActivity);
    }

}
