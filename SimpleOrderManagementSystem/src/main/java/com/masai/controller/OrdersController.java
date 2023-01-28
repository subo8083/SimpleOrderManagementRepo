package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Orders;
import com.masai.service.OrderService;


@RestController
public class OrdersController {
	
	@Autowired
	private OrderService oService;
	
	@PostMapping("/addorders")
	public ResponseEntity<Orders>addOrdersHandler(@RequestBody Orders order){
		
		return new ResponseEntity<Orders>(oService.addOrders(order),HttpStatus.CREATED);
		
	}

}
