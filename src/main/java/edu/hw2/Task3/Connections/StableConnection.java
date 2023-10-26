package edu.hw2.Task3.Connections;

import edu.hw2.Task3.Interfaces;
import static edu.hw2.Task3.Utility.LOGGER;

public class StableConnection implements Interfaces.Connection {
    @Override
    public void execute(String command) {
        LOGGER.info(command);
    }

    @Override
    public void close() {
    }
}
