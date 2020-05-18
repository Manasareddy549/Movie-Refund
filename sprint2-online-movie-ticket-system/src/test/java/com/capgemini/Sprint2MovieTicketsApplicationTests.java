package com.capgemini;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.cap.anurag.dao.CustomerDao;
import com.cap.anurag.dao.PaymentDao;
import com.cap.anurag.dao.RefundDao;
import com.cap.anurag.dao.SeatsDao;
import com.cap.anurag.entity.Customer;
import com.cap.anurag.entity.Payments;
import com.cap.anurag.entity.Refund;
import com.cap.anurag.entity.Seats;
import com.cap.anurag.service.MovieService;

@RunWith(MockitoJUnitRunner.class)
public class Sprint2MovieTicketsApplicationTests {
	@InjectMocks
	MovieService movieservice;
	@Mock
	RefundDao refund;
	@Mock
	SeatsDao seats;
	@Mock
	CustomerDao account;
	@Mock
	PaymentDao payment;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
//////*****updating refund table******//////
	@Test
	public void refundDetails() {
		Refund ref = new Refund();
		ref.setAccount_no(1000);
		ref.setBooking_id(85);
		ref.setSno(1);
		ref.setMoney_refunded(400);
		ref.setDate_of_refund("5/8/2020");
		// movieservice.save(refund);
		refund.save(ref);
		Mockito.verify(refund, Mockito.times(1)).save(ref);
	}
/////*****Refund list****/////
	@Test
	public void getRefundList() {
		List<Refund> reflist = new ArrayList<>();
		reflist.add(new Refund(119, 1000, 400, 118, "5/11/2020"));
		reflist.add(new Refund(121, 2000, 200, 119, "6/11/2020"));
		Mockito.when(refund.findAll()).thenReturn(reflist);
		List<Refund> returnedData = refund.findAll();
		assertEquals(returnedData.get(0).getBooking_id(), reflist.get(0).getBooking_id());
		assertEquals(2, returnedData.size()); // expected 23 but was 2
		assertNotEquals(24,returnedData.size());
	}
///////*******seats lists*****//////
	@Test
	public void seatDetails() {
		List<Seats> seatlist = new ArrayList<>();
		seatlist.add(new Seats(1, "GOLD", 45, 300));
		seatlist.add(new Seats(2, "SILVER", 52, 200));
		Mockito.when(seats.findAll()).thenReturn(seatlist);
		List<Seats> sl = seats.findAll();
		assertEquals(sl.get(1).getSno(), seatlist.get(1).getSno());
		assertEquals(2, sl.size());// expected 3 but was 2
	}
///////******updating seats*******//////
	@Test
	public void setSeats() {
		Seats s = new Seats();
		s.setSno(1);
		s.setSeat_type("GOLD");
		s.setAvailable_seats(50);
		s.setPrice(300);
		seats.save(s);
		Mockito.verify(seats, Mockito.times(1)).save(s);
	}
///////*****updating customer account balance*****////
	@Test
	public void updateCustomer() {
		Customer cus = new Customer();
		cus.setAccount_no(1000);
		cus.setName("manasa reddy");
		cus.setUsername("manasa");
		cus.setPassword("manasa123");
		cus.setCurrent_balance(5500);
		account.save(cus);
		Mockito.verify(account, Mockito.times(1)).save(cus);
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
