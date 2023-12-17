package edu.project3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AppArgs {
    public List<String> path = new ArrayList<>();
    public OffsetDateTime from;
    public OffsetDateTime to;
    public String format = CONSOLE;
    private final static String CONSOLE = "console";
    private final static String PATH_ARG = "--path";
    private final static String FROM_ARG = "--from";
    private final static String TO_ARG = "--to";
    private final static String FORMAT_ARG = "--format";
    private final static Set<String> KEYWORDS = Set.of(PATH_ARG, FROM_ARG, TO_ARG, FORMAT_ARG);
    private final static Set<String> OUTPUT_KEYWORDS = Set.of("adoc", CONSOLE, "markdown");

    private AppArgs() {
    }

    public static AppArgs getArgs(String[] args) throws Exception {
        if (("-h".equals(args[0])) || "--help".equals(args[0])) {
            return null;
        }
        AppArgs appArgs = new AppArgs();

        boolean fPath = false;
        boolean fPathNotEmpty = false;
        boolean fFromNotEmpty = false;
        boolean fToNotEmpty = false;
        boolean fFormatNotEmpty = false;
        int i = 0;

        while (i < args.length) {
            switch (args[i]) {
                case PATH_ARG -> {
                    if (fPath) {
                        throw new Exception("Argument --path was given several times");
                    }
                    fPath = true;
                    i++;
                    for (; i < args.length; i++) {
                        if (isPathOrURL(args[i])) {
                            fPathNotEmpty = true;
                            appArgs.path.add(args[i]);
                            log.info("Args: add --path: " + args[i]);
                        } else if (KEYWORDS.contains(args[i]) && fPathNotEmpty) {
                            break;
                        } else if (KEYWORDS.contains(args[i]) && !fPathNotEmpty) {
                            throw new Exception("After --path no path");
                        } else {
                            throw new Exception("No such file or url:" + args[i]);
                        }
                    }
                }
                case FROM_ARG -> {
                    if (fFromNotEmpty) {
                        throw new Exception("Argument --from was given several times");
                    }
                    i++;
                    try {
                        appArgs.from = OffsetDateTime.parse(args[i]);
                        fFromNotEmpty = true;
                        log.info("Args: add --from: " + args[i]);
                        i++;
                    } catch (Exception e) {
                        if (KEYWORDS.contains(args[i])) {
                            throw new Exception("No one argument after --from");
                        } else {
                            throw new Exception("Wrong patter of time. Use -h or --help for information");
                        }
                    }
                }
                case TO_ARG -> {
                    if (fToNotEmpty) {
                        throw new Exception("Argument --to was given several times");
                    }
                    i++;
                    try {
                        appArgs.to = OffsetDateTime.parse(args[i]);
                        fToNotEmpty = true;
                        log.info("Args: add --to: " + args[i]);
                        i++;
                    } catch (Exception e) {
                        if (KEYWORDS.contains(args[i])) {
                            throw new Exception("No one argument after --to");
                        } else {
                            throw new Exception("Wrong patter of time. Use -h or --help for information");
                        }
                    }
                }
                case FORMAT_ARG -> {
                    if (fFormatNotEmpty) {
                        throw new Exception("Argument --format was given several times");
                    }
                    i++;
                    if (OUTPUT_KEYWORDS.contains(args[i])) {
                        appArgs.format = args[i];
                        fFormatNotEmpty = true;
                        log.info("Args: add --format: " + args[i]);
                        i++;
                    } else {
                        throw new Exception("No such format. Use -h or --help for information");
                    }
                }
                case null, default -> i++;
            }
        }

        if (fPathNotEmpty) {
            log.info("Args processed correctly");
            return appArgs;
        } else {
            throw new Exception("Args have no one path");
        }
    }

    static boolean isPathOrURL(String str) {
        Path path = Paths.get(str);
        return Files.isRegularFile(path) || Files.isSymbolicLink(path) || Files.isDirectory(path);
    }
}

