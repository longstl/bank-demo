package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;

public class TransferMoneyController implements Initializable {

    @FXML
    private JFXButton btnCheckSend;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXTextField txtAccountSend;

    @FXML
    private JFXTextField txtAmmountSend;

    @FXML
    private JFXButton btnTransfer;

    @FXML
    private JFXButton btnCheckReceive;

    @FXML
    private JFXTextField txtAccountReceive;


    public void actTransfer(ActionEvent actionEvent) {
        String accountSend = txtAccountSend.getText();
        String accountReceive = txtAccountReceive.getText();
        String amount = txtAmmountSend.getText();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_data", "root", "");
            System.out.println("Connection Success!!!");
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
                        }else {
                            JOptionPane.showMessageDialog(null, "Receive Money Faild.");
                        }
                    }catch (NumberFormatException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Input incorrect. Please enter only number.");
                    }catch (SQLException e) {
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
    }

    public void actCheckSend(ActionEvent actionEvent) {
        String accountSend = txtAccountSend.getText();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_data", "root", "");
            System.out.println("Connection Success!!!");
            String query = "SELECT * FROM account WHERE numberAccount = " +
                    "'" +
                    accountSend +
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

    public void actCheckReceive(ActionEvent actionEvent) {
        String accountReceive = txtAccountReceive.getText();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_data", "root", "");
            System.out.println("Connection Success!!!");
            String query = "SELECT * FROM account WHERE numberAccount = " +
                    "'" +
                    accountReceive +
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

    public void actBack(ActionEvent actionEvent) {
        memberManagerForm();
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.hide();
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
        btnTransfer.setOnKeyPressed(
                event -> {
                    switch (event.getCode()){
                        case ENTER:
                            String accountSend = txtAccountSend.getText();
                            String accountReceive = txtAccountReceive.getText();
                            String amount = txtAmmountSend.getText();

                            try {
                                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_data", "root", "");
                                System.out.println("Connection Success!!!");
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
                                            }else {
                                                JOptionPane.showMessageDialog(null, "Receive Money Faild.");
                                            }
                                        }catch (NumberFormatException e) {
                                            e.printStackTrace();
                                            JOptionPane.showMessageDialog(null, "Input incorrect. Please enter only number.");
                                        }catch (SQLException e) {
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
                            break;
                    }
                }
        );
    }
}
