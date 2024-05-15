/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public class RegisterStaff extends Window implements Initializable{
    
    @FXML
    private TextField addressField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField firstNameField;

    @FXML
    private ChoiceBox<String> genderChoiceBox;
    
    private String[] genders = {"Male", "Female", "Transformer", "Attack Helicopter", "Other"};

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField phoneNumberField;
    
    public static Window goBack;
    
    @Override
    public void create(Stage primaryStage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("RegisterStaff.fxml"));
        scene = new Scene(root);
        stage = primaryStage;
        //String css = this.getClass().getResource("general.css").toExternalForm();
        //scene.getStylesheets().add(css);
        stage.setTitle("Register");
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genderChoiceBox.getItems().addAll(genders);
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
    
    
    public void goBack(ActionEvent event) {
        try {
            Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            goBack.create(primaryStage);
        } catch(IOException ioes) {
            System.out.println("File not found in Option goBack");
        }
    }
    
    public void register(ActionEvent event) {
        try {
            if(checkRegister()) {
                Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                StaffView sv = new StaffView();
                sv.create(primaryStage);
                createLoginToken();
            }
        } catch(IOException ioe) {
            System.out.println("File not found in Login Option");
        }
    }
    
    private boolean checkRegister() {
        if(firstNameField.getText().equals("") || lastNameField.getText().equals("") || genderChoiceBox.getValue().equals("") || phoneNumberField.getText().equals("") || emailField.getText().equals("")|| addressField.getText().equals("")|| passwordField.getText().equals("")) {
            System.out.println("nigga");
            return false;
        }
        String key = emailField.getText()+passwordField.getText();
        Staff newStaff = new Staff(
                firstNameField.getText(),
                lastNameField.getText(),
                genderChoiceBox.getValue(),
                phoneNumberField.getText(),
                emailField.getText(),
                addressField.getText(),
                passwordField.getText()
        );
        if(Gym.getStaffList().get(key) == null) {
            Gym.add(newStaff);
            return true;
        }
        return false;
    }
    
    private void createLoginToken() {
        try(FileOutputStream fos = new FileOutputStream("logedin.ser")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(String.format("%s%s", emailField.getText(), passwordField.getText()));
        } catch(IOException ioe) {
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println("Exception Occured");
        }
    }
}
