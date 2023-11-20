package com.chubb.capstone.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.chubb.capstone.model.Product;
import com.chubb.capstone.service.ProductService;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping()
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/{productId}")
	public Product getProductById(@PathVariable String productId) {
		return productService.getProductById(productId);
	}
	
	@GetMapping("/category/{category}")
	public List<Product> getProductByCategory(@PathVariable String category) {
		return productService.getProductByCategory(category);
	}
	
	@GetMapping("/search")
	public List<Product> getProductsByTitle(@RequestParam String q){
		return productService.getProductsByTitle(q); 
	}
	
	@PostMapping("/create")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/{productId}")
	public void deleteProductById(@PathVariable String productId) {
		productService.deleteProductById(productId);
	}
	
	
}
