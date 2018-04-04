package model;

import entity.BankCustomer;

import javax.swing.*;
import java.sql.*;

public class CheckAccountNumberModel {

    BankCustomer customer = new BankCustomer();

    public BankCustomer checkAccount(String accountNumber) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_data", "root", "");
            System.out.println("Connection Success!!!");
            String query = "SELECT * FROM account WHERE numberAccount = " +
                    "'" +
                    accountNumber +
                    "'" +
                    "";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                Double checkBalance = rs.getDouble("balance");
                JOptionPane.showMessageDialog(null, "Balance: " + checkBalance);
            } else {
                JOptionPane.showMessageDialog(null, "Account Number is not exist.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

}
