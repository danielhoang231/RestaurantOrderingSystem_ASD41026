package com.uts.restaurant.model;

import java.io.Serializable;

public class User implements Serializable {
    int id;
    String fname;
    String surname;
    String email;
    String phoneNo;
    String password;
    
    public User(int id, String fname, String surname, String email, String phoneNo, String password) {
        this.id = id;
        this.fname = fname;
        this.surname = surname;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
    }

    public User(int id, String fname, String surname, String email, String phoneNo, Boolean isActive) {
        this.fname = fname;
        this.surname = surname;
        this.email = email;
        this.phoneNo = phoneNo;
    }
    
    public User(String fname, String surname, String email, String phoneNo, Boolean isActive) {
        this.fname = fname;
        this.surname = surname;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public User(String fname, String surname, String email, String phoneNo) {
        this.fname = fname;
        this.surname = surname;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public User(String email) {
        this.fname = email;
        this.surname = "";
        this.email = email;
        this.phoneNo = "";
        this.password = "";
    }

    public int getID() {
        return id;
    }

    public String getEmail() {
        return email;
    }
    
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        this.password = password;
    }
}