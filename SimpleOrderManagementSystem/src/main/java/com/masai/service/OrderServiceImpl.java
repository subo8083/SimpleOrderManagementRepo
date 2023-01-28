package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Orders;
import com.masai.repository.OrdersRepository;


@Service
public class OrderServiceImpl implements OrderService {
	
	
	@Autowired
	private OrdersRepository oRepo;

	
	//Adding of orders with the help of JpaRepo.
	
	
	@Override
	public Orders addOrders(Orders order) {
		
		Orders orders=oRepo.save(order);
		return orders;
		
		
	}
	
	

}
