package edu.project3;

import org.junit.jupiter.api.Test;
import static edu.project3.LogStats.runStats;

public class LogStatsTest {
    @Test
    void test0() {
        runStats(new String[] {"-h"});
    }

    @Test
    void test1() {
        String[] args = {"--path",
            "src/test/java/edu/project3/files/",
        };
        runStats(args);
    }
    @Test
    void test2() {
        String[] args = {"--path",
            "src/test/java/edu/project3/files/",
            "--format",
            "markdown"
        };
        runStats(args);
    }
    @Test
    void test3() {
        String[] args = {"--path",
            "src/test/java/edu/project3/files/",
            "--format",
            "adoc"
        };
        runStats(args);
    }
}
