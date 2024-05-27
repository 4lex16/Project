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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public class Option extends Window{
    
    @FXML
    private AnchorPane parent;
    
    @FXML
    private Button changeButton;

    @FXML
    private Button darkModeButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button goBackButton;

    @FXML
    private Button inspectButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Label optionLabel;
    
    public static Window goBack;
    
    @Override
    public void create(Stage primaryStage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Option.fxml"));
        scene = new Scene(root);
        stage = primaryStage;
        String css = this.getClass().getResource("general.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Option");
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        css();
        if (isToken("darkmode.ser")) {
            darkModeButton.setText("Light Mode");
        }
        inspectButton.setVisible(isToken("logedin.ser"));
        changeButton.setVisible(isToken("logedin.ser"));
        logoutButton.setVisible(isToken("logedin.ser"));
    }
    
    private void css() {
        if (isToken("darkmode.ser")) {
            parent.getStyleClass().add("parent-dark");
            optionLabel.getStyleClass().add("label-gen-dark");
            goBackButton.getStyleClass().add("button-gen-dark");
            exitButton.getStyleClass().add("button-gen-dark");
            inspectButton.getStyleClass().add("button-gen-dark");
            changeButton.getStyleClass().add("button-gen-dark");
            logoutButton.getStyleClass().add("button-gen-dark");
            darkModeButton.getStyleClass().add("button-gen-dark");
        } else {
            parent.getStyleClass().add("parent");
            optionLabel.getStyleClass().add("label-gen");
            goBackButton.getStyleClass().add("button-gen");
            exitButton.getStyleClass().add("button-gen");
            inspectButton.getStyleClass().add("button-gen");
            changeButton.getStyleClass().add("button-gen");
            logoutButton.getStyleClass().add("button-gen");
            darkModeButton.getStyleClass().add("button-gen");
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
    
    public void logout(ActionEvent event) {
        try {
            Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Login login = new Login();
            login.create(primaryStage);
            deleteLoginToken();
        } catch(IOException ioe) {
            System.out.println("File not found in Option logout");
        }
    }
    
    public void close(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to log out");
        alert.setContentText("Do you want to save before exiting: ");
        
        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.close();
        }
    }
    
    public void darkmode(ActionEvent event) {
        if (isToken("darkmode.ser")) {
            deleteDarkmodeToken();
            darkModeButton.setText("Dark Mode");
        } else {
            createDarkmodeToken();
            darkModeButton.setText("Light Mode");
        }
        try {
            Option option = new Option();
            option.create((Stage) ((Node)event.getSource()).getScene().getWindow());
        } catch (IOException ex) {
            Logger.getLogger(Option.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inspect(ActionEvent event) {
        try {
            StaffInspect staffInspect = new StaffInspect();
            StaffInspect.goBack = this;
            StaffInspect.staff = getToken();
            staffInspect.create((Stage)(((Node)event.getSource()).getScene().getWindow()));
        } catch(IOException ioe) {
            System.out.println("File not found in Option inspect");
        }
    }
    
    public void change(ActionEvent event) {
        try {
            StaffChange staffChange = new StaffChange();
            StaffChange.goBack = this;
            StaffChange.staff = getToken();
            StaffChange.isStaffLogin = true;
            staffChange.create((Stage)(((Node)event.getSource()).getScene().getWindow()));
        } catch(IOException ioe) {
            System.out.println("File not found in Option inspect");
        }
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
    
}
