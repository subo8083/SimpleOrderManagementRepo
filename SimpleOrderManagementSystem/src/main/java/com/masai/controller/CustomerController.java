package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Customer;
import com.masai.exceptions.CustomerException;
import com.masai.exceptions.OrdersException;
import com.masai.service.CustomerService;
import com.masai.service.OrderService;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cService;
	
	@Autowired
	private OrderService oService;
	
	
	
	
	@PostMapping("/addcustomer")
	public ResponseEntity<Customer>addCustomerHandler(@RequestBody Customer c){
		
		return new ResponseEntity<Customer>(cService.addCustomer(c),HttpStatus.CREATED);
		
	}
	
	
	
	
	@PostMapping("/associate/customers/orders")
	public ResponseEntity<Customer>associatingCustomerAndOrdersHandler(@RequestParam Integer customerId, @RequestParam Integer orderId) throws OrdersException, CustomerException{
		
		
		return new ResponseEntity<Customer>(cService.associateCustomersAndOrders(customerId, orderId),HttpStatus.OK);
		
	}
}
