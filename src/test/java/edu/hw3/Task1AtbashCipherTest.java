package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static edu.hw3.Task1AtbashCipher.atbash;
import static edu.hw3.Task1AtbashCipher.isEnglishHigh;
import static edu.hw3.Task1AtbashCipher.isEnglishLow;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1AtbashCipherTest {

    @Test
    @DisplayName("1 Тест с курса")
    void test1() {
        String request = "Hello world!";
        String expected = "Svool dliow!";

        String ciphered = atbash(request);

        assertThat(ciphered).isEqualTo(expected);
    }

    @Test
    @DisplayName("2 Тест с курса")
    void test2() {
        String request =
            "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler";
        String expected =
            "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";

        String ciphered = atbash(request);

        assertThat(ciphered).isEqualTo(expected);
    }

    static Arguments[] validLowLetters() {
        return new Arguments[] {
            Arguments.of('a'),
            Arguments.of('z'),
            Arguments.of('k'),
        };
    }

    static Arguments[] validHighLetters() {
        return new Arguments[] {
            Arguments.of('A'),
            Arguments.of('Z'),
            Arguments.of('K'),
        };
    }

    static Arguments[] invalidLetters() {
        return new Arguments[] {
            Arguments.of('-'),
            Arguments.of('ж'),
            Arguments.of(','),
            Arguments.of('2'),
            Arguments.of('?'),
            Arguments.of('\"'),
            Arguments.of('\'')
        };
    }

    @ParameterizedTest
    @DisplayName("Is English Low")
    @MethodSource("validLowLetters")
    void test3(Character letter) {
        assertThat(isEnglishLow(letter)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Is English High")
    @MethodSource("validHighLetters")
    void test4(Character letter) {
        assertThat(isEnglishHigh(letter)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Is invalid letters")
    @MethodSource("invalidLetters")
    void test5(Character letter) {
        assertThat(isEnglishHigh(letter)).isFalse();
        assertThat(isEnglishLow(letter)).isFalse();
    }
}
