package edu.hw5.Task7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task7.Magic.isBeginAndEndIsTheSameSymbol;
import static org.assertj.core.api.Assertions.assertThat;

public class SameSymbolTest {
    @Test
    @DisplayName("Корректное значение 1")
    void test1() {
        String number = "01010";

        boolean result = isBeginAndEndIsTheSameSymbol(number);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Корректное значение 2")
    void test2() {
        String number = "11011";

        boolean result = isBeginAndEndIsTheSameSymbol(number);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Разные цифры")
    void test3() {
        String number = "110";

        boolean result = isBeginAndEndIsTheSameSymbol(number);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Некорректные символы")
    void test4() {
        String number = "01120";
        boolean result = isBeginAndEndIsTheSameSymbol(number);

        assertThat(result).isFalse();
    }
}
