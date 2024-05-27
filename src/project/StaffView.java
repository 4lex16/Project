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
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public class StaffView extends Window implements Initializable, Tokens{
    
    @FXML
    private Button gymBalanceButton;

    @FXML
    private Button memberListButton;

    @FXML
    private Button optionButton;

    @FXML
    private AnchorPane parent;

    @FXML
    private Button staffListButton;

    @FXML
    private Label staffViewLabel;
    
    @Override
    public void create(Stage primaryStage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("StaffView.fxml"));
        scene = new Scene(root);
        stage = primaryStage;
        String css = this.getClass().getResource("general.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("StaffView");
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        css();
    }
    
    private void css() {
        if(isToken("darkmode.ser")) {
            parent.getStyleClass().add("parent-dark");
            gymBalanceButton.getStyleClass().add("button-gen-dark");
            memberListButton.getStyleClass().add("button-gen-dark");
            optionButton.getStyleClass().add("button-gen-dark");
            staffListButton.getStyleClass().add("button-gen-dark");
            staffViewLabel.getStyleClass().add("label-gen-dark");
        } else {
            parent.getStyleClass().add("parent");
            gymBalanceButton.getStyleClass().add("button-gen");
            memberListButton.getStyleClass().add("button-gen");
            optionButton.getStyleClass().add("button-gen");
            staffListButton.getStyleClass().add("button-gen");
            staffViewLabel.getStyleClass().add("label-gen");
        }
    }
    
    public void option(ActionEvent event) {
        try {
            Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Option option = new Option();
            Option.goBack = this;
            option.create(primaryStage);
        } catch(IOException ioe) {
            System.out.println("File not found in StaffView option");
        }
    }
    
    public void membersList(ActionEvent event) {
        try {
            Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            MemberList ml = new MemberList();
            ml.goBack = this;
            ml.create(primaryStage);
        } catch (IOException ex) {
            System.out.println("File not found in StaffView membersList");
        }
    }
    
    public void staffList(ActionEvent event) {
        try {
            Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            StaffList sl = new StaffList();
            StaffList.goBack = this;
            sl.create(primaryStage);
        } catch(IOException ioe) {
            System.out.println("File not found in StaffView staffList");
        }    
    }
    
    public void gymBalance(ActionEvent event) {
        try {
            Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            GymBalance gb = new GymBalance();
            GymBalance.goBack = this;
            gb.create(primaryStage);
        } catch(IOException ioe) {
            System.out.println("File not found in StaffView gymBalance");
        }
    }
}
