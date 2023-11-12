package edu.hw5.Task8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static edu.hw5.Task8Special.RegularExpressions.isCountOfZerosIsMultipleOfThree;
import static org.assertj.core.api.Assertions.assertThat;

public class CountOfZerosIsMultipleOfThreeTest {
    @Test
    @DisplayName("Верная последовательность (10001)")
    void test1() {
        boolean result = isCountOfZerosIsMultipleOfThree("10001");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (01010)")
    void test2() {
        boolean result = isCountOfZerosIsMultipleOfThree("01010");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (000111)")
    void test3() {
        boolean result = isCountOfZerosIsMultipleOfThree("000111");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (000111000)")
    void test4() {
        boolean result = isCountOfZerosIsMultipleOfThree("000111000");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (101010111010101)")
    void test5() {
        boolean result = isCountOfZerosIsMultipleOfThree("101010111010101");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (11101111011101111111011101101110101011)")
    void test6() {
        boolean result = isCountOfZerosIsMultipleOfThree("11101111011101111111011101101110101011");
        assertThat(result).isTrue();
    }
    @Test
    @DisplayName("Неверная последовательность (100100)")
    void test7() {
        boolean result = isCountOfZerosIsMultipleOfThree("100100");
        assertThat(result).isFalse();
    }
    @Test
    @DisplayName("Неверная последовательность (100100010001)")
    void test8() {
        boolean result = isCountOfZerosIsMultipleOfThree("100100010001");
        assertThat(result).isFalse();
    }
    @Test
    @DisplayName("Неверная последовательность (0)")
    void test9() {
        boolean result = isCountOfZerosIsMultipleOfThree("0");
        assertThat(result).isFalse();
    }
    @Test
    @DisplayName("Неверная последовательность (0000)")
    void test10() {
        boolean result = isCountOfZerosIsMultipleOfThree("0000");
        assertThat(result).isFalse();
    }
    @Test
    @DisplayName("Неверная последовательность (00010)")
    void test11() {
        boolean result = isCountOfZerosIsMultipleOfThree("00010");
        assertThat(result).isFalse();
    }
}
