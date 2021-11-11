package com.shubhanshu02.shop.Repository;

import java.util.List;

import com.shubhanshu02.shop.Models.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class CategoryRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void save(Category category) {
        String query = "INSERT INTO category (categoryName, supplierName) VALUES (?, ?)";
        jdbcTemplate.update(query, category.getCategoryName(), category.getSupplierName());
    }

    public List<Category> findAll() {
        String query = "SELECT * FROM category";
        return jdbcTemplate.query(query, (resultSet, i) -> {
            Category category = new Category(resultSet.getInt("categoryId"), resultSet.getString("categoryName"),
                    resultSet.getString("supplierName"));
            return category;
        });
    }

}
