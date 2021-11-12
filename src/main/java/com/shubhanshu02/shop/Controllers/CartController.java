package com.shubhanshu02.shop.Controllers;

import java.util.List;

import com.shubhanshu02.shop.Models.CartItem;
import com.shubhanshu02.shop.Repository.CartRepository;
import com.shubhanshu02.shop.Services.SecurityService;
import com.shubhanshu02.shop.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class CartController {
    @Autowired
    SecurityService securityService;

    @Autowired
    UserService userService;
    @Autowired
    CartRepository cartRepository;

    @Secured({ "ROLE_USER", "ROLE_STAFF" })
    @GetMapping("/cart")
    public String cart(WebRequest request, Model model) {

        String userEmail = securityService.findLoggedInUsername();
        if (userEmail == null) {
            return "redirect:/login";
        }
        List<CartItem> cartItems = cartRepository.getCartItems(userEmail);
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @PostMapping("/add/cartItem")
    public String addCartItem(WebRequest request) {
        String userEmail = securityService.findLoggedInUsername();
        if (userEmail == null) {
            return "redirect:/login";
        }

        int productId = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        CartItem cartItem = new CartItem(userEmail, productId, quantity);
        if (!cartRepository.addToCart(cartItem)) {
            return "redirect:/product/" + productId + "?error";
        }

        return "redirect:/cart";
    }

}
