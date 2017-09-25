package comsiteucrtcu501.google.httpssites.tcu501;

/**
 * Created by oscar on 06/07/17.
 */

import java.util.Random;

/**
 * Created by fernando on 11/13/14.
 */
public class GenerateWord {

    public static String generate()
    {
        String[] words = {"directions", "orange", "christmas", "birthday", "beach", "bedroom", "house", "window", "couch", "chair" };
        Random randomGenerator = new Random();
        randomGenerator.nextInt(words.length);
        return words[randomGenerator.nextInt(words.length)];
    }
}