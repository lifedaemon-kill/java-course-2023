package edu.project1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

final class GameMethods {
    private GameMethods() {
    }

    private static final Random RANDOM = new Random();
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int MIN_WORD_LENGTH = 3;

    public static String initWord(String[] words) {
        String word = words[RANDOM.nextInt(words.length)];
        if (word.length() < MIN_WORD_LENGTH) {
            return "-1";
        } else {
            return word;
        }
    }

    public static String getHideWord(String word, boolean[] openLetters) {
        StringBuilder wordBuild = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (openLetters[i] || word.charAt(i) == ' ') {
                wordBuild.append(word.charAt(i));
            } else {
                wordBuild.append("*");
            }
        }
        return wordBuild.toString();
    }

    public static boolean isLetterValid(String letter) {
        if (letter.length() != 1) {
            return false;
        }
        return letter.charAt(0) >= 'a' && letter.charAt(0) <= 'z';
    }

    public static boolean isGameWon(String word, boolean[] openLetters) {
        for (int i = 0; i < word.length(); i++) {
            if (!openLetters[i] && word.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static void printMessage(String[] object) {
        LOGGER.info(object[RANDOM.nextInt(object.length)]);
    }

    public static HashMap<Character, ArrayList<Integer>> getDictionary(String word) {
        char[] wordChars = word.toCharArray();
        var letters = new HashMap<Character, ArrayList<Integer>>();
        for (int i = 0; i < wordChars.length; i++) {
            var key = wordChars[i];

            if (!letters.containsKey(key)) {
                letters.put(key, new ArrayList<>());
            }
            letters.get(key).add(i);
        }
        return letters;
    }

    public static boolean triesOver(int tries, String[] object1, String[] object2) {
        if (tries <= 0) {
            GameMethods.printMessage(object1);
            return true;
        } else {
            GameMethods.printMessage(object2);
            LOGGER.info(tries + " tries left");
            return false;
        }
    }
}
