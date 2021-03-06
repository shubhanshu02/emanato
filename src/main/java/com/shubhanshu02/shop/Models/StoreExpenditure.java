package com.shubhanshu02.shop.Models;

import java.sql.Date;

public class StoreExpenditure {
    public int transactionId;
    public Date transactionDate;
    public int amount;
    public String userEmail;
    public String summary;

    public StoreExpenditure(int transactionId, Date date, int amount, String userEmail, String summary) {
        this.transactionId = transactionId;
        this.transactionDate = date;
        this.amount = amount;
        this.userEmail = userEmail;
        this.summary = summary;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDate() {
        return transactionDate;
    }

    public void setDate(Date date) {
        this.transactionDate = date;

    }
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getuserEmail() {
        return userEmail;
    }

    public void setuserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "StoreExpenditure{" + "transactionId=" + transactionId + ", date=" + transactionDate + ", amount=" + amount
                + ", userEmail=" + userEmail + ", summary='" + summary + '\'' + '}';
    }

}
