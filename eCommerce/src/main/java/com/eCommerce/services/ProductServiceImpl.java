package com.eCommerce.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Product> findByName(String name) {
		
		EntityManager entityManager = emf.createEntityManager();

		TypedQuery<Product> query = entityManager.createNamedQuery("product_findByName", Product.class);
        query.setParameter("P_NAME", "%" + name + "%");
        List<Product> list = query.getResultList();
        entityManager.close();
        return list;
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

}
