package edu.hw5.Task7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task7.Magic.isLengthBetween1And3;
import static org.assertj.core.api.Assertions.assertThat;

public class BetweenTest {
    @Test
    @DisplayName("Корректное значение 1 символ")
    void test1() {
        boolean result = isLengthBetween1And3("0");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Корректное значение (3 символа)")
    void test2() {
        boolean result = isLengthBetween1And3("010");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Корректное значение (2 символа)")
    void test3() {
        boolean result = isLengthBetween1And3("10");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Не корректное значение (Посторонний символ)")
    void test4() {
        boolean result = isLengthBetween1And3("002");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Не корректное значение (Чисел меньше больше чем 3)")
    void test5() {
        boolean result = isLengthBetween1And3("0101");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Не корректное значение (Чисел меньше больше чем 1)")
    void test6() {
        boolean result = isLengthBetween1And3("");
        assertThat(result).isFalse();
    }
}
