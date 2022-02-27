package ua.com.alevel.config;

import ua.com.alevel.DAO.UserDAO;
import ua.com.alevel.DAOImpl.Database;
import ua.com.alevel.DAOImpl.UserDAOImpl;

public class DBConfig {

    private static final DBConfig instance = new DBConfig();
    private UserDAO userDAO;

    private DBConfig() { }

    public static DBConfig getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void configure(String database) {
        database = database.toUpperCase();
        /*At this point switch statement is unnecessary, but to practice this way writing code
         will be very useful. Pattern Factory */
        switch (Database.valueOf(database)) {
            case MSSQL:
            case MYSQL:
            case POSTGRESQL: {
                userDAO = new UserDAOImpl();
                break;
            }
            default: {
                System.out.println("Unknown database");
            }
        }
    }
}
