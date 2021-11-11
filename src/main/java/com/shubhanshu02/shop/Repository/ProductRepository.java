package com.shubhanshu02.shop.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.shubhanshu02.shop.Models.Product;

import org.springframework.beans.factory.annotation.Autowired;
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
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, productRowMapper);

    }

    public Product findByName(String name) {
        String sql = "SELECT * FROM product WHERE productName = ?";
        return jdbcTemplate.queryForObject(sql, productRowMapper, name);
    }

    public void save(Product product) {
        String query = "INSERT INTO product (id, productName, ProductImage, size, mrp, categoryId, quantityAvailable, details) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, product.getId(), product.getProductName(), product.getProductImage(),
                product.getSize(), product.getMrp(), product.getCategoryId(), product.getQuantityAvailable(),
                product.getDetails());
    }

    public List<Product> filterByCategory(String categoryName) {
        String sql = "SELECT * FROM product WHERE categoryId = (SELECT id FROM category WHERE categoryName = ?)";
        return jdbcTemplate.query(sql, productRowMapper, categoryName);
    }
}
