package com.Category.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Category.Entity.Category;
import com.Category.repository.CategoryRepository;

@Service
public class CategoryService
{
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Page<Category> getAllCategories(Pageable pageable)
	{
		return categoryRepository.findAll(pageable);
	}
	
	public Category getCategoryById(Long id)
	{
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		
		if(optionalCategory.isPresent())
		{
			return optionalCategory.get();
		}
		else
		{
			throw new RuntimeException("Category not found with id "+id);
		}
	}
	
	public Category createCategory(Category category)
	{
		return categoryRepository.save(category);
	}
	
	public Category updateCategory(Long id, Category categoryDetails)
	{
		Category category = getCategoryById(id);
		
		category.setName(categoryDetails.getName());
		
		return categoryRepository.save(category);
	}
	
	public void deleteCategory(Long id)
	{
		Category category = getCategoryById(id);
		categoryRepository.delete(category);
	}
}
