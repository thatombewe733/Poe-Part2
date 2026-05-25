/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poeloginandregistration;
import java.util.Scanner;
/**
 *
 * @author thato
 */
public class POELoginAndRegistration {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Declarations
        String username = "";
        String password = "";
        String phoneNum = "";
        String firstName = "";
        String lastName = "";
        String loginUsername = " ";
        String savedPassword = " ";
        
        checkUserName();
        checkPasswordComplixity();
        checkCellPhoneNumber();
        login.loginUser();
        
        
        
       
       
         }
     //Registerimg the user
     static boolean checkUserName() {
         //Declarations
         boolean corrUsername = true;
         String username;
        Scanner input = new Scanner(System.in);

        
        //Using the while loop to loop until the user enters the correct details
        while(corrUsername){
            //Prompt the user to enter their username
            System.out.println("Username must contain an underscore and is no more than five characters long");
            System.out.println("Please enter username: ");
            username = input.next();
            
            //Using if Statement to check if the conditions are met
            if(username.contains("_") && username.length()<=5) 
            {
                System.out.println("Username successfully captured.");
                corrUsername = false;
              
            }
            else
            {
                System.out.println("Username is not correctly formatted,please ensure that your username contains an underscore and is no more than five characters in length");
                System.out.println("Please re-enter your username: ");
            }
            

            }
        return false;
     }
        
        
        static boolean checkPasswordComplixity (){
            //Declarations
            boolean corrPassword = true;
             String password;
            Scanner input = new Scanner(System.in);
            //Using the while loop until the user enters the correct password
            while(corrPassword){
                //Prompt the user to enter their password
                System.out.println("Password must be at least eight character long, contain a capital letter, conatin a special character, and a number");
                System.out.println("Please enter password: ");
                password = input.next();
                
                //Using the if statement to check if the conditions of the password are met
                if(password.length()<=8 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&(),.?\":{}|<>}.*].*"))
                {
                    System.out.println("Password successfully captured.");
                    corrPassword = false;
                }
                else
                {
                    System.out.println("Password is not correctly formatted,please ensure that the password contain at least eight characters,a capital letter,a number,a special character");
                    System.out.println("Please re-enter your password");
                    
                }
                
            }
        return false;
        }
        
        static boolean checkCellPhoneNumber (){
            //Declartions
            boolean corrPhoneNumber = true;
             String phoneNum;
            Scanner input = new Scanner(System.in);
            //Using the while loop until the user enters the correct phone number
            while(corrPhoneNumber){
                //Prompt the user to enter their phone number
                System.out.println("Cellphone number must contain international code");
                System.out.println("Please enter phone number: ");
                phoneNum = input.next();
                
                //Using the if statement to check if the conditions of the cellphone are met
                if(phoneNum.contains("+27") && phoneNum.length()<=12)
                {
                    System.out.println("Cellphone number successfully added. ");
                    corrPhoneNumber = false;
                }
                else
                {
                    System.out.println("Cell phone number incorrectly formatted or does not contain an international code. ");
                    System.out.println("Please re-enter your phone number: ");
                }
                }
            System.out.println("Registration Successful. ");
        return false;
            }
}
        

    
    
        
    
    
        
        
            
