package edu.hw5.Task7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task7.Magic.isBeginAndEndIsTheSameSymbol;
import static org.assertj.core.api.Assertions.assertThat;

public class SameSymbolTest {
    @Test
    @DisplayName("Корректное значение 1")
    void test1() {
        boolean result = isBeginAndEndIsTheSameSymbol("01010");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Корректное значение 2")
    void test2() {
        boolean result = isBeginAndEndIsTheSameSymbol("11011");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Разные цифры")
    void test3() {
        boolean result = isBeginAndEndIsTheSameSymbol("110");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Некорректные символы")
    void test4() {
        boolean result = isBeginAndEndIsTheSameSymbol("01120");
        assertThat(result).isFalse();
    }
}
