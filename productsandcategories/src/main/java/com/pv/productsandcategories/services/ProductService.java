package com.pv.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pv.productsandcategories.models.Category;
import com.pv.productsandcategories.models.Product;
import com.pv.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
// create a product
	public Product createProd(Product c) {
		return this.productRepo.save(c);
	}
	
// show all products
	public List<Product> allProducts() {
		return this.productRepo.findAll();
	}
	
// show one product
	public Product showOneProduct(Long id) {
		return this.productRepo.findById(id).orElse(null);
	}
	
// show list of products NOT in a category		
	public List<Product> findProductNotInCategory(Category category) {
		return this.productRepo.findByCategoriesNotContains(category);
	}
	
// add category to product
	public void addCategory(Product product, Category category) {
		// retrieve existing list of categories for a product
		List<Category> currentCategories = product.getCategories();
		// append list
		currentCategories.add(category);
		// save list
		this.productRepo.save(product);
	}
	
}
