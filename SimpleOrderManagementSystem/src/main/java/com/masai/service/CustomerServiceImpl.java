package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Customer;
import com.masai.entity.Orders;
import com.masai.exceptions.CustomerException;
import com.masai.exceptions.OrdersException;
import com.masai.repository.CustomerRepository;
import com.masai.repository.OrdersRepository;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository cRepo;
	
	@Autowired
	private OrdersRepository orderRepo;

	
	//It will simply add Customer to the database.
	
	
	@Override
	public Customer addCustomer(Customer customer) {
		
		Customer cust=cRepo.save(customer);
		return cust;
		
	}
	
	
	
	
	
	
	//Now we have created orders and customers so we need to figure out which order is made by which customer so for 
	//that we need to associate Customers with Orders. e.g(for customer-1 order 2,3,4 is placed so just by passing
	// orderId's with customer Id we can easily associate that.
	
	public boolean flag=true;
	public boolean flag2=true;

	@Override
	public Customer associateCustomersAndOrders(Integer customerId, Integer OrderId)
			throws OrdersException, CustomerException {
		
		Orders or=orderRepo.findById(OrderId).orElseThrow(()->new OrdersException("Invalid order Id"));
		
		Customer cust=cRepo.findById(customerId).orElseThrow(()->new CustomerException("Invalid customer Id"));
		
		
		
		
		cust.getOrders().add(or);
		or.setCustomer(cust);
		
		
		
		//===============To Check whether the customer is Regular gold or platinum=============================//
		
		
		if(cust.getOrders().size()<10)
		{
			cust.setCustomerType("Regular");
			cRepo.save(cust);
		}
		
		
		else if(cust.getOrders().size()>=10 && cust.getOrders().size()<20)
		{
			cust.setCustomerType("Gold");
			cRepo.save(cust);
		}
		else
		{
			cust.setCustomerType("Platinum");
			cRepo.save(cust);
		}
		
		
		String type=or.getCustomer().getCustomerType();
		
		//====================================================================================================//
		
		
		
		
		
		
		
		
		
											// for discount purpose.
			/*========================================================================================*/
			
		
		
			
			if(type.equals("Gold"))
			{
				
				//For previous 1-9 items discount
				
				for(int i=0;i<9 && flag==true;i++)
				{
					Integer amount=cust.getOrders().get(i).getTotalOrderAmount();
					double dis=amount-amount*0.1;
					cust.getOrders().get(i).setTotalOrderAmount((int)dis);
				}
				flag=false;
				
				// For current item discount
				
				double discount= or.getTotalOrderAmount()-or.getTotalOrderAmount()*0.1;
				or.setTotalOrderAmount((int)discount);
			}
			
			
			else if(type.equals("Platinum"))
			{
				//for previous 10-20 items discount(runs only one time).
				
				for(int i=10;i<19 && flag2==true;i++)
				{
					Integer amount=cust.getOrders().get(i).getTotalOrderAmount();
					double dis=amount-amount*0.2;
					cust.getOrders().get(i).setTotalOrderAmount((int)dis);
				}
				flag2=false;
				
				//for last item discount
			
				double dis=or.getTotalOrderAmount()-or.getTotalOrderAmount()*0.2;
				or.setTotalOrderAmount((int)dis);
			}
			
			
			// =======================================================================================//
		
		
		return cRepo.save(cust);
		
		
	}

	@Override
	public Customer sendMail(Integer id) throws CustomerException {
		
		Customer cust=cRepo.findById(id).orElseThrow(()->new CustomerException("Invalid customer Id"));
		if(cust.getOrders().size()==9)
		{
			String email=cust.getCustomerEmail();
		}
		System.out.println("Congates! You are approaching to GOLD membership, Just 1 order more!");
		cust.setCustomerType("One more order To GOLD!");
		return cRepo.save(cust);
	}
	
	

}
