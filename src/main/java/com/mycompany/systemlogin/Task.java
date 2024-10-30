/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemlogin;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration; // in hours
    private String taskStatus;

    public Task(int taskNumber, String developerDetails, String taskName, String taskDescription, int taskduration, String taskstatus) {
        this.taskNumber = taskNumber;
        this.developerDetails = developerDetails;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDuration = taskduration;
        this.taskStatus = taskstatus;
    }
   // Method that checks and set the task description
   public boolean checkTaskDescription(String description) {
    if (description.length() <= 50) {
        this.taskDescription = description; // Set the task description
        JOptionPane.showMessageDialog(null, "Task successfully captured");
        return true; 
    } else {
        JOptionPane.showMessageDialog(null, " Please enter a  description of less than 50 characters ");
        return false; 
    }
}

     // Method to create Task ID
    public String createTaskID() {
     
   String letters;// Get the first two letters of the task name
      if (taskName.length() >= 2) {
    letters = taskName.substring(0, 2).toUpperCase();//Capitalize the first two letters
     } else {
    letters = taskName.toUpperCase();// Capitalize if the name is shorter
   }
      
    String taskNum = Integer.toString(taskNumber);  // Get the task number as a string
     String threeLetters; // Gets the last three letters of the developer details
         if (developerDetails.length() < 3) {
         threeLetters = developerDetails.toUpperCase();
          } else {
         threeLetters = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
          }   
          return letters + ":" + taskNum + ":" + threeLetters; // It combines  everything into the Task ID
    }

    //This method gives you the task information in a string.
   public String printTaskDetails() {
    String details = "Task Number: " + taskNumber + "\n" +
                     "Task Name: " + taskName + "\n" +
                     "Developer: " + developerDetails + "\n" +
                     "Description: " + taskDescription + "\n" +
                     "Duration: " + taskDuration + " hrs\n" +
                     "Status: " + taskStatus + "\n" +
                     "Task ID: " + createTaskID();
      return details;
     }
// Method to calculate the total duration of tasks in a list
 public static int returnTotalHours(List<Task> tasks) {
        int totalHours = 0;// Initialize total hours counter to 0 
        for (Task task : tasks) {
            totalHours += task.taskDuration; //Total the hours for every task.
        }
        return totalHours;// Return the total duration
    
}
}
