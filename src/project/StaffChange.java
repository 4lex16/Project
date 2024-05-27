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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public class StaffChange extends Window{


    @FXML
    private TextField addressField;

    @FXML
    private Label addressLabel;

    @FXML
    private Button changeButton;

    @FXML
    private TextField emailField;

    @FXML
    private Label emailLabel;

    @FXML
    private TextField firstNameField;

    @FXML
    private Label firstNameLabel;

    @FXML
    private ChoiceBox<String> genderChoiceBox;

    @FXML
    private Label genderLabel;

    @FXML
    private Button goBackButton;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Label passwordLabel;

    @FXML
    private TextField phoneField;

    @FXML
    private Label phoneLabel;
    
    @FXML
    private AnchorPane parent;
    
    @FXML
    private Label lastNameLabel;
    
    private final String[] genders = {"Male", "Female", "Transformer", "Attack Helicopter", "Other"};
    
    public static String tempuuid;
    public static Window goBack;
    public static Staff staff;
    public static boolean isStaffLogin;
    
    @Override
    public void create(Stage primaryStage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("StaffChange.fxml"));
        scene = new Scene(root);
        stage = primaryStage;
        String css = this.getClass().getResource("general.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("StaffChange");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genderChoiceBox.getItems().addAll(genders);
        firstNameField.setText(staff.getFirstName());
        lastNameField.setText(staff.getLastName());
        emailField.setText(staff.getEmail());
        addressField.setText(staff.getAddress());
        passwordField.setText(staff.getPassword());
        phoneField.setText(staff.getPhoneNumber());
        genderChoiceBox.setValue(staff.getGender());
        css();
    }
    
    private void css() {
        if(isToken("darkmode.ser")) {    
            parent.getStyleClass().add("parent-dark");
            genderChoiceBox.getStyleClass().add("choice-gen-dark");
            firstNameField.getStyleClass().add("input-gen-dark");
            lastNameField.getStyleClass().add("input-gen-dark");
            phoneField.getStyleClass().add("input-gen-dark");
            emailField.getStyleClass().add("input-gen-dark");
            addressField.getStyleClass().add("input-gen-dark");
            passwordField.getStyleClass().add("input-gen-dark");
            
            goBackButton.getStyleClass().add("button-gen-dark");
            changeButton.getStyleClass().add("button-gen-dark");
            
            genderLabel.getStyleClass().add("label-gen-dark");
            firstNameLabel.getStyleClass().add("label-gen-dark");
            lastNameLabel.getStyleClass().add("label-gen-dark");
            phoneLabel.getStyleClass().add("label-gen-dark");
            emailLabel.getStyleClass().add("label-gen-dark");
            addressLabel.getStyleClass().add("label-gen-dark");
            passwordLabel.getStyleClass().add("label-gen-dark");
            
        } else {
            parent.getStyleClass().add("parent");
            genderChoiceBox.getStyleClass().add("choice-gen");
            firstNameField.getStyleClass().add("input-gen");
            lastNameField.getStyleClass().add("input-gen");
            phoneField.getStyleClass().add("input-gen");
            emailField.getStyleClass().add("input-gen");
            addressField.getStyleClass().add("input-gen");
            passwordField.getStyleClass().add("input-gen");
            
            goBackButton.getStyleClass().add("button-gen");
            changeButton.getStyleClass().add("button-gen");
            
            genderLabel.getStyleClass().add("label-gen");
            firstNameLabel.getStyleClass().add("label-gen");
            lastNameLabel.getStyleClass().add("label-gen");
            phoneLabel.getStyleClass().add("label-gen");
            emailLabel.getStyleClass().add("label-gen");
            addressLabel.getStyleClass().add("label-gen");
            passwordLabel.getStyleClass().add("label-gen");
        }
    }
    
    public void goBack(ActionEvent event) {
        try {                                                                                                                                           
            Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            goBack.create(primaryStage);
        } catch(IOException ioes) {
            System.out.println("File not found in Option goBack");
        }
    }
    
    public void change(ActionEvent event) {
        if(!(firstNameField.getText().equals("") || lastNameField.getText().equals("") || genderChoiceBox.getValue() == null || phoneField.getText().equals("") || emailField.getText().equals("")|| addressField.getText().equals("")|| passwordField.getText().equals(""))) {
            Staff newStaff = new Staff(
                    tempuuid,
                    firstNameField.getText(),
                    lastNameField.getText(),
                    genderChoiceBox.getValue(),
                    phoneField.getText(),
                    emailField.getText(),
                    addressField.getText(),
                    passwordField.getText()
            );
            if(newStaff.getKey().equals(staff.getKey()) || Gym.getStaffList().get(newStaff.getKey()) == null) {
                Gym.remove(staff);
                Gym.add(newStaff);
                if(isStaffLogin) createLoginToken();
                goBack(event);
            }
        }
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
