package edu.project3;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.project3.FileRequest.getTextFromPaths;

@Log4j2
public class TextFromPathOrURLTest {
    @Test
    @DisplayName("One file")
    void test1() {
        List<String> path = new ArrayList<>();
        path.add("src/test/java/edu/project3/files/small2-log.txt");
        log.info(getTextFromPaths(path));
    }

    @Test
    @DisplayName("two files")
    void test2() {
        List<String> path = new ArrayList<>();
        path.add("src/test/java/edu/project3/files/small2-log.txt");
        path.add("src/test/java/edu/project3/files/small-log.txt");
        log.info(getTextFromPaths(path));
    }

    @Test
    @DisplayName("all files")
    void test3() {
        List<String> path = new ArrayList<>();
        path.add("src/test/java/edu/project3/files/");
        log.info(getTextFromPaths(path));
    }

    @Test
    @DisplayName("URL")
    void test4() {
        List<String> path = new ArrayList<>();
        path.add(
            "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs");
        log.info(getTextFromPaths(path));
    }

    @Test
    @DisplayName("file + URL")
    void test5() {
        List<String> path = new ArrayList<>();
        path.add("src/test/java/edu/project3/files/small2-log.txt");
        path.add(
            "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs");

        log.info(getTextFromPaths(path));
    }
}
