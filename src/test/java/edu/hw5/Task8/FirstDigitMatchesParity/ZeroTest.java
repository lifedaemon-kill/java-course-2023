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
        boolean result = isFirstDigitMatchesParity("001");
        assertThat(result).isTrue();
    }
    @Test
    @DisplayName("Верно для нуля (0)")
    void test2() {
        boolean result = isFirstDigitMatchesParity("0");
        assertThat(result).isTrue();
    }
    @Test
    @DisplayName("Верно для нуля (01111)")
    void test3() {
        boolean result = isFirstDigitMatchesParity("01111");
        assertThat(result).isTrue();
    }
    @Test
    @DisplayName("Не верно для нуля (01)")
    void test4() {
        boolean result = isFirstDigitMatchesParity("01");
        assertThat(result).isFalse();
    }
    @Test
    @DisplayName("Не верно для нуля (0112)")
    void test5() {
        boolean result = isFirstDigitMatchesParity("0112");
        assertThat(result).isFalse();
    }
    @Test
    @DisplayName("Не верно для нуля (пусто)")
    void test6() {
        boolean result = isFirstDigitMatchesParity("");
        assertThat(result).isFalse();
    }
    @Test
    @DisplayName("Не верно для нуля (01231)")
    void test7() {
        boolean result = isFirstDigitMatchesParity("01231");
        assertThat(result).isFalse();
    }
}
