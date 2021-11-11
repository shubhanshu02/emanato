package com.shubhanshu02.shop.Models;

import java.sql.Date;

public class Order {
    private enum Status {
        PENDING, PROCESSING, COMPLETED
    }

    private enum TransactionMode {
        COD, ONLINE
    }

    private int id;
    private String customerName;
    private Date orderDate;
    private int total;
    private Status orderStatus;
    private int userEmail;
    private TransactionMode transactionMode;
    private String onlineTransactionID;

    public Order(int id, String customerName, Date orderDate, int total, String orderStatus, int userEmail,
            String transactionMode) {
        this.id = id;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.total = total;
        this.orderStatus = Status.valueOf(orderStatus);
        this.userEmail = userEmail;
        this.transactionMode = TransactionMode.valueOf(transactionMode);

    }

    public Order(int id, String customerName, Date orderDate, int total, String orderStatus, int userEmail,
            String transactionMode, String onlineTransactionID) {
        this.id = id;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.total = total;
        this.orderStatus = Status.valueOf(orderStatus);
        this.userEmail = userEmail;
        this.transactionMode = TransactionMode.valueOf(transactionMode);
        this.onlineTransactionID = onlineTransactionID;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getDate() {
        return this.orderDate;
    }

    public void setDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Status getStatus() {
        return this.orderStatus;
    }

    public void setStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(int userEmail) {
        this.userEmail = userEmail;
    }

    public TransactionMode getTransactionMode() {
        return this.transactionMode;
    }

    public void setTransactionMode(TransactionMode transactionMode) {
        this.transactionMode = transactionMode;
    }

    public String getOnlineTransactionID() {
        return this.onlineTransactionID;
    }

    public void setOnlineTransactionID(String onlineTransactionID) {
        this.onlineTransactionID = onlineTransactionID;
    }

}
