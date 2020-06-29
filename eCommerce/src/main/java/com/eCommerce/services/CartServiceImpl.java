package com.eCommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eCommerce.entity.Cart;
import com.eCommerce.entity.CartDetails;
import com.eCommerce.repository.CartDetailsRepository;
import com.eCommerce.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartDetailsRepository cartDetailsRepository;
	
    public CartServiceImpl(CartRepository cartRepository, CartDetailsRepository cartDetailsRepository) {
		this.cartRepository = cartRepository;
		this.cartDetailsRepository = cartDetailsRepository;
	}
    
	@Override
	public List<CartDetails> getCartDetails() {
		return cartDetailsRepository.findAll();
	}

	@Override
	public Cart addToCart(Cart cart) {
		
		Cart currentCart = getCartByProductId(cart.getProductId());
		if(currentCart == null) {
			return cartRepository.save(cart);
		}else {
			cart.setItemCount(currentCart.getItemCount() + cart.getItemCount());
			return cartRepository.save(cart);
		}
	}

	@Override
	public void removeFromCart(Long productId) {
		cartRepository.deleteById(productId);
	}

	@Override
	public Cart getCartByProductId(Long productId) {
		Optional<Cart> result = cartRepository.findById(productId);
		try {
			return result.get();
		} catch (RuntimeException e) {
			return null;
		}
	}

	

	@Override
	public Cart updateCart(Long productId, Integer newItemCount) {
		Cart currentCart = getCartByProductId(productId);
		if(currentCart != null) {
			currentCart.setItemCount(newItemCount);
			return cartRepository.save(currentCart);	
		}
		return null;
	}

}
