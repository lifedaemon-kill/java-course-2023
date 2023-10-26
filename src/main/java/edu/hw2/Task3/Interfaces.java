package edu.hw2.Task3;

public class Interfaces {
    public interface Connection extends AutoCloseable {
        void execute(String command);
    }

    public interface ConnectionManager {
        Connection getConnection();
    }

}
