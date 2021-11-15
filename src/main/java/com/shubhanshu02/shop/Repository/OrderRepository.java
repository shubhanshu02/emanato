package com.shubhanshu02.shop.Repository;

import java.util.List;

import com.shubhanshu02.shop.Models.CartItem;
import com.shubhanshu02.shop.Models.Order;
import com.shubhanshu02.shop.Models.OrderItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class OrderRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Boolean addOrder(Order order) {
        String sql = "INSERT INTO orders (id, orderDate, total, orderStatus, userEmail, deliveryAddress, contact) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            return jdbcTemplate.update(sql, order.getId(), order.getOrderDate(), order.getTotal(),
                    order.getOrderStatus(), order.getUserEmail(), order.getDeliveryAddress(), order.getContact()) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public Order getDatabaseOrder(Order order) {
        String sql = "SELECT * from orders where orderDate = ? and total = ? and userEmail = ? and deliveryAddress = ? and contact = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            return new Order(rs.getInt("id"), rs.getDate("orderDate"), rs.getInt("total"), rs.getString("orderStatus"),
                    rs.getString("userEmail"), rs.getString("deliveryAddress"), rs.getString("contact"));
        }, order.getOrderDate(), order.getTotal(), order.getUserEmail(), order.getDeliveryAddress(),
                order.getContact());
    }

    public Boolean updateOrderStatus(String orderStatus, int orderId) {
        String sql = "UPDATE orders SET orderStatus = ? WHERE id = ?";
        return jdbcTemplate.update(sql, orderStatus, orderId) == 1;
    }

    public Boolean deleteOrder(String id) {
        String sql = "DELETE FROM orders WHERE id = ?";
        return jdbcTemplate.update(sql, id) == 1;
    }

    public List<Order> findAllOrders() {
        String sql = "SELECT * FROM orders ORDER BY orderDate DESC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Order order = new Order(rs.getInt("id"), rs.getDate("orderDate"), rs.getInt("total"),
                    rs.getString("orderStatus"), rs.getString("userEmail"), rs.getString("deliveryAddress"),
                    rs.getString("contact"));
            return order;
        });
    }

    public List<Order> getAllOrders(String userEmail) {
        String sql = "SELECT * FROM orders WHERE userEmail = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Order order = new Order(rs.getInt("id"), rs.getDate("orderDate"), rs.getInt("total"),
                    rs.getString("orderStatus"), rs.getString("userEmail"), rs.getString("deliveryAddress"),
                    rs.getString("contact"));
            return order;
        }, userEmail);
    }

    public Order getOrder(int id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                Order order = new Order(rs.getInt("id"), rs.getDate("orderDate"), rs.getInt("total"),
                        rs.getString("orderStatus"), rs.getString("userEmail"), rs.getString("deliveryAddress"),
                        rs.getString("contact"));
                return order;
            }, id);
        } catch (Exception e) {
            return null;
        }
    }

    public List<OrderItem> getOrderItems(int id) {
        String sql = "SELECT * FROM OrderItem WHERE orderId = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            OrderItem orderItem = new OrderItem(rs.getInt("orderId"), rs.getInt("productId"), rs.getInt("quantity"));
            return orderItem;
        }, id);
    }

    public Boolean addOrderItem(int orderId, CartItem cartItem) {
        String sql = "INSERT INTO OrderItem (orderId, productId, quantity) VALUES (?, ?, ?)";
        try {
            return jdbcTemplate.update(sql, orderId, cartItem.getProductId(), cartItem.getQuantity()) == 1;

        } catch (Exception e) {
            return false;
        }
    }

}
