/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poeloginandregistration;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author thato
 */
public class Report {
    static Scanner scanner = QuickChatBox.scanner;
    
    //Stored Messages menu
    public static void storedMessagesMenu(){
        
        
        boolean back = false;
        while(!back){
            System.out.println("Stored Messages");
            System.out.println("a) Display the sender and recipient of all stored messages");
            System.out.println("b) Display the longest stored message");
            System.out.println("c) Search for a message by ID");
            System.out.println("d) Search messages for a particular recipient");
            System.out.println("e) Delete a message using the message hash");
            System.out.println("f) Display full report of all stored messages");
            System.out.println("x) Back to Main Menu");
            System.out.println("Choose: ");
            String option = scanner.nextLine().trim().toLowerCase();
            
            switch(option){
                case "a": displayAllStoredSenderRecipient();
                break;
                 case "b": displayLongestStoredMessage();    
                 break;
                  case "c": searchByMessageID();              
                  break;
                   case "d": searchByRecipient();             
                   break;
                   case "e": deleteByMessageHash();           
                   break;
                    case "f": displayFullReport();             
                    break;
                     case "x": back = true;                     
                     break;
                     default:  
                         System.out.println("Invalid option.");
            }
        }
    }
    //Display the sender and the recipient of all stored messages
    static void displayAllStoredSenderRecipient(){
        if(QuickChatBox.storedMessages.isEmpty()){
            System.out.println("No  stored messages");
            return;
        }
        System.out.println("All stored messages");
        for (int i = 0; i < QuickChatBox.storedMessages.size(); i++){
            System.out.println("ID: " + QuickChatBox.storedIDs.get(i) + "Recipient: " + QuickChatBox.storedRecipients.get(i) + "Message: " + QuickChatBox.storedMessages.get(i));
        }
    }
    // b) Display the longest stored message
    static void displayLongestStoredMessage() {
        if (QuickChatBox.storedMessages.isEmpty()) {
            System.out.println("No stored messages.");
            return;
        }
String longest = QuickChatBox.storedMessages.get(0);
        String longestRecipient = QuickChatBox.storedRecipients.get(0);
        for (int i = 1; i < QuickChatBox.storedMessages.size(); i++) {
            if (QuickChatBox.storedMessages.get(i).length() > longest.length()) {
                longest = QuickChatBox.storedMessages.get(i);
                longestRecipient = QuickChatBox.storedRecipients.get(i);
            }
        }
        System.out.println("Longest stored message:");
        System.out.println("To: " + longestRecipient + " | \"" + longest + "\"");
    }

    // c) Search by message ID
    static void searchByMessageID() {
        System.out.print("Enter Message ID to search: ");
        String id = scanner.nextLine().trim();
        boolean found = false;
        for (int i = 0; i < QuickChatBox.storedIDs.size(); i++) {
            if (QuickChatBox.storedIDs.get(i).equals(id)) {
                System.out.println("Recipient: " + QuickChatBox.storedRecipients.get(i)
                        + " | Message: " + QuickChatBox.storedMessages.get(i));
                found = true;
            }
        }
        if (!found) System.out.println("No message found with ID: " + id);
    }

    // d) Search all messages for a particular recipient
    static void searchByRecipient() {
        System.out.print("Enter recipient cell number: ");
        String rec = scanner.nextLine().trim();
        boolean found = false;
        System.out.println("\nMessages to " + rec + ":");
        for (int i = 0; i < QuickChatBox.storedRecipients.size(); i++) {
            if (QuickChatBox.storedRecipients.get(i).equals(rec)) {
                System.out.println("ID: " + QuickChatBox.storedIDs.get(i)
                        + " | Hash: " + QuickChatBox.storedHashes.get(i)
                        + " | Message: " + QuickChatBox.storedMessages.get(i));
                found = true;
            }
        }
        if (!found) System.out.println("No messages found for: " + rec);
    }

    // e) Delete a message using message hash
    static void deleteByMessageHash() {
        System.out.print("Enter message hash to delete: ");
        String hash = scanner.nextLine().trim().toUpperCase();
        boolean found = false;
        for (int i = 0; i < QuickChatBox.storedHashes.size(); i++) {
            if (QuickChatBox.storedHashes.get(i).toUpperCase().equals(hash)) {
                System.out.println("Deleted: \"" + QuickChatBox.storedMessages.get(i) + "\"");
                QuickChatBox.storedMessages.remove(i);
                QuickChatBox.storedRecipients.remove(i);
                QuickChatBox.storedIDs.remove(i);
                QuickChatBox.storedHashes.remove(i);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No message found with hash: " + hash);
    }

    // f) Display full report
    public static void displayFullReport() {
        
        System.out.println("         FULL MESSAGE REPORT    ");
        

        System.out.println(" SENT MESSAGES (" + QuickChatBox.sentMessages.size() + ") ");
        for (int i = 0; i < QuickChatBox.sentMessages.size(); i++) {
            System.out.println((i + 1) + ". ID: " + QuickChatBox.sentIDs.get(i)
                    + "  Hash: " + QuickChatBox.sentHashes.get(i)
                    + "  To: " + QuickChatBox.sentRecipients.get(i)
                    + "  Msg: " + QuickChatBox.sentMessages.get(i));
        }

        System.out.println(" DISREGARDED MESSAGES (" + QuickChatBox.disregaredMessages.size() + ") ");
        for (int i = 0; i < QuickChatBox.disregaredMessages.size(); i++) {
            System.out.println((i + 1) + ". ID: " + QuickChatBox.disregaredIDs.get(i)
                    + "  Hash: " + QuickChatBox.disregaredHashes.get(i)
                    + "  To: " + QuickChatBox.disregaredRecipients.get(i)
                    + "  Msg: " + QuickChatBox.disregaredMessages.get(i));
        }

        System.out.println(" STORED MESSAGES (" + QuickChatBox.storedMessages.size() + ") ");
        for (int i = 0; i < QuickChatBox.storedMessages.size(); i++) {
            System.out.println((i + 1) + ". ID: " + QuickChatBox.storedIDs.get(i)
                    + "  Hash: " + QuickChatBox.storedHashes.get(i)
                    + "  To: " + QuickChatBox.storedRecipients.get(i)
                    + "  Msg: " + QuickChatBox.storedMessages.get(i));
        }

        System.out.println("Total messages sent: " + QuickChatBox.totalMessagesSent);
        System.out.println("");
    }

    // Returns report as a String (used by unit tests)
    public static String generateReport() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("         FULL MESSAGE REPORT    ");
        

        sb.append("SENT MESSAGES (").append(QuickChatBox.sentMessages.size()).append(") ");
        for (int i = 0; i < QuickChatBox.sentMessages.size(); i++) {
            sb.append((i + 1)).append(". ID: ").append(QuickChatBox.sentIDs.get(i))
              .append("  Hash: ").append(QuickChatBox.sentHashes.get(i))
              .append("  To: ").append(QuickChatBox.sentRecipients.get(i))
              .append("  Msg: ").append(QuickChatBox.sentMessages.get(i))
              .append(" ");
        }

        sb.append(" DISREGARDED MESSAGES (").append(QuickChatBox.disregaredMessages.size()).append(") ");
        for (int i = 0; i < QuickChatBox.disregaredMessages.size(); i++) {
            sb.append((i + 1)).append(". ID: ").append(QuickChatBox.disregaredIDs.get(i))
              .append(" Hash: ").append(QuickChatBox.disregaredHashes.get(i))
              .append(" To: ").append(QuickChatBox.disregaredRecipients.get(i))
              .append(" Msg: ").append(QuickChatBox.disregaredMessages.get(i))
              .append(" ");
        }

        sb.append(" STORED MESSAGES (").append(QuickChatBox.storedMessages.size()).append(") ");
        for (int i = 0; i < QuickChatBox.storedMessages.size(); i++) {
            sb.append((i + 1)).append(". ID: ").append(QuickChatBox.storedIDs.get(i))
              .append(" Hash: ").append(QuickChatBox.storedHashes.get(i))
              .append(" To: ").append(QuickChatBox.storedRecipients.get(i))
              .append(" Msg: ").append(QuickChatBox.storedMessages.get(i))
              .append(" ");
        }

        sb.append("Total messages sent: ").append(QuickChatBox.totalMessagesSent).append(" ");
        sb.append(" ");
        return sb.toString();
    }

    // Load stored_message.json into QuickChatBox stored arrays
    public static void loadStoredMessagesFromJSON() {
        QuickChatBox.storedMessages.clear();
        QuickChatBox.storedRecipients.clear();
        QuickChatBox.storedHashes.clear();
        QuickChatBox.storedIDs.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("stored_message.json"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String id        = extractJsonValue(line, "messageID");
                String recipient = extractJsonValue(line, "recipient");
                String message   = extractJsonValue(line, "message");
                String hash      = extractJsonValue(line, "messageHash");
                if (id != null && message != null) {
                    QuickChatBox.storedIDs.add(id);
                    QuickChatBox.storedRecipients.add(recipient != null ? recipient : "");
                    QuickChatBox.storedMessages.add(message);
                    QuickChatBox.storedHashes.add(hash != null ? hash : "");
                }
            }
            System.out.println("Loaded " + QuickChatBox.storedMessages.size() + " stored message(s) from file.");
        } catch (IOException e) {
            System.out.println("No stored_message.json found. Starting fresh.");
        }
    }

    // Simple JSON value extractor
    private static String extractJsonValue(String json, String key) {
        String search = "\"" + key + "\": \"";
        int start = json.indexOf(search);
        if (start == -1) return null;
        start += search.length();
        int end = json.indexOf("\"", start);
        if (end == -1) return null;
        return json.substring(start, end);
    }
}

    

