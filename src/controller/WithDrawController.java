package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import model.WithDrawModel;

import java.net.URL;
import java.util.ResourceBundle;

public class WithDrawController implements Initializable {

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

    FormController formController = new FormController();
    WithDrawModel withDrawModel = new WithDrawModel();

    public void actCheck(ActionEvent actionEvent) {
        String accountNumber = txtAccountNumber.getText();

    }

    public void actAddMoney(ActionEvent actionEvent) {
    }

    public void withDraw(){
        String accountNumber = txtAccountNumber.getText();
        String amount = txtMoneyAdd.getText();
        withDrawModel.withDrawQuery(accountNumber,amount);
    }

    public void actBack(ActionEvent actionEvent) {
        formController.memberManagerForm();
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.hide();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
