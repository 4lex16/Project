/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public class StaffView extends Window{
    
    @Override
    public void create(Stage primaryStage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("StaffView.fxml"));
        scene = new Scene(root);
        stage = primaryStage;
        //String css = this.getClass().getResource("general.css").toExternalForm();
        //scene.getStylesheets().add(css);
        stage.setTitle("StaffView");
        stage.setScene(scene);
        stage.show();
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
