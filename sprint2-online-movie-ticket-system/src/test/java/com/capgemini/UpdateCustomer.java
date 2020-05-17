package com.capgemini;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import com.cap.anurag.entity.Customer;
import com.cap.anurag.exception.InvalidDetailsException;
import com.cap.anurag.service.MovieServiceInterface;

public class UpdateCustomer {

	@Autowired
	private MovieServiceInterface movieservice;
	@Test
	void updateCustomer() throws InvalidDetailsException
	{
		Customer cus=new Customer();
		cus.setAccount_no(1000);
		cus.setName("manasa reddy");
		cus.setUsername("manasa");
		cus.setPassword("manasa123");
		cus.setCurrent_balance(5500);
		String s=movieservice.updateCustomer(cus);
		String s1="the customer table was updated successfully..!!";
		Assertions.assertEquals(s1,s);
	}
	
}
