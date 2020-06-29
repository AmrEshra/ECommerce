package com.eCommerce.services;

import java.util.List;

import com.eCommerce.entity.Cart;
import com.eCommerce.entity.CartDetails;

public interface CartService {
	
	public List<CartDetails> getCartDetails();
	public Cart getCartByProductId(Long productId);
	public Cart addToCart(Cart cart);
	public void removeFromCart(Long id);
	public Cart updateCart(Long productId, Integer newItemCount);
}
