package edu.hw5.Task8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task8Special.RegularExpressions.isNotConsecutiveOnes;
import static org.assertj.core.api.Assertions.assertThat;

public class NotConsecutiveOnesTest {
    @Test
    @DisplayName("Верная последовательность (1)")
    void test1() {
        String number = "1";
        boolean result = isNotConsecutiveOnes(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (101)")
    void test2() {
        String number = "101";
        boolean result = isNotConsecutiveOnes(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (1001)")
    void test3() {
        String number = "1001";
        boolean result = isNotConsecutiveOnes(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (000000001001000001010100000000000001)")
    void test4() {
        String number = "000000001001000001010100000000000001";
        boolean result = isNotConsecutiveOnes(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Неверная последовательность (11)")
    void test5() {
        String number = "11";
        boolean result = isNotConsecutiveOnes(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Неверная последовательность (010011)")
    void test6() {
        String number = "010011";
        boolean result = isNotConsecutiveOnes(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Неверная последовательность (0110011101)")
    void test7() {
        String number = "0110011101";
        boolean result = isNotConsecutiveOnes(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Неверная последовательность (пусто)")
    void test8() {
        String number = "";
        boolean result = isNotConsecutiveOnes(number);
        assertThat(result).isTrue();
    }
}
