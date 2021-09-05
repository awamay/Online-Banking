package com.abc.onlinebanking.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public class AccountStatement {
	
	
	//initialize consumer object by calling constructor
	CustomerDetails cust1 = new CustomerDetails("jake", LocalDate.now(),"erfd","erfd",(long)23454,null);
	CustomerDetails cust2 = new CustomerDetails("amy", LocalDate.now(),"rang","erdrefd",(long)4221,null);
	
	List<AccountDetails> accounts = new ArrayList<AccountDetails>();
	
	AccountDetails acc1 = new AccountDetails((float)1234.0, LocalDate.now(), cust1, null);
	AccountDetails acc2 = new AccountDetails((float)123434.0, LocalDate.now(), cust1, null);

	
	
	//TransactionInitiator transactionIn = new TransactionInitiator(230, acc1.getAccountNumber(), "Deposit", acc2.getAccountNumber());
			
	
    
	
}

