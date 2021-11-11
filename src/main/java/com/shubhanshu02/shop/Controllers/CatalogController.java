package com.shubhanshu02.shop.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CatalogController {

    @GetMapping("/catalog")
    public String catalog(Model model) {

        return "catalog";
    }
}