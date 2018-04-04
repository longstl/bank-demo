package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.util.Optional;
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
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sign Out Notice");
        alert.setHeaderText("Do you want to Sign out?");
        alert.setContentText("Please Choice Yes or No");
        ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(buttonTypeYes,buttonTypeNo);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeYes){
            JOptionPane.showMessageDialog(null, "Goodbye!!! See you again!!!");
            formController.signInForm();
            Stage stage = (Stage) btnSignOut.getScene().getWindow();
            stage.hide();
        }else{
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
