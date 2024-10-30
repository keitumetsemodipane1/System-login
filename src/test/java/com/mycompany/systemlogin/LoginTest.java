/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.systemlogin;

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
public class LoginTest {
   
    
   /**
     * Test of CheckUsername method, of class Login.
     */
    @Test
    public void testCheckUsername() {
        System.out.println("Username correctly formatted");
        String username = "kyl_1";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.CheckUsername(username);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testfailedUsername() {
        System.out.println("Username incorrectly formatted");
        String username = "kyle!!!!!!!";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.CheckUsername(username);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println(" Password meets Complexity requirements");
        String password = "Ch&&sec@ke99!";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testfailedPasswordComplexity() {
        System.out.println(" Password does not meet Complexity requirements");
        String password = "password";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of registerUser method, of class Login.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("User successfully registered");
        Login instance = new Login();
        instance.setFirstName("kyle");//Set the firstname
        instance.setlastName("fahima");//Set the lastname
        instance.setUserName("kyl_1");// Set the password
        instance.setPassWord("Ch&&sec@ke99!");//Set vail password
        String expResult = "Username and password successfully captured";
        String result = instance.registerUser();
        assertEquals(expResult, result);
        
    }
    @Test
    public void testFailedRegisterUser() {
        System.out.println("failed to register user");
        Login instance = new Login();
        instance.setFirstName("kyle");//Set the firstname
        instance.setlastName("fahima");//Set the lastname
        instance.setUserName("kyle!!!!!!!");//Set the username
        instance.setPassWord("password");//Set the password
        String expResult = "Username is not correctly formatted";
        String result = instance.registerUser();
        assertEquals(expResult, result);
        
    }
    
    

   

   
}