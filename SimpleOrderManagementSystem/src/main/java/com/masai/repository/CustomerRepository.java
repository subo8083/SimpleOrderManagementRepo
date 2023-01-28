package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.Customer;


// Here i am Extending the Jpa Repository to use the inbuilt save method provided by Spring Boot


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
