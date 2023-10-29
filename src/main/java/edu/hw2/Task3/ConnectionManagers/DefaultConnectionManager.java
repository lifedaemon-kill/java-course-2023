package edu.hw2.Task3.ConnectionManagers;

import edu.hw2.Task3.Connections.FaultyConnection;
import edu.hw2.Task3.Connections.StableConnection;
import edu.hw2.Task3.Interfaces.Connection;
import edu.hw2.Task3.Interfaces.ConnectionManager;
import static edu.hw2.Task3.Utility.DROP_RATE;
import static edu.hw2.Task3.Utility.LOGGER;

public class DefaultConnectionManager implements ConnectionManager {
    private int connectionIterator = -1;
    private int connectionDropRate = DROP_RATE;

    public void setDropRate(int drop) {
        connectionDropRate = drop;
    }

    public DefaultConnectionManager() {
    }

    @Override
    public Connection getConnection() {
        connectionIterator++;

        if (connectionIterator % connectionDropRate == 0) {
            LOGGER.info("Connection is faulty");
            return new FaultyConnection();
        } else {
            LOGGER.info("Connection is stable");
            return new StableConnection();
        }
    }
}
