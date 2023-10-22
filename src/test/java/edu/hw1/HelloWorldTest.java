package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {

    @Test
    @DisplayName("Запуск вывода в консоль")
    void loggerOut() {
        HelloWorld.printHello();
    }
}
