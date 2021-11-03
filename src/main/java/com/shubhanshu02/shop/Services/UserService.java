package com.shubhanshu02.shop.Services;

import com.shubhanshu02.shop.Interfaces.Repository.UserRepositoryInterface;
import com.shubhanshu02.shop.Interfaces.Services.UserServiceInterface;
import com.shubhanshu02.shop.Models.User;
import com.shubhanshu02.shop.Repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface {

    @Override
    public User registerNewUserAccount(String firstName, String middleName, String lastName, String email,
            String password, String role, String address) {

        try {
            UserRepositoryInterface userRepository = new UserRepository();
            User user = new User(firstName, middleName, lastName, email, password, role, address);
            userRepository.save(user);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("User Already Exists");
        }

        return null;
    }
}
