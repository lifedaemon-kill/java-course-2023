package edu.hw5.Task1;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AverageTime {
    private AverageTime() {
    }

    final static long MINUTE_IN_SECONDS = 60;
    final static long HOUR_IN_SECONDS = 3600;

    public static String averageTime(List<String> twiceDates) {
        //если строка не валидна, то она не учитывается
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd, HH:mm");
        List<Duration> durationList = new ArrayList<>();
        String[] splitDate;

        for (String date : twiceDates) {
            try {
                splitDate = date.split(" - ");
                if (splitDate.length != 2) {
                    throw new Exception();
                }
                Date date1 = format.parse(splitDate[0]);
                Date date2 = format.parse(splitDate[1]);

                Instant instant1 = date1.toInstant();
                Instant instant2 = date2.toInstant();

                durationList.add(Duration.between(instant1, instant2));
            } catch (Exception ignored) {
            }
        }
        long average = (long) durationList.stream()
            .mapToLong(Duration::getSeconds)
            .average()
            .orElse(Double.NaN);

        long hour = average / HOUR_IN_SECONDS;
        long min = average / MINUTE_IN_SECONDS % MINUTE_IN_SECONDS;

        return String.format("%dч %dм", hour, min);
    }
}
