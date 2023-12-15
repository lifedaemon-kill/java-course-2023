package edu.project3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.log4j.Log4j2;
import static edu.project3.LogReport.writeType.ADOC;
import static edu.project3.LogReport.writeType.MARKDOWN;

@Log4j2
public class LogReport {
    private LogReport() {
    }

    enum writeType {MARKDOWN, ADOC}

    private final static String prefix = "/log-report_";
    private final static Map<writeType, String> postfix = new HashMap<>();

    static {
        postfix.put(MARKDOWN, ".md");
        postfix.put(ADOC, ".adoc");
    }

    public static void markdown(String text) {
        write(text, MARKDOWN);
    }

    public static void adoc(String text) {
        write(text, ADOC);
    }

    public static void write(String text, writeType type) {
        Instant instant = Instant.now();
        Path path = Paths.get(prefix + instant + postfix.get(type));

        try {
            byte[] bs = text.getBytes();
            Files.write(path, bs);
        } catch (Exception e) {
            log.error(e.getStackTrace());
        }
    }

    public static void console(String text) {
        System.out.println(text);
    }
}
