package edu.hw5.Task8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task8Special.RegularExpressions.isOddLength;
import static org.assertj.core.api.Assertions.assertThat;

public class OddTest {
    @Test
    @DisplayName("Нечетное число 1")
    void test1() {
        String number = "010";
        boolean result = isOddLength(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Нечетное число 2")
    void test2() {
        String number = "10101";
        boolean result = isOddLength(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Нечетное число 3")
    void test3() {
        String number = "11111";
        boolean result = isOddLength(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Четное число цифр 1")
    void test4() {
        String number = "111111";
        boolean result = isOddLength(number);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Четное число цифр 2")
    void test5() {
        String number = "11";
        boolean result = isOddLength(number);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Неверное число")
    void test6() {
        String number = "121";
        boolean result = isOddLength(number);
        assertThat(result).isFalse();
    }
}
