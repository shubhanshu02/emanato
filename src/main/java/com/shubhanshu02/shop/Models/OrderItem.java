package com.shubhanshu02.shop.Models;

public class OrderItem {

    private int orderId;
    private int productId;
    private int quantity;

    public OrderItem() {
    }

    public OrderItem(int orderId, int productId, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public OrderItem orderId(int orderId) {
        setOrderId(orderId);
        return this;
    }

    public OrderItem productId(int productId) {
        setProductId(productId);
        return this;
    }

    public OrderItem quantity(int quantity) {
        setQuantity(quantity);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderItem)) {
            return false;
        }
        OrderItem orderItem = (OrderItem) o;
        return orderId == orderItem.orderId && productId == orderItem.productId && quantity == orderItem.quantity;
    }

    @Override
    public String toString() {
        return "{" + " orderId='" + getOrderId() + "'" + ", productId='" + getProductId() + "'" + ", quantity='"
                + getQuantity() + "'" + "}";
    }

}
