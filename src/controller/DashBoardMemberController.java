package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardMemberController implements Initializable {

    @FXML
    private JFXButton btnCheckBalance;

    @FXML
    private JFXButton btnSignOut;

    @FXML
    private JFXButton btnSendMoney;

    @FXML
    private JFXButton btnWithDraw;

    FormController formController = new FormController();
    public void actCheckBalance(ActionEvent actionEvent) {
        formController.checkBalance();
        Stage stage = (Stage) btnCheckBalance.getScene().getWindow();
        stage.hide();
    }

    public void actWithDraw(ActionEvent actionEvent) {
        formController.withDraw();
        Stage stage = (Stage) btnWithDraw.getScene().getWindow();
        stage.hide();
    }

    public void actSendMoney(ActionEvent actionEvent) {
        formController.transferMoney();
        Stage stage = (Stage) btnSendMoney.getScene().getWindow();
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
