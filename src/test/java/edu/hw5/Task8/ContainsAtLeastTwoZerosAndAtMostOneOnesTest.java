package edu.hw5.Task8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task8Special.RegularExpressions.isContainsAtLeastTwoZerosAndAtMostOneOnes;
import static org.assertj.core.api.Assertions.assertThat;

public class ContainsAtLeastTwoZerosAndAtMostOneOnesTest {
    @Test
    @DisplayName("Верная последовательность (001)")
    void test1() {
        boolean result = isContainsAtLeastTwoZerosAndAtMostOneOnes("001");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (010)")
    void test2() {
        boolean result = isContainsAtLeastTwoZerosAndAtMostOneOnes("010");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (0010)")
    void test3() {
        boolean result = isContainsAtLeastTwoZerosAndAtMostOneOnes("0010");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (00)")
    void test4() {
        boolean result = isContainsAtLeastTwoZerosAndAtMostOneOnes("00");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (000100)")
    void test5() {
        boolean result = isContainsAtLeastTwoZerosAndAtMostOneOnes("000100");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верная последовательность (00000)")
    void test6() {
        boolean result = isContainsAtLeastTwoZerosAndAtMostOneOnes("00000");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Неверная последовательность (10)")
    void test7() {
        boolean result = isContainsAtLeastTwoZerosAndAtMostOneOnes("10");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Неверная последовательность (1)")
    void test8() {
        boolean result = isContainsAtLeastTwoZerosAndAtMostOneOnes("1");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Неверная последовательность (110000)")
    void test9() {
        boolean result = isContainsAtLeastTwoZerosAndAtMostOneOnes("110000");
        assertThat(result).isFalse();
    }
}
