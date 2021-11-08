package com.shubhanshu02.shop.Controllers;

import com.shubhanshu02.shop.Models.User;
import com.shubhanshu02.shop.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {
    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String register(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @GetMapping("/registerError")
    public String registerError(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("emailError", true);
        return "register";
    }

    @PostMapping({ "/register" })
    public String register(@ModelAttribute("user") User user, BindingResult result, WebRequest request, Model model,
            RedirectAttributes attributes) {
        if (userService.findUserbyEmail(user.getEmail()) != null) {
            return "redirect:/registerError";
        }
        User usr = new User("ds", "fds", "fds", "df@df.com", "fds", "fgd", "fds");
        userService.save(usr);
        System.out.println(user);
        return "redirect:index";
    }

}
