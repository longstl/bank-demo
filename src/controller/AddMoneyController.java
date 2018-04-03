package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entity.BankCustomer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AddMoneyController implements Initializable {

    @FXML
    private JFXButton btnCheck;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXTextField txtMoneyAdd;

    @FXML
    private JFXTextField txtAccountNumber;

    public void actCheck(ActionEvent actionEvent) {
        String accountNumber = txtAccountNumber.getText();

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
    }

    public void actAddMoney(ActionEvent actionEvent) {
        String accountNumber = txtAccountNumber.getText();
        String amount = txtMoneyAdd.getText();
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
                Double currentBalance = checkBalance + Double.parseDouble(amount);
                String addMoneyQuery = "Update account Set balance = ? where numberAccount = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(addMoneyQuery);
                preparedStatement.setDouble(1, currentBalance);
                preparedStatement.setString(2, accountNumber);
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Add Money Success!!!");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actBack(ActionEvent actionEvent) {
        adminManagerForm();
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.hide();
    }

    @FXML
    public void adminManagerForm() {
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("../fxml_file/DashBoardAdmin.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Bank Account Admin DashBoard");
            Image icon = new Image(getClass().getResourceAsStream("/images/icon.png"));
            stage.getIcons().add(icon);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
