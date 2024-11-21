/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.systemlogin;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
/**
 * Test class for Task class. This class tests various functionalities of the Task class 
 * such as task creation, task description validation, task duration calculation, 
 * and task management (addition, deletion, etc.).
 */
public class TaskTest {

   private Task taskData1; // Variable to hold the first Task data
   private Task taskData2; // Variable to hold the second Task data
   
   // This method runs before each test method
   @BeforeEach 
   public void setUp() {
        // Initialize taskData1 and taskData2 with example data
        taskData1 = new Task(1, "Robyn Harrison", "Login Feature", "Create Login to authenticate users", 8, "To Do");
        taskData2 = new Task(2, "Mike Smith", "Add Task Feature", "Create Add Task feature to add task users", 10, "Doing");
    }


   /**
    * Test to ensure that the developerNames array is populated correctly
    * when tasks are added using the addTask method.
    */
   @Test
   public void testDeveloperArrayPopulation() {
        // Add tasks to populate the arrays
        Task.addTask("Mike Smith", "Create Login", 5, "To Do");
        Task.addTask("Edward Harrison", "Create Add Features", 8, "Doing");
        Task.addTask("Samantha Paulson", "Create Reports", 2, "Done");
        Task.addTask("Glenda Oberholzer", "Add Arrays", 11, "To Do");
        // Expected developers list
        List<String> expectedDevelopers = List.of("Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer");
        // Check if the developerNames array is populated correctly
        assertEquals(expectedDevelopers, Task.getDevelopers());
   }

   /**
    * Test of CheckTaskDescription method, of class Task.
    * This test ensures that the task description is validated correctly.
    */
   @Test
   public void testCheckTaskDescription() {
        System.out.println("Task successfully captured");
        String description = "Create Login to authenticate users";
        Task instance = new Task(1, "Robyn Harrison", "Login Feature", description, 8, "To Do");
        boolean expResult = true; // Expected validation result
        boolean result = instance.checkTaskDescription(description);
        assertEquals(expResult, result); // Assert that the validation is correct
   }

   /**
    * Test for failed description validation where the description exceeds the 50-character limit.
    */
   @Test
   public void testFailedCheckTaskDescription() {
        System.out.println("Please enter a description of less than 50 characters");
        String description = "This description is way too long to pass validation and will fail the test";
        Task instance = new Task(1, "Robyn Harrison", "Login Feature", description, 8, "To Do");
        boolean expResult = false; // Expected validation result
        boolean result = instance.checkTaskDescription(description);
        assertEquals(expResult, result); // Assert that the validation fails
   }

   /**
    * Test of createTaskID method, of class Task.
    * This test ensures that the unique task ID is created correctly.
    */
   @Test
   public void testCreateTaskID() {
        System.out.println("TaskID");
        Task instance = taskData1;
        String expResult = "AD:2:ITH"; // Expected result for task ID based on the task name and developer
        String result = taskData2.createTaskID();
        assertEquals(expResult, result); // Assert that the task ID is correctly generated
   }

   /**
    * Test of returnTotalHours method, of class Task.
    * This test ensures that the total hours of tasks are calculated correctly.
    */
   @Test
   public void testReturnTotalHours() {
        System.out.println("returnTotalHours");
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, "Robyn Harrison", "Login Feature", "Create Login to authenticate users", 8, "To Do"));
        tasks.add(new Task(2, "Mike Smith", "Add Task Feature", "Create Add Task feature", 10, "Doing"));
        int expResult = 18;  // Expected result (8 + 10 = 18)
        int result = Task.returnTotalHours(tasks); 
        assertEquals(expResult, result); // Assert that the total hours match the expected result
   }

   /**
    * Additional test of returnTotalHours method with more tasks.
    */
   @Test
   public void testAdditionalReturnTotalHours() {
        System.out.println("returnTotalHours");
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, "Alice Brown", "Task 1", "Description 1", 10, "To Do"));
        tasks.add(new Task(2, "Bob White", "Task 2", "Description 2", 12, "Doing"));
        tasks.add(new Task(3, "Charlie Black", "Task 3", "Description 3", 55, "Done"));
        tasks.add(new Task(4, "Diana Grey", "Task 4", "Description 4", 11, "To Do"));
        tasks.add(new Task(5, "Eve Green", "Task 5", "Description 5", 1, "Doing"));
        int expResult = 89;  // Expected result (10 + 12 + 55 + 11 + 1 = 89)
        int result = Task.returnTotalHours(tasks);
        assertEquals(expResult, result); // Assert that the total hours match the expected result
   }


   /**
    * Test of getLongestTask method, of class Task.
    * This test ensures that the task with the longest duration is correctly identified.
    */
   @Test
   public void testGetLongestTask() {
        // Add tasks to the system
        Task.addTask("Create Login", "Mike Smith", 5, "To Do");
        Task.addTask("Create Add Features", "Edward Harrison", 8, "Doing");
        Task.addTask("Create Reports", "Samantha Paulson", 2, "Done");
        Task.addTask("Add Arrays", "Glenda Oberholzer", 11, "To Do");
        // Get the task with the longest duration
        String result = Task.getLongestTask(); // Should return task info of the longest task
        String expected = "Glenda Oberholzer, Add Arrays, 11 hours";  // Expected result
        assertEquals(expected, result); // Assert that the longest task is correctly identified
   }

   /**
    * Test of searchTaskByName method, of class Task.
    * This test ensures that tasks can be correctly searched by their name.
    */
   @Test
   public void testSearchTaskByName() {
        // Add tasks to the system
        Task.addTask("Create Login", "Mike Smith", 5, "To Do");
        Task.addTask("Create Add Features", "Edward Harrison", 8, "Doing");
        // Search for a task by name
        String result = Task.searchTaskByName("Create Login");  // Should return task info
        String expected = "Mike Smith, Create Login, 5 hours, To Do";  // Expected output format
        assertTrue(result.contains("Mike Smith"));
        assertTrue(result.contains("Create Login"));
   }

   /**
    * Test of searchTasksByDeveloper method, of class Task.
    * This test ensures that tasks can be searched by developer.
    */
   @Test
   public void testSearchTasksByDeveloper() {
        // Add tasks to the system
        Task.addTask("Create Login", "Mike Smith", 5, "To Do");
        Task.addTask("Create Add Features", "Edward Harrison", 8, "Doing");
        // Search tasks by developer
        String result = Task.searchTasksByDeveloper("Mike Smith");  // Should return task info for Mike Smith
        assertTrue(result.contains("Create Login"));
        assertTrue(result.contains("Mike Smith"));
   }

   /**
    * Test of deleteTaskByName method, of class Task.
    * This test ensures that a task can be correctly deleted by its name.
    */
   @Test
   public void testDeleteTaskByName() {
        // Add tasks to the system
        Task.addTask("Create Login", "Mike Smith", 5, "To Do");
        Task.addTask("Create Add Features", "Edward Harrison", 8, "Doing");
        // Delete a task by name
        String deleteResult = Task.deleteTaskByName("Create Reports");
        assertEquals("Task deleted successfully.", deleteResult);
        // Ensure the task was deleted
        String taskList = Task.showAllTasks();
        assertFalse(taskList.contains("Create Reports"));
   }

   /**
    * Test of TaskReport method, of class Task.
    * This test ensures that a report of all tasks can be generated correctly.
    */
   @Test
   public void testTaskReport() {
        // Add tasks to the system
        Task.addTask("Create Login", "Mike Smith", 5, "To Do");
        Task.addTask("Create Add Features", "Edward Harrison", 8, "Doing");
        // Get the task report
        String report = Task.TaskReport();  //  return a report of all tasks
        assertTrue(report.contains("Mike Smith"));
        assertTrue(report.contains("Create Login"));
        assertTrue(report.contains("Edward Harrison"));
        assertTrue(report.contains("Create Add Features"));
   }

}
