package com.eCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eCommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
		
}
