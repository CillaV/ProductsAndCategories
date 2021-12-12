package com.pv.productsandcategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pv.productsandcategories.models.Category;
import com.pv.productsandcategories.models.Product;
import com.pv.productsandcategories.services.CategoryService;
import com.pv.productsandcategories.services.ProductService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	
// show category form
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category, Model model) {
		model.addAttribute("categories", this.categoryService.allCategories());
		return "newCategory.jsp";
	}

// create new category
	@PostMapping("/categories/new")
	public String createCategory(@ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		}
		else {
			this.categoryService.createCat(category);
			return "redirect:/";
		}
	}

// show all categories
	@GetMapping("/categories")
	public String allCategories(Model model) {
		model.addAttribute("categories", this.categoryService.allCategories());
		return "allCategories.jsp";
	}

// show one category
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		// need to instantiate??? category to be able to list Not in list
		Category category = this.categoryService.showOneCategory(id);
		model.addAttribute("category", category);
		model.addAttribute("notCategory", this.productService.findProductNotInCategory(category));
		return "showCategory.jsp";
	}
	
// add new product to category
	@PostMapping("/categories/{id}/addproduct")
	public String addProductToCategory(@PathVariable("id") Long id, @RequestParam("product") Long prodId) {
		Category currentCategory = this.categoryService.showOneCategory(id);
		Product newProduct = this.productService.showOneProduct(prodId);
		this.categoryService.addProduct(newProduct, currentCategory);
		return "redirect:/categories/{id}";
	}
	
	
}
