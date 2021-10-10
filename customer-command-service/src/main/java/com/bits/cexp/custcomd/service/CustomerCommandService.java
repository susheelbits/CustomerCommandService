package com.bits.cexp.custcomd.service;

import com.bits.cexp.custcomd.model.Customer;

/**
 * Interface for Customer Command Service
 * 
 * It exposes methods for Create, Update, Delete
 *
 */
public interface CustomerCommandService {

	 public Customer saveCustomer(Customer customer);
	 
	 Customer updateCustomer(Customer customer, long id);
	 
	 void deleteCustomer(long id);
	 
}
