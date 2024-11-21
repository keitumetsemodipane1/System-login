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
        //login intance of the login 
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
               
      // Username validation loop
        String tempUsername;
     do { 
       System.out.println("Please enter your username ");
       tempUsername = sc.nextLine(); // Read the username
       user.setUserName(tempUsername); // Set username
        } 
     while (!user.CheckUsername(tempUsername)); // Checks the username

        // Password complexity check loop
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
        boolean exit = false; // Flag to control the loop. Initially set to false to keep the program running

        // Display a welcome message when the application starts
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        // Main loop to keep the program running until the user chooses to quit
        while (!exit) {
            // Show a menu asking for the user's choice (Add task, Show tasks, or Quit)
            String choice = JOptionPane.showInputDialog(
                "Choose an option:\n" +
                "1) Add task\n" +
                "2) Show all tasks\n" +
                "3) Quit\n" +
                "4) Longest Task\n" +
                "5) Search by Task Name\n" +
                "6) Search by Developer\n" +
                "7) Delete Task\n" +
                "8) Task Report\n");

            // Switch statement to handle different menu options based on the user's input
            switch (choice) {
                case "1": // Add task
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
                developerDetails = JOptionPane.showInputDialog( "Enter developer's first name  and last name:");
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
                case "2": // Show all tasks
                    // Display a dialog with all the tasks using the Task class's showAllTasks method
                    JOptionPane.showMessageDialog(null, Task.showAllTasks());
                    break;

                case "3": // Quit the program
                    exit = true; // This will break out of the loop and return from the current method
                    break;

                case "4": // display the longest task
                    // Call the Task class's getLongestTask method and display the result in a dialog
                    JOptionPane.showMessageDialog(null, Task.getLongestTask());
                    break;

                case "5": // Search for a task by its name
                    // Prompt the user to input the task name they wish to search for
                    String taskNameToSearch = JOptionPane.showInputDialog("Enter task name to search:");
                    // Display the search result using the Task class's searchTaskByName method
                    JOptionPane.showMessageDialog(null, Task.searchTaskByName(taskNameToSearch));
                    break;

                case "6": // Search tasks by the developer's name
                    // Prompt the user to input the developer's name
                    String developerNameToSearch = JOptionPane.showInputDialog("Enter developer name to search:");
                    // Display the search result using the Task class's searchTasksByDeveloper method
                    JOptionPane.showMessageDialog(null, Task.searchTasksByDeveloper(developerNameToSearch));
                    break;

                case "7": // Delete a task by its name
                    // Prompt the user to input the name of the task they wish to delete
                    String taskNameToDelete = JOptionPane.showInputDialog("Enter task name to delete:");
                    // Show the result of deleting the task using the Task class's deleteTaskByName method
                    JOptionPane.showMessageDialog(null, Task.deleteTaskByName(taskNameToDelete));
                    break;

                case "8": // Display a full report of all tasks
                    // Show the task report generated by the Task class's TaskReport method
                    JOptionPane.showMessageDialog(null, Task.TaskReport());
                    break;

                default: // Handle invalid menu options
                    // Display a message dialog informing the user of an invalid option
                    JOptionPane.showMessageDialog(dialog, "Invalid option. Please try again.");
                    break;
            }
        }

       // Close the dialog when the program quits
        dialog.dispose();
    }
}
