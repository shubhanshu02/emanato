package com.shubhanshu02.shop.Models;

public class CartItem {

    private int productId;
    private int productQuantity;
    private int cartId;

    public CartItem(int productId, int productQuantity, int cartId) {
        this.productId = productId;
        this.productQuantity = productQuantity;
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
        // TODO:SQL IMPLEMENTATION
        return 0;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Override
    public String toString() {
        return "CartItem{" + "productId=" + productId + ", productQuantity=" + productQuantity + ", cartId=" + cartId
                + '}';
    }

}
