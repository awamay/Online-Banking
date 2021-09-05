package com.abc.onlinebanking.domain;

import java.time.LocalDate;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;

import com.abc.onlinebanking.service.*;

public class TransactionInitiator {
	@Autowired  
	AccountService accountService; 
	
	@Autowired  
	TransactionService transactionService; 
	
	@Column(name = "AMOUNT")
	private float transactionAmount;
	
	@Column(name = "FROM_ACCOUNT")
	private String transactionFromAccount;
	
//	@Column(name = "TRANSACTION_TYPE")
//	private String transactionType;

	@Column(name = "TO_ACCOUNT")
	private String transactionToAccount; 
	
	public TransactionInitiator() {
		
	}

	public TransactionInitiator(float transactionAmount, String transactionFromAccount, //String transactionType,
			String transactionToAccount) {
		super();
		this.transactionAmount = transactionAmount;
		this.transactionFromAccount = transactionFromAccount;
		//this.transactionType = transactionType;
		this.transactionToAccount = transactionToAccount;
	}

	public float getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionFromAccount() {
		return transactionFromAccount;
	}

	public void setTransactionFromAccount(String transactionFromAccount) {
		this.transactionFromAccount = transactionFromAccount;
	}

//	public String getTransactionType() {
//		return transactionType;
//	}
//
//	public void setTransactionType(String transactionType) {
//		this.transactionType = transactionType;
//	}

	public String getTransactionToAccount() {
		return transactionToAccount;
	}

	public void setTransactionToAccount(String transactionToAccount) {
		this.transactionToAccount = transactionToAccount;
	}
	
	
}
