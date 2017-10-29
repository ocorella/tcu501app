package comsiteucrtcu501.google.httpssites.tcu501;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oscar on 06/07/17.
 */

public class HangmanActivity extends Activity{

    CurrentGameStatus current_game = new CurrentGameStatus();
    TextView hint, category;
    ImageView image;
    String[] urlImageList = {"https://cdn.pixabay.com/photo/2013/12/29/10/15/directory-235079_960_720.jpg",
            "https://cdn.pixabay.com/photo/2012/02/19/18/07/orange-15047_960_720.jpg",
            "https://asset.holidaycardsapp.com/assets/card/b_day229-6ae37171a98c1ce89a30eb6454e1fe60.png",
            "https://cdn.pixabay.com/photo/2016/09/03/14/18/natural-1641791_960_720.jpg",
            "https://cdn.pixabay.com/photo/2016/06/01/17/43/house-1429409_960_720.png",
            "https://cdn.pixabay.com/photo/2015/09/15/19/26/window-941625_960_720.jpg",
            "https://cdn.pixabay.com/photo/2013/07/12/17/50/door-152538_960_720.png",
            "https://cdn.pixabay.com/photo/2013/07/12/13/58/settee-147701_960_720.png",
            "https://cdn.pixabay.com/photo/2017/09/13/19/53/chair-2746767_960_720.png",
            "https://cdn.pixabay.com/photo/2013/11/20/23/54/pig-214349_960_720.jpg",
            "https://cdn.pixabay.com/photo/2016/10/04/23/52/cow-1715829_960_720.jpg",
            "https://cdn.pixabay.com/photo/2012/04/24/16/27/chicken-40335_960_720.png",
            "https://cdn.pixabay.com/photo/2014/07/10/17/17/bedroom-389254_960_720.jpg"
    };

    String[] topics = {"Exchanging basic information", "Fruits and Colors",
            "Personal Data", "Places", "My Home",
            "Parts of the House" ,"Parts of the House", "Parts of the House", "Parts of the House", "Farm animals",
    "Farm animals", "Farm animals", "Parts of the House"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);


        TextView wordView = (TextView) findViewById(R.id.word);
        TextView scoreText = (TextView) findViewById(R.id.score);
        hint = (TextView) findViewById(R.id.hint);
        image = (ImageView) findViewById(R.id.imageHint);

        category = (TextView) findViewById(R.id.category);

        setHintText(current_game.wordToGuess.return_raw_word());


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

        setHintText(current_game.wordToGuess.return_raw_word());
    }

    public void setHintText(String s){
        switch (s) {
            case "directions":
                hint.setText("You ask for this if you don't know where to go");
                image.setImageResource(R.drawable.directions);
                category.setText(topics[0]);
                break;
            case "orange":
                hint.setText("Color of this fruit");
                image.setImageResource(R.drawable.orange);
                category.setText(topics[1]);
                break;
            case "birthday":
                    hint.setText("Happy ________! Congratulations!");
                image.setImageResource(R.drawable.birthday);
                category.setText(topics[2]);
                break;
            case "beach":
                hint.setText("Place with sand, sun,  and water where you go on vacations");
                image.setImageResource(R.drawable.beach);
                category.setText(topics[3]);
                break;
            case "house":
                hint.setText("Place where you live");
                image.setImageResource(R.drawable.house);
                category.setText(topics[4]);
                break;
            case "window":
                hint.setText("Part of the house for admission of light and air");
                image.setImageResource(R.drawable.window);
                category.setText(topics[5]);
                break;
            case "door":
                hint.setText("Open the ____");
                image.setImageResource(R.drawable.door);
                category.setText(topics[6]);
                break;
            case "couch":
                hint.setText("Long piece of furniture for several people to sit on");
                image.setImageResource(R.drawable.couch);
                category.setText(topics[7]);
                break;
            case "chair":
                hint.setText("a seat for one person");
                image.setImageResource(R.drawable.chair);
                category.setText(topics[8]);
                break;
            case "pig":
                hint.setText("Oink!");
                image.setImageResource(R.drawable.pig2);
                category.setText(topics[9]);
                break;
            case "cow":
                hint.setText("Moo!");
                image.setImageResource(R.drawable.cow2);
                category.setText(topics[10]);
                break;
            case "chicken":
                hint.setText("Farm animal that gives eggs");
                image.setImageResource(R.drawable.chicken2);
                category.setText(topics[11]);
                break;
            case "bedroom":
                hint.setText("Place where you sleep");
                image.setImageResource(R.drawable.bedroom);
                category.setText(topics[12]);
                break;
            default: hint.setText("");
                break;
        }
    }


}
