package com.shubhanshu02.shop.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.shubhanshu02.shop.Models.User;
import com.shubhanshu02.shop.Models.UserPhoneNumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet res, int rowNum) throws SQLException {
            return new User(res.getString("firstName"), res.getString("middleName"), res.getString("lastName"),
                    res.getString("email"), res.getString("password"), res.getString("role"), res.getString("address"));
        }
    };

    public User findByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        return jdbcTemplate.queryForObject(query, userRowMapper, email);
    }

    public void save(User user) {
        System.err.println(this.jdbcTemplate);
        String query = "INSERT INTO users (firstName, middleName, lastName, email, password, role, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
        System.out.println(user.toString());
        if (user.getRole() == null) {
            user.setrole("ROLE_USER");
        }
        jdbcTemplate.update(query, user.getFirstName(), user.getMiddleName(), user.getLastName(), user.getEmail(),
                user.getPassword(), user.getRole(), user.getAddress());
    }

    public void update(User user) {
        String query = "UPDATE users SET firstName = ?, middleName = ?, lastName = ?, address = ? WHERE email = ?";
        jdbcTemplate.update(query, user.getFirstName(), user.getMiddleName(), user.getLastName(), user.getAddress(),
                user.getEmail());
    }

    public List<UserPhoneNumber> getPhones(String userEmail) {
        String query = "SELECT * FROM UserPhoneNumber WHERE email = ?";
        return jdbcTemplate.query(query, new RowMapper<UserPhoneNumber>() {
            @Override
            public UserPhoneNumber mapRow(ResultSet res, int rowNum) throws SQLException {
                return new UserPhoneNumber(res.getLong("phoneNumber"), res.getString("email"));
            }
        }, userEmail);
    }

    public Boolean addPhone(String userEmail, long phoneNumber) {
        String query = "INSERT INTO UserPhoneNumber (phoneNumber, email) VALUES (?, ?)";
        jdbcTemplate.update(query, phoneNumber, userEmail);
        return true;
    }

}
