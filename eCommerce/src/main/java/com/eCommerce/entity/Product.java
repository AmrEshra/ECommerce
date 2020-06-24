package com.eCommerce.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity

@NamedQueries({
	@NamedQuery(name = "product_findByName", 
			query = "SELECT p FROM Product p WHERE lower(p.name) like lower(:P_NAME)"),
})

@Table(name="PRODUCT")
public class Product {

	@Id
	@SequenceGenerator(name = "PRODUCT_SEQ", sequenceName = "PRODUCT_SEQ", allocationSize = 1)  
	@GeneratedValue(generator = "PRODUCT_SEQ", strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private Long id;
	
	@Column(name="SKU")
	private String sku;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="UNIT_PRICE")
	private Double unitPrice;
	
	@Column(name="IMAGE_URL")
	private String imageUrl;
	
	@Column(name="ACTIVE")
	private Integer active;
	
	@Column(name="UNITS_IN_STOCK")
	private Integer unitsInStock;
	
	@Column(name="DATE_CREATED")
	@CreationTimestamp
	private Date createDate;
	
	@Column(name="LAST_UPDATED")
	@UpdateTimestamp
	private Date updateDate;
	
	@Column(name="CATEGORY_ID")
	private Long categoryId;
	
	public Product() {
	}

	public Product(String sku, String name, String description, Double unitPrice, String imageUrl, Integer active,
			Integer unitsInStock, Date createDate, Date updateDate, Long categoryId) {
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.imageUrl = imageUrl;
		this.active = active;
		this.unitsInStock = unitsInStock;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.categoryId = categoryId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Integer getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(Integer unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	
	
}
