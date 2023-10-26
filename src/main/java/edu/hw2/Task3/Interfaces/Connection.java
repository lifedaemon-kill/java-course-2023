package edu.hw2.Task3.Interfaces;

public interface Connection extends AutoCloseable {
    void execute(String command);
}
