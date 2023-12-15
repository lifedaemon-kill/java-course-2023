package edu.project3;

import java.util.List;
import java.util.logging.LogRecord;
import java.util.stream.Stream;
import static edu.project3.FileRequest.getLogsFromPaths;

@SuppressWarnings("RegexpSinglelineJava")
public class NGINXLogStats {
    private NGINXLogStats() {
    }

    private final static String HELP =
        """
            ████████████████▀█████████████████████████████████████████████████████
            █▄─▄███─▄▄─█─▄▄▄▄████▀▄─██▄─▀█▄─▄██▀▄─██▄─▄███▄─█─▄█░▄▄░▄█▄─▄▄─█▄─▄▄▀█
            ██─██▀█─██─█─██▄─████─▀─███─█▄▀─███─▀─███─██▀██▄─▄███▀▄█▀██─▄█▀██─▄─▄█
            ▀▄▄▄▄▄▀▄▄▄▄▀▄▄▄▄▄▀▀▀▄▄▀▄▄▀▄▄▄▀▀▄▄▀▄▄▀▄▄▀▄▄▄▄▄▀▀▄▄▄▀▀▄▄▄▄▄▀▄▄▄▄▄▀▄▄▀▄▄▀

            The program calculates statistics for NGINX logs
            You can use parameters:

            \t--path\tRequired: You can specify the path to one or more(use spaces)
            \t      \t          NGINX log files as a local template or URL

            \t--from\tOptional: Filter for start date. Use ISO8601 format.
            \t      \t          Not used by default

            \t--to\tOptional: Filter for end date. Use ISO8601 format. Not used by default

            \t--format\tOptional: Can be markdown, adoc or by default use console
            """;

    public static void getHelp() {
        System.out.println(HELP);
    }

    public static void main(String[] args) {
        if (args.length == 2 && "-h".equals(args[1])) {
            getHelp();
            return;
        }
        try {
            LogRequest request = new LogRequest(args);

            System.out.println("Start of program execution");

            List<NGINXLog> log = getLogsFromPaths(request);

            Stream<LogRecord> logRecordStream;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n\nShutting down the program");
    }
}
