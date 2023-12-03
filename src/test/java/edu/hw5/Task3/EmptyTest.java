package edu.hw5.Task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static edu.hw5.Task3.ParseDate.parseDate;
import static org.assertj.core.api.Assertions.assertThat;

public class EmptyTest {
    @Test
    @DisplayName("Некорректные значения(Текст)")
    void test1() {
        String date = "Hello world";

        Optional<LocalDate> result = parseDate(date);

        assertThat(result).isEmpty();
    }
    @Test
    @DisplayName("Некорректные значения(Отсутствующий тип)")
    void test2() {
        String date = "10-10-2023";

        Optional<LocalDate> result = parseDate(date);

        assertThat(result).isEmpty();
    }
}
