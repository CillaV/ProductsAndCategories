package com.pv.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pv.productsandcategories.models.Category;
import com.pv.productsandcategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	List<Product> findAll();
	
	// reverse of each method from Category Repository
	// list of products for a category
	List<Product> findAllByCategories(Category category);
	
	// list of products not within a category
	List<Product> findByCategoriesNotContains(Category category);

}
