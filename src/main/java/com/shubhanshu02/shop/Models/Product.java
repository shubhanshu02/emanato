package com.shubhanshu02.shop.Models;

import java.beans.Transient;

public class Product {

    private int mrp;
    private int id;
    private String productName;
    private String productImage;
    private String size;
    private int categoryId;
    private int quantityAvailable;
    private String details;

    public Product(int mrp, int id, String productName, String ProductImage, String size, int categoryId,
            int quantityAvailable, String details) {
        this.mrp = mrp;
        this.id = id;
        this.productName = productName;
        this.productImage = ProductImage;
        this.size = size;
        this.categoryId = categoryId;
        this.quantityAvailable = quantityAvailable;
        this.details = details;
    }

    public Product() {
    }

    public int getMrp() {
        return mrp;
    }

    public void setMrp(int mrp) {
        this.mrp = mrp;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return this.productImage;
    }

    public void setProductImage(String ProductImage) {
        this.productImage = ProductImage;
    }

    @Transient
    public String getPhotosImagePath() {
        if (productImage == null)
            return null;
        return "/product-photos/" + id + "/" + productImage;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Product{" + "mrp=" + mrp + ", id='" + id + '\'' + ", productName='" + productName + '\'' + ", size='"
                + size + '\'' + ", categoryId=" + categoryId + ", quantityAvailable=" + quantityAvailable
                + ", details='" + details + '\'' + '}';
    }

    public String toDisplayString() {
        return productName + " " + size;
    }

}
