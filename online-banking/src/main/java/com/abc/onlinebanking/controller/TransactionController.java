package com.abc.onlinebanking.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.onlinebanking.domain.TransactionDetails;
import com.abc.onlinebanking.domain.TransactionInitiator;
import com.abc.onlinebanking.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired  
	TransactionService transactionService;  
	
	//creating a get mapping that retrieves all the students detail from the database   
	@GetMapping("/transaction")  
	private List<TransactionDetails> getAllTransactions()   
	{  
		return transactionService.getAllTransactions();  
	}  
	
	//creating a get mapping that retrieves the detail of a specific student  
	@GetMapping("/transaction/{id}")  
	private TransactionDetails getTransaction(@PathVariable("id") long id)   
	{  
		return transactionService.getTransactionById(id);  
	}  
	
	//creating a delete mapping that deletes a specific student  
	@DeleteMapping("/transaction/{id}")  
	private void deleteTransaction(@PathVariable("id") long id)   
	{  
		transactionService.delete(id);  
	}  
	
	//creating post mapping that post the student detail in the database  
	@PostMapping("/transaction")  
	private long saveTransaction(@RequestBody TransactionDetails transaction)   
	{  
		transactionService.saveOrUpdate(transaction);  
		return transaction.getTransactionId();  
	}  
	
	@PostMapping("/transaction/create")  
	private long getTransactionFromTransfer(@RequestBody TransactionInitiator transactionInitiator)
	{  
		TransactionDetails transaction = transactionService.TransferMoney(transactionInitiator);  
		saveTransaction(transaction);
		return transaction.getTransactionId();  
	}  
	
	
}
