package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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

public class CheckBalanceController implements Initializable {


    @FXML
    private JFXButton btnCheck;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXTextField txtAccountNumber;

    public void actBack(ActionEvent actionEvent) {
        memberManagerForm();
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.hide();
    }

    public void actCheck(ActionEvent actionEvent) {
        String accountNumber = txtAccountNumber.getText();

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_data", "root", "");
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

    @FXML
    public void memberManagerForm() {
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("../fxml_file/DashBoardMember.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Bank Account Member DashBoard");
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
