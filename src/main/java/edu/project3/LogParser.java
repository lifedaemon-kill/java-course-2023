package edu.project3;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class LogParser {
    private LogParser() {
    }

    public static List<LogRecord> parseLogsTo(String text, OffsetDateTime to) {
        return parseLogsFromTo(text, null, to);
    }

    public static List<LogRecord> parseLogsFrom(String text, OffsetDateTime from) {
        return parseLogsFromTo(text, from, null);
    }

    public static List<LogRecord> parseLogs(String text) {
        return parseLogsFromTo(text, null, null);
    }

    public static List<LogRecord> parseLogsFromTo(String text, OffsetDateTime from, OffsetDateTime to) {
        Scanner scanner = new Scanner(text);
        List<LogRecord> result = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
//ADDRESS
            int leftIndex = line.indexOf(" ");
            String address = line.substring(0, leftIndex);

//USERNAME
            int rightIndex = line.indexOf(" ", leftIndex + 3);
            String username = line.substring(leftIndex + 3, rightIndex);
//DATETIME
            leftIndex = line.indexOf("[") + 1;
            rightIndex = line.indexOf("]", leftIndex);
            String time = line.substring(leftIndex, rightIndex);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);

            OffsetDateTime offsetDateTime = OffsetDateTime.parse(time, formatter);
//FROM AND TO
            if (!((from == null || offsetDateTime.isAfter(from)) && (to == null || offsetDateTime.isBefore(to)))) {
                continue;
            }

//REQUEST
            leftIndex = line.indexOf("\"") + 1;
            rightIndex = line.indexOf("\"", leftIndex);
            String[] request = line.substring(leftIndex, rightIndex).split(" ");
            ServerRequestRecord serverRequest = new ServerRequestRecord(request[0], request[1], request[2]);
//RESPONSE
            leftIndex = line.indexOf(" ", rightIndex + 1) + 1;
            rightIndex = line.indexOf(" ", leftIndex);
            int response = Integer.parseInt(line.substring(leftIndex, rightIndex));
//BYTE
            leftIndex = rightIndex + 1;
            rightIndex = line.indexOf(" ", leftIndex);
            int b = Integer.parseInt(line.substring(leftIndex, rightIndex));
//HTTP REFERER
            leftIndex = line.indexOf("\"", rightIndex + 1) + 1;
            rightIndex = line.indexOf("\"", leftIndex);
            String http_referer = line.substring(leftIndex, rightIndex);
//HTTP USER AGENT
            leftIndex = line.indexOf("\"", rightIndex + 1) + 1;
            rightIndex = line.indexOf("\"", leftIndex);
            String http_user_agent = line.substring(leftIndex, rightIndex);

            result.add(new LogRecord(
                address,
                username,
                offsetDateTime,
                serverRequest,
                response,
                b,
                http_referer,
                http_user_agent
            ));
        }

        scanner.close();
        return result;
    }

}
