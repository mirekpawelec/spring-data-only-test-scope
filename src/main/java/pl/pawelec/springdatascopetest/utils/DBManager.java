package pl.pawelec.springdatascopetest.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public class DBManager {

    private static Connection connection;
    private static Properties prop = new Properties();

    static {
        try (InputStream propInputStream = DBManager.class.getClassLoader().getResourceAsStream("application.properties");) {
            if (Objects.isNull(propInputStream)) {
                System.out.println("Sorry, unable to find application.properties");
            } else {
                prop.load(propInputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (Objects.isNull(connection)) {
            connection = initConnection();
        }
        return connection;
    }

    public static void closeConnection() {
        if (Objects.nonNull(connection)) {
            try {
                connection.close();
                System.out.println("Connection has been closed!");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static Connection initConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(prop.getProperty("database.link"), prop.getProperty("database.user"),
                    prop.getProperty("database.password"));
            System.out.println("Connection has been inited!");
        } catch (SQLException e) {
            System.out.println("## Problem z połączeniem z bazą danych!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }
}
