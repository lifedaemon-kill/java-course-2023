package edu.hw2;

import edu.hw2.Task4.CallingInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw2.Task4.CallingInfo.callingInfo;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4WhoCallsTest {
    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    @DisplayName("Запуск из теста")
    void test1() {
        CallingInfo caller = callingInfo();

        LOGGER.info(caller);

        assertThat(caller.className()).isEqualTo("edu.hw2.Task4WhoCallsTest");
        assertThat(caller.methodName()).isEqualTo("test1");
    }

    @Test
    @DisplayName("Запуск из класса")
    void test2() {
        class A {
            public static void execute() {
                CallingInfo callingInfo = callingInfo();

                LOGGER.info(callingInfo);

                assertThat(callingInfo.className()).isEqualTo("edu.hw2.Task4WhoCallsTest$1A");
                assertThat(callingInfo.methodName()).isEqualTo("execute");
            }
        }
        A.execute();
    }

    @Test
    @DisplayName("Запуск из класса из класса")
    void test3() {
        class A {
            static class B {
                public static void execute() {
                    CallingInfo callingInfo = callingInfo();

                    LOGGER.info(callingInfo);

                    assertThat(callingInfo.className()).isEqualTo("edu.hw2.Task4WhoCallsTest$2A$B");
                    assertThat(callingInfo.methodName()).isEqualTo("execute");
                }
            }
        }
        A.B.execute();
    }
}
