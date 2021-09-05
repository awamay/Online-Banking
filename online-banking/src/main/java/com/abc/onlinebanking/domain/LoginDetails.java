package com.abc.onlinebanking.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "LOGIN")

public class LoginDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String loginId;
	
	@Column(name = "PASSWORD")
	private String password;

	//One-to-one to customer
	@JsonIgnore
	@OneToOne
	private CustomerDetails customer;

	//constructor


	public LoginDetails() {

	}

	public LoginDetails(String loginId, String password) {
		super();
		this.loginId = loginId;
		this.password = password;
	}
	
	//getter and setter methods
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
