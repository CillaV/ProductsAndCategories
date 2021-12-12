package com.pv.productsandcategories.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
// main page
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
}
