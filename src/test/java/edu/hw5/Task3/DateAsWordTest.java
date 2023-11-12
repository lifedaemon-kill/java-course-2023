package edu.hw5.Task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static edu.hw5.Task3.ParseDate.parseDate;
import static org.assertj.core.api.Assertions.assertThat;

public class DateAsWordTest {
    @Test
    @DisplayName("На входе словесное обозначение дней")
    void test1() {
        String[] dates = {"today", "tomorrow", "yesterday"};

        List<Optional<LocalDate>> excepted = new ArrayList<>();
        excepted.add(Optional.of(LocalDate.now()));
        excepted.add(Optional.of(LocalDate.now().plusDays(1)));
        excepted.add(Optional.of(LocalDate.now().minusDays(1)));

        List<Optional<LocalDate>> answer = new ArrayList<>();
        for (String date : dates) {
            answer.add(parseDate(date));
        }

        assertThat(answer).isEqualTo(excepted);
    }
}
