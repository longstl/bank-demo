package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.AddMoneyModel;
import model.CheckAccountNumberModel;

import java.net.URL;
import java.util.ResourceBundle;

public class AddMoneyController implements Initializable {

    @FXML
    public JFXButton btnCheck;

    @FXML
    public JFXButton btnBack;

    @FXML
    public JFXButton btnAdd;

    @FXML
    private JFXTextField txtMoneyAdd;

    @FXML
    private JFXTextField txtAccountNumber;

    FormController formController = new FormController();
    AddMoneyModel addMoneyModel = new AddMoneyModel();
    CheckAccountNumberModel checkAccountNumberModel = new CheckAccountNumberModel();

    public void actCheck(ActionEvent actionEvent) {
        String accountNumber = txtAccountNumber.getText();
        checkAccountNumberModel.checkAccount(accountNumber);
    }

    public void actAddMoney(ActionEvent actionEvent) {
        addMoney();
    }

    public void  addMoney(){
        String accountNumber = txtAccountNumber.getText();
        String amount = txtMoneyAdd.getText();
        addMoneyModel.addMoneyUpdate(accountNumber, amount);
    }

    public void actBack(ActionEvent actionEvent) {
        formController.adminManagerForm();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnAdd.setOnKeyPressed(
                event -> {
                    switch (event.getCode()) {
                        case ENTER:
                            addMoney();
                            break;
                    }
                }
        );
    }
}
