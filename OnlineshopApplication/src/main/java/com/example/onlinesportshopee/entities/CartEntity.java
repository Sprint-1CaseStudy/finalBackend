package com.example.onlinesportshopee.entities;

import javax.persistence.*;

@Entity
@Table(name="Cart")
public class CartEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "ProductName")
	private String productName;
	@Column(name = "Quantity")
	private Integer quantity;
	@Column(name = "Price")
	private Double price;
	@Column(name="TotalBill")
	private Double total;
	private Long custId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "CartEntity [id=" + id + ", productName=" + productName + ", quantity=" + quantity + ", price=" + price
				+ ", total=" + total + ", custId=" + custId + "]";
	}
	public CartEntity(Long id, String productName, Integer quantity, Double price, Double total) {
		super();
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
	}
	
	public CartEntity() {}
	
	public CartEntity(String productName, Integer quantity, Double price, Double total, Long custId) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
		this.custId = custId;
	}
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}	
}

	
	