package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
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


public class SignUpController implements Initializable {

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXButton btnSignUp;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXTextField txtAccountName;

    @FXML
    private JFXButton btnBack;


    public void actSignUp(ActionEvent actionEvent) {
        BankCustomer bankCustomer = new BankCustomer();

        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String accountNumber = txtAccountName.getText();

        long createAt = new Long(System.currentTimeMillis());
        bankCustomer.setCreateAt(createAt);

        if (username.length() < 6 && password.length() < 7 && accountNumber.length() < 8 || username == null && password == null && accountNumber == null) {
            JOptionPane.showMessageDialog(null, "Sign Up Faild!!");

        } else {
            try {
                Connection connection = null;
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_data", "root", "");
                System.out.println("Connect Success!!!");
                String query = "Select * from account where username =" +
                        "'" +
                        username +
                        "'" +
                        "";
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query);
                if (rs.next()){
                    JOptionPane.showMessageDialog(null,"Username has exist.");
                    String accQuery = rs.getString("numberAccount");
                    if (accQuery.equals(accountNumber)){
                        JOptionPane.showMessageDialog(null,"Account Number has exist.");
                    }else {
                        System.out.println("Account Number OK!!");
                    }
                }else {
                    String queryCreate = "insert into account (username, password, numberAccount, createAt) values (?,?,?,?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(queryCreate);
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);
                    preparedStatement.setString(3, accountNumber);
                    preparedStatement.setLong(4, bankCustomer.getCreateAt());
                    preparedStatement.execute();
                    JOptionPane.showMessageDialog(null,"Sign Up Success!!!");
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
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
