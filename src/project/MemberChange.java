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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public class MemberChange extends Window implements Initializable {
    
    @FXML
    private TextField addressLabel;

    @FXML
    private TextField creditCardLabel;

    @FXML
    private VBox creditCardVBox;

    @FXML
    private TextField cvvLabel;

    @FXML
    private TextField emailLabel;

    @FXML
    private TextField expirationLabel;

    @FXML
    private TextField firstNameLabel;

    @FXML
    private ChoiceBox<String> genderChoiceBox;

    @FXML
    private TextField lastNameLabel;

    @FXML
    private ChoiceBox<String> membershipChoiceBox;

    @FXML
    private TextField passwordLabel;

    @FXML
    private ChoiceBox<String> paymentMethodChoiceBox;

    @FXML
    private TextField phoneNumberLabel;

    @FXML
    private ChoiceBox<String> timeChoiceBox;
    
    private final String[] payments = {"Regular", "Premium"};
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
        //String css = this.getClass().getResource("general.css").toExternalForm();
        //scene.getStylesheets().add(css);
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
        
        firstNameLabel.setText(member.getFirstName());
        lastNameLabel.setText(member.getLastName());
        phoneNumberLabel.setText(member.getPhoneNumber());
        emailLabel.setText(member.getEmail());
        addressLabel.setText(member.getAddress());
        passwordLabel.setText(member.getPassword());
        
        genderChoiceBox.setValue(member.getGender());
        membershipChoiceBox.setValue(member.getMemberShip());
        paymentMethodChoiceBox.setValue(member.getPaymentMethod());
        timeChoiceBox.setValue(member.getTime());
        
        if(member.getPaymentMethod().equalsIgnoreCase("credit")) {
            creditCardVBox.setVisible(true);
            creditCardLabel.setText(member.getCreditCardNumber());
            cvvLabel.setText(member.getCvv());
            expirationLabel.setText(member.getExpDate());
        } else {
            creditCardVBox.setVisible(false);
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
        Member newMember = new Member(
                firstNameLabel.getText(),
                lastNameLabel.getText(),
                genderChoiceBox.getValue(),
                phoneNumberLabel.getText(),
                emailLabel.getText(),
                addressLabel.getText(),
                passwordLabel.getText(),
                membershipChoiceBox.getValue(),
                paymentMethodChoiceBox.getValue(),
                timeChoiceBox.getValue(),
                creditCardLabel.getText(),
                cvvLabel.getText(),
                expirationLabel.getText()
        );
        member.removePaid();
        Gym.remove(member);
        Gym.add(newMember);
        Gym.serializeMemberList();
        goBack(event);
    }
    
}
