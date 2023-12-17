package edu.hw6.Task1;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class SafeFileTest {
    @Test
    @DisplayName("Safe correct map")
    void testCorrect() {
        String path = "src/test/java/edu/hw6/Task1/SavedMap";

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("hello", "world");
        hashMap.put("simple", "dimple");
        hashMap.put("axe", "топор");
        hashMap.put("morse code", ".- --.. -... ..- -.- .-  -- --- .-. --.. .");
        hashMap.put("банк", "Тинькофф");

        boolean nice = false;

        try {
            DiskMap.safeToFile(hashMap, path);
            File file = new File(path);

            if (file.exists()) {
                log.info("Файл успешно записан!");

                nice = true;

                if (file.delete()) {
                    log.info("Файл успешно удалён!");
                } else {
                    throw new Exception("При удалении файла произошла ошибка");
                }
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        assertThat(nice).isTrue();
    }

    @Test
    @DisplayName("Запись инвалидов")
    void testInvalid() {
        String path = "src/test/java/edu/hw6/Task1/SavedMap";

        Map<String, String> hashMap = new HashMap<>();

        hashMap.put("hello world", "");
        hashMap.put("hell", "o:world");
        hashMap.put("hello", "");
        hashMap.put("", "world");
        hashMap.put("he", "llo wo:rld");

        boolean nice;

        try {
            DiskMap.safeToFile(hashMap, path);
            nice = false;
        } catch (Exception e) {
            nice = true;

            File file = new File(path);
            if (file.exists()) {
                log.error("Файл " + file.getName() + " был ошибочно сохранен!\nЗапуск попытки удаления...");

                if (file.delete()) {
                    log.info("Файл успешно удален!");
                } else {
                    log.info("Файл не был удалён!");
                }
            }
        }

        assertThat(nice).isTrue();
    }
}
