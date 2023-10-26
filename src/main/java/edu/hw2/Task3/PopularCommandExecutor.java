package edu.hw2.Task3;

import edu.hw2.Task3.ConnectionManagers.DefaultConnectionManager;
import edu.hw2.Task3.ConnectionManagers.FaultyConnectionManager;
import java.util.Locale;
import static edu.hw2.Task3.Utility.DROP_CONNECTION;
import static edu.hw2.Task3.Utility.FAULTY;

public class PopularCommandExecutor {
    private static Interfaces.ConnectionManager manager;
    private final int maxAttempts;
    private final int minAttempts = 1;

    public PopularCommandExecutor(int attempts, String managerType) {
        this.maxAttempts = Math.max(attempts, minAttempts);

        if (managerType.toLowerCase(Locale.ROOT).equals(FAULTY)) {
            manager = new FaultyConnectionManager();
        } else {
            manager = new DefaultConnectionManager();
        }
    }

    public PopularCommandExecutor(String managerType) {
        this.maxAttempts = minAttempts;

        if (managerType.toLowerCase(Locale.ROOT).equals(FAULTY)) {
            manager = new FaultyConnectionManager();
        } else {
            manager = new DefaultConnectionManager();
        }
    }

    public PopularCommandExecutor() {
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
