package edu.hw5.Task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Friday13 {
    private Friday13() {
    }

    public static List<LocalDate> getF13List(int year) {
        List<LocalDate> f13 = new ArrayList<>();

        for (int month = 1; month <= 12; month++) {
            LocalDate date = LocalDate.of(year, month, 13);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                f13.add(date);
            }
        }
        return f13;
    }

    public static LocalDate findNextF13(LocalDate date) {
        date = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));

        while (date.getDayOfMonth() != 13) {
            date = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
        return date;
    }
}
