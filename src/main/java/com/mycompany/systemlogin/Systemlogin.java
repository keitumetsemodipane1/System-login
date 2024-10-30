/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.systemlogin;
import java.util.*;
import javax.swing.*;

/**
 * Main class for the system login and task management application.
 * @author RC_Student_lab
 */
public class Systemlogin {

    public static void main(String[] args) {
        //login intance ogf the login 
        Login user= new Login();   
        String registrationMessage;
               
        
        //Create the object of the Scanner that reads the users input
        Scanner sc= new Scanner (System.in);
        
        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        
         //Registration 
          System.out.println(">>>>Registration <<<<");
         //promts the user to enter details
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
        System.out.println(">>>Login<<<");
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


    ArrayList<Task> taskList = new ArrayList<>();// List to hold tasks
    
    //Delarations for task details
    String taskName;
    int TaskNumber;
    String taskDescription;
    String developerDetails;
    int taskDuration;
    String taskStatus;
    int taskCounter = 1;//tracks the number of tasks
    
    JOptionPane.showMessageDialog(null, "Welcome to EasyKanban"); // Welcome message displayed
    boolean exit = false;//Variable to exit the loop.
    
    while (!exit){// Loop until the user chooses to exit
        String choice = JOptionPane.showInputDialog(
             "Choose an option:\n1"
              + " Add tasks\n2)"
              + " Show all tasks\n3)  " 
              + "Quit");
        
        
        // Switch cases for user options
        switch (choice){
            case"1"://Handle the user's input.
                 TaskNumber =Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to enter?"));
                for (int i = 0 ; i < TaskNumber ; i++){
                taskName=JOptionPane.showInputDialog("Enter a task name");
               
                 // Loop for valid task description input
                 while (true) {
                 taskDescription = JOptionPane.showInputDialog( "Please enter a task description of less than 50 characters:");
                 if (taskDescription.length() <= 50) {
                break; // Valid input
                  }
                JOptionPane.showMessageDialog(dialog, "Task succussfully captured.");
                } 
           
                 // Loop for valid developer details input
                while (true) {
                developerDetails = JOptionPane.showInputDialog( "Enter developer's first and last name:");
                //  Checks for exactly two words separated by a space
                if (developerDetails.matches("\\S+ \\S+")) {
                break; // Valid input
                }
                 JOptionPane.showMessageDialog( null,"Please enter both first and last names.");
                 }
                
                // Loop for valid task duration input
                 do {
                 String input = JOptionPane.showInputDialog("Enter duration of the task in  hours:");
                 if (input == null) {
                    JOptionPane.showMessageDialog(null,"Invalid input,Please enter a valid number for duration.");
                    return; // Exit if canceled
                }
                 //Checks if the input matches a valid number 
                if (input.matches("\\d+")) {
                  taskDuration = Integer.parseInt(input); // Convert input to an integer
                {
                        break; 
                }// Valid input
                    }
                } while (true);
                            
                // Create a Task with the provided data
                Task newTask = new Task(taskCounter++, developerDetails, taskName, taskDescription, taskDuration, ""); 
                 // Shows successful capture message
                 JOptionPane.showMessageDialog(dialog, "Task successfully captured with ID: " + newTask.createTaskID());
                  // Ask for task status
                   taskStatus = JOptionPane.showInputDialog(
                           "Enter task status:\n1)"
                           + " To Do\n2)"
                           + " Done\n3) "
                           + "Doing");

                        // Add the task to the list
                        taskList.add(newTask);
                    }
                    break;
                    
             // Case for displaying task details
            case "2":
                   if (taskList.isEmpty()) {// CheckS if the task list is empty
                JOptionPane.showMessageDialog(null, "No tasks available.");
                 } else {
                 String taskDetails = "Tasks:\n"; // Initialize  string to hold task details
                 for (Task task : taskList) {
                 taskDetails += task.printTaskDetails() + "\n";
             }
                JOptionPane.showMessageDialog(null, taskDetails); // Show the dialog here
             }

                    break;
            case "3": // Case for calculating and displaying total task hours
                    int totalHours = Task.returnTotalHours(taskList); //Calculates  total hours from the task list
                    JOptionPane.showMessageDialog(dialog, "Total hours: " + totalHours);
                    exit = true; // Exit the loop
                    break;

                default: //  invalid option
                    JOptionPane.showMessageDialog(dialog, "Invalid option, please try again.");
                    break;
            }
        }

        dialog.dispose(); // Dispose of the dialog when done
        sc.close(); // Close the scanner
    }
}
