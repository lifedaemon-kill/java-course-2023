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
        boolean result = isFirstDigitMatchesParity("11");
        assertThat(result).isTrue();
    }
    @Test
    @DisplayName("Верно для единицы (1010)")
    void test2() {
        boolean result = isFirstDigitMatchesParity("1010");
        assertThat(result).isTrue();
    }
    @Test
    @DisplayName("Верно для единицы (101111)")
    void test3() {
        boolean result = isFirstDigitMatchesParity("101111");
        assertThat(result).isTrue();
    }
    @Test
    @DisplayName("Не верно для единицы (101)")
    void test4() {
        boolean result = isFirstDigitMatchesParity("101");
        assertThat(result).isFalse();
    }
    @Test
    @DisplayName("Не верно для единицы (10112)")
    void test5() {
        boolean result = isFirstDigitMatchesParity("10112");
        assertThat(result).isFalse();
    }
    @Test
    @DisplayName("Не верно для единицы (пусто)")
    void test6() {
        boolean result = isFirstDigitMatchesParity("");
        assertThat(result).isFalse();
    }
    @Test
    @DisplayName("Не верно для единицы (01231)")
    void test7() {
        boolean result = isFirstDigitMatchesParity("01231");
        assertThat(result).isFalse();
    }
}
