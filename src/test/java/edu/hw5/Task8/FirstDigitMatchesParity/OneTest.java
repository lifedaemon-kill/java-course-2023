package edu.hw5.Task8.FirstDigitMatchesParity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task8Special.RegularExpressions.isFirstDigitMatchesParity;
import static org.assertj.core.api.Assertions.assertThat;

public class OneTest {
    //начинается с 0 и имеет нечетную длину(НЕ делится на два)
    //начинается с 1 и имеет четную длину(делится на два)
    @Test
    @DisplayName("Верно для единицы (11)")
    void test1() {
        String number = "11";

        boolean result = isFirstDigitMatchesParity(number);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верно для единицы (1010)")
    void test2() {
        String number = "1010";

        boolean result = isFirstDigitMatchesParity(number);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верно для единицы (101111)")
    void test3() {
        String number = "101111";

        boolean result = isFirstDigitMatchesParity(number);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Не верно для единицы (101)")
    void test4() {
        String number = "101";

        boolean result = isFirstDigitMatchesParity(number);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Не верно для единицы (10112)")
    void test5() {
        String number = "10112";

        boolean result = isFirstDigitMatchesParity(number);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Не верно для единицы (пусто)")
    void test6() {
        String number = "";

        boolean result = isFirstDigitMatchesParity(number);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Не верно для единицы (01231)")
    void test7() {
        String number = "01231";

        boolean result = isFirstDigitMatchesParity(number);

        assertThat(result).isFalse();
    }
}
