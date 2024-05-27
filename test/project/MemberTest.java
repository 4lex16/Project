/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package project;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cirla
 */
public class MemberTest {
    
    public MemberTest() {
    }

    @Test
    public void testExportCSV() {
        System.out.println("exportCSV");
        Member instance = new Member("test","test","test","test","test","test","test","test","test","test","test","test","test","test");
        String expResult = "test,test,test,test,test,test,test,test,member,test,test,test,,,\n";
        String result = instance.exportCSV();
        assertEquals(expResult, result);
    }
    
}
