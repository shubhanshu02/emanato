package com.shubhanshu02.shop.Models;

import java.sql.Date;

public class Order {

    private int id;
    private Date orderDate;
    private int total;
    private String orderStatus;
    private String userEmail;
    private String deliveryAddress;
    private String contact;

    public Order() {
    }

    public Order(int id, Date orderDate, int total, String orderStatus, String userEmail, String deliveryAddress,
            String contact) {
        this.id = id;
        this.orderDate = orderDate;
        this.total = total;
        this.orderStatus = orderStatus;
        this.userEmail = userEmail;
        this.deliveryAddress = deliveryAddress;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
