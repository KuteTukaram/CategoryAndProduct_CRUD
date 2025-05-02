package com.Category.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Category.Entity.Category;
import com.Category.Entity.Product;
import com.Category.repository.ProductRepository;

@Service
public class ProductService 
{
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	public Page<Product> getAllProducts(Pageable pageable)
	{
		return productRepository.findAll(pageable);
	}
	
	public Product getProductById(Long id)
	{
		Optional<Product> optionalProduct = productRepository.findById(id);
		
		if(optionalProduct.isPresent())
		{
			return  optionalProduct.get();
		}
		else
		{
			throw new RuntimeException("Product not found with id "+ id);
		}
		
	}
	
	public Product createProduct(Product product)
	{
		Long categoryId = product.getCategory().getId();
        Category category = categoryService.getCategoryById(categoryId);
        product.setCategory(category);
        return productRepository.save(product);
	}
	
	public Product updateProduct(Long id, Product productDetails)
	{
		Product product = getProductById(id);
		
		product.setName(productDetails.getName());
		product.setPrice(productDetails.getPrice());
		
		Long categoryId = productDetails.getCategory().getId();
	    Category category = categoryService.getCategoryById(categoryId);
	    product.setCategory(category);

	    return productRepository.save(product);
	}
	
	public void deleteProduct(Long id)
	{
		Product product = getProductById(id);
		
		productRepository.delete(product);
	}
}
