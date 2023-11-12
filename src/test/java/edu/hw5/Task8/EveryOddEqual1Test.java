package edu.hw5.Task8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task8Special.RegularExpressions.isEveryOddEqual1;
import static org.assertj.core.api.Assertions.assertThat;

public class EveryOddEqual1Test {
    @Test
    @DisplayName("Верное значение (01)")
    void test1() {
        boolean result = isEveryOddEqual1("01");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верное значение (0)")
    void test2() {
        boolean result = isEveryOddEqual1("0");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верное значение (011101011101)")
    void test3() {
        boolean result = isEveryOddEqual1("011101011101");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Неверное значение (10)")
    void test4() {
        boolean result = isEveryOddEqual1("10");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Неверное значение (пусто)")
    void test5() {
        boolean result = isEveryOddEqual1("");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Неверное значение (1100)")
    void test6() {
        boolean result = isEveryOddEqual1("1100");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Неверное значение (11111110)")
    void test7() {
        boolean result = isEveryOddEqual1("11111110");
        assertThat(result).isFalse();
    }
}
