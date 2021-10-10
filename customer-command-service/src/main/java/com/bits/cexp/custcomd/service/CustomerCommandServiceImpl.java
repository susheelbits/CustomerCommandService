package com.bits.cexp.custcomd.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bits.cexp.custcomd.ResourceNotFoundException;
import com.bits.cexp.custcomd.model.Customer;
import com.bits.cexp.custcomd.repository.CustomerCommandRepository;

/**
 * Implementation for Interface of Customer Command Service
 * 
 * It implements methods for Create, Update, Delete
 *
 */
@Service
public class CustomerCommandServiceImpl implements CustomerCommandService {

	private CustomerCommandRepository customerCommandRepository;

	public CustomerCommandServiceImpl(CustomerCommandRepository customerCommandRepository) {
		super();
		this.customerCommandRepository = customerCommandRepository;
	}	

	/**
	 * 1. Add the Customer
	 * 2. Send message to Query Database to add the customer
	 * 
	 */	
	public Customer saveCustomer(Customer customer) {
    	Customer cust = customerCommandRepository.save(customer);
    	
 
		//Send message to Customer Query Database to Add it
    	
		//String baseUrl = "http://localhost:8080/customer-rabbitmq/producer?firstName=emp1&customerId=1"; 
    	//RestTemplate restTemplate = new RestTemplate(); String result = restTemplate.getForObject(baseUrl, String.class);    	
    	return cust;
	}	

	/**
	 * 1. Update the Customer
	 * 2. Send message to Query Database to update the customer
	 * 
	 */
	@Override
	public Customer updateCustomer(Customer customer, long id) {
		
		// Check if customer with given id is exist in DB or not
		Customer existingCustomer = customerCommandRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Customer", "Id", id)); 
		
		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		existingCustomer.setEmail(customer.getEmail());
		
		// save existing customer to DB
		customerCommandRepository.save(existingCustomer);
		
		String fname = customer.getFirstName();
		System.out.println("updateCustomer  = " );
		//Send message to Customer Query Database
		// Can be refactored to be read from Configuration file
		String baseUrl = "http://localhost:8081/customer-rabbitmq/producer?firstName=fname&customerId=1"; 
		RestTemplate  restTemplate = new RestTemplate(); 
		String result = restTemplate.getForObject(baseUrl, String.class);
				
		return existingCustomer;
	}	 

	/**
	 * 1. Delete the Customer
	 * 2. Send message to Query Database to delete the customer
	 * 
	 */	
	@Override
	public void deleteCustomer(long id) {
		
		// check whether a customerRepository exist in a DB or not
		customerCommandRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Customer", "Id", id));
		customerCommandRepository.deleteById(id);
		
		//Send message to Query Database to delete it
		
		//String baseUrl = "http://localhost:8080/customer-rabbitmq/producer?firstName=emp1&customerId={id}"; 
		// RestTemplate restTemplate = new RestTemplate(); String result = restTemplate.getForObject(baseUrl, String.class);		
	}	
	
}
