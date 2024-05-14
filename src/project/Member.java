/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.UUID;

/**
 *
 * @author cirla
 */
public class Member extends User{
    private String memberShip, paymentMethod;
    
    public Member(String uuid, String firstName, String lastName, String gender, String phoneNumber, String email, String address, String password, String memberShip, String paymentMethod) {
        super(uuid, firstName, lastName, gender, phoneNumber, email, address, password);
        this.type = "member";
        this.memberShip = memberShip;
        this.paymentMethod = paymentMethod;
    }
    

    public Member(String firstName, String lastName, String gender, String phoneNumber, String email, String address, String password, String memberShip, String paymentMethod) {
        super(firstName, lastName, gender, phoneNumber, email, address, password);
        this.type = "member";
        this.memberShip = memberShip;
        this.paymentMethod = paymentMethod;
    }
    
    

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", uuid, firstName, lastName, gender, phoneNumber, email, address, password, type, memberShip, paymentMethod);
    }
    
    public String previewLable() {
        return String.format("%s %s %s", firstName, lastName, gender);
    }
}
