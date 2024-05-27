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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public class GymBalance extends Window {

    @FXML
    private Label cashLabel;

    @FXML
    private Label creditLabel;

    @FXML
    private Button goBackButton;

    @FXML
    private Label gymLabel;

    @FXML
    private Button optionButton;

    @FXML
    private Label totalLabel;
    
    @FXML
    private AnchorPane parent;
    
    public static Window goBack;
    
    @Override
    public void create(Stage primaryStage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("GymBalance.fxml"));
        scene = new Scene(root);
        stage = primaryStage;
        String css = this.getClass().getResource("general.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("GymBalance");
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cashLabel.setText(String.format("Cash Balance :   %10.2f", Gym.getCashBalance()));
        creditLabel.setText(String.format("Credit Balance : %10.2f", Gym.getCreditBalance()));
        totalLabel.setText(String.format("Total Balance :   %10.2f", Gym.getTotalBalance()));
        css();
    }
    
    private void css() {
        if(isToken("darkmode.ser")) {
            parent.getStyleClass().add("parent-dark");
            optionButton.getStyleClass().add("button-gen-dark");
            goBackButton.getStyleClass().add("button-gen-dark");
            gymLabel.getStyleClass().add("label-gen-dark");
            cashLabel.getStyleClass().add("label-gen-dark");
            creditLabel.getStyleClass().add("label-gen-dark");
            totalLabel.getStyleClass().add("label-gen-dark");
        } else {
            parent.getStyleClass().add("parent");
            optionButton.getStyleClass().add("button-gen");
            goBackButton.getStyleClass().add("button-gen");
            gymLabel.getStyleClass().add("label-gen");
            cashLabel.getStyleClass().add("label-gen");
            creditLabel.getStyleClass().add("label-gen");
            totalLabel.getStyleClass().add("label-gen");
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
    
    public void option(ActionEvent event) {
        try {
            Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Option option = new Option();
            Option.goBack = this;
            option.create(primaryStage);
        } catch(IOException ioe) {
            System.out.println("File not found in Login Option");
        }
    }

    
}
