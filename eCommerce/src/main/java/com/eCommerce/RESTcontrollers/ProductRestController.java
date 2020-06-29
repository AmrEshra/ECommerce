package com.eCommerce.RESTcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eCommerce.entity.Product;
import com.eCommerce.exceptions.NotFoundException;
import com.eCommerce.services.ProductService;

@RestController
@RequestMapping("/product-api")
@CrossOrigin(origins = "*")
public class ProductRestController {
	
	
	ProductService ProductService;

	@Autowired
	public ProductRestController(ProductService ProductService) {
		this.ProductService = ProductService;
	}

	@GetMapping("/Products")
	public List<Product> getAllProducts() {
		
		return ProductService.findAll();
	}
	
	@GetMapping("/Products/{id}")
	public Product getProductById(@PathVariable Long id) {
		
		try {
			return ProductService.findById(id);
		}catch(NotFoundException e) {
			throw new NotFoundException("Not Data Found");
		}
	}
	
	@GetMapping("/Products/category")
	public Page<Product> getProductByCategoryId(@RequestParam Long categoryId, @PageableDefault(page = 0, size = 50) Pageable pageable) {
		
		try {
			return ProductService.findByCategoryId(categoryId, pageable);
		}catch(NotFoundException e) {
			throw new NotFoundException("Not Data Found");
		}
	}
	
	@GetMapping("/Products/name")
	public Page<Product> getProductBytName(@RequestParam String name, @PageableDefault(page = 0, size = 50) Pageable pageable) {

		return ProductService.findByName(name, pageable);
	}
	
	@GetMapping("/countProducts")
	public long getProductCount() {

		return ProductService.countAll();
	}
	
	@PostMapping("/Products")
	public Product addProduct(@RequestBody Product Product) {
		
		ProductService.save(Product);
		return Product;
	}
	
	@PutMapping("/Products")
	public Product updateProduct(@RequestBody Product Product) {
		
		ProductService.save(Product);
		return Product;
	}
	
	@DeleteMapping("/Products/{id}")
	public String deleteProduct(@PathVariable Long id) {
		
		try {
			ProductService.deleteById(id);
			return "Product deleted";
		}catch(NotFoundException e) {
			throw new NotFoundException("Not Data Found");
			
		}
	}

}
