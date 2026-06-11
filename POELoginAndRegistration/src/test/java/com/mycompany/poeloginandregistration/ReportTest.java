/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poeloginandregistration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author thato
 */
public class ReportTest {
     @BeforeEach
    public void setUp() {
        // Clear all arrays before each test
        QuickChatBox.sentMessages.clear();
        QuickChatBox.sentRecipients.clear();
        QuickChatBox.sentHashes.clear();
        QuickChatBox.sentIDs.clear();

        QuickChatBox.storedMessages.clear();
        QuickChatBox.storedRecipients.clear();
        QuickChatBox.storedHashes.clear();
        QuickChatBox.storedIDs.clear();

        QuickChatBox.disregaredMessages.clear();
        QuickChatBox.disregaredRecipients.clear();
        QuickChatBox.disregaredHashes.clear();
        QuickChatBox.disregaredIDs.clear();

        QuickChatBox.totalMessagesSent = 0;

        // --- Test Data Message 1 (Sent) ---
        QuickChatBox.sentMessages.add("Did you get the cake?");
        QuickChatBox.sentRecipients.add("+27834557896");
        QuickChatBox.sentHashes.add("MS:0:DIDCAKE");
        QuickChatBox.sentIDs.add("1234567890");

        // --- Test Data Message 2 (Stored) ---
        QuickChatBox.storedMessages.add("Where are you? You are late! I have asked you to be on time.");
        QuickChatBox.storedRecipients.add("+27838884567");
        QuickChatBox.storedHashes.add("MS:1:WHERETIME");
        QuickChatBox.storedIDs.add("0987654321");

        // Test Data Message 3 (Disregarded) 
        QuickChatBox.disregaredMessages.add("Yohoooo, I am at your gate.");
        QuickChatBox.disregaredRecipients.add("+27834484567");
        QuickChatBox.disregaredHashes.add("MS:2:YOHOOOGATE");
        QuickChatBox.disregaredIDs.add("1122334455");

        //Test Data Message 4 (Sent)
        QuickChatBox.sentMessages.add("It is dinner time !");
        QuickChatBox.sentRecipients.add("+270838884567");
        QuickChatBox.sentHashes.add("MS:3:ITTIME");
        QuickChatBox.sentIDs.add("0838884567");

        // Test Data Message 5 (Stored)
        QuickChatBox.storedMessages.add("Ok, I am leaving without you.");
        QuickChatBox.storedRecipients.add("+27838884567");
        QuickChatBox.storedHashes.add("MS:4:OKYOU");
        QuickChatBox.storedIDs.add("5566778899");

        QuickChatBox.totalMessagesSent = 4;
    }

    // Testing Sent Messages array correctly populated
    @Test
    public void testSentMessagesArrayCorrectlyPopulated() {
        assertTrue(QuickChatBox.sentMessages.contains("Did you get the cake?"),
                "Sent messages should contain 'Did you get the cake?'");
        assertTrue(QuickChatBox.sentMessages.contains("It is dinner time !"),
                "Sent messages should contain 'It is dinner time !'");
        assertEquals(2, QuickChatBox.sentMessages.size(),
                "There should be 2 sent messages");
    }

    // Test the longest stored message
    @Test
    public void testDisplayLongestStoredMessage() {
        String longest = QuickChatBox.storedMessages.get(0);
        for (int i = 1; i < QuickChatBox.storedMessages.size(); i++) {
            if (QuickChatBox.storedMessages.get(i).length() > longest.length()) {
                longest = QuickChatBox.storedMessages.get(i);
            }
        }
        assertEquals("Where are you? You are late! I have asked you to be on time.", longest,
                "Longest stored message should be 'Where are you? You are late! I have asked you to be on time.'");
    }

    //  Test Search for a message by ID (Message 4)
    @Test
    public void testSearchByMessageID() {
        String searchID = "0838884567";
        String foundMessage = null;
        for (int i = 0; i < QuickChatBox.sentIDs.size(); i++) {
            if (QuickChatBox.sentIDs.get(i).equals(searchID)) {
                foundMessage = QuickChatBox.sentMessages.get(i);
            }
        }
        assertEquals("It is dinner time !", foundMessage,
                "Searching by ID '0838884567' should return 'It is dinner time !'");
    }

    //Test Search all messages for a particular recipient (+27838884567)
    @Test
    public void testSearchByRecipient() {
        String searchRecipient = "+27838884567";
        java.util.ArrayList<String> results = new java.util.ArrayList<>();

        for (int i = 0; i < QuickChatBox.storedRecipients.size(); i++) {
            if (QuickChatBox.storedRecipients.get(i).equals(searchRecipient)) {
                results.add(QuickChatBox.storedMessages.get(i));
            }
        }

        assertTrue(results.contains("Where are you? You are late! I have asked you to be on time."),
                "Should find 'Where are you? You are late! I have asked you to be on time.' for recipient");
        assertTrue(results.contains("Ok, I am leaving without you."),
                "Should find 'Ok, I am leaving without you.' for recipient");
        assertEquals(2, results.size(),
                "Should find 2 messages for recipient +27838884567");
    }

    //Test Delete a message using message hash (Message 2)
    @Test
    public void testDeleteByMessageHash() {
        String hashToDelete = "MS:1:WHERETIME";
        int sizeBefore = QuickChatBox.storedMessages.size();
        boolean deleted = false;

        for (int i = 0; i < QuickChatBox.storedHashes.size(); i++) {
            if (QuickChatBox.storedHashes.get(i).equalsIgnoreCase(hashToDelete)) {
                QuickChatBox.storedMessages.remove(i);
                QuickChatBox.storedRecipients.remove(i);
                QuickChatBox.storedIDs.remove(i);
                QuickChatBox.storedHashes.remove(i);
                deleted = true;
                break;
            }
        }

        assertTrue(deleted, "Message with hash 'MS:1:WHERETIME' should be found and deleted");
        assertEquals(sizeBefore - 1, QuickChatBox.storedMessages.size(),
                "Stored messages size should decrease by 1 after deletion");
        assertFalse(QuickChatBox.storedMessages.contains("Where are you? You are late! I have asked you to be on time."),
                "Deleted message should no longer exist in stored messages");
    }

    // Test Display full report contains all sent messages with hash, recipient, message
    @Test
    public void testDisplayFullReport() {
        String report = Report.generateReport();

        assertTrue(report.contains("Did you get the cake?"),
                "Report should contain 'Did you get the cake?'");
        assertTrue(report.contains("It is dinner time !"),
                "Report should contain 'It is dinner time !'");
        assertTrue(report.contains("MS:0:DIDCAKE"),
                "Report should contain message hash 'MS:0:DIDCAKE'");
        assertTrue(report.contains("+27834557896"),
                "Report should contain recipient '+27834557896'");
        assertTrue(report.contains("SENT MESSAGES"),
                "Report should contain SENT MESSAGES section");
        assertTrue(report.contains("STORED MESSAGES"),
                "Report should contain STORED MESSAGES section");
        assertTrue(report.contains("DISREGARDED MESSAGES"),
                "Report should contain DISREGARDED MESSAGES section");
    }
}


   




