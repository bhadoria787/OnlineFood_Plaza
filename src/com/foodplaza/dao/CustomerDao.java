package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.Customer;

public interface CustomerDao {
	int addCustomer(Customer cust);

	int updateCustomer(Customer cust);

	int deleteCustomer(String custEmailId);

	Customer searchCustomerByEmailId(String custEmailId);

	List<Customer> getAllCustomer();
	// List<Customer> searchCustomerById(int custId);

}
