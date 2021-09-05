package com.abc.onlinebanking.service;
import com.abc.onlinebanking.repository.*;
import com.abc.onlinebanking.repository.CustomerRepository;
import com.abc.onlinebanking.domain.AccountDetails;
import com.abc.onlinebanking.domain.CustomerDetails;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
	@Autowired  
	CustomerRepository customerRepository;  
	
	@Autowired  
	AccountService accountService;  
	
	//getting all student records  
	public List<CustomerDetails> getAllCustomers()   
	{  
		List<CustomerDetails> customers = new ArrayList<CustomerDetails>();  
		customerRepository.findAll().forEach(customer -> customers.add(customer));  
		return customers;  
	}  
	
	//getting a specific record  
	public CustomerDetails getCustomerById(String id)   
	{  
		return customerRepository.findById(id).get();  
	}  
	
	public void saveOrUpdate(CustomerDetails customer)   
	{  
		//customerRepository.save(customer);  
		CustomerDetails cust = new CustomerDetails();
		cust.setDateOfBirth(customer.getDateOfBirth());
		cust.setAddress(customer.getAddress());
		cust.setAccounts(customer.getAccounts());
		cust.setCity(customer.getCity());
		cust.setName(customer.getName());
		cust.setPhone(customer.getPhone());
		
		customerRepository.save(cust);
	}  
	
	public void deleteAllAccounts(String id) {
		CustomerDetails customer = getCustomerById(id);
		List<AccountDetails> accounts = customer.getAccounts();
		for(AccountDetails account : accounts) {
			String accountNo = account.getAccountNumber();
			accountService.delete(accountNo);  
		}
	}
	
	//deleting a specific record  
	public void delete(String id)   
	{
		customerRepository.deleteById(id);  
	}  
	
	

	
}
