/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public class Login extends Window implements Initializable{
    
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
        //String css = this.getClass().getResource("general.css").toExternalForm();
        //scene.getStylesheets().add(css);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] key = isRememberMe();
        if(key!=null) {
            rememberMeCheckBox.setSelected(true);
            emailField.setText(key[0]);
            passwordField.setText(key[1]);
        } else {
            rememberMeCheckBox.setSelected(false);
            deleteRemeberMeToken();
        }
        
    }
    
    private String[] isRememberMe() {
        String[] s = null;
        try(FileInputStream fis = new FileInputStream("rememberMe.ser")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            s = (String[]) ois.readObject();
        } catch (Exception e) {}
        return s;
    }
    
    public void login(ActionEvent event) {
        try {
            if(checkLogin()) {
                Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                StaffView staffView = new StaffView();
                staffView.create(primaryStage);
                createLoginToken();
                if(rememberMeCheckBox.isSelected()) {createRemeberMeToken();}
                else {deleteRemeberMeToken();}
            }
        } catch(IOException ioe) {
            System.out.println("File not found in Login login function");
        }
    }
    
    private boolean checkLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();
        return Gym.getStaffList().get(email+password) != null;
    }
    
    private void createLoginToken() {
        try(FileOutputStream fos = new FileOutputStream("logedin.ser")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(String.format("%s%s", emailField.getText(), passwordField.getText()));
        } catch(IOException ioe) {
            System.out.println("File not found in Login createLoginToken");
        } catch (Exception e) {
            System.out.println("Exception Occured in Login createLoginToken");
        }
    }
    
    private void createRemeberMeToken() {
        try(FileOutputStream fos = new FileOutputStream("rememberMe.ser")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            String[] strs = {emailField.getText(), passwordField.getText()};
            oos.writeObject(strs);
        } catch(IOException ioe) {
            System.out.println("File not found in Login createRememberMeToken");
        } catch (Exception e) {
            System.out.println("Exception Occured in Login createRememberMeToken");
        }
    }
    
    private void deleteRemeberMeToken() {
        try {
            File f = new File("rememberMe.ser");
            f.delete();
        } catch(Exception e) {}
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
            RegisterStaff rs = new RegisterStaff();
            RegisterStaff.goBack = this;
            rs.create(primaryStage);
        } catch(IOException ioe) {
            System.out.println("File not found in Login Option");
        }
    }

    
}
