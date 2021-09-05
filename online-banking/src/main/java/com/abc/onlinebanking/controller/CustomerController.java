package com.abc.onlinebanking.controller;
import com.abc.onlinebanking.domain.CustomerDetails;
import com.abc.onlinebanking.exceptions.*;
import com.abc.onlinebanking.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
public class CustomerController {


	@Autowired  
	CustomerService customerService;  
	
	//creating a get mapping that retrieves all the students detail from the database   
	@GetMapping("/customer")  
	private List<CustomerDetails> getAllCustomers()   
	{  
		return customerService.getAllCustomers();  
	}  
	
	//creating a get mapping that retrieves the detail of a specific student  
	@GetMapping("/customer/{id}")  
	private CustomerDetails getCustomer(@PathVariable("id") String id) throws ContentNotFoundException
	{
		CustomerDetails customer = customerService.getCustomerById(id);
		try {
			if(customer == null)
					throw new ContentNotFoundException("Customer not found");

		}
		catch (ContentNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		return customer;
	}  
	
	//creating a delete mapping that deletes a specific student  
	@DeleteMapping("/customer/{id}")  
	private void deleteCustomer(@PathVariable("id") String id)   
	{  
		customerService.delete(id);  
	}  
	
	//creating post mapping that post the student detail in the database  
	@PostMapping("/customer")  
	private String saveCustomer(@RequestBody CustomerDetails customer)   
	{  
		customerService.saveOrUpdate(customer);  
		return customer.getCustomerId();  
	}  

}
