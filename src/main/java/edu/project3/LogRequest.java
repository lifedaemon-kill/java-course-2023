package edu.project3;

import java.time.OffsetDateTime;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import static edu.project3.FileRequest.isPathOrURL;

@Log4j2
public class LogRequest {
    public List<String> path;
    public OffsetDateTime from;
    public OffsetDateTime to;
    public String format;

    public LogRequest(String[] args) throws Exception {
        boolean pathFlag = false;
        boolean fromFlag = false;
        boolean toFlag = false;
        boolean formatFlag = false;

        if (args.length == 1 || "-h".equals(args[0])) {
            return;
        }

        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "--path":
                    if (!pathFlag) {
                        try {
                            if (isPathOrURL(args, i)) {
                                this.path.add(args[i + 1]);
                                pathFlag = true;
                            }
                        } catch (Exception e) {
                            throw new Exception("Directory have wrong pattern");
                        }
                    } else {
                        throw new Exception("There are several \"--path\" command in the request");
                    }
                    break;
                case "--from":
                    if (!fromFlag) {
                        try {
                            this.from = OffsetDateTime.parse(args[i + 1]);
                            fromFlag = true;
                        } catch (Exception e) {
                            throw new Exception("Date after \"--from\" have wrong pattern, You should use ISO8601");
                        }
                    } else {
                        throw new Exception("There are several \"--from\" command in the request");
                    }
                    break;
                case "--to":
                    if (!toFlag) {
                        try {
                            this.to = OffsetDateTime.parse(args[i + 1]);
                            toFlag = true;
                        } catch (Exception e) {
                            throw new Exception("Date after \"--to\" have wrong pattern, You should use ISO8601");
                        }
                    } else {
                        throw new Exception("There are several \"--to\" command in the request");
                    }
                    break;
                case "--format":
                    if (!formatFlag) {
                        if ("markdown".equals(args[i + 1]) || "adoc".equals(args[i + 1])) {
                            this.format = args[i + 1];
                            formatFlag = true;
                        } else {
                            throw new Exception("Wrong format type");
                        }
                    } else {
                        throw new Exception(("There are several \"--format\" command in the request"));
                    }
                    break;
                default:
                    throw new Exception("No such command");
            }
        }
        if (!pathFlag) {
            throw new Exception("Path is required");
        }
    }
}

