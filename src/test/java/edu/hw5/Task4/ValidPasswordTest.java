package edu.hw5.Task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidPasswordTest {
    //~ ! @ # $ % ^ & * | хотя бы один из этих символов должен быть
    @Test
    @DisplayName("Строка содержит 1 спец символ")
    void test1() {
        String pass = "Hello World!";

        boolean result = ValidPassword.isPasswordHaveSpecSymbol(pass);

        assertThat(result).isTrue();
    }
    @Test
    @DisplayName("Строка содержит несколько спец символов")
    void test2() {
        String pass = "#Hello%world~";

        boolean result = ValidPassword.isPasswordHaveSpecSymbol(pass);

        assertThat(result).isTrue();
    }
    @Test
    @DisplayName("Строка не содержит спец символы")
    void test3() {
        String pass = "Hello world";

        boolean result = ValidPassword.isPasswordHaveSpecSymbol(pass);

        assertThat(result).isFalse();
    }
}
