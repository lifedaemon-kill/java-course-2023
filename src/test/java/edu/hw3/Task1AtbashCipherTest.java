package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static edu.hw3.Task1.AtbashCipher.*;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1AtbashCipherTest {

    @Test
    @DisplayName("Correct string")
    void test1() {
        // Arrange
        String request = "Hello world!";
        String expected = "Svool dliow!";
        // Act
        String ciphered = atbash(request);
        // Assert
        assertThat(ciphered).isEqualTo(expected);
    }

    @Test
    @DisplayName("Long string with special symbols")
    void test2() {
        // Arrange
        String request =
            "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler";
        String expected =
            "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";
        // Act
        String ciphered = atbash(request);
        // Assert
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
    @DisplayName("Is English Low work right")
    @MethodSource("validLowLetters")
    void test3(Character letter) {
        // Arrange

        // Act
        boolean result = isEnglishLow(letter);
        // Assert
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Is English High work right")
    @MethodSource("validHighLetters")
    void test4(Character letter) {
        // Arrange

        // Act
        boolean result = isEnglishHigh(letter);
        // Assert
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @DisplayName("IsEnglish Low and High receive invalid characters")
    @MethodSource("invalidLetters")
    void test5(Character letter) {
        // Arrange

        // Act
        boolean resultHigh = isEnglishHigh(letter);
        boolean resultLow = isEnglishLow(letter);

        // Assert
        assertThat(resultHigh).isFalse();
        assertThat(resultLow).isFalse();
    }
}
