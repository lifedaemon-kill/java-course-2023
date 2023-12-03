package edu.hw5.Task7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task7.Magic.isLengthBetween1And3;
import static org.assertj.core.api.Assertions.assertThat;

public class BetweenTest {
    @Test
    @DisplayName("Корректное значение 1 символ")
    void test1() {
        String value = "0";

        boolean result = isLengthBetween1And3(value);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Корректное значение (3 символа)")
    void test2() {
        String value = "010";

        boolean result = isLengthBetween1And3(value);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Корректное значение (2 символа)")
    void test3() {
        String value = "10";

        boolean result = isLengthBetween1And3(value);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Не корректное значение (Посторонний символ)")
    void test4() {
        String value = "002";

        boolean result = isLengthBetween1And3(value);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Не корректное значение (Чисел меньше больше чем 3)")
    void test5() {
        String value = "0101";

        boolean result = isLengthBetween1And3(value);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Не корректное значение (Чисел меньше больше чем 1)")
    void test6() {
        String value = "";

        boolean result = isLengthBetween1And3(value);

        assertThat(result).isFalse();
    }
}
