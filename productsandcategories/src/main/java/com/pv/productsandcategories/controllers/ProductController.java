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
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
// show product form
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product, Model model) {
		model.addAttribute("products", this.productService.allProducts());
		return "newProduct.jsp";
	}

// create new product
	@PostMapping("/products/new")
	public String createProduct(@ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		}
		else {
			this.productService.createProd(product);
			return "redirect:/";
		}
	}

// show all products
	@GetMapping("/products")
	public String allProducts(Model model) {
		model.addAttribute("products", this.productService.allProducts());
		return "allProducts.jsp";
	}
	
// show one product
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		// binding result removed since no need to validate
		Product product = this.productService.showOneProduct(id);
		model.addAttribute("product", product);
//		model.addAttribute("product", this.productService.showOneProduct(id)
	
//		model.addAttribute("notInProduct", this.productService.findProductNotInCategory(product));
		model.addAttribute("notProduct", this.categoryService.findCategoryNotInProduct(product));
		return "showProduct.jsp";
	}

// add new category to product
	@PostMapping("/products/{id}/addcategory")
	public String addCategoryToProduct(@PathVariable("id") Long id, @RequestParam("category") Long catId) {
		// need to pull info for both product and category
		Product currentProduct = this.productService.showOneProduct(id);
		Category newCategory = this.categoryService.showOneCategory(catId);
		// utilize service method to save appended list
		this.productService.addCategory(currentProduct, newCategory);
		// redirect since post method
		return "redirect:/products/{id}";
	}
	
	
}
