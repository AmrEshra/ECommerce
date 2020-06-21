package com.eCommerce.RESTcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping("/Products/name/{name}")
	public List<Product> getProductBytName(@PathVariable String name) {

		return ProductService.findByName(name);
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
