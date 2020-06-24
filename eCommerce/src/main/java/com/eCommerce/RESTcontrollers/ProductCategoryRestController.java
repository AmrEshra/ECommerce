package com.eCommerce.RESTcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eCommerce.entity.Product;
import com.eCommerce.entity.ProductCategory;
import com.eCommerce.exceptions.NotFoundException;
import com.eCommerce.services.ProductCategoryService;

@RestController
@RequestMapping("/productCategory-api")
@CrossOrigin(origins = "*")
public class ProductCategoryRestController {
	
	@Autowired
	ProductCategoryService productCategoryService;
	
	public ProductCategoryRestController(ProductCategoryService ProductCategoryService) {
		this.productCategoryService = ProductCategoryService;
	}

	@GetMapping("/ProductCategories")
	public List<ProductCategory> getAllProductCategorys() {
		
		return productCategoryService.findAll();
	}
	
	@GetMapping("/ProductCategories/{id}")
	public ProductCategory getProductCategoryById(@PathVariable Long id) {
		
		try {
			return productCategoryService.findById(id);
		}catch(NotFoundException e) {
			throw new NotFoundException("Not Data Found");
		}
	}

}
