package com.mycompany.poeloginandregistration;

import java.util.Scanner;

public class POELoginAndRegistration {

    public static void main(String[] args) {
        checkUserName();
        checkPasswordComplixity();
        checkCellPhoneNumber();
    }

    // Instance methods for testing
    public boolean checkUsernameValid(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordValid(String password) {
        return password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*[0-9].*")
                && password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }

    public boolean checkPhoneNumberValid(String phoneNum) {
        return phoneNum.startsWith("+27") && phoneNum.length() <= 13;
    }

    // Static interactive methods (unchanged)
    static boolean checkUserName() {
        boolean corrUsername = true;
        String username;
        Scanner input = new Scanner(System.in);
        while (corrUsername) {
            System.out.println("Username must contain an underscore and is no more than five characters long");
            System.out.println("Please enter username: ");
            username = input.next();
            if (username.contains("_") && username.length() <= 5) {
                System.out.println("Username successfully captured.");
                corrUsername = false;
            } else {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length");
            }
        }
        return false;
    }

    static boolean checkPasswordComplixity() {
        boolean corrPassword = true;
        String password;
        Scanner input = new Scanner(System.in);
        while (corrPassword) {
            System.out.println("Password must be at least eight characters long, contain a capital letter, a special character, and a number");
            System.out.println("Please enter password: ");
            password = input.next();
            if (password.length() >= 8
                    && password.matches(".*[A-Z].*")
                    && password.matches(".*[0-9].*")
                    && password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
                System.out.println("Password successfully captured.");
                corrPassword = false;
            } else {
                System.out.println("Password is not correctly formatted.");
            }
        }
        return false;
    }

    static boolean checkCellPhoneNumber() {
        boolean corrPhoneNumber = true;
        String phoneNum;
        Scanner input = new Scanner(System.in);
        while (corrPhoneNumber) {
            System.out.println("Cellphone number must contain international code");
            System.out.println("Please enter phone number: ");
            phoneNum = input.next();
            if (phoneNum.startsWith("+27") && phoneNum.length() <= 13) {
                System.out.println("Cellphone number successfully added.");
                corrPhoneNumber = false;
            } else {
                System.out.println("Cell phone number incorrectly formatted or does not contain an international code.");
            }
        }
        System.out.println("Registration Successful.");
      login.main(new String[]{});
MessageSender.main(new String[]{});
QuickChatBox.main(new String[]{});
        
        return true;
    }
}