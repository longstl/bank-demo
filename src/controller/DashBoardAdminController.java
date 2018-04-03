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

public class DashBoardAdminController implements Initializable{

    @FXML
    private JFXButton btnSignUp;

    @FXML
    private JFXButton btnAddMoney;

    @FXML
    private JFXButton btnSignOut;

    public void actSignUp(ActionEvent actionEvent) {
        signUp();
        Stage stage = (Stage) btnSignUp.getScene().getWindow();
        stage.hide();
    }

    public void actAddMoney(ActionEvent actionEvent) {
        addMoney();
        Stage stage = (Stage) btnAddMoney.getScene().getWindow();
        stage.hide();
    }

    public void actSignOut(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null, "Goodbye!!! See you again!!!");
        signInForm();
        Stage stage = (Stage) btnSignOut.getScene().getWindow();
        stage.hide();
    }

    @FXML
    public void signUp() {
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("../fxml_file/SignUpForm.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Bank Account Sign Up");
            Image icon = new Image(getClass().getResourceAsStream("/images/icon.png"));
            stage.getIcons().add(icon);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addMoney(){
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("../fxml_file/AddMoney.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Bank Add Money");
            Image icon = new Image(getClass().getResourceAsStream("/images/icon.png"));
            stage.getIcons().add(icon);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void signInForm(){
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
