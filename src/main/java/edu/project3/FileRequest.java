package edu.project3;

import lombok.extern.log4j.Log4j2;
import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Log4j2
public class FileRequest {
    private FileRequest() {
    }

    static boolean isPathOrURL(String[] args, int i) {
        boolean flag = false;
        try {
            File file = new File(args[i + 1]);
            flag = true;
        } catch (Exception ignored) {
        }
        try {
            URL url = new URL(args[i + 1]);
            flag = true;
        } catch (Exception ignored) {
        }
        return flag;
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

    public static List<NGINXLog> getLogsFromPaths(LogRequest request) {
        List<NGINXLog> logList = new ArrayList<>();
        String logText = getTextFromPaths(request.path);

        Scanner scanner = new Scanner(logText);
        String input = "int - int [data data date] \"data data\"";

        String pattern = " - | \\[|]| \"";
        Pattern regexPattern = Pattern.compile(pattern);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Разбиваем строку по паттерну
            String[] tokens = regexPattern.split(line);

        }

        scanner.close();

        return logList;
    }
}
