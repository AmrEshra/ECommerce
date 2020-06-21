package com.eCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.eCommerce.entity.ProductCategory;

@CrossOrigin
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{
	
}
