package com.example.onlinesportshopee.entities;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import com.example.onlinesportshopee.entities.AddressEntity;

@Entity
@Table(name = "Customer")
public class CustomerEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "gmail",unique=true)
	private String gmail;
	@Column(name = "password")
	private String password;
	@Column(name = "contactno")
	private String contactNo;
	@Column(name = "DateOfBirth")
	private LocalDate doB;

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
	
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public LocalDate getDoB() {
		return doB;
	}
	public void setDoB(LocalDate doB) {
		this.doB = doB;
	}
	
	@Override
	public String toString() {
		return "CustomerEntity [id=" + id + ", name=" + name + ", gmail=" + gmail + ", password=" + password
				+ ", contactNo=" + contactNo + ", doB=" + doB +  "]";
	}
	
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public CustomerEntity(Long id, String name, String gmail, String password, String contactNo, LocalDate doB) {
		super();
		this.id = id;
		this.name = name;
		this.gmail = gmail;
		this.password = password;
		this.contactNo = contactNo;
		this.doB = doB;
	}
	public CustomerEntity() {}

	/*
	 * {"id":5, "name":"Rama", "email":"rama@gmail.com", "contactNo":"9876543456",
	 * "doB":"2018-11-01", "address":[{ "street":"3rdmain", "area":"rrnagar",
	 * "city":"blore", "state":"karnataka", "pincode":"566001"}], "orders":[{
	 * "id":11, "amount":7777.82, "billingDate":"2021-11-01"}] }
	 */	
}
