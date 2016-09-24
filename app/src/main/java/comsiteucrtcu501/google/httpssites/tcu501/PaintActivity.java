package comsiteucrtcu501.google.httpssites.tcu501;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class PaintActivity extends AppCompatActivity {
    private DrawingView drawView;
    private ImageButton currPaint;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        drawView = (DrawingView)findViewById(R.id.drawing);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        LinearLayout paintLayout = (LinearLayout)findViewById(R.id.paint_colors);
        currPaint = (ImageButton)paintLayout.getChildAt(0);
        currPaint.setImageDrawable(getDrawable(R.drawable.paint_pressed));
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void paintClicked(View view){
        if(view!=currPaint){
            ImageButton imgView = (ImageButton)view;
            String color = view.getTag().toString();
            drawView = (DrawingView)findViewById(R.id.drawing);
            drawView.setColorr(color);
            imgView.setImageDrawable(getDrawable(R.drawable.paint_pressed));
            currPaint.setImageDrawable(getDrawable(R.drawable.paint));
            currPaint=(ImageButton)view;
        }
    }
}
