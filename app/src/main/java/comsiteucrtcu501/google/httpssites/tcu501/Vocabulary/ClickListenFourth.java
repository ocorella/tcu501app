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
 * Created by oscar on 30/10/17.
 */

public class ClickListenFourth extends AppCompatActivity {

    TextToSpeech t1;
    LinearLayout one, two, three, four, five, six;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clicklisten_fourth);

        one = (LinearLayout) findViewById(R.id.topleft);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i != TextToSpeech.ERROR){
                            t1.setLanguage(Locale.ENGLISH);
                            String toSpeak = "Christmas is on December the twenty-fourth ";
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
                            String toSpeak = "My house has a swimming pool";
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
                            String toSpeak = "We had a car accident and it was dangerous.";
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
                            String toSpeak = "I have fever";
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
                            String toSpeak = "She broke her arm";
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
                            String toSpeak = "I need three big carrots from the farmer's market";
                            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                });
            }
        });

    }
}
