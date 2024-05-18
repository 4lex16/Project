/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public class StaffList extends Window implements Initializable{
    
    @FXML
    private ListView staffList;
    
    public static Window goBack;
    
    @Override
    public void create(Stage primaryStage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("StaffList.fxml"));
        scene = new Scene(root);
        stage = primaryStage;
        //String css = this.getClass().getResource("general.css").toExternalForm();
        //scene.getStylesheets().add(css);
        stage.setTitle("StaffList");
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Enumeration<String> keys = Gym.getStaffList().keys();
        while(keys.hasMoreElements()) {
            staffList.getItems().add(Gym.getStaffList().get(keys.nextElement()));
        }
        
//        staffList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Staff>() {
//            @Override
//            public void changed(ObservableValue<? extends Staff> observable, Staff oldValue, Staff newValue) {
//                System.out.println(staffList.getSelectionModel().getSelectedItem());
//            }
//        });
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
    
    public void goBack(ActionEvent event) {
        try {
            Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            goBack.create(primaryStage);
        } catch(IOException ioes) {
            System.out.println("File not found in Option goBack");
        }
    }

    public void inspect(ActionEvent event) {
        try {
            StaffInspect staffInspect = new StaffInspect();
            staffInspect.staff = (Staff) staffList.getSelectionModel().getSelectedItem();
            staffInspect.goBack = this;
            staffInspect.create((Stage) ((Node)event.getSource()).getScene().getWindow());
        } catch(IOException ioe) {
            System.out.println("");
        }
    }
    
    public void change(ActionEvent event) {
        System.out.println("Change");
        try {
            StaffChange staffChange = new StaffChange();
            staffChange.staff = (Staff) staffList.getSelectionModel().getSelectedItem();
            staffChange.goBack = this;
            staffChange.create((Stage) ((Node)event.getSource()).getScene().getWindow());
        } catch(IOException ioe) {
            System.out.println("");
        }
    }
    
    public void delete(ActionEvent event) {
        try {
            Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            StaffList sl = new StaffList();
            StaffList.goBack = this;
            sl.create(primaryStage);
        } catch(IOException ioe) {
            System.out.println("File not found in StaffView staffList");
        }    
    }
    
    public void add(ActionEvent event) {
        System.out.println("Add");
    }
}
