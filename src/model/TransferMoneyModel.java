package model;

import entity.BankCustomer;

import javax.swing.*;
import java.sql.*;

public class TransferMoneyModel {

    BankCustomer customer = new BankCustomer();

    public BankCustomer transferMoneyQuery(String accountSend, String accountReceive, String amount) {
        Connection connection = null;
        connection = DbConnection.getConnection();
        if (connection == null) {
            return null;
        }
        try {
            String query = "SELECT * FROM account WHERE numberAccount = " +
                    "'" +
                    accountSend +
                    "'" +
                    "";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                Double checkBalance = rs.getDouble("balance");
                if (checkBalance > Double.parseDouble(amount)) {
                    Double currentBalanceSend = checkBalance - Double.parseDouble(amount);
                    PreparedStatement preparedStatement = connection.prepareStatement("Update account SET balance = ? WHERE numberAccount = ?");
                    preparedStatement.setDouble(1, currentBalanceSend);
                    preparedStatement.setString(2, accountSend);
                    preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Transfer Money Success.");
                    try {
                        String query2 = "SELECT * FROM account WHERE numberAccount = " +
                                "'" +
                                accountReceive +
                                "'" +
                                "";
                        Statement statement2 = connection.createStatement();
                        ResultSet rs2 = statement2.executeQuery(query2);
                        if (rs2.next()) {
                            Double checkBalance2 = rs2.getDouble("balance");
                            Double currentBalanceReceive = checkBalance2 + Double.parseDouble(amount);
                            PreparedStatement preparedStatement2 = connection.prepareStatement("Update account SET balance = ? WHERE  numberAccount = ?");
                            preparedStatement2.setDouble(1, currentBalanceReceive);
                            preparedStatement2.setString(2, accountReceive);
                            preparedStatement2.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Receive Money Success.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Receive Money Faild.");
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Input incorrect. Please enter only number.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Transfer Money Faild. Money in your Account not enough.");
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Input incorrect. Please enter only number.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

}
