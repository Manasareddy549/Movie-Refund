package com.cap.anurag;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.anurag.dao.PaymentDao;
import com.cap.anurag.entity.Payments;
import com.cap.anurag.service.MovieService;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class Service1ApplicationTests {
		@InjectMocks
		MovieService movieservice;

	@Mock
	PaymentDao payment;
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
//////******updating payment table*****//////
	@Test
	public void updatePayment() {
		Payments pay = new Payments();
		pay.setAccount_no(1000);
		pay.setBooking_id(83);
		pay.setDate_of_transac("5/6/2020");
		pay.setMoney_collected(0);
		pay.setRefund(400);
		pay.setSeat_type("SILVER");
		pay.setSeats_booked(2);
		payment.save(pay);
		Mockito.verify(payment, Mockito.times(1)).save(pay);
	}


	}

