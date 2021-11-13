package com.shubhanshu02.shop.Repository;

import java.util.List;

import com.shubhanshu02.shop.Models.CartItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class CartRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Boolean addToCart(CartItem cartItem) {
        String sql = "INSERT INTO cart(userEmail, productId, quantity) VALUES(?,?,?)";
        try {
            return jdbcTemplate.update(sql, cartItem.getUserEmail(), cartItem.getProductId(),
                    cartItem.getQuantity()) > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return updateCart(cartItem);
        }
    }

    public Boolean deleteFromCart(int productId, String userEmail) {
        String sql = "DELETE FROM cart WHERE productId = ? AND userEmail = ?";
        return jdbcTemplate.update(sql, productId, userEmail) > 0;
    }

    public Boolean updateCart(CartItem cartItem) {
        String sql = "UPDATE cart SET quantity = ? WHERE userEmail = ? AND productId = ?";
        try {
            System.out.println("EHRE: " +cartItem.getProductId());
            return jdbcTemplate.update(sql, cartItem.getQuantity(), cartItem.getUserEmail(),
                    cartItem.getProductId()) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public void deleteAllCartItems(String userEmail) {
        String sql = "DELETE FROM cart WHERE userEmail = ?";
        jdbcTemplate.update(sql, userEmail);
    }

    public Boolean updateQuantity(CartItem cartItem) {
        String sql = "UPDATE cart SET quantity = ? WHERE userEmail = ? AND productId = ?";
        try {
            return jdbcTemplate.update(sql, cartItem.getQuantity(), cartItem.getUserEmail(),
                    cartItem.getProductId()) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public List<CartItem> getCartItems(String userEmail) {
        String query = "SELECT * FROM cart WHERE userEmail = ?";

        return jdbcTemplate.query(query, (resultSet, i) -> {
            CartItem item = new CartItem(resultSet.getString("userEmail"), resultSet.getInt("productId"),
                    resultSet.getInt("quantity"));
            return item;
        }, userEmail);
    }

}
