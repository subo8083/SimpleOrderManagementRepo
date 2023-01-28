package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails>CustomerExceptionHandler(CustomerException ce, WebRequest req){
		
		MyErrorDetails md = new MyErrorDetails(LocalDateTime.now(), ce.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(md,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(OrdersException.class)
	public ResponseEntity<MyErrorDetails>OrdersExceptionHandler(OrdersException oe, WebRequest req){
		
		MyErrorDetails md=new MyErrorDetails(LocalDateTime.now(),oe.getMessage(),req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(md,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails>myExceptionHandler(Exception e, WebRequest req)
	{
		MyErrorDetails md=new MyErrorDetails(LocalDateTime.now(),e.getMessage(),req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(md,HttpStatus.BAD_REQUEST);
		
		
		
		
	}

}
