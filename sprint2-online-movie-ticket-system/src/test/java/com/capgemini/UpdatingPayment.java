package com.capgemini;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import com.cap.anurag.entity.Payments;
import com.cap.anurag.exception.InvalidDetailsException;
import com.cap.anurag.service.MovieServiceInterface;

public class UpdatingPayment {


	@Autowired
	private MovieServiceInterface movieservice;
	
	@Test
	public void updatePayment()throws InvalidDetailsException{
		Payments pay=new Payments();
		pay.setAccount_no(1000);
		pay.setBooking_id(83);
		pay.setDate_of_transac("5/6/2020");
		pay.setMoney_collected(0);
		pay.setRefund(400);
		pay.setSeat_type("SILVER");
		pay.setSeats_booked(2);
		String str=movieservice.updatePayment(pay);
		String string="payment details updated successfully!!";
		Assertions.assertEquals(str,string);
		
	}
	
	

}
