package com.eCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eCommerce.entity.CartDetails;

public interface CartDetailsRepository extends JpaRepository<CartDetails, Long>{
	
}
