package edu.hw5.Task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Friday13 {
    private Friday13() {
    }

    private static final int COUNT_OF_MONTHS = 12;
    private static final int SPECIAL_DAY = 13;

    public static List<LocalDate> getF13List(int year) {
        List<LocalDate> f13 = new ArrayList<>();

        for (int month = 1; month <= COUNT_OF_MONTHS; month++) {
            LocalDate date = LocalDate.of(year, month, SPECIAL_DAY);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                f13.add(date);
            }
        }
        return f13;
    }

    public static LocalDate findNextF13(LocalDate date) {
        LocalDate next = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));

        while (next.getDayOfMonth() != SPECIAL_DAY) {
            next = next.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
        return next;
    }
}
