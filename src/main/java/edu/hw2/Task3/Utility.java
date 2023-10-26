package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utility {
    private Utility() {
    }

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String FAULTY = "faulty";
    public static final String DROP_CONNECTION = "Can't create connection";
    public static final int DROP_RATE = 3;
}
