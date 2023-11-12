package edu.hw5.Task3;

import edu.hw5.Task3.Parsers.DMYWithSlashParser;
import edu.hw5.Task3.Parsers.DateAsWordParser;
import edu.hw5.Task3.Parsers.DayAgoParser;
import edu.hw5.Task3.Parsers.YMDWithDashParser;
import java.time.LocalDate;
import java.util.Optional;

public class ParseDate {
    private ParseDate() {
    }

    /*

    1/3/1976
    1/3/20
     */
    public static Optional<LocalDate> parseDate(String date) {
        AbstractParser parser = AbstractParser.link(
            new DateAsWordParser(),
            new DayAgoParser(),
            new DMYWithSlashParser(),
            new YMDWithDashParser()
        );

        LocalDate result = parser.check(date);
        if (result == null) {
            return Optional.empty();
        } else {
            return Optional.of(result);
        }
    }
}
