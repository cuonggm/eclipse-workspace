package com.cuong.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Xin chao cac ban");
		model.addAttribute("tagline", "Day la tagline");
		
		return "welcome";
	}
	
}
