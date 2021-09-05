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

import com.abc.onlinebanking.domain.AccountDetails;
import com.abc.onlinebanking.domain.TransactionDetails;
import com.abc.onlinebanking.service.AccountService;
import com.abc.onlinebanking.service.TransactionService;

@RestController
public class AccountController {

	@Autowired  
	AccountService accountService;  
	
	//creating a get mapping that retrieves all the students detail from the database   
	@GetMapping("/account")  
	private List<AccountDetails> getAllAccounts()   
	{  
		return accountService.getAllAccounts();  
	}  
	
	//creating a get mapping that retrieves the detail of a specific student  
	@GetMapping("/account/{id}")  
	private AccountDetails getAccount(@PathVariable("id") String id)   
	{  
		return accountService.getAccountByNumber(id);  
	}  
	
	//creating a delete mapping that deletes a specific student  
	@DeleteMapping("/account/{id}")  
	private void deleteAccount(@PathVariable("id") String id)   
	{  
		accountService.delete(id);  
	}  
	
	//creating post mapping that post the student detail in the database  
	@PostMapping("/account")  
	private String saveAccount(@RequestBody AccountDetails account)   
	{  
		accountService.saveOrUpdate(account);  
		return account.getAccountNumber();  
	}  
	
//	@RequestMapping("/sendmoney")
//    public Response sendMoney(@RequestBody TransactionDetails transactionDetails) {
//        return Response.ok().setPayload(
//        		TransactionService.sendMoney(TransactionDetails)
//        );
//    }
//    @RequestMapping("/statement")
//    public Response getStatement(@RequestBody AccountStatementRequest accountStatementRequest){
//        return Response.ok().setPayload(
//                accountService.getStatement(accountStatementRequest.getAccountNumber())
//        );
//
//    }
}
