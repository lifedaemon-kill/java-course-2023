package edu.project3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AppArgs {
    private static final String CONSOLE = "console";
    private static final String PATH_ARG = "--path";
    private static final String FROM_ARG = "--from";
    private static final String TO_ARG = "--to";
    private static final String FORMAT_ARG = "--format";
    private static final Set<String> KEYWORDS = Set.of(PATH_ARG, FROM_ARG, TO_ARG, FORMAT_ARG);
    private static final Set<String> OUTPUT_KEYWORDS = Set.of("adoc", CONSOLE, "markdown");
    private static final String WRONG_PATTERN_OF_TIME = "Wrong patter of time. Use -h or --help for information";

    public List<String> path = new ArrayList<>();
    public OffsetDateTime from;

    public OffsetDateTime to;
    public String format = CONSOLE;

    private AppArgs() {
    }

    @SuppressWarnings("CyclomaticComplexity")
    public static AppArgs getArgs(String[] args) throws Exception {
        if (("-h".equals(args[0])) || "--help".equals(args[0])) {
            return null;
        } else if (!isArgsCorrect(args)) {
            throw new Exception("Args not match pattern. Use -h or --help for information");
        }

        AppArgs appArgs = new AppArgs();

        boolean fPathNotEmpty = false;

        int i = 0;

        while (i < args.length) {
            switch (args[i]) {
                case PATH_ARG -> {
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
                            throw new Exception(String.format("No such file or url: %s", args[i]));
                        }
                    }
                }
                case FROM_ARG -> {
                    i++;
                    try {
                        appArgs.from = OffsetDateTime.parse(args[i]);
                        log.info(String.format("Args: add --from: %s", args[i]));
                        i++;
                    } catch (Exception e) {
                        log.error(e.getMessage());
                        throw new Exception(WRONG_PATTERN_OF_TIME);
                    }
                }
                case TO_ARG -> {
                    i++;
                    try {
                        appArgs.to = OffsetDateTime.parse(args[i]);
                        log.info(String.format("Args: add --to: %s", args[i]));
                        i++;
                    } catch (Exception e) {
                        log.error(e.getMessage());
                        throw new Exception(WRONG_PATTERN_OF_TIME);
                    }
                }
                case FORMAT_ARG -> {
                    i++;
                    if (!OUTPUT_KEYWORDS.contains(args[i])) {
                        throw new Exception("No such format. Use -h or --help for information");
                    }
                    appArgs.format = args[i];
                    log.info(String.format("Args: add --format: %s", args[i]));
                    i++;
                }
                case null, default -> throw new Exception("Argument exception");
            }
        }
        log.info("Args processed correctly");
        return appArgs;
    }

    static boolean isPathOrURL(String str) {
        Path path = Paths.get(str);
        return Files.isRegularFile(path) || Files.isSymbolicLink(path) || Files.isDirectory(path);
    }

    static boolean isArgsCorrect(String[] args) {
        Map<String, Integer> keyword = new HashMap<>();
        keyword.put(PATH_ARG, 0);
        keyword.put(FROM_ARG, 0);
        keyword.put(TO_ARG, 0);
        keyword.put(FORMAT_ARG, 0);

        for (var item : args) {
            if (keyword.containsKey(item)) {
                keyword.put(item, keyword.get(item) + 1);

                if (keyword.get(item) > 1) {
                    return false;
                }
            }
        }
        return keyword.get(PATH_ARG) == 1;
    }
}

