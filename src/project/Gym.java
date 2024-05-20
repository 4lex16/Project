/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author cirla
 */
public class Gym {
    private static List<Member> memberList = new ArrayList<>();
    private static Dictionary<String, Staff> staffList = new Hashtable<>();
    private static double cashBalance;
    private static double creditBalance;

    public static double getCashBalance() {
        return cashBalance;
    }

    public static double getCreditBalance() {
        return creditBalance;
    }
    
    public static double getTotalBalance() {
        return cashBalance + creditBalance;
    }
    
    public static double addCash(double value) {
        cashBalance += value;
        return cashBalance;
    }
    
    public static double removeCash(double value) {
        cashBalance += value;
        return cashBalance;
    }
    
    public static double addCredit(double value) {
        creditBalance += value;
        return creditBalance;
    }
    
    public static double removeCredit(double value) {
        creditBalance += value;
        return creditBalance;
    }    
    
    public static List<Member> getMemberList() {
        return memberList;
    }
    
    public static Dictionary<String, Staff> getStaffList() {
        return staffList;
    }
    
    public static void add(Member m) {
        memberList.add(m);
    }
    
    public static void remove(Member m) {
        memberList.remove(m);
    }
    
    public static void add(Staff s) {
        staffList.put(s.getKey(), s);
    }
    
    public static void remove(Staff s) {
        staffList.remove(s.getKey());
    }
    
    public static void writeMemberFile(String path) {
        File data = new File(path);
        String str = "uuid,firstName,lastName,gender,phoneNumber,email,address,password,type,memberShip,paymentMethod\n";
        try(FileWriter fw = new FileWriter(data)) {
            for(Member m: memberList) str += m.toString();
            fw.write(str);
        } catch(IOException ioe) {
            System.out.println("File not found while writing");
        }
    }
}
