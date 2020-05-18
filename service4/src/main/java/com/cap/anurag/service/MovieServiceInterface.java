package com.cap.anurag.service;


import com.cap.anurag.entity.Customer;
import com.cap.anurag.exception.InvalidDetailsException;

public interface MovieServiceInterface {

	String updateCustomer(Customer cus) throws InvalidDetailsException;
	
}
