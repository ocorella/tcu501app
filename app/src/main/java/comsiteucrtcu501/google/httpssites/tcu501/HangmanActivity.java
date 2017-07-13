package comsiteucrtcu501.google.httpssites.tcu501;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by oscar on 06/07/17.
 */

public class HangmanActivity extends Activity{

    CurrentGameStatus current_game = new CurrentGameStatus();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);

        TextView wordView = (TextView) findViewById(R.id.word);
        TextView scoreText = (TextView) findViewById(R.id.score);
        TextView hint = (TextView) findViewById(R.id.hint);


        switch (current_game.wordToGuess.return_raw_word()) {
            case "directions":  hint.setText("You ask for this if you do not know where to go");
                break;
            case "chores":  hint.setText("Responsability as a family member");
                break;
            case "christmas":  hint.setText("Celebrated in december when Santa Clause comes to town");
                break;
            case "birthday":  hint.setText("When you were born");
                break;
            case "beach":  hint.setText("Place with sand, sun,  and water where you go on vacations");
                break;
            case "mountain":  hint.setText("Natural elevation of land");
                break;
            case "store":  hint.setText("If you want to buy vegetables you go to this place");
                break;
            case "park":  hint.setText("Place with trees and swings where you can have fun");
                break;
            case "dish":  hint.setText("Item you wash after eating");
                break;
            case "bedroom": hint.setText("Place where you sleep and have to clean");
                break;
            default: hint.setText("");
                break;
        }


        System.out.println("Game Created with Word: " + current_game.get_raw_word());
        System.out.println("Game Created with Score: " + current_game.get_score());
        System.out.println("Game Created with Score: " + current_game.get_display_word());

        wordView.setText(current_game.get_display_word());
        scoreText.setText("Score: " + Integer.toString(current_game.get_score()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }


    public void new_guess(View view) {

        TextView wordView = (TextView) findViewById(R.id.word);
        TextView scoreText = (TextView) findViewById(R.id.score);
        TextView letter_guessed = (TextView) findViewById(R.id.new_letter);

        String new_guess = letter_guessed.getText().toString();
        if (!new_guess.equals("")) {
            current_game.try_to_insert_letter(new_guess);

            wordView.setText(current_game.get_display_word());
            scoreText.setText(Integer.toString(current_game.get_score()));
            letter_guessed.setText("");

            if (current_game.word_completed()) {
                Toast.makeText(getApplicationContext(), "Congrats!!!! \n You guessed " + current_game.get_raw_word().toUpperCase() + " correctly", Toast.LENGTH_LONG).show();
                reset(view);
            }
        }
    }


    public void reset(View view) {
        TextView wordView = (TextView) findViewById(R.id.word);
        TextView scoreText = (TextView) findViewById(R.id.score);
        TextView hint = (TextView) findViewById(R.id.hint);


        current_game = new CurrentGameStatus();
        wordView.setText(current_game.get_display_word());
        scoreText.setText(Integer.toString(current_game.get_score()));

        switch (current_game.wordToGuess.return_raw_word()) {
            case "directions":  hint.setText("You ask for this if you do not know where to go");
                break;
            case "chores":  hint.setText("Responsability as a family member");
                break;
            case "christmas":  hint.setText("Celebrated in december when Santa Clause comes to town");
                break;
            case "birthday":  hint.setText("When you were born");
                break;
            case "beach":  hint.setText("Place with sand, sun,  and water where you go on vacations");
                break;
            case "mountain":  hint.setText("Natural elevation of land");
                break;
            case "store":  hint.setText("If you want to buy vegetables you go to this place, Responsability as a family member, Place with trees and swings where you can have fun,\n");
                break;
            case "park":  hint.setText("Place with trees and swings where you can have fun");
                break;
            case "dish":  hint.setText("Item you wash after eating");
                break;
            case "bedroom": hint.setText("Place where you sleep and have to clean");
                break;
            default: hint.setText("");
                break;
        }
    }


}
