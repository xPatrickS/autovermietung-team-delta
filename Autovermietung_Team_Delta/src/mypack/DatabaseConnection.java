package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mariadb://localhost:3306/fahrzeugdb";
    private static final String USER = "root"; // 
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Verbindung zur Datenbank hergestellt!");
        } catch (SQLException e) {
            System.err.println("Verbindung fehlgeschlagen!");
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        // Teste die Verbindung
        getConnection();
    }
}
