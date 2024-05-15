/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public class StaffList extends Window implements Initializable{
    
    @FXML
    private VBox staffVbox;
    
    public static Window goBack;
    
    @Override
    public void create(Stage primaryStage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("StaffList.fxml"));
        instantiateStaffList(root);
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
            Staff s = Gym.getStaffList().get(keys.nextElement());
            Label label = new Label(s.previewLable());
            HBox hbox = new HBox();
            hbox.getChildren().addAll(label);
            staffVbox.getChildren().add(hbox);
        }
    }
    
    private void instantiateStaffList(Parent root) {
          ScrollPane scrollPane = ((ScrollPane)root.getChildrenUnmodifiable().get(1));
          VBox vbox = new VBox();
          Enumeration<String> keys = Gym.getStaffList().keys();
          while(keys.hasMoreElements()) {
              Staff s = Gym.getStaffList().get(keys.nextElement());
              Label label = new Label(s.previewLable());
              HBox hbox = new HBox();
              hbox.getChildren().addAll(label);
              vbox.getChildren().add(hbox);
          }
          scrollPane.setContent(vbox);
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

    
    
}
