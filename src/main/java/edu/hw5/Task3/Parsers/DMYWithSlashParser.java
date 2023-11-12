package edu.hw5.Task3.Parsers;

import edu.hw5.Task3.AbstractParser;
import java.time.DateTimeException;
import java.time.LocalDate;
import static edu.hw5.Task3.ParsingConstants.COUNT_OF_DMY_PARTS;

public class DMYWithSlashParser extends AbstractParser {
    @Override
    public LocalDate check(String date) {
        String[] split = date.split("/");
        if (split.length != COUNT_OF_DMY_PARTS) {
            return checkNext(date);
        }
        int day;
        int month;
        int year;
        LocalDate result;
        try {
            day = Integer.parseUnsignedInt(split[0]);
            month = Integer.parseUnsignedInt(split[1]);
            year = Integer.parseUnsignedInt(split[2]);

            result = LocalDate.of(year, month, day);

            return result;
        } catch (NumberFormatException | DateTimeException e) {
            return checkNext(date);
        }
    }
}

