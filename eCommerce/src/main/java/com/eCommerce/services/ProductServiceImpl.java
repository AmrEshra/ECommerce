package com.eCommerce.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eCommerce.entity.Product;
import com.eCommerce.exceptions.NotFoundException;
import com.eCommerce.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

    @Autowired
    EntityManagerFactory emf;

    public ProductServiceImpl(ProductRepository ProductRepository) {
		this.productRepository = ProductRepository;
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	@Override
	public Page<Product> findByName(String name, Pageable pageable) {
		return productRepository.findByName(name == null || name.equals("null") ? "%%" : "%" + name +"%", pageable);
	}
	
	@Override
	public Product findById(Long id) {
		Optional<Product> result = productRepository.findById(id);
		
		try {
			return result.get();
		} catch(NotFoundException e) {
			throw new NotFoundException("Did not find Product id - " + id);
		}
	}

	@Override
	public void save(Product employee) {
		productRepository.save(employee);
	}

	@Override
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public long countAll() {
		return productRepository.count();
	}

	@Override
	public Page<Product> findByCategoryId(Long categoryId, Pageable pageable) {
		return productRepository.findByCategoryId(categoryId, pageable);
	}

}
