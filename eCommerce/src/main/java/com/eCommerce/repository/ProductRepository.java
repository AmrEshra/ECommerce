package com.eCommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eCommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
    @Query(value = "select p from Product p where p.categoryId = :P_CATEGORY_ID")
    Page<Product> findByCategoryId(@Param("P_CATEGORY_ID") Long categoryId, Pageable pageable);
}
