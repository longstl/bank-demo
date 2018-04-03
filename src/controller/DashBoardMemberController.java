package controller;

import com.jfoenix.controls.JFXButton;
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

    public void actCheckBalance(ActionEvent actionEvent) {
        checkBalance();
        Stage stage = (Stage) btnCheckBalance.getScene().getWindow();
        stage.hide();
    }

    public void actWithDraw(ActionEvent actionEvent) {
        withDraw();
        Stage stage = (Stage) btnWithDraw.getScene().getWindow();
        stage.hide();
    }

    public void actSendMoney(ActionEvent actionEvent) {
        transferMoney();
        Stage stage = (Stage) btnSendMoney.getScene().getWindow();
        stage.hide();
    }

    public void actSignOut(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null, "Goodbye!!! See you again!!!");
        signInForm();
        Stage stage = (Stage) btnSignOut.getScene().getWindow();
        stage.hide();
    }

    public void signInForm() {
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("../fxml_file/SignInForm.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Bank Account Sign In");
            Image icon = new Image(getClass().getResourceAsStream("/images/icon.png"));
            stage.getIcons().add(icon);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkBalance() {
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("../fxml_file/CheckBalance.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Bank Check Balance");
            Image icon = new Image(getClass().getResourceAsStream("/images/icon.png"));
            stage.getIcons().add(icon);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void withDraw() {
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("../fxml_file/WithDraw.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Bank With Draw Money");
            Image icon = new Image(getClass().getResourceAsStream("/images/icon.png"));
            stage.getIcons().add(icon);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void transferMoney() {
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("../fxml_file/TransferMoney.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Bank Transfer Money");
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
