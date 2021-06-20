package com.example.onlinesportshopee.entities;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "amount")
	private Double amount;
	@Column(name = "ProductName")
	private String productName;
	@Column(name = "billingDate")
	private String billingDate;
    @Column(name = "paymentMethod")
	private String paymentMethod;
	private Long custId;
	
	public OrderEntity(Long id, Double amount, String productName, String billingDate, String paymentMethod, Long custId) {
		super();
		this.id = id;
		this.amount = amount;
		this.productName = productName;
		this.billingDate = billingDate;
		this.paymentMethod = paymentMethod;
		this.custId = custId;
	}
	
	public OrderEntity(Double amount, String billingDate, String paymentMethod, String productName, Long custId) {
		super();
		this.amount = amount;
		this.billingDate = billingDate;
		this.paymentMethod = paymentMethod;
		this.productName = productName;
		this.custId = custId;
	}

	public OrderEntity() {
		super();
	}
	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(String billingDate) {
		this.billingDate = billingDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", amount=" + amount + ", productName=" + productName + ", billingDate="
				+ billingDate + ", paymentMethod=" + paymentMethod  + ", custId=" + custId
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}