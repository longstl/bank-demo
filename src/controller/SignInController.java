package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import model.SignInModel;

import java.net.URL;
import java.util.ResourceBundle;

public class SignInController implements Initializable {

    @FXML
    private JFXTextField txtUsername;

    @FXML
    public JFXButton btnSignIn;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXTextField txtRole;

    public void actSignIn(ActionEvent actionEvent) {
        signInInput();
    }

    public void signInInput() {
        SignInModel signInModel = new SignInModel();
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String role = txtRole.getText();
        signInModel.signInQuery(username, password, role);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnSignIn.setOnKeyPressed(
                event -> {
                    switch (event.getCode()) {
                        case ENTER:
                            signInInput();
                            break;
                    }
                }
        );
    }
}
