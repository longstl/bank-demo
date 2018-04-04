package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import model.CheckAccountNumberModel;

import java.net.URL;
import java.util.ResourceBundle;

public class CheckBalanceController implements Initializable {


    @FXML
    private JFXButton btnCheck;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXTextField txtAccountNumber;

    FormController formController = new FormController();
    CheckAccountNumberModel checkAccountNumberModel = new CheckAccountNumberModel();

    public void actBack(ActionEvent actionEvent) {
        formController.memberManagerForm();
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.hide();
    }

    public void actCheck(ActionEvent actionEvent) {
        String accountNumber = txtAccountNumber.getText();
        checkAccountNumberModel.checkAccount(accountNumber);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
