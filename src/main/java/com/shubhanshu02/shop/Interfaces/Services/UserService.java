package com.shubhanshu02.shop.Interfaces.Services;

import com.shubhanshu02.shop.Models.User;

public interface UserService {
    public void save(User user);

    User findByUsername(String username);
}
