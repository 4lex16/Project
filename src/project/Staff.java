/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author cirla
 */
public class Staff extends User{

    public Staff(String uuid, String firstName, String lastName, String gender, String phoneNumber, String email, String address, String password) {
        super(uuid, firstName, lastName, gender, phoneNumber, email, address, password);
        this.type = "staff";
    }

    public Staff(String firstName, String lastName, String gender, String phoneNumber, String email, String address, String password) {
        super(firstName, lastName, gender, phoneNumber, email, address, password);
        this.type = "staff";
    }
    
    @Override
    public String toString() {
        return String.format("%s %s %s", firstName, lastName, gender);
        
    }
    
    public String csv() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", uuid, firstName, lastName, gender, phoneNumber, email, address, password, type);
    }
}
