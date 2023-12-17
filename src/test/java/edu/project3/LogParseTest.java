package edu.project3;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.project3.AppArgs.getArgs;
import static edu.project3.FileRequest.getTextFromPaths;
import static edu.project3.LogParser.parseLogs;
import static edu.project3.LogParser.parseLogsFromTo;
import static org.assertj.core.api.Assertions.assertThat;

public class LogParseTest {
    @Test
    void test1() {
        String input =
            "93.180.71.3 - mrLogger [17/May/2015:08:05:32 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 0 \"htttp refer\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"\n"
            +
            "93.180.71.3 - - [17/May/2015:08:05:23 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"\n";

        List<LogRecord> logs = parseLogs(input);
        for (var log : logs) {
            System.out.println(log);
        }
    }

    @Test
    void test2() {
        List<String> path = new ArrayList<>();
        path.add("src/test/java/edu/project3/files/small2-log.txt");
        path.add("src/test/java/edu/project3/files/small-log.txt");
        String result = getTextFromPaths(path);

        List<LogRecord> logs = parseLogs(result);
        for (var log : logs) {
            System.out.println(log);
        }
    }
    @Test
    @DisplayName("From и To работают корректно")
    void test3() throws Exception {
        String[] args = "--from 2015-05-17T08:05:10+00:00 --to 2015-05-17T08:05:26+00:00 --path src/test/java/edu/project3/files/small2-log.txt"
            .split(" ");

        var args1 = getArgs(args);
        String text = getTextFromPaths(args1.path);
        var logs = parseLogsFromTo(text, args1.from, args1.to);

        for (var log : logs) {
            System.out.println(log);
        }
        assertThat(logs.size()).isEqualTo(2);
    }
}
