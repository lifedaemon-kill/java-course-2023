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
import static edu.project3.LogReport.writeType.ADOC;
import static edu.project3.LogReport.writeType.MARKDOWN;

@Log4j2
public class LogReport {
    private LogReport() {
    }

    enum writeType {MARKDOWN, ADOC}
    private final static String dir = "src/test/java/edu/project3/reports";
    private final static String prefix = "/log-report_";
    private final static Map<String, String> postfix = new HashMap<>();

    static {
        postfix.put("markdown", ".md");
        postfix.put("adoc", ".adoc");
    }

    public static void write(String text, String type) {
        if(Objects.equals(type, "console")){
            log.info("\n" + text);
            return;
        }

        OffsetDateTime now = OffsetDateTime.parse(Instant.now().toString());
        var time = now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy_hh.mm.ss"));

        Path path = Paths.get(dir + prefix + time + postfix.get(type));

        try {
            byte[] bs = text.getBytes();
            Files.write(path, bs);
        } catch (Exception e) {
            log.error(e.getStackTrace());
        }
    }
}
