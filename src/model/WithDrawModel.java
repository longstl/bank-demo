package model;

import entity.BankCustomer;

import javax.swing.*;
import java.sql.*;

public class WithDrawModel {

    BankCustomer customer = new BankCustomer();

    public BankCustomer withDrawQuery(String accountNumber, String amount) {
        Connection connection = null;
        connection = DbConnection.getConnection();
        if (connection == null) {
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
                if (checkBalance.equals(amount)) {
                    Double currentBalance = checkBalance - Double.parseDouble(amount);
                    String withDrawMoneyQuery = "Update account Set balance = ? where numberAccount = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(withDrawMoneyQuery);
                    preparedStatement.setDouble(1, currentBalance);
                    preparedStatement.setString(2, accountNumber);
                    preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "With Draw Money Success!!!");
                } else {
                    JOptionPane.showMessageDialog(null, "With Draw Money Faild!!!");
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Input in-correct. Input only number.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

}
