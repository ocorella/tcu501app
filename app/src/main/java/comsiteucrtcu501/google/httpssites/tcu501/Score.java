package comsiteucrtcu501.google.httpssites.tcu501;

/**
 * Created by oscar on 06/07/17.
 */

public class Score {

    static int score = 100;
    void update_score_by(int delta)
    {
        score += delta;
    }
    void update_score_correct_letter()
    {
        score += 10;
    }
    void update_score_incorrect_letter()
    {
        score -= 10;
    }
    int return_score()
    {
        return score;
    }
    Score(){
        score = 1000;
    }

}