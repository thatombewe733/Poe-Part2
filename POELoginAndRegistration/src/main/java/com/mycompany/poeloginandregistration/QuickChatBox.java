/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poeloginandregistration;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author thato
 */
public class QuickChatBox {
     static Scanner scanner = new Scanner(System.in);
    static ArrayList<MessageSender> messageList = new ArrayList<>();
    static int totalMessagesSent = 0;

 public static void main(String[] args) {

     // check if user is logged in first
        System.out.println("Welcome to QuickChat.");

        // ask how many messages they want to send
        System.out.print("How many messages would you like to send? ");
        int numofMessages = 0;
        try {
            numofMessages = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Exiting.");
            return;
        }

        boolean run = true;

        while (run) {
            System.out.println(" Main Menu");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Choose your option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    sendMessages(numofMessages);
                    break;
                case "2":
                    System.out.println("Coming Soon.");
                    break;
                case "3":
                    run = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // basic login method - just checks if fields are not empty
    static boolean login(String username, String password) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        if (password == null || password.isEmpty()) {
            return false;
        }
        return true;
    }

    static void sendMessages(int numMessages) {
        int count = 0;

        while (count < numMessages) {
            System.out.println(" Message " + (count + 1) + " of " + numMessages + " ");

            System.out.print("Enter recipient cell number with international code: ");
            String recipient = scanner.nextLine();

            System.out.print("Enter your message: ");
            String messageText = scanner.nextLine();

            // create the message object
            MessageSender msg = new MessageSender(recipient,  messageText, count);

            // validate recipient
            String recipientCheck = msg.checkRecipientCell();
            if (!recipientCheck.equals("Cell phone number successfully captured.")) {
                System.out.println(recipientCheck);
                continue; // ask again
            }

            // validate message length
            if (messageText.length() > 250) {
                int more = messageText.length() - 250;
                System.out.println("Please enter a message of less than 250 characters.");
                continue;
            } else {
                System.out.println("Message sent");
            }

            // generate hash and displays it
            String hash = msg.createMessageHash();
            System.out.println("Message Hash: " + hash);
            System.out.println("Message ID: " + msg.getMessageID());

            // ask what to do with message
            String result = msg.sendMessage();
            System.out.println(result);

            if (!result.equals("Press 0 to delete the message.")) {
                messageList.add(msg);
                totalMessagesSent++;
                count++;

                // print full message details
                System.out.println(" Message Details");
                System.out.println(msg.printMessage());
            } else {
                System.out.println("Message discarded.");
                count++;
            }
        }

        // show total after all messages done
        System.out.println("Total messages sent: " + count);
    }

    static int returnTotalMessages() {
        return totalMessagesSent;
    }
}



    