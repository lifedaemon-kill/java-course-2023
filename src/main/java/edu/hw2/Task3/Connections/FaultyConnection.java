package edu.hw2.Task3.Connections;

import edu.hw2.Task3.ConnectionException;
import edu.hw2.Task3.Interfaces;
import static edu.hw2.Task3.Utility.DROP_RATE;
import static edu.hw2.Task3.Utility.LOGGER;

public class FaultyConnection implements Interfaces.Connection {
    private static int connectionIterator = -1;
    private int connectionDropRate = DROP_RATE;

    public void setDropRate(int drop) {
        connectionDropRate = drop;
    }

    public FaultyConnection() {
    }

    @Override
    public void execute(String command) throws ConnectionException {
        connectionIterator++;

        if (connectionIterator % connectionDropRate == 0) {
            throw new ConnectionException("Execute was failed");
        } else {
            LOGGER.info(command);
        }
    }

    @Override
    public void close() {
    }
}
