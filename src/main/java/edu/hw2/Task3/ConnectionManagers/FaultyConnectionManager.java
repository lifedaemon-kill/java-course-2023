package edu.hw2.Task3.ConnectionManagers;

import edu.hw2.Task3.Connections.FaultyConnection;
import edu.hw2.Task3.Interfaces.ConnectionManager;
import edu.hw2.Task3.Interfaces.Connection;

public class FaultyConnectionManager implements ConnectionManager {
    public FaultyConnectionManager() {
    }

    @Override
    public Connection getConnection() {
        return new FaultyConnection();
    }
}
