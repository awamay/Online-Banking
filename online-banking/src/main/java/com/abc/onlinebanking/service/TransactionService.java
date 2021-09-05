package com.abc.onlinebanking.service;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;  

import com.abc.onlinebanking.domain.TransactionDetails;
import com.abc.onlinebanking.domain.TransactionInitiator;
import com.abc.onlinebanking.controller.AccountController;
import com.abc.onlinebanking.domain.AccountDetails;
import com.abc.onlinebanking.repository.TransactionRepository;
import com.abc.onlinebanking.repository.AccountRepository;


@Service
public class TransactionService {
	Scanner sc=new Scanner(System.in);  

	@Autowired  
	TransactionRepository transactionRepository;  
	
	@Autowired  
	AccountRepository accountRepository;  
	
	@Autowired  
	AccountService accountService;  
	
	//getting all student records  
	public List<TransactionDetails> getAllTransactions()   
	{  
		List<TransactionDetails> transactions = new ArrayList<TransactionDetails>();  
		transactionRepository.findAll().forEach(transaction -> transactions.add(transaction));  
		return transactions;  
	}  
	
	//getting a specific record  
	public TransactionDetails getTransactionById(long id)   
	{  
		return transactionRepository.findById(id).get();  
	}  
	
	public TransactionDetails saveOrUpdate(TransactionDetails transaction)   
	{  
		transactionRepository.save(transaction);  
		return transaction;
	}  
	
	//deleting a specific record  
	public void delete(long id)   
	{  
		transactionRepository.deleteById(id);  
	}

	public void AddMoneyToAccount(String AccountNumber, float amount){
		AccountDetails account = accountService.getAccountByNumber(AccountNumber);
		float currentBalance = account.getAccountBalance();
		float newBalance = currentBalance + amount;
		account.setAccountBalance(newBalance);
		accountService.saveOrUpdate(account);
	}
	
	public TransactionDetails TransferMoney(TransactionInitiator transactionInitiator) {
        String fromAccountNumber = transactionInitiator.getTransactionFromAccount();
        String toAccountNumber = transactionInitiator.getTransactionToAccount();
        float amount = transactionInitiator.getTransactionAmount();
        
        AccountDetails fromAccount = accountService.getAccountByNumber(fromAccountNumber);
        AccountDetails toAccount = accountService.getAccountByNumber(toAccountNumber);

		if(Float.compare(fromAccount.getAccountBalance(), amount) > 0 ){
			AddMoneyToAccount(fromAccountNumber, -amount);
			AddMoneyToAccount(toAccountNumber, amount);
			TransactionDetails transaction1 = saveOrUpdate(new TransactionDetails(amount, LocalDate.now(), "Withdraw", toAccountNumber, fromAccount));
			TransactionDetails transaction2 = saveOrUpdate(new TransactionDetails(amount, LocalDate.now(), "Deposit", toAccountNumber, toAccount));
			return transaction1;
		}

		return null;
    }
	
}
