/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poeloginandregistration;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author thato
 */

public class QuickChatBox {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<MessageSender> messageList = new ArrayList<>();
    static int totalMessagesSent = 0;

    static ArrayList<String> sentMessages = new ArrayList<>();
    static ArrayList<String> sentRecipients = new ArrayList<>();
    static ArrayList<String> sentHashes = new ArrayList<>();
    static ArrayList<String> sentIDs = new ArrayList<>();

    static ArrayList<String> disregaredMessages = new ArrayList<>();
    static ArrayList<String> disregaredRecipients = new ArrayList<>();
    static ArrayList<String> disregaredHashes = new ArrayList<>();
    static ArrayList<String> disregaredIDs = new ArrayList<>();

    static ArrayList<String> storedMessages = new ArrayList<>();
    static ArrayList<String> storedRecipients = new ArrayList<>();
    static ArrayList<String> storedHashes = new ArrayList<>();
    static ArrayList<String> storedIDs = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to QuickChat.");

        System.out.print("How many messages would you like to send? ");
        int numofMessages = 0;
        try {
            numofMessages = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Exiting.");
            return;
        }

        boolean run = true;
        while (run) {
            System.out.println("Main Menu");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Choose your option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    sendMessages(numofMessages);
                    break;
                case "2":
                    Report.storedMessagesMenu();
                    break;
                case "3":
                    run = false;
                    System.out.println("Goodbye!");
                    return; 
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    static boolean login(String username, String password) {
        return username != null && !username.isEmpty() && password != null && !password.isEmpty();
    }

    static void sendMessages(int numMessages) {
        int count = 0;

        while (count < numMessages) {
            System.out.println("Message " + (count + 1) + " of " + numMessages);

            System.out.print("Enter recipient cell number with international code: ");
            String recipient = scanner.nextLine().trim();

            System.out.print("Enter your message: ");
            String messageText = scanner.nextLine().trim();

            MessageSender msg = new MessageSender(recipient, messageText, count);

            // Validate recipient
            String recipientCheck = msg.checkRecipientCell();
            if (!recipientCheck.equals("Cell phone number successfully captured.")) {
                System.out.println(recipientCheck);
                continue;
            }
            System.out.println(recipientCheck);

            // Validate message length
            if (messageText.length() > 250) {
                System.out.println("Please enter a message of less than 250 characters.");
                continue;
            }

            String hash = msg.createMessageHash();
            System.out.println("Message Hash: " + hash);
            System.out.println("Message ID: " + msg.getMessageID());

            
            String result = msg.sendMessage(scanner);

            if (result.equals("Message successfully sent")) {
                sentMessages.add(messageText);
                sentRecipients.add(recipient);
                sentHashes.add(hash);
                sentIDs.add(msg.getMessageID());
                messageList.add(msg);
                totalMessagesSent++;
                System.out.println(msg.printMessage());

            } else if (result.equals("Message successfully stored")) {
                storedMessages.add(messageText);
                storedRecipients.add(recipient);
                storedHashes.add(hash);
                storedIDs.add(msg.getMessageID());
                messageList.add(msg);
                totalMessagesSent++;
                System.out.println(msg.printMessage());

            } else if (result.equals("Press 0 to delete the message.")) {
                disregaredMessages.add(messageText);
                disregaredRecipients.add(recipient);
                disregaredHashes.add(hash);
                disregaredIDs.add(msg.getMessageID());
                System.out.println("Message discarded.");

            } else {
                System.out.println("Invalid choice. Please try again.");
                continue; 
            }

            count++;  
        }

        System.out.println("Total messages sent: " + totalMessagesSent);
    }

    static int returnTotalMessages() {
        return totalMessagesSent;
    }
}