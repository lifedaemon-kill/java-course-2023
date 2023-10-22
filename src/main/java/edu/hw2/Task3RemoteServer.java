package edu.hw2;

import java.util.Locale;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

final class Task3RemoteServer {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String FAULTY = "faulty";
    private static final String DROP_CONNECTION = "Can't create connection";
    private static final int DROP_RATE = 3;

    private Task3RemoteServer() {
    }

    public static class ConnectionException extends RuntimeException {
        ConnectionException(String exception, Throwable cause) {
            super(exception, cause);
        }

        ConnectionException(String exception) {
            super(exception);
        }
    }

    public interface Connection extends AutoCloseable {
        void execute(String command);
    }

    public static class StableConnection implements Connection {
        @Override
        public void execute(String command) {
            LOGGER.info(command);
        }

        @Override
        public void close() {
        }
    }

    public static class FaultyConnection implements Connection {
        private static int connectionIterator = -1;
        private int connectionDropRate = DROP_RATE;

        public void setDropRate(int drop) {
            connectionDropRate = drop;
        }

        FaultyConnection() {
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

    public interface ConnectionManager {
        Connection getConnection();
    }

    public static class DefaultConnectionManager implements ConnectionManager {
        private int connectionIterator = -1;
        private int connectionDropRate = DROP_RATE;

        public void setDropRate(int drop) {
            connectionDropRate = drop;
        }

        DefaultConnectionManager() {
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

    public static class FaultyConnectionManager implements ConnectionManager {
        FaultyConnectionManager() {
        }

        @Override
        public Connection getConnection() {
            return new FaultyConnection();
        }
    }

    public static class PopularCommandExecutor {
        private static ConnectionManager manager;
        private final int maxAttempts;
        private final int minAttempts = 1;

        PopularCommandExecutor(int attempts, String managerType) {
            this.maxAttempts = Math.max(attempts, minAttempts);

            if (managerType.toLowerCase(Locale.ROOT).equals(FAULTY)) {
                manager = new FaultyConnectionManager();
            } else {
                manager = new DefaultConnectionManager();
            }
        }

        PopularCommandExecutor(String managerType) {
            this.maxAttempts = minAttempts;

            if (managerType.toLowerCase(Locale.ROOT).equals(FAULTY)) {
                manager = new FaultyConnectionManager();
            } else {
                manager = new DefaultConnectionManager();
            }
        }

        PopularCommandExecutor() {
            this.maxAttempts = minAttempts;
            manager = new DefaultConnectionManager();
        }

        public void updatePackages() {
            tryExecute("apt update && apt upgrade -y");
        }

        public void installPackages(String pack) {
            tryExecute("apt install " + pack);
        }

        private void tryExecute(String command) {
            try {
                var managerExecutor = manager.getConnection();
                managerExecutor.execute(command);
                managerExecutor.close();
            } catch (ConnectionException e) {
                if (maxAttempts == 1) {
                    throw new ConnectionException(DROP_CONNECTION, e);
                }
                int iterator = 1;
                while (iterator < maxAttempts) {
                    try {
                        var managerExecutor = manager.getConnection();
                        managerExecutor.execute(command);
                        managerExecutor.close();
                        break;
                    } catch (ConnectionException ex) {
                        iterator++;
                        if (iterator >= maxAttempts) {
                            throw new ConnectionException(DROP_CONNECTION, e);
                        }
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
