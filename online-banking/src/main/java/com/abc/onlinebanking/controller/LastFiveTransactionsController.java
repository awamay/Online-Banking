package com.abc.onlinebanking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.abc.onlinebanking.domain.*;
import com.abc.onlinebanking.repository.*;
import com.abc.onlinebanking.service.*;

public class LastFiveTransactionsController {
	
	@Autowired  
	LastFiveTransactionsService lastFiveTransactionsService;  

	
	//creating a get mapping that retrieves the detail of a specific customer
	
	@GetMapping("/transactionhistory/{accountNo}")  
	private AccountDetails getAccountDetails(@PathVariable("accountNo") String accountNo)   
	{  
		return lastFiveTransactionsService.getAccountDetails(accountNo);  
	}  
	
	@GetMapping("/transactionhistory/{customerId}/{accountNo}")  
	private List<TransactionDetails> lastFiveTransactions(@PathVariable String customerId, @PathVariable String accountNo)   
	{  
		return lastFiveTransactionsService.getLastFiveTransactions(customerId, accountNo);  
	}  
	
	//ResponseEntity<TransactionDetails>
		
}
