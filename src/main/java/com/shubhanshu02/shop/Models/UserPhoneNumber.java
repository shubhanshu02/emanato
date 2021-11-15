package com.shubhanshu02.shop.Models;

public class UserPhoneNumber {

    private long phoneNumber;
    private String email;

    public UserPhoneNumber(long phoneNumber, String email) {
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public UserPhoneNumber() {
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
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
