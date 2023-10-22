package edu.hw2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw2.Task4WhoCalls.CallingInfo;
import static edu.hw2.Task4WhoCalls.callingInfo;

public class Task4WhoCallsTest {
    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    @DisplayName("Пустой запуск")
    void test1() {
        LOGGER.info(callingInfo());
    }

    @Test
    @DisplayName("Запуск из класса")
    void test2() {
        class A {
            public static void execute() {
                CallingInfo callingInfo = callingInfo();
                LOGGER.info(callingInfo);
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
                }
            }
        }
        A.B.execute();
    }
}
