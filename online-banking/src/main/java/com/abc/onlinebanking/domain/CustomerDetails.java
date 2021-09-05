package com.abc.onlinebanking.domain;
import java.time.*;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity(name = "PERSONS")
@Table(name = "PERSONS")

public class CustomerDetails {
 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CUSTOMER_ID")
  private String customerId;
  
  @Column(name = "NAME")
  private String name;
  
  @Column(name = "DATE_OF_BIRTH")
  private LocalDate dateOfBirth;
  
  @Column(name = "ADDRESS")
  private String address;
  
  @Column(name = "CITY")
  private String city;
  
  @Column(name = "PHONE")
  private long phone;
  
  //Login object
  @OneToOne(targetEntity = LoginDetails.class, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "customerId")
  private LoginDetails loginDetails;
  
  //Account object list
//  @JsonManagedReference
//  @OneToMany(mappedBy = "customer")
//  private List<AccountDetails> accounts;
  
  @OneToMany(targetEntity = AccountDetails.class, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "customer_id")
  private List<AccountDetails> accounts;
  
  
//  public LoginDetails getLoginDetails() {
//	  return loginDetails;
//  }
//  public void setLoginDetails(LoginDetails loginDetails) {
//	this.loginDetails = loginDetails;
//  }
  

  public List<AccountDetails> getAccounts() {
	  return accounts;
  }
  public void setAccounts(List<AccountDetails> accounts) {
	  this.accounts = accounts;
  }
  
  //default constructor
  public CustomerDetails() {
	
  }
  
  
  public CustomerDetails(String name, LocalDate dateOfBirth, String address, String city, long phone,
			 List<AccountDetails> accounts) {
		super();
//		this.customerId = customerId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.city = city;
		this.phone = phone;
		//this.loginDetails = loginDetails;
		this.accounts = accounts;
	}


  //Getters setters
  public String getCustomerId() {
	  return customerId;
  }
  public void setCustomerId(String customerId) {
	  this.customerId = customerId;
  }
  public String getName() {
	  return name;
  }
  public void setName(String name) {
	  this.name = name;
  }
  public String getAddress() {
	  return address;
  }
  public void setAddress(String address) {
	  this.address = address;
  }
  public String getCity() {
	  return city;
  }
  public void setCity(String city) {
	  this.city = city;
  }
  public long getPhone() {
	  return phone;
  }	
  public void setPhone(long phone) {
	  this.phone = phone;
  }	
  public LocalDate getDateOfBirth() {
	  return dateOfBirth;
  }
  public void setDateOfBirth(LocalDate dateOfBirth) {
	  this.dateOfBirth = dateOfBirth;
  }
	  
}
