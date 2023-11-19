package edu.hw6.Task1;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class LoadFileTest {
    @Test
    @DisplayName("Correct map in file")
    void test1() {
        //Arrange
        String path = "src/test/java/edu/hw6/Task1/CorrectMap";
        Map<String, String> expected = new HashMap<>();

        expected.put("hello", "world");
        expected.put("simple", "dimple");
        expected.put("axe", "топор");
        expected.put("morse code", ".- --.. -... ..- -.- .-  -- --- .-. --.. .");
        expected.put("банк", "Тинькофф");

        //Act
        Map<String, String> test = new HashMap<>();
        try {
            test = DiskMap.getFromFile(path);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        //Assert
        assertThat(test).isEqualTo(expected);
    }
    @Test
    @DisplayName("Wrong path")
    void test2() {
        //Arrange
        String path = "src/test/java/edu/hw6/Task1/RyanGosling";

        //Act
        Map<String, String> test = new HashMap<>();
        try {
            test = DiskMap.getFromFile(path);
        } catch (Exception e) {
            log.error("Ошибка при выполнении!");
        }

        //Assert
        assertThat(test).isEmpty();
    }
}
