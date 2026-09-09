package com.ecoguide.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Reads local database settings from environment variables; no password is stored in source control. */
public final class DBConnection {
    private DBConnection() { }

    public static Connection getConnection() throws SQLException {
        String url = value("DB_URL", "jdbc:mysql://localhost:3306/ecoguide_ai?useSSL=false&serverTimezone=UTC");
        String user = value("DB_USER", "ecoguide_app");
        String password = System.getenv("DB_PASSWORD");
        if (password == null || password.isBlank()) {
            throw new SQLException("Database is not configured. Set DB_PASSWORD before starting Tomcat.");
        }
        return DriverManager.getConnection(url, user, password);
    }

    private static String value(String key, String defaultValue) {
        String value = System.getenv(key);
        return value == null || value.isBlank() ? defaultValue : value;
    }
}
