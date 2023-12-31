package edu.project3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LogReport {
    private LogReport() {
    }

    private static final String MAIN_DIR = "src/test/java/edu/project3/reports";
    private static final String PREFIX = "/log-report_";
    private static final Map<String, String> POSTFIX = new HashMap<>();

    static {
        POSTFIX.put("markdown", ".md");
        POSTFIX.put("adoc", ".adoc");
    }

    public static void write(String text, String type) {
        if (Objects.equals(type, "console")) {
            log.info(String.format("\n%s", text));
            return;
        }

        OffsetDateTime now = OffsetDateTime.parse(Instant.now().toString());
        var time = now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy_hh.mm.ss"));

        Path path = Paths.get(MAIN_DIR + PREFIX + time + POSTFIX.get(type));

        try {
            byte[] bs = text.getBytes();
            Files.write(path, bs);
        } catch (Exception e) {
            log.error(e.getStackTrace());
        }
    }
}
