package edu.project3;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static edu.project3.AppArgs.getArgs;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class ArgsTest {
    @Test
    @DisplayName("Один путь работает")
    void test1() {
        String[] args = "--path src/test/java/edu/project3/files/small2-log.txt --format markdown"
            .split(" ");

        try {
            AppArgs request = getArgs(args);
            log.info(request.path);
            log.info(request.from);
            log.info(request.to);
            log.info(request.format);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
    @Test
    @DisplayName("Два пути")
    void test2() {
        String[] args = "--path src/test/java/edu/project3/files/small2-log.txt src/test/java/edu/project3/files/small-log.txt --format markdown"
            .split(" ");

        try {
            AppArgs request = getArgs(args);
            assert request != null;
            log.info(request.path);
            log.info(request.from);
            log.info(request.to);
            log.info(request.format);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
    @Test
    @DisplayName("Второй путь на несуществующий файл")
    void test3() {
        String[] args = "--path src/test/java/edu/project3/files/small2-log.txt src/test/edu/project3/files/small-log.txt --format markdown"
            .split(" ");

        try {
            AppArgs request = getArgs(args);
            assert request != null;
            log.info(request.path);
            log.info(request.from);
            log.info(request.to);
            log.info(request.format);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
    @Test
    @DisplayName("Ни одного файла")
    void test4() {
        String[] args = "--path --format markdown"
            .split(" ");

        try {
            AppArgs request = getArgs(args);
            assert request != null;
            log.info(request.path);
            log.info(request.from);
            log.info(request.to);
            log.info(request.format);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
    @Test
    @DisplayName("Два раза --path")
    void test5() {
        String[] args = "--path src/test/java/edu/project3/files/small2-log.txt --path src/test/java/edu/project3/files/small2-log.txt --format markdown"
            .split(" ");

        try {
            AppArgs request = getArgs(args);
            assert request != null;
            log.info(request.path);
            log.info(request.from);
            log.info(request.to);
            log.info(request.format);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
    @Test
    @DisplayName("From + To работает")
    void test6() {
        String[] args = "--from 2015-05-17T08:05:10+00:00 --to 2015-05-17T08:05:26+00:00 --path src/test/java/edu/project3/files/small2-log.txt"
            .split(" ");
        try {
            AppArgs request = getArgs(args);
            log.info(request.from);
            log.info(request.to);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
