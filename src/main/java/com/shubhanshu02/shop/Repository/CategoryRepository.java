package com.shubhanshu02.shop.Repository;

import java.util.List;

import com.shubhanshu02.shop.Models.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class CategoryRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void save(Category category) {
        String query = "INSERT INTO category (id, categoryName, supplierName) VALUES (NULL, ?, ?)";
        jdbcTemplate.update(query, category.getCategoryName(), category.getSupplierName());
    }

    public List<Category> findAll() {
        String query = "SELECT * FROM category";
        return jdbcTemplate.query(query, (resultSet, i) -> {
            Category category = new Category(resultSet.getInt("Id"), resultSet.getString("categoryName"),
                    resultSet.getString("supplierName"));
            return category;
        });
    }

    public Category findbyId(int id) {
        String query = "SELECT * FROM category where id = ?";
        return jdbcTemplate.queryForObject(query, (resultSet, i) -> {
            Category category = new Category(resultSet.getInt("Id"), resultSet.getString("categoryName"),
                    resultSet.getString("supplierName"));
            return category;
        }, id);
    }

    public Boolean delete(Category category) {
        String query = "DELETE FROM category WHERE categoryName = ? and supplierName = ?";
        return jdbcTemplate.update(query, category.getCategoryName(), category.getSupplierName()) > 0;
    }

    public Boolean exists(Category category) {
        String query = "SELECT * FROM category WHERE categoryName = ? and supplierName = ?";
        return jdbcTemplate.query(query, (resultSet, i) -> {
            Category category1 = new Category(resultSet.getInt("Id"), resultSet.getString("categoryName"),
                    resultSet.getString("supplierName"));
            return category1;
        }, category.getCategoryName(), category.getSupplierName()).size() > 0;
    }
}
