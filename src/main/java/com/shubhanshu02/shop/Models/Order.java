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
    private Date date;
    private int total;
    private Status status;
    private int userEmail;
    private TransactionMode transactionMode;
    private String onlineTransactionID;

    public Order(int id, String customerName, Date date, int total, String status, int userEmail,
            String transactionMode) {
        this.id = id;
        this.customerName = customerName;
        this.date = date;
        this.total = total;
        this.status = Status.valueOf(status);
        this.userEmail = userEmail;
        this.transactionMode = TransactionMode.valueOf(transactionMode);

    }

    public Order(int id, String customerName, Date date, int total, String status, int userEmail,
            String transactionMode, String onlineTransactionID) {
        this.id = id;
        this.customerName = customerName;
        this.date = date;
        this.total = total;
        this.status = Status.valueOf(status);
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
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
