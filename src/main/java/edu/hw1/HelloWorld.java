package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorld {
    private final static Logger LOGGER = LogManager.getLogger();

    private HelloWorld() {
    }

    private static final String HELLO = "Привет, мир!";

    public static void printHello() {
        LOGGER.info(HELLO);
    }
}
