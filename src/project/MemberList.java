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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public class MemberList extends Window implements Initializable{
    
    @FXML
    private ListView memberList;
    
    public static Window goBack;
    
    @Override
    public void create(Stage primaryStage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MemberList.fxml"));
        scene = new Scene(root);
        stage = primaryStage;
        //String css = this.getClass().getResource("general.css").toExternalForm();
        //scene.getStylesheets().add(css);
        stage.setTitle("MemberList");
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        memberList.getItems().addAll(Gym.getMemberList());
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
        if((Member)memberList.getSelectionModel().getSelectedItem()!=null) {
            try {
                MemberInspect mi = new MemberInspect();
                MemberInspect.goBack = this;
                MemberInspect.member = (Member) memberList.getSelectionModel().getSelectedItem();
                mi.create((Stage)((Node)event.getSource()).getScene().getWindow());
            } catch(IOException ioe) {
                System.out.println("sdfsd");
            }
        }
    }
    
    public void change(ActionEvent event) {
        if((Member)memberList.getSelectionModel().getSelectedItem()!=null) {
            try {
                MemberChange mc = new MemberChange();
                MemberChange.goBack = this;
                MemberChange.tempuuid = ((Member)memberList.getSelectionModel().getSelectedItem()).getUUID();
                MemberChange.member = (Member)memberList.getSelectionModel().getSelectedItem();
                mc.create((Stage)((Node)event.getSource()).getScene().getWindow());
            } catch(IOException ioe) {
                System.out.println("sdfsd");
            }
        }
    }
    
    public void delete(ActionEvent event) {
        Member member = (Member)memberList.getSelectionModel().getSelectedItem();
        if(member!=null) {
            member.removePaid();
            Gym.remove(member);
            memberList.getItems().clear();
            memberList.getItems().addAll(Gym.getMemberList());
        }
    }
    
    public void add(ActionEvent event) {
        try {
            MemberAdd ma = new MemberAdd();
            MemberAdd.goBack = this;
            ma.create((Stage)((Node)event.getSource()).getScene().getWindow());
        } catch(IOException ioe) {
            System.out.println("sdfsd");
        }
    }
    
    
}
