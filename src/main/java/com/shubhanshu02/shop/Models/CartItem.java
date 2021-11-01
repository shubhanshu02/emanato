package com.shubhanshu02.shop.Models;

public class CartItem {

    private int productId;
    private int productQuantity;
    private int productPrice;
    private int cartId;

    public CartItem(int productId, int productQuantity, int productPrice, int cartId) {
        this.productId = productId;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.cartId = cartId;
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

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int itemTotal() {
        return productQuantity * productPrice;
    }

    @Override
    public String toString() {
        return "CartItem{" + "productId=" + productId + ", productQuantity=" + productQuantity + ", productPrice="
                + productPrice + ", cartId=" + cartId + '}';
    }

}
