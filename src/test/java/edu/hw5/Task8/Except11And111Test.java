package edu.hw5.Task8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task8Special.RegularExpressions.isExcept11And111;
import static org.assertj.core.api.Assertions.assertThat;

public class Except11And111Test {

    @Test
    @DisplayName("Корректное значение 1")
    void test1() {
        boolean result = isExcept11And111("11111");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Корректное значение 1")
    void test2() {
        boolean result = isExcept11And111("110");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Ошибка 11")
    void test3() {
        boolean result = isExcept11And111("11");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Ошибка 111")
    void test4() {
        boolean result = isExcept11And111("11");
        assertThat(result).isFalse();
    }
}
