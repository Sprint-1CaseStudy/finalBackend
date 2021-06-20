package com.example.onlinesportshopee.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="cardentity")
public class CardEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "cardHolderName")
	private String cardHolderName;
	@Column(name = "cardName")
	private String cardName;
	@Column(name = "cardNumber")
	private String cardNumber;
	@Column(name = "expiryDate")
	private LocalDate expiryDate;
	@Column(name = "bankName")
	private String bankName;
	private Long custId;
	
	public CardEntity() {
		super();
	}
	
	public CardEntity(Long id, String cardHolderName, String cardName, String cardNumber, LocalDate expiryDate,
			String bankName, Long custId) {
		super();
		this.id = id;
		this.cardHolderName = cardHolderName;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.bankName = bankName;
		this.custId = custId;
	}



	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {

		this.expiryDate = expiryDate;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
		
	}
	@Override
	public String toString() {
		return "CardEntity [id=" + id + ", cardHolderName=" + cardHolderName + ", cardName=" + cardName
				+ ", cardNumber=" + cardNumber + ", expiryDate=" + expiryDate + ", bankName=" + bankName + ", custId="
				+ custId + "]";
	}
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}

}