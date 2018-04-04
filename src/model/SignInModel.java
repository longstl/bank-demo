package model;

import controller.FormController;
import controller.SignInController;
import entity.BankCustomer;
import javafx.stage.Stage;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignInModel {
    BankCustomer customer = new BankCustomer();
    FormController formController = new FormController();
    SignInController signInController = new SignInController();

    public BankCustomer signInQuery(String username, String password, String role){
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
                String queryPwd = rs.getString("password");
                if (queryPwd.equals(password)) {
                    String queryRole = rs.getString("role");
                    if (queryRole.equals(role) && role.equals("admin")) {
                        JOptionPane.showMessageDialog(null, "Sign In Success!!. You login with " + role + " account.");
                        formController.adminManagerForm();
                        Stage stage = (Stage) signInController.btnSignIn.getScene().getWindow();
                        stage.hide();
                    } else if (queryRole.equals(role) && role.equals("member")) {
                        JOptionPane.showMessageDialog(null, "Sign In Success!!. You login with " + role + " account.");
                        formController.memberManagerForm();
                        Stage stage = (Stage) signInController.btnSignIn.getScene().getWindow();
                        stage.hide();
                    } else {
                        JOptionPane.showMessageDialog(null, "Role wrong.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Password wrong.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username is not exist.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can not connect");
        }
        return customer;
    }

}
