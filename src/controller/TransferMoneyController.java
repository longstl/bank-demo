package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.stage.Stage;
import model.CheckAccountNumberModel;
import model.TransferMoneyModel;

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

    FormController formController = new FormController();
    CheckAccountNumberModel checkAccountNumberModel = new CheckAccountNumberModel();
    TransferMoneyModel transferMoneyModel = new TransferMoneyModel();

    public void actTransfer(ActionEvent actionEvent) {
        transferMoney();
    }

    public void transferMoney(){
        String accountSend = txtAccountSend.getText();
        String accountReceive = txtAccountReceive.getText();
        String amount = txtAmmountSend.getText();
        transferMoneyModel.transferMoneyQuery(accountSend,accountReceive,amount);
    }

    public void actCheckSend(ActionEvent actionEvent) {
        String accountSend = txtAccountSend.getText();
        checkAccountNumberModel.checkAccount(accountSend);
    }

    public void actCheckReceive(ActionEvent actionEvent) {
        String accountReceive = txtAccountReceive.getText();
        checkAccountNumberModel.checkAccount(accountReceive);
    }

    public void actBack(ActionEvent actionEvent) {
        formController.memberManagerForm();
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.hide();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnTransfer.setOnKeyPressed(
                event -> {
                    switch (event.getCode()){
                        case ENTER:
                            transferMoney();
                            break;
                    }
                }
        );
    }
}
