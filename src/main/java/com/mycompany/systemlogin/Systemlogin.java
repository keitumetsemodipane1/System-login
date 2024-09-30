/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.systemlogin;
import java.util.*;

/**
 *
 * @author RC_Student_lab
 */
public class Systemlogin {

    public static void main(String[] args) {
        //login intance ogf the login 
        Login user= new Login();   
        String registrationMessage;
               
        
        //Create the object of the Scanner that reads the users input
        Scanner sc= new Scanner (System.in);
        
         //Registration  promts the user to enter details
       System.out.println("Please enter your name");
        String firstName=sc.nextLine();
        user.setFirstName(firstName); // Sets first name
       
        
        System.out.println("Please enter your lastname");        
        String lastName=sc.nextLine();
        user.setlastName(lastName);//Sets the lastname
        
        String tempUsername;
     do { 
       System.out.println("Please enter your username ");
       tempUsername = sc.nextLine(); // Read the username
       user.setUserName(tempUsername); // Set username
        } 
     while (!user.CheckUsername(tempUsername)); // Checks the username

        
       String password;
    do { 
       System.out.println("Please enter your password");
       password = sc.nextLine(); // Read the password
       user.setPassWord(password); 
       } 
    while (!user.checkPasswordComplexity(password));
                
        // Call the registerUser method to register the user
            registrationMessage = user.registerUser();     
            System.out.println(registrationMessage); //Displays the registration message

    // Check if registration was successful
        if (!registrationMessage.equals("Username and password successfully captured")) {
            return; // Exit when registration failed
        }
    boolean loginSuccessful = false; // Initializing the login status to false which prevents  login attempts until user is successful registered
    
    // Loop for user to  login until successful
    do { 
        // Prompt the user to log in with their username
        System.out.println("Please enter your username to log in:");
        String enteredUsername = sc.nextLine();
        
        // Prompt the user to log in with their password
        System.out.println("Please enter your password:");
        String enteredPassword = sc.nextLine();
     
        // Attempt to log in
        loginSuccessful = user.loginUser(enteredUsername, enteredPassword);
        
        // Output the login status
        System.out.println(user.returnLoginStatus(loginSuccessful));
        
    } while (!loginSuccessful); 

    }
       
    }

