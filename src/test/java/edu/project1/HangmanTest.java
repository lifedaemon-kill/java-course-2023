package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HangmanTest {
    @Test
    @DisplayName("Загадываемое слово имеет некорректную длину")
    void invalidWordLength() {
        String[] request = {"Ab", "", "a"};
        String answer;
        for (var item : request) {
            answer = GameMethods.initWord(new String[] {item});
            assertThat(answer).isEqualTo("-1");
        }
    }

    @Test
    @DisplayName("Валидность ввода")
    void inputValid() {
        String[] request = {"et", "e e", "ee", ""};
        for (var item : request) {
            var answer = GameMethods.isLetterValid(item);

            assertThat(answer).isFalse();
        }
    }

    @Test
    @DisplayName("Отображение скрытого слова")
    void hide() {
        String[] word = {"hello world", "test", "Tinkoff bank offer me"};
        String[] hide = {"***** *****", "****", "******* **** ***** **"};

        for (int i = 0; i < word.length; i++) {
            boolean[] status = new boolean[word[i].length()];

            var answer = GameMethods.getHideWord(word[i], status);

            assertThat(answer).isEqualTo(hide[i]);
        }
    }

    @Test
    @DisplayName("Буквы засчитывается")
    void dictionary() {
        String word = "hello world";
        var dictionaryLetter = GameMethods.getDictionary(word);

        for (int i = 0; i < word.length(); i++) {
            boolean answer = dictionaryLetter.containsKey(word.charAt(i));
            assertThat(answer).isTrue();
        }
    }

    @Test
    @DisplayName("Превышение попыток")
    void end() {
        String[] dummy = {""};
        int i = Hangman.getTries();
        for (; i > 0; i--) {
            assertThat(GameMethods.triesOver(i, dummy, dummy)).isFalse();
        }
        i -= 1;
        assertThat(GameMethods.triesOver(i, dummy, dummy)).isTrue();

    }
    @Test
    @DisplayName("Победа")
    void win() {
        String word = "hell";
        boolean[] status = {true, true, true, false};
        boolean answer = GameMethods.isGameWon(word, status);
        assertThat(answer).isFalse();

        status[3] = true;
        answer = GameMethods.isGameWon(word, status);
        assertThat(answer).isTrue();
    }
}
