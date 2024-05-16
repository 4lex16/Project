/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public class Option extends Window implements Initializable{
    
    @FXML
    private Button inspectButton;
    
    @FXML
    private Button changeButton;
    
    @FXML
    private Button logoutButton;
    
    public static Window goBack;
    
    @Override
    public void create(Stage primaryStage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Option.fxml"));
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
        inspectButton.setVisible(getLoginToken());
        changeButton.setVisible(getLoginToken());
        logoutButton.setVisible(getLoginToken());
    }
    
    private boolean getLoginToken() {
        try(FileInputStream fis = new FileInputStream("logedin.ser")) {
            return true;
        } catch(IOException ioe) {
            return false;
        } catch (Exception e) {
            return false;
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
    
    private void deleteLoginToken() {
        File f = new File("logedin.ser");
        f.delete();
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
        System.out.println("Darkmode");
    }
    
    public void inspect(ActionEvent event) {
        try {
            StaffInspect staffInspect = new StaffInspect();
            StaffInspect.goBack = this;
            staffInspect.create((Stage)(((Node)event.getSource()).getScene().getWindow()));
        } catch(IOException ioe) {
            System.out.println("File not found in Option inspect");
        }
        
    }
    
    public void change(ActionEvent event) {
        try {
            StaffChange staffChange = new StaffChange();
            staffChange.goBack = this;
            staffChange.create((Stage)(((Node)event.getSource()).getScene().getWindow()));
        } catch(IOException ioe) {
            System.out.println("File not found in Option inspect");
        }
    }

    
}
