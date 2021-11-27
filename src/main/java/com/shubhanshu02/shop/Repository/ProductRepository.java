package com.shubhanshu02.shop.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.shubhanshu02.shop.Models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private RowMapper<Product> productRowMapper = new RowMapper<Product>() {
        @Override
        public Product mapRow(ResultSet res, int rowNum) throws SQLException {
            return new Product(res.getInt("MRP"), res.getInt("id"), res.getString("productName"),
                    res.getString("productImage"), res.getString("size"), res.getInt("categoryId"),
                    res.getInt("quantityAvailable"), res.getString("details"));

        }
    };

    public List<Product> listAll() {
        String sql = "SELECT * FROM Product where quantityAvailable > 0";
        return jdbcTemplate.query(sql, productRowMapper);

    }

    public Product getProductbyName(String name) {
        String sql = "SELECT * FROM Product WHERE productName = ?";

        try {
            return jdbcTemplate.queryForObject(sql, productRowMapper, name);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Product getProductById(int productId) {
        String query = "SELECT * FROM Product WHERE id = ?";
        return jdbcTemplate.queryForObject(query, productRowMapper, productId);
    }

    public void save(Product product) {
        String query = "INSERT INTO Product (id, productName, ProductImage, size, mrp, categoryId, quantityAvailable, details) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, product.getId(), product.getProductName(), product.getProductImage(),
                product.getSize(), product.getMrp(), product.getCategoryId(), product.getQuantityAvailable(),
                product.getDetails());
    }

    public Boolean delete(Product product) {
        String query = "DELETE FROM Product WHERE productName = ?";
        return jdbcTemplate.update(query, product.getProductName()) > 0;
    }

    public List<Product> filterByCategory(String categoryName) {
        String sql = "SELECT * FROM Product WHERE categoryId = (SELECT id FROM category WHERE categoryName = ?)";
        return jdbcTemplate.query(sql, productRowMapper, categoryName);
    }

    public Boolean reduceQuantity(int productId, int quantity) {
        String query = "UPDATE Product SET quantityAvailable = quantityAvailable - ? WHERE id = ?";
        return jdbcTemplate.update(query, quantity, productId) > 0;
    }
}
