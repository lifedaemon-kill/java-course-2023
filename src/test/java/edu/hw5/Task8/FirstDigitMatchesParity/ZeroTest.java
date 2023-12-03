package edu.hw5.Task8.FirstDigitMatchesParity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task8Special.RegularExpressions.isFirstDigitMatchesParity;
import static org.assertj.core.api.Assertions.assertThat;

public class ZeroTest {
    //начинается с 0 и имеет нечетную длину(НЕ делится на два)
    //начинается с 1 и имеет четную длину(делится на два)
    @Test
    @DisplayName("Верно для нуля (001)")
    void test1() {
        String number = "001";

        boolean result = isFirstDigitMatchesParity(number);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верно для нуля (0)")
    void test2() {
        String number = "0";

        boolean result = isFirstDigitMatchesParity(number);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верно для нуля (01111)")
    void test3() {
        String number = "01111";

        boolean result = isFirstDigitMatchesParity(number);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Не верно для нуля (01)")
    void test4() {
        String number = "01";

        boolean result = isFirstDigitMatchesParity(number);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Не верно для нуля (0112)")
    void test5() {
        String number = "0112";

        boolean result = isFirstDigitMatchesParity(number);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Не верно для нуля (пусто)")
    void test6() {
        String number = "";

        boolean result = isFirstDigitMatchesParity(number);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Не верно для нуля (01231)")
    void test7() {
        String number = "01231";

        boolean result = isFirstDigitMatchesParity(number);

        assertThat(result).isFalse();
    }
}
