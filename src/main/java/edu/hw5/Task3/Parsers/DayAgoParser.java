package edu.hw5.Task3.Parsers;

import edu.hw5.Task3.AbstractParser;
import java.time.LocalDate;
import static edu.hw5.Task3.ParsingConstants.COUNT_OF_DAYS_AGO_PARTS;

public class DayAgoParser extends AbstractParser {
    @Override
    public LocalDate check(String date) {
        String[] split = date.split(" ");
        if (split.length != COUNT_OF_DAYS_AGO_PARTS
            || (!split[1].equals("day") && !split[1].equals("days"))
            || !split[2].equals("ago")) {
            return checkNext(date);
        }
        long day;
        try {
            day = Long.parseUnsignedLong(split[0]);
        } catch (NumberFormatException e) {
            return checkNext(date);
        }

        return LocalDate.now().minusDays(day);
    }
}
