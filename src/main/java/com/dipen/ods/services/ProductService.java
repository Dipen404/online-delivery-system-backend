package com.dipen.ods.services;

import java.util.List;

import com.dipen.ods.entities.Product;

public interface ProductService {
	
	Product saveProduct(Product product);
	List<Product> saveProducts(List<Product> products);
	List<Product> getAllProducts();
	Product getProductById(Long id);
	String deleteProductById(Long id);
	Product updateProduct(Product product);

}
