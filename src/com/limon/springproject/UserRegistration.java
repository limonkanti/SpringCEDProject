
package com.limon.springproject;


public class UserRegistration 
{
    
    String name;
    String email;
    String password;
    int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRegistration(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserRegistration(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UserRegistration() {
    }

    public UserRegistration(int userId,String name,String email) {
        this.name = name;
        this.email = email;
        this.userId = userId;
    }
    
    
}
