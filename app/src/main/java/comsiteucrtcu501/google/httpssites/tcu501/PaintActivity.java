package comsiteucrtcu501.google.httpssites.tcu501;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.media.MediaPlayer;
import android.widget.LinearLayout;
import java.util.UUID;
import android.provider.MediaStore;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.widget.Toast;
import java.lang.reflect.Field;

public class PaintActivity extends AppCompatActivity implements OnClickListener{
    private DrawingView drawView;
    private ImageButton currPaint;
    private ImageButton drawBtn;
    private ImageButton eraseBtn;
    private ImageButton newBtn;
    private ImageButton changeBtn;
    private float smallBrush, mediumBrush, largeBrush;
    private int cuenta = 0;
    private int limite = 2;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        drawView = (DrawingView) findViewById(R.id.drawing);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        LinearLayout paintLayout = (LinearLayout)findViewById(R.id.paint_colors);
        currPaint = (ImageButton)paintLayout.getChildAt(0);
        currPaint.setImageDrawable(getDrawable(R.drawable.paint_pressed));
        eraseBtn = (ImageButton)findViewById(R.id.erase_btn);
        eraseBtn.setOnClickListener(this);
        smallBrush = getResources().getInteger(R.integer.small_size);
        mediumBrush = getResources().getInteger(R.integer.medium_size);
        largeBrush = getResources().getInteger(R.integer.large_size);
        drawBtn = (ImageButton)findViewById(R.id.draw_btn);
        drawBtn.setOnClickListener(this);
        newBtn = (ImageButton)findViewById(R.id.new_btn);
        newBtn.setOnClickListener(this);
        changeBtn = (ImageButton)findViewById(R.id.change_btn);
        changeBtn.setOnClickListener(this);

        //drawView.setBrushSize(mediumBrush);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void paintClicked(View view){
        drawView = (DrawingView)findViewById(R.id.drawing);
        drawView.setErase(false);
        drawView.setBrushSize(drawView.getLastBrushSize());
        if(view!=currPaint){
            ImageButton imgView = (ImageButton)view;
            String color = view.getTag().toString();
            //drawView = (DrawingView)findViewById(R.id.drawing);
            drawView.setColorr(color);
            Log.d("Andres",color);
            MediaPlayer mp3;
            String colorMsg = "";
            switch (color) {
                case "#FF660000":
                    mp3 = MediaPlayer.create(getApplicationContext(), R.raw.brown);
                    colorMsg = "Brown";
                    mp3.start();
                    break;
                case "#FFFF0000":
                    mp3 = MediaPlayer.create(getApplicationContext(), R.raw.red);
                    colorMsg = "Red";
                    mp3.start();
                    break;
                case "#FFFF6600":
                    mp3 = MediaPlayer.create(getApplicationContext(), R.raw.orange);
                    colorMsg = "Orange";
                    mp3.start();
                    break;
                case "#FFFFCC00":
                    mp3 = MediaPlayer.create(getApplicationContext(), R.raw.yellow);
                    colorMsg = "Yellow";
                    mp3.start();
                    break;
                case "#FF009900":
                    mp3 = MediaPlayer.create(getApplicationContext(), R.raw.green);
                    colorMsg = "Green";
                    mp3.start();
                    break;
                case "#FF009999":
                    mp3 = MediaPlayer.create(getApplicationContext(), R.raw.light_blue);
                    colorMsg = "Light blue";
                    mp3.start();
                    break;
                case "#FF0000FF":
                    mp3 = MediaPlayer.create(getApplicationContext(), R.raw.blue);
                    colorMsg = "Blue";
                    mp3.start();
                    break;
                case "#FF990099":
                    mp3 = MediaPlayer.create(getApplicationContext(), R.raw.purple);
                    colorMsg = "Purple";
                    mp3.start();
                    break;
                case "#FFFF6666":
                    mp3 = MediaPlayer.create(getApplicationContext(), R.raw.pink);
                    colorMsg = "Pink";
                    mp3.start();
                    break;
                case "#FFFFFFFF":
                    mp3 = MediaPlayer.create(getApplicationContext(), R.raw.white);
                    colorMsg = "White";
                    mp3.start();
                    break;
                case "#FF787878":
                    mp3 = MediaPlayer.create(getApplicationContext(), R.raw.gray);
                    colorMsg = "Gray";
                    mp3.start();
                    break;
                case "#FF000000":
                    mp3 = MediaPlayer.create(getApplicationContext(), R.raw.black);
                    colorMsg = "Black";
                    mp3.start();
                    break;
                default:
                    break;
            }

            drawView = (DrawingView)findViewById(R.id.drawing);
            //R.style.MyDialogTheme.
            AlertDialog newDialog = new AlertDialog.Builder(this).create();
            newDialog.setTitle("");
            newDialog.setMessage(android.text.Html.fromHtml("<b>"+colorMsg+"</b>"));
            //newDialog.
            newDialog.show();


            //MediaPlayer media = MediaPlayer.create(getApplicationContext(), R.raw.color);
            //media.start();
            imgView.setImageDrawable(getDrawable(R.drawable.paint_pressed));
            currPaint.setImageDrawable(getDrawable(R.drawable.paint));
            currPaint=(ImageButton)view;
        }

        else if(view.getId()==R.id.erase_btn){
            MediaPlayer media = MediaPlayer.create(getApplicationContext(), R.raw.eraser);
            media.start();
            final Dialog brushDialog = new Dialog(this);
            brushDialog.setTitle("Eraser size:");
            brushDialog.setContentView(R.layout.brush_chooser);

            ImageButton smallBtn = (ImageButton)brushDialog.findViewById(R.id.small_brush);
            smallBtn.setOnClickListener(new OnClickListener(){
                @Override
                public void onClick(View v) {
                    drawView.setErase(true);
                    drawView.setBrushSize(smallBrush);
                    brushDialog.dismiss();
                }
            });
            ImageButton mediumBtn = (ImageButton)brushDialog.findViewById(R.id.medium_brush);
            mediumBtn.setOnClickListener(new OnClickListener(){
                @Override
                public void onClick(View v) {
                    drawView.setErase(true);
                    drawView.setBrushSize(mediumBrush);
                    brushDialog.dismiss();
                }
            });
            ImageButton largeBtn = (ImageButton)brushDialog.findViewById(R.id.large_brush);
            largeBtn.setOnClickListener(new OnClickListener(){
                @Override
                public void onClick(View v) {
                    drawView.setErase(true);
                    drawView.setBrushSize(largeBrush);
                    brushDialog.dismiss();
                }
            });

            brushDialog.show();
        }
    }

    public void onClick(View view){
        if(view.getId()==R.id.draw_btn){
            MediaPlayer media = MediaPlayer.create(getApplicationContext(), R.raw.brush);
            media.start();
            drawView = (DrawingView)findViewById(R.id.drawing);
            final Dialog brushDialog = new Dialog(this);
            brushDialog.setTitle("Brush size:");
            brushDialog.setContentView(R.layout.brush_chooser);

            ImageButton smallBtn = (ImageButton)brushDialog.findViewById(R.id.small_brush);
            smallBtn.setOnClickListener(new OnClickListener(){
                public void onClick(View v) {
                    drawView.setBrushSize(smallBrush);
                    drawView.setLastBrushSize(smallBrush);
                    drawView.setErase(false);
                    brushDialog.dismiss();
                }
            });

            ImageButton mediumBtn = (ImageButton)brushDialog.findViewById(R.id.medium_brush);
            mediumBtn.setOnClickListener(new OnClickListener(){
                @Override
                public void onClick(View v) {
                    drawView.setBrushSize(mediumBrush);
                    drawView.setLastBrushSize(mediumBrush);
                    drawView.setErase(false);
                    brushDialog.dismiss();
                }
            });

            ImageButton largeBtn = (ImageButton)brushDialog.findViewById(R.id.large_brush);
            largeBtn.setOnClickListener(new OnClickListener(){
                @Override
                public void onClick(View v) {
                    drawView.setBrushSize(largeBrush);
                    drawView.setLastBrushSize(largeBrush);
                    drawView.setErase(false);
                    brushDialog.dismiss();
                }
            });

            brushDialog.show();
        }
        else if(view.getId()==R.id.erase_btn){
            MediaPlayer media = MediaPlayer.create(getApplicationContext(), R.raw.eraser);
            media.start();
            drawView = (DrawingView)findViewById(R.id.drawing);
            final Dialog brushDialog = new Dialog(this);
            brushDialog.setTitle("Eraser size:");
            brushDialog.setContentView(R.layout.brush_chooser);

            ImageButton smallBtn = (ImageButton)brushDialog.findViewById(R.id.small_brush);
            smallBtn.setOnClickListener(new OnClickListener(){
                @Override
                public void onClick(View v) {
                    drawView.setErase(true);
                    drawView.setBrushSize(smallBrush);
                    brushDialog.dismiss();
                }
            });
            ImageButton mediumBtn = (ImageButton)brushDialog.findViewById(R.id.medium_brush);
            mediumBtn.setOnClickListener(new OnClickListener(){
                @Override
                public void onClick(View v) {
                    drawView.setErase(true);
                    drawView.setBrushSize(mediumBrush);
                    brushDialog.dismiss();
                }
            });
            ImageButton largeBtn = (ImageButton)brushDialog.findViewById(R.id.large_brush);
            largeBtn.setOnClickListener(new OnClickListener(){
                @Override
                public void onClick(View v) {
                    drawView.setErase(true);
                    drawView.setBrushSize(largeBrush);
                    brushDialog.dismiss();
                }
            });
            brushDialog.show();
        }
        else if(view.getId()==R.id.new_btn){
                drawView = (DrawingView)findViewById(R.id.drawing);
           // drawView = (DrawingView)findViewById(R.id.drawing);
            drawView.setBackgroundResource(R.drawable.fam2);
                AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
                newDialog.setTitle("New drawing");
                newDialog.setMessage("Do you want to start a new drawing?");
                newDialog.setNegativeButton("No", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        dialog.cancel();
                    }
                });
                newDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        drawView.startNew();
                        dialog.dismiss();
                    }
                });
            newDialog.show();
        }
        else if(view.getId()== R.id.change_btn){
            if(cuenta < limite) {
                cuenta++;
            } else {
                cuenta = 1;
            }

            drawView = (DrawingView)findViewById(R.id.drawing);

            Drawable drawable = getResources().getDrawable(getResources()
                    .getIdentifier("fam"+cuenta, "drawable", getPackageName()));
            drawView.setBackground(drawable);
            drawView.startNew();
        }
    }
}
