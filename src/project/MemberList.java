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
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public class MemberList extends Window{
    
    @FXML
    private Button addButton;

    @FXML
    private Button changeButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button goBackButton;

    @FXML
    private Button inspectButton;

    @FXML
    private ListView<Member> memberList;

    @FXML
    private Label memberlistLabel;

    @FXML
    private Button optionButton;

    @FXML
    private AnchorPane parent;
    
    public static Window goBack;
    
    @Override
    public void create(Stage primaryStage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MemberList.fxml"));
        scene = new Scene(root);
        stage = primaryStage;
        String css = this.getClass().getResource("general.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("MemberList");
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        memberList.getItems().addAll(Gym.getMemberList());
        css();
    }
    
    private void css() {
        if(isToken("darkmode.ser")) {
            parent.getStyleClass().add("parent-dark");
            addButton.getStyleClass().add("button-gen-dark");
            changeButton.getStyleClass().add("button-gen-dark");
            deleteButton.getStyleClass().add("button-gen-dark");
            inspectButton.getStyleClass().add("button-gen-dark");
            goBackButton.getStyleClass().add("button-gen-dark");
            optionButton.getStyleClass().add("button-gen-dark");
            memberlistLabel.getStyleClass().add("label-gen-dark");
        } else {
            parent.getStyleClass().add("parent");
            addButton.getStyleClass().add("button-gen");
            changeButton.getStyleClass().add("button-gen");
            deleteButton.getStyleClass().add("button-gen");
            inspectButton.getStyleClass().add("button-gen");
            goBackButton.getStyleClass().add("button-gen");
            optionButton.getStyleClass().add("button-gen");
            memberlistLabel.getStyleClass().add("label-gen");
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
                ioe.printStackTrace();
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
