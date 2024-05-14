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
        staffList.put(s.getEmail()+s.getPassword(), s);
    }
    
    public static void remove(String str) {
        staffList.remove(str);
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
