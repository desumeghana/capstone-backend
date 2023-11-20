package com.chubb.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chubb.capstone.database.ProductRespository;
import com.chubb.capstone.model.Product;

@Service
public class ProductService {
	@Autowired
	ProductRespository productRepository;
	//get data
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public Product getProductById(String ProductId) {
		return productRepository.findById(ProductId).get();
	}
	
	public List<Product> getProductByCategory(String category){
		return productRepository.findByCategory(category);
	}
	
	public List<Product> getProductsByTitle(String q){
		return productRepository.getProductByTitleRegEx(q);
	}
	
	// create data
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	//update data
	public Product updateProduct(Product product) {
		Product curr=productRepository.findById(product.getProductId()).get();
		curr.setTitle(product.getTitle());
		curr.setImages(product.getImages());
		curr.setCategory(product.getCategory());
		curr.setPrice(product.getPrice());
		curr.setDescription(product.getDescription());
		curr.setRating(product.getRating());
		curr.setDiscount(product.getDiscount());
		curr.setAvailable(product.getAvailable());
		curr.setQuantity(product.getQuantity());
		return productRepository.save(curr);
	}
	
	//delete data
	public void deleteProductById(String ProductId) {
		productRepository.deleteById(ProductId);
	}
}
