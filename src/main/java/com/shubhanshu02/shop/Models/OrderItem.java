package com.shubhanshu02.shop.Models;

public class OrderItem {

    private String userEmail;
    private int productId;
    private int quantity;

    public OrderItem() {
    }

    public OrderItem(String userEmail, int productId, int quantity) {
        this.userEmail = userEmail;
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
