package edu.hw5.Task8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task8Special.RegularExpressions.isCountOfZerosIsMultipleOfThree;
import static org.assertj.core.api.Assertions.assertThat;

public class CountOfZerosIsMultipleOfThreeTest {
    @Test
    @DisplayName("Верная последовательность (10001)")
    void test1() {
        String number = "10001";
        boolean result = isCountOfZerosIsMultipleOfThree(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (01010)")
    void test2() {
        String number = "01010";
        boolean result = isCountOfZerosIsMultipleOfThree(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (000111)")
    void test3() {
        String number = "000111";
        boolean result = isCountOfZerosIsMultipleOfThree(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (000111000)")
    void test4() {
        String number = "000111000";
        boolean result = isCountOfZerosIsMultipleOfThree(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (101010111010101)")
    void test5() {
        String number = "101010111010101";
        boolean result = isCountOfZerosIsMultipleOfThree(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (11101111011101111111011101101110101011)")
    void test6() {
        String number = "11101111011101111111011101101110101011";
        boolean result = isCountOfZerosIsMultipleOfThree(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Неверная последовательность (100100)")
    void test7() {
        String number = "100100";
        boolean result = isCountOfZerosIsMultipleOfThree(number);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Неверная последовательность (100100010001)")
    void test8() {
        String number = "100100010001";
        boolean result = isCountOfZerosIsMultipleOfThree(number);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Неверная последовательность (0)")
    void test9() {
        String number = "0";
        boolean result = isCountOfZerosIsMultipleOfThree(number);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Неверная последовательность (0000)")
    void test10() {
        String number = "0000";
        boolean result = isCountOfZerosIsMultipleOfThree(number);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Неверная последовательность (00010)")
    void test11() {
        String number = "00010";
        boolean result = isCountOfZerosIsMultipleOfThree(number);
        assertThat(result).isFalse();
    }
}
