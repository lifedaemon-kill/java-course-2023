package edu.project1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

final class Hangman {
    private Hangman() {
    }

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String[] WORDS = {"hello world",
        "hangman", "chessboard", "copybara"};
    private static final String[] HIT = {"Nice!", "Hit!", "Absolutely right!", "Good job!", "Perfect"};
    private static final String[] MISTAKE =
        {"So close", "Don't cry but it was wrong", "Missed", "Somewhere one kitten are upset"};
    private static final String[] LOSE =
        {"You lose, try again", "Don't cry, it was close",
            "Somewhere one thousand kittens are upset, you lose",
            "It's over, nothing personal"};
    private static final String[] WIN =
        {"You win, try again", "It was epic. You win",
            "Somewhere one billion kittens are happy. You win",
            "It's a big win. Nothing personal"};
    private static final String[] INCORRECT =
        {"Somewhere three kittens were upset. That is not English letter",
            "Are You kidding?", "Nice, you created the new letter, try again",
            "Bad joke", "Why You did this?", "Are You the Joker?"};

    private static final String WELCOME_MESSAGE =
        "╔╗╔╗╔╗╔═══╗╔╗──╔══╗╔══╗╔╗──╔╗╔═══╗───╔════╗╔══╗───╔╗╔╗╔══╗╔╗─╔╗╔═══╗╔╗──╔╗╔══╗╔╗─╔╗───╔═══╗╔══╗╔╗──╔╗╔═══╗╔╗\n"
        +
        "║║║║║║║╔══╝║║──║╔═╝║╔╗║║║──║║║╔══╝───╚═╗╔═╝║╔╗║───║║║║║╔╗║║╚═╝║║╔══╝║║──║║║╔╗║║╚═╝║───║╔══╝║╔╗║║║──║║║╔══╝║║\n"
        +
        "║║║║║║║╚══╗║║──║║──║║║║║╚╗╔╝║║╚══╗─────║║──║║║║───║╚╝║║╚╝║║╔╗─║║║╔═╗║╚╗╔╝║║╚╝║║╔╗─║───║║╔═╗║╚╝║║╚╗╔╝║║╚══╗║║\n"
        +
        "║║║║║║║╔══╝║║──║║──║║║║║╔╗╔╗║║╔══╝─────║║──║║║║───║╔╗║║╔╗║║║╚╗║║║╚╗║║╔╗╔╗║║╔╗║║║╚╗║───║║╚╗║║╔╗║║╔╗╔╗║║╔══╝╚╝\n"
        +
        "║╚╝╚╝║║╚══╗║╚═╗║╚═╗║╚╝║║║╚╝║║║╚══╗─────║║──║╚╝║───║║║║║║║║║║─║║║╚═╝║║║╚╝║║║║║║║║─║║───║╚═╝║║║║║║║╚╝║║║╚══╗╔╗\n"
        +
        "╚═╝╚═╝╚═══╝╚══╝╚══╝╚══╝╚╝──╚╝╚═══╝─────╚╝──╚══╝───╚╝╚╝╚╝╚╝╚╝─╚╝╚═══╝╚╝──╚╝╚╝╚╝╚╝─╚╝───╚═══╝╚╝╚╝╚╝──╚╝╚═══╝╚╝";

    private static final int TRIES = 10;

    public static int getTries() {
        return TRIES;
    }

    public static void start() {
        String word = GameMethods.initWord(WORDS);

        if (word.equals("-1")) {
            LOGGER.info("The word " + word + " is broken.\nCritical error. Shut down");
            return;
        }
        int tries = TRIES;
        boolean[] openLetters = new boolean[word.length()];
        HashMap<Character, ArrayList<Integer>> lettersDictionary = GameMethods.getDictionary(word);
        Scanner input = new Scanner(System.in);
        String letter;

        LOGGER.info("\n" + WELCOME_MESSAGE + "\nTry to guess the letters! And remember You have only "
                    + TRIES + " chances to mistake!\nWrite <exit> to finish early\nLet's start!");

        while (true) {
            LOGGER.info("The word: " + GameMethods.getHideWord(word, openLetters));
            LOGGER.info(">");
            letter = input.next().toLowerCase(Locale.ENGLISH);

            if (letter.equalsIgnoreCase("exit")) {
                LOGGER.info("Bye!");
                break;
            }
            if (GameMethods.isLetterValid(letter)) {
                char key = letter.charAt(0);

                if (lettersDictionary.containsKey(key)) {
                    for (var item : lettersDictionary.get(key)) {
                        openLetters[item] = true;
                    }
                    if (GameMethods.isGameWon(word, openLetters)) {
                        LOGGER.info("Word: " + GameMethods.getHideWord(word, openLetters));
                        GameMethods.printMessage(WIN);
                        break;

                    } else {
                        GameMethods.printMessage(HIT);
                    }
                } else {
                    if (GameMethods.triesOver(--tries, LOSE, MISTAKE)) {
                        break;
                    }
                }
            } else {
                if (GameMethods.triesOver(--tries, LOSE, INCORRECT)) {
                    break;
                }
            }
        }
    }
}
