package edu.hw2.Task3;

import edu.hw2.Task3.ConnectionManagers.DefaultConnectionManager;
import edu.hw2.Task3.ConnectionManagers.FaultyConnectionManager;
import edu.hw2.Task3.Interfaces.ConnectionManager;
import edu.hw2.Task3.Utility.ManagersTypes;
import static edu.hw2.Task3.Utility.DROP_CONNECTION;
import static edu.hw2.Task3.Utility.LOGGER;

public class PopularCommandExecutor {
    private ConnectionManager manager;
    private final int minAttempts = 1;
    private int maxAttempts;

    public PopularCommandExecutor(int attempts, ManagersTypes managerType) {
        setAttempts(attempts);
        setManager(managerType);
    }

    public PopularCommandExecutor(ManagersTypes managerType) {
        setAttempts(minAttempts);
        setManager(managerType);
    }

    public PopularCommandExecutor() {
        setAttempts(minAttempts);
        setManager(ManagersTypes.DEFAULT);
    }

    public void setManager(ManagersTypes managerType) {
        if (managerType == ManagersTypes.FAULTY) {
            this.manager = new FaultyConnectionManager();
        } else if (managerType == ManagersTypes.DEFAULT) {
            this.manager = new DefaultConnectionManager();
        } else {
            LOGGER.warn("There aren't that manager! Set to default: " + ManagersTypes.DEFAULT.name());
            this.manager = new DefaultConnectionManager();
        }
    }

    public void setAttempts(int attempts) {
        if (attempts < minAttempts) {
            LOGGER.warn("Max Attempts is too small! Set to default:" + minAttempts);
            this.maxAttempts = minAttempts;
        } else {
            this.maxAttempts = attempts;
        }
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
