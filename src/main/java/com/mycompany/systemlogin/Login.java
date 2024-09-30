/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemlogin;
import java.util.regex.Pattern;

/**
 *
 * @author RC_Student_lab
 */
class Login {
    
     //intance variables that stores users details
    private String firstName;
    private String lastName;
    private String username;
    private String password ;
    
    
     //Setter for te firstname
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    //Setter fr the lastname
    public void setlastName(String lastName){
        this.lastName=lastName;
    }
    //Setter for the username
    public void setUserName(String username){
        this.username=username;
    }
    //Setter for the password
    public void setPassWord(String password){
        this.password=password;
    }
    
    
     // Getter methods bring values of private instance variables
    //Getter for the firstname
    public String getFirstName() {
        return this.firstName;
    }
     //Getter for the lastname
    public String getLastName() {
        return this.lastName;
    }

    
    
    //Method to check the username is correctly formatted
    public boolean CheckUsername(String username){
    // temp variable for checking 
    boolean Found = false;
    
    //Checks the username has an underscore
    if(username.contains("_") && username.length() >= 5){
    //  assign to true 
    Found = true;
    //message that ouputs true
    System.out.println("Username successfully captured");
    }else{
        
    //assign to false
    Found = false;
    //message that outputs false
    System.out.println("Username is not correctly formatted !: Please ensure your username contains an underscore and is no more than 5 characters in length");
    }
    return Found;
    
    }
    
    //Method to check password complexity
    public boolean checkPasswordComplexity(String password){
    
     //pattern regex
        Pattern user_num= Pattern .compile("[0123456789]");//Checks for digits
        Pattern user_specials = Pattern.compile("[~!@#$%^&*()_=-]");   //Checks for special  characters
        Pattern user_uppercase=Pattern.compile("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]");//Checks for uppercase letters
       
        //temp variables
        boolean Found = false;
        //checks password meets the required complexity
        if(user_num.matcher(password).find() && user_specials.matcher(password).find() && user_uppercase.matcher(password).find() ){
                    
          //message that outputs to true
          Found = true;
            System.out.println("Password succesfully captured");
            //return to true
            
        }else{    
            Found = false;
            //message that outputs to false
           System.out.println ("Password is not captured ;please ensure that the password is at least 8 characters long,"
                   +" contain a capital letter, a number, and a special character.");  
           
        } 
        return Found;
    }
    
    //Method to register the user
        public  String registerUser(){  
                   
        // Check username is correctly ormatted
    if (!CheckUsername(this.username)) {  
        return "Username is not correctly formatted";  
    }
    // Check password is correctl formatted
    if (!checkPasswordComplexity(this.password)) {  
        return "Password is not correctly formatted"; 
    }  
    return  "Username and password  correctly formatted the user has successfully logged in";
}

     // Method that verifies login details
    public boolean loginUser(String enteredUsername, String enteredPassword)   {
        return enteredUsername.equals(this.username) && enteredPassword.equals(this.password);
    }
  
   
       //Method returns the login status message
    public String returnLoginStatus(boolean loginUser){
   
    if(loginUser){
        return "Welcome " + getFirstName() + " " + getLastName() + ", great to see you.";
    }else{
        return "Username or password incorrect,please try again";
    }
    
    }   
    
    
   
    
    
}
