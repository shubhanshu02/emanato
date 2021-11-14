package com.shubhanshu02.shop.Controllers;

import java.util.List;

import com.shubhanshu02.shop.Models.Product;
import com.shubhanshu02.shop.Repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Autowired
	ProductRepository productRepository;

	@GetMapping("/")
	public String home(Model model) {
		List<Product> products = productRepository.listAll();
		products = products.subList(0, Math.min(4, products.size()));

		model.addAttribute("products", products);
		return "index";
	}
}