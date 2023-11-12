package edu.hw5.Task8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task8Special.RegularExpressions.isNotConsecutiveOnes;
import static org.assertj.core.api.Assertions.assertThat;

public class NotConsecutiveOnesTest {
    @Test
    @DisplayName("Верная последовательность (1)")
    void test1() {
        boolean result = isNotConsecutiveOnes("1");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (101)")
    void test2() {
        boolean result = isNotConsecutiveOnes("101");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (1001)")
    void test3() {
        boolean result = isNotConsecutiveOnes("1001");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (000000001001000001010100000000000001)")
    void test4() {
        boolean result = isNotConsecutiveOnes("000000001001000001010100000000000001");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Неверная последовательность (11)")
    void test5() {
        boolean result = isNotConsecutiveOnes("11");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Неверная последовательность (010011)")
    void test6() {
        boolean result = isNotConsecutiveOnes("010011");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Неверная последовательность (0110011101)")
    void test7() {
        boolean result = isNotConsecutiveOnes("0110011101");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Неверная последовательность (пусто)")
    void test8() {
        boolean result = isNotConsecutiveOnes("");
        assertThat(result).isTrue();
    }
}
