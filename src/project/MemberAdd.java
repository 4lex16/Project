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
public class MemberAdd extends Window implements Initializable {

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
    private final String[] genders = {"Male", "Female", "Tranformer", "Attack Helicopter", "Other"};

    @FXML
    private TextField lastNameLabel;

    @FXML
    private ChoiceBox<String> membershipChoiceBox;
    private final String[] memberships = {"Regular", "Premium"};

    @FXML
    private TextField passwordLabel;

    @FXML
    private ChoiceBox<String> paymentMethodChoiceBox;
    private final String[] payments = {"Cash", "Credit"};

    @FXML
    private TextField phoneNumberLabel;

    @FXML
    private ChoiceBox<String> timeChoiceBox;
    private final String[] times = {"Monthly", "Yearly"};
    
    public static Window goBack;
    
    @Override
    public void create(Stage primaryStage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MemberAdd.fxml"));
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
        timeChoiceBox.getItems().addAll(times);
        paymentMethodChoiceBox.getItems().addAll(payments);
        paymentMethodChoiceBox.setOnAction(this::payCredit);
        membershipChoiceBox.getItems().addAll(memberships);
        genderChoiceBox.getItems().addAll(genders);
        creditCardVBox.setVisible(false);
    }
    
    public void goBack(ActionEvent event) {
        try {
            goBack.create((Stage)((Node)event.getSource()).getScene().getWindow());
        } catch(IOException ioes) {
            System.out.println("File not found in MemberAdd goBack");
        }
    }
    
    public void add(ActionEvent event) {
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
        Gym.add(newMember);
        Gym.serializeMemberList();
        goBack(event);
    }
    
    public void payCredit(ActionEvent event) {
        if(paymentMethodChoiceBox.getValue().equalsIgnoreCase("credit")) {
            creditCardVBox.setVisible(true);
        } else {
            creditCardVBox.setVisible(false);
        }
    }
}
