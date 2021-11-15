package com.shubhanshu02.shop.Controllers;

import java.util.List;

import com.shubhanshu02.shop.Models.Offer;
import com.shubhanshu02.shop.Models.Category;
import com.shubhanshu02.shop.Models.Product;
import com.shubhanshu02.shop.Repository.OfferRepository;
import com.shubhanshu02.shop.Repository.CategoryRepository;
import com.shubhanshu02.shop.Repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @Autowired
    OfferRepository offerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/product/{productId}")
    public String getOrder(@PathVariable(value = "productId") int productId, Model model) {
        Product product = productRepository.getProductById(productId);
        if (product == null) {
            return "redirect:/404";
        }
        List<Offer> offers = offerRepository.getOfferByProductId(productId);
        Category category = categoryRepository.findbyId(product.getCategoryId());
        model.addAttribute("offers", offers);
        model.addAttribute("product", product);
        model.addAttribute("category", category);
        return "product";
    }

}
