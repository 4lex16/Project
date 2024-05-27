/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author cirla
 */
public class Member extends User{
    private String memberShip, paymentMethod, time, creditCardNumber, cvv, expDate;
    private double paid;
    
    public Member(String uuid, String firstName, String lastName, String gender, String phoneNumber, String email, String address, String password, String memberShip, String paymentMethod, String time, String creditCardNumber, String cvv, String expDate) {
        super(uuid, firstName, lastName, gender, phoneNumber, email, address, password);
        this.type = "member";
        this.memberShip = memberShip;
        this.paymentMethod = paymentMethod;
        this.time = time;
        if(paymentMethod.equalsIgnoreCase("credit")) {
            this.creditCardNumber = creditCardNumber;
            this.cvv = cvv;
            this.expDate = expDate;
        } else {
            this.creditCardNumber = "";
            this.cvv = "";
            this.expDate = "";
        }
        
        if(this.memberShip.equalsIgnoreCase("regular")) {
            paid = this.time.equalsIgnoreCase("monthly")?  180/12: 180;
        } else {
            paid = this.time.equalsIgnoreCase("monthly")?  265/12: 265;
        }
        if(paymentMethod.equalsIgnoreCase("credit")) {
            Gym.addCredit(paid);
        } else {
            Gym.addCash(paid);
        }
    }

    public Member(String firstName, String lastName, String gender, String phoneNumber, String email, String address, String password, String memberShip, String paymentMethod, String time, String creditCardNumber, String cvv, String expDate) {
        super(firstName, lastName, gender, phoneNumber, email, address, password);
        this.type = "member";
        this.memberShip = memberShip;
        this.paymentMethod = paymentMethod;
        this.time = time;
        if(this.paymentMethod.equalsIgnoreCase("credit")) {
            this.creditCardNumber = creditCardNumber;
            this.cvv = cvv;
            this.expDate = expDate;
        } else {
            this.creditCardNumber = "";
            this.cvv = "";
            this.expDate = "";
        }
        addPaid();
    }

    public void addPaid() {
        if(this.memberShip.equalsIgnoreCase("regular")) {
            paid = this.time.equalsIgnoreCase("monthly")?  180/12: 180;
        } else {
            paid = this.time.equalsIgnoreCase("monthly")?  265/12: 265;
        }
        if(this.paymentMethod.equalsIgnoreCase("credit")) {
            Gym.addCredit(paid);
        } else {
            Gym.addCash(paid);
        }
        Gym.serializeCash();
        Gym.serializeCredit();
    }
     
    public void removePaid() {
        if(this.paymentMethod.equalsIgnoreCase("credit")) {
            Gym.removeCredit(paid);
        } else {
            Gym.removeCash(paid);
        }
        Gym.serializeCash();
        Gym.serializeCredit();
    }
    
    public String getMemberShip() {
        return memberShip;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getTime() {
        return time;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public String getExpDate() {
        return expDate;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", firstName, lastName, gender, memberShip);
    }
    
    public String exportCSV() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n", uuid, firstName, lastName, gender, phoneNumber, email, address, password, type, memberShip, paymentMethod, time, creditCardNumber, cvv, expDate);
    }
}
