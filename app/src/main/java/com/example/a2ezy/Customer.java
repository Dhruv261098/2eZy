package com.example.a2ezy;

public class Customer {

    private String Name;
    private String Email;
    private String Password;
    private String ComfirmPassword;


    public Customer() {
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getComfirmPassword() {
        return ComfirmPassword;
    }

    public void setComfirmPassword(String comfirmPassword) {
        ComfirmPassword = comfirmPassword;
    }


}
