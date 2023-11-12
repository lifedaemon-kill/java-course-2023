package edu.hw5.Task8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task8Special.RegularExpressions.isOddLength;
import static org.assertj.core.api.Assertions.assertThat;

public class OddTest {
    @Test
    @DisplayName("Нечетное число 1")
    void test1() {
        boolean result = isOddLength("010");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Нечетное число 2")
    void test2() {
        boolean result = isOddLength("10101");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Нечетное число 3")
    void test3() {
        boolean result = isOddLength("11111");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Четное число цифр 1")
    void test4() {
        boolean result = isOddLength("111111");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Четное число цифр 2")
    void test5() {
        boolean result = isOddLength("11");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Неверное число")
    void test6() {
        boolean result = isOddLength("121");
        assertThat(result).isFalse();
    }
}
