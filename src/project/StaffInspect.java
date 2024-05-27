/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public class StaffInspect extends Window{

    @FXML
    private Label addressInput;

    @FXML
    private Label addressLabel;

    @FXML
    private Label emailInput;

    @FXML
    private Label emailLabel;

    @FXML
    private Label firstNameInput;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label genderInput;

    @FXML
    private Label genderLabel;

    @FXML
    private Button goBackButton;

    @FXML
    private Label lastNameInput;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Button optionButton;

    @FXML
    private AnchorPane parent;

    @FXML
    private Label passwordInput;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label phoneInput;

    @FXML
    private Label phoneLabel;
    
    public static Window goBack;
    
    public static Staff staff;
    
    @Override
    public void create(Stage primaryStage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("StaffInspect.fxml"));
        scene = new Scene(root);
        stage = primaryStage;
        String css = this.getClass().getResource("general.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("StaffInspect");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        firstNameInput.setText(staff.getFirstName());
        lastNameInput.setText(staff.getLastName());
        genderInput.setText(staff.getGender());
        emailInput.setText(staff.getEmail());
        addressInput.setText(staff.getAddress());
        passwordInput.setText(staff.getPassword());
        phoneInput.setText(staff.getPhoneNumber());
        css();
    }
    
        private void css() {
        if(isToken("darkmode.ser")) {    
            parent.getStyleClass().add("parent-dark");
            genderInput.getStyleClass().add("label-gen-dark");
            firstNameInput.getStyleClass().add("label-gen-dark");
            lastNameInput.getStyleClass().add("label-gen-dark");
            phoneInput.getStyleClass().add("label-gen-dark");
            emailInput.getStyleClass().add("label-gen-dark");
            addressInput.getStyleClass().add("label-gen-dark");
            passwordInput.getStyleClass().add("label-gen-dark");
            
            goBackButton.getStyleClass().add("button-gen-dark");
            
            genderLabel.getStyleClass().add("label-gen-dark");
            firstNameLabel.getStyleClass().add("label-gen-dark");
            lastNameLabel.getStyleClass().add("label-gen-dark");
            phoneLabel.getStyleClass().add("label-gen-dark");
            emailLabel.getStyleClass().add("label-gen-dark");
            addressLabel.getStyleClass().add("label-gen-dark");
            passwordLabel.getStyleClass().add("label-gen-dark");
            
        } else {
            parent.getStyleClass().add("parent");
            genderInput.getStyleClass().add("label-gen");
            firstNameInput.getStyleClass().add("label-gen");
            lastNameInput.getStyleClass().add("label-gen");
            phoneInput.getStyleClass().add("label-gen");
            emailInput.getStyleClass().add("label-gen");
            addressInput.getStyleClass().add("label-gen");
            passwordInput.getStyleClass().add("label-gen");
            
            goBackButton.getStyleClass().add("button-gen");
            
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
            Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            goBack.create(primaryStage);
        } catch(IOException ioes) {
            System.out.println("File not found in Option goBack");
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
}
