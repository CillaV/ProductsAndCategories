package com.pv.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pv.productsandcategories.models.Category;
import com.pv.productsandcategories.models.Product;
import com.pv.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
// create a category
	public Category createCat(Category c) {
		return this.categoryRepo.save(c);
	}
	
// show all categories
	public List<Category> allCategories() {
		return this.categoryRepo.findAll();
	}
	
// show one category
	public Category showOneCategory(Long id) {
		return this.categoryRepo.findById(id).orElse(null);
	}
	
	
// show list of products in a category
	public List<Category> currentCat(Product c) {
		return this.categoryRepo.findAllByProducts(c);
	}

	
// show list of categories NOT in a product	
	public List<Category> findCategoryNotInProduct(Product product) {
		return this.categoryRepo.findByProductsNotContains(product);
	}

// add product to category
	public void addProduct(Product product, Category category) {
		// retrieve existing list of products for a category
		List<Product> currentProducts = category.getProducts();
		// append list
		currentProducts.add(product);
		// save list
		this.categoryRepo.save(category);
	}

	
}
