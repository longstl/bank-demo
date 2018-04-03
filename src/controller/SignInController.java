package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
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
import java.sql.*;
import java.util.ResourceBundle;

public class SignInController implements Initializable {

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXButton btnSignIn;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXTextField txtRole;

    public void actSignIn(ActionEvent actionEvent) {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String role = txtRole.getText();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_data", "root", "");
            System.out.println("Connect succcess!!!!");
            String query = "Select * from account where username =" +
                    "'" +
                    username +
                    "'" +
                    "";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                String queryPwd = rs.getString("password");
                if (queryPwd.equals(password)) {
                    String queryRole = rs.getString("role");
                    if (queryRole.equals(role) && role.equals("admin")) {
                        JOptionPane.showMessageDialog(null, "Sign In Success!!. You login with " + role + " account.");
                        adminManagerForm();
                        Stage stage = (Stage) btnSignIn.getScene().getWindow();
                        stage.hide();
                    } else if (queryRole.equals(role) && role.equals("member")) {
                        JOptionPane.showMessageDialog(null, "Sign In Success!!. You login with " + role + " account.");
                        memberManagerForm();
                        Stage stage = (Stage) btnSignIn.getScene().getWindow();
                        stage.hide();
                    } else {
                        JOptionPane.showMessageDialog(null, "Role wrong.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Password wrong.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username is not exist.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can not connect");
        }
    }

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnSignIn.setOnKeyPressed(
                event -> {
                    switch (event.getCode()){
                        case ENTER:
                            String username = txtUsername.getText();
                            String password = txtPassword.getText();
                            String role = txtRole.getText();
                            Connection connection = null;
                            try {
                                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_data", "root", "");
                                System.out.println("Connect succcess!!!!");
                                String query = "Select * from account where username =" +
                                        "'" +
                                        username +
                                        "'" +
                                        "";
                                Statement statement = connection.createStatement();
                                ResultSet rs = statement.executeQuery(query);
                                if (rs.next()) {
                                    String queryPwd = rs.getString("password");
                                    if (queryPwd.equals(password)) {
                                        String queryRole = rs.getString("role");
                                        if (queryRole.equals(role) && role.equals("admin")) {
                                            JOptionPane.showMessageDialog(null, "Sign In Success!!. You login with " + role + " account.");
                                            adminManagerForm();
                                            Stage stage = (Stage) btnSignIn.getScene().getWindow();
                                            stage.hide();
                                        } else if (queryRole.equals(role) && role.equals("member")) {
                                            JOptionPane.showMessageDialog(null, "Sign In Success!!. You login with " + role + " account.");
                                            memberManagerForm();
                                            Stage stage = (Stage) btnSignIn.getScene().getWindow();
                                            stage.hide();
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Role wrong.");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Password wrong.");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Username is not exist.");
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                                System.out.println("Can not connect");
                            }
                            break;
                    }
                }
        );
    }
}
