package com.shubhanshu02.shop.Controllers;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shubhanshu02.shop.Models.CartItem;
import com.shubhanshu02.shop.Models.Order;
import com.shubhanshu02.shop.Models.OrderItem;
import com.shubhanshu02.shop.Models.Product;
import com.shubhanshu02.shop.Repository.CartRepository;
import com.shubhanshu02.shop.Repository.OrderRepository;
import com.shubhanshu02.shop.Repository.ProductRepository;
import com.shubhanshu02.shop.Services.SecurityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@Controller
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    SecurityService securityService;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/orders")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String ordersView(Model model) {
        List<Order> orders = orderRepository.findAllOrders();

        model.addAttribute("orders", orders);
        return "allOrders";
    }

    @GetMapping("/order/{orderId}")
    public String getOrder(@PathVariable(value = "orderId") int orderId, Model model) {
        Order order = orderRepository.getOrder(orderId);
        if (order == null) {
            return "redirect:/404";
        }
        List<OrderItem> orderItems = orderRepository.getOrderItems(order.getId());
        Map<Object, Object> products = new HashMap<Object, Object>();
        for (OrderItem orderItem : orderItems) {
            products.put(orderItem, productRepository.getProductById(orderItem.getProductId()));
        }
        model.addAttribute("order", order);
        model.addAttribute("orderItems", orderItems);
        model.addAttribute("products", products);
        return "order";
    }

    @PostMapping("/add/order")
    @ResponseBody
    public String createOrder(WebRequest request) {
        String userEmail = securityService.findLoggedInUsername();
        if (userEmail == null) {
            return "no";
        }

        try {
            String mobile = request.getParameter("mobile");
            String address = request.getParameter("address");
            List<CartItem> cartItems = cartRepository.getCartItems(userEmail);
            Date date = new Date(Calendar.getInstance().getTime().getTime());
            int total = 35 + 15;

            for (CartItem cartItem : cartItems) {
                Product product = productRepository.getProductById(cartItem.getProductId());
                total += product.getMrp() * cartItem.getQuantity();
            }

            Order order = new Order(0, date, total, "Confirmed", userEmail, address, mobile);
            orderRepository.addOrder(order);
            order = orderRepository.getDatabaseOrder(order);
            for (CartItem cartItem : cartItems) {
                orderRepository.addOrderItem(order.getId(), cartItem);
                productRepository.reduceQuantity(cartItem.getProductId(), cartItem.getQuantity());
            }
            cartRepository.deleteAllCartItems(userEmail);
            return "/order/" + order.getId() + "/?success";
        } catch (Exception e) {
            return "no";
        }
    }

    @PostMapping("/update/order")
    @ResponseBody
    public String updateOrderStatus(WebRequest request) {
        String userEmail = securityService.findLoggedInUsername();
        if (userEmail == null) {
            return "no";
        }

        try {
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            String status = request.getParameter("status");
            if (!orderRepository.updateOrderStatus(status, orderId)) {
                return "no";
            }
            return "yes";
        } catch (Exception e) {
            return "no";
        }
    }
}
