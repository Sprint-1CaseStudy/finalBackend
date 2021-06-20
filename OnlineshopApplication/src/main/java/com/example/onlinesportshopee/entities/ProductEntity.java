package com.example.onlinesportshopee.entities;

import java.time.LocalDate;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_category")
	private String category;
	@Column(name = "product_description")
	private String description;
	@Column(name = "product_brand")
	private String brand;
	@Column(name = "product_colour")
	private String colour;
	@Column(name = "product_size")
	private String size;
	@Column(name = "product_mrp")
	private Double mrp;
	@Column(name = "product_discount")
	private Double priceAfterDiscount;
	@Column(name = "in_stock")
	private String inStock;
	@Column(name = "expected_delivery")
	private LocalDate expectedDelivery;
	
	public ProductEntity() {
		
	}
	
	public ProductEntity(Long id, String productName, String category, String description, String brand, String colour, String size, 
			Double mrp, Double priceAfterDiscount, String inStock, LocalDate expectedDelivery) {
		super();
		this.id=id;
		this.productName = productName;
		this.category = category;
		this.description = description;
		this.brand = brand;
		this.colour = colour;
		this.size = size;
		this.mrp = mrp;
		this.priceAfterDiscount = priceAfterDiscount;
		this.inStock = inStock;
		this.expectedDelivery = expectedDelivery;
	}


	

	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getColour() {
		return colour;
	}


	public void setColour(String colour) {
		this.colour = colour;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public Double getMrp() {
		return mrp;
	}


	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}


	public Double getPriceAfterDiscount() {
		return priceAfterDiscount;
	}


	public void setPriceAfterDiscount(Double priceAfterDiscount) {
		this.priceAfterDiscount = priceAfterDiscount;
	}


	public String getInStock() {
		return inStock;
	}


	public void setInStock(String inStock) {
		this.inStock = inStock;
	}


	public LocalDate getExpectedDelivery() {
		return expectedDelivery;
	}


	public void setExpectedDelivery(LocalDate expectedDelivery) {
		this.expectedDelivery = expectedDelivery;
	}


	

	@Override
	public String toString() {
		return "ProductEntity [productId=" + id + ", productName=" + productName + ", category=" + category
				+ ", description=" + description + ", brand=" + brand + ", colour=" + colour + ", size=" + size
				+ ", mrp=" + mrp + ", priceAfterDiscount=" + priceAfterDiscount + ", inStock=" + inStock
				+ ", expectedDelivery=" + expectedDelivery + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
