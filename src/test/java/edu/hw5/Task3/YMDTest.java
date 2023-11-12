package edu.hw5.Task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static edu.hw5.Task3.ParseDate.parseDate;
import static org.assertj.core.api.Assertions.assertThat;

public class YMDTest {
    @Test
    @DisplayName("Корректные значения yyyy-mm-dd")
    void test1() {
        Optional<LocalDate> excepted = Optional.of(LocalDate.of(1925, 3, 15));

        Optional<LocalDate> result = parseDate("1925-3-15");

        assertThat(result).isEqualTo(excepted);
    }
    @Test
    @DisplayName("Некорректные значения(День больше чем может быть)")
    void test2() {
        Optional<LocalDate> result = parseDate("1925-3-32");

        assertThat(result).isEmpty();
    }
    @Test
    @DisplayName("Некорректные значения(Месяц больше чем может быть)")
    void test3() {
        Optional<LocalDate> result = parseDate("1925-13-1");

        assertThat(result).isEmpty();
    }
    @Test
    @DisplayName("Некорректные значения(Отрицательный день)")
    void test4() {
        Optional<LocalDate> result = parseDate("1925-3--15");

        assertThat(result).isEmpty();
    }
}
