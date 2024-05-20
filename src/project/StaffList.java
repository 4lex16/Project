/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;
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
        if((Staff)staffList.getSelectionModel().getSelectedItem()!=null) {
            try {
                StaffInspect staffInspect = new StaffInspect();
                StaffInspect.staff = (Staff) staffList.getSelectionModel().getSelectedItem();
                StaffInspect.goBack = this;
                staffInspect.create((Stage) ((Node)event.getSource()).getScene().getWindow());
            } catch(IOException ioe) {
                System.out.println("");
            }
        }
    }
    
    public void change(ActionEvent event) {
        if((Staff)staffList.getSelectionModel().getSelectedItem()!=null) {
            try {
                StaffChange staffChange = new StaffChange();
                StaffChange.staff = (Staff) staffList.getSelectionModel().getSelectedItem();
                StaffChange.goBack = this;
                StaffChange.isStaffLogin = false;
                StaffChange.tempuuid = StaffChange.staff.getUUID();
                staffChange.create((Stage)((Node)event.getSource()).getScene().getWindow());
            } catch(IOException ioe) {
                System.out.println("");
            }
        }
    }
    
    public void delete(ActionEvent event) {
        if((Staff)staffList.getSelectionModel().getSelectedItem()!=null) {
            Gym.remove((Staff)staffList.getSelectionModel().getSelectedItem());
            staffList.getItems().clear();
            Enumeration<String> keys = Gym.getStaffList().keys();
            while(keys.hasMoreElements()) {
                staffList.getItems().add(Gym.getStaffList().get(keys.nextElement()));
            }
        }
    }
    
    public void add(ActionEvent event) {
        try {
            StaffAdd staffAdd = new StaffAdd();
            StaffAdd.goBack = this;
            staffAdd.create((Stage)((Node)event.getSource()).getScene().getWindow());
        } catch(IOException ioe) {
            System.out.println("");
        }
    }
}
