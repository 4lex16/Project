/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author cirla
 */
public interface Tokens {
    
    // Login Token

    default void createLoginToken(String email, String password) {
        try(FileOutputStream fos = new FileOutputStream("logedin.ser")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(String.format("%s%s", email, password));
        } catch(IOException ioe) {
            System.out.println("File not found in Login createLoginToken");
        } catch (Exception e) {
            System.out.println("Exception Occured in Login createLoginToken");
        }
    }
    
    default void deleteLoginToken() {
        File f = new File("logedin.ser");
        f.delete();
    }
    
    // RememberMe Token
    
    default void createRememberMeToken(String email, String password) {
        try(FileOutputStream fos = new FileOutputStream("rememberMe.ser")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            String[] strs = {email, password};
            oos.writeObject(strs);
        } catch(IOException ioe) {
            System.out.println("File not found in Login createRememberMeToken");
        } catch (Exception e) {
            System.out.println("Exception Occured in Login createRememberMeToken");
        }
    }
    
    default void deleteRememberMeToken() {
        File f = new File("rememberMe.ser");
        f.delete();
    }
    
    // DarkMode Token
    
    default void createDarkmodeToken() {
        try(FileOutputStream fos = new FileOutputStream("darkmode.ser")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject("");
        } catch(IOException ioe) {
            System.out.println("File not found in Login createLoginToken");
        } catch (Exception e) {
            System.out.println("Exception Occured in Login createLoginToken");
        }
    }
    
    default void deleteDarkmodeToken() {
        File f = new File("darkmode.ser");
        f.delete();
    }
}
