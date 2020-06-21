package com.eCommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_CATEGORY")
public class ProductCategory {

	@Id
	@SequenceGenerator(name = "PRODUCT_CATEGORY_SEQ", sequenceName = "PRODUCT_CATEGORY_SEQ", allocationSize = 1)  
	@GeneratedValue(generator = "PRODUCT_CATEGORY_SEQ", strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;

	@Override
	public String toString() {
		return "Product Category [id=" + id + ", Name=" + name + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
