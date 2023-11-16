package edu.hw5.Task8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task8Special.RegularExpressions.isEveryOddEqual1;
import static org.assertj.core.api.Assertions.assertThat;

public class EveryOddEqual1Test {
    @Test
    @DisplayName("Верное значение (01)")
    void test1() {
        String number = "01";
        boolean result = isEveryOddEqual1(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верное значение (0)")
    void test2() {
        String number = "0";
        boolean result = isEveryOddEqual1(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Верное значение (011101011101)")
    void test3() {
        String number = "011101011101";
        boolean result = isEveryOddEqual1(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Неверное значение (10)")
    void test4() {
        String number = "10";
        boolean result = isEveryOddEqual1(number);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Неверное значение (пусто)")
    void test5() {
        String number = "";
        boolean result = isEveryOddEqual1(number);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Неверное значение (1100)")
    void test6() {
        String number = "1100";
        boolean result = isEveryOddEqual1(number);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Неверное значение (11111110)")
    void test7() {
        String number = "11111110";
        boolean result = isEveryOddEqual1(number);
        assertThat(result).isFalse();
    }
}
