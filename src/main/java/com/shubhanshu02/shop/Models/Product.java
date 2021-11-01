package com.shubhanshu02.shop.Models;

public class Product {

    private int mrp;
    private String id;
    private String name;
    private String size;
    private int categoryId;
    private int quantityAvailable;
    private String details;

    public Product(int mrp, String id, String name, String size, int categoryId, int quantityAvailable,
            String details) {
        this.mrp = mrp;
        this.id = id;
        this.name = name;
        this.size = size;
        this.categoryId = categoryId;
        this.quantityAvailable = quantityAvailable;
        this.details = details;
    }

    public int getMrp() {
        return mrp;
    }

    public void setMrp(int mrp) {
        this.mrp = mrp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Product{" + "mrp=" + mrp + ", id='" + id + '\'' + ", name='" + name + '\'' + ", size='" + size + '\''
                + ", categoryId=" + categoryId + ", quantityAvailable=" + quantityAvailable + ", details='" + details
                + '\'' + '}';
    }

    public String toDisplayString() {
        return name + " " + size;
    }

}
