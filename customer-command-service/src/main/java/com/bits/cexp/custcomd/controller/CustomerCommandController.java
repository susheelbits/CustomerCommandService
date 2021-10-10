package com.bits.cexp.custcomd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bits.cexp.custcomd.model.Customer;
import com.bits.cexp.custcomd.service.CustomerCommandService;

@RestController
@RequestMapping("/api/customers")
public class CustomerCommandController {

	private CustomerCommandService customerCommandService;

	public CustomerCommandController(CustomerCommandService customerCommandService) {
		super();
		this.customerCommandService = customerCommandService;
	}	

	// build create Customer REST API
	@PostMapping()
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerCommandService.saveCustomer(customer), HttpStatus.CREATED);
	}	

	// build update customer REST API
	// http://localhost:8080/api/customers/{id}
	@PutMapping("{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id
												  ,@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerCommandService.updateCustomer(customer, id), HttpStatus.OK);
	}	

	// build delete customer REST API
	// http://localhost:8080/api/customers/{id}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id){
		
		// delete employee from DB
		customerCommandService.deleteCustomer(id);
		
		return new ResponseEntity<String>("Customer deleted successfully!.", HttpStatus.OK);
	}	
}
