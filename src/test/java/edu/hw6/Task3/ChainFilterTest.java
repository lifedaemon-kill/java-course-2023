package edu.hw6.Task3;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Log4j2
public class ChainFilterTest {

    @Test
    @DisplayName("Regulars")
    void test1() {
        final AbstractFilter regularFile = Files::isRegularFile;

        Path dir = Path.of("src/test/java/edu/hw6/Task3/Files");

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir, regularFile)) {
            entries.forEach(System.out::println);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    @Test
    @DisplayName("Читаемый")
    void test2() {
        final AbstractFilter readable = Files::isReadable;

        Path dir = Path.of("src/test/java/edu/hw6/Task3/Files");

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir, readable)) {
            entries.forEach(System.out::println);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
}
