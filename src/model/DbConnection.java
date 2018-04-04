package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private Connection connection = null;

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_data", "root", "");
            System.out.println("Connection Success!!!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can not connect Database!!!");
            connection = null;
        }
        return connection;
    }
}
