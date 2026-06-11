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
//  Success: Message under 250 characters
    @Test
    public void testCheckMessageLengthSuccess() {
        MessageSender msg = new MessageSender("+27718693002", "Hi Mike, can you join us for dinner tonight?", 0);
        String result = msg.checkMessageLength();
        assertEquals("Message sent", result,
                "Short message should return 'Message sent'");
    }

    //  Fail: Message exceeds 250 characters
    @Test
    public void testCheckMessageLengthFailure() {
        String longMessage = "a".repeat(260);
        MessageSender msg = new MessageSender("+27718693002", longMessage, 0);
        String result = msg.checkMessageLength();
        assertTrue(result.contains("Message exceeds 250 characters by 10"),
                "Message over 250 chars should report how many characters over");
    }

    // ========== RECIPIENT NUMBER TESTS ==========

    // ✅ Success: Valid international number (Test Data Message 1)
    @Test
    public void testCheckRecipientCellSuccess() {
        MessageSender msg = new MessageSender("+27718693002", "Hi Mike, can you join us for dinner tonight?", 0);
        String result = msg.checkRecipientCell();
        assertEquals("Cell phone number successfully captured.", result,
                "Valid international number should be captured successfully");
    }

    // ✅ Failure: No international code (Test Data Message 2)
    @Test
    public void testCheckRecipientCellFailure() {
        MessageSender msg = new MessageSender("08575975889", "Hi Keegan, did you receive the payment?", 0);
        String result = msg.checkRecipientCell();
        assertEquals("Cell phone number is incorrectly formated or does not conatin an international code.Please re-enter your phone number: ",
                result, "Number without international code should fail");
    }

    // ========== MESSAGE HASH TESTS ==========

    // ✅ Hash correct for Test Data Message 1
    @Test
    public void testCreateMessageHashMessage1() {
        // ID starts with "00" is random, so we just check format and content
        MessageSender msg = new MessageSender("+27718693002", "Hi Mike, can you join us for dinner tonight?", 0);
        String hash = msg.createMessageHash();
        assertNotNull(hash, "Hash should not be null");
        assertTrue(hash.contains("HI") && hash.contains("TONIGHT"),
                "Hash should contain first word 'HI' and last word 'TONIGHT'");
    }

    // ✅ Hash correct for remaining messages (loop test)
    @Test
    public void testCreateMessageHashLoop() {
        String[] messages = {
            "Hi Mike, can you join us for dinner tonight?",
            "Hi Keegan, did you receive the payment?",
            "Where are you? You are late!",
            "It is dinner time!"
        };
        String[] recipients = {
            "+27718693002",
            "+27834557896",
            "+27838884567",
            "+27834484567"
        };

        for (int i = 0; i < messages.length; i++) {
            MessageSender msg = new MessageSender(recipients[i], messages[i], i);
            String hash = msg.createMessageHash();
            assertNotNull(hash, "Hash should not be null for message " + (i + 1));
            assertTrue(hash.contains(":"), "Hash should contain ':' separator for message " + (i + 1));
        }
    }

    // ========== MESSAGE ID TESTS ==========

    // ✅ MessageID is generated and is 10 digits
    @Test
    public void testMessageIDGenerated() {
        MessageSender msg = new MessageSender("+27718693002", "Hi Mike, can you join us for dinner tonight?", 0);
        String id = msg.getMessageID();
        assertNotNull(id, "MessageID should be generated");
        assertEquals(10, id.length(), "MessageID should be exactly 10 characters");
    }

    // ✅ checkMessageID returns false when ID is 10 chars (not less than 10)
    @Test
    public void testCheckMessageID() {
        MessageSender msg = new MessageSender("+27718693002", "Hi Mike, can you join us for dinner tonight?", 0);
        assertEquals(false, msg.checkMessageID(),
                "checkMessageID should return false when ID is 10 characters");
    }

    // ========== SEND MESSAGE TESTS ==========

    // ✅ Test Data Message 1: User selects Send → "Message successfully sent"
    @Test
    public void testSendMessageSent() {
        MessageSender msg = new MessageSender("+27718693002", "Hi Mike, can you join us for dinner tonight?", 0);
        String result = msg.sendMessage("1");
        assertEquals("Message successfully sent", result,
                "Selecting Send should return 'Message successfully sent'");
    }

    // ✅ Test Data Message 2: User selects Disregard → "Press 0 to delete the message."
    @Test
    public void testSendMessageDisregard() {
        MessageSender msg = new MessageSender("08575975889", "Hi Keegan, did you receive the payment?", 1);
        String result = msg.sendMessage("2");
        assertEquals("Press 0 to delete the message.", result,
                "Selecting Disregard should return 'Press 0 to delete the message.'");
    }

    // ✅ User selects Store → "Message successfully stored"
    @Test
    public void testSendMessageStored() {
        MessageSender msg = new MessageSender("+27718693002", "Hi Mike, can you join us for dinner tonight?", 0);
        msg.createMessageHash(); // hash must be set before storing
        String result = msg.sendMessage("3");
        assertEquals("Message successfully stored", result,
                "Selecting Store should return 'Message successfully stored'");
    }

    // ========== RETURN TOTAL MESSAGES TEST ==========

    // ✅ Total messages increments after sending
    @Test
    public void testReturnTotalMessages() {
        MessageSender msg = new MessageSender("+27718693002", "Hi Mike, can you join us for dinner tonight?", 0);
        assertEquals(0, msg.returnTotalMessages(),
                "Total messages should start at 0");
        msg.sendMessage("1"); // send increments count
        assertEquals(1, msg.returnTotalMessages(),
                "Total messages should be 1 after sending");
    }
}
