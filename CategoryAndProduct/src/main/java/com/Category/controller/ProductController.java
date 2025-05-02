package com.Category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Category.Entity.Product;
import com.Category.service.ProductService;

@RequestMapping("/api/products")
@RestController
public class ProductController 
{
	@Autowired
	private ProductService productService;
	
	// get the product all
	@GetMapping
	public ResponseEntity<Page<Product>> getAllProduct(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size )
	{
		 Page<Product> paginatedProducts = productService.getAllProducts(PageRequest.of(page, size));
		 return ResponseEntity.ok(paginatedProducts);
	}
	
	// get the product by id
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
	    return ResponseEntity.ok(productService.getProductById(id));
	}
	
	// create product
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product)
	{
		return new ResponseEntity<>(productService.createProduct(product),HttpStatus.CREATED);
	}
	
	// update the product by id
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product)
	{
		return ResponseEntity.ok(productService.updateProduct(id, product));
	}
	
	// delete the product by id 
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id)
	{
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
