package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class FormController {

    @FXML
    public void adminManagerForm() {
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("../fxml_file/DashBoardAdmin.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Bank Account Admin DashBoard");
            Image icon = new Image(getClass().getResourceAsStream("/images/icon.png"));
            stage.getIcons().add(icon);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void memberManagerForm() {
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("../fxml_file/DashBoardMember.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Bank Account Member DashBoard");
            Image icon = new Image(getClass().getResourceAsStream("/images/icon.png"));
            stage.getIcons().add(icon);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
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

    @FXML
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

    @FXML
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

    @FXML
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

}
