/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.IOException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author cirla
 */
public abstract class Window {
    
    protected Parent root;
    protected Scene scene;
    protected Stage stage;
    
    public abstract void create(Stage primaryStage) throws IOException;
}
