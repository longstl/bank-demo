package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardAdminController implements Initializable {

    @FXML
    private JFXButton btnSignUp;

    @FXML
    private JFXButton btnAddMoney;

    @FXML
    private JFXButton btnSignOut;

    FormController formController = new FormController();
    public void actSignUp(ActionEvent actionEvent) {
        formController.signUp();
        Stage stage = (Stage) btnSignUp.getScene().getWindow();
        stage.hide();
    }

    public void actAddMoney(ActionEvent actionEvent) {
        formController.addMoney();
        Stage stage = (Stage) btnAddMoney.getScene().getWindow();
        stage.hide();
    }

    public void actSignOut(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null, "Goodbye!!! See you again!!!");
        formController.signInForm();
        Stage stage = (Stage) btnSignOut.getScene().getWindow();
        stage.hide();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
