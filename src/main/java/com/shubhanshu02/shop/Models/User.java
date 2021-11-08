package com.shubhanshu02.shop.Models;

import org.springframework.data.annotation.Id;

public class User {
    private String firstName;
    private String middleName;
    private String lastName;
    @Id
    private String email;
    private String password;
    private String role;
    private String address;

    public User(String firstName, String middleName, String lastName, String email, String password, String role,
            String address) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getRole() {
        return role;
    }

    public void setrole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" + "firstName='" + firstName + '\'' + ", middleName='" + middleName + '\'' + ", lastName='"
                + lastName + '\'' + ", email='" + email + '\'' + ", password='" + password + '\'' + ", role=" + role
                + ", address='" + address + '\'' + '}';
    }

    public User() {
        super();
    }
}
