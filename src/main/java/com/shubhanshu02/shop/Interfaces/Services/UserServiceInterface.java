package com.shubhanshu02.shop.Interfaces.Services;

import com.shubhanshu02.shop.Models.User;

public interface UserServiceInterface {
    User registerNewUserAccount(String firstName, String middleName, String lastName, String email, String password,
            String role, String address);

}
