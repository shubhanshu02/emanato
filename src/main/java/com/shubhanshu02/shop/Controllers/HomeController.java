package com.shubhanshu02.shop.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {


	@GetMapping("/")
	public String home(Model model) {
				System.out.println("LINKINFDS");
		model.addAttribute("name", "asdas");
		return "index";
	}
}