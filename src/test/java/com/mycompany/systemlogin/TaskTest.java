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
public class TaskTest {
    
   private Task taskData1;// Variable to hold the first Task data
    private Task taskData2;// Variable to hold the second  Task data
    
    @BeforeEach // This method runs before each test method
    public void setUp() {
        
        // Set up taskData1 with example data
   taskData1 = new Task(1, "Robyn Harrison", "Login Feature", "Create Login to authenticate users", 8, "To Do");
   // Set up taskData2 with example data
   taskData2 = new Task(2, "Mike Smith", "Add Task Feature", "Create Add Task feature to add task users", 10, "Doing");
         
    }
    
  
    /**
     * Test of checkTaskDescription method, of class Task.
     */
    @Test
    public void testCheckTaskDescription() {
        System.out.println("Task successfully captured");
        String description = "Task successfully captured";
        Task instance = new Task(1, "Robyn Harrison", "Login Feature", "Create Login to authenticate users", 8, "To Do");
        boolean expResult = true;
        boolean result = instance.checkTaskDescription(description);
        assertEquals(expResult, result);
        
    }
     @Test
    public void testfaiedcheckTaskDescription() {
        System.out.println("please enter a description of less than 50 characters");
        String description = "please enter a description of less than 50 characters";
        Task instance =  new Task(1, "Robyn Harrison", "Login Feature", "Create Login to authenticate users", 8, "To Do");
        boolean expResult = false;
        boolean result = instance.checkTaskDescription(description);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of createTaskID method, of class Task.
     */
    @Test
    public void testCreateTaskID() {
         System.out.println("TaskID");
       Task instance = taskData1;
        String expResult = "AD:2:ITH";
        String result = taskData2.createTaskID();
        assertEquals(expResult, result);
    }
 

    
    /**
     * Test of returnTotalHours method, of class Task.
     */
    @Test
    public void testReturnTotalHours() {
       System.out.println("returnTotalHours");
        List<Task> tasks = new ArrayList<>();     
        tasks.add(new Task(1, "Robyn Harrison", "Login Feature", "Create Login to authenticate users", 8, "To Do"));
        tasks.add(new Task(2, "Mike Smith", "Add Task Feature", "Create Add Task feature to add task users", 10, "Doing"));
        int expResult = 18;
        int result = Task.returnTotalHours(tasks);
        assertEquals(expResult, result);
    }
    @Test
    public void testadditonalReturnTotalHours_List() {
        System.out.println("returnTotalHours");
        List<Task> tasks =new ArrayList<>();
        tasks.add(new Task(1, "Alice Brown", "Task 1", "Description 1", 10, "To Do"));
        tasks.add(new Task(2, "Bob White", "Task 2", "Description 2", 12, "Doing"));
        tasks.add(new Task(3, "Charlie Black", "Task 3", "Description 3", 55, "Done"));
        tasks.add(new Task(4, "Diana Grey", "Task 4", "Description 4", 11, "To Do"));
        tasks.add(new Task(5, "Eve Green", "Task 5", "Description 5", 1, "Doing"));       
        int expResult = 89;
        int result = Task.returnTotalHours(tasks);
        assertEquals(expResult, result);
       
    }
}
