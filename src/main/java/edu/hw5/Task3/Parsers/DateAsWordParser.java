package edu.hw5.Task3.Parsers;

import edu.hw5.Task3.AbstractParser;
import java.time.LocalDate;
import java.util.Locale;

public class DateAsWordParser extends AbstractParser {
    @Override
    public LocalDate check(String date) {
        String copyDate = date.toLowerCase(Locale.ENGLISH);

        return switch (copyDate) {
            case "today" -> LocalDate.now();
            case "tomorrow" -> LocalDate.now().plusDays(1);
            case "yesterday" -> LocalDate.now().minusDays(1);
            default -> checkNext(date);
        };
    }
}
