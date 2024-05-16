/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
        instantiateLists(); // Just instansiates with random filler.
        starttime = System.nanoTime();
        launch(args);
        saveLists(); // not implemented yet
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            if(checkLoginToken()) {
                StaffView staffView = new StaffView();
                staffView.create(primaryStage);
            } else {
                Login login = new Login();
                login.create(primaryStage);
            }
        } catch(IOException ioe) {
            System.out.println("File not found in Main Start function");
        }
        System.out.println("time to open: " + (System.nanoTime() - starttime)/1000000 + "ms");
    }
    
    private boolean checkLoginToken() {
        String s = "";
        try(FileInputStream fis = new FileInputStream("logedin.ser")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            s = (String) ois.readObject();
        } catch(IOException ioe) {
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println("Exception Occured");
        }
        return Gym.getStaffList().get(s) != null;
    }
    
    private static void deleteLoginToken() {
        File f = new File("logedin.ser");
        f.deleteOnExit();
    }
    
    private static void saveLists() {
        
    }
    
    // These are functions that don't pertain to the function of the app.
    private static void instantiateLists() {
        Staff test = new Staff(String.format("uuid"), String.format("firstname"), String.format("lastname"), String.format("M"), String.format("xxx-xxx-xxxx"), String.format("test"), String.format("address"), String.format("test"));
        Gym.add(test);
        for(int i = 0; i<30;i++) {
            Member m = new Member(String.format("uuid%d", i), String.format("firstname%d", i), String.format("lastname%d", i), String.format("M"), String.format("xxx-xxx-xxxx%d", i), String.format("email%d@google.com", i), String.format("address%d", i), String.format("password%d", i), "regular", "cash");
            Gym.add(m);
        }
        for(int i = 0; i<30;i++) {
            Staff s = new Staff(String.format("uuid%d", i), String.format("firstname%d", i), String.format("lastname%d", i), String.format("M"), String.format("xxx-xxx-xxxx%d", i), String.format("email%d@google.com", i), String.format("address%d", i), String.format("password%d", i));
            Gym.add(s);
        }
    }
}
