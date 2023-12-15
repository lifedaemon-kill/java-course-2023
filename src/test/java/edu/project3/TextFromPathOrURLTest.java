package edu.project3;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.project3.FileRequest.getTextFromPaths;

public class TextFromPathOrURLTest {
    @Test
    @DisplayName("One file")
    void test1() {
        List<String> path = new ArrayList<>();
        path.add("src/test/java/edu/project3/files/small2-log.txt");
        String result = getTextFromPaths(path);

        System.out.println(result);
    }

    @Test
    @DisplayName("two files")
    void test2() {
        List<String> path = new ArrayList<>();
        path.add("src/test/java/edu/project3/files/small2-log.txt");
        path.add("src/test/java/edu/project3/files/small-log.txt");
        String result = getTextFromPaths(path);

        System.out.println(result);
    }

    @Test
    @DisplayName("all files")
    void test3() {
        List<String> path = new ArrayList<>();
        path.add("src/test/java/edu/project3/files/");
        String result = getTextFromPaths(path);
        System.out.println(result);
    }

    @Test
    @DisplayName("URL")
    void test4() {
        List<String> path = new ArrayList<>();
        path.add(
            "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs");
        String result = getTextFromPaths(path);
        System.out.println(result);
    }

    @Test
    @DisplayName("file + URL")
    void test5() {
        List<String> path = new ArrayList<>();
        path.add("src/test/java/edu/project3/files/small2-log.txt");
        path.add(
            "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs");

        String result = getTextFromPaths(path);

        System.out.println(result);
    }
}
