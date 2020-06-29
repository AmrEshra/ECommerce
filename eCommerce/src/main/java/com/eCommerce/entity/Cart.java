package com.eCommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="CART")
public class Cart {

	@Id
	@Column(name="PRODUCT_ID")
	private Long productId;
	
	@Column(name="ITEM_COUNT")
	private Integer itemCount;

	public Cart() {
	}

	public Cart(Long productId, Integer itemCount) {
		super();
		this.productId = productId;
		this.itemCount = itemCount;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getItemCount() {
		return itemCount;
	}

	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}
	
}
