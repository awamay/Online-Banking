package com.abc.onlinebanking.domain;
import java.time.*;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ACCOUNT")

public class AccountDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACC_NUMBER")
	private String accountNumber;
	
	@Column(name = "ACC_BALANCE")
	private float accountBalance;
	
	@Column(name = "DATE_CREATED")
	private LocalDate dateCreated;
	
	
	//Transactions object list
//	@OneToMany(targetEntity = TransactionDetails.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "ACC_NUMBER", referencedColumnName = "ACC_NUMBER")
//	private List<TransactionDetails> transactions;
	
//	@JsonManagedReference
//	@OneToMany(mappedBy = "accountDetails")
//	private List<TransactionDetails> transactions;

	@OneToMany(targetEntity = TransactionDetails.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "account_no")
	private List<TransactionDetails> transactions;
	
//	@JsonBackReference
//	@ManyToOne
//    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
//	private CustomerDetails customer;

	@JsonIgnore
	@ManyToOne
	private CustomerDetails customer;

	//Constructor
	public AccountDetails() {
		
	}

	public AccountDetails(float accountBalance, LocalDate dateCreated,
			CustomerDetails customer, List<TransactionDetails> transactions) {
		super();
		this.accountBalance = accountBalance;
		this.dateCreated = dateCreated;
		this.customer = customer;
		this.transactions = transactions;
	}

	//Setters getters
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public float getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	public List<TransactionDetails> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<TransactionDetails> transactions) {
		this.transactions = transactions;
	}
	public CustomerDetails getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDetails customer) {
		this.customer = customer;
	}

	
}
