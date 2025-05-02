package com.Category.Entity;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
@Entity
@Table(name="categories")
public class Category 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany (mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval= true)
	@JsonIgnoreProperties("category")
	private List<Product> products = new ArrayList<>();
	
	public Category()
	{
		
	}
	
	public Category(String name)
	{
		this.name = name;
	}
}
