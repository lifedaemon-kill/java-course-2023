package edu.hw2.Task3.ConnectionManagers;

import edu.hw2.Task3.Connections.FaultyConnection;
import static edu.hw2.Task3.Interfaces.Connection;
import static edu.hw2.Task3.Interfaces.ConnectionManager;

public class FaultyConnectionManager implements ConnectionManager {
    public FaultyConnectionManager() {
    }

    @Override
    public Connection getConnection() {
        return new FaultyConnection();
    }
}
