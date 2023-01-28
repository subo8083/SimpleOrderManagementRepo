package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.Orders;



// Similarly I am extending JpaRepository for using the inbuilt methods. 


@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
	
	

}
