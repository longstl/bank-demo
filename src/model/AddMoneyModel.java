package model;

import entity.BankCustomer;

import javax.swing.*;
import java.sql.*;

public class AddMoneyModel {

    BankCustomer customer = new BankCustomer();

    public BankCustomer addMoneyUpdate(String accountNumber, String amount) {
        Connection connection =null;
        connection = DbConnection.getConnection();
        if (connection == null){
            return null;
        }
        try {
            String query = "SELECT * FROM account WHERE numberAccount = " +
                    "'" +
                    accountNumber +
                    "'" +
                    "";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                Double checkBalance = rs.getDouble("balance");
                Double currentBalance = checkBalance + Double.parseDouble(amount);
                String addMoneyQuery = "Update account Set balance = ? where numberAccount = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(addMoneyQuery);
                preparedStatement.setDouble(1, currentBalance);
                preparedStatement.setString(2, accountNumber);
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Add Money Success!!!");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Input in-correct. Please enter number only.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
