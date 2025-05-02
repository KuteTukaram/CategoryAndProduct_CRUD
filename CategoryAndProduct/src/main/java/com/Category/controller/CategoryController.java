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

import com.Category.Entity.Category;
import com.Category.service.CategoryService;

@RequestMapping("/api/categories")
@RestController
public class CategoryController 
{
	
	private CategoryService categoryService;
	

    @Autowired
    public CategoryController(CategoryService categoryService) 
    {
     this.categoryService = categoryService;
    }
    
	// Get all category list
	@GetMapping
	public ResponseEntity<Page<Category>> getAllCategories( @RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue="10") int size)
	{
		return ResponseEntity.ok(categoryService.getAllCategories(PageRequest.of(page, size)));
	}
	
	// create category
	@PostMapping
	public ResponseEntity<Category> createCategory(@RequestBody Category category)
	{
		return new ResponseEntity<>(categoryService.createCategory(category), HttpStatus.CREATED);
	}
	
	// get the category by id
	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Long id)
	{
		return ResponseEntity.ok(categoryService.getCategoryById(id));
	}
	
	// update the category by id
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category)
	{
		return ResponseEntity.ok(categoryService.updateCategory(id, category));
	}
	
	// delete category by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable long id)
	{
		categoryService.deleteCategory(id);
		return ResponseEntity.noContent().build();
	}
}
