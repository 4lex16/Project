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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public class MemberChange extends Window{
    
    @FXML
    private TextField addressInput;

    @FXML
    private Label addressLabel;

    @FXML
    private Button changeButton;

    @FXML
    private VBox creditCardVBox;

    @FXML
    private TextField creditInput;

    @FXML
    private Label creditLabel;

    @FXML
    private TextField cvvInput;

    @FXML
    private Label cvvLabel;

    @FXML
    private TextField emailInput;

    @FXML
    private Label emailLabel;

    @FXML
    private TextField expInput;

    @FXML
    private Label expLabel;

    @FXML
    private TextField firstNameInput;

    @FXML
    private Label firstNameLabel;

    @FXML
    private ChoiceBox<String> genderChoiceBox;

    @FXML
    private Label genderLabel;

    @FXML
    private Button goBackButton;

    @FXML
    private TextField lastNameInput;

    @FXML
    private Label lastNameLabel;

    @FXML
    private ChoiceBox<String> membershipChoiceBox;

    @FXML
    private Label membershipLabel;

    @FXML
    private AnchorPane parent;

    @FXML
    private TextField passwordInput;

    @FXML
    private Label passwordLabel;
    
    @FXML
    private Label phoneLabel;

    @FXML
    private Label paymentLabel;

    @FXML
    private ChoiceBox<String> paymentMethodChoiceBox;

    @FXML
    private TextField phoneInput;

    @FXML
    private ChoiceBox<String> timeChoiceBox;

    @FXML
    private Label timeLabel;
    
    private final String[] payments = {"Cash", "Credit"};
    private final String[] times = {"Monthly", "Yearly"};
    private final String[] genders = {"Male", "Female", "Transformer", "Attack Helicopter", "Other"};
    private final String[] memberships = {"Regular", "Premium"};
    
    public static Window goBack;
    public static Member member;
    public static String tempuuid;
    
    @Override
    public void create(Stage primaryStage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MemberChange.fxml"));
        scene = new Scene(root);
        stage = primaryStage;
        String css = this.getClass().getResource("general.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("MemberChange");
        stage.setScene(scene);
        stage.show(); 
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genderChoiceBox.getItems().addAll(genders);
        membershipChoiceBox.getItems().addAll(memberships);
        paymentMethodChoiceBox.getItems().addAll(payments);
        timeChoiceBox.getItems().addAll(times);
        
        firstNameInput.setText(member.getFirstName());
        lastNameInput.setText(member.getLastName());
        phoneInput.setText(member.getPhoneNumber());
        emailInput.setText(member.getEmail());
        addressInput.setText(member.getAddress());
        passwordInput.setText(member.getPassword());
        
        genderChoiceBox.setValue(member.getGender());
        membershipChoiceBox.setValue(member.getMemberShip());
        paymentMethodChoiceBox.setValue(member.getPaymentMethod());
        timeChoiceBox.setValue(member.getTime());
        
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
            genderChoiceBox.getStyleClass().add("choice-gen-dark");
            membershipChoiceBox.getStyleClass().add("choice-gen-dark");
            paymentMethodChoiceBox.getStyleClass().add("choice-gen-dark");
            timeChoiceBox.getStyleClass().add("choice-gen-dark");
            firstNameInput.getStyleClass().add("input-gen-dark");
            lastNameInput.getStyleClass().add("input-gen-dark");
            phoneInput.getStyleClass().add("input-gen-dark");
            emailInput.getStyleClass().add("input-gen-dark");
            addressInput.getStyleClass().add("input-gen-dark");
            passwordInput.getStyleClass().add("input-gen-dark");
            creditInput.getStyleClass().add("input-gen-dark");
            cvvInput.getStyleClass().add("input-gen-dark");
            expInput.getStyleClass().add("input-gen-dark");
            goBackButton.getStyleClass().add("button-gen-dark");
            changeButton.getStyleClass().add("button-gen-dark");
            
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
            genderChoiceBox.getStyleClass().add("choice-gen");
            membershipChoiceBox.getStyleClass().add("choice-gen");
            paymentMethodChoiceBox.getStyleClass().add("choice-gen");
            timeChoiceBox.getStyleClass().add("choice-gen");
            firstNameInput.getStyleClass().add("input-gen");
            lastNameInput.getStyleClass().add("input-gen");
            phoneInput.getStyleClass().add("input-gen");
            emailInput.getStyleClass().add("input-gen");
            addressInput.getStyleClass().add("input-gen");
            passwordInput.getStyleClass().add("input-gen");
            creditInput.getStyleClass().add("input-gen");
            cvvInput.getStyleClass().add("input-gen");
            expInput.getStyleClass().add("input-gen");
            
            goBackButton.getStyleClass().add("button-gen");
            changeButton.getStyleClass().add("button-gen");
            
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
            Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            goBack.create(primaryStage);
        } catch(IOException ioes) {
            System.out.println("File not found in Option goBack");
        }
    }
    
    public void change(ActionEvent event) {
        if(!(firstNameInput.getText().equals("") || lastNameInput.getText().equals("") || genderChoiceBox.getValue() == null || phoneInput.getText().equals("") || emailInput.getText().equals("") || addressInput.getText().equals("") || passwordInput.getText().equals("") || membershipChoiceBox.getValue() == null || paymentMethodChoiceBox.getValue() == null || timeChoiceBox.getValue() == null || creditInput.getText().equals("") ||cvvInput.getText().equals("") || expInput.getText().equals(""))) {
            Member newMember = new Member(
                    tempuuid,
                    firstNameInput.getText(),
                    lastNameInput.getText(),
                    genderChoiceBox.getValue(),
                    phoneInput.getText(),
                    emailInput.getText(),
                    addressInput.getText(),
                    passwordInput.getText(),
                    membershipChoiceBox.getValue(),
                    paymentMethodChoiceBox.getValue(),
                    timeChoiceBox.getValue(),
                    creditInput.getText(),
                    cvvInput.getText(),
                    expInput.getText()
            );
            member.removePaid();
            Gym.remove(member);
            Gym.add(newMember);
            Gym.serializeMemberList();
            goBack(event);
        }
    }
    
}
