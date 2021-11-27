package com.shubhanshu02.shop.Controllers;

import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.shubhanshu02.shop.FileUploadUtil;
import com.shubhanshu02.shop.Models.Category;
import com.shubhanshu02.shop.Models.Product;
import com.shubhanshu02.shop.Repository.CategoryRepository;
import com.shubhanshu02.shop.Repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CatalogController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/catalog")
    public String catalog(Model model) {
        List<Product> products = productRepository.listAll();
        model.addAttribute("products", products);
        return "catalog";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model, HttpServletRequest request) {
        if (!request.isUserInRole("ROLE_STAFF")) {
            return "error/403";
        }

        List<Category> categories = categoryRepository.findAll();
        if (categories.size() == 0) {
            return "catalog?empty";
        }

        model.addAttribute("categories", categories);
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/addproduct")
    public String addProductPOSTHandler(@ModelAttribute("product") Product product,
            @RequestParam("image") MultipartFile multipartFile, Model model) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        product.setProductImage(fileName);
        if (productRepository.getProductbyName(product.getProductName()) != null) {
            return "redirect:addProduct?error";
        }

        productRepository.save(product);
        String uploadDir = "product-photos/";
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return "redirect:addProduct?success";
    }

    @RequestMapping(value = "/delete/product", method = RequestMethod.POST)
    @ResponseBody
    public String deleteCategory(BindingResult result, WebRequest request, Model model, RedirectAttributes attributes) {
        String name = request.getParameter("name");
        Product product = productRepository.getProductbyName(name);
        if (product == null) {
            return "NO";
        }
        productRepository.delete(product);
        return "YES";
    }

}