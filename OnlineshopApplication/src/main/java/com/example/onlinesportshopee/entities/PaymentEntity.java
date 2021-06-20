package com.example.onlinesportshopee.entities;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class PaymentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "type")
	private String type;
	@Column(name = "status")
	private String status;
	@OneToMany(cascade=CascadeType.ALL)
	private List<CardEntity> cardEntity;

	public PaymentEntity() {
		super();
	}
	
	public PaymentEntity(Long id, String type, String status, List<CardEntity> cardEntity) {
		super();
		this.id=id;
		this.type = type;
		this.status = status;
		this.cardEntity = cardEntity;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public List<CardEntity> getCardEntity() {
		return cardEntity;
	}

	public void setCardEntity(List<CardEntity> cardEntity) {
		this.cardEntity = cardEntity;
	}

	@Override
	public String toString() {
		return "PaymentEntity [paymentId=" + id + ", type=" + type + ", status=" + status + ", cardEntity=" + cardEntity
				+ "]";
	}

	

	

}
