package com.shubhanshu02.shop.Controllers;

import com.shubhanshu02.shop.Models.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String register(Model model) {
        model.addAttribute("user", new User());
        /*
         * String email = "", password = ""; model.addAttribute("email", email);
         * model.addAttribute("password", password);
         */
        return "login";
    }

    @PostMapping("/login")
    public String register(@ModelAttribute("email") String user, @ModelAttribute("password") String password,
            BindingResult result, WebRequest request, Model model, RedirectAttributes attributes) {

        System.out.println(user);
        System.out.println(password);

        return "login";
    }
}
