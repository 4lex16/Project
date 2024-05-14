/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author cirla
 */
public abstract class User implements Serializable{
    protected String uuid, firstName, lastName, gender, phoneNumber, email, address, password, type;

    public User(String uuid, String firstName, String lastName, String gender, String phoneNumber, String email, String address, String password) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.password = password;
        this.type = "user";
    }
    
    public User(String firstName, String lastName, String gender, String phoneNumber, String email, String address, String password) {
        this.uuid = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.password = password;
        this.type = "user";
    }
    
    

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    public void serialize() {
        try(FileOutputStream fos = new FileOutputStream("person.ser")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
        } catch(IOException ioe) {
            System.out.println("File not found");
        }
    }
    
    public User deserialize() {
        User u = null;
        try(FileInputStream fis = new FileInputStream("")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            u = (User) ois.readObject();
        } catch(IOException ioe) {
            System.out.println("File not found");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        return u;
    }
}
