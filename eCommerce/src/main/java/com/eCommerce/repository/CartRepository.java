package com.eCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eCommerce.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
	
}
