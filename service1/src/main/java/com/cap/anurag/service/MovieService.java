package com.cap.anurag.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.anurag.dao.PaymentDao;
import com.cap.anurag.entity.Payments;
import com.cap.anurag.exception.InvalidDetailsException;
@Service
@Transactional
public class MovieService implements MovieServiceInterface  {

	@Autowired 
	private PaymentDao payment;

	 //Refund details
	@Override
	public Payments refund(int accountno, int bookingid){
	return payment.refund(accountno, bookingid);
	}

	//Updating payment table
	@Override
	public String updatePayment(Payments pay) throws InvalidDetailsException{
		boolean bool = payment.existsById(pay.getBooking_id());
		if(bool == true) {
			payment.save(pay);
			return "payment details updated successfully!!";
		}
		else {
			throw new InvalidDetailsException("sorry,payment details not updated!!");
			//return "sorry,payment details not updated!!";
		}
	}

	}