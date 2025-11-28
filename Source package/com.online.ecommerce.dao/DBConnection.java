package com.online.ecommerce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try (InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
                Properties props = new Properties();
                if (input != null) {
                    props.load(input);
                } else {
                    throw new SQLException("db.properties not found in classpath");
                }

                String url = props.getProperty("db.url");
                String user = props.getProperty("db.username");
                String pass = props.getProperty("db.password");

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    throw new SQLException("MySQL JDBC Driver not found", e);
                }

                connection = DriverManager.getConnection(url, user, pass);
            } catch (IOException e) {
                throw new SQLException("Failed to load db.properties", e);
            }
        }
        return connection;
    }
}
