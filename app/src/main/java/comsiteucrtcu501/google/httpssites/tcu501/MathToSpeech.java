package comsiteucrtcu501.google.httpssites.tcu501;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

import comsiteucrtcu501.google.httpssites.tcu501.Utils.EnglishNumberToWords;

/**
 * Created by oscar on 13/07/17.
 */

public class MathToSpeech extends Activity {

    TextView first, second, operand, firstText, secondText;
    int maxRandomNumber, rand1, rand2;
    String operation ="";
    int answer;
    TextToSpeech t1;
    String operandToSpeech="";
    Button checkResult;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_to_speech);

        first = (TextView) findViewById(R.id.firstnumber);
        firstText = (TextView) findViewById(R.id.firstnumberText);
        secondText = (TextView) findViewById(R.id.secondnumbertext);
        operand = (TextView) findViewById(R.id.operand);
        second = (TextView) findViewById(R.id.secondnumber);
        editText = (EditText) findViewById(R.id.math_answer);
        checkResult = (Button) findViewById(R.id.check_math);
        checkResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = editText.getText().toString();
                if (result.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please give an answer first", Toast.LENGTH_LONG).show();

                }
                else{
                    int i = Integer.parseInt(result);
                    if(i == answer){
                        Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_LONG).show();
                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                            @Override
                            public void onInit(int i) {
                                if (i != TextToSpeech.ERROR){
                                    t1.setLanguage(Locale.ENGLISH);
                                    String toSpeak = "Correct, the answer is " + Integer.toString(answer);
                                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);


                                    Random randomGenerator = new Random();
                                    rand1 = randomGenerator.nextInt(maxRandomNumber+1);
                                    rand2 = randomGenerator.nextInt(maxRandomNumber+1);
                                    if(rand2 == 0){
                                        rand2++;
                                    }

                                    int op = randomGenerator.nextInt(4);
                                    if(op == 0){
                                        operation = "-";
                                        answer = rand1 - rand2;
                                        operandToSpeech = "minus";
                                    }
                                    else if (op == 1) {
                                        operation = "*";
                                        answer = rand1 * rand2;
                                        operandToSpeech = "multiplied by";
                                    }
                                    else if (op == 2) {
//                    operation = "/";
//                    answer = rand1 / rand2;
//                    operandToSpeech = "divided by";
                                        operation = "+";
                                        answer = rand1 + rand2;
                                        operandToSpeech = "plus";
                                    }
                                    else {
                                        operation = "+";
                                        answer = rand1 + rand2;
                                        operandToSpeech = "plus";
                                    }

                                    operand.setText(operation);
                                    if(rand2 > rand1){
                                        int temp = rand1;
                                        rand1 = rand2;
                                        rand2 = temp;
                                    }
                                    first.setText(Integer.toString(rand1));
                                    firstText.setText(""+EnglishNumberToWords.convert(rand1));
                                    second.setText(Integer.toString(rand2));
                                    secondText.setText(""+EnglishNumberToWords.convert(rand2));


                                    t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                        @Override
                                        public void onInit(int i) {
                                            if (i != TextToSpeech.ERROR){
                                                t1.setLanguage(Locale.ENGLISH);
                                                String toSpeak = Integer.toString(rand1) + operandToSpeech + Integer.toString(rand2);
                                                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                                            }
                                        }
                                    });

                                }
                            }
                        });
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_LONG).show();
                        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                            @Override
                            public void onInit(int i) {
                                if (i != TextToSpeech.ERROR){
                                    t1.setLanguage(Locale.ENGLISH);
                                    String toSpeak = Integer.toString(rand1) + operandToSpeech + Integer.toString(rand2);
                                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                                }
                            }
                        });
                    }
                }
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Max number to play with (Número máximo para jugar)");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        input.setInputType( InputType.TYPE_CLASS_NUMBER );
        InputFilter[] FilterArray = new InputFilter[1];
        FilterArray[0] = new InputFilter.LengthFilter(5);
        editText.setFilters(FilterArray);
        builder.setView(input);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String ced = input.getText().toString();
                int i = 0;
                if(ced.isEmpty()){
                    i = 10;
                }
                else {
                    i = Integer.parseInt(ced);
                }
                maxRandomNumber = i;
                Random randomGenerator = new Random();
                rand1 = randomGenerator.nextInt(maxRandomNumber+1);
                rand2 = randomGenerator.nextInt(maxRandomNumber+1);
                if(rand2 == 0){
                    rand2++;
                }

                int op = randomGenerator.nextInt(4);
                if(op == 0){
                    operation = "-";
                    answer = rand1 - rand2;
                    answer = Math.abs(answer);
                    operandToSpeech = "minus";
                }
                else if (op == 1) {
                    operation = "*";
                    answer = rand1 * rand2;
                    answer = Math.abs(answer);
                    operandToSpeech = "multiplied by";
                }
                else if (op == 2) {
//                    operation = "/";
//                    answer = rand1 / rand2;
//                    operandToSpeech = "divided by";
                    operation = "+";
                    answer = rand1 + rand2;
                    answer = Math.abs(answer);
                    operandToSpeech = "plus";
                }
                else {
                    operation = "+";
                    answer = rand1 + rand2;
                    answer = Math.abs(answer);
                    operandToSpeech = "plus";
                }

                operand.setText(operation);
                if(rand2 > rand1){
                    int temp = rand1;
                    rand1 = rand2;
                    rand2 = temp;
                }
                first.setText(Integer.toString(rand1));
                firstText.setText(""+EnglishNumberToWords.convert(rand1));
                second.setText(Integer.toString(rand2));
                secondText.setText(""+EnglishNumberToWords.convert(rand2));


                t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i != TextToSpeech.ERROR){
                            t1.setLanguage(Locale.ENGLISH);
                            String toSpeak = Integer.toString(rand1) + operandToSpeech + Integer.toString(rand2);
                            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                });

                dialog.dismiss();
            }
        });
        builder.show();

    }

}
