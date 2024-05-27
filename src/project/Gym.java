/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author cirla
 */
public class Gym {
    private static List<Member> memberList = deserializeMemberList();
    private static Dictionary<String, Staff> staffList = deserializeStaffList();
    private static double cashBalance = deserializeCash();
    private static double creditBalance = deserializeCredit();

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
        serializeCash();
        return cashBalance;
    }
    
    public static double removeCash(double value) {
        cashBalance -= value;
        serializeCash();
        return cashBalance;
    }
    
    public static double addCredit(double value) {
        creditBalance += value;
        serializeCash();
        return creditBalance;
    }
    
    public static double removeCredit(double value) {
        creditBalance -= value;
        serializeCash();
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
        serializeMemberList();
        writeMemberFile();
    }
    
    public static void remove(Member m) {
        memberList.remove(m);
        serializeMemberList();
        writeMemberFile();
    }
    
    public static void add(Staff s) {
        staffList.put(s.getKey(), s);
        serializeStaffList();
        writeStaffFile();
    }
    
    public static void remove(Staff s) {
        staffList.remove(s.getKey());
        serializeStaffList();
        writeStaffFile();
    }
    
    public static void writeMemberFile() {
        File data = new File("memberlist.csv");
        String str = "uuid,firstName,lastName,gender,phoneNumber,email,address,password,type,memberShip,paymentMethod,time,creditCardNumber,cvv,expDate\n";
        try(FileWriter fw = new FileWriter(data)) {
            for(Member m: memberList) str += m.exportCSV();
            fw.write(str);
        } catch(IOException ioe) {
            System.out.println("File not found while writing");
        }
    }
    
    public static void readMemberFile(String path) {
        // Not implemented due to short time constraints
    }
    
    public static void writeStaffFile() {
        File data = new File("stafflist.csv");
        String str = "uuid,firstName,lastName,gender,phoneNumber,email,address,password,type\n";
        try(FileWriter fw = new FileWriter(data)) {
            Enumeration<String> keys = staffList.keys();
            while(keys.hasMoreElements()) {
                str += staffList.get(keys.nextElement()).exportCSV();
            }
            fw.write(str);
        } catch(IOException ioe) {
            System.out.println("File not found while writing");
        }
    }
    
    public static void readStaffFile(String path) {
        // Not implemented due to short time constraints
    }
    
    public static void serializeMemberList() {
        try(FileOutputStream fos = new FileOutputStream("memberList.ser")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(memberList);
        } catch(IOException ioe) {
            System.out.println("File not found in Gym serializeMemberList");
        } catch (Exception e) {
            System.out.println("Exception Occured in Gym serializeMemberList");
        }
    }
    
    public static ArrayList<Member> deserializeMemberList() {
        ArrayList<Member> ml = new ArrayList<>();
        try(FileInputStream fis = new FileInputStream("memberList.ser")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            ml = (ArrayList<Member>) ois.readObject();
        } catch (Exception e) {}
        return ml;
    }
    
    public static void serializeStaffList() {
        try(FileOutputStream fos = new FileOutputStream("staffList.ser")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(staffList);
        } catch(IOException ioe) {
            System.out.println("File not found in Gym serializeStaffList");
        } catch (Exception e) {
            System.out.println("Exception Occured in Gym serializeStaffList");
        }
    }
    
    public static Dictionary<String, Staff> deserializeStaffList() {
        Dictionary<String, Staff> sl = new Hashtable<>();
        try(FileInputStream fis = new FileInputStream("staffList.ser")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            sl = (Dictionary<String, Staff>) ois.readObject();
        } catch (Exception e) {}
        return sl;
    }
    
    public static void serializeCash() {
        try(FileOutputStream fos = new FileOutputStream("cash.ser")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cashBalance);
        } catch(IOException ioe) {
            System.out.println("File not found in Gym serializeCash");
        } catch (Exception e) {
            System.out.println("Exception Occured in Gym serializeCash");
        }
    }
    
    public static double deserializeCash() {
        double c = 0;
        try(FileInputStream fis = new FileInputStream("cash.ser")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            c = (double) ois.readObject();
        } catch (Exception e) {}
        return c;
    }
    
    public static void serializeCredit() {
        try(FileOutputStream fos = new FileOutputStream("credit.ser")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(creditBalance);
        } catch(IOException ioe) {
            System.out.println("File not found in Gym serializeCredit");
        } catch (Exception e) {
            System.out.println("Exception Occured in Gym serializeCredit");
        }
    }
    
    public static double deserializeCredit() {
        double c = 0;
        try(FileInputStream fis = new FileInputStream("credit.ser")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            c = (double) ois.readObject();
        } catch (Exception e) {}
        return c;
    }
    
}
