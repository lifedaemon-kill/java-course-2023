package edu.hw5.Task3.Parsers;

import edu.hw5.Task3.AbstractParser;
import java.time.LocalDate;
import static edu.hw5.Task3.ParsingConstants.COUNT_OF_DAYS_AGO_PARTS;

public class DayAgoParser extends AbstractParser {
    @Override
    public LocalDate check(String date) {
        String[] split = date.split(" ");

        if (COUNT_OF_DAYS_AGO_PARTS != split.length
            || (!"day".equals(split[1]) && !"days".equals(split[1]))
            || (!"ago".equals(split[2]))) {
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
