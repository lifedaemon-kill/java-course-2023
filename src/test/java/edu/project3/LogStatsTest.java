package edu.project3;

import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

public class LogStatsTest {
    @Test
    void test1() {
        String input =
            "$remote_addr - $remote_user [$time_ local] \"$re qu est\" $status $body_bytes_sent  \"$http_referer\" \"$http_user_agent\"\n"
            +
            "93.180.71.3 - mrLogger [17/May/2015:08:05:32 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 0 \"htttp refer\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\""
            + "93.180.71.3 - - [17/May/2015:08:05:23 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"\n";

        String pattern = "(\\d+) - (\\d+) \\[(\\w+) (\\w+) (\\w+)] \"(.+)";

        Pattern regexPattern = Pattern.compile(pattern);

        String[] tokens = regexPattern.split(input);

        for (String token : tokens) {
            System.out.println(token);
        }
    }
}
