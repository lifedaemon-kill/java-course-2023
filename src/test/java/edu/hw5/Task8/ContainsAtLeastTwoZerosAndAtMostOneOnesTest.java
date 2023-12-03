package edu.hw5.Task8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task8Special.RegularExpressions.isContainsAtLeastTwoZerosAndAtMostOneOnes;
import static org.assertj.core.api.Assertions.assertThat;

public class ContainsAtLeastTwoZerosAndAtMostOneOnesTest {
    @Test
    @DisplayName("Верная последовательность (001)")
    void test1() {
        String number = "001";
        boolean result = isContainsAtLeastTwoZerosAndAtMostOneOnes(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (010)")
    void test2() {
        String number = "010";
        boolean result = isContainsAtLeastTwoZerosAndAtMostOneOnes(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (0010)")
    void test3() {
        String number = "0010";
        boolean result = isContainsAtLeastTwoZerosAndAtMostOneOnes(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (00)")
    void test4() {
        String number = "00";
        boolean result = isContainsAtLeastTwoZerosAndAtMostOneOnes(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (000100)")
    void test5() {
        String number = "000100";
        boolean result = isContainsAtLeastTwoZerosAndAtMostOneOnes(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (00000)")
    void test6() {
        String number = "00000";
        boolean result = isContainsAtLeastTwoZerosAndAtMostOneOnes(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Неверная последовательность (10)")
    void test7() {
        String number = "10";
        boolean result = isContainsAtLeastTwoZerosAndAtMostOneOnes(number);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Неверная последовательность (1)")
    void test8() {
        String number = "1";
        boolean result = isContainsAtLeastTwoZerosAndAtMostOneOnes(number);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Неверная последовательность (110000)")
    void test9() {
        String number = "110000";
        boolean result = isContainsAtLeastTwoZerosAndAtMostOneOnes(number);
        assertThat(result).isFalse();
    }
}
