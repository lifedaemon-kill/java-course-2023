package edu.hw2.Task3.ConnectionManagers;

import edu.hw2.Task3.Connections.FaultyConnection;
import edu.hw2.Task3.Connections.StableConnection;
import static edu.hw2.Task3.Interfaces.Connection;
import static edu.hw2.Task3.Interfaces.ConnectionManager;
import static edu.hw2.Task3.Utility.DROP_RATE;

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
            return new FaultyConnection();
        } else {
            return new StableConnection();
        }
    }
}
