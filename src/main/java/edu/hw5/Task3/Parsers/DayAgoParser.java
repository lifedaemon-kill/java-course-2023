package edu.hw5.Task3.Parsers;

import edu.hw5.Task3.AbstractParser;
import java.time.LocalDate;

public class DayAgoParser extends AbstractParser {
    @Override
    public LocalDate check(String date) {
        String[] split = date.split(" ");
        if (split.length != 3
            || (!split[1].equals("day") && !split[1].equals("days"))
            || !split[2].equals("ago")) {
            return checkNext(date);
        }
        long day;
        try {
            day = Long.parseUnsignedLong(split[0]);
        }
        catch (NumberFormatException e){
            return checkNext(date);
        }

        return LocalDate.now().minusDays(day);
    }
}
