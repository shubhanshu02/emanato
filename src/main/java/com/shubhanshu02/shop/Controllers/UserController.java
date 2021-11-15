package com.shubhanshu02.shop.Controllers;

import java.util.List;

import com.shubhanshu02.shop.Models.Order;
import com.shubhanshu02.shop.Models.User;
import com.shubhanshu02.shop.Models.UserPhoneNumber;
import com.shubhanshu02.shop.Repository.CartRepository;
import com.shubhanshu02.shop.Repository.OrderRepository;
import com.shubhanshu02.shop.Repository.ProductRepository;
import com.shubhanshu02.shop.Repository.UserRepository;
import com.shubhanshu02.shop.Services.SecurityService;
import com.shubhanshu02.shop.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    SecurityService securityService;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/account")
    public String getProfile(Model model) {
        String userEmail = securityService.findLoggedInUsername();
        if (userEmail == null) {
            return "redirect:/login";
        }

        User user = userService.findUserbyEmail(userEmail);
        List<Order> orders = orderRepository.getAllOrders(userEmail);
        List<UserPhoneNumber> userPhoneNumbers = userRepository.getPhones(userEmail);
        Boolean hasObject = orders.size() > 0;
        UserPhoneNumber phone = new UserPhoneNumber();

        model.addAttribute("user", user);
        model.addAttribute("phone", phone);
        model.addAttribute("orders", orders);
        model.addAttribute("hasObject", hasObject);
        model.addAttribute("userPhoneNumbers", userPhoneNumbers);
        return "profile";
    }

    @PostMapping({ "/update" })
    public String register(@ModelAttribute("user") User user, Model model) {
        userService.update(user);
        return "redirect:/profile";

    }

    @PostMapping({ "/add/phone" })
    public String addPhone(@ModelAttribute("phone") long phone, Model model) {
        String userEmail = securityService.findLoggedInUsername();
        if (userEmail == null) {
            return "redirect:/login";
        }
        try {
            userRepository.addPhone(userEmail, phone);
        }
        catch (Exception e) {
            System.out.println("Error Adding the Phone Number");
        }
        return "redirect:/account";
    }
}
