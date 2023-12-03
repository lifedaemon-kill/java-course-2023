package edu.hw5.Task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static edu.hw5.Task3.ParseDate.parseDate;
import static org.assertj.core.api.Assertions.assertThat;

public class DayAgoTest {
    @Test
    @DisplayName("Вид конструкции с day (1 day ago)")
    void test1() {
        Optional<LocalDate> excepted = Optional.of(LocalDate.now().minusDays(1));

        Optional<LocalDate> result = parseDate("1 day ago");

        assertThat(result).isEqualTo(excepted);
    }
    @Test
    @DisplayName("Вид конструкции с days (2234 days ago)")
    void test2() {
        Optional<LocalDate> excepted = Optional.of(LocalDate.now().minusDays(2234));

        Optional<LocalDate> result = parseDate("2234 days ago");

        assertThat(result).isEqualTo(excepted);
    }
}
