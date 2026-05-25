/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poeloginandregistration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author thato
 */
public class POELoginAndRegistrationTest {
    
    public POELoginAndRegistrationTest() {
    }

    POELoginAndRegistration login = new POELoginAndRegistration();
    private String firstName;
    private String lastName;
    
    
    // Test Incorrect username
    @Test
    public void testIncorrectcheckUsername() {
        boolean result = login.equals("kyle!!!!");
        assertFalse(result);
        System.out.print("Username is not correctly formatted;please ensure that your username contains an underscore and is no more than five characters in length.");
    }
    
     // Test correct username
    @Test
    public void testCheckUserName() {
        boolean result = login.equals("kyl_1");
        assertTrue(result);
        System.out.print("welcome "+ firstName +" "+ lastName+  " it is great to see you");
    }
    
    // Test Incorrect password
    @Test
    public void testIncorrectCheckPassword() {
        boolean result = login.equals("passord");
        assertFalse(result);
        System.out.print("Password is not correctly formatterd;please ensure that the password contains at least eight characters,a capital letter,a number,and a special character.");
    }

    

    // Test Correct password
    @Test
    public void testCkeckPasswordComplixity() {
        boolean result = login.equals("Ch&&sec@ke99!");
        assertTrue(result);
        System.out.print("Password successfully captured");
    }

    

    // Test Correct phone number
    @Test
    public void testcheckPhoneNumber() {
        boolean result = login.equals("+27838968976");
        assertTrue(result);
        System.out.print("Cell number successfully captured.");
    }

    // Test Incorrect incorrect phone number
    @Test
    public void testIncorrectPhoneNumber() {
        boolean result = login.equals("08966553");
        assertFalse(result);
        System.out.print("Cell number is incorrectly formatted or does not contain an international code;please correct the number and try again.");
    }
    @Test
   
public void testReturnLoginStatus(){

    POELoginAndRegistration login = new POELoginAndRegistration();

    
    boolean loginStatus = true;

    // Expected Response
    String expectedResponse = "Welcome  it is great to see you again.";

   // String result = login.returnLoginStatus(loginStatus);

  //  assertEquals(expectedResponse, result);

}

@Test
public void testReturnLoginStatusFailed(){

    //login2 log = new login2();

    
    boolean loginStatus = false;
    
    // Expected response
    String expectedResponse = "Username or password incorrect, please try again.";

    //String result = log.returnLoginStatus(loginStatus);

   // assertEquals(expectedResponse, result);

}
}