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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public class StaffInspect extends Window implements Initializable{

    @FXML
    private Label addressLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label genderLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label phoneNumberLabel;
    
    public static Window goBack;
    
    public static Staff staff;
    
    @Override
    public void create(Stage primaryStage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("StaffInspect.fxml"));
        scene = new Scene(root);
        stage = primaryStage;
        //String css = this.getClass().getResource("general.css").toExternalForm();
        //scene.getStylesheets().add(css);
        stage.setTitle("Option");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        firstNameLabel.setText(staff.getFirstName());
        lastNameLabel.setText(staff.getLastName());
        genderLabel.setText(staff.getGender());
        emailLabel.setText(staff.getEmail());
        addressLabel.setText(staff.getAddress());
        passwordLabel.setText(staff.getPassword());
        phoneNumberLabel.setText(staff.getPhoneNumber());
    }
    
    public void goBack(ActionEvent event) {
        try {                                                                                                                                           
            Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            goBack.create(primaryStage);
        } catch(IOException ioes) {
            System.out.println("File not found in Option goBack");
        }
    }
}
