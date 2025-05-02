package com.Category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Category.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> 
{

}
