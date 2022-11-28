package services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class DataBaseService {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "Americana#1";

    Logger logger = LoggerFactory.getLogger(DataBaseService.class);

    Connection connection;
    Statement statement;

    public DataBaseService() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

        if (connection != null) {
            logger.warn("You successfully connected to DB...");
        } else {
            logger.warn("Что-то пошло не так...");
        }
    }

    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Соединение успешно разорвано...");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Statement getStatement() {
        if (statement == null) {
            try {
                statement = this.connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return statement;
    }

    public void executeSQL(String sql) {
        try {
            getStatement().execute(sql);
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            return getStatement().executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }
}
