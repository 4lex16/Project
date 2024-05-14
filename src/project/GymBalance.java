/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public class GymBalance extends Window{

    public static Window goBack;
    
    @Override
    public void create(Stage primaryStage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("GymBalance.fxml"));
        setGymBalance(root);
        scene = new Scene(root);
        stage = primaryStage;
        //String css = this.getClass().getResource("general.css").toExternalForm();
        //scene.getStylesheets().add(css);
        stage.setTitle("GymBalance");
        stage.setScene(scene);
        stage.show();
    }
    
    private void setGymBalance(Parent root) {
        VBox vbox = (VBox) root.getChildrenUnmodifiable().get(1);
        String[] strs = {String.format("Gym cash balance : %-4.2f", Gym.getCashBalance()), String.format("Gym credit balance : %-4.2f", Gym.getCreditBalance()), String.format("Gym total balance : %-4.2f", Gym.getTotalBalance())};
        for(int i = 0; i<vbox.getChildren().size(); i++) {
            ((Label)vbox.getChildren().get(i)).setText(strs[i]);
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
