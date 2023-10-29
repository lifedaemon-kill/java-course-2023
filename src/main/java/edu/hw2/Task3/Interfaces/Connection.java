package edu.hw2.Task3.Interfaces;

import static edu.hw2.Task3.Utility.LOGGER;

public interface Connection extends AutoCloseable {
    void execute(String command);

    @Override
    default void close() {
        LOGGER.info("Connection was close");
    }
}
