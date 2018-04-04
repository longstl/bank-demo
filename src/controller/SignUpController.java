package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import model.SignUpModel;

import javax.swing.*;
import java.net.URL;
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

    FormController formController = new FormController();
    SignUpModel signUpModel = new SignUpModel();

    public void actSignUp(ActionEvent actionEvent) {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String accountNumber = txtAccountName.getText();

        long createAt = new Long(System.currentTimeMillis());

        if (username.length() < 6 && password.length() < 7 && accountNumber.length() < 8 || username == null && password == null && accountNumber == null) {
            JOptionPane.showMessageDialog(null, "Sign Up Faild!!");
        } else {
            signUpModel.signUpInsert(username, accountNumber, password, createAt);
        }
    }

    public void actBack(ActionEvent actionEvent) {
        formController.adminManagerForm();
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.hide();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
