package com.shubhanshu02.shop.Repository;

import com.shubhanshu02.shop.Interfaces.Repository.UserRepository;
import com.shubhanshu02.shop.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            User user = new User();
            user.setFirstName(rs.getString("firstName"));
            user.setMiddleName(rs.getString("middleName"));
            user.setLastName(rs.getString("lastName"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setIsStaff(rs.getBoolean("isStaff"));
            user.setAddress(rs.getString("address"));
            return user;
        }
    };

    @Override
    public User findByEmail(String email) {
        String sqlQuery = "select * from users where email=" + email;
        User user = jdbcTemplate.queryForObject(sqlQuery, userRowMapper);
        return user;
    }

    @Override
    public void save(User user) {
        System.out.println(user);
        String sqlQuery = "insert into users(firstName,middleName,lastName,email,password,isStaff,address) values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sqlQuery, user.getFirstName(), user.getMiddleName(), user.getLastName(), user.getEmail(),
                user.getPassword(), user.checkIfStaff(), user.getAddress());
    }

}