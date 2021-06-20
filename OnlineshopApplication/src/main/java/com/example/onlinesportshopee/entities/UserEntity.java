package com.example.onlinesportshopee.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "username")
	private String username;
	@Column(name = "gmail",unique=true)
	private String gmail;
	@Column(name = "password")
	private String password;
	
	public UserEntity() {
		super();
	}
	
	public UserEntity(Long id, String username, String gmail, String password) {
		super();
		this.id = id;
		this.username = username;
		this.gmail = gmail;
		this.password = password;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public UserEntity(String gmail, String password) {
		this.gmail = gmail;
		this.password = password;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long userid) {
		this.id = userid;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", username=" + username + ", gmail=" + gmail + ", password=" + password + "]";
	}
	
	

}
