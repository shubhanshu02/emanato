package com.shubhanshu02.shop.Models;

public class OrderItem {

    private int productId;
    private int productQuantity;
    private int productPrice;
    private int orderId;

    public OrderItem(int productId, int productQuantity, int productPrice, int orderId) {
        this.productId = productId;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "productId=" + productId + ", productQuantity=" + productQuantity + ", productPrice="
                + productPrice + ", orderId=" + orderId + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        OrderItem orderItem = (OrderItem) o;

        if (productId != orderItem.productId)
            return false;
        if (productQuantity != orderItem.productQuantity)
            return false;
        if (productPrice != orderItem.productPrice)
            return false;
        return orderId == orderItem.orderId;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + productQuantity;
        result = 31 * result + productPrice;
        result = 31 * result + orderId;
        return result;
    }

}
