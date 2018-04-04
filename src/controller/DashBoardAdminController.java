package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.util.Optional;
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
