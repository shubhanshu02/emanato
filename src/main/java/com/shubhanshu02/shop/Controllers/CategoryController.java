package com.shubhanshu02.shop.Controllers;

import org.springframework.stereotype.Controller;

import java.util.List;

import com.shubhanshu02.shop.Models.Category;
import com.shubhanshu02.shop.Repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public String categoriesView(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("category", new Category());
        return "categories";
    }

    @PostMapping("/categories")
    public String addCategory(@ModelAttribute("category") Category category, BindingResult result, WebRequest request,
            Model model, RedirectAttributes attributes) {

        if (categoryRepository.exists(category)) {
            return "redirect:categories?error";
        }

        categoryRepository.save(category);
        return "redirect:categories";
    }

    @RequestMapping(value = "/delete/categories", method = RequestMethod.POST)
    @ResponseBody
    public String deleteCategory(@ModelAttribute("category") Category category, BindingResult result,
            WebRequest request, Model model, RedirectAttributes attributes) {
        String categoryName = request.getParameter("categoryName");
        String supplierName = request.getParameter("supplierName");
        Category cat = new Category();
        cat.setCategoryName(categoryName);
        cat.setSupplierName(supplierName);

        if (!categoryRepository.exists(category)) {
            return "NO";
        }
        categoryRepository.delete(category);
        return "YES";
    }

}
