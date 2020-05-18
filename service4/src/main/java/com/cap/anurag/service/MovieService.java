package com.cap.anurag.service;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.anurag.dao.CustomerDao;
import com.cap.anurag.entity.Customer;
import com.cap.anurag.exception.InvalidDetailsException;
@Service
@Transactional
public class MovieService implements MovieServiceInterface  {


	@Autowired
	private CustomerDao account;

	
		//updating customer balance after refund
		@Override
		public String updateCustomer(Customer cus) throws InvalidDetailsException{
			boolean bool = account.existsById(cus.getAccount_no());
			if(bool){
				account.save(cus);
				return "the customer table was updated successfully..!!";
			}
			
			else
			{
				throw new InvalidDetailsException("sorry, customer table was not updated..!!");
				//return "sorry, customer table was not updated..!!";
			}
		}

}