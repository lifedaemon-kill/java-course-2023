package edu.hw6.Task1;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static edu.hw6.Task1.DiskMap.getValidLine;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class CheckValidStringTest {

    @Test
    void test() {
        //Arrange
        final String[] INVALID_STRINGS = {
            "hell:o:world",
            "hello world",
            "hello:",
            ":world",
            ":",
            "he:llo wo:rld",
        };
        int errorCount = 0;
        //Act
        for (String line : INVALID_STRINGS) {
            try {
                getValidLine(line);
                log.error("line is broken but returned as valid:\n" + line);
            } catch (Exception e) {
                errorCount++;
            }
        }

        //Assert
        assertThat(errorCount).isEqualTo(INVALID_STRINGS.length);
    }
}
