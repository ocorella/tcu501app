package comsiteucrtcu501.google.httpssites.tcu501.dragDrop;

import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.Locale;

import comsiteucrtcu501.google.httpssites.tcu501.R;

/**
 * Created by oscar on 30/10/17.
 */

public class DragDropFourthActivity  extends AppCompatActivity {

    ImageButton soundTopL, soundTopR, soundBottomL, soundBottomR, five, six;
    TextToSpeech t1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dragdrop_fourth);
        findViewById(R.id.myimage1).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.myimage2).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.myimage3).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.myimage4).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.myimage5).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.myimage6).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.myimage7).setOnTouchListener(new MyTouchListener());

        findViewById(R.id.title).setOnDragListener(new MyDragListener());


        findViewById(R.id.topleft).setOnDragListener(new MyDragListener());
        findViewById(R.id.topright).setOnDragListener(new MyDragListener());
        findViewById(R.id.bottomleft).setOnDragListener(new MyDragListener());
        findViewById(R.id.bottomright).setOnDragListener(new MyDragListener());
        findViewById(R.id.fivelayout).setOnDragListener(new MyDragListener());
        findViewById(R.id.sixlayout).setOnDragListener(new MyDragListener());

        findViewById(R.id.bottomall).setOnDragListener(new MyDragListener());
        findViewById(R.id.bottomall2).setOnDragListener(new MyDragListener());

        soundBottomL = (ImageButton) findViewById(R.id.soundbottomleft);
        soundBottomL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i != TextToSpeech.ERROR){
                            t1.setLanguage(Locale.ENGLISH);
                            String toSpeak = "The boy loves reading";
                            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                });
            }
        });
        soundBottomR = (ImageButton) findViewById(R.id.soundbottomright);
        soundBottomR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i != TextToSpeech.ERROR){
                            t1.setLanguage(Locale.ENGLISH);
                            String toSpeak = "The girl has a pet cat";
                            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                });
            }
        });
        soundTopL = (ImageButton) findViewById(R.id.soundtopleft);
        soundTopL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i != TextToSpeech.ERROR){
                            t1.setLanguage(Locale.ENGLISH);
                            String toSpeak = "Maria has a green book";
                            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                });

            }
        });
        soundTopR = (ImageButton) findViewById(R.id.soundtopright);
        soundTopR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i != TextToSpeech.ERROR){
                            t1.setLanguage(Locale.ENGLISH);
                            String toSpeak = "Carlos is a cook";
                            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                });
            }
        });
        five = (ImageButton) findViewById(R.id.fivesound);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i != TextToSpeech.ERROR){
                            t1.setLanguage(Locale.ENGLISH);
                            String toSpeak = "Erick washes his hands before eating";
                            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                });
            }
        });

        six = (ImageButton) findViewById(R.id.sixsound);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i != TextToSpeech.ERROR){
                            t1.setLanguage(Locale.ENGLISH);
                            String toSpeak = "Mary dislikes junk food";
                            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                });
            }
        });


    }

    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                        view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            } else {
                return false;
            }
        }
    }

    class MyDragListener implements View.OnDragListener {
        Drawable enterShape = getResources().getDrawable(
                R.drawable.shape_droptarget);
        Drawable normalShape = getResources().getDrawable(R.drawable.shape);

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    v.setBackgroundDrawable(enterShape);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    v.setBackgroundDrawable(normalShape);
                    break;
                case DragEvent.ACTION_DROP:
                    // Dropped, reassign View to ViewGroup
                    View view = (View) event.getLocalState();
                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);
                    LinearLayout container = (LinearLayout) v;
                    int i = container.getId();
                    String s = getResources().getResourceName(i);
                    int j = view.getId();
                    String s2 = getResources().getResourceName(j);

                    if( (s.contains("topleft") && s2.contains("myimage1"))
                            || (s.contains("topright") && s2.contains("myimage4"))
                            || (s.contains("bottomleft") && s2.contains("myimage2"))
                            || (s.contains("bottomright") && s2.contains("myimage3"))
                            || (s.contains("fivelayout") && s2.contains("myimage6"))
                            || (s.contains("sixlayout") && s2.contains("myimage7"))
                            ) {
                        container.addView(view);
                        view.setVisibility(View.VISIBLE);
                    }
                    else{
                        owner.addView(view);
                        view.setVisibility(View.VISIBLE);
                    }

                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    v.setBackgroundDrawable(normalShape);
                default:
                    break;
            }
            return true;
        }
    }
}