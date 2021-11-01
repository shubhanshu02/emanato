package com.shubhanshu02.shop.Interfaces;

import com.shubhanshu02.shop.Models.User;

public interface UserRepository {
    public User findByEmail(String email);

    public void save(User user);
}
