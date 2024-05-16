/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import static project.StaffInspect.goBack;

/**
 *
 * @author cirla
 */
public class StaffChange extends Window implements Initializable{

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
        root = FXMLLoader.load(getClass().getResource("StaffChange.fxml"));
        scene = new Scene(root);
        stage = primaryStage;
        //String css = this.getClass().getResource("general.css").toExternalForm();
        //scene.getStylesheets().add(css);
        stage.setTitle("StaffChange");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Staff staff = getToken();
        genderChoiceBox.getItems().addAll(genders);
        firstNameField.setText(staff.getFirstName());
        lastNameField.setText(staff.getLastName());
        emailField.setText(staff.getEmail());
        addressField.setText(staff.getAddress());
        passwordField.setText(staff.getPassword());
        phoneNumberField.setText(staff.getPhoneNumber());
        genderChoiceBox.setValue(staff.getGender());
    }
    
    private Staff getToken() {
        String s = "";
        try(FileInputStream fis = new FileInputStream("logedin.ser")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            s = (String) ois.readObject();
        } catch(IOException ioe) {
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println("Exception Occured");
        }
        return Gym.getStaffList().get(s);
    }
    
    public void goBack(ActionEvent event) {
        try {                                                                                                                                           
            Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            goBack.create(primaryStage);
        } catch(IOException ioes) {
            System.out.println("File not found in Option goBack");
        }
    }
    
    public void change(ActionEvent event) {
        Staff staff = getToken();
        String oldKey = staff.getEmail()+staff.getPassword();
        String newKey = emailField.getText()+passwordField.getText();
        Staff newStaff = new Staff(
                firstNameField.getText(),
                lastNameField.getText(),
                genderChoiceBox.getValue(),
                phoneNumberField.getText(),
                emailField.getText(),
                addressField.getText(),
                passwordField.getText()
        );
        if(Gym.getStaffList().get(newKey) == null) {
            Gym.remove(oldKey);
            Gym.add(newStaff);
            createLoginToken();
            goBack(event);
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
