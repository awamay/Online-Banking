package com.abc.onlinebanking.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.abc.onlinebanking.domain.*;
import com.abc.onlinebanking.repository.*;

public class LastFiveTransactionsService {
	@Autowired  
	LastFiveTransactionsRepository lastFiveTransactionsRepository;  
	
	@Autowired  
	AccountRepository accountRepository;  
	
	@Autowired  
	AccountService accountService;  
	
	@Autowired  
	CustomerService customerService;  
	
	public AccountDetails getAccountDetails(String accountNo) {
		AccountDetails account = accountRepository.findById(accountNo).get();  
        return account;
	}

	public List<TransactionDetails> getLastFiveTransactions(String customerId, String accountNo)   
	{  
		List<TransactionDetails> lastFiveTransactions = new ArrayList<TransactionDetails>();  
		CustomerDetails customer = customerService.getCustomerById(customerId);
		
		AccountDetails account = getAccountDetails(accountNo);
		
		List<TransactionDetails> lastFiveTransactionsTemp = account.getTransactions();
		
		return lastFiveTransactionsTemp;
		
//		if(lastFiveTransactionsTemp == null) return lastFiveTransactions;
//		
//		Collections.reverse(lastFiveTransactionsTemp);
//		
//		if(lastFiveTransactionsTemp.size() < 5) return lastFiveTransactionsTemp;
//		
//		for(int i=0; i<lastFiveTransactionsTemp.size() && i<5 ; i++) {
//			lastFiveTransactions.add(lastFiveTransactionsTemp.get(i));
//		}
//		
//		return lastFiveTransactions;
	}  
	
}
