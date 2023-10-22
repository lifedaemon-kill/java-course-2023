package edu.hw3;

public class Task1AtbashCipher {
    private Task1AtbashCipher() {
    }

    public static boolean isEnglishLow(Character letter) {
        return (letter >= 'a' && letter <= 'z');
    }

    public static boolean isEnglishHigh(Character letter) {
        return (letter >= 'A' && letter <= 'Z');
    }

    public static String atbash(String text) {
        StringBuilder cipheredText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            Character letter = text.charAt(i);

            if (isEnglishLow(letter)) {
                cipheredText.append(Character.toString('a' + 'z' - letter));
            } else if (isEnglishHigh(letter)) {
                cipheredText.append(Character.toString('A' + 'Z' - letter));
            } else {
                cipheredText.append(letter);
            }
        }
        return cipheredText.toString();
    }
}
