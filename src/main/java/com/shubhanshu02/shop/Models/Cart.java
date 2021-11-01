package com.shubhanshu02.shop.Models;

public class Cart {
    public int id;
    public int total;
    public int userEmail;

    public Cart(int id, int total, int userEmail) {
        this.id = id;
        this.total = total;
        this.userEmail = userEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(int userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "Cart{" + "id=" + id + ", total=" + total + ", userEmail=" + userEmail + '}';
    }

}
