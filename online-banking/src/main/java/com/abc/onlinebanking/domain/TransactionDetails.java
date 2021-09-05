package com.abc.onlinebanking.domain;
import java.time.*;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TRANSACTION")

public class TransactionDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactionId;
	
	@Column(name = "AMOUNT")
	private float transactionAmount;
	
	@Column(name = "DATE_OF_TRANSACTION")
	private LocalDate transactionDate;
	
	@Column(name = "TRANSACTION_TYPE")
	private String transactionType;
	
	@Column(name = "TO_ACCOUNT")
	private String transactionToAccount; // transfered to which account
	
//	@JsonBackReference
//	@ManyToOne
//    @JoinColumn(name = "ACC_NUMBER", nullable = false)
//    private AccountDetails accountDetails;

	@JsonIgnore
	@ManyToOne
	private AccountDetails accountDetails;
	
	//constructor
	public TransactionDetails() {
		
	}
	
	public TransactionDetails(float transactionAmount, LocalDate transactionDate,
			String transactionType, String transactionToAccount, AccountDetails accountDetails) {
		super();
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.transactionToAccount = transactionToAccount;
		this.accountDetails = accountDetails;
	}

	//getter and setter methods
	public long getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	
	public float getTransactionAmount() {
		return transactionAmount;
	} 
	
	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public String getTransactionType() {
		return transactionType;
	}
	
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	public String getTransactionToAccount() {
		return transactionToAccount;
	}
	
	public void setTransactionToAccount(String transactionToAccount) {
		this.transactionToAccount = transactionToAccount;
	}
		
	public AccountDetails getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(AccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}
	
	
}
