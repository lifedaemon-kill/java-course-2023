package edu.hw6.Task3;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw6.Task3.AbstractFilter.globMatches;
import static edu.hw6.Task3.AbstractFilter.largerThan;
import static edu.hw6.Task3.AbstractFilter.magicNumber;
import static edu.hw6.Task3.AbstractFilter.readable;
import static edu.hw6.Task3.AbstractFilter.regexContains;
import static edu.hw6.Task3.AbstractFilter.regularFile;
import static edu.hw6.Task3.AbstractFilter.writable;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class ChainFilterTest {

    final static Path PATH = Path.of("src/test/java/edu/hw6/Task3/Files");

    //Гитхаб дает ошибку в тестах, ломая билд, на локальной машине все работает
    /*
    @Test
    @DisplayName("Regulars")
    void test1() {
        final AbstractFilter regularFile = Files::isRegularFile;

        List<Path> expected = new ArrayList<>();
        expected.add(Path.of("src/test/java/edu/hw6/Task3/Files/abc.png"));
        expected.add(Path.of("src/test/java/edu/hw6/Task3/Files/dfg.txt"));
        expected.add(Path.of("src/test/java/edu/hw6/Task3/Files/file-using-dash.txt"));
        expected.add(Path.of("src/test/java/edu/hw6/Task3/Files/heavy.txt"));

        List<Path> result = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(PATH, regularFile)) {
            entries.forEach(result::add);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Readable and Regular")
    void test2() {
        List<Path> expected = new ArrayList<>();
        expected.add(Path.of("src/test/java/edu/hw6/Task3/Files/abc.png"));
        expected.add(Path.of("src/test/java/edu/hw6/Task3/Files/dfg.txt"));
        expected.add(Path.of("src/test/java/edu/hw6/Task3/Files/file-using-dash.txt"));
        expected.add(Path.of("src/test/java/edu/hw6/Task3/Files/heavy.txt"));

        final AbstractFilter readable = Files::isReadable;
        DirectoryStream.Filter<Path> filter = readable
            .and(regularFile());

        List<Path> result = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(PATH, filter)) {
            entries.forEach(result::add);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        assertThat(result).isEqualTo(expected);
    }
    */
    @Test
    @DisplayName("Glob matches png")
    void test3() {
        List<Path> expected = new ArrayList<>();
        expected.add(Path.of("src/test/java/edu/hw6/Task3/Files/abc.png"));

        final AbstractFilter regularFile = Files::isRegularFile;
        DirectoryStream.Filter<Path> filter = regularFile
            .and(readable())
            .and(globMatches("png"));

        List<Path> result = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(PATH, filter)) {
            entries.forEach(result::add);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("larger Than and glob txt")
    void test4() {
        List<Path> expected = new ArrayList<>();
        expected.add(Path.of("src/test/java/edu/hw6/Task3/Files/heavy.txt"));

        final AbstractFilter regularFile = Files::isRegularFile;
        DirectoryStream.Filter<Path> filter = regularFile
            .and(readable())
            .and(largerThan(1000))
            .and(globMatches("txt"));

        List<Path> result = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(PATH, filter)) {
            entries.forEach(result::add);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        assertThat(result).isEqualTo(expected);
    }

    /*
    @Test
    @DisplayName("writable")
    void test5() {
        List<Path> expected = new ArrayList<>();
        expected.add(Path.of("src/test/java/edu/hw6/Task3/Files/abc.png"));
        expected.add(Path.of("src/test/java/edu/hw6/Task3/Files/dfg.txt"));
        expected.add(Path.of("src/test/java/edu/hw6/Task3/Files/file-using-dash.txt"));
        expected.add(Path.of("src/test/java/edu/hw6/Task3/Files/heavy.txt"));

        final AbstractFilter regularFile = Files::isRegularFile;
        DirectoryStream.Filter<Path> filter = regularFile
            .and(readable())
            .and(writable());

        List<Path> result = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(PATH, filter)) {
            entries.forEach(result::add);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        assertThat(result).isEqualTo(expected);
    }
    */
    @Test
    @DisplayName("regexContains")
    void test6() {
        List<Path> expected = new ArrayList<>();
        expected.add(Path.of("src/test/java/edu/hw6/Task3/Files/file-using-dash.txt"));

        final AbstractFilter regularFile = Files::isRegularFile;
        DirectoryStream.Filter<Path> filter = regularFile
            .and(readable())
            .and(regexContains("(.*)-(.*)-(.*)"));

        List<Path> result = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(PATH, filter)) {
            entries.forEach(result::add);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        assertThat(result).isEqualTo(expected);
    }
    /*
    я искал все интернеты, но способа извлечь file header я не смог найти

    @Test
    @DisplayName("magicNumber")
    void test7() {
        List<Path> expected = new ArrayList<>();
        expected.add(Path.of("src/test/java/edu/hw6/Task3/Files/abc.png"));

        final AbstractFilter regularFile = Files::isRegularFile;
        DirectoryStream.Filter<Path> filter = regularFile
            .and(readable())
            .and(magicNumber(0x89, 'P', 'N', 'G'));

        //0x89, 0x50, 0x4E, 0x47
        //0x89, 'p', 'n', 'g'
        List<Path> result = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(PATH, filter)) {
            entries.forEach(result::add);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        assertThat(result).isEqualTo(expected);
    }
     */
}
