package com.shubhanshu02.shop.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.shubhanshu02.shop.Interfaces.Repository.UserRepositoryInterface;
import com.shubhanshu02.shop.Models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserRepository implements UserRepositoryInterface {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet res, int rowNum) throws SQLException {
            return new User(res.getString("firstName"), res.getString("middleName"), res.getString("lastName"),
                    res.getString("email"), res.getString("password"), res.getBoolean("isStaff"),
                    res.getString("address"));
        }
    };

    @Override
    public User findByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        return jdbcTemplate.queryForObject(query, userRowMapper, email);
    }

    @Override
    public void save(User user) {
        String query = "INSERT INTO users (firstName, middleName, lastName, email, password, isStaff, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, user.getFirstName(), user.getMiddleName(), user.getLastName(), user.getEmail(),
                user.getPassword(), user.checkIfStaff(), user.getAddress());
    }

}
