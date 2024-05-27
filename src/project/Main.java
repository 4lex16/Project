/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;


import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public class Main extends Application{
    static long starttime;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Login login = new Login();
            login.create(primaryStage);
        } catch(IOException ioe) {
            System.out.println("File not found in Main Start function");
        }
    }
}
