package com.pv.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pv.productsandcategories.models.Category;
import com.pv.productsandcategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	List<Category> findAll();
	
	// Retrieves a list of all categories for a particular product
	// finds a list of categories for a product
	List<Category> findAllByProducts(Product product);
	
	
	 // Retrieves a list of any categories a particular product does not belong to
	// finds a list of categories not within a product
	List<Category> findByProductsNotContains(Product product);
	// another use is NotIn

}
