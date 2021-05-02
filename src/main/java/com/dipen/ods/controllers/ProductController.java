package com.dipen.ods.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dipen.ods.entities.Product;
import com.dipen.ods.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/saveproduct")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@PostMapping("/saveproducts")
	public List<Product> saveProducts(@RequestBody List<Product> products){
		return productService.saveProducts(products);
	}

	@GetMapping("/getproducts")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	@GetMapping("/getproduct/{id}")
	public Product getProduct(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	@PutMapping("/updateproduct")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	@DeleteMapping("deleteproduct/{id}")
	public String deleteProduct(@PathVariable Long id) {
		return productService.deleteProductById(id);
	}
}

