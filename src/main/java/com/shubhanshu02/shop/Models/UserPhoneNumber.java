package com.shubhanshu02.shop.Models;

public class UserPhoneNumber {
    private String phoneNumber;
    private String email;

    public UserPhoneNumber(String phoneNumber, String email) {
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserPhoneNumber{" + "phoneNumber='" + phoneNumber + '\'' + ", email='" + email + '\'' + '}';
    }

}
