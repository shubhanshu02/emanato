package com.shubhanshu02.shop.Controllers;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.shubhanshu02.shop.Models.Offer;
import com.shubhanshu02.shop.Models.Product;
import com.shubhanshu02.shop.Repository.OfferRepository;
import com.shubhanshu02.shop.Repository.ProductRepository;

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
public class OfferController {

    @Autowired
    OfferRepository offerRepository;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/offers")
    public String offerView(Model model) {
        List<Offer> offers = offerRepository.getAllOffers();
        List<Product> products = productRepository.listAll();
        Map<Integer, Object> attributes = new HashMap<Integer, Object>();
        for (Product product : products) {
            attributes.put(product.getId(), product);
        }
        model.addAttribute("offers", offers);
        model.addAttribute("offer", new Offer());
        model.addAttribute("products", products);
        model.addAttribute("attributes", attributes);
        return "offers";
    }

    @PostMapping("/offers")
    public String addOffer(@ModelAttribute("offer") Offer offer, BindingResult result, WebRequest request, Model model,
            RedirectAttributes attributes) {

        if (offerRepository.exists(offer.getOfferCode())) {
            return "redirect:/offer?error";
        }

        offerRepository.save(offer);
        return "redirect:/offers";
    }

    @RequestMapping(value = "/delete/offer", method = RequestMethod.POST)
    @ResponseBody
    public String deleteCategory(WebRequest request, Model model) {
        String offerCode = request.getParameter("offerCode");

        if (!offerRepository.exists(offerCode)) {
            return "NO";
        }
        offerRepository.delete(offerCode);
        return "YES";
    }

}
