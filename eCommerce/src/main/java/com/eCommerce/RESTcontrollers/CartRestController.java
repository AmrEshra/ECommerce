package com.eCommerce.RESTcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eCommerce.entity.Cart;
import com.eCommerce.entity.CartDetails;
import com.eCommerce.exceptions.NotFoundException;
import com.eCommerce.services.CartService;

@RestController
@RequestMapping("/cart-api")
@CrossOrigin(origins = "*")
public class CartRestController {
	
	CartService cartService;

	@Autowired
	public CartRestController(CartService cartService) {
		this.cartService = cartService;
	}

	@GetMapping("/Carts")
	public List<CartDetails> getCartDetails() {
		return cartService.getCartDetails();
	}
	
	@PostMapping("/Carts")
	public Cart addToCart(@RequestBody Cart cart) {
		
		cartService.addToCart(cart);
		return cart;
	}
	
	@PostMapping("/Carts/updateCart")
	public Cart updateCart(@RequestParam Long productId, @RequestParam Integer newItemCount) {
		return cartService.updateCart(productId, newItemCount);
	}
	
	@DeleteMapping("/Carts/{id}")
	public String removeFromCart(@PathVariable Long id) {
		
		try {
			cartService.removeFromCart(id);
			return "Item deleted from Cart";
		}catch(NotFoundException e) {
			throw new NotFoundException("Not Data Found");
		}
	}

}
