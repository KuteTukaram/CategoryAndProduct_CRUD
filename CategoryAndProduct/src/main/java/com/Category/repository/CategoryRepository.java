package com.Category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Category.Entity.Category;

public interface CategoryRepository extends JpaRepository <Category, Long>
{

}
