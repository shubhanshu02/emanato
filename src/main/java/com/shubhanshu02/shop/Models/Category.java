package com.shubhanshu02.shop.Models;

public class Category {
    public int id;
    public String categoryName;
    public String supplierName;

    public Category(int id, String categoryName, String supplierName) {
        this.id = id;
        this.categoryName = categoryName;
        this.supplierName = supplierName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", categoryName='" + categoryName + '\'' + ", supplierName='" + supplierName
                + '\'' + '}';
    }
}
