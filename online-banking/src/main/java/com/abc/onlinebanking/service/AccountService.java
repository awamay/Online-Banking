package com.abc.onlinebanking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.onlinebanking.domain.AccountDetails;
import com.abc.onlinebanking.domain.TransactionDetails;
import com.abc.onlinebanking.repository.AccountRepository;
import com.abc.onlinebanking.repository.TransactionRepository;


@Service
public class AccountService {

	@Autowired  
	AccountRepository accountRepository;  
	
	@Autowired  
	TransactionService transactionService;  
	
	//getting all student records  
	public List<AccountDetails> getAllAccounts()   
	{  
		List<AccountDetails> accounts = new ArrayList<AccountDetails>();  
		accountRepository.findAll().forEach(account -> accounts.add(account));  
		return accounts;  
	}  
	
	//getting a specific record  
	public AccountDetails getAccountByNumber(String accountNumber)   
	{  
		AccountDetails account = accountRepository.findById(accountNumber).get();  
        return account;
	}  
	
	public void saveOrUpdate(AccountDetails account)   
	{  
		accountRepository.save(account);  
//        return accountRepository.findByAccountNumberEquals(account.getAccountNumber());
	}  
	
	//deleting a specific record 
	public void DeleteAllTransactions(String id) {
		AccountDetails account = getAccountByNumber(id);
		List<TransactionDetails> transactions = account.getTransactions();
		for(TransactionDetails transaction : transactions) {
			long transactionId = transaction.getTransactionId();
			transactionService.delete(transactionId);
		}
	}
	
	public void delete(String id)   
	{
		accountRepository.deleteById(id);
	}  
	
	
	
}
