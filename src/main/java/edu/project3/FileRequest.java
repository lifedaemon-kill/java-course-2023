package edu.project3;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class FileRequest {
    private FileRequest() {
    }

    public static String getTextFromPaths(List<String> path) {
        StringBuilder mergedContent = new StringBuilder();
        for (String item : path) {
            //File
            try {
                mergedContent.append(Files.walk(Paths.get(item))
                    .filter(Files::isRegularFile)
                    .flatMap(file -> {
                        try {
                            return Files.lines(file);
                        } catch (Exception e) {
                            log.error(e.getStackTrace());
                            return null;
                        }
                    })
                    .collect(Collectors.joining(System.lineSeparator()))
                );
            } catch (Exception ignored) {
            }
            //URL
            try {
                URL url = new URL(item);
                try (Scanner scanner = new Scanner(url.openStream(), StandardCharsets.UTF_8)) {
                    while (scanner.hasNextLine()) {
                        mergedContent.append(scanner.nextLine()).append("\n");
                    }
                }
            } catch (Exception ignored) {
            }
        }
        return mergedContent.toString();
    }
}
