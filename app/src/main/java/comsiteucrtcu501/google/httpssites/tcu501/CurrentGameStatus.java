package comsiteucrtcu501.google.httpssites.tcu501;

/**
 * Created by oscar on 06/07/17.
 */

public class CurrentGameStatus {

    public static Score score;
    public static WordToGuess wordToGuess;

    CurrentGameStatus(){
        score = new Score();
        wordToGuess = new WordToGuess(GenerateWord.generate());
    }

    int get_score(){
        return score.return_score();
    }

    String get_raw_word(){
        return wordToGuess.return_raw_word();
    }

    String get_display_word(){
        return wordToGuess.display_word();
    }

    boolean try_to_insert_letter(String guessed_letter) {
        if (wordToGuess.letter_belongs_to_word(guessed_letter) && !wordToGuess.letter_already_in_word(guessed_letter)) {
            wordToGuess.insert_letter(guessed_letter);
            score.update_score_correct_letter();
            return true;
        } else {
            score.update_score_incorrect_letter();
            return false;
        }
    }

    boolean word_completed(){
        return wordToGuess.word_completed();
    }
}