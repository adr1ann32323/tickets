package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/tickets_db?useSSL=false&serverTimezone=UTC";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "adrian";


    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver JDBC no encontrado: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}