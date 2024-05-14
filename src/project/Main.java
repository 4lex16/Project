/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;

import java.io.File;
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
        instantiateLists(); // Just instansiates with random filler.
        System.out.println(Gym.getStaffList().keys().nextElement());
        starttime = System.nanoTime();
        
        launch(args);
        
        deleteLoginToken();
        saveLists(); // not implemented yet
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Login login = new Login();
            login.create(stage);
        } catch(IOException ioe) {
            System.out.println("File not found in Main Start function");
        }
        System.out.println("time to open: " + (System.nanoTime() - starttime)/1000000 + "ms");
    }
    
    private static void deleteLoginToken() {
        File f = new File("logedin.ser");
        f.deleteOnExit();
    }
    
    private static void saveLists() {
        
    }
    
    
    
    
    // These are functions that don't pertain to the function of the app.
    private static void instantiateLists() {
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
