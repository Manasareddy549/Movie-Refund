package com.capgemini;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import com.cap.anurag.entity.Refund;
import com.cap.anurag.exception.InvalidDetailsException;
import com.cap.anurag.service.MovieServiceInterface;

public class CreateRefund {

	@Autowired
	private MovieServiceInterface movieservice;
	@Test
	public void refundDetails() throws InvalidDetailsException
	{
		Refund refund=new Refund();
		refund.setAccount_no(1000);
		refund.setBooking_id(85);
		refund.setSno(1);
		refund.setMoney_refunded(400);
		refund.setDate_of_refund("5/8/2020");
		String ref=movieservice.refundDetails(refund);
		Assertions.assertEquals(refund.toString(),ref.toString());
		
	}

}














