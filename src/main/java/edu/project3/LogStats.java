package edu.project3;

import java.util.List;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SuppressWarnings("RegexpSinglelineJava")
public class LogStats {
    private LogStats() {
    }

    private final static String HELP =
        """
            ████████████████▀█████████████████████████████████████████████████████
            █▄─▄███─▄▄─█─▄▄▄▄████▀▄─██▄─▀█▄─▄██▀▄─██▄─▄███▄─█─▄█░▄▄░▄█▄─▄▄─█▄─▄▄▀█
            ██─██▀█─██─█─██▄─████─▀─███─█▄▀─███─▀─███─██▀██▄─▄███▀▄█▀██─▄█▀██─▄─▄█
            █▄▄▄▄▄█▄▄▄▄█▄▄▄▄▄███▄▄█▄▄█▄▄▄██▄▄█▄▄█▄▄█▄▄▄▄▄██▄▄▄██▄▄▄▄▄█▄▄▄▄▄█▄▄█▄▄█
            ▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀
            The program calculates statistics for NGINX logs
            You can use parameters:

            \t--path  \tRequired: You can specify the path to one or more(use spaces)
            \t        \t          NGINX log files as a local template or URL

            \t--from  \tOptional: Filter for start date. Use ISO8601 format.


            \t--to    \tOptional: Filter for end date. Use ISO8601 format.


            \t--format\tOptional: Can be markdown, adoc or by default use console
            """;

    public static void getHelp() {
        log.info("\n" + HELP);
    }

    public static void runStats(String[] args) {
        if (args.length == 1 && "-h".equals(args[0])) {
            getHelp();
            return;
        }
        try {
            log.info("Start of program execution");
            //GET ARGS
            AppArgs request = AppArgs.getArgs(args);

            //GET TEXT FROM FILES/URLS
            String textLogs = FileRequest.getTextFromPaths(request.path);

            //GET LOGS
            List<LogRecord> logs = LogParser.parseLogsFromTo(textLogs, request.from, request.to);

            //DO STATS
            String result = LogAnalysisStream
                .createStream(logs)
                .generalInfo()
                .serverResponseCodes()
                .requestedResources()
                .httpAgents()
                .highLoad()
                .getText();

            //GET OUT
            LogReport.write(result, request.format);

        } catch (Exception e) {
            log.error(e.getMessage());
            log.error(e.getStackTrace());
        }

        log.info("Shutting down the program");
    }
}
