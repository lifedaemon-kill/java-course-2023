package edu.hw2;

import edu.hw2.Task3.ConnectionException;
import edu.hw2.Task3.ConnectionManagers.DefaultConnectionManager;
import edu.hw2.Task3.ConnectionManagers.FaultyConnectionManager;
import edu.hw2.Task3.Connections.FaultyConnection;
import edu.hw2.Task3.Connections.StableConnection;
import edu.hw2.Task3.PopularCommandExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3RemoteServerTest {
    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    @DisplayName("StableConnection is stable")
    void test1() {
        int dropCount = 0;
        int maxTries = 5;
        try (StableConnection stableConnection = new StableConnection()) {
            for (int i = 0; i < maxTries; i++) {
                try {
                    stableConnection.execute("test1:" + (i - dropCount + 1));
                } catch (ConnectionException ex) {
                    dropCount++;
                    LOGGER.error(ex);
                }
            }
            stableConnection.close();
            assertThat(dropCount).isZero();

        }
    }

    @Test
    @DisplayName("FaultyConnection is not stable")
    void test2() {
        int dropCount = 0;

        int maxTries = 100;
        int dropRate = 3;
        try (FaultyConnection faultyConnection = new FaultyConnection()) {
            faultyConnection.setDropRate(dropRate);

            for (int i = 0; i < maxTries; i++) {
                try {
                    faultyConnection.execute("test2:" + (i - dropCount + 1));
                } catch (ConnectionException ex) {
                    dropCount++;
                    LOGGER.error(ex);
                }
            }

            int left = maxTries / dropRate - 1;
            int right = maxTries / dropRate + 1;

            faultyConnection.close();
            assertThat(dropCount).isBetween(left, right);
        }
    }

    @Test
    @DisplayName("FaultyConnectionManager is always return FaultConnection")
    void test3() {
        int dropCount = 0;
        int maxTries = 100;
        int dropRate = 3;

        FaultyConnectionManager manager = new FaultyConnectionManager();

        for (int i = 0; i < maxTries; i++) {
            try {
                manager.getConnection().execute("test3:" + (i - dropCount + 1));
            } catch (ConnectionException ex) {
                dropCount++;
                LOGGER.error(ex);
            }
        }
        int left = maxTries / dropRate - 1;
        int right = maxTries / dropRate + 1;

        assertThat(dropCount).isBetween(left, right);
    }

    @Test
    @DisplayName("DefaultConnectionManager have chance return FaultyConnection")
    void test4() {
        int dropCount = 0;
        int maxTries = 51;
        int dropRate = 4;

        DefaultConnectionManager manager = new DefaultConnectionManager();
        manager.setDropRate(dropRate);

        for (int i = 0; i < maxTries; i++) {
            try {
                manager.getConnection().execute("test4: " + (i - dropCount + 1));
            } catch (ConnectionException ex) {
                dropCount++;
                LOGGER.error(ex);
            }
        }
        int left = maxTries / dropRate / 3 - 1;
        int right = maxTries / dropRate / 3 + 1;

        assertThat(dropCount).isBetween(left, right);
    }

    @Test
    @DisplayName("PopularCommandExecutor Default, maxAttempts > DropRate")
    void test5() {
        int dropCount = 0;
        int maxTries = 15;

        PopularCommandExecutor executor = new PopularCommandExecutor(4, "Default");

        for (int i = 0; i < maxTries; i++) {
            try {
                executor.updatePackages();
            } catch (ConnectionException ex) {
                dropCount++;
                LOGGER.error(ex);
            }
        }
        assertThat(dropCount).isZero();
    }

    @Test
    @DisplayName("PopularCommandExecutor Default, maxAttempts < dropRate")
    void test6() {
        int dropCount = 0;
        int maxTries = 50;

        PopularCommandExecutor executor = new PopularCommandExecutor(1, "Default");

        for (int i = 0; i < maxTries; i++) {
            try {
                executor.installPackages("nmap");
            } catch (ConnectionException ex) {
                dropCount++;
                LOGGER.error(ex);
            }
        }
        int left = maxTries / 3 / 3 - 1;
        int right = maxTries / 3 / 3 + 1;

        assertThat(dropCount).isBetween(left, right);
    }

    @Test
    @DisplayName("PopularCommandExecutor is Full-Default")
    void test7() {
        int dropCount = 0;
        int maxTries = 50;

        PopularCommandExecutor executor = new PopularCommandExecutor();

        for (int i = 0; i < maxTries; i++) {
            try {
                executor.installPackages("nmap");
            } catch (ConnectionException ex) {
                dropCount++;
                LOGGER.error(ex);
            }
        }
        int left = maxTries / 3 / 3 - 1;
        int right = maxTries / 3 / 3 + 1;

        assertThat(dropCount).isBetween(left, right);
    }

    @Test
    @DisplayName("PopularCommandExecutor is Faulty, Attempts default")
    void test8() {
        int dropCount = 0;
        int maxTries = 50;

        PopularCommandExecutor executor = new PopularCommandExecutor("Faulty");

        for (int i = 0; i < maxTries; i++) {
            try {
                executor.installPackages("nmap");
            } catch (ConnectionException ex) {
                dropCount++;
                LOGGER.error(ex);
            }
        }
        int left = maxTries / 3 - 1;
        int right = maxTries / 3 + 1;

        assertThat(dropCount).isBetween(left, right);
    }
}
