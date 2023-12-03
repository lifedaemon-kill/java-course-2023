package edu.hw5.Task7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task7.Magic.isGreaterThen3DigitsAnd3ndIs0;
import static org.assertj.core.api.Assertions.assertThat;

public class GreaterThen3Test {
    @Test
    @DisplayName("Корректное значение 1")
    void test1() {
        String number = "0101";

        boolean result = isGreaterThen3DigitsAnd3ndIs0(number);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Корректное значение 2")
    void test2() {
        String number = "010";

        boolean result = isGreaterThen3DigitsAnd3ndIs0(number);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Не корректное значение (3 цифра не равна 0)")
    void test3() {
        String number = "0111";

        boolean result = isGreaterThen3DigitsAnd3ndIs0(number);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Не корректное значение (Посторонний символ)")
    void test4() {
        String number = "0102";

        boolean result = isGreaterThen3DigitsAnd3ndIs0(number);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Не корректное значение (Чисел меньше чем 3)")
    void test5() {
        String number = "01";

        boolean result = isGreaterThen3DigitsAnd3ndIs0(number);

        assertThat(result).isFalse();
    }
}
