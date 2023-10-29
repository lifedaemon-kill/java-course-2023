package edu.hw2.Task3;

public class ConnectionException extends RuntimeException {
    ConnectionException(String exception, Throwable cause) {
        super(exception, cause);
    }

    public ConnectionException(String exception) {
        super(exception);
    }
}
