/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public class Login extends Window{
    
    @FXML
    private Button optionButton;
    
    @FXML
    private AnchorPane parent;
    
    @FXML
    private Button signinButton, signupButton;
    
    @FXML
    private Label emailLabel, passwordLabel, signupLabel;
    
    @FXML
    private TextField emailField;
    
    @FXML
    private PasswordField passwordField;
    
    @FXML
    private CheckBox rememberMeCheckBox;
    
    @Override
    public void create(Stage primaryStage) throws IOException{
        
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        scene = new Scene(root);
        stage = primaryStage;
        String css = this.getClass().getResource("general.css").toExternalForm();
        String css2 = this.getClass().getResource("login.css").toExternalForm();
        scene.getStylesheets().add(css);
        scene.getStylesheets().add(css2);
        stage.setTitle("Login");
        stage.resizableProperty().set(false);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        css();
        deleteLoginToken();
        String[] key = isRememberMe();
        if(key!=null) {
            rememberMeCheckBox.setSelected(true);
            emailField.setText(key[0]);
            passwordField.setText(key[1]);
        } else {
            rememberMeCheckBox.setSelected(false);
            deleteRememberMeToken();
        }
    }
    
    private void css() {
        if (isToken("darkmode.ser")) {
            parent.getStyleClass().add("parent-dark");
            signinButton.getStyleClass().add("button-gen-dark");
            signupButton.getStyleClass().add("sign-up-button-dark");
            emailField.getStyleClass().add("input-gen-dark");
            passwordField.getStyleClass().add("input-gen-dark");
            rememberMeCheckBox.getStyleClass().add("login-check-dark");
            optionButton.getStyleClass().add("button-gen-dark");
            emailLabel.getStyleClass().add("label-gen-dark");
            passwordLabel.getStyleClass().add("label-gen-dark");
            signupLabel.getStyleClass().add("label-gen-dark");
        } else {
            parent.getStyleClass().add("parent");
            signinButton.getStyleClass().add("button-gen");
            signupButton.getStyleClass().add("sign-up-button");
            emailField.getStyleClass().add("input-gen");
            passwordField.getStyleClass().add("input-gen");
            rememberMeCheckBox.getStyleClass().add("login-check");
            optionButton.getStyleClass().add("button-gen");
            emailLabel.getStyleClass().add("label-gen");
            passwordLabel.getStyleClass().add("label-gen");
            signupLabel.getStyleClass().add("label-gen");
        }
    }
    
    public void login(ActionEvent event) {
        try {
            String email = emailField.getText();
            String password = passwordField.getText();
            if(isLogin()) {
                Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                StaffView staffView = new StaffView();
                staffView.create(primaryStage);
                createLoginToken(email, password);
                if(rememberMeCheckBox.isSelected()) {createRememberMeToken(email, password);}
                else {deleteRememberMeToken();}
            }
        } catch(IOException ioe) {
            System.out.println("File not found in Login login function");
        }
    }
    
    private boolean isLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();
        return Gym.getStaffList().get(email+password) != null;
    }
    
    private String[] isRememberMe() {
        String[] s = null;
        try(FileInputStream fis = new FileInputStream("rememberMe.ser")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            s = (String[]) ois.readObject();
        } catch (Exception e) {}
        return s;
    }

    public void option(ActionEvent event) {
        try {
            Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Option option = new Option();
            Option.goBack = this;
            option.create(primaryStage);
        } catch(IOException ioe) {
            System.out.println("File not found in Login Option");
        }
    }
    
    public void register(ActionEvent event) {
        try {
            Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            StaffRegister rs = new StaffRegister();
            StaffRegister.goBack = this;
            rs.create(primaryStage);
        } catch(IOException ioe) {
            System.out.println("File not found in Login Option");
        }
    }

    
}
