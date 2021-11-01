package com.shubhanshu02.shop.Models;

import java.sql.Date;

public class Offer {
    public String offerCode;
    public Date startDate;
    public Date endDate;
    public int discount;
    public int productId;
    public String freebies;

    public Offer(String offerCode, Date startDate, Date endDate, int discount, int productId, String freebies) {
        this.offerCode = offerCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discount = discount;
        this.productId = productId;
        this.freebies = freebies;
    }

    public String getOfferCode() {
        return offerCode;
    }

    public void setOfferCode(String offerCode) {
        this.offerCode = offerCode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getFreebies() {
        return freebies;
    }

    public void setFreebies(String freebies) {
        this.freebies = freebies;
    }

    @Override
    public String toString() {
        return "Offer{" + "offerCode='" + offerCode + '\'' + ", startDate=" + startDate + ", endDate=" + endDate
                + ", discount=" + discount + ", productId=" + productId + ", freebies='" + freebies + '\'' + '}';
    }

}
