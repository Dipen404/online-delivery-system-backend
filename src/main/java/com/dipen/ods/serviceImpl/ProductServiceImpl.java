package com.dipen.ods.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dipen.ods.entities.Product;
import com.dipen.ods.repositories.ProductRepository;
import com.dipen.ods.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> saveProducts(List<Product> products) {
		return productRepository.saveAll(products);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public String deleteProductById(Long id) {
		productRepository.deleteById(id);
		return "Product deleted of id:"+id;
	}

	@Override
	public Product updateProduct(Product product) {
		Product existingProduct =productRepository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		return productRepository.save(existingProduct);
	}
}
