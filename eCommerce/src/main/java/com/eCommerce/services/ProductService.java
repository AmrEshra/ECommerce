package com.eCommerce.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.eCommerce.entity.Product;

public interface ProductService {
	
	public List<Product> findAll();
	public long countAll();
	
	public Product findById(Long theId);
	public Page<Product> findByCategoryId(Long categoryId, Pageable pageable);
	public List<Product> findByName(String name);
	public void save(Product product);
	public void deleteById(Long theId);
}
