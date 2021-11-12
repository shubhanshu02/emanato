package com.shubhanshu02.shop.Models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class CartItem {

    private String userEmail;
    private int productId;
    private int quantity;

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CartItem() {
    }

    public CartItem(String userEmail, int productId, int quantity) {
        this.userEmail = userEmail;
        this.productId = productId;
        this.quantity = quantity;
    }

}
