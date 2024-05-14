/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public class Login extends Window {
    
    @FXML
    private TextField emailField;
    
    @FXML
    private PasswordField passwordField;
    
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
    
    public void login(ActionEvent event) {
        
        try {
            if(checkLogin()) {
                Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                StaffView staffView = new StaffView();
                staffView.create(primaryStage);
                createLoginToken();
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
            oos.writeObject(""); // add email+password string
        } catch(IOException ioe) {
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println("Exception Occured");
        }
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
