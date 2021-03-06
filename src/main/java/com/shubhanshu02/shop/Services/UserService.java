package com.shubhanshu02.shop.Services;

import com.shubhanshu02.shop.Models.User;
import com.shubhanshu02.shop.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User registerNewUserAccount(String firstName, String middleName, String lastName, String email,
            String password, String role, String address) {
        try {
            User user = new User(firstName, middleName, lastName, email, password, role, address);
            userRepository.save(user);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("User Already Exists");
        }

        return null;
    }

    public User findUserbyEmail(String email) {
        try {
            return userRepository.findByEmail(email);
        } catch (Exception e) {
            return null;
        }
    }

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }
}
