package model;

import entity.BankCustomer;

import javax.swing.*;
import java.sql.*;

public class SignUpModel {

    BankCustomer customer = new BankCustomer();

    public BankCustomer signUpInsert(String username, String accountNumber, String password, long createAt) {
        Connection connection = null;
        connection = DbConnection.getConnection();

        if (connection == null){
            return null;
        }
        try {
            String query = "Select * from account where username =" +
                    "'" +
                    username +
                    "'" +
                    "";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Username has exist.");
                String accQuery = rs.getString("numberAccount");
                if (accQuery.equals(accountNumber)) {
                    JOptionPane.showMessageDialog(null, "Account Number has exist.");
                } else {
                    System.out.println("Account Number OK!!");
                }
            } else {
                String queryCreate = "insert into account (username, password, numberAccount, createAt) values (?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(queryCreate);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, accountNumber);
                preparedStatement.setLong(4, createAt);
                preparedStatement.execute();
                JOptionPane.showMessageDialog(null, "Sign Up Success!!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
