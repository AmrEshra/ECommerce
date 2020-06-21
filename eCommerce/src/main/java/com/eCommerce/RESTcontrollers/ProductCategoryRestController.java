package com.eCommerce.RESTcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eCommerce.entity.ProductCategory;
import com.eCommerce.services.ProductCategoryService;

@RestController
@RequestMapping("/productCategory-api")
@CrossOrigin(origins = "*")
public class ProductCategoryRestController {
	
	@Autowired
	ProductCategoryService ProductCategoryService;
	
	public ProductCategoryRestController(ProductCategoryService ProductCategoryService) {
		this.ProductCategoryService = ProductCategoryService;
	}

	@GetMapping("/ProductCategories")
	public List<ProductCategory> getAllProductCategorys() {
		
		return ProductCategoryService.findAll();
	}

}
