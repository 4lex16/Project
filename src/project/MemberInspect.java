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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public class MemberInspect extends Window implements Initializable{

@FXML
    private Label addressLabel;

    @FXML
    private Label creditCardNumberLabel;

    @FXML
    private VBox creditCardVBox;

    @FXML
    private Label cvvLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label expDateLabel;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label genderLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label memberShipLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label paymentMethod;

    @FXML
    private Label phoneNumberLabel;

    @FXML
    private Label timeLabel;
    
    public static Window goBack;
    public static Member member;
    
    @Override
    public void create(Stage primaryStage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MemberInspect.fxml"));
        scene = new Scene(root);
        stage = primaryStage;
        //String css = this.getClass().getResource("general.css").toExternalForm();
        //scene.getStylesheets().add(css);
        stage.setTitle("MemberInspect");
        stage.setScene(scene);
        stage.show(); 
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        firstNameLabel.setText(member.getFirstName());
        lastNameLabel.setText(member.getLastName());
        genderLabel.setText(member.getGender());
        emailLabel.setText(member.getEmail());
        addressLabel.setText(member.getAddress());
        passwordLabel.setText(member.getPassword());
        phoneNumberLabel.setText(member.getPhoneNumber());
        memberShipLabel.setText(member.getMemberShip());
        timeLabel.setText(member.getTime());
        paymentMethod.setText(member.getPaymentMethod());
        
        if(member.getPaymentMethod().equalsIgnoreCase("credit")) {
            creditCardVBox.setVisible(true);
            creditCardNumberLabel.setText(member.getCreditCardNumber());
            cvvLabel.setText(member.getCvv());
            expDateLabel.setText(member.getExpDate());
        } else {
            creditCardVBox.setVisible(false);
        }
    }
    
    public void goBack(ActionEvent event) {
        try {                                                                                                                                           
            Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            goBack.create(primaryStage);
        } catch(IOException ioes) {
            System.out.println("File not found in MemberInspect goBack");
        }
    }
}
