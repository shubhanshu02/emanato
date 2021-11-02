package com.shubhanshu02.shop.Interfaces.Repository;

import com.shubhanshu02.shop.Models.User;

public interface UserRepositoryInterface {
    public User findByEmail(String email);

    public void save(User user);
}
