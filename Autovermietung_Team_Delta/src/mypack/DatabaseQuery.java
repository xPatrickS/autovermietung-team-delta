package mypack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQuery {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM fahrzeugbestand";
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    System.out.println("Fahrzeugmodell: " + resultSet.getString("Fahrzeugmodell"));
                    System.out.println("Marke: " + resultSet.getString("Marke"));
                    System.out.println("Zustand: " + resultSet.getString("Zustand"));
                    System.out.println("Laufleistung: " + resultSet.getInt("Laufleistung"));
                    System.out.println("Motorisierung: " + resultSet.getString("Motorisierung"));
                    System.out.println("Sitzanzahl: " + resultSet.getInt("Sitzanzahl"));
                    System.out.println("Standort: " + resultSet.getString("Standort"));
                    System.out.println("Kraftstoff: " + resultSet.getString("Kraftstoff"));
                    System.out.println("------------------------------");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
