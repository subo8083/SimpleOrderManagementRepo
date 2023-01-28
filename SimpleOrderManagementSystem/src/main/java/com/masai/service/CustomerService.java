package com.masai.service;

import com.masai.entity.Customer;
import com.masai.exceptions.CustomerException;
import com.masai.exceptions.OrdersException;


// By the help of this Interface we can make our code loosely coupled.


public interface CustomerService {
	
	
	public Customer addCustomer(Customer customer);
	
	public Customer associateCustomersAndOrders(Integer customerId, Integer OrderId) throws OrdersException,CustomerException;
	
	public Customer sendMail(Integer id)throws CustomerException;

}
