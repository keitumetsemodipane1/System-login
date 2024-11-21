/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemlogin;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
class Task {
    // Static arrays to manage tasks globally
    private static ArrayList<String> developerNames = new ArrayList<>();
    private static ArrayList<String> taskNames = new ArrayList<>();
    private static ArrayList<String> taskIDs = new ArrayList<>();
    private static ArrayList<Integer> taskDurations = new ArrayList<>();
    private static ArrayList<String> taskStatuses = new ArrayList<>();

    // Instance variables for a task
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration; // in hours
    private String taskStatus;

    /**
     * Constructor for creating a new Task.
     * 
     * taskNumber The unique number for the task.
     * developerDetails The developer working on the task.
     * taskName The name of the task.
     * taskDescription The description of the task.
     * taskDuration The duration of the task in hours.
     * taskStatus The current status of the task.
     */ 
    public Task(int taskNumber, String developerDetails, String taskName, String taskDescription, int taskduration, String taskstatus) {
        this.taskNumber = taskNumber;
        this.developerDetails = developerDetails;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDuration = taskduration;
        this.taskStatus = taskstatus;
        
         // Adds task details to static arrays
        taskNames.add(taskName);
        developerNames.add(developerDetails);
        taskDurations.add(taskDuration);
        taskStatuses.add(taskStatus);

        // Creates a unique task ID
        String taskID = "T" + (taskIDs.size() + 1); // Incremental task ID
        taskIDs.add(taskID);
    }
    
    // Getter for developerNames
    public static List<String> getDevelopers() {
        return developerNames;
    }
    
   //Validates the task description (should be 50 characters or less).
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

     // Creates a unique task ID based on the task name, task number, and developer's details.   
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

   // Prints the details of the task containing all the task details.
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
   
  // Calculates the total duration of all tasks in hours.
     
   public static int returnTotalHours(List<Task> tasks) {
        int totalHours = 0;// Initialize total hours counter to 0 
        for (Task task : tasks) {
            totalHours += task.taskDuration; //Total  hours for every task.
        }
        return totalHours;// Returns the total duration
 }
     
     /**
     * Adds a new task to the system.
     * 
     * taskName The name of the task.
     * developerDetails The developer assigned to the task.
     * taskDuration The duration of the task in hours.
     * taskStatus The current status of the task.*/
    public static void addTask(String taskName, String developerDetails, int taskDuration, String taskStatus) {
        taskNames.add(taskName);
        developerNames.add(developerDetails);
        taskDurations.add(taskDuration);
        taskStatuses.add(taskStatus);
        
        // Creates a task ID
        String taskID = "T" + (taskIDs.size() + 1);// Incremental task ID
        taskIDs.add(taskID);
    }
 
   //Displays all tasks in the system containing the details of all tasks   
    public static String showAllTasks() {
    if (taskNames.isEmpty()) {
        return "No tasks available.";
    } else {
        String taskDetails = "Tasks:\n";
        for (int i = 0; i < taskNames.size(); i++) {
            taskDetails += "ID: " + taskIDs.get(i) + "\n"
                        + "Name: " + taskNames.get(i) + "\n"
                        + "Developer: " + developerNames.get(i) + "\n"
                        + "Duration: " + taskDurations.get(i) + " hours\n"
                        + "Status: " + taskStatuses.get(i) + "\n\n";
        }
        return taskDetails;
    }
}

      //identifies and returns the longest task that is based on duration and return the details of the longest task.    
    public static String getLongestTask() {
        if (taskDurations.isEmpty()) {
            return "No tasks available.";
        } else {
            int longestTaskIndex = 0;
            for (int i = 1; i < taskDurations.size(); i++) {
                if (taskDurations.get(i) > taskDurations.get(longestTaskIndex)) {
                    longestTaskIndex = i;
                }
            }

            // Return the longest task details
            return "Longest Task:\n" +
                    "ID: " + taskIDs.get(longestTaskIndex) + "\n" +
                    "Name: " + taskNames.get(longestTaskIndex) + "\n" +
                    "Developer: " + developerNames.get(longestTaskIndex) + "\n" +
                    "Duration: " + taskDurations.get(longestTaskIndex) + " hours\n" +
                    "Status: " + taskStatuses.get(longestTaskIndex);
        }
    }

 //Searches for a task by name and returns its details.
    public static String searchTaskByName(String taskNameToSearch) {
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskNameToSearch)) {
                return "Task found:\n" +
                        "ID: " + taskIDs.get(i) + "\n" +
                        "Name: " + taskNames.get(i) + "\n" +
                        "Developer: " + developerNames.get(i) + "\n" +
                        "Duration: " + taskDurations.get(i) + " hours\n" +
                        "Status: " + taskStatuses.get(i);
            }
        }
        return "Task not found.";//returns a string with the task details, or a message if the task is not found.
    }

     // Searches for tasks by developer's name and returns the tasks assigned to that developer
   public static String searchTasksByDeveloper(String developerNameToSearch) {
    String developerTaskDetails = "Tasks for developer " + developerNameToSearch + ":\n";
    boolean developerFound = false;
    
    for (int i = 0; i < developerNames.size(); i++) {
        if (developerNames.get(i).equalsIgnoreCase(developerNameToSearch)) {
            developerTaskDetails += "ID: " + taskIDs.get(i) + "\n"
                                  + "Name: " + taskNames.get(i) + "\n"
                                  + "Duration: " + taskDurations.get(i) + " hours\n"
                                  + "Status: " + taskStatuses.get(i) + "\n\n";
            developerFound = true;
        }
    }
    
   
    if (developerFound) {
        return developerTaskDetails;
    } else {
        return "No tasks found for developer: " + developerNameToSearch;
    }
}


   // Deletes a task by its name. 
    public static String deleteTaskByName(String taskNameToDelete) {
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskNameToDelete)) {
                taskNames.remove(i);
                developerNames.remove(i);
                taskDurations.remove(i);
                taskStatuses.remove(i);
                taskIDs.remove(i);
                return "Task deleted successfully.";//returns a message indicating whether the task was successfully deleted or not.
            }
        }
        return "Task not found.";// Returns failure message if task is not found
    }

    // Method to generate a task report
   public static String TaskReport() {
    if (taskNames.isEmpty()) {
        return "No tasks available.";
    } else {
        String report = "Task Report:\n";
        for (int i = 0; i < taskNames.size(); i++) {
            report += "ID: " + taskIDs.get(i) + "\n"
                    + "Name: " + taskNames.get(i) + "\n"
                    + "Developer: " + developerNames.get(i) + "\n"
                    + "Duration: " + taskDurations.get(i) + " hours\n"
                    + "Status: " + taskStatuses.get(i) + "\n\n";
        }
        return report;
    }
}

}

