package com.eCommerce.services;

import java.util.List;

import com.eCommerce.entity.Product;

public interface ProductService {
	
	public List<Product> findAll();
	public long countAll();
	
	public Product findById(Long theId);
	public List<Product> findByName(String name);
	public void save(Product product);
	public void deleteById(Long theId);
}
