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
public class MessageSenderTest {
    
    public MessageSenderTest() {
    }

      /**
     * Test of checkMessageID method, of class MessageSender.
     */
    @Test
    public void testCheckMessageID() {
        
        MessageSender testMethod = new MessageSender("+27718693002","Hi Mike,can you join us for dinner?",0);
        boolean expected = false;
        boolean actual = testMethod.checkMessageID();
        assertEquals(expected,actual);
        
    }

     @Test
    public void testCheckMessageIDTrue() {
        
        MessageSender testMethod = new MessageSender("+27718693002","Hi Mike,can you join us for dinner?",0);
        boolean expected = false;
        boolean actual = testMethod.checkMessageID();
        assertEquals(expected,actual);
        
    }
    @Test
    public void testCheckMessageIDFalse(){
        MessageSender testMethod = new MessageSender("0718693002","Hi Keegan, did you recieve the payment?",0);
    }
    /**
     * Test of checkRecipientCell method, of class MessageSender.
     */
    @Test
    public void testCheckRecipientCell() {
        
        MessageSender testMethod = new MessageSender("+27718693002","Hi Mike,can you join us for dinner?",0);
        String expResult = "+27718693002";
        String result = testMethod.checkRecipientCell();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of checkMessageLength method, of class MessageSender.
     */
    @Test
    public void testCheckMessageLength() {
        System.out.println("checkMessageLength");
        MessageSender instance = null;
        String expResult = "";
        String result = instance.checkMessageLength();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMessageHash method, of class MessageSender.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        MessageSender instance = null;
        String expResult = "";
        String result = instance.createMessageHash();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendMessage method, of class MessageSender.
     */
    @Test
    public void testSendMessage() {
        System.out.println("sendMessage");
        MessageSender instance = null;
        String expResult = "";
        String result = instance.sendMessage();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of printMessage method, of class MessageSender.
     */
    @Test
    public void testPrintMessage() {
        System.out.println("printMessage");
        MessageSender instance = null;
        String expResult = "";
        String result = instance.printMessage();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnTotalMessages method, of class MessageSender.
     */
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        MessageSender instance = null;
        int expResult = 0;
        int result = instance.returnTotalMessages();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessage method, of class MessageSender.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        MessageSender instance = null;
        String expResult = "";
        String result = instance.getMessage();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageHash method, of class MessageSender.
     */
    @Test
    public void testGetMessageHash() {
        System.out.println("getMessageHash");
        MessageSender instance = null;
        String expResult = "";
        String result = instance.getMessageHash();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecipient method, of class MessageSender.
     */
    @Test
    public void testGetRecipient() {
        System.out.println("getRecipient");
        MessageSender instance = null;
        String expResult = "";
        String result = instance.getRecipient();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumMesaagesSent method, of class MessageSender.
     */
    @Test
    public void testGetNumMesaagesSent() {
        System.out.println("getNumMesaagesSent");
        MessageSender instance = null;
        int expResult = 0;
        int result = instance.getNumMesaagesSent();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageID method, of class MessageSender.
     */
    @Test
    public void testGetMessageID() {
        System.out.println("getMessageID");
        MessageSender instance = null;
        String expResult = "";
        String result = instance.getMessageID();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of Menu method, of class MessageSender.
     */
    @Test
    public void testMenu() {
        System.out.println("Menu");
        MessageSender.Menu();
        fail("The test case is a prototype.");
    }
    
}
