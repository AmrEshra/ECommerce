package com.eCommerce.services;

import java.util.List;

import com.eCommerce.entity.ProductCategory;

public interface ProductCategoryService {
	
	public List<ProductCategory> findAll();
	public ProductCategory findById(Long id);
}
