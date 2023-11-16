package edu.hw5.Task8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task8Special.RegularExpressions.isExcept11And111;
import static org.assertj.core.api.Assertions.assertThat;

public class Except11And111Test {
    @Test
    @DisplayName("Корректное значение 1")
    void test0() {
        String number = "1";
        boolean result = isExcept11And111(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Корректное значение 1111")
    void test1() {
        String number = "1111";
        boolean result = isExcept11And111(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Корректное значение 110")
    void test2() {
        String number = "110";
        boolean result = isExcept11And111(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Корректное значение 011")
    void test3() {
        String number = "110";
        boolean result = isExcept11And111(number);
        assertThat(result).isTrue();
    }
    @Test
    @DisplayName("Корректное значение 0111")
    void test4() {
        String number = "110";
        boolean result = isExcept11And111(number);
        assertThat(result).isTrue();
    }
    @Test
    @DisplayName("Корректное значение 1110")
    void test5() {
        String number = "1110";
        boolean result = isExcept11And111(number);
        assertThat(result).isTrue();
    }
    @Test
    @DisplayName("Корректное значение \" 111\"")
    void test6() {
        String number = " 111";
        boolean result = isExcept11And111(number);
        assertThat(result).isTrue();
    }
    @Test
    @DisplayName("Корректное значение \" 11 \"")
    void test7() {
        String number = " 11 ";
        boolean result = isExcept11And111(number);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Ошибка 11")
    void testError11() {
        String number = "11";
        boolean result = isExcept11And111(number);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Ошибка 111")
    void testError111() {
        String number = "111";
        boolean result = isExcept11And111(number);
        assertThat(result).isFalse();
    }
}
