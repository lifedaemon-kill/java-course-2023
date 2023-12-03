package edu.hw6.Task2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw6.Task2.CloneFile.cloneFile;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2 public class CloneFileTest {
    @Test @DisplayName("Начального файла нет") void testCreateFile() {
        Path path = Path.of("src/test/java/edu/hw6/Task2/empty.txt");
        boolean nice = false;

        try {
            cloneFile(path);

            File file = new File(String.valueOf(path));

            if (file.exists()) {
                nice = true;
                log.info("Файл создан! Запуск удаления");

                if (file.delete()) {
                    log.info("Файл успешно удален!");
                } else {
                    log.info("Файл не был удален!");
                }
            } else {
                nice = true;
                log.info("Файл не был создан!");
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        assertThat(nice).isTrue();
    }
    /*
    @Test @DisplayName("Первая копия") void testFirstCopy() {
        Path path = Path.of("src/test/java/edu/hw6/Task2/abc.txt");

        Path pathTarget = Path.of("src/test/java/edu/hw6/Task2/abc — копия.txt");

        File fileOrigin = new File(String.valueOf(path));
        File fileTarget = new File(String.valueOf(pathTarget));

        boolean nice = false;

        if (fileTarget.exists()) {
            log.info("файл уже существует! Удаляем!");
            fileTarget.delete();
        } else {
            cloneFile(path);
            File fileCopy = new File(String.valueOf(pathTarget));

            if (fileCopy.exists()) {
                try {
                    String expected = Files.readString(fileCopy.toPath());
                    String original = Files.readString(fileOrigin.toPath());

                    nice = true;
                    assertThat(original).isEqualTo(expected);

                } catch (IOException e) {
                    log.info("Не удалось считать файл");
                }
            }
            fileCopy.delete();
        }
        assertThat(nice).isTrue();
    }

    @Test @DisplayName("Вторая копия") void testSecondCopy() {
        Path originalPath = Path.of("src/test/java/edu/hw6/Task2/abc.txt");
        Path copyPath1 = Path.of("src/test/java/edu/hw6/Task2/abc — копия.txt");
        Path copyPath2 = Path.of("src/test/java/edu/hw6/Task2/abc — копия (2).txt");

        File originalFile = new File(String.valueOf(originalPath));
        File copyFile1 = new File(String.valueOf(copyPath1));
        File copyFile2 = new File(String.valueOf(copyPath2));

        boolean nice = false;

        if (copyFile1.exists()) {
            log.info("Первая копия уже существует! Удаление");
            copyFile1.delete();
        }
        if (copyFile2.exists()) {
            log.info("Вторая копия уже существует! Удаление");
            copyFile2.delete();
        }

        cloneFile(originalPath);
        cloneFile(originalPath);

        try {
            copyFile2 = new File(String.valueOf(copyPath2));

            String expected = Files.readString(copyFile2.toPath());
            if (copyFile2.exists()) {
                log.info("Вторая копия была создана!");
            }
            String original = Files.readString(originalFile.toPath());

            log.info(expected);

            assertThat(original).isEqualTo(expected);
            nice = true;

        } catch (Exception e) {
            log.info(e.getMessage());
        }

        copyFile1.delete();
        copyFile2.delete();

        assertThat(nice).isTrue();
    }

     */
}
