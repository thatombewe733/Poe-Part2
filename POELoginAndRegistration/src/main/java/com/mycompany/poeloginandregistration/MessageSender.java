/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poeloginandregistration;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author thato
 */
public class MessageSender {
    private String message;
    private String recipient;
    private String messageHash;
    private String messageID;
    private int numMessagesSent;
    private HashMap<String,String>  storedMessages = new HashMap<>();
    
    
    //Constructor for the recipient message number and the message ID
   public MessageSender(String recipient, String message, int numSent){
       this.recipient = recipient;
       this.message = message;
       this.numMessagesSent = numSent;
       this.messageID = generateMessageID();
   }
          
    public static void main(String[] args){
        String userMessage;
          Scanner myMessage = new Scanner(System.in);
          StringBuilder messageID = new StringBuilder();
    }

                  
                  
                  //Generating and randomise the message ID
    private String generateMessageID() {
        Random newNum = new Random();
        StringBuilder messageID = new StringBuilder();
                  for (int i = 0; i<10; i++)
                  {
                      messageID.append(newNum.nextInt(10));
                  }
                  return messageID.toString();
    }
    

    //Checking if the messageID is not long than 10 characters
    public boolean checkMessageID() {
        if (messageID.length() < 10)
        {
            return true;
        }
        return false;
    }
    //Check for recipient cellphone number
    public String checkRecipientCell() {
        if(recipient.length() <12 && recipient.startsWith("+"))
        {
            return "Cellphone number is successfully captured.";
        }
        else
        {
            return "Cellphone number is incorrectly formated or does not conatin an international code.Please re-enter your phone number: ";
           
        }
    }
        public String checkMessageLength() {
            if(message == null)
                return "Please enter a message of less than 250 characters";
            if(message.length()>250){
                int extra = message.length()-250;
                return "Message exceeds 250 characters by " + extra + "; please reduce the length of the message.";
            }
            return "Message sent";
            }
        //Creating a message hash
        public String createMessageHash() {
            if(message == null || message.trim().isEmpty()) {
                return messageID.substring(0 , 2) + " " + numMessagesSent + " ";
            }
            String[] words = message.trim().split("\\s+");
            String lastWord = words[words.length - 1];
            String firstWord = words[0]; 
            lastWord = lastWord.replaceAll("[^a-zA-Z0-9]", " ");
            firstWord = firstWord.replaceAll("[^a-zA-Z0-9]", " ");
            messageHash =(messageID.substring(0, 2) + ":" + numMessagesSent + ":" + firstWord + lastWord).toUpperCase();
            return messageHash;
            }
        //sending messages
        public String sendMessage() {
             Scanner myMessage = new Scanner(System.in);
            //Prompting the use to enter their choice
            System.out.println("1)Send a Message");
            System.out.println("2)Disregard message");
            System.out.println("3)Store the message to send later");
            System.out.println("Choose your choice:");
            String choice = myMessage.nextLine();
            
            if (choice.equals("1")){
                numMessagesSent++;
                return "Message successfully sent";
            }
            else if(choice.equals("2")){
                return"Press 0 to delete your message.";
            }
            else if(choice.equals("3")){
                storedMessages.put(messageID,message);
                  System.out.println("Messages successfully associated with their ID");
                  System.out.println("Message ID:" + messageID + "is a message: "+ message);
                  //Using the JSON file to store the message and to also save the message
                  storeMessageToJSON();
                return"Message successfully stored";
            }
            else
            {
                return"Invalid choice";
            }
        }
            //store the message to JSON file
        private void storeMessageToJSON(){
                //store to the JSON file
                String jsonMessage = " " + "messageID: " + messageID + " " +
                        "recipient: " + recipient + " " +
                        "message: " + message + " " + 
                        "messageHash: " + messageHash + " ";
                try {
                    FileWriter file = new FileWriter("stored_message.json");
                    file.write(jsonMessage);
                    file.flush();
                    file.close();
                    System.out.println("Message sucessfully stored");
                }
                catch (IOException e){
                    System.out.println("Error writing to JSON file: "+ e.getMessage());
                }
            }
                
            //Print all the messages 2ith the messageID, messageHash,recipient and the message 
        public String printMessage() {
            return "MessageID: " + messageID + " " +
                    "Message Hash: " + messageHash + " " 
                    + "Recipient: " + recipient +" "
                    + "Message: " + message;
        }

        
        //Returning total messages
        public int returnTotalMessages() {
            return numMessagesSent;
        }
        //using Getters to get the recipient,the message, the messageHash, number of messages sent, messageID
        public String getMessage(){
            return message;
        }
        public String getMessageHash(){
            return messageHash;
        }
        public String getRecipient(){
            return recipient;
        }
        public int getNumMesaagesSent(){
            return numMessagesSent;
        }
        public String getMessageID(){
            return messageID;
        }
        //The main menu
        public static void Menu(){
            Scanner input = new Scanner(System.in);
            boolean run = true;
            int messageCounter = 0;
            System.out.println("Welcome");
        }
                
            
            
        }
                
            
              
        
            
     
        
   
        
            
                  
                     
    
                  
                 
                      
                  
         
            
            
        
    

