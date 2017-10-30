package comsiteucrtcu501.google.httpssites.tcu501.Vocabulary;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Locale;

import comsiteucrtcu501.google.httpssites.tcu501.R;

/**
 * Created by oscar on 29/10/17.
 */

public class ClickAndListenSecond extends AppCompatActivity {

    TextToSpeech t1;
    LinearLayout one, two, three, four, five, six;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_listen_third);

        one = (LinearLayout) findViewById(R.id.topleft);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i != TextToSpeech.ERROR){
                            t1.setLanguage(Locale.ENGLISH);
                            String toSpeak = "I am smelling a flower with my nose";
                            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                });
            }
        });

        two = (LinearLayout) findViewById(R.id.topright);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i != TextToSpeech.ERROR){
                            t1.setLanguage(Locale.ENGLISH);
                            String toSpeak = "I kick the ball with my feet when I play soccer";
                            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                });
            }
        });

        three = (LinearLayout) findViewById(R.id.bottomleft);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i != TextToSpeech.ERROR){
                            t1.setLanguage(Locale.ENGLISH);
                            String toSpeak = "I always take a shower in the morning";
                            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                });
            }
        });

        four = (LinearLayout) findViewById(R.id.bottomright);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i != TextToSpeech.ERROR){
                            t1.setLanguage(Locale.ENGLISH);
                            String toSpeak = "Eating fruits and vegetables is healthy";
                            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                });
            }
        });


        five = (LinearLayout) findViewById(R.id.fivelayout);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i != TextToSpeech.ERROR){
                            t1.setLanguage(Locale.ENGLISH);
                            String toSpeak = "The weather is rainy";
                            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                });
            }
        });

        six = (LinearLayout) findViewById(R.id.sixlayout);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i != TextToSpeech.ERROR){
                            t1.setLanguage(Locale.ENGLISH);
                            String toSpeak = "The weather is sunny";
                            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                });
            }
        });

    }
}
