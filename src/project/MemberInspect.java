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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public class MemberInspect extends Window{

    @FXML
    private Label addressInput;

    @FXML
    private Label addressLabel;

    @FXML
    private VBox creditCardVBox;

    @FXML
    private Label creditInput;

    @FXML
    private Label creditLabel;

    @FXML
    private Label cvvInput;

    @FXML
    private Label cvvLabel;

    @FXML
    private Label emailInput;

    @FXML
    private Label emailLabel;

    @FXML
    private Label expInput;

    @FXML
    private Label expLabel;

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
    private Label membershipInput;

    @FXML
    private Label membershipLabel;

    @FXML
    private Label passwordInput;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label paymentInput;

    @FXML
    private Label paymentLabel;

    @FXML
    private Label phoneInput;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label timeInput;

    @FXML
    private Label timeLabel;
    
    @FXML
    private AnchorPane parent;
    
    public static Window goBack;
    public static Member member;
    
    @Override
    public void create(Stage primaryStage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MemberInspect.fxml"));
        scene = new Scene(root);
        stage = primaryStage;
        String css = this.getClass().getResource("general.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("MemberInspect");
        stage.setScene(scene);
        stage.show(); 
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        firstNameInput.setText(member.getFirstName());
        lastNameInput.setText(member.getLastName());
        genderInput.setText(member.getGender());
        emailInput.setText(member.getEmail());
        addressInput.setText(member.getAddress());
        passwordInput.setText(member.getPassword());
        phoneInput.setText(member.getPhoneNumber());
        membershipInput.setText(member.getMemberShip());
        timeInput.setText(member.getTime());
        paymentInput.setText(member.getPaymentMethod());
        
        if(member.getPaymentMethod().equalsIgnoreCase("credit")) {
            creditCardVBox.setVisible(true);
            creditInput.setText(member.getCreditCardNumber());
            cvvInput.setText(member.getCvv());
            expInput.setText(member.getExpDate());
        } else {
            creditCardVBox.setVisible(false);
        }
        css();
    }
    
        private void css() {
        if(isToken("darkmode.ser")) {    
            parent.getStyleClass().add("parent-dark");
            genderInput.getStyleClass().add("choice-gen-dark");
            membershipInput.getStyleClass().add("choice-gen-dark");
            paymentInput.getStyleClass().add("choice-gen-dark");
            timeInput.getStyleClass().add("choice-gen-dark");
            firstNameInput.getStyleClass().add("choice-gen-dark");
            lastNameInput.getStyleClass().add("choice-gen-dark");
            phoneInput.getStyleClass().add("choice-gen-dark");
            emailInput.getStyleClass().add("choice-gen-dark");
            addressInput.getStyleClass().add("choice-gen-dark");
            passwordInput.getStyleClass().add("choice-gen-dark");
            creditInput.getStyleClass().add("choice-gen-dark");
            cvvInput.getStyleClass().add("choice-gen-dark");
            expInput.getStyleClass().add("choice-gen-dark");
            
            goBackButton.getStyleClass().add("button-gen-dark");
            
            genderLabel.getStyleClass().add("label-gen-dark");
            membershipLabel.getStyleClass().add("label-gen-dark");
            paymentLabel.getStyleClass().add("label-gen-dark");
            timeLabel.getStyleClass().add("label-gen-dark");
            firstNameLabel.getStyleClass().add("label-gen-dark");
            lastNameLabel.getStyleClass().add("label-gen-dark");
            phoneLabel.getStyleClass().add("label-gen-dark");
            emailLabel.getStyleClass().add("label-gen-dark");
            addressLabel.getStyleClass().add("label-gen-dark");
            passwordLabel.getStyleClass().add("label-gen-dark");
            creditLabel.getStyleClass().add("label-gen-dark");
            cvvLabel.getStyleClass().add("label-gen-dark");
            expLabel.getStyleClass().add("label-gen-dark");
            
        } else {
            parent.getStyleClass().add("parent");
            genderInput.getStyleClass().add("choice-gen");
            membershipInput.getStyleClass().add("choice-gen");
            paymentInput.getStyleClass().add("choice-gen");
            timeInput.getStyleClass().add("choice-gen");
            firstNameInput.getStyleClass().add("choice-gen");
            lastNameInput.getStyleClass().add("choice-gen");
            phoneInput.getStyleClass().add("choice-gen");
            emailInput.getStyleClass().add("choice-gen");
            addressInput.getStyleClass().add("choice-gen");
            passwordInput.getStyleClass().add("choice-gen");
            creditInput.getStyleClass().add("choice-gen");
            cvvInput.getStyleClass().add("choice-gen");
            expInput.getStyleClass().add("choice-gen");
            
            goBackButton.getStyleClass().add("button-gen");
            
            genderLabel.getStyleClass().add("label-gen");
            membershipLabel.getStyleClass().add("label-gen");
            paymentLabel.getStyleClass().add("label-gen");
            timeLabel.getStyleClass().add("label-gen");
            firstNameLabel.getStyleClass().add("label-gen");
            lastNameLabel.getStyleClass().add("label-gen");
            phoneLabel.getStyleClass().add("label-gen");
            emailLabel.getStyleClass().add("label-gen");
            addressLabel.getStyleClass().add("label-gen");
            passwordLabel.getStyleClass().add("label-gen");
            creditLabel.getStyleClass().add("label-gen");
            cvvLabel.getStyleClass().add("label-gen");
            expLabel.getStyleClass().add("label-gen");
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
