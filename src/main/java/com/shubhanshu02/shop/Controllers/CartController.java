package com.shubhanshu02.shop.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shubhanshu02.shop.Models.CartItem;
import com.shubhanshu02.shop.Models.Product;
import com.shubhanshu02.shop.Repository.CartRepository;
import com.shubhanshu02.shop.Repository.ProductRepository;
import com.shubhanshu02.shop.Services.SecurityService;
import com.shubhanshu02.shop.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@Controller
public class CartController {
    @Autowired
    SecurityService securityService;

    @Autowired
    UserService userService;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;

    @Secured({ "ROLE_USER", "ROLE_STAFF" })
    @GetMapping("/cart")
    public String cart(WebRequest request, Model model) {

        String userEmail = securityService.findLoggedInUsername();
        if (userEmail == null) {
            return "redirect:/login";
        }
        List<CartItem> cartItems = cartRepository.getCartItems(userEmail);
        int orderTotal = 0;
        Map<Object, Object> cartProduct = new HashMap<Object, Object>();

        for (CartItem cartItem : cartItems) {
            Product product = productRepository.getProductById(cartItem.getProductId());
            cartProduct.put(cartItem, product);
            orderTotal += product.getMrp() * cartItem.getQuantity();
        }

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("cartProduct", cartProduct);
        model.addAttribute("orderTotal", orderTotal + 35 + 15);
        System.out.println(cartItems.size());
        return "cart";
    }

    @PostMapping("/add/cartItem")
    public String addCartItem(WebRequest request) {
        String userEmail = securityService.findLoggedInUsername();
        if (userEmail == null) {
            return "redirect:/login";
        }

        for (String nam : request.getParameterMap().keySet()) {
            System.out.println(nam + " at  " + request.getParameter(nam));

        }
        System.out.println("YEs " + request.getParameter("id") + " qty = " + request.getParameter("quantity"));

        int productId = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        CartItem cartItem = new CartItem(userEmail, productId, quantity);
        if (!cartRepository.addToCart(cartItem)) {
            return "redirect:/product/" + productId + "?error";
        }

        return "redirect:/cart";
    }

    @PostMapping("/update/cartItem")
    @ResponseBody
    public String updateCartItem(WebRequest request) {
        String userEmail = securityService.findLoggedInUsername();
        if (userEmail == null) {
            return "false";
        }

        int productId = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        CartItem cartItem = new CartItem(userEmail, productId, quantity);
        if (!cartRepository.updateQuantity(cartItem)) {
            return "false";
        }

        return "true";
    }

    @DeleteMapping("/delete/cartItem")
    @ResponseBody
    public String deleteCartItem(WebRequest request) {
        String userEmail = securityService.findLoggedInUsername();
        if (userEmail == null) {
            return "false";
        }

        int productId = Integer.parseInt(request.getParameter("id"));
        if (!cartRepository.deleteFromCart(productId, userEmail)) {
            return "false";
        }

        return "true";
    }

}
