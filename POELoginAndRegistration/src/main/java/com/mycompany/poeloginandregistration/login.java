/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poeloginandregistration;

import java.util.Scanner;

/**
 *
 * @author thato
 */
public class login {
    public static void main(String[]args)
    {
        loginUser();
    }
     static void  loginUser(){
            Scanner input = new Scanner(System.in);
            boolean login =true;
            
            //Declartions
            String loginUsername;
            String savedPassword;
            String firstName = " ";
            String lastName = " ";
            
            //Using the while loop to loop until the user entered the correct details
            while(login){
                System.out.println("Login");
                System.out.println("Enter your username: ");
                loginUsername = input.next();
                System.out.println("Enter your password: ");
                savedPassword = input.next();
                System.out.println("Enter your firstname: ");
                firstName = input.next();
                System.out.println("Enter you lastname: ");
                lastName = input.next();
                 
                //Using if statement to check if the conditions are met
                if(loginUsername.equals(loginUsername)){
                    System.out.println("Welcome " + firstName + " " + lastName + " " + "it is great to see you again.");
                    login = true;
                    
                    
                    QuickChatBox.main(new String[]{});
                     break;
                }
                else
                {
                    System.out.println("Username or password is incorrect please try again.");
                }
            }
            
     
            }

}
