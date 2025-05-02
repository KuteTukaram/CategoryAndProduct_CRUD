package com.Category.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="products")
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	
	private double price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id",nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "products"})
	private Category category;
	
	public Product()
	{
		
	}
	
	public Product(String name, double price,Category category)
	{
		this.name = name;
		this.price = price;
		this.category = category;
		
	}
}
