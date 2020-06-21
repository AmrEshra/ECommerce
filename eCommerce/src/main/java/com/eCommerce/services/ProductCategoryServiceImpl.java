package com.eCommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.eCommerce.entity.ProductCategory;
import com.eCommerce.repository.ProductCategoryRepository;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryRepository ProductCategoryRepository;

    public ProductCategoryServiceImpl(ProductCategoryRepository ProductCategoryRepository) {
		this.ProductCategoryRepository = ProductCategoryRepository;
	}

	@Override
	public List<ProductCategory> findAll() {
		return ProductCategoryRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}

}
